package br.com.api.rickandmorty.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OriginLocation extends Location {
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "character_id")
	private Character character;

}
