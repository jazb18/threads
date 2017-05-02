package com.pe.jazb.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class runnableExample implements Runnable {

	ExecutorService service = Executors.newFixedThreadPool(1);

	ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

	@Override
	public void run() {
		//System.out.println("Hello from a thread!");
		try {
			method();
			method2();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String... args) {
		new Thread(new runnableExample()).start();
	}

	public synchronized void method() throws InterruptedException {

		String[] data = { "Jose", "Juan", "Maria", "Iesus" };

		for (int i = 0; i < data.length; i++) {
			Thread.sleep(4000);
			System.out.println(data[i]);
		}
	}

	public synchronized void method2() throws InterruptedException {

		int dataInt[] = { 1, 2, 3, 4, 5 };
		
		for (int i = 0; i < dataInt.length; i++) {
			Thread.sleep(4000);
			System.out.println(dataInt[i]);
		}
	}

}
