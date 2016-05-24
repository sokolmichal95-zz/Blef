package Server;

import Utilities.Card;

import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

/**
 * Created by msokol on 5/10/16.
 */
public class Player {
	private SocketChannel socketChannel = null;
	private String login;
	private int cardsAmount;

	public String cardsAmountToString() {
		StringBuilder sb = new StringBuilder();
		sb.append(cardsAmount);
		return new String(sb);
	}

	public void setCardsAmount(int cardsAmount) {
		this.cardsAmount = cardsAmount;
	}

	private ArrayList<Card> cards = new ArrayList<Card>();

	public Player(SocketChannel socketChannel) throws IOException {
		this.socketChannel = socketChannel;
		this.socketChannel.socket().setSoTimeout(5);
		// this.socketChannel.configureBlocking(false);
		System.out.println("New player connected" + socketChannel.socket().getRemoteSocketAddress());
	}

	public void disconnectPlayer() {
		try {
			this.socketChannel.close();
		} catch (IOException e) {
			System.out.printf(e.getMessage());
		}
	}

	public void writeToPlayer(String message) {
		ByteBuffer buffer = ByteBuffer.allocate(128);
		buffer.clear();
		buffer.put(message.getBytes());

		buffer.flip();
		System.out.println(new String(buffer.array()) + socketChannel.socket().getRemoteSocketAddress());
		while (buffer.hasRemaining()) {
			try {
				socketChannel.write(buffer);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public String readFromPlayer() {
		ByteBuffer buffer = ByteBuffer.allocate(128);
		try {
			socketChannel.socket().setSoTimeout(50);
			int bytesRead = this.socketChannel.read(buffer);

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(socketChannel.socket().getRemoteSocketAddress() + " : " + new String(buffer.array()));
		return new String(buffer.array());
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void addCard(Card c) {
		this.cards.add(c);
		this.cardsAmount = this.cards.size();
	}

	public int getCardsAmount() {
		// TODO Auto-generated method stub
		return this.cardsAmount;
	}
}
