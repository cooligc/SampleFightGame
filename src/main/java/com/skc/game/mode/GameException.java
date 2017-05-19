/**
 * 
 */
package com.skc.game.mode;

/**
 * @author chaudhsi
 *
 */
public class GameException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	
	public GameException(String message) {
		this.errorMessage = message;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	
}
