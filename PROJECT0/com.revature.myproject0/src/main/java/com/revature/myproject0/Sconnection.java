package com.revature.myproject0;
import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.util.Properties;

	public class Sconnection {

	private static Connection conn = null;

	public static Connection getConnection() {
	Properties p = new Properties();
	try {
	FileReader reader = new FileReader("src/main/resources/Connection.properties");
	p.load(reader);
	String URL = p.getProperty("db.url");
	String port = p.getProperty("db.port");
	String db = p.getProperty("db.database");
	String user = p.getProperty("db.user");
	String pwd = p.getProperty("db.password");

	String DBURL = "jdbc:postgresql://" + URL + ":" + port + "/" + db+"?stringtype=unspecified";
	conn = DriverManager.getConnection(DBURL, user, pwd);

	} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	return conn;
	}
	}
	
	
	

