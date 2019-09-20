package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
  * @author Binnur Kurt <binnur.kurt@gmail.com>
  *
  */
public class ParallelArraySum {
	private static final int CORES =  
			 Runtime.getRuntime().availableProcessors();
	private static final int ARRAY_SIZE = 2_000_000_000;
	private static final int[] array =
			new int[ARRAY_SIZE];
	// static block
	static { // runs once when class is loaded
		for (int i=0;i<ARRAY_SIZE;++i)
			array[i]= i;
	}
	public static void parallelStreamSum() {
	     long sum = Arrays.stream(array)
	    		           .parallel()
	    		           .boxed()
	    		           .mapToLong(Integer::longValue)
	    		          .sum();
	     System.out.println("parallel stream sum: "+sum); 
	}
	public static void serialSum() {
		long begin = System.currentTimeMillis();
		long sum =0;
		for (int num : array)
			sum += num;
		long end = System.currentTimeMillis();
		System.out.println("sum: "+sum+" @ "+(end-begin));		
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		serialSum();
		parallelStreamSum();
		final int size = ARRAY_SIZE / CORES ;
		List<FutureTask<Long>> futures = 
				   new ArrayList<>();
		long begin = System.currentTimeMillis();
		for (int i=0,start=0;i<CORES;++i,start+=size) {
			TaskSum ts = new TaskSum(array, start, size);
			FutureTask<Long> ft = new FutureTask<>(ts);
			futures.add(ft);
			new Thread(ft).start();
		}
		long sum=0;
		for (FutureTask<Long> ft : futures) {
			sum += ft.get();
		}
		long end = System.currentTimeMillis();
		System.out.println("sum: "+sum+" @ "+(end-begin));
	}

}

class TaskSum implements Callable<Long>{
	private int[] numbers;
	private int start;
	private int size;
	
	public TaskSum(int[] numbers, int start, int size) {
		this.numbers = numbers;
		this.start = start;
		this.size = size;
	}

	@Override
	public Long call() throws Exception {
		long sum =0;
		for (int i=start,j=0;j<size;++i,++j)
			sum += numbers[i];
		return sum;
	}
	
}














