
public class VarArgs {
public static int add( int ...x){
	int sum =0;
	for(int d : x){
		sum = sum + d;
	}
	return sum;
}
	public static void main(String[] args) {
		System.out.println(add());
		System.out.println(add(10,20));
		System.out.println(add(10,20,30));
		System.out.println(add(10,20,30,40,50));

	}

}
