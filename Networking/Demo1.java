import java.net.InetAddress;
import java.net.UnknownHostException;


public class Demo1 {

	public static void main(String[] args) throws UnknownHostException {
		/*InetAddress ip = InetAddress.getLocalHost();
		System.out.println(ip.getHostAddress());
		System.out.println(ip.getHostName());*/
		InetAddress ips[] = InetAddress.getAllByName("www.yahoo.com");
		for(InetAddress i : ips){
			System.out.println(i.getHostAddress());
		}

	}

}
