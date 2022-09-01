package com.globant.players.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.globant.players.model.PlayerEntity;

public interface PlayerRepository extends CrudRepository<PlayerEntity, Long> {

	public List<PlayerEntity> findAll();	

}
