package br.com.api.rickandmorty.dto;

public class FanficCharacterDto{
		
	private Integer id;
	private String name;
	private String status;
	private String species;
	private String gender;
	private LocationDataDto originLocation;
	private LocationDataDto lastKnowLocation;
	private String url;
	private String created;

	public FanficCharacterDto() {
	}

	public FanficCharacterDto(String name, String status, String species, String gender,
			LocationDataDto originLocation, LocationDataDto lastKnowLocation) {
		this.name = name;
		this.status = status;
		this.species = species;
		this.gender = gender;
		this.originLocation = originLocation;
		this.lastKnowLocation = lastKnowLocation;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}	
	public LocationDataDto getOriginLocation() {
		return originLocation;
	}	
	public void setOriginLocation(LocationDataDto originLocation) {
		this.originLocation = originLocation;
	}
	
	public LocationDataDto getLastKnowLocation() {
		return lastKnowLocation;
	}
	public void setLastKnowLocation(LocationDataDto lastKnowLocation) {
		this.lastKnowLocation = lastKnowLocation;
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
