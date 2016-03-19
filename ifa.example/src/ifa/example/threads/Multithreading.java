package ifa.example.threads;

import java.lang.Thread.State;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Multithreading {

	public static Banking banking = new Banking(500);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runnable r = new Runnable() {
			
			Lock lock = new ReentrantLock();
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				if(Thread.currentThread().getName().equals("Thread-1") &&
						Thread.currentThread().getState() == State.NEW){
					try {
						Thread.currentThread().wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				lock.lock();
				
				for(int i = 0; i < 1000; i++){
					if(i % 10 == 0){
						if(Thread.currentThread().getName().equals("Thread-1")){
							banking.deposit(100);
						}else{
							banking.amount(100);
						}
						System.out.println(Thread.currentThread().getName()+" "+banking.getAmount());
					}
						//System.out.println(Thread.currentThread().getName() + ": " + i );
				}
				System.out.println(Thread.currentThread().getName());
				lock.unlock();
				System.out.println("Anzahl Fehlbezüge" + Banking.failed);
			}
		};
		
		Thread td = new Thread(r);
		Thread td1 = new Thread(r);
		
		td.start();
		td1.start();
		
	}

}
