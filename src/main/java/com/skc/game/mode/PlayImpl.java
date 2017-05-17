/**
 * 
 */
package com.skc.game.mode;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.skc.game.model.PlayerDetails;
import com.skc.util.LogUtil;
import com.skc.util.RandomStringGenerator;

/**
 * @author sitakant
 *
 */
@Component
@SuppressWarnings("resource")
public class PlayImpl implements Play {

	
	
	@Override
	public void playGame(String name,Boolean isResume) {
		
		String uuid = RandomStringGenerator.generateRandomString();
		PlayerDetails playerDetails = null;
		Integer score = Integer.valueOf(0);
		if(isResume){
			playerDetails = new PlayerDetails();
			score = playerDetails.getLastScore();
		}else{
			playerDetails = new PlayerDetails();
			playerDetails.setCharacterName(name);
			playerDetails.setIsSaved(Boolean.FALSE);
			playerDetails.setHighestScore(0);
		}
		
		StringBuilder builder = new StringBuilder();
		builder.append("From A-Z will have a punch . Please enter your punch");
	
		Scanner scanner = new Scanner(System.in);
		
		LogUtil.log("To exit any time , Press & from keyboard");
		LogUtil.log("===========================================");
		
		while(true){
			LogUtil.log(builder.toString());
			Character selectedChar = scanner.nextLine().charAt(0);
			if(selectedChar.equals('&')){
				LogUtil.log("Do you want to save the current game ? (y/n)");
				String status = scanner.nextLine();
				if(status.equalsIgnoreCase("y")){
					playerDetails.setIsSaved(Boolean.TRUE);
				}
				if(score > playerDetails.getHighestScore()){
					playerDetails.setHighestScore(score);
				}
				playerDetails.setLastScore(score);
				//TODO Have to save the current execution 
				LogUtil.successPlayed(name,score);
				System.exit(0);
			}
			
			
			if(((int)selectedChar) < 65 || ((int)selectedChar) > 91){
				LogUtil.confirmExit();
			}
			
			if(uuid.contains(selectedChar+"")){
				LogUtil.hit(name,"BOTS");
			}else{
				LogUtil.hit(name,"");
				++score;
			}
		}
	
	}

	@Override
	public void resumeGame(String name) {
		//TODO Need to retrieve the data from redis and resume the game
		playGame(name, Boolean.TRUE);
	}

	@Override
	public void lastScore(String name) {
		//TODO Need to retrieve the PlayerDetails from Redis and get the last score 
		PlayerDetails playerDetails = new PlayerDetails();
		LogUtil.log(name+" , Your last score is "+playerDetails.getLastScore());
	}

	@Override
	public void highestScore(String name) {
		//TODO Need to retrieve the PlayerDetails from Redis and get the highest score 
		PlayerDetails playerDetails = new PlayerDetails();
		LogUtil.log(name+" , Your highest score is "+playerDetails.getHighestScore());
	}

}
