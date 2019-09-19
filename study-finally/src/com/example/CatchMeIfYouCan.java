package com.example;

/**
  * @author Binnur Kurt <binnur.kurt@gmail.com>
  *
  */
public class CatchMeIfYouCan {
	@SuppressWarnings("finally")
	public static int gun() {
		try {
			return 42;
		} finally {
			return 108;
		}
	}
	public static void main(String[] args) {
		System.out.println(gun());
	}

}
