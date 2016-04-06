import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InsertDemo {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String driverName = "com.mysql.jdbc.Driver"; 
		Class.forName(driverName);
		String url = "jdbc:mysql://localhost:3306/jdbc12to2d";
		String userid = "root";
		String password ="root";
		Connection con = DriverManager.getConnection(url,userid,password);
		PreparedStatement stmt = con.prepareStatement("insert into emp(id,name,salary) values(?,?,?)");
		stmt.setInt(1, 1009);
		stmt.setString(2, "Jim");
		stmt.setDouble(3, 6666);
		int recCount = stmt.executeUpdate();
		if(recCount>0){
			System.out.println("Record Added..");
		}
		else
		{
			System.out.println("Not Added..");
		}
		stmt.close();
		con.close();
		

	}

}
