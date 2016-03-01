import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	 String name;
	private double salary;
	Employee(int id, String name , double salary){
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public String toString(){
		return "Id "+id+" Name "+name +" Salary "+salary;
	}
}
public class ReadingWritingMultipleObject {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		/*FileOutputStream fo = new FileOutputStream("D:\\Images\\Emp.dat",true);
		ObjectOutputStream os = new ObjectOutputStream(fo);
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("Enter the Empno");
			int id = scanner.nextInt();
			System.out.println("Enter the Name");
			String name = scanner.next();
			System.out.println("Enter the Salary");
			double salary = scanner.nextDouble();
			Employee emp = new Employee(id, name, salary);
			os.writeObject(emp);
			System.out.println("DO U want to Add More Records Y or N ");
			String choice = scanner.next();
			if(choice.equalsIgnoreCase("N")){
				break;
			}
		}
		os.close();
		fo.close();
		scanner.close();*/
		
		//Reading
		ArrayList<Employee> empList = new ArrayList<Employee>();
		FileInputStream fi = new FileInputStream("D:\\Images\\Emp.dat");
		ObjectInputStream oi = new ObjectInputStream(fi);
		while(true){
			try{
			Object obj = oi.readObject();
			empList.add((Employee)obj);
			}
			catch(EOFException e){
				System.out.println("EOF Reach...");
				break;
			}
		}
		System.out.println("Now Records Are "+empList);
		boolean isFound = false;
		Employee w = empList.get(0);
		for(Employee e : empList){
			if(e.name.equals("Mike")){
				System.out.println("Name Found ....");
				isFound = true;
				break;
			}
		
		}
		if(!isFound){
			System.out.println("name Not Found...");
		}
		oi.close();
		fi.close();

	}

}
