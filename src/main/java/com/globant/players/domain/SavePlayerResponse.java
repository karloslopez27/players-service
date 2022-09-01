package com.globant.players.domain;

import com.globant.players.model.PlayerEntity;

public class SavePlayerResponse {

	private int code;
	private String message;
	private PlayerEntity player;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PlayerEntity getPlayer() {
		return player;
	}

	public void setPlayer(PlayerEntity player) {
		this.player = player;
	}

}
