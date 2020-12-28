package com.gm.thread;

import java.io.IOException;

import com.gm.thread.fileio.FileReader;

// References:
// For threads: https://crunchify.com/java-simple-thread-example/
// For file-reading: https://stackoverflow.com/questions/4149/how-do-i-use-java-to-read-from-a-file-that-is-actively-being-written-to

public class BackgroundFileReaderWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hello");
		System.out.println("Starting reading file");
		
		// This FileReader class extends Thread
		// Arguments: File path, boolean continuous true/false
		FileReader fileReader = new FileReader("/tmp/x1", true);
		 
		// Read file in background - Call the inherited start() method as FileReader extends Thread
		fileReader.start();
		
		// This run() does not put it in background
		//fileReader.run();
		
		/* NOT USING run() - instead using the readTheFile() method
		 * This will not put it in background;
		try {
			fileReader.readTheFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		System.out.println("Starting reading file in background");
		
	}

}
