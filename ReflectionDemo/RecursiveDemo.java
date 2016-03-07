
public class RecursiveDemo {
static int x = 1;
	static void print1to10(){
	if(x<=10){
		System.out.println(x);
		x++;
		print1to10();
	}
}
	public static void main(String[] args) {
		print1to10();

	}

}
