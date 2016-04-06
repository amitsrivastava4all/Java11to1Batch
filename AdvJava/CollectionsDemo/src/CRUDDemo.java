import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;
// Multi Sort
class SortById implements Comparator<Customer>{

	@Override
	public int compare(Customer This, Customer that) {
		// TODO Auto-generated method stub
		return ((Integer)This.getId()).compareTo((Integer)that.getId());
	}
	
}
class SortByName implements Comparator<Customer>{

	@Override
	public int compare(Customer This, Customer that) {
		// TODO Auto-generated method stub
		return This.getName().compareTo(that.getName());
	}
	
}
class SortByCity implements Comparator<Customer>{

	@Override
	public int compare(Customer This, Customer that) {
		// TODO Auto-generated method stub
		return This.getCity().compareTo(that.getCity());
	}
	
}
class Customer implements Comparable<Customer>
//implements Comparable
{
	private int id;
	private String name;
	private String city;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCity() {
		return city;
	}
	Customer(int id , String name , String city){
		this.id = id;
		this.name = name;
		this.city = city;
	}
	// toString - When Ever any Object is Get Print it will by default call toString of Object class
	// and Object class toString by default print classname@hashCode
	// which is meaning less for us
	// that's why we override to String so we can print meaning ful information of an Object
	@Override
	public String toString(){
		return "Id "+id +" Name "+name+" City "+city;
	}
	@Override
	public boolean equals(Object o){
		boolean isFound = false;
		Customer customer = (Customer)o;  // Downcasting
		if(this.id>0){
			if(this.id == customer.id){
				isFound = true;
			}
		}
		if(this.name!=null && !this.name.equalsIgnoreCase("no")){
			if(this.name.equals(customer.name)){
				isFound = true;
			}
		}
		if(this.city!=null && !this.city.equalsIgnoreCase("no"))
		if( this.city.equals(customer.city)){
			isFound= true;
		}
		return isFound;
	}
	/*@Override
	public int compareTo(Object o) {
		Customer that = (Customer)o;
		// TODO Auto-generated method stub
		return this.name.compareTo(that.name);
	}*/
	@Override
	public int compareTo(Customer that) {
		// TODO Auto-generated method stub
		//return this.name.compareToIgnoreCase(that.name); //ascending order
		return that.name.compareToIgnoreCase(this.name); //desc order
	}
	
}
public class CRUDDemo {

	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	ArrayList<Customer> customerList = new ArrayList<>();
	
	while(true){
		System.out.println("1. Add ");
		System.out.println("2. Delete");
		System.out.println("3. Search");
		System.out.println("4. Print");
		System.out.println("5. Update");
		System.out.println("6. Sort");
		System.out.println("7. Exit");
		System.out.println("Enter the Choice");
		int choice = scanner.nextInt();
		if(choice == 1){
		System.out.println("Enter the Id ");
		int id = scanner.nextInt();
		System.out.println("Enter the Name");
		String name = scanner.next();
		System.out.println("Enter the City");
		String city = scanner.next();
		Customer customerObject = new Customer(id,name,city);
		customerList.add(customerObject);
		System.out.println("After Add Records are "+customerList);
		}
		else
		if(choice == 2){	
			
		}
		else
		if(choice == 3){
			System.out.println("At Least Provide One Value");
			System.out.println("Enter the Id to Search Type 0 for Nothing ");
			int id = scanner.nextInt();
			System.out.println("Enter the Name to Search Type No for Nothing");
			String name = scanner.next();
			System.out.println("Enter the City to Search Type No for Nothing");
			String city = scanner.next();
			Customer searchObject = new Customer(id,name,city);
			if(customerList.contains(searchObject)){
				System.out.println("Found...");
			}
			else
			{
				System.out.println("Not Found...");
			}
		}
		else
		if(choice==4){	
			// 1st Way
			System.out.println("1st Way of Printing Simple For Loop");
			for(int i = 0 ; i<customerList.size(); i++){
				System.out.println(customerList.get(i));
			}
			// Java 1.5
			System.out.println("2nd Way of Printing Enhance For Loop");
			for(Customer c : customerList){
				System.out.println(c);
			}
			// Java 1.4
			System.out.println("3rd Way of Printing Iterator");
			Iterator<Customer> iterator = customerList.iterator();
			while(iterator.hasNext()){
				System.out.println(iterator.next()); //print the current element and then move to the next element
				//iterator.remove();
			}
			System.out.println("4th Way of Printing ListIterator");
			ListIterator<Customer> listIterartor = customerList.listIterator();
			while(listIterartor.hasNext()){
				System.out.println(listIterartor.next());
			}
			while(listIterartor.hasPrevious()){
				System.out.println(listIterartor.previous());
			}
			System.out.println("5th Way");
			// Java 1.8
			customerList.forEach((c)->System.out.println(c));
		}
		else
		if(choice == 6){	
			//Collections.sort(customerList); //By Default it call Comparable Sort
			//Collections.sort(customerList,new SortByCity());  // now comparator
			/*Collections.sort(customerList,new Comparator<Customer>() {
			@Override
				public int compare(Customer first, Customer second){
				return first.getCity().compareTo(second.getCity());
			}
			});*/
			Collections.sort(customerList,(first,second)->first.getCity().compareTo(second.getCity()));
			System.out.println("After Sort "+customerList);
		}
		else
		if(choice == 7){	
			break;
		}
	}
	

	}

}
