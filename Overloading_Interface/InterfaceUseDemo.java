//SAM
@FunctionalInterface
interface RR
{
	void disp();
}
interface Adder{
	int add(int x, int y);
}
//1st Way
class WW implements RR
{
	@Override
	public void disp(){
		System.out.println("WW Disp");
	}
}
public class InterfaceUseDemo {

	public static void main(String[] args) {
		/*WW obj = new WW();
		obj.disp();*/
		// Anonymous Class (2nd Way)
		RR obj = new RR(){
			@Override
			public void disp(){
				System.out.println("RR Disp");
			}
		};
		obj.disp();
		// 3rd Way (Lambda Expression) (2013)
		RR obj2 = ()->{
			System.out.println("RR Lambda Call");
		};
		
		Adder obj4 = (a,b)->a+b;
		System.out.println(obj4.add(100,200));

	}

}
