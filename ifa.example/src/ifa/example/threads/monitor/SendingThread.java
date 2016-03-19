package ifa.example.threads.monitor;

import java.util.concurrent.Semaphore;

public class SendingThread extends Thread {
	BoundedBuffer bb = null;

	public SendingThread(BoundedBuffer bb) {
		this.bb = bb;
	}

	public void run() {
		int i = 0;
		while (i < 100) {	
			try {
				this.bb.deposit("" + i++);
				System.out.println("Sending: " + (i-1));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}