import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
class TT implements Serializable{
	int m = 90;
}
class PP  implements Serializable{   // implements Serializable{
	int x,y;
	TT obj = new TT();
	PP(){
		x = 100;
		y = 200;
		System.out.println("PP COns Call");
	}
}
class QQ extends PP {//implements Serializable{
	int z ;
	QQ(){
		z=200;
		System.out.println("QQ Cons Call");
	}
	@Override
	public String toString() {
		return "QQ [z=" + z + ", x=" + x + ", y=" + y + " m = "+obj.m + "]";
	}
	
}
public class ISA_HASA_Serialization {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		QQ obj = new QQ();
		FileOutputStream fo =new FileOutputStream("D:\\Images\\isa.dat",true);
		ObjectOutputStream os = new ObjectOutputStream(fo);
		obj.x++;
		obj.y++;
		obj.z++;
		os.writeObject(obj);
		
		os.close();
		fo.close();
		System.out.println("Object Store ");
		FileInputStream fi = new FileInputStream("D:\\Images\\isa.dat");
		ObjectInputStream oi = new ObjectInputStream(fi);
		QQ obj2 = (QQ)oi.readObject();
		System.out.println("After Read "+obj2);
		oi.close();
		fi.close();
		

	}

}
