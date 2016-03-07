import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

class T
{
	T(){
		System.out.println("T Cons call");
	}
}
public class NewerWay {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		System.out.println("Which Calculator U Want to Use");
		System.out.println("Type Calc for Small Calculations");
		System.out.println("Type AdvCalc for Bigger Calculations");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your Choice");
		String className = scanner.next();
		// This is the Another Way to create Class and it is a Lazy way
		// Lazy means compiler do not know which class object u r going to
		// create on runtime
		Object object = Class.forName(className).newInstance();  //new ClassName()
		System.out.println("Type add for calling add");
		System.out.println("Type subtract for calling subtract");
		System.out.println("Type multiply for calling multiply");
		System.out.println("Type divide for calling divide");
		System.out.println("Enter your choice");
		String methodName = scanner.next();
		/*Object params[]= {10,20,30,40,50};*/
		Method methods[]=object.getClass().getDeclaredMethods();
		for(Method method : methods){
			if(method.getName().equals(methodName)){
				Class paramTypes []=method.getParameterTypes();
				
				Method m = object.getClass().getDeclaredMethod(methodName,paramTypes);
				m.setAccessible(true);
				Object result = m.invoke(object, 10,20);  // obj.add(100,200)
				System.out.println("Result is "+result);
				break;
			}
		}
		//Method method = object.getClass().getDeclaredMethod(methodName, int.class,int.class);
		//Method method = object.getClass().getDeclaredMethod(methodName,paramTypes);
		//Object result = method.invoke(object, 10,20);  // obj.add(100,200)
		//System.out.println("Result is "+result);
		// this will give upcasted object

	}

}
