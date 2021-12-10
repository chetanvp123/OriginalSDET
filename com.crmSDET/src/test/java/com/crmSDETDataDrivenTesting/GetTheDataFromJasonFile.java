package com.crmSDETDataDrivenTesting;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

public class GetTheDataFromJasonFile {
	@Test
	public void getData  () throws Throwable {
		
		JSONParser parser = new JSONParser  ();
		FileReader reader = new FileReader ("./data/value.json");
		Object object = parser.parse(reader);
		JSONObject jsonobj = (JSONObject) object;
		
		String browserName = jsonobj.get("browser").toString();
		String url = jsonobj.get("url").toString();
		String username = jsonobj.get("username").toString();
		String password = jsonobj.get("password").toString();
		
		System.out.println(browserName);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);  
		
		/* FileUtility fUtil = new FileUtility ();
		System.out.println(fUtil.readDataFromJSON("browser"));
		System.out.println(fUtil.readDataFromJSON("url"));
		System.out.println(fUtil.readDataFromJSON("username"));
		System.out.println(fUtil.readDataFromJSON("password"));   */
	}

}