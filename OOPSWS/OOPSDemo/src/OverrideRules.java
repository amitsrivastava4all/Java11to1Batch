// Weaker Access Rule
// Co-variant return type

class EE
{
	int p,q;
}
class EE2 extends EE{
	int r,t;
}
class T
{
	protected EE show(){
		System.out.println("T Show");
		EE obj = new EE();
		return obj;
	}
}
class T2 extends T{
	@Override
	  public EE2 show(){
		System.out.println("T2 Show");
		return new EE2();
	}
}
class T3 extends T2{
	
}
public class OverrideRules {

	public static void main(String[] args) {
		T2 obj = new T2();
		EE2 ee2 = obj.show();
		System.out.println(ee2.p+ " "+ee2.q+" "+ee2.r+" "+ee2.t);

	}

}
