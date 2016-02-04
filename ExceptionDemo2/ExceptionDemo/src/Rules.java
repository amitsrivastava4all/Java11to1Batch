import java.io.File;
import java.io.IOException;


public class Rules {

	public static void main(String[] args) {
		int x[] = new int[10];
		x[20]= 100;

			File file = new File("X:\\ADemo\\TT.txt");
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Can't Create File");
			}
		

	}

}
