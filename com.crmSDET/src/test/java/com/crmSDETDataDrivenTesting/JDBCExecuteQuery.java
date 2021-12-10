package com.crmSDETDataDrivenTesting;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;
import com.mysql.cj.jdbc.Driver;

@Test
public class JDBCExecuteQuery {
	
	public void Query () throws Exception {
		//1. Register the manager
		Driver driverref = new Driver ();
		DriverManager.registerDriver(driverref);
		
		//2.connect to the server
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsdb", "root", "root");
		
		// 3. create statement
		Statement stat = conn.createStatement();
		
		//4. get the result 
		 ResultSet result = stat.executeQuery("select * from studentinfo;");
		 
		 while (result.next())  {
			 System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		 }
		 //5. close the dataBase
		 conn.close();
	}

}
