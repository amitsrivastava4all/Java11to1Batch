import java.util.TreeSet;


public class SongDemo {

	public static void main(String[] args) {
		// It not take duplicate values + and it is sorted by default
		TreeSet ts  = new TreeSet();
		ts.add("it's my life");
		ts.add("it's my life");
		ts.add("bang bang");
		System.out.println(ts);
		

	}

}
