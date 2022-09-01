package com.globant.players.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.players.model.PlayerEntity;
import com.globant.players.repository.PlayerRepository;
import com.globant.players.service.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerRepository repository;

	@Override
	public List<PlayerEntity> retrieveAllPlayers() {
		return repository.findAll();
	}

	@Override
	public PlayerEntity retrievPlayer(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public PlayerEntity savePlayer(PlayerEntity player) {
		Optional<PlayerEntity> playerOptional = repository.findById(player.getId());
		if (!playerOptional.isPresent()) {
			return repository.save(player);
		} else {
			return new PlayerEntity();
		}

	}

	@Override
	public PlayerEntity updatePlayer(PlayerEntity player) {
		Optional<PlayerEntity> playerOptional = repository.findById(player.getId());
		if (playerOptional.isPresent()) {
			PlayerEntity currentPlayer = playerOptional.get();
			currentPlayer.setId(player.getId());
			currentPlayer.setAge(player.getAge());
			currentPlayer.setFullname(player.getFullname());
			currentPlayer.setNationality(player.getNationality());
			currentPlayer.setTeam(player.getTeam());

			return repository.save(currentPlayer);
		} else {
			return new PlayerEntity();
		}
	}

	@Override
	public void deletePlayer(Long id) {
		repository.deleteById(id);

	}

}
