package ifa.example.threads.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

	public static void main(String[] args) {
		Semaphore s = new Semaphore(1);

		SendingThread sender = new SendingThread(s);
		ReceivingThread receiver = new ReceivingThread(s);

		sender.start();
		receiver.start();

		System.out.println(sender);
		System.out.println(receiver);
	}

}
