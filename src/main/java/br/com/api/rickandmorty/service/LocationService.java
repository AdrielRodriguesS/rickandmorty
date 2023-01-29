package br.com.api.rickandmorty.service;

import java.time.LocalDateTime;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.api.rickandmorty.dto.FanficCharacterDto;
import br.com.api.rickandmorty.dto.LocationDto;
import br.com.api.rickandmorty.model.FanficCharacter;
import br.com.api.rickandmorty.model.Location;
import br.com.api.rickandmorty.repository.LocationRepository;

@Service
public class LocationService {
	
	@Autowired
	private LocationRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Value("${mainPath}") 
	private String path;
	
	public Page<LocationDto> findAll(Pageable pagination){
		return repository
				.findAll(pagination)
				.map(p -> modelMapper.map(p, LocationDto.class));
	}
	
	public Location findByName(String name) {		
		return repository.findByName(name);
		
	}
	
	public LocationDto findById(Integer id) {
		Location location = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		return modelMapper.map(location, LocationDto.class);
	}

	public LocationDto create(LocationDto locationDto) {
		Location location = modelMapper.map(locationDto, Location.class);
		LocalDateTime date = LocalDateTime.now();
		location.setCreated(date.toString());
		repository.save(location);
		return modelMapper.map(location, LocationDto.class);
	}
	
	public LocationDto update(Integer id, LocationDto locationDto) {
		Location location = modelMapper.map(locationDto, Location.class);
		location.setId(id);
		location.setUrl(path.concat("locations/").concat(id.toString()));
		location = repository.save(location);
		return modelMapper.map(location, LocationDto.class);
	}
	
	public Location updateResidents(Location location, String url) {
		location.setResidents(location.getResidents() + ", " + url);
		return repository.save(location);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	/**
	 * Insert character's url in the field residents when a character is created
	 * @param locationDto
	 * @return LocationDto
	 */
	public LocationDto putUrl(LocationDto locationDto) {
		Location location = modelMapper.map(locationDto, Location.class);
		location.setUrl(path.concat("locations/").concat(location.getId().toString()));
		repository.save(location);
		return modelMapper.map(location, LocationDto.class);
	}
	
}
