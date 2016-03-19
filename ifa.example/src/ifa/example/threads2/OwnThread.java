package ifa.example.threads2;

import java.io.IOException;

public class OwnThread extends Thread implements Runnable{
	
	private Writer writer;
	
	public void run(){
		for(int i = 0; i < 100; i++){
			try {
				writer.append(this.getName()+": "+i);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public OwnThread(Writer writer){
		this.writer = writer;
	}
	
}
