package app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skc.game.Game;
import com.skc.game.mode.GameException;
import com.skc.util.LogUtil;

/**
 * 
 * @author sitakant
 *
 */
@SuppressWarnings("resource")
public class App {


	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

		Game game = (Game) applicationContext.getBean("game");
		
		try{
			game.startGame();
		}catch(GameException e){
			LogUtil.log(e.getErrorMessage());
			System.exit(0);
		}catch(Exception e){
			e.printStackTrace();
			LogUtil.log("--- Unable to Process ---");
			System.exit(0);
		}
	
	}

}
