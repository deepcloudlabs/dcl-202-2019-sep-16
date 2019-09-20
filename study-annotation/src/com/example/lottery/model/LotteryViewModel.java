package com.example.lottery.model;

import java.util.List;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class LotteryViewModel {
	@RandomNumber(size=10)
	private List<Integer> numbers;

	public LotteryViewModel() {
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

}
