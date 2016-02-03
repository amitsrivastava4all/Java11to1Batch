
public class StringMethods {

	public static void main(String[] args) {
		String a = "Hello";
		int e1 = 9090;
		String r = ((Integer)e1).toString();
		char singleChar = a.charAt(0);
		String w = String.valueOf(90.254540);
		System.out.println(w + 7878);
		System.out.println(w);
		System.out.println(singleChar);
		String e = new String("Hello");
		System.out.println(a.length());
		System.out.println(a.toLowerCase());
		System.out.println("Index "+a.indexOf("l"));
		System.out.println("index "+a.indexOf("a"));
		System.out.println(a.lastIndexOf("l"));
		String b = "Hello How are you";
		//b.indexOf("o")
		
		System.out.println(b.substring(2));
		System.out.println("SubString "+a.substring(2,4));
		String x = "Mr Ram Kumar";
		System.out.println(x.startsWith("Mr"));
		System.out.println(x.endsWith("Kumar"));
		System.out.println(x.contains("Ram"));
		String y = "      Mike   Peter      ";
		System.out.println("["+y.trim()+"]");
		System.out.println("["+y+"]");
		String address = "A-11/2, Shakti Nagar , Delhi-7";
		String array[]= address.split(",");
		for(String s : array){  // Java 1.5 (Enhance For Loop)
			System.out.println(s);
		}
		
		String p = "Hello";
		String q = new String("hello");
		if(p.equalsIgnoreCase(q)){
		//if(p.equals(q)){
			System.out.println("Same value");
		}
		else{
			System.out.println("not same value");
		}
		
		if(p==q){
		/*if(a==a.toUpperCase()){*/
			System.out.println("Same Ref");
		}
		else
		{
			System.out.println("Not Same Ref");
		}
		//System.out.println(a.toUpperCase());

	}

}
