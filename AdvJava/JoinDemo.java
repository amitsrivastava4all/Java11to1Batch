class Print{
	static int x;
	static void print(){
		for(int i = 1; i<=5 ; i++){
			
			x++;
			System.out.println("X Is "+x+" I is "+i+" Thread "+Thread.currentThread().getName()+" "+Thread.currentThread().isAlive());
						
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class Job implements Runnable{
	Print print = new Print();
	Print print2 = new Print();
	public  void run(){
		synchronized (Print.class) {
			
		Print.print();
		//synchronized (print) {
			//print.print();
		}
		System.out.println("***********************");
		print2.print();
	}
}
public class JoinDemo {

	public static void main(String[] args) throws InterruptedException {
		Job job = new Job();
		Thread worker1 = new Thread(job,"t1");
		Thread worker2 = new Thread(job,"t2");
		Thread worker3 = new Thread(job,"t3");
		worker1.start();
		worker1.resume();
		//worker1.stop();
		//worker1.join();
		worker2.start();
		//worker3.start();

	}

}
