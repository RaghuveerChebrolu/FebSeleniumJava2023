package com.Java;

public class JavaStrings {

	public static void main(String[] args) {
	 String str = "learning java";   //declaring string using string literal, storing in string constant pool
	 
	 String s1 = "hellow world";
	 String s2 = "hellow world";
	 str.concat("hello");
	 String str2= "hi how are you how are you doing"
	 		+ " i am fine";
	 System.out.println("The value of str:"+str);
	 str=str.concat(" hello");
	 System.out.println("The value of str after changing explicitly:"+str);
	 
	 System.out.println("charAt:"+str2.charAt(5));
	 System.out.println("substring:"+str2.substring(3));
	 System.out.println("substring:"+str2.substring(3,8));
	 System.out.println("length:"+str2.length());
	 String str3= "I am learning java";
	 Boolean flag1 = s1==s2; //compare the reference (address) where the string us being stored
	 System.out.println("flag1:"+flag1);
	 Boolean flag2 = s1.equals(s2);//compare the content (what is being stored) of two strings
	 System.out.println("flag2:"+flag2);
	 String str4 = "hi how are you";
	 Boolean flag3 = str2.equals(str4);
	 System.out.println("flag3:"+flag3);
	 String str5 = "hi how are yOu";
	 Boolean flag4 = str2.equals(str5);
	 System.out.println("flag4:"+flag4);
	 System.out.println("uppercase:"+str2.toUpperCase());
	 System.out.println("lowercase:"+str5.toLowerCase());
	 System.out.println(str2.replace('a', 'l'));
	 
	 str2 = str2.replace("how", "what");
	 str2 = str2.replace("fine", "hello");
	 System.out.println(str2);
	 
	 String str6 = "     How are you    doing ?   ";
	 System.out.println("str6 length before trim:"+str6 +"=" +str6.length());
	 System.out.println("str6 length after trim:"+str6.trim()+"="+str6.trim().length());
	 
	 System.out.println("str6 hashcode "+str6.hashCode());

	 
	}

}
