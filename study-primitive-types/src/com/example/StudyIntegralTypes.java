package com.example;

import java.math.BigInteger;

public class StudyIntegralTypes {

	public static void main(String[] args) {
		byte b = 1; // 1-byte, [-128..127]
		b=-128;
		System.out.println("b="+b);
		b--;
		System.out.println("b="+b);
        b = 127;
        System.out.println("b="+b);
        b++;
        System.out.println("b="+b);
        byte x=3, y= 5, z=0;
        z += x + y ;
        z = (byte)(z + x + y);
        short s = 42 ; // 2-byte
        s = Short.MIN_VALUE;
        System.out.println("s="+s);
        s--;
        System.out.println("s="+s);
        int i=42; // 4-byte
        i = Integer.MIN_VALUE;
        System.out.println("i="+i);
        i--;
        System.out.println("i="+i);
        long l= 42; // 8-byte
        l = Long.MIN_VALUE;
        System.out.println("l="+l);
        l--;
        System.out.println("l="+l);
        l = 2147483647 + 1L;
        System.out.println("l="+l);
//        int one = 1 / -0 ;
//        System.out.println("one="+one);
        // Immutable Class
        BigInteger bi = 
        		BigInteger.valueOf(
        				Long.MAX_VALUE);
        System.out.println(bi);
       bi = bi.add(BigInteger.ONE);
       System.out.println(bi);
	}

}











