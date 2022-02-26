package io_reader;
/**
 * This class contains variables and methods to read a file.
 * Note: (1) Supports UTF_8 I/O.
 * 		 (2) Currently Timestamp_Modifier.java is a IO.java. (linkage: active)
 * @author sonic.-
 * @version Beta 0.01
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class IO {
	/* Instance variables */
	private BufferedReader input = null; // timestamp input -38s
	private BufferedReader lyrics = null;
	//private BufferedReader lyrics_trim = null;
	private BufferedWriter output = null;
	
	/* Constructor */
	/* Note: Should split into two different constructors; (1) handles 2 streams, (2) handles 3 streams; call the required stream for lower load.
	public IO(String trim, String output) {
		// initiate global variables
		try {
			//InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
			this.lyrics_trim = new BufferedReader(new InputStreamReader(new FileInputStream(trim), StandardCharsets.UTF_8)); // US_ASCII
			this.output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output), StandardCharsets.UTF_8));
		} catch (IOException e) {
			System.out.println("Error during initiating the global variables, details below:");
			e.printStackTrace();
		}
	}
	
	
	public IO(String in, String out) {
		// initiate global variables
		try {
			//InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
			this.input = new BufferedReader(new InputStreamReader(new FileInputStream(in), StandardCharsets.UTF_8)); // US_ASCII
			this.output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(out), StandardCharsets.UTF_8));
		} catch (IOException e) {
			System.out.println("Error during initiating the global variables, details below:");
			e.printStackTrace();
		}
	}
	*/
	public IO(String in, String lyrics, String out) {
		// initiate global variables
		try {
			//InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
			this.input = new BufferedReader(new InputStreamReader(new FileInputStream(in), StandardCharsets.UTF_8)); // US_ASCII
			this.lyrics = new BufferedReader(new InputStreamReader(new FileInputStream(lyrics), StandardCharsets.UTF_8));
			this.output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(out), StandardCharsets.UTF_8));
		} catch (IOException e) {
			System.out.println("Error during initiating the global variables, details below:");
			e.printStackTrace();
		}
	}
	
	/* Instance methods */
	public BufferedReader getBufferedReader() { // Access Methods
		return input;
	}
	
	public BufferedReader getLyricsBuffedReader() {
		return lyrics;
	}
	
	public BufferedWriter getBufferedWriter() {
		return output;
	}
	
	/* Useless in recent updates
	public String readPerLine() {
		String result = "";
		
		try {
			result = input.readLine();
		} catch (IOException e) {
			System.out.println("Error during line reading, details below:");
			e.printStackTrace();
		}
		
		return (result != null) ? result : "End of text";
	}
	*/
}
