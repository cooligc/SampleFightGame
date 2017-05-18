/**
 * 
 */
package com.skc.game.model;

import java.io.Serializable;
import java.util.Map;

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
	private Integer bout;
	private Integer currentPos;
	private Map<Integer,String> boutDetails; 
	
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
	/**
	 * @return the bout
	 */
	public Integer getBout() {
		return bout;
	}
	/**
	 * @param bout the bout to set
	 */
	public void setBout(Integer bout) {
		this.bout = bout;
	}
	/**
	 * @return the currentPos
	 */
	public Integer getCurrentPos() {
		return currentPos;
	}
	/**
	 * @param currentPos the currentPos to set
	 */
	public void setCurrentPos(Integer currentPos) {
		this.currentPos = currentPos;
	}
	/**
	 * @return the boutDetails
	 */
	public Map<Integer,String> getBoutDetails() {
		return boutDetails;
	}
	/**
	 * @param boutDetails the boutDetails to set
	 */
	public void setBoutDetails(Map<Integer,String> boutDetails) {
		this.boutDetails = boutDetails;
	}
}
