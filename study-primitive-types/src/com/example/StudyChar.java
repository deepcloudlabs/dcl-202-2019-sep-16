package com.example;

public class StudyChar {

	public static void main(String[] args) {
		char c = 'x'; // 2-byte, unicode
		System.out.println("c= "+(char)(c+1));
        c = '\u20BA';
        System.out.println(c);
        String clef = "\ud834\udd1e";
        System.out.println(clef);
	}

}
