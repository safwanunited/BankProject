package com.revature.myproject0;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {

	
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		   int i=1;
		    int option1=0;//option2=0;//option3=0;
		    while(i==1) {
			Scanner in=new Scanner(System.in);
			System.out.println("1.Log in as customer\n 2.Log in as employee \n 3.Create new account \n4.Log out ");
		    option1=in.nextInt();
		    if(option1==1) {
		    	//logger.info(" LOGGED IN AS CUSTOMER " );
		    	Customer.customer();
		    	//logger.info(" LOGGED IN AS CUSTOMER " );
		    }
		    else if(option1==2) {
			    Employee.employee();  
			}
		    else if(option1==3) {
			    CreateAccount.Createnewcustomeraccount();
			}
		    else if(option1==4){
		    	i=0;
		    	System.out.println("THANK YOU FOR YOUR VISIT...HAPPY BANKING...!!!!");
				System.exit(0);
		    }
		    else {
		    	System.out.println("SORRY.....INVALID OPTION....CHOOSE 1..2..OR..3...");
		    }
		    
		
		    }
		}

	}


