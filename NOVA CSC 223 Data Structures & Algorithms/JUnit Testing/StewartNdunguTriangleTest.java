/**
*
* Student name:  Stewart Ndung'u
* Completion date: 05/26/26
*
* TriangleTest.txt: the template file of TriangleTest.java
* Student tasks: 
* - Write 20 JUnit test cases for Triangle class 
* - Then run this file on the command line with the jar files provided
*
*/

import static org.junit.Assert.*;
import org.junit.Test;


public class StewartNdunguTriangleTest {

	@Test
	public void test1(){
		Triangle triangle = new Triangle("12","12","12");
		assertEquals("This is an equilateral triangle. ",triangle.triangleType());	
	}//end test
	
	@Test
	public void test2(){
		Triangle triangle = new Triangle("3","3","5");
		assertEquals("This is an isosceles triangle. ",triangle.triangleType());
	 	
	}//end test
	
	@Test
	public void test3(){
		Triangle triangle = new Triangle("4","5","6");
		assertEquals("This is a scalene triangle. ", triangle.triangleType());
		// expected value: "This is a scalene triangle. "  
		// value returned from the method: triangle.triangleType() 
	}//end test
	
	@Test
	public void test4(){
		// add your code below
		Triangle triangle = new Triangle("E","5","9");
	

		assertEquals("The side 1 is not an integer number.\n\nNot a valid triangle!\n" ,triangle.triangleType());   
		// change above arguments(true, true) to (expectedValue, valueReturned)

	}//end test
	
	@Test
	public void test5(){
		Triangle triangle = new Triangle("3","L","9");
	

		assertEquals("The side 2 is not an integer number.\n\nNot a valid triangle!\n" ,triangle.triangleType());
	}//end test
	
	@Test
	public void test6(){
		Triangle triangle = new Triangle("3","5","X");
	

		assertEquals("The side 3 is not an integer number.\n\nNot a valid triangle!\n" ,triangle.triangleType());
	}//end test
	
	@Test
	public void test7(){
		Triangle triangle = new Triangle("530","555","525");
	

		assertEquals("This triangle is too big.\n" ,triangle.triangleType());
	}//end test
	
	@Test
	public void test8(){
		Triangle triangle = new Triangle("-5","10","15");
	

		assertEquals("At least one side is negative!\nNot a valid triangle!\n" ,triangle.triangleType());
	}//end test
	/*
	@Test
	public void test9(){
		assertEquals(true,true);
	}//end test
	
	@Test
	public void test10(){
		assertEquals(true,true);
	}//end test	
	
	@Test
	public void test11(){
		assertEquals(true,true);
	}//end test
	
	@Test
	public void test12(){
		assertEquals(true,true);
	}//end test
	
	@Test
	public void test13(){
		assertEquals(true,true);
	}//end test
	
	@Test
	public void test14(){
		assertEquals(true,true);
	}//end test
	
	@Test
	public void test15(){
		assertEquals(true,true);
	}//end test
	
	@Test
	public void test16(){
		assertEquals(true,true);
	}//end test	
	
	@Test
	public void test17(){
		assertEquals(true,true);
	}//end test
	
	
	@Test
	public void test18(){
		assertEquals(true,true);
	}//end test	
	
	
	@Test
	public void test19(){
		assertEquals(true,true);	
	}//end test
	
	@Test
	public void test20(){
		Triangle triangle = new Triangle("530","2355","112");
	

		assertEquals("Not a valid triangle!\nThis triangle is too big.\n" ,triangle.triangleType());	
	}//end test
	*/
}
