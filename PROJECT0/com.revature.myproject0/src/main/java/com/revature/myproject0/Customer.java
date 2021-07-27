package com.revature.myproject0;

import java.util.Scanner;

public class Customer {
	static long temp;
	static Scanner sc;
	
public static void customer() {
	int i=1,ch=0;
	//CustomerFunction.login();
	
	int b=CustomerFunction.login();
    sc = new Scanner(System.in);
   
while(b==0) {
System.out.println("INVALID USED ID OR PASSWORD.....TRY AGAIN");
b=CustomerFunction.login();
}
	
	
	
	System.out.println("1.Deposit\n2.withdraw\n3.transfer\n4.balance\n5.logout");
	sc=new Scanner(System.in);
	while(i==1) {
		ch=sc.nextInt();
		if(ch==1) {
			temp=CustomerFunction.deposit();
			CustomerFunction.balance(temp);
		}
		else if(ch==2) {
			temp=CustomerFunction.withdraw();
			CustomerFunction.balance(temp);
		}
		else if(ch==3) {
			temp=CustomerFunction.transfer();
			CustomerFunction.balance(temp);
		}
		else if(ch==4) {
			CustomerFunction.balance();
		}
		else if(ch==5) {
			System.exit(0);
		}
		else {
	
			System.out.println("Invalid");
		}
		System.out.println("FURTHER PROCESSING PRESS 1");
		i=sc.nextInt();
		if(i==1)
			System.out.println("1.Deposit\n2.withdraw\n3.transfer\n4.balance\n5.logout");
		else
			break;
	}
	


}
}

