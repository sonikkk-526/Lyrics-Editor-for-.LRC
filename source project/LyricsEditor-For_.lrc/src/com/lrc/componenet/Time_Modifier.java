package com.lrc.componenet;

import java.util.regex.Pattern;

public class Time_Modifier {
    /**
     * Convert the given timestamp to milliseconds.
     * @param timestamp A string that contains the timestamp (eg. 01:23.66)
     * @return Returns a double that contains milliseconds (eg. 8366 ms)
     */
    public double time2seconds(String timestamp) {
        double minutes = Double.parseDouble(timestamp.substring(0, 2));
        double seconds = Double.parseDouble(timestamp.substring(3));

        if (minutes > 0) {
            return (minutes * 60) + seconds;
        }

        return seconds;
    }

    /**
     * Convert the given milliseconds to .lrc format timestamp
     * @param seconds A double that contains milliseconds (eg. 8366 ms) 
     * @return A string that contains the timestamp (eg. 01:23.66)
     */
    public String seconds2time(double seconds) { // eg. seconds = 83.66
        int minutes = (int) ((seconds >= 60) ? (seconds / 60) : 0);

        String result = String.format("%02d:%05.2f", minutes, seconds-(minutes * 60));

        return result;
    }

    
    /**
     * Extract the timestamp out of the line of lyrics.
     * @param lyricsLine A String that contains the line of lyrics.
     * @return String (1) timestamp (2) NullPointerException, missing timestamp (3) IllegalArgumentException, incorrect format
     */
    public String extract_timestamp(String lyricsLine) {
        Pattern timePattern = Pattern.compile("\\d{2}:\\d{2}.\\d{2}");
        
        if (!(lyricsLine.indexOf("[") == 0 && lyricsLine.contains("]"))) {
            throw new NullPointerException();
        }
        
        String temp = lyricsLine.substring(lyricsLine.indexOf("[")+1, lyricsLine.indexOf("]"));
        if (!timePattern.matcher(temp).matches()) {
            throw new IllegalArgumentException();
        }
        
        return lyricsLine.substring(lyricsLine.indexOf("[")+1, lyricsLine.indexOf("]"));
    }
    
    /**
     * Extract each line of lyrics from the merge lyrics panel.
     * @param mergeLyrics String[] Obtain an array that contains the merge lyrics
     * @param index int The index (location) of the line of lyrics you want to get
     * @return (1) The line of lyrics or (2) "No More Lyrics..." or (3) "-1", empty merge lyrics
     */
    public String getMergeLine(String[] mergeLyrics, int index) { // new Merge_Form().getMergeLyrics()[element] !=
        String result;
        try {
            result = mergeLyrics[index];
            
            if (result.equals("") && mergeLyrics.length == 1) result = "-1";
        } catch (ArrayIndexOutOfBoundsException e) {
            result = "No More Lyrics...";
        }
        
        return result;
    }
    
    /**
     * Generate .LRC file titles
     * @return String Header titles: title, artist, length, [00:00.00] timestamp
     */
    public String headerTag_gen() {
        return String.format("[ti:]%n[ar:]%n[al:]%n[length:]%n[00:00.00]\"\"%n");
    }
    
    /**
     * Identify whether input contains a timestamp
     * @return Boolean .contains() timestamp
     */
    public boolean containsTimestamp() {
        return true;
    }
}
