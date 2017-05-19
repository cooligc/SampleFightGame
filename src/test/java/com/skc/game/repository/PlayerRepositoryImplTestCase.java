/**
 * 
 */
package com.skc.game.repository;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.skc.game.common.SampleBaseTestCase;
import com.skc.game.model.PlayerDetails;
import com.skc.game.repo.PlayerRepository;
import com.skc.game.repo.PlayerRepositoryImpl;

/**
 * @author sitakant
 *
 */
public class PlayerRepositoryImplTestCase extends SampleBaseTestCase {

	@Autowired
	PlayerRepository playerRepository;
	
	@Test
	public void testInstanceOf(){
		assertTrue(playerRepository != null );
		assertTrue(playerRepository instanceof PlayerRepositoryImpl);
		
		PlayerRepository repository = new PlayerRepositoryImpl();
		assertTrue(repository instanceof PlayerRepositoryImpl);
	}
	
	@Test
	public void testCreatePlayer(){
		PlayerDetails details = new PlayerDetails();
		details.setBout(0);
		details.setBoutDetails(new HashMap<>());
		details.setCharacterName("Test");
		details.setCurrentPos(3);
		details.setHighestScore(4444);
		details.setIsSaved(Boolean.FALSE);
		details.setLastScore(300);
		
		
		PlayerDetails result = playerRepository.createPlayer(details);
		assertNotNull(result);
		assertEquals(details.getBout(), result.getBout());
		assertEquals(details.getBoutDetails(), result.getBoutDetails());
		assertEquals(details.getCharacterName(), result.getCharacterName());
		assertEquals(details.getCurrentPos(), result.getCurrentPos());
		assertEquals(details.getHighestScore(), result.getHighestScore());
		assertEquals(details.getIsSaved(), result.getIsSaved());
		assertEquals(details.getLastScore(), result.getLastScore());

		PlayerDetails finalResult = playerRepository.getPlayer(result.getCharacterName());
		assertNotNull(finalResult);
		assertEquals(finalResult.getBout(), result.getBout());
		assertEquals(finalResult.getBoutDetails(), result.getBoutDetails());
		assertEquals(finalResult.getCharacterName(), result.getCharacterName());
		assertEquals(finalResult.getCurrentPos(), result.getCurrentPos());
		assertEquals(finalResult.getHighestScore(), result.getHighestScore());
		assertEquals(finalResult.getIsSaved(), result.getIsSaved());
		assertEquals(finalResult.getLastScore(), result.getLastScore());
	}
	
}
