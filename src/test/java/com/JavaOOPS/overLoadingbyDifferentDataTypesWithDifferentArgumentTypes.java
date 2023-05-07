package com.JavaOOPS;

class Adder123 {
	static int add(int a, int b) {
		return a + b;
	}

	static double add(double a, double b) {
		return a + b;
	}
	
	static double sum(float a, float b) {
		return a + b;
	}
	static double mul(double a, int b) {
		return a * b;
	}
	static double div(int a, int b) {
		return a % b;
	}
}

class overLoadingbyDifferentDataTypesWithDifferentArgumentTypes {
	public static void main(String[] args) {
		System.out.println(Adder123.add(11, 11));
		System.out.println(Adder123.add(12.3, 12.6));
		System.out.println(Adder123.add(12, 12));
		System.out.println(Adder123.mul(12.6, 12));
		System.out.println(Adder123.sum('s', 'k'));
	//	System.out.println(Adder123.sub(12.3, 12.6));
	//	System.out.println(Adder123.mul(3.15, 7.297)); //compile time error
		
	}
}