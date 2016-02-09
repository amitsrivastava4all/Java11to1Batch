class Employee{
	private int id;
	private String name;
	private double salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
class MyNumber{
	int x,y,z;
}
class Dept
{
	int deptNo;
	String deptName;
	String managerName;
}
class CalculateSalary{
	double increase(double salary){
		salary = salary + 9090;
		System.out.println("Copy Salary "+salary);
		return salary;
	}
	/*int add(int x , int y , int z ){
		
	}
	int add(MyNumber obj){
		
	}*/
	Dept assignDept(Employee obj){
		Dept dept = new Dept();
		if(obj.getSalary()>9090){
			dept.deptName="IT";
			dept.deptNo=1001;
			dept.managerName="Ram";
		}
		else
		{
			dept.deptName="HR";
			dept.deptNo=1002;
			dept.managerName="Shyam";
		}
		return dept;
	}
	void generateSalary(Employee obj){
		System.out.println("Id "+obj.getId());
		System.out.println(" Name "+obj.getName());
		System.out.println(" Salary "+obj.getSalary());
		obj.setSalary(obj.getSalary()+ 9090);
	}
}
public class PassAndReturnObjectDemo {

	public static void main(String[] args) {
		Employee ram = new Employee();
		ram.setId(1001);
		ram.setName("Ram");
		ram.setSalary(9090);
		CalculateSalary cs = new CalculateSalary();
		cs.generateSalary(ram);
		
		System.out.println("Now Updated Salary "+ram.getSalary());
		double salary = ram.getSalary();
		double s =cs.increase(salary);
		System.out.println("(Orginial) Now Again Updated Salary "+salary);
		System.out.println("Return Salary Updated "+s);
		Dept dept = cs.assignDept(ram);
		System.out.println("Dept "+dept.deptNo+" "+dept.deptName+" "+dept.managerName);
	}

}
