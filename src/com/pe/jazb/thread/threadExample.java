package com.pe.jazb.thread;

public class threadExample extends Thread {

	@Override
	public void run() {
		//System.out.println("Hello from the thread 2");
		try {
			method();
			method2();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void method() throws InterruptedException{
		
		String[] data = {"Jose", "Juan", "Maria", "Iesus"};
		
		for (int i = 0; i < data.length; i++) {
			
			System.out.println(data[i]);
			//Thread.sleep(4000);
			Thread.sleep(NORM_PRIORITY);
		}
	}
	
	public synchronized void method2() throws InterruptedException{
		
		int dataInt[] = {1,2,3,4,5};
		for (int i = 0; i < dataInt.length; i++) {
			Thread.sleep(NORM_PRIORITY);
			System.out.println(dataInt[i]);
		}
	}
	
	public static void main(String... args){
		(new threadExample()).start();
	}
}
