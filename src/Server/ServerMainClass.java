package Server;

import Utilities.Card;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

/**
 * Created by msokol on 5/10/16.
 */
public class ServerMainClass {

    private static int NUMBER_OF_PLAYERS = 3;
    private static int PORT = 8989;

    public static void main(String[] args) {

        ArrayList<Player> players = new ArrayList<>();

        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(PORT));
            int i = 0;
            while (i < NUMBER_OF_PLAYERS) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                Player player = new Player(socketChannel);
                player.writeToPlayer("POLOCZONO\n");
                players.add(player);
                i++;
            }
            Game game = new Game();
            for (Player p :
                    players) {
                game.loginProcedure(p);
            }
            game.startGame(players);

            /*while (players.size() > 0) {


                //główna rozgrywka
            }*/

            for (Player p :
                    players) {
                p.disconnectPlayer();
            }

        } catch (IOException e) {
            System.console().printf(e.getMessage());
        }
    }

}
