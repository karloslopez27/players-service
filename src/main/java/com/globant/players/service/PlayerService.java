package com.globant.players.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.globant.players.model.PlayerEntity;

@Service
public interface PlayerService {

	public List<PlayerEntity> retrieveAllPlayers();

	public PlayerEntity retrievPlayer(Long id);

	public PlayerEntity savePlayer(PlayerEntity player);

	public PlayerEntity updatePlayer(PlayerEntity player);

	public void deletePlayer(Long id);
}
