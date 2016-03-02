import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost",9001);
		System.out.println("Enter the Message Send to the Server");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Message ");
		String message = scanner.nextLine();
		OutputStream os = socket.getOutputStream();
		os.write(message.getBytes());
		System.out.println("Message Send to the Server");
		os.close();
		socket.close();

	}

}
