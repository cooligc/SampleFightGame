/**
 * 
 */
package com.skc.util;

import com.skc.game.model.PlayerDetails;

/**
 * @author sitakant
 *
 */
public class ObjectUtils {

	public static boolean checkNull(PlayerDetails playerDetails) {
		return null == playerDetails ? Boolean.TRUE : Boolean.FALSE;
	}
	
}
