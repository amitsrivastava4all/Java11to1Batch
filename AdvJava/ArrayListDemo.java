import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ArrayListDemo {

	public static void main(String[] args) {
		Integer x[] = {1000,4444,2222,5555};
		List<Integer> l2 = Arrays.asList(x);
		ArrayList<Integer> l = new ArrayList<>();
		l.add(10);  // add
		l.add(20);
		l.add(30);
		l.add(2);
		l.add(5);
		
		l.add(0,110);  // add index wise
		
		//l.add("Hello");
		//int x = l.get(0);  // read index wise
		System.out.println(l);
		l.remove(0);
		if(l.contains(20)){
			System.out.println("Found");
		}
		else
		{
			System.out.println("NOt Found");
		}
		l.set(0,900);
		
		Collections.sort(l);
		System.out.println(l.size());
		l.addAll(l2);
		l.clear();
		//l2.remove(0);
		//l.removeAll(l2);
		System.out.println("After Sort "+l);
		Collections.reverse(l);
		Collections.binarySearch(l, 100);
		

	}

}
