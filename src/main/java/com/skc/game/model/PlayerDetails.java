/**
 * 
 */
package com.skc.game.model;

import java.io.Serializable;

/**
 * @author sitakant
 *
 */
public class PlayerDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String characterName;
	private Integer highestScore;
	private Integer lastScore;
	private Boolean isSaved;
	/**
	 * @return the characterName
	 */
	public String getCharacterName() {
		return characterName;
	}
	/**
	 * @param characterName the characterName to set
	 */
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}
	/**
	 * @return the highestScore
	 */
	public Integer getHighestScore() {
		return highestScore;
	}
	/**
	 * @param highestScore the highestScore to set
	 */
	public void setHighestScore(Integer highestScore) {
		this.highestScore = highestScore;
	}
	/**
	 * @return the lastScore
	 */
	public Integer getLastScore() {
		return lastScore;
	}
	/**
	 * @param lastScore the lastScore to set
	 */
	public void setLastScore(Integer lastScore) {
		this.lastScore = lastScore;
	}
	/**
	 * @return the isSaved
	 */
	public Boolean getIsSaved() {
		return isSaved;
	}
	/**
	 * @param isSaved the isSaved to set
	 */
	public void setIsSaved(Boolean isSaved) {
		this.isSaved = isSaved;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PlayerDetails [characterName=" + characterName + ", highestScore=" + highestScore + ", lastScore="
				+ lastScore + ", isSaved=" + isSaved + "]";
	}
	
	
	
}
