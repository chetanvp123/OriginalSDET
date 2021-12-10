package com.crmSDETDataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteFinallyJDBC {
	@Test

	
	public void finaly () throws Exception  {
		Connection conn = null;
		
		try {
			
		Driver driv = new Driver ();
		DriverManager.registerDriver(driv);
		
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root", "root");
		
		Statement stat = conn.createStatement();
		
		 ResultSet result = stat.executeQuery("select * fr   employeeinfo"); 
		
		 while (result.next())   {
			System.out.println(result.getString(1+" /t"+result.getString(2+" /t"+result.getString(3))));
		 }
		}
		
		catch  (Exception e) {
			
		}
	
		finally {
		conn.close();   }
	}  }
