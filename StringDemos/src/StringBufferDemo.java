
public class StringBufferDemo {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("hello");
		//StringBuffer sb = new StringBuffer("hello");
		System.out.println(sb.length());
		System.out.println(sb.capacity());
		sb.append("How");
		System.out.println("After Append "+sb);
		sb.insert(2, "Hi");
		System.out.println("After Insert "+sb);
		sb.deleteCharAt(0);
		System.out.println("Single Char Delete "+sb);
		sb.delete(2, 4);
		System.out.println("Multiple Char Delete "+sb);
		StringBuffer s = new StringBuffer("Hello");
		System.out.println(s.reverse());
		System.out.println(s.toString());
		System.out.println(s.toString().toCharArray());
		byte b[] = s.toString().getBytes();
		System.out.println(b);

	}

}
