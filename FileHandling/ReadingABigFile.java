import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class ReadingABigFile {
static void slowReadWrite(String readPath, String writePath) throws IOException{
	File file  = new File(readPath);
	FileInputStream fi = new FileInputStream(file);
	FileOutputStream fo = new FileOutputStream(writePath);
	int singleChar = fi.read();
	while(singleChar!=-1){
		fo.write(singleChar);
		singleChar = fi.read();
	}
	fi.close();
	fo.close();
}
static void fastReadWrite(String readPath, String writePath) throws IOException{
	File file  = new File(readPath);
	FileInputStream fi = new FileInputStream(file);
	BufferedInputStream bi = new BufferedInputStream(fi);
	FileOutputStream fo = new FileOutputStream(writePath);
	BufferedOutputStream bo  = new BufferedOutputStream(fo);
	int singleChar = bi.read();
	while(singleChar!=-1){
		bo.write(singleChar);
		singleChar = bi.read();
	}
	bi.close();
	bo.close();
	fi.close();
	fo.close();
}
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		//slowReadWrite("D:\\Images\\WorldCup.jpg","D:\\Images\\WorldCup2.jpg");
		fastReadWrite("E:\\UI-Stuff\\Html5_Project\\WebContent\\video\\elephants-dream.webm","E:\\UI-Stuff\\Html5_Project\\WebContent\\video\\elephants-dreamcopy.webm");
		long endTime =System.currentTimeMillis();
		System.out.println("Total Time Taken "+(endTime-startTime));

	}

}
