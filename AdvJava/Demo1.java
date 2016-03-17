import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

// Thread - Code in Execution is Called Thread
//class CopyJob extends Thread {
class CopyJob implements Runnable{
	private String sourceFileName;
	private String desFileName;
	// Job Logic is inside the Run method
	CopyJob(String sourceFileName,String desFileName){
		this.sourceFileName = sourceFileName;
		this.desFileName = desFileName;
	}
	public void run(){
		System.out.println("Start "+Thread.currentThread().getName());
		try{
		FileInputStream fi =new FileInputStream(sourceFileName);
		BufferedInputStream bi = new BufferedInputStream(fi,10);
		FileOutputStream fo = new FileOutputStream(desFileName);
		BufferedOutputStream bo = new BufferedOutputStream(fo,10);
		int singleChar = bi.read();
		//Thread.sleep(100);
		while(singleChar!=-1){
			bo.write(singleChar);
			singleChar = bi.read();
		}
		bi.close();
		bo.close();
		fo.close();
		fi.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		System.out.println("End "+Thread.currentThread().getName());
		/*for(int i = 1; i<=5 ; i++){
			System.out.println("I is "+i
					+" Thread "+Thread.currentThread().getName());
		}*/
	}
}
public class Demo1 {
	// Single Threaded 
	public static void main(String[] args) {
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				for(int i = 1; i<=5; i++){
					System.out.println("I is "+i);
				}
				
			}
		};
		Thread t1 = new Thread(runnable,"Thread1");
		t1.start();
		
		Thread t3 = new Thread(()->{
			for(int i = 1; i<=5; i++){
				System.out.println("I is "+i);
			}
		},"Thread3");
		t3.start();
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 1; i<=5; i++){
					System.out.println("I is "+i);
				}
				
			}
		});
		t2.start();
		
		CopyJob job = new CopyJob("E:\\TestThread\\A.wmv","E:\\TestThread\\A2.wmv");
		CopyJob job2 = new CopyJob("E:\\TestThread\\B.wmv","E:\\TestThread\\B2.wmv");
		//job.start();
		//job2.start();
		Thread worker1 =new Thread(job,"ram");
		worker1.setDaemon(true);
		//worker1.setPriority(Thread.MAX_PRIORITY);
		Thread worker2 =new Thread(job2,"shyam");
		//worker2.setPriority(Thread.MIN_PRIORITY);
		worker1.start(); // start will call run
		
		worker2.start(); 
		/*for(int i = 1; i<=5 ;i++){
			System.out.println("I is "+i+" "+Thread.currentThread());
		}*/

	}

}
