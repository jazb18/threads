package com.pe.jazb.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class futureExample {

	static ExecutorService service = Executors.newFixedThreadPool(1);

	public static void main(String... strings) throws InterruptedException, ExecutionException {

		Future<String> future = service.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {

				return method();
			}
		});
		
		if (!future.isDone()) {
			Thread.sleep(1);
		}
		
		String data = future.get();  
		System.out.println(data);
	}
	
	public synchronized static String method() {
		
		StringBuffer buffer = new StringBuffer();
		
		String data[] = { "A", "B", "C", "D", "E" };
		
		for (int i = 0; i < data.length; i++) {
			// System.out.println(data[i]);
			buffer.append(data[i]);
		}
		
		return buffer.toString();
	}
}
