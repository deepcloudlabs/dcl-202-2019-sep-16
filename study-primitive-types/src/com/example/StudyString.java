package com.example;

public class StudyString {

	public static void main(String[] args) {
		String name1= "Jack";
		String name2= new String("Jack");
		String name3= "Jack";
		name2 = name2.intern();
		System.out.println("name1==name2: "
		                   + (name1==name2) );
		System.out.println("name1.equals(name2): "
				+ name1.equals(name2) );
		System.out.println("name1==name3: "
			               + (name1==name3) );
	}

}
