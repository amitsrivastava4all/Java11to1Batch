import java.io.Serializable;


public class User implements Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String userid;
private String password;
private String email;
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

}
