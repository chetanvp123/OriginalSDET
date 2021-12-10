package com.crmSDETDataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.testng.annotations.Test;
import com.mysql.cj.jdbc.Driver;

@Test
public class JDBCExecuteQueryUpdate {
	
	public void Update () throws Exception  {
	
	Driver driver= new Driver ();
	DriverManager.registerDriver(driver);
	
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsdb", "root", "root");
	
	
	Statement stat = conn.createStatement();
	
	int result = stat.executeUpdate("insert into studentinfo values ('Messi',18,'Barcelona')");
	
	if (result==1)  {
		System.out.println("data created");
	}
	else  {
		System.out.println("not created");
	}
	
	conn.close();

	}
}