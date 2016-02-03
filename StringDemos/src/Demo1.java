
public class Demo1 {

	public static void main(String[] args) {
		//String a = "Terms and Conditions.gjdlkfjgldfjgljfdlgjlfdj";
		final String a1 = "Hello";
		String a = "Hello";  // String Literal
		String x = "Hello";  // 1 or 0 
		String z = "hello";
		String d = new String("Hello");  // 2 or 1 object
		
		int e = 10;
		int r = 10;
		/*if(e==r){
			
		}*/
		//a1 = "bye";
		
		if(a==x){
			System.out.println("Same Ref");
		}
		else{
			System.out.println("Not Same ref");
		}
		a = "bye";
		if(a==x){
			System.out.println("Same Ref");
		}
		else{
			System.out.println("Not Same ref");
		}
		

	}

}
