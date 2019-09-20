package com.example.lottery.app;

import com.example.lottery.model.LotteryViewModel;
import com.example.lottery.service.RandomNumberGenerator;

/**
  * @author Binnur Kurt <binnur.kurt@gmail.com>
  *
  */
public class LotteryApp {

	public static void main(String[] args) {
		RandomNumberGenerator rng= new RandomNumberGenerator();  
		LotteryViewModel model = new LotteryViewModel();
		rng.generate(model);
		System.out.println(model.getNumbers());

	}

}
