import java.util.Scanner;

class Calc{
	Calc(){
		System.out.println("Calc Cons Call");
	}
	private int add(int x,int y){
		return x + y;
	}
	public int subtract(int x,int y){
		return x - y;
	}
	public int multiply(int x,int y){
		return x * y;
	}
	public int divide(int x,int y){
		return x / y;
	}
}
class AdvCalc{
	AdvCalc(){
		System.out.println("AdvCalc Cons Call");
	}
	public double add(double x,double y){
		return x + y;
	}
	public double subtract(double x,double y){
		return x - y;
	}
	public double multiply(double x,double y){
		return x * y;
	}
	public double divide(double x,double y){
		return x / y;
	}
}
public class OlderWay {

	public static void main(String[] args) {
		System.out.println("add");
		System.out.println("subtract");
		System.out.println("multiply");
		System.out.println("divide");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.next();
		Calc cal = new Calc();
		int result = 0;
		if(choice.equals("add")){
			//result = cal.add(100, 200);
		}
		else
		if(choice.equals("subtract")){
				result = cal.subtract(100, 200);
			}
			else
				if(choice.equals("multiply")){
					result = cal.multiply(100, 200);
				}
				else
					if(choice.equals("divide")){
						result = cal.divide(100, 200);
					}
		System.out.println("Result is "+result);
	}

}
