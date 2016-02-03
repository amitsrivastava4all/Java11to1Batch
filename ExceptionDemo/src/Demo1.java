import java.util.InputMismatchException;
import java.util.Scanner;


public class Demo1 {

	public static void main(String[] args) {
		int firstNo = 0;
		int secondNo = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the First No");
		try{
			firstNo = scanner.nextInt();
		}
		catch(InputMismatchException e){
			System.out.println("Only Number Allowed , No Characters Allowed in First No");
			scanner.nextLine();
		}
		System.out.println("Enter the Second No");
		try{
		 secondNo = scanner.nextInt();
		}
		catch(InputMismatchException e){
			System.out.println("Only Number Allowed , No Characters Allowed in First No");
			scanner.nextLine();
		}
		int result = firstNo/secondNo;
		System.out.println("Result is "+result);
		

	}

}
