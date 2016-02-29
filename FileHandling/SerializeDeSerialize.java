import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Customer implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	private String name;
	private transient String city;
	private String phone="2222";
	private String email = "joe@email.com";
	Customer(int id, String name , String city){
		this.id = id;
		this.name = name;
		this.city = city;
		System.out.println("Constructor Call");
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", city=" + city
				+ ", phone=" + phone + ", email=" + email ;
	}
	
}
public class SerializeDeSerialize {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		/*Customer ram =new Customer(1001,"Ram","Delhi");
		// This class is used to Write Bytes in a File
		FileOutputStream fo =new FileOutputStream("D:\\Images\\Customer.dat");
		// This class is used to convert Object into Bytes
		ObjectOutputStream os = new ObjectOutputStream(fo);
		ram.id = ram.id + 3;
		os.writeObject(ram);  // Write Object in a File
		System.out.println("Object  Store in a File ");
		os.close();
		fo.close();*/
		
		// this class read bytes from a file
		FileInputStream fi = new FileInputStream("D:\\Images\\Customer.dat");
		// this class convert bytes into object
		ObjectInputStream oi = new ObjectInputStream(fi);
		Customer c = (Customer)oi.readObject();
		System.out.println(c.toString());
		oi.close();
		fi.close();

	}

}
