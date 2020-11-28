package com.gm.thread.fileio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

//References:
//For threads: https://crunchify.com/java-simple-thread-example/
//For file-reading: https://stackoverflow.com/questions/4149/how-do-i-use-java-to-read-from-a-file-that-is-actively-being-written-to

public class FileReader extends Thread {
	
	String filePath;
	boolean continuous;
	
	public FileReader(String filePath, boolean continuous) {
		this.filePath = filePath;
		this.continuous = continuous;
	}
	
	
	private File getFile() {
		
		File file = new File(filePath);
		
		if (file.exists() && file.canRead()) {
			
			return file;
			
		} else {
			System.out.println ("File Read Error");
			return null;
		}
		
	}
	
	private void readFile(File file, long skipLines) throws IOException {
        String line = null;

        BufferedReader in = new BufferedReader(new java.io.FileReader(file));
        in.skip(skipLines);
        
        
        while((line = in.readLine()) != null)
        {
            System.out.println(line);
        }
        in.close();
	}
	
	private void readFileContinuous(File file) throws IOException {
		long fileLength;
		fileLength = file.length();
		
		// first read the file skipping zero characters
		readFile(file, 0L);
		
		while(true) {
            if(fileLength<file.length()){
                readFile(file,fileLength);
                fileLength=file.length();
            }
		}
		
	}
	
	private void readFileOnce(File file) throws IOException {
		long fileLength;
		fileLength = file.length();
		
		// first read the file skipping zero characters
		readFile(file, 0L);
	}
	
	public void readTheFile() throws IOException {
		
		File file = getFile();
		
		if (continuous) {
			readFileContinuous(file);
		} else {
			readFileOnce(file);
			
		}
		
	}
	
	@Override
	public void run() throws RuntimeException {
		
		File file = getFile();
		
	    if (continuous) {
	    	try {
	    	readFileContinuous(file);
	    	} 
	    	catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    } else {
	    	try {
	    		readFileOnce(file);
	    	}
	    	catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    }

	}
}
