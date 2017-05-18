/**
 * 
 */
package com.skc.game;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.skc.game.mode.Play;
import com.skc.util.LogUtil;

/**
 * @author sitakant
 *
 */
@Component("game")
public class GameImpl implements Game {
	public static Set<String> initialExplorer = new LinkedHashSet<String>();

	static {
		initialExplorer.add("1. Play a new Game");
		initialExplorer.add("2. Resume the old Game");
		initialExplorer.add("3. Current Score");
		initialExplorer.add("4. Highest Score");
		
	}

	@Autowired
	Play play;

	public void startGame() {

		Scanner scanner = new Scanner(System.in);
		LogUtil.log("Please enter your character Name ");
		String name = scanner.next();
		LogUtil.log("Welcome " + name + " to the world of Fight Club");
		LogUtil.log("Please choose your selection");

		initialExplorer.forEach(message -> {
			LogUtil.log(message);
		});

		Integer selection = scanner.nextInt();

		if (selection > 4 || selection < 1) {
			LogUtil.confirmExit();
		}

		chooseMenu(selection,name);

	}

	private void chooseMenu(Integer selection,String name) {
		switch (selection) {
		case 1:
			play.playGame(name,Boolean.FALSE);
			break;
		case 2:
			play.resumeGame(name);
			break;
		case 3:
			play.lastScore(name);
			break;
		case 4:
			play.highestScore(name);
			break;
		}
	}

}
