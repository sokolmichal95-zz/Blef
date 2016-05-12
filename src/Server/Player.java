package Server;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import Utilities.Card;

/**
 * Created by msokol on 5/10/16.
 */
public class Player {
    private SocketChannel socketChannel = null;
    private String login;
    private int cardsAmount;
    private ArrayList<Card> cards = new ArrayList<Card>();

    public Player(SocketChannel socketChannel) throws IOException {
        this.socketChannel = socketChannel;
        this.socketChannel.socket().setSoTimeout(5);
        //this.socketChannel.configureBlocking(false);
        System.out.println("New player connected");
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
            int bytesRead = this.socketChannel.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(buffer.array());
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
