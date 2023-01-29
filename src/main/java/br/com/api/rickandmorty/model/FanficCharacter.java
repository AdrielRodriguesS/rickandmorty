package br.com.api.rickandmorty.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="characters")
public class FanficCharacter {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Size(max=100)
	private String name;
	
	@NotBlank
	@Size(max=20)
	private String status;
	
	@NotBlank
	@Size(max=50)
	private String species;
	
	@NotBlank
	@Size(max=20)
	private String gender;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "origin_location_id")	
	private Location originLocation;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "last_location_id")	
	private Location lastKnowLocation;
	
	private String url;
	
	@NotBlank
	private String created;

	public FanficCharacter() {
	}

	public FanficCharacter(Integer id, @NotBlank @Size(max = 100) String name, @NotBlank @Size(max = 20) String status,
			@NotBlank @Size(max = 50) String species, @NotBlank @Size(max = 20) String gender, Location originLocation,
			Location lastKnowLocation, String url, @NotBlank String created) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.species = species;
		this.gender = gender;
		this.originLocation = originLocation;
		this.lastKnowLocation = lastKnowLocation;
		this.url = url;
		this.created = created;
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

	public Location getOriginLocation() {
		return originLocation;
	}
	
	public void setOriginLocation(Location originLocation) {
		this.originLocation = originLocation;
	}
	
	public Location getLastKnowLocation() {
		return lastKnowLocation;
	}

	public void setLastKnowLocation(Location lastKnowLocation) {
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

	@Override
	public String toString() {
		return "FanficCharacter [id=" + id + ", name=" + name + ", status=" + status + ", species=" + species
				+ ", gender=" + gender + ", originLocation=" + originLocation + ", lastKnowLocation=" + lastKnowLocation
				+ ", url=" + url + ", created=" + created + "]";
	}
		
}
