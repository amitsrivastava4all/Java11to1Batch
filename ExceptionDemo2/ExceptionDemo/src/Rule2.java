
public class Rule2 {

	public static void main(String[] args) {
		
			String  a = "OK";
			String b = "Hello";
			System.out.println(b.length());
			try{
			System.out.println(a.length());
			int s[] = new int[10];
			s[2]=190;
			int t = 100/0;
			}
			catch(NullPointerException e){
				System.out.println("Value is Empty Cant Find the Length ");
			}
			catch(ArrayIndexOutOfBoundsException e){
				System.out.println("Array Size is Small Can't Go Beyond this");
			}
			catch(ArithmeticException e){
				System.out.println("Can't Divide a Number with Zero");
			}
			catch(Exception e){
				System.out.println("Contact to System Admin..");
			}
		
	}

}
