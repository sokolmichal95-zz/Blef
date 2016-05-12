package Server;

import Utilities.Card;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by msokol on 5/10/16.
 */
public class Game {

    public static void loginProcedure(Player player) {
        player.writeToPlayer("Podaj swój login\n");
        String login = player.readFromPlayer();
        while (!login.startsWith("LOGIN ")) {
            player.writeToPlayer("Podaj swój login w formacie : LOGIN <twoj login>\n");
            login = player.readFromPlayer();
        }
        player.setLogin(login.substring(6, login.length()));
    }

    public static void startGame(ArrayList<Player> players){
        Random random = new Random();
        int playerToStart = random.nextInt(players.size()+1);
        System.out.println(playerToStart);

        for (Player p :
                players) {
            p.writeToPlayer("START " + (players.indexOf(p) + 1) + " " + playerToStart + "\n");
            Card c = new Card("P", Card.Value.AS.getCardValue());
            p.writeToPlayer("KARTA : " + c.getCard());
        }
    }
}
