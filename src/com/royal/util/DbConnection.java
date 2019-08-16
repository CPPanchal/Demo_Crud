package com.royal.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;

import com.sun.xml.internal.fastinfoset.sax.Properties;

public class DbConnection {
	
	static Connection conn=null;
	private DbConnection()
	{
		
	}

	public static Connection getConnectionObj()
	{
		if (conn == null) 
		{
			conn = DbConnection.getConnection();
		}
		return conn;
	}

	private static Connection getConnection() {
		
		FileInputStream fin=null;
		java.util.Properties prop= new java.util.Properties();
		
		try {
			fin=new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\Demo_Crud\\WebContent\\dbconfig.properties");
			prop.load(fin);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		String urlName     = prop.getProperty("URLNAME").trim();
		String driverClass = prop.getProperty("DRIVERCLASS").trim();
		String userName    = prop.getProperty("USERNAME").trim();
		String password    = prop.getProperty("PASSWORD").trim();
		
	
		
		try {
			Class.forName(driverClass);
			conn=DriverManager.getConnection(urlName,userName,password);
			
			if(conn!=null)
			{
				System.out.println("Db Connected : " + conn);
			} else 
			{
				System.out.println("Db not Connected : " + conn);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	public static void main(String[] args) {
		
		getConnectionObj();
		
	}
	
}
