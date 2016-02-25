import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public interface FileOperations {

	public static String writeOperation(String path, String data) throws IOException{
		String result = "Can't Write this File ";
		FileOutputStream fo = new FileOutputStream(path); // File Path Open
		byte b[] = data.getBytes();  // Convert data into byte form
		fo.write(b); // then write the data
		fo.close(); // then close the file
		result = "Data Write in a File";
		return result;
		
	}
	
	public static String readOperation(String path) throws IOException{
		File file =new File(path);
		final int EOF = -1;
		StringBuilder sb = new StringBuilder();
		if(file.exists()){
			FileInputStream fi = new FileInputStream(file);
			int singleByte = fi.read();
			while(singleByte!=EOF){
				sb.append((char)singleByte);
				singleByte = fi.read();
			}
			fi.close();
		}
		else{
			return "Not Able to read this file , Kindly check the path ";
		}
		
		return sb.toString();
	}
	


}
