import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(9001);
		System.out.println("Waiting for the CLient to Come...");
		Socket socket = server.accept();
		System.out.println("Here Comes the Client...");
		InputStream is = socket.getInputStream();
		int singleByte = is.read();
		System.out.println();
		while(singleByte!=-1){
			System.out.print((char)singleByte);
			singleByte = is.read();
		}
		is.close();
		socket.close();
		server.close();
		

	}

}
