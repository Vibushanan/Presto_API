package com.slk.presto.resources;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class Execute_Query {
	
	
	public void Execute_Query(String query){
		
		Connection connection;
		Statement stmt;
		
		
		try {
			connection = DriverManager.getConnection("jdbc:presto://10.41.2.16:9080/","test","");
		  
		 stmt = connection.createStatement();
		 ResultSet rs = stmt.executeQuery(query);
		 
	
		}catch (Exception e){
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
