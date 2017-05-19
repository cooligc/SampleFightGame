/**
 * 
 */
package com.skc.util;

/**
 * @author sitakant
 *
 */
public class  LogUtil{
	
	
	public static void log(Object o){
		System.out.println(o);
	}

	public static void confirmExit() {
		LogUtil.log("Invalid Entry.");
		LogUtil.log("Thank you for being in the Game. Good Bye");
		System.exit(0);
	}

	public static void hit(String name,String type) {
		if(type.equals("BOTS")){
			LogUtil.log(name + " , You have been hitted by BOTS");
		}else{
			LogUtil.log(name + " , You hit BOTS and earn points");
		}
	}

	public static void successPlayed(String name,Integer score) {
		LogUtil.log(name + " , Thanks for playing. Your current score is "+score);
	}
	
	public static void printInvalidCharName(){
		LogUtil.log("Entered Player is not found. Please try again by entering a valid character.");
	}

}
