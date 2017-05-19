/**
 * 
 */
package com.skc.game.mode;

/**
 * @author sitakant
 *
 */
public interface Play {
	void playGame(String name,Boolean isResume);

	void resumeGame(String name);

	Integer lastScore(String name);

	Integer highestScore(String name);
}
