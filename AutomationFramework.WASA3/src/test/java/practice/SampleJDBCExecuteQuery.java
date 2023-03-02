package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {

	public static void main(String[] args) throws SQLException {
		
		//Driver for Mysql database
		Driver driverRef = new Driver();
		
		//Step 1: Register the driver
		DriverManager.registerDriver(driverRef);
		
		//Step 2: Get the connection from the database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wasa3db", "root", "root");
		
		//Step 3: Issue the create statement
		Statement state = con.createStatement();
		//Step 4: Execute a query
		ResultSet result = state.executeQuery("select * from candidateinfo");
		while(result.next()) {
			System.out.println(result.getString(1)+" "+result.getInt(2)+" "+result.getString(3));
		}
		
		//Step 5: close the database
        con.close();
        
        System.out.println("db close");
	}

}
