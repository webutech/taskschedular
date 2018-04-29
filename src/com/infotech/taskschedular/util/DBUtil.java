package com.infotech.taskschedular.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;

public class DBUtil {

	private Connection con = null;
	private PreparedStatement pstmt = null;
	private Properties properties;
	private FileInputStream fileInput;
	
	public DBUtil() throws FileNotFoundException {
//		try {
			
//			FileReader reader = new FileReader("DBProperties.properties");
		//	Properties p = new Properties();
//			Properties p = new Properties();
//			p.load(reader);
			
//			String driver=p.getProperty("driver");
			
//			Class.forName(driver);
		
//		} catch (ClassNotFoundException | IOException e) {
			
//			e.printStackTrace();
//		}
	}
	
	private Connection connect() throws IOException{
		try {
			con = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"),properties.getProperty("password"));
			System.out.println("connection created"+properties.getProperty("url")+" "+properties.getProperty("username")+" "+properties.getProperty("password"));
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		fileInput.close();
		return con;
	}
	
	public PreparedStatement getPrepareStatement(String sql) throws IOException{
		try {
			pstmt = connect().prepareStatement(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return pstmt;
	}
	
	private void closeConnection(){
		try {
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void closePrepareStatement(){
		try {
			closeConnection();
			pstmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		DBUtil db = new DBUtil();
		db.connect();
	}
}
