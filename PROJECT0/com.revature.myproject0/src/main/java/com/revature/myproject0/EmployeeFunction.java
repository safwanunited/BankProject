package com.revature.myproject0;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmployeeFunction {

	private static final Logger logger = LogManager.getLogger(EmployeeFunction.class);
		private static Scanner sc;

		public static void Accept() {
		try {
		sc = new Scanner(System.in);
		System.out.println("NAME :");
		String name=sc.next();
		System.out.println("ACCOUNT NO:");
		long acntno=sc.nextLong();
		System.out.println("1.ACCEPT \n 2.REJECT...?");
		int a=sc.nextInt();
		if(a==1) {
		System.out.println("ACCEPTED "+name+"'S ACCOUNT ");
		}
		else if(a==2) {
		   Connection con5=Sconnection.getConnection();
		   Statement st = con5.createStatement();    
		        String sql1 = "DELETE FROM CUSTOMERTAB WHERE acntno="+acntno;
		        st.executeUpdate(sql1);
	
		        System.out.println(" REJECTED "+name+"'S ACCOUNT ");
		}
		else {
		System.out.println("INVALID CHOICE...TRY AGAIN");
		}
		}catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getLocalizedMessage());
		}
		}
		
	
		public static void logs() {
			 File file = new File("C:\\mylogs\\mylog.log");
			 BufferedReader br;
			try {
			br = new BufferedReader(new FileReader(file));
			String st;
			System.out.println("LOG FILE: ");
			while ((st = br.readLine()) != null)
			   System.out.println(st);
			} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			}
public static void view() {
	
	
	 Connection con=Sconnection.getConnection();
	 try {
			String sql= "SELECT * FROM customertab"; 
		
			Statement statement = con.createStatement(); 
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) 
			{
				System.out.println(" "+resultSet.getLong(1)+" "+resultSet.getString(2)+"  "+resultSet.getString(3)+"  "+resultSet.getDouble(4));
				
			
			}
			
	   }catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
			}
	    
	
	
}
	
	
	
	
	
	
	


		public static Logger getLogger() {
			return logger;
		}
	
	
		public static int login() {
			try  {
			    sc = new Scanner(System.in);
			Connection con3=Sconnection.getConnection();
			System.out.print("Employee name:");
			String uid=sc.next();
			
			System.out.print("ENTER YOUR PASSWORD:");
			String pwd=sc.next();
			
			String sql= "SELECT password FROM emp WHERE ename="+"'"+uid+"'" ;
			Statement statement = con3.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next())
			{
			//System.out.println(resultSet.getString(1));
			if(resultSet.getString(1).equals(pwd)) {
			return 1;
			}
			else {
			return 0;
			}
			}
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getLocalizedMessage());
			System.out.println("SERVER ERROR...");
			}
			return 0;
			}


	
	
	

}
