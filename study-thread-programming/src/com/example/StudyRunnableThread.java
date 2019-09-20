package com.example;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class StudyRunnableThread {
	public static void main(String[] args) throws InterruptedException {
		MyTask1 task = new MyTask1();
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		t1.start(); // thread is started
		t2.start(); // thread is started
		t1.join(); // wait for the thread
		t2.join(); // wait for the thread
		System.out.println("Application is done.");
		System.out.println(task.getCounter());
	}
}

class MyTask1 implements Runnable {
	private AtomicInteger counter = new AtomicInteger(0);

	@Override
	public void run() {
		for (int i = 0; i < 100_000; ++i) {
			counter.getAndIncrement();
		}
		System.out.println("Thread is done.");
	}

	public int getCounter() {
		return counter.get();
	}

}
