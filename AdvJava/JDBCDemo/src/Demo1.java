import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Demo1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Salary to Search....");
		String salary = scanner.nextLine();
		// Step - 1 Load Driver
		// PostGres -> org.postgresql.Driver
		// Oracle -> oracle.jdbc.driver.OracleDriver
		// MySQL -> com.mysql.jdbc.Driver
		String driverName = "com.mysql.jdbc.Driver"; 
		Class.forName(driverName);
		System.out.println("Driver (Class) Loaded...");
		// Step -2 Create Connection
		// Oracle --> jdbc:oracle:thin:@localhost:port:dbname
		// Mysql --> jdbc:mysql://hostname:port/dbname
		String url = "jdbc:mysql://localhost:3306/jdbc12to2d";
		String userid = "root";
		String password ="root";
		Connection con = DriverManager.getConnection(url,userid,password);
		if(con!=null){
			System.out.println("Connection Created...");
		}
		// Step -3 Do Query and Get the Result
		// Statement will do SQL Injection
		// Statement would not Cache
		
		// PreparedStatement (Cache + No SQL Injection)
		//Statement stmt = con.createStatement();
		PreparedStatement stmt = con.prepareStatement("select id,name,salary from emp where salary=?");
		stmt.setDouble(1, Double.parseDouble(salary));
		ResultSet rs = stmt.executeQuery("select id,name,salary from emp where salary="+salary);
		// Step -4 Loop Till there is Row , rs.next () will return true if there is row in a Database
		while(rs.next()){
			System.out.println("Id "+rs.getInt("id")+" name "+rs.getString("name")+" salary "+rs.getDouble("salary"));
		}
		// Step -5 Close all the Open Resources, and close first which will open last (LIFO)
		rs.close();
		stmt.close();
		con.close();
		// Here Connection is Interface and It is Implemented by the Driver Jar
		// And DriverMaager is the Class which is used to create Connection 
		

	}

}
