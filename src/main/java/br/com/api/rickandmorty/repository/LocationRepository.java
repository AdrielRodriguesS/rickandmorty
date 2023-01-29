package br.com.api.rickandmorty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.api.rickandmorty.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
	
	@Query("SELECT l FROM Location l WHERE l.name = :name")
	public Location findByName(String name);

}
