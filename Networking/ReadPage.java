import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class ReadPage {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://cdn.xyt.desi/Filmywap/videos/mp4/Bollywood%20Movie/Brothers_2015_DvDRip_HD_Rip1_by_-Filmywap.mp4");
		FileOutputStream fo = new FileOutputStream("D:\\Images\\video.mp4");
		URLConnection con = url.openConnection();
		con.connect();
		InputStream is = con.getInputStream();
		int singleByte = is.read();
		while(singleByte!=-1){
			fo.write(singleByte);
			System.out.print((char)singleByte);
			singleByte = is.read();
		}
		is.close();
		
		

	}

}
