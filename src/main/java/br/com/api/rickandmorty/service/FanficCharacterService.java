package br.com.api.rickandmorty.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.api.rickandmorty.dto.FanficCharacterDto;
import br.com.api.rickandmorty.dto.LocationDataDto;
import br.com.api.rickandmorty.model.FanficCharacter;
import br.com.api.rickandmorty.model.Location;
import br.com.api.rickandmorty.repository.FanficCharacterRepository;

@Service
public class FanficCharacterService {

	@Autowired
	private FanficCharacterRepository repository;

	@Autowired
	private LocationService locationService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Value("${mainPath}") 
	private String path;
	
	public FanficCharacterService(LocationService locationService, ModelMapper modelMapper) {
		this.locationService = locationService;
		this.modelMapper = modelMapper;
	}
	
	List<FanficCharacterDto> charactersDto = new ArrayList<>();

	public Page<FanficCharacterDto> findAll(Pageable pagination) {
		return repository
				.findAll(pagination)
				.map(p -> toCharacterDto(p));
	}

	public FanficCharacterDto findById(Integer id) {
		FanficCharacter character = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		FanficCharacterDto characterDto = toCharacterDto(character);
		return characterDto;
	}
	
	public FanficCharacterDto create(FanficCharacterDto characterDto) {
		FanficCharacter character = modelMapper.map(characterDto, FanficCharacter.class);
		character = findAndSetLocations(locationService, character, characterDto);
		LocalDateTime date = LocalDateTime.now();
		character.setCreated(date.toString());		
		repository.save(character);
		return toCharacterDto(character);
	}
	
	public FanficCharacterDto update(Integer id, FanficCharacterDto characterDto) {
		FanficCharacter character = modelMapper.map(characterDto, FanficCharacter.class);
		character.setId(id);
		character = findAndSetLocations(locationService, character, characterDto);
		character.setUrl(path.concat("characters/").concat(id.toString()));
		character = repository.save(character);
		return toCharacterDto(character);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}


	/**
	 * Maps CharacterDto to create Character's Json.
	 * @param character
	 * @return CharacterDto
	 */
	public FanficCharacterDto toCharacterDto(FanficCharacter character) {
		FanficCharacterDto characterDto = modelMapper.map(character, FanficCharacterDto.class);
		LocationDataDto origin = modelMapper.map(characterDto.getOriginLocation(), LocationDataDto.class);
		LocationDataDto lastKnow = modelMapper.map(characterDto.getLastKnowLocation(), LocationDataDto.class);
		characterDto.setOriginLocation(origin);
		characterDto.setLastKnowLocation(lastKnow);
		return characterDto;
	}
	
	
	/**
	 * Get origin location id and last know location id to set location foreign keys in the FanficCharacter
	 * @param service
	 * @param character
	 * @param characterDto
	 * @return FanficCharacter
	 */
	public FanficCharacter findAndSetLocations(LocationService locationService, FanficCharacter character, FanficCharacterDto characterDto) {
		Location originLocationFinded = locationService.findByName(characterDto.getOriginLocation().getName());
		Location lastKnowLocationFinded = locationService.findByName(characterDto.getLastKnowLocation().getName());
		character.setOriginLocation(originLocationFinded);
		character.setLastKnowLocation(lastKnowLocationFinded);
		return character;
	}
	
	/**
	 * After character created, this method create a url with the generate id and update the character.
	 * The locationService input the last know location in the list of residents.
	 * @param fanficCharacterDto
	 * @return CharacterDto
	 */	
	public FanficCharacterDto putUrlAndUpdateResidents(FanficCharacterDto fanficCharacterDto) {
		FanficCharacter character = modelMapper.map(fanficCharacterDto, FanficCharacter.class);
		character = findAndSetLocations(locationService, character, fanficCharacterDto);
		character.setUrl(path.concat("characters/").concat(character.getId().toString()));
		repository.save(character);
		locationService.updateResidents(character.getLastKnowLocation(), character.getUrl());
		return toCharacterDto(character);
	}

}
