
public class Tricks {
	static void finallyUse(){
		try
		{
			System.out.println("Code Start");
			if(100>20){
			return;
			}
			//int e = 100/0;  // throw new ArithmeticException();
			System.out.println("Code Ends");
		}
		finally{
			System.out.println("This Will Execute Always");
		}
	}
	static void finallyUse2(){
		try
		{
			System.out.println("Code Start");
			System.exit(0);
			//int e = 100/0;  // throw new ArithmeticException();
			System.out.println("Code Ends");
		}
		catch(ArithmeticException e){
			System.out.println("U Can't Divide a Number With Zero "+e);
			throw e;
			//int r = 100/0;
		}
		finally{
			System.out.println("This Will Execute Always");
		}
		System.out.println("Coding.......");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		finallyUse2();

	}

}
