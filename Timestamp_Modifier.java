package io_reader;

import java.io.IOException;

public class Timestamp_Modifier extends IO {
	/* local variables - Change your file path here */
	private static String in = "input.txt", 
			      out = "timestamp.txt", 
			      lyrics = "lyrics_merge.txt";
	// private static boolean merge;
	
	
	/* Constructor */
	public Timestamp_Modifier() {
		super(in, lyrics, out);
	}

	
	/* Instance methods */
	private double time2seconds(String timestamp) { // let timestamp = 01:23.66
		int minutes = Integer.parseInt(timestamp.substring(0, 2));
		double seconds = Double.parseDouble(timestamp.substring(3));
		
		if (minutes > 0) {
			return (minutes * 60) + seconds;
		}
		
		return seconds;
	}
	
	
	private String seconds2time(double seconds) { // let seconds = 83.66
		//DecimalFormat df = new DecimalFormat("##.##");
		
		int minutes = (int) ((seconds >= 60) ? (seconds / 60) : 0);
		
		String result = String.format("%02d:%05.2f", minutes, seconds-(minutes * 60));
				
		return result;
	}
	
	
	private String extract_timestamp(String timestamp) {
		return timestamp.substring(timestamp.indexOf("[")+1, timestamp.indexOf("]"));
	}
	
	
	private String getMergeLine() {
		String result = "";
		try {
			result = getLyricsBuffedReader().readLine();
		} catch (IOException e) {
			System.out.println("Error during reading external lyrics, details below:");
			e.printStackTrace();
		}
		return (result != null) ? result : "No more lyrics";
	}
	
	
	public void trim_lyrics(int initial_skip, int con_skip) {
		String line;
		
		try {
			for (int i = 1; i <= initial_skip; i++) {
				getLyricsBuffedReader().readLine();
			}
			
			while((line = getLyricsBuffedReader().readLine()) != null) {
				for (int i = 1; i <= con_skip; i++) {
					getLyricsBuffedReader().readLine();
				}
				
				getBufferedWriter().append(String.format("%s%n", line));
				
				getBufferedWriter().flush();
			}
		} catch (IOException e) {
			System.out.println("Error while trimming lyrics, details below: ");
			e.printStackTrace();
		}
		
		System.out.println("No exceptions caught, finished.");
	}
	
	
	public void result_printer(boolean merge, double amount, boolean gen_title) { // Actions: Grab timestamp -> converts to seconds -> deduct 38s -> converts to timestamp -> output to output.txt
		// initialize variables
		String line;
		
		try {
			if (gen_title) { getBufferedWriter().append(String.format("[ti:]%n[ar:]%n[al:]%n[length:]%n[00:00.00]\"\"%n")); }

			while ((line = getBufferedReader().readLine()) != null) {
				// takes line and extract the time, then converts into seconds; later being deducted.
				double seconds = time2seconds(extract_timestamp(line)) + amount;
				// apped the formatted output into [##:##.##]lyrics
				if (merge) {
					getBufferedWriter().append(String.format("[%s]%s%n", seconds2time(seconds), getMergeLine()));
				} else {
					getBufferedWriter().append(String.format("[%s]%s%n", seconds2time(seconds), line.substring(line.indexOf("]")+1)));
				}
				// reset stream
				getBufferedWriter().flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("No exceptions caught, finished.");
		
	}
}
