package com.example.lottery.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
  * @author Binnur Kurt <binnur.kurt@gmail.com>
  *
  */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RandomNumber {

	int min() default 1;

	int max() default 50;

	int size() default 6;

	boolean distinct() default true;

	boolean sorted() default true;

}
