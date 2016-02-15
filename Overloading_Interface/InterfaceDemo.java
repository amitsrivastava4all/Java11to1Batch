// What to Do?
interface IPlayer{
	 int MAX_SPEED = 100;
	void run();
	void jump();
	void attack();
}

// How to DO?
class BlackPlayer implements IPlayer
{

	@Override
	public void run() {
		System.out.println("Black Player Run Fast....");
		
	}

	@Override
	public void jump() {
		System.out.println("Black Player Jump Average");
		
	}

	@Override
	public void attack() {
		System.out.println("Black Player Attack by Guns");
		
	}
	
}
class RedPlayer implements IPlayer{

	@Override
	public void run() {
		System.out.println("Red Player Run Average....");
		
	}

	@Override
	public void jump() {
		System.out.println("Red Player Jump High....");
		
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}
	
}
class GreenPlayer{
	
}
public class InterfaceDemo {

	public static void main(String[] args) {
		//IPlayer obj = new BlackPlayer();

	}

}
