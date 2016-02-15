class E
{
static void show(){
	System.out.println("E Show");
}
}
class T1 extends E
{
	//@Override
static void show(){
System.out.println("T1 Show");
}
}
public class StaticOverrideDemo {

	public static void main(String[] args) {
		T1 obj = new T1();
		obj.show();

	}

}
