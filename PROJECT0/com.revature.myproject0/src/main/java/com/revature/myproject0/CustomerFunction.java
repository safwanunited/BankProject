package com.revature.myproject0;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CustomerFunction {
	
	private static final Logger logger = LogManager.getLogger(CustomerFunction.class);
	
	
	private static Scanner scanner;
	private static int acntno;
	static double amnt=0;
	private static ResultSet resultSet1;
	private static Scanner sc;

	@SuppressWarnings("deprecation")
	public static long deposit() {
		
		  Connection con=null;
		  double deposit=0;int i=0;
		 
		   con=Sconnection.getConnection();
		   System.out.println("Connected to database succesfully");
		   try {
				
				System.out.println("ENTER THE ACCOUNT NUMBER");
				scanner = new Scanner(System.in);
				acntno = scanner.nextInt();
			
				do {
					
					if(i>0) {
						System.out.println("CANNOT DEPOSIT NEGATIVE AMOUNT");

					}
					
					System.out.print("AMOUNT TO BE DEPOSITED:");
				 deposit= scanner.nextDouble();
				i++;
				
				}while(deposit<0);
				
				String sql= "SELECT balance FROM customertab WHERE acntno="+acntno;
				Statement statement = con.createStatement(); 
				ResultSet resultSet = statement.executeQuery(sql);
				while (resultSet.next()) 
				{
				amnt=resultSet.getDouble(1)+deposit;
				logger.info(acntno+" deposited " + deposit);
				}
				
				
				String sql3= "update customertab set balance="+amnt+" where acntno="+acntno;
				Statement stmt1 = con.createStatement();
				stmt1.executeUpdate(sql3);
				logger.entry();

				
				
				
				System.out.println("DEPOSITED SUCCESSFULLY");
				logger.exit();
				//con.close();
				} catch (SQLException e) {
				System.out.println(e.getLocalizedMessage());
				}
		   		return acntno;
	}
	
	
	
	
	
	
	@SuppressWarnings("deprecation")
	public static long withdraw() {
		
		  Connection con=null;
		 
		   con=Sconnection.getConnection();
		   System.out.println("Connected to database succesfully");
		   try {
				//PreparedStatement stmt;
				System.out.println("ENTER THE ACCOUNT NUMBER");
				scanner = new Scanner(System.in);
				acntno = scanner.nextInt();
				
				
				
				
		double deposit=0;
		int i=0;
		do {
					
					
					if(i>0) {
						System.out.println("CANNOT DEPOSIT NEGATIVE AMOUNT");

					}System.out.print("AMOUNT TO BE WITHDRAWN:");
				 deposit= scanner.nextDouble();
				i++;
				
				}while(deposit<0);
				
				String sql= "SELECT balance FROM customertab WHERE acntno="+acntno;
				Statement statement = con.createStatement(); 
				ResultSet resultSet = statement.executeQuery(sql);
				while (resultSet.next()) 
				{
					double bal=resultSet.getDouble(1);
					bal=bal-1000;
					if(bal<deposit) {
						System.out.println("INSUFFICICNET BALANCE...CHECK YOUR BALANCE AND TRY AGAIN ...");
						System.out.println("---------------------------------------------------------------------");
						statement.close();
					}
				amnt=resultSet.getDouble(1)-deposit;
				logger.info(acntno+" withdrawn " + amnt);
				}
				
				
				String sql3= "update customertab set balance=" + amnt + "where acntno="+acntno;
				Statement stmt1 = con.createStatement();
				stmt1.executeUpdate(sql3);
				//logger.entry();


				
				
			
				System.out.println("WITHDRAWN SUCCESSFULLY");
			
				logger.exit();
				con.close();

				} catch (SQLException e) {
				System.out.println(e.getLocalizedMessage());
				}
		   return acntno;
	}
	
	
	@SuppressWarnings("deprecation")
	public static long transfer() {
		
		  Connection con=null;
		 
		   con=Sconnection.getConnection();
		   System.out.println("Connected to database succesfully");
		   try {
			   
			   System.out.println("ENTER THE ACCOUNT NUMBER");
				scanner = new Scanner(System.in);
				acntno = scanner.nextInt();
				System.out.print("ENTER THE AMOUT TO BE TRANSFERED");
				double deposit= scanner.nextDouble();
				String sql= "SELECT balance FROM customertab WHERE acntno="+acntno;
				Statement statement = con.createStatement(); 
				ResultSet resultSet = statement.executeQuery(sql);
				while (resultSet.next()) 
				{
					double bal=resultSet.getDouble(1);
					bal=bal-1000;
					if(bal<deposit) {
						System.out.println("INSUFFICICNET BALANCE...CHECK YOUR BALANCE AND TRY AGAIN ...");
						System.out.println("---------------------------------------------------------------------");
						statement.close();
					}
					
					
					
					
				amnt=resultSet.getDouble(1)-deposit;
				
				}
				
				
				String sql3= "update customertab set balance=" + amnt + "where acntno="+acntno;
				Statement stmt1 = con.createStatement();
				stmt1.executeUpdate(sql3);
				

				
				
				
				//System.out.println("TRANSFER SUCCESSFULLY");
			   
			   
			   
			   
			   
			   
			   
			   
		
				System.out.println("ENTER THE ACCOUNT NUMBER OF THE RECEIVER");
				scanner = new Scanner(System.in);
				int acntno1 = scanner.nextInt();
				String sql1= "SELECT balance FROM customertab WHERE acntno="+acntno1;
				Statement statement1 = con.createStatement(); 
				resultSet1 = statement1.executeQuery(sql1);
				while (resultSet1.next()) 
				{
				amnt=resultSet1.getDouble(1)+deposit;
				//logger.info(acntno+" LOGGER TRANSFER " + amnt);
				}
				
				
				String sql4= "update customertab set balance="+amnt+" where acntno="+acntno1;
				con.createStatement();
				stmt1.executeUpdate(sql4);
				logger.info(acntno+" LOGGER TRANSFER " + amnt);
				logger.entry();
				
				
				
				System.out.println("TRANSFERRED SUCCESSFULLY");

				
				
				
				
				logger.exit();
				//con.close();
				
				
				} catch (SQLException e) {
				System.out.println(e.getLocalizedMessage());
				}
		   return acntno;
	}
	
	public static void balance() {
		
		  Connection con=null;
		 
		   con=Sconnection.getConnection();
		   System.out.println("Connected to database succesfully");
		   try {
			   
			   System.out.println("ENTER THE ACCOUNT NUMBER");
				scanner = new Scanner(System.in);
				acntno = scanner.nextInt();
				String sql= "SELECT balance FROM customertab WHERE acntno="+acntno;
				Statement statement = con.createStatement(); 
				ResultSet resultSet = statement.executeQuery(sql);
				while (resultSet.next()) 
				{
					System.out.println("YOUR BALANCE IS "+resultSet.getDouble(1));
					
				
				}
				
		   }catch (SQLException e) {
				System.out.println(e.getLocalizedMessage());
				}
				
				
				
		   }






	public static void balance(long temp) {
		
		  Connection con=null;
		 
		   con=Sconnection.getConnection();
		   System.out.println("Connected to database succesfully");
		   try {
				String sql= "SELECT balance FROM customertab WHERE acntno="+temp;
				Statement statement = con.createStatement(); 
				ResultSet resultSet = statement.executeQuery(sql);
				while (resultSet.next()) 
				{
					System.out.println("YOUR BALANCE IS "+resultSet.getDouble(1));
					
				
				}
				
		   }catch (SQLException e) {
				System.out.println(e.getLocalizedMessage());
				}
				
				
				
		   }






	public static int login() {
		try  {
		    sc = new Scanner(System.in);
		Connection con3=Sconnection.getConnection();
		System.out.print("ENTER YOUR ACCOUNT NUMBER:");
		long uid=sc.nextLong();
		
		System.out.print("ENTER YOUR PASSWORD:");
		String pwd=sc.next();
		
		String sql= "SELECT password FROM customertab WHERE acntno="+uid;
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






	public static Logger getLogger() {
		return logger;
	}





}


	
	

