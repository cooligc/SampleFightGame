/**
 * 
 */
package com.skc.game.util;

import static org.junit.Assert.*;

import org.junit.Test;

import com.skc.game.common.SampleBaseTestCase;
import com.skc.util.RandomStringGenerator;

/**
 * @author sitakant
 *
 */

public class RandomStringGeneratorTestCase extends SampleBaseTestCase {
	
	@Test
	public void testGenerateRandomString(){
		String generatedString = RandomStringGenerator.generateRandomString();
		assertEquals(13, generatedString.length());
	}
	
	
}
