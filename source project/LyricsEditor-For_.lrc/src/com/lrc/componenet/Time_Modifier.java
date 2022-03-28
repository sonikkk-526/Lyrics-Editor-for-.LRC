package com.lrc.componenet;

import java.util.regex.Pattern;
import com.lrc.forms.Merge_Form;

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
     * @param milliseconds A double that contains milliseconds (eg. 8366 ms)
     * @returnp A string that contains the timestamp (eg. 01:23.66)
     */
    public String seconds2time(double seconds) { // eg. seconds = 83.66
        int minutes = (int) ((seconds >= 60) ? (seconds / 60) : 0);

        String result = new String(String.format("%02d:%05.2f", minutes, seconds-(minutes * 60)));

        return result;
    }

    
    /**
     * Extract the timestamp out of the line of lyrics.
     * @param timestamp A String that contains the line of lyrics.
     * @return String (1) timestamp (2) 1, missing timestamp (3) 2, incorrect format
     */
    public String extract_timestamp(String lyricsLine) {
        Pattern timePattern = Pattern.compile("\\d{2}:\\d{2}.\\d{2}");
        
        if (!(lyricsLine.contains("[") && lyricsLine.contains("]"))) {
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
     * @param merge Merge_Form
     * @param index int The index (location) of the line of lyrics you want to get
     * @return (1) The line of lyrics or (2) "No More Lyrics..." or (3) "-1", empty merge lyrics
     */
    public String getMergeLine(Merge_Form merge, int index) { // new Merge_Form().getMergeLyrics()[element] !=
        String result = "";
        try {
            result = merge.getMergeLyrics()[index];
            
            if (result.equals("") && merge.getMergeLyrics().length == 1) result = "-1";
        } catch (ArrayIndexOutOfBoundsException e) {
            result = "No More Lyrics...";
        }
        
        return result;
    }
    
    /**
     * Generate Header titles: title, artist, length, [00:00.00] timestamp
     * @return 4 Headers
     */
    public String headerTag_gen() {
        return String.format("[ti:]%n[ar:]%n[al:]%n[length:]%n[00:00.00]\"\"%n");
    }
}
