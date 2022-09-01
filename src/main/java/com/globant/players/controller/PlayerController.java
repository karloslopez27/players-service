package com.globant.players.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globant.players.domain.SavePlayerResponse;
import com.globant.players.model.PlayerEntity;
import com.globant.players.service.PlayerService;

@RestController
@RequestMapping("/v1/players")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	@GetMapping("/all")
	public ResponseEntity<List<PlayerEntity>> retrieveAllPlayers() {
		List<PlayerEntity> allPlayers = playerService.retrieveAllPlayers();
		return ResponseEntity.status(HttpStatus.OK).body(allPlayers);
	}

	@GetMapping("/player")
	public ResponseEntity<PlayerEntity> retrievePlayer(@RequestParam Long playerId) {
		PlayerEntity player = playerService.retrievPlayer(playerId);
		return ResponseEntity.status(HttpStatus.OK).body(player);
	}

	@PostMapping("/player")
	public ResponseEntity<PlayerEntity> savePlayer(@RequestBody PlayerEntity player) {
		PlayerEntity playerSaved = playerService.savePlayer(player);
		if (playerSaved.getId() != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(playerSaved);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(playerSaved);
		}

	}

	@PutMapping("/player")
	public ResponseEntity<PlayerEntity> updatePlayer(@RequestBody PlayerEntity player) {
		PlayerEntity playerUpdated = playerService.updatePlayer(player);
		if (playerUpdated.getId() != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(playerUpdated);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(playerUpdated);
		}

	}

	@DeleteMapping("/player")
	public ResponseEntity<String> updatePlayer(@RequestParam Long playerId) {
		playerService.deletePlayer(playerId);
		return ResponseEntity.status(HttpStatus.OK).body("deleted.");

	}

}
