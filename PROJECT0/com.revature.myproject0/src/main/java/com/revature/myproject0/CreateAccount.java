package com.revature.myproject0;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
    public class CreateAccount  {
	private static Scanner scanner;
	public static void Createnewcustomeraccount() {
	   Connection con=null;
	   @SuppressWarnings("resource")
	Scanner in=new Scanner(System.in);
	   con=Sconnection.getConnection();
	   System.out.println("connected to database succesfully");
	try {
	PreparedStatement stmt;
	//System.out.println("ACCOUNT NUMBER");
	System.out.print("NAME:");
	scanner = new Scanner(System.in).useDelimiter("\n");
	   String fname= scanner.next();
	System.out.print("ADDRESS:");
	scanner = new Scanner(System.in).useDelimiter("\n");
	   String add = scanner.next();
	System.out.print("EMAIL:");
	String email = scanner.next();
	
	System.out.print("CREATE A PASSWORD FOR YOUR ACCOUNT:");
	    String pswd = in.next();
	//System.out.print("DATE OF BIRTH:(note:MM/dd/yyyy):");
	//String input = in.next() ;
	       
	        //System.out.print("CONTACT NUMBER:");
	       System.out.print("INITIAL AMOUNT (Note:Initial amount must be greater than 1000) :");
	   double amnt=in.nextDouble();
	   while(amnt<=1000) {
	    System.out.println("INITIAL AMOUNT CANNOT BE LESS THAN 1000");
	    System.out.print("INITIAL AMOUNT:");
	   amnt=in.nextDouble();
	   }
	String query="INSERT INTO customertab(name, address, balance, password,emailid) VALUES(?,?,?,?,?)";
	stmt=con.prepareStatement(query);
	stmt.setString(1, fname);
	stmt.setString(2, add);
	stmt.setDouble(3, amnt);
	stmt.setString(4,pswd);
	stmt.setString(5, email);
	//stmt.setObject(5, input);
	int r=stmt.executeUpdate();
	if(r>0) {
	System.out.println("*                  ACCOUNT CREATED SUCCESSFULLY                      *");
	}
	else {
	System.out.println("SOME ERROR OCCURED,TRY AGAIN LATER...!!");
	}
	
	
	
	
	String query2="SELECT acntno FROM customertab WHERE emailid="+"'"+email+"'";

	Statement statement = con.createStatement(); 
	ResultSet resultSet = statement.executeQuery(query2);
	while (resultSet.next()) 
	{
		System.out.println("YOUR ACCOUNT NUMBER IS "+resultSet.getLong(1));
		
	
	}
	
	
	
	
	} catch (SQLException e) {
	System.out.println(e.getLocalizedMessage());
	}


	}
	}

