package com.skc.game.repo;

import com.skc.game.model.PlayerDetails;

public interface PlayerRepository {
	void createPlayer(PlayerDetails details);
	PlayerDetails getPlayer(String playerName);
}
