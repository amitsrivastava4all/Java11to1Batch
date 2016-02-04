import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

import org.apache.log4j.Logger;


public class ThrowThrowsAndFinally {
	Logger logger = Logger.getLogger(ThrowThrowsAndFinally.class);
	void db() throws SQLException {//throws SQLException{
		logger.debug("DB Code Start....");
		System.out.println("Connection Open");
		System.out.println("DB Query");
		try{
		if(100>20){
			throw new SQLException();
	/*	try {
			throw new SQLException();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Problem in DB Level "+e);
		}*/
		}
		System.out.println("GET RESULT ");
		}
		finally{
		System.out.println("DB Close");  // Always Execute (Clean Up Code)
		
		}
		logger.debug("DB Code Ends....");
	}
	void bl()throws SQLException{
		logger.debug("BL Code Start....");
		System.out.println("LOGIC Start");
		System.out.println("DB CALL ");
		db();
		System.out.println("DB RESULT FETCH ");
		System.out.println("MASSAGING (011 to Delhi)");
		System.out.println("Logic Ends");
		logger.debug("BL Code END....");
	}
	void ui(){
		logger.debug("UI Code Start....");
		System.out.println("UI Call Start ");
		System.out.println("UI Call BL ");
		//bl();
		try {
			bl();
		} catch (SQLException e) {
			System.out.println("SOME DB PROBLEM ARISE **************************");
			
			//System.out.println("Exception Caught "+e);
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			logger.error("Exception Caught "+sw.toString());
			//e.printStackTrace();
		}
		System.out.println("UI GET BL RESULT");
		System.out.println("PRINT RESULT");
		System.out.println("UI COde eNDS");
		logger.debug("UI Code ENDS");
	}
	public static void main(String[] args) {
		ThrowThrowsAndFinally obj = new ThrowThrowsAndFinally();
		//for(int i = 1 ; i<100000; i++){
		obj.ui();
		//}
	}

}
