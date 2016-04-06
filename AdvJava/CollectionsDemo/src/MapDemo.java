import java.util.ArrayList;
import java.util.HashMap;


public class MapDemo {

	public static void main(String[] args) {
		HashMap<String,ArrayList<Integer>> phoneMap = new HashMap<>();
		ArrayList<Integer> amitPhone = new ArrayList<>();
		amitPhone.add(2222);
		amitPhone.add(1222);
		amitPhone.add(3222);
		phoneMap.put("amit",amitPhone);
		/*phoneMap.put("amit",2222);
		phoneMap.put("ram",3333);
		phoneMap.put("ram",4444);*/
		//System.out.println(phoneMap.get("ram"));
		//System.out.println(phoneMap.remove("ram"));
		System.out.println(phoneMap);

	}

}
