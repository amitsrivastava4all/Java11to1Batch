import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;


public strictfp class Demo3 {

	public static void main(String[] args) {
		BigDecimal bd = BigDecimal.valueOf(9090900.20);
		BigInteger bg1 = BigInteger.valueOf(100000l);
		BigInteger bg2 = BigInteger.valueOf(100000l);
		BigInteger b3 = bg1.multiply(bg2);
		System.out.println(b3);
		double a = 10.20;
		float b = 90.20f;
		System.out.println("Enter the Salary");
		Scanner scanner = new Scanner(System.in);
		int salary = scanner.nextInt();
		//float salary = scanner.nextFloat();
		System.out.println("Salary "+salary);

	}

}
