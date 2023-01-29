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

import br.com.api.rickandmorty.dto.LocationDto;
import br.com.api.rickandmorty.service.LocationService;

@RestController
@RequestMapping("/locations")
public class LocationController{
	
	@Autowired
	private LocationService service;
	
	@GetMapping
	public Page<LocationDto> findAll(@PageableDefault(size = 10) Pageable pagination){
		return service.findAll(pagination);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<LocationDto> findById(@PathVariable @NotNull Integer id) {
		LocationDto locationDto = service.findById(id);
		return ResponseEntity.ok(locationDto);
	}
	
	@PostMapping
	public ResponseEntity<LocationDto> create(@RequestBody @Valid LocationDto locationDto, UriComponentsBuilder uriBuilder){
		LocationDto locationDtoCreated = service.create(locationDto);
		locationDtoCreated = service.putUrl(locationDtoCreated);
		URI adress = uriBuilder.path("locations/{id}").buildAndExpand(locationDtoCreated.getId()).toUri();
		return ResponseEntity.created(adress).body(locationDtoCreated);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<LocationDto> update(@PathVariable @NotNull Integer id, @RequestBody @Valid LocationDto locationDto){
		LocationDto locationDtoUpdate = service.update(id, locationDto);
		return ResponseEntity.ok(locationDtoUpdate);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<LocationDto> delete(@PathVariable @NotNull Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
