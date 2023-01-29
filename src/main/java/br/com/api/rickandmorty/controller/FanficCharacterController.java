package br.com.api.rickandmorty.controller;

import java.net.URI;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.api.rickandmorty.dto.FanficCharacterDto;
import br.com.api.rickandmorty.service.FanficCharacterService;

@RestController
@RequestMapping("characters")
public class FanficCharacterController {

	@Autowired
	private FanficCharacterService service;
	
	@GetMapping
	public Page<FanficCharacterDto> ListAll(@PageableDefault(size = 10) Pageable pagination){
		return service.findAll(pagination);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FanficCharacterDto> findById(@PathVariable @NotNull Integer id) {
		FanficCharacterDto fanficCharacterDto = service.findById(id);
		return ResponseEntity.ok(fanficCharacterDto);
	}
	
	@PostMapping
	public ResponseEntity<FanficCharacterDto> create(@RequestBody @Valid FanficCharacterDto characterDto, UriComponentsBuilder uriBuilder){
		FanficCharacterDto fanficCharacterDto = service.create(characterDto);
		fanficCharacterDto = service.putUrlAndUpdateResidents(fanficCharacterDto);
		URI adress = uriBuilder.path("characters/{id}").buildAndExpand(fanficCharacterDto.getId()).toUri();
		return ResponseEntity.created(adress).body(fanficCharacterDto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<FanficCharacterDto> update(@PathVariable @NotNull Integer id, @RequestBody @Valid FanficCharacterDto characterDto){
		FanficCharacterDto fanficCharacterDto = service.update(id, characterDto);
		return ResponseEntity.ok(fanficCharacterDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<FanficCharacterDto> delete(@PathVariable @NotNull Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
}
