package com.revature.myproject0;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//import org.junit.Test;
//import org.junit.gen5.api.Assertions;

public class Test4 {

	

@Test
void Test1() {
System.out.println("Customer login....");
  Assertions.assertEquals(1,CustomerFunction.login());
}
@Test
    void Test2() {
System.out.println("Employee login....");
      Assertions.assertEquals(1,EmployeeFunction.login());
    }
}


	
	
	
	
	
	
	
	
	
	

