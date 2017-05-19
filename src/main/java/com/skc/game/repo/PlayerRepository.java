package com.skc.game.repo;

import com.skc.game.model.PlayerDetails;

public interface PlayerRepository {
	PlayerDetails createPlayer(PlayerDetails details);
	PlayerDetails getPlayer(String playerName);
}
