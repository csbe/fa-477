package ifa.example.threads.monitor;



public class MonitorExample {

	public static void main(String[] args) {
		BoundedBuffer bb = new BoundedBuffer(1);
		
		SendingThread sender = new SendingThread(bb);
		ReceivingThread receiver = new ReceivingThread(bb);

		sender.start();
		receiver.start();
		
	}

}
