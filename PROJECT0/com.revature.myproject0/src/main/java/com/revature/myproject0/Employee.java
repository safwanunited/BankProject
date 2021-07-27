package com.revature.myproject0;


import java.util.Scanner;

public class Employee {
		static Scanner sc;
		public static void employee() {
			int i=1,ch=0;
			int b=EmployeeFunction.login();
		    sc = new Scanner(System.in);
		   
		while(b==0) {
		System.out.println("INVALID USED ID OR PASSWORD.....TRY AGAIN");
		b=EmployeeFunction.login();
	
			
		}
			
			
			System.out.println("1.Accept\n2.Log file\n 3.view customer account 5.log out");
			sc=new Scanner(System.in);
			while(i==1) {
				ch=sc.nextInt();
				if(ch==1) {
					EmployeeFunction.Accept();
				}
				else if(ch==2) {
					EmployeeFunction.logs();
				}
				else if(ch==3) {
					EmployeeFunction.view();
				}
				else if(ch==4) {
					i=0;
				}
				else {
					System.out.println("Invalid");
				}
				System.out.println("FURTHER PROCESSING PRESS 1");
				i=sc.nextInt();
				if(i==1)
					System.out.println("1.Accept\n2.Log file\n 3.view customer account 5.log out");
				else
						break;
			
				
				
				
				
			}
	
			
			
			
			
			
		}
		
		
		
		
	
	

		}
