/**
*
* Student name:  Stewart Ndung'u
* Completion date: 05/27/26
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
	

	// Tests if side 1 has a non integer and the result matches below.
	@Test
	public void test4(){
		// add your code below
		Triangle triangle = new Triangle("E","5","9");
		assertEquals("The side 1 is not an integer number.\n\nNot a valid triangle!\n" ,triangle.triangleType());   
		// change above arguments(true, true) to (expectedValue, valueReturned)

	}//end test
	

	// Tests if Side 2 has a non integer and the result matches below.
	@Test
	public void test5(){
		Triangle triangle = new Triangle("3","L","9");
		assertEquals("The side 2 is not an integer number.\n\nNot a valid triangle!\n" ,triangle.triangleType());
	}//end test
	

	// Tests if Side 3 has a non integer and the result matches below.
	@Test
	public void test6(){
		Triangle triangle = new Triangle("3","5","X");
		assertEquals("The side 3 is not an integer number.\n\nNot a valid triangle!\n" ,triangle.triangleType());
	}//end test
	

	// Tests if all the sides added up are larger than 1000 and the result matches below.
	@Test
	public void test7(){
		Triangle triangle = new Triangle("530","555","525");
		assertEquals("This triangle is too big.\n" ,triangle.triangleType());
	}//end test
	

	//Tests if one of the sides is negative and the result matches below.
	@Test
	public void test8(){
		Triangle triangle = new Triangle("-5","10","15");
		assertEquals("At least one side is negative!\nNot a valid triangle!\n" ,triangle.triangleType());
	}//end test
	

	// Tests if Side 1 & Side 2 are non integers and the result matches below.
	@Test
	public void test9(){
		Triangle triangle = new Triangle("X","Y","5");
	

		assertEquals("The side 1 is not an integer number.\n\nThe side 2 is not an integer number.\n\nNot a valid triangle!\n" ,triangle.triangleType());
	}//end test
	

	// Tests if Side 1 & Side 3 are non integers and the result matches below.
	@Test
	public void test10(){
		Triangle triangle = new Triangle("X","5","Z");
		assertEquals("The side 1 is not an integer number.\n\nThe side 3 is not an integer number.\n\nNot a valid triangle!\n" ,triangle.triangleType());
	}//end test	
	

	// Tests if Side 2 & Side 3 are non integers and the result matches below.
	@Test
	public void test11(){
		Triangle triangle = new Triangle("5","Y","Z");
		assertEquals("The side 2 is not an integer number.\n\nThe side 3 is not an integer number.\n\nNot a valid triangle!\n" ,triangle.triangleType());
	}//end test
	

	// Tests if all the sides are non integers and the result matches below.
	@Test
	public void test12(){
		Triangle triangle = new Triangle("X","Y","Z");
		assertEquals("The side 1 is not an integer number.\n\nThe side 2 is not an integer number.\n\nThe side 3 is not an integer number.\n\nNot a valid triangle!\n" ,triangle.triangleType());
	}//end test
	

	//Tests if one side has a negative number and the sum of the sides over 1000 and the result matches below.
	@Test
	public void test13(){
		Triangle triangle = new Triangle("-5","600","600");
		assertEquals("At least one side is negative!\nNot a valid triangle!\nThis triangle is too big.\n" ,triangle.triangleType());
	}//end test
	

	//Tests if Side 1 & Side 3 match and the result matches below
	@Test
	public void test14(){
		Triangle triangle = new Triangle("3","5","3");
		assertEquals("This is an isosceles triangle. ",triangle.triangleType());
	}//end test
	

	//Tests if Side 2 & Side 3 match. As well as the boundary for the sum of all the sides needs to be 1000 or lower is met
	@Test
	public void test15(){
		Triangle triangle = new Triangle("400","300","300");
		assertEquals("This is an isosceles triangle. ",triangle.triangleType());
	}//end test
	

	//Tests if there are no values for all the sides and the result matches below.
	@Test
	public void test16(){
		Triangle triangle = new Triangle();
		assertEquals("Not a valid triangle!\n",triangle.triangleType());
	}//end test	
	

	//Tests when Side 1 + Side 2 <= Side3 when the sum of Side 1 and Side 3 are exactly Side 2.
	@Test
	public void test17(){
		
		Triangle triangle = new Triangle("5","5","10");
		assertEquals("Not a valid triangle!\n",triangle.triangleType());
	}//end test
	

	//Tests when Side 1 is a non-integer, meaning then it is an invalid triangle & the sum of the triangle is greater than 1000
	@Test
	public void test18(){
		
		Triangle triangle = new Triangle("E","600","500");
		assertEquals("The side 1 is not an integer number.\n\nNot a valid triangle!\nThis triangle is too big.\n",triangle.triangleType());
	}//end test	
	
	
	//Tests when Side 2 + Side 3 <= Side 1 & Side 1 is a float number which is not an integer and the result matches below.
	@Test
	public void test19(){
		
		Triangle triangle = new Triangle("6.6","2","3");
		assertEquals("The side 1 is not an integer number.\n\nNot a valid triangle!\n",triangle.triangleType());	
	}//end test
	

	//Tests when Side 1 + Side 3 <= Side 2 & the sum of all the sides are greater than 1000 and the result matches below.
	@Test
	public void test20(){
		Triangle triangle = new Triangle("530","2355","112");
		assertEquals("Not a valid triangle!\nThis triangle is too big.\n" ,triangle.triangleType());	
	}//end test
	
}
