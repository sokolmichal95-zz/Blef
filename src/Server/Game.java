package Server;

import java.util.ArrayList;
import java.util.Random;

import Utilities.Card;
import Utilities.Deck;
import Utilities.Utils;

/**
 * Created by msokol on 5/10/16.
 */
public class Game {

	static int counter = 0;
	static Card[] deck;
	static int playerToStart;

	/**
	 * Logowanie
	 * 
	 * @param player
	 */
	public static void loginProcedure(Player player) {
		player.writeToPlayer("Podaj swój login\n");
		String login = player.readFromPlayer();
		while (!login.startsWith("LOGIN ")) {
			player.writeToPlayer("Podaj swój login w formacie : LOGIN <twoj login>\n");
			login = player.readFromPlayer();
		}
		player.setLogin(login.substring(6, login.length()));
	}

	private static Card getCard() {
		return deck[counter++];
	}

	/**
	 * Początek rozgrywki
	 * 
	 * @param players
	 */
	public static void startGame(ArrayList<Player> players) {

		Random random = new Random();
		playerToStart = random.nextInt(players.size() + 1);
		System.out.println(playerToStart);
		for (int i = 0; i < players.size(); i++) {
			players.get(i).writeToPlayer("START " + (i + 1) + " " + playerToStart + "\n");
			players.get(i).setCardsAmount(1);
		}
	}

	/**
	 * Główna rozgrywka
	 * 
	 * @param players
	 */
	public static void round(ArrayList<Player> players) {
		deck = Utils.shuffle(Deck.getDeck());
		for (int i = 0; i < players.size(); i++) {
			players.get(i).writeToPlayer(players.get(i).cardsAmountToString() + " ");
			for (int j = 0; j < players.get(i).getCardsAmount(); j++)
				players.get(i).writeToPlayer(getCard().toString() + "\n");
		}
		/*for (int i = playerToStart; i < players.size(); i++) {
			String message = players.get(i).readFromPlayer();
			System.out.println("Message from player " + i + " " + message);
			if (message.equals("CHECK")) {
				players.get(i).writeToPlayer("SUKCES");
			} else {
				players.get(i).writeToPlayer(message);
			}
		}
		for (int i = 0; i < playerToStart; i++) {
			String message = players.get(i).readFromPlayer();
			if (message.equals("CHECK")) {
				players.get(i).writeToPlayer("SUKCES");
			} else {
				players.get(i).writeToPlayer(message);
			}
		}*/
		counter = 0;
	}
}
