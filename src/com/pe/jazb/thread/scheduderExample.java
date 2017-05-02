package com.pe.jazb.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class scheduderExample {

	static ScheduledExecutorService service = Executors.newScheduledThreadPool(2);

	public static void main(String... strings) {

		scheduderExample th = new scheduderExample();

		service.schedule(new Runnable() {

			@Override
			public void run() {
				try {
					th.method();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, 60, TimeUnit.SECONDS);
		
		service.shutdown();

	}

	public synchronized void method() throws InterruptedException {

		String data[] = { "A", "B", "C", "D", "E" };

		for (int i = 0; i < data.length; i++) {
			Thread.sleep(100);
			System.out.println(data[i]);
		}
	}

	public synchronized void method2() throws InterruptedException {

		int data[] = { 1, 2, 3, 4, 5 };

		for (int i = 0; i < data.length; i++) {
			Thread.sleep(100);
			System.out.println(data[i]);
		}
	}

}
