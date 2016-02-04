import java.util.Scanner;

class MinorAgeException extends Exception{
	
}
public class CustomExceptionDemo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Age");
		int age = scanner.nextInt();
		if(age>=18){
			System.out.println("U Can vote");
			//System.out.println("U Can Drive");
			//System.out.println("U Can Pay Tax");
		}
		else
		{
			try{
			throw new MinorAgeException();
			}
			catch(MinorAgeException e){
				System.out.println(" Age Is Less than 18 U Can't Vote , DL , PanCard ");
			}
		}

	}

}
