package ifa.example.threads2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {
	
	private BufferedWriter bw;
	private FileWriter fw;
	
	public Writer() throws IOException{
		File f = new File("test.csv");
		fw = new FileWriter(f,true);
		bw = new BufferedWriter(fw);			
	}
	
	synchronized public void append(String text) throws IOException{
		bw.write("bw "+text + "\n");
		//fw.write("fw "+text + "\n");
	}
	
	public void flush() throws IOException{
		bw.flush();
		//fw.flush();
	}
	
}
