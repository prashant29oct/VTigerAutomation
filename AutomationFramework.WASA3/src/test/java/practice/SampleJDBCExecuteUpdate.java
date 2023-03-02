package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	public static void main(String[] args) throws SQLException {
		
		Connection con=null;
		try {
		Driver driverRef = new Driver();
		
		//Step 1: register the driver
		DriverManager.registerDriver(driverRef);
		
		//Step 2: Get the connection from the database
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3db", "root", "root");
		
       //Step 3: issue create statement
		Statement state = con.createStatement();
		
	   //Step 4: execute a query
		String query = "insert into candidateinfo values('Virat',40,'Delhi');";
		int result = state.executeUpdate(query);
		if(result>=1) {
			System.out.println("data added");
		}
		ResultSet resul = state.executeQuery("select * from candidateinfo;");
		while(resul.next()) {
			System.err.println(resul.getString(1)+" "+resul.getInt(2)+" "+resul.getString(3));
		}
		}catch (Exception e) {
			
		}
		finally {
			con.close();
			System.out.println("db close");
		}
	
	}

}
