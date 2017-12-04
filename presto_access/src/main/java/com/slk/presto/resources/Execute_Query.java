package com.slk.presto.resources;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.json.JSONObject;



public class Execute_Query {
	
	Connection connection;
	Statement stmt;
	public Execute_Query() {

		

		try {
			connection = DriverManager.getConnection(
					"jdbc:presto://10.41.2.16:9080/", "test", "");

			stmt = connection.createStatement();

		} catch (Exception e) {

		}

	}
	

	public JSONObject executeQuery(String query){
		
		try{
		 ResultSet rs = stmt.executeQuery(query);
			
		 System.out.println("Executed ...");
		 
		 
		ResultSetMetaData metaData = rs.getMetaData();
		
		
		int count = metaData.getColumnCount(); //number of column
		
		String columnName[] = new String[count];

		for (int i = 1; i <= count; i++)
		{
		   columnName[i-1] = metaData.getColumnLabel(i);
		   
		
		   System.out.println(columnName[i-1]);
		}
		
		
		  
		}catch (Exception e){
			
		}
	    

		return null;
		
		
		
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
