class Demo11
{

	/*static void show(long x){
		System.out.println("long");
	}*/
	/*static void show(double x){
		System.out.println("double");
	}
	static void show(float x){
		System.out.println("float");
	}*/
	/*static void show(Integer x){
		System.out.println("Wrapper Class Integer");
	}*/
	static void show(short x){
		System.out.println("short");
	}
	/*static void show(int x){
		System.out.println("int");
	}*/
	static void show(byte x){
		System.out.println("byte");
	}
	/*static void show(int... x){
		System.out.println("var args");
	}*/
}
public class TypePromitionDemo {

	public static void main(String[] args) {
		//LinkedList l =new LinkedList();
		Demo11.show((byte)1);
	}

}
