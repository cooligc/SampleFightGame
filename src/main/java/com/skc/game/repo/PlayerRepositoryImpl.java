/**
 * 
 */
package com.skc.game.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.skc.game.model.PlayerDetails;

/**
 * @author sitakant
 *
 */
@Repository("playerRepo")
public class PlayerRepositoryImpl implements PlayerRepository{
	
	private static final String PLAYER_KEY="PLAYER";
	
	@Autowired
	RedisTemplate<String, PlayerDetails> redisTemplate;
	

	@Override
	public PlayerDetails createPlayer(PlayerDetails details) {
		redisTemplate.opsForHash().put(PLAYER_KEY, details.getCharacterName(), details);
		return details;
	}

	@Override
	public PlayerDetails getPlayer(String playerName) {
		return (PlayerDetails) redisTemplate.opsForHash().get(PLAYER_KEY, playerName);
	}
	
}
