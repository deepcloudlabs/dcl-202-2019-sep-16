package com.example;

import java.security.SecureRandom;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class StudyCallableThread {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		LotteryTask lotteryTask = new LotteryTask();
		FutureTask<List<Integer>> future1 = new FutureTask<>(lotteryTask);
		FutureTask<List<Integer>> future2 = new FutureTask<>(lotteryTask);
		Thread t1 = new Thread(future1);
		Thread t2 = new Thread(future2);
		t1.start();
		t2.start();
		System.out.println(future1.get());
		System.out.println(future2.get());
	}

}

class LotteryTask implements Callable<List<Integer>> {

	@Override
	public List<Integer> call() throws Exception {
		return new SecureRandom().ints(1, 50).distinct().limit(6).sorted().boxed().collect(Collectors.toList());
	}

}
