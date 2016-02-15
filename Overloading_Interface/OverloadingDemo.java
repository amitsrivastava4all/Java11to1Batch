class Overloading
{
	public int search(int exp){
		System.out.println("Exp ");
		return 0;
	}
	protected double search(String companyName){
		System.out.println("Company ");
		return 0.0;
	}
	String search(String companyName, double salary){
		System.out.println("Company + Salary");
		return null;
	}
}
public class OverloadingDemo {

	public static void main(String[] args) {
		Overloading o = new Overloading();
		o.search(10);
		o.search("HCL");
		o.search("HCL", 88989);

	}

}
