package br.com.api.rickandmorty.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="locations")
public class Location {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank
	@Size(max=100)
	private String name;
	
	@NotBlank
	@Size(max=100)
	private String dimension;
	
	private String residents;
	
	@Size(max=100)
	private String url;
	
	@Size(max=100)
	private String created;
	
	@OneToMany(mappedBy = "originLocation")
	private List<FanficCharacter> charactersOrigin = new ArrayList<>();
		
	@OneToMany(mappedBy = "lastKnowLocation")
	private List<FanficCharacter> charactersLastKnow = new ArrayList<>();
	
	public Location() {
	}

	public Location(Integer id, @NotBlank @Size(max = 100) String name, @NotBlank @Size(max = 100) String dimension,
			String residents, @Size(max = 100) String url, @Size(max = 100) String created) {
		this.id = id;
		this.name = name;
		this.dimension = dimension;
		this.residents = residents;
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
