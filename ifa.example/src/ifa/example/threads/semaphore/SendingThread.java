package ifa.example.threads.semaphore;

import java.util.concurrent.Semaphore;

public class SendingThread extends Thread {
	Semaphore semaphore = null;

	public SendingThread(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	public void run() {
		while (true) {
			// do something, then signal
			System.out.println("test");
			
			try {
				this.semaphore.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}