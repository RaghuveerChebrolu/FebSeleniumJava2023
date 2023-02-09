package com.Java;

public class JavaVariables {
	
	//instance variable : declared inside a class and out side a method 
	
	int a=87;
	char ch = 'l';
	String str = "Raghuveer is trainer";
	
	
	//static variable : declared with help of static keyboard
	static int b=32; 
	static char c ='h';
	
	
	//local variables : declared inside method are called local variables
	int sum (int a, int b) {
		return a+ b;
	}
	
	static int mul (int a, int b) {
		return a* b;
	}
	
	void display() {
		System.out.println("i am inside display method");
	}
	
	public static void main(String[] args) {
		JavaVariables obj = new JavaVariables();
		System.out.println(obj.a);
		System.out.println(b);
		System.out.println(obj.sum(4, 5));
		System.out.println(mul(7, 6));
		obj.display();
	}

}
