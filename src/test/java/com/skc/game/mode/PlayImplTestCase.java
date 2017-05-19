/**
 * 
 */
package com.skc.game.mode;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.skc.game.common.SampleBaseTestCase;
import com.skc.game.model.PlayerDetails;
import com.skc.game.repo.PlayerRepository;

/**
 * @author sitakant
 *
 */
public class PlayImplTestCase extends SampleBaseTestCase{

	@Autowired
	Play play;
	
	@Autowired
	PlayerRepository playerRepository;
	
	@Test
	public void testInstance(){
		assertTrue(play != null );
		assertTrue(play instanceof Play);
		
		Play play2 = new PlayImpl();
		assertTrue(play2 instanceof PlayImpl);
	}
	
	@Test
	public void testLastScore(){
		PlayerDetails details = new PlayerDetails();
		details.setBout(0);
		details.setBoutDetails(new HashMap<>());
		details.setCharacterName("Test");
		details.setCurrentPos(3);
		details.setHighestScore(4444);
		details.setIsSaved(Boolean.FALSE);
		details.setLastScore(300);
		playerRepository.createPlayer(details);
		assertEquals(details.getLastScore(),play.lastScore(details.getCharacterName()));
	}
	
	@Test(expected=GameException.class)
	public void testInvalidCharacterForLastScore(){
		String characterName = "DUMMY";
		play.lastScore(characterName);
	}
	
	@Test(expected=GameException.class)
	public void testInvalidCharacterForHighestScore(){
		String characterName = "DUMMY";
		play.highestScore(characterName);
	}
	
	@Test(expected=GameException.class)
	public void testResumeGameWithInvalidCharcter(){
		String characterName = "DUMMY";
		play.resumeGame(characterName);
	}
	
	@Test(expected=GameException.class)
	public void testResumeGameForUnsaved(){
		PlayerDetails details = new PlayerDetails();
		details.setBout(0);
		details.setBoutDetails(new HashMap<>());
		details.setCharacterName("Test");
		details.setCurrentPos(3);
		details.setHighestScore(4444);
		details.setIsSaved(Boolean.FALSE);
		details.setLastScore(300);
		playerRepository.createPlayer(details);
		play.resumeGame(details.getCharacterName());
	}
	
	@Test
	public void testHighestScore(){
		PlayerDetails details = new PlayerDetails();
		details.setBout(0);
		details.setBoutDetails(new HashMap<>());
		details.setCharacterName("Test");
		details.setCurrentPos(3);
		details.setHighestScore(4444);
		details.setIsSaved(Boolean.FALSE);
		details.setLastScore(300);
		playerRepository.createPlayer(details);
		assertEquals(details.getHighestScore(),play.highestScore(details.getCharacterName()));
	}
	
}
