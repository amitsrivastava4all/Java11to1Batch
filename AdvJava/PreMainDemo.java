import java.lang.instrument.Instrumentation;

class W
{
	// housekeeping Bytes (8)  Object Status (Id , Locked (Synch), Reachable)
}
class E
{
	// 8 (HouseKeeping) + 4 (int size) + 4 (Padding Bytes)
	int w; // 4 byte
}
class S
{
	// 8 byte
	int w;  // 4 byte
	String m = "Hello";  // 4 Bytes (Ref)
}
class T
{
	long w; // 8 byte
	int q;
	int e;
	byte q1;
	
}


public class PreMainDemo {
	public static void premain(String agentArgs, Instrumentation inst){
		System.out.println("Pre Main Call");
		W obj = new W();
		long size = inst.getObjectSize(obj);
		System.out.println("W Object Size is "+size);
		size = inst.getObjectSize(new E());
		System.out.println("E Object Size is "+size);
		size = inst.getObjectSize(new S());
		System.out.println("S Object Size is "+size);
		size = inst.getObjectSize(new T());
		System.out.println("T Object Size is "+size);
	}
	public static void main(String[] args) {
		System.out.println("Main Call");
		// try with resource Java 7
		/*try(FileInputStream fi = new FileInputStream("E:\\ProjectWS\\ThreadsDemo\\src\\PreMain.java")){
			
		}
		catch(Exception e){
			
		}*/

	}

}
