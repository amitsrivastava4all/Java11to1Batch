import java.util.HashSet;

// Set Demo
class Employee{
	private int id;
	private String name;
	private double salary;
	
	Employee(int id , String name, double salary){
		this.id = id;
		this.name = name;
		this.salary =salary;
	}
	@Override
	public String toString(){
		return "Id "+id+ " Name "+name+" Salary "+salary;
	}
	// Search the Right Bucket
	@Override
	public int hashCode(){
		return name.length();
	}
	// Search the Right Value in A Bucket
	public boolean equals(Object o){
		Employee e = (Employee)o;
		if(this.id==e.id && this.name.equals(e.name) && this.salary==e.salary){
			return true;
		}
		else
		{
			return false;
		}
	}
}
public class SetDemo {

	public static void main(String[] args) {
		HashSet<Employee> hs = new HashSet<>();
		Employee ram = new Employee(1001, "Ram", 9090);
		hs.add(ram);
		Employee raj = new Employee(1001, "Ram", 9090);
		hs.add(raj);
		Employee shyam = new Employee(1002, "Shyam", 9090);
		hs.add(shyam);
		Employee ram1 = new Employee(1001, "Ram", 9090);
		hs.add(ram1);
		System.out.println(hs);
		System.out.println(ram.hashCode());
		System.out.println(ram1.hashCode());
		System.out.println(raj.hashCode());
		System.out.println(shyam.hashCode());

	}

}
