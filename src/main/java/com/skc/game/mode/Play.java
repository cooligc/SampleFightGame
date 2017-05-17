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

	void lastScore(String name);

	void highestScore(String name);
}
