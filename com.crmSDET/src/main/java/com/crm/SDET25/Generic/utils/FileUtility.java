package com.crm.SDET25.Generic.utils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 * this property file will help to utilize the common data
 * @author shidlingappa
 *
 */

public class FileUtility {
	/**
	 * This method will help to access property file data 
	 * @param key
	 * @throws Exception
	 */
	public String readDataFromPropertyFile (String key) throws Exception {
		FileInputStream fis = new FileInputStream (IPathConstants.PROPERTY_PATH);
		Properties p= new Properties ();
		
		p.load(fis);
		
		  String value = p.getProperty(key);
		  return value;
			}
	
	/**
	 * This method will return value from the json file based on the key passed
	 * @param jsonKeyToPass
	 * @return
	 * @throws Throwable
	 */

	public String readDataFromJSON (String jsonKeyToPass) throws Throwable  {
		JSONParser parser = new JSONParser ();
		FileReader file = new FileReader (IPathConstants.JSON_PATH);		
		 Object object  = parser.parse(file);
		 JSONObject jonobj = (JSONObject) object;
		 return jonobj.get(jsonKeyToPass).toString();
	}
	
}
