package Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

import Utilities.Card;
import Utilities.Card.Color;
import Utilities.Utils;

public class ClientMainClass {

	public static int PORT = 8989;
	public static String HOST = "localhost";
	
	public static void main(String[] args) {
		try {
			Socket socket = new Socket(HOST, PORT);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeBytes("LOGIN s407306");
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			String message = (String) ois.readObject();
			System.out.println(message);
			while (socket.isConnected()) {
				Card c = Utils.generateRandomCard();
				oos.writeObject("V " + c.toString());
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
