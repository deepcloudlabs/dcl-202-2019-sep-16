package com.example;

import java.math.BigDecimal;

public class StudyFloatingPoint {

	public static void main(String[] args) {
         float x = 3.1415F; // 4-byte
         double y = 3.1415; // 8-byte
         y = 2.0;
         y = y - 1.10;
         System.out.println("y= "+y);
         x = 1_000_000_000;
         x = x + 50 ;
         System.out.println(
            String.format("x=%12.3f", x)
         );
         BigDecimal bd = BigDecimal.valueOf(2.0);
         bd = bd.subtract(BigDecimal.valueOf(1.1));
         System.out.println("bd= "+bd.toString());
         y = 1.0 / -0.0 ;
         System.out.println("y = "+y);
         System.out.println(Double.isNaN(y));
	}

}



