import java.util.Scanner;
import java.util.InputMismatchException;


public class Demo2 {
	Scanner scanner = new Scanner(System.in);
	int firstNo ;
	int secondNo;
	int result;
	void takeFirstNo(){
		
		
		try{
		System.out.println("Enter the First No");
		 firstNo = scanner.nextInt();         // throw new InputMisMatchException()
		 
		
		}
		catch(InputMismatchException e)
		{
			System.out.println("Only Number Allowed , No Chars Allowed ");
			scanner.nextLine();
			takeFirstNo();
		}
		
	}
	
	void divide(){
		try{
		result = firstNo/secondNo;
		}
		catch(ArithmeticException e){
			System.out.println("U Can't Divide a Number with Zero ");
			takeSecondNo();
			divide();
		}
		
	}
	
	void print(){
		System.out.println("Result "+result);
	}
	
void takeSecondNo(){
		
		
		try{
		System.out.println("Enter the Second No");
		 secondNo = scanner.nextInt();         // throw new InputMisMatchException()
		 
		
		}
		catch(InputMismatchException e)
		{
			System.out.println("Only Number Allowed , No Chars Allowed ");
			scanner.nextLine();
			takeSecondNo();
		}
		
	}
	public static void main(String[] args) {
		Demo2 obj = new Demo2();
		obj.takeFirstNo();
		obj.takeSecondNo();
		obj.divide();
		obj.print();
		
		
		// Scanner Act like a Buffer and right now it is connected to the System.in
		
		
		
		

	}

}
