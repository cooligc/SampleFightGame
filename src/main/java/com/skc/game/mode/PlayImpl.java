/**
 * 
 */
package com.skc.game.mode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.skc.game.model.PlayerDetails;
import com.skc.game.repo.PlayerRepository;
import com.skc.util.LogUtil;
import com.skc.util.RandomStringGenerator;

/**
 * @author sitakant
 *
 */
@Component
@SuppressWarnings("resource")
public class PlayImpl implements Play {

	@Autowired
	PlayerRepository playerRepository;
	
	@Value("${total.no.bout}")
	Integer totalBoutCount;
	
	@Value("${fight.in.bout}")
	Integer fightInABout;
	
	@Override
	public void playGame(String name,Boolean isResume) {
		
		PlayerDetails playerDetails = null;
		Integer score = Integer.valueOf(0);
		Integer currentPos = Integer.valueOf(0);
		Integer noBout = Integer.valueOf(0);
		Integer botScore = Integer.valueOf(0);
		Integer _points = 0;
		Map<Integer,String> boutDetails = null;
		playerDetails = playerRepository.getPlayer(name);
		if(playerDetails == null){
			playerDetails = new PlayerDetails();
			playerDetails.setHighestScore(0);
		}
		if(isResume){
			currentPos = playerDetails.getCurrentPos();
			noBout = playerDetails.getBout();
			boutDetails = playerDetails.getBoutDetails();
			String _score[]= playerDetails.getBoutDetails().get(noBout).split(",");
			score = Integer.valueOf(_score[0]);
			botScore = Integer.valueOf(_score[1]);
			_points = playerDetails.getLastScore();
		}else{
			playerDetails.setCharacterName(name);
			playerDetails.setIsSaved(Boolean.FALSE);
			boutDetails = new HashMap<Integer,String>();
		}
		
		StringBuilder builder = new StringBuilder();
		builder.append("From A-Z will have a punch . Please enter your punch");
	
		Scanner scanner = new Scanner(System.in);
		
		LogUtil.log("To exit any time , Press & from keyboard");
		LogUtil.log("===========================================");
		
		while(true){
			if(currentPos == fightInABout){
				boutDetails.put(noBout, score+","+botScore);
				if(noBout == totalBoutCount){
					resultFlash(name, playerDetails, score, boutDetails);
				}else{
					score = Integer.valueOf(0);
					botScore=Integer.valueOf(0);
					LogUtil.log(noBout + " Bout has over");
					LogUtil.log("Now, Going for next bout ");
					LogUtil.log("----------------------------");
				}
				currentPos = 0;
				++noBout;
			}
			
			String dynamicPunch = RandomStringGenerator.generateRandomString();
			LogUtil.log(builder.toString());
			Character selectedChar = scanner.nextLine().charAt(0);
			if(selectedChar.equals('&')){
				LogUtil.log("Do you want to save the current game ? (y/n)");
				String status = scanner.nextLine();
				if(status.equalsIgnoreCase("y")){
					playerDetails.setIsSaved(Boolean.TRUE);
					playerDetails.setBout(++noBout);
					playerDetails.setCurrentPos(currentPos);
					boutDetails.put(noBout,score+","+botScore);
					playerDetails.setBoutDetails(boutDetails);
				}else{
					playerDetails.setIsSaved(Boolean.FALSE);
				}
				if(_points > playerDetails.getHighestScore()){
					playerDetails.setHighestScore(_points);
				}
				playerDetails.setLastScore(_points);
				//TODO Have to save the current execution
				playerRepository.createPlayer(playerDetails);
				LogUtil.successPlayed(name,playerDetails.getLastScore());
				System.exit(0);
			}
			
			
			if(((int)selectedChar) < 65 || ((int)selectedChar) > 91){
				LogUtil.confirmExit();
			}
			
			if(dynamicPunch.contains(selectedChar+"")){
				LogUtil.hit(name,"BOTS");
				++botScore;
			}else{
				LogUtil.hit(name,"");
				++score;
				_points+=10;
			}
			++currentPos;
		}
	
	}

	private void resultFlash(String name, PlayerDetails playerDetails, Integer score,
			Map<Integer, String> boutDetails) {
		LogUtil.log("----------------------");
		LogUtil.log("----------------------");
		LogUtil.log("Thanks  "+name+" ," +" for playing the Game");
		LogUtil.log("Here are the statistics");
		Integer botWinCount = Integer.valueOf(0);
		playerDetails.setBoutDetails(boutDetails);
		for (Entry<Integer, String> bout: playerDetails.getBoutDetails().entrySet()) {
			LogUtil.log("Bout "+bout.getKey());
			LogUtil.log("----------------------");
			String finalScore[] = bout.getValue().split(",");
			LogUtil.log(name + " -> "+ finalScore[0]);
			LogUtil.log("BOTS -> "+ finalScore[1]);
			if(Integer.valueOf(finalScore[0]) > Integer.valueOf(finalScore[1])){
				LogUtil.log("Winner :"+ name);
			}else{
				LogUtil.log("Winner : BOTS");
				++botWinCount;
			}
		}
		
		if(botWinCount >= 2){
			LogUtil.log("Match Winner : BOTS");
		}else{
			LogUtil.log("Match Winner : "+name);
		}
		playerDetails.setIsSaved(Boolean.FALSE);
		playerDetails.setLastScore(score);
		playerDetails.setBout(0);
		playerDetails.setCurrentPos(0);
		if(score > playerDetails.getHighestScore()){
			playerDetails.setHighestScore(score);
		}
		playerRepository.createPlayer(playerDetails);
		LogUtil.log("Thanks for playing the Game ");
		System.exit(0);
	}

	@Override
	public void resumeGame(String name) {
		PlayerDetails playerDetails = playerRepository.getPlayer(name);
		if(null == playerDetails){
			LogUtil.log("Entered Player is not found. Please try again by entering a valid character.");
			System.exit(0);
		}
		
		if(!playerDetails.getIsSaved()){
			LogUtil.log("You have not saved the game yet. So, resume cannot be happened. Please try again");
			System.exit(0);
		}
		
		//TODO Need to retrieve the data from redis and resume the game
		playGame(name, Boolean.TRUE);
	}

	@Override
	public void lastScore(String name) {
		PlayerDetails playerDetails = playerRepository.getPlayer(name);
		if(null == playerDetails){
			LogUtil.log("Entered Player is not found. Please try again by entering a valid character.");
			System.exit(0);
		}
		LogUtil.log(name+" , Your last score is "+playerDetails.getLastScore());
	}

	@Override
	public void highestScore(String name) {
		PlayerDetails playerDetails = playerRepository.getPlayer(name);
		if(null == playerDetails){
			LogUtil.log("Entered Player is not found. Please try again by entering a valid character.");
			System.exit(0);
		}
		LogUtil.log(name+" , Your highest score is "+playerDetails.getHighestScore());
	}

}
