package com.pe.jazb.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class executorServiceExample {

	static ExecutorService service = Executors.newFixedThreadPool(2);

	public static void main(String... args) {

		executorServiceExample th = new executorServiceExample();
		service.execute(new Runnable() {

			@Override
			public void run() {
				try {
					th.method();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		service.execute(new Runnable() {

			@Override
			public void run() {
				try {
					th.method2();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		service.shutdown();
		
	}

	public synchronized void method() throws InterruptedException {

		String data[] = { "A", "B", "C", "D", "E" };

		for (int i = 0; i < data.length; i++) {
			Thread.sleep(1000);
			System.out.println(data[i]);
		}

		if (Thread.interrupted()) {
			return;
		}
	}

	public synchronized void method2() throws InterruptedException {

		int data[] = { 1, 2, 3, 4, 5 };

		for (int i = 0; i < data.length; i++) {
			Thread.sleep(2000);
			System.out.println(data[i]);

			if (Thread.interrupted()) {
				return;
			}
		}
	}
}
