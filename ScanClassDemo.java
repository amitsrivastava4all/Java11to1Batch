import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
interface E
{
	void output();
}
interface E1{
	
}
class WW
{
	
}
class W{
	
}
class A extends WW implements E,E1
{
	int x;
	private int y;
	protected int z;
	public int m;
	static int d;
	A(){
		x = 100;
		y = 200;
	}
	public void show(){
		
	}
	 void print(){
		
	}
	 static void disp(){
		 
	 }
	@Override
	public void output() {
		// TODO Auto-generated method stub
		
	}
}

public class ScanClassDemo {

	public static void main(String[] args) {
		Class cls = A.class;  // MetaData
		System.out.println(cls.getDeclaredConstructors().length);
		if(cls.getInterfaces().length==2){
			System.out.println("Correct No of Interfaces Implemented ");
		}
		else
		{
			System.out.println("Incorrect No of Interfaces.");
			
		}
		if(cls.getSuperclass().getName().equals("W")){
			System.out.println("Correct Class");
		}
		else
		{
			System.out.println("Not Correct Class");
		}
		for(Field  f : cls.getDeclaredFields()){
		if(Modifier.isPublic(f.getModifiers())){	
			System.out.println("Wrong Variable "+f.getName());
		}
		}
		System.out.println("This Class Contains No of Methods "+cls.getDeclaredMethods().length);
		for(Method m : cls.getDeclaredMethods()){
			if(Modifier.isStatic(m.getModifiers())){
				System.out.println("this method is static "+m.getName());
			}
			if(Modifier.isPublic(m.getModifiers())){
				System.out.println("this method is public "+m.getName());
			}
		}
		A obj = new A();
		Class cls2 = obj.getClass(); // Data + MetaData

	}

}
