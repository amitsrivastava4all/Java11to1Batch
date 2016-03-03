import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class UserOperations {
	static{
		try {
			regUserList=getUsers();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	private static final String USER_PATH = "D:\\Images\\User.dat";
	private static ArrayList<User> regUserList =new ArrayList<User>();
public static boolean registerUser(User userObject) throws IOException{
	boolean isStore = false;
	FileOutputStream fo = new FileOutputStream(USER_PATH);
	ObjectOutputStream os = new ObjectOutputStream(fo);
	regUserList.add(userObject);
	for(User regUser: regUserList){
	os.writeObject(regUser);
	}
	os.close();
	fo.close();
	isStore = true;
	return isStore;
	
}
public static ArrayList<User> getUsers() throws ClassNotFoundException, IOException{
	ArrayList<User> userList = new ArrayList<User>();
	FileInputStream fi = new FileInputStream(USER_PATH);
	ObjectInputStream oi = new ObjectInputStream(fi);
	while(true){
		try{
		Object o = oi.readObject();
		userList.add((User)o);
		}
		catch(EOFException e){
			System.out.println("EOF Exception Reach "+userList);
			break;
		}
	}
	oi.close();
	fi.close();
	return userList;
}
public static boolean isUserExist(User searchUser) throws ClassNotFoundException, IOException{
	ArrayList<User> userList = getUsers();
	//boolean isFound = false;
	if(userList!=null && userList.size()>0){
		for(User userObject : userList){
			if(userObject.getUserid().equals(searchUser.getUserid()) && userObject.getPassword().equals(searchUser.getPassword())){
				return true;
				//isFound = true;
				//break;
			}
		}
	}
	/*else{
		isFound = false;
	}*/
	return false;
}
}
