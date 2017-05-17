package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.skc.game.Game;

/**
 * 
 * @author sitakant
 *
 */
@SuppressWarnings("resource")
public class App {

	@Autowired
	Game game;

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

		Game game = (Game) applicationContext.getBean("game");
		game.startGame();

		/*
		 * PlayerRepository playerRepository = (PlayerRepository)
		 * applicationContext.getBean("playerRepo");
		 * 
		 * PlayerDetails details = new PlayerDetails();
		 * details.setCharacterName("AA");
		 * details.setHighestScore(Integer.MAX_VALUE+"");
		 * details.setIsSaved(Boolean.FALSE); details.setLastScore(5000+"");
		 * playerRepository.createPlayer(details); System.out.println(details);
		 * 
		 * PlayerDetails playerDetails =
		 * playerRepository.getPlayer(details.getCharacterName());
		 * System.out.println(playerDetails);
		 */

	}

}
