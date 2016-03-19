package ifa.example.threads.monitor;

public class ReceivingThread extends Thread {
	BoundedBuffer bb = null;

	public ReceivingThread(BoundedBuffer bb) {
		this.bb = bb;
	}

	public void run() {
		while (true) {
			try {
				System.out.println("Receiving: " + this.bb.fetch());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
