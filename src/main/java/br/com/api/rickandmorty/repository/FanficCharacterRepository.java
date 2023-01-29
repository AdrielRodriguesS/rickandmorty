package br.com.api.rickandmorty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.rickandmorty.model.FanficCharacter;

@Repository
public interface FanficCharacterRepository extends JpaRepository<FanficCharacter, Integer> {


}
