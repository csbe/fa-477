package ifa.example.threads2;

import java.io.IOException;

public class Multithreading {

	public static void main(String[] args) {
		Writer w;
		try {
			w = new Writer();
			OwnThread t = new OwnThread(w);
			OwnThread t1 = new OwnThread(w);
			t.start();
			t1.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
