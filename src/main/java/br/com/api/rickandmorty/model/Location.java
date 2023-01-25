package br.com.api.rickandmorty.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@MappedSuperclass
public class Location {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Size(max=100)
	private String name;
	
	@NotBlank
	@Size(max=100)
	private String dimension;
	
	private List<String> residents = new ArrayList<>();
	
	@NotBlank
	@Size(max=100)
	private String url;
	
	@NotBlank
	@Size(max=100)
	private String create;
		
	public Location() {
	}

	public Location(Integer id, String name, String dimension, List<String> residents, String url, String create) {
		this.id = id;
		this.name = name;
		this.dimension = dimension;
		this.residents = residents;
		this.url = url;
		this.create = create;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public List<String> getResidents() {
		return residents;
	}

	public void setResidents(List<String> residents) {
		this.residents = residents;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCreate() {
		return create;
	}

	public void setCreate(String create) {
		this.create = create;
	}
	
}
