package br.com.api.rickandmorty.dto;

public class LocationDto {
	
	private Integer id;
	private String name;
	private String dimension;
	private String residents;
	private String url;
	private String created;
	
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
	public String getResidents() {
		return residents;
	}
	public void setResidents(String residents) {
		this.residents = residents;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	
}
