package ifa.example.threads.semaphore;

import java.util.concurrent.Semaphore;

public class ReceivingThread extends Thread {
	  Semaphore semaphore = null;

	  public ReceivingThread(Semaphore semaphore){
	    this.semaphore = semaphore;
	  }

	  public void run(){
	    while(true){
	      this.semaphore.release();
	    }
	  }
	}
