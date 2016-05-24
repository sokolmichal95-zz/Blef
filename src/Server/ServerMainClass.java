package Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

/**
 * Created by msokol on 5/10/16.
 */
public class ServerMainClass {

	private static int NUMBER_OF_PLAYERS = 10;
	private static int PORT = 10000;

	public static void main(String[] args) {

		ArrayList<Player> players = new ArrayList<>();

		try {
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.bind(new InetSocketAddress(PORT));
			int i = 0;
			while (i < NUMBER_OF_PLAYERS) {
				SocketChannel socketChannel = serverSocketChannel.accept();
				Player player = new Player(socketChannel);
				player.writeToPlayer("POLACZONO\n");
				players.add(player);
				i++;
			}
			for (Player p : players) {
				Game.loginProcedure(p);
			}
			Game.startGame(players);
			Game.round(players);

		} catch (IOException e) {
			System.console().printf(e.getMessage());
		}
	}

}
