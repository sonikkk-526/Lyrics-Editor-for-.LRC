# LyricsEditor-for_.lrc
■ About this program (Version: Alpha 0.01a)

This program is written in java. A lyrics editor for .lrc files.
- *All the controlling of this program is in `Main.java`, please keep other files unchanged.
- *Use "//" (comments) to turn of commands


■ Current features
1. timestamp editing & tag generating | Command: mod.result_printer(merge, time, gen_title)
	- takes in input.txt, lyrics_merge.txt if merging, output to timestamp.txt (currently is fixed)
	- merge (true/false) -> select "true" if you want to disgard every lyrics in the input.txt file, and merge with new lyrics given in lyrics_merge.txt.
	- time (seconds) -> by default is a addition. Pass in a negative if you want to deduct.
	- gen_title (true/false) -> select "true" if you want auto-gen .lrc tags 
	      > Auto-gen tags: (ti - title, ar - artist, al - album, au - author (composer), length - total song length), [00:00.00])

2. lyrics trimming | Command: mod.trim_lyrics(initial_skip_amount, continously_skip_amount)
	- first variable determines skipping how many lines before start trimming.
	- second variable determines skipping how many lines.

	
■ Known Issues
1. Currently does not have a user interface
2. Requires an IDE to work with
3. Hard to use


■ Future Updates
1. GUI (User interface)
2. Removes IDE requirement
3. Removes requirement of using `input.txt`, `lyrics_merge.txt`, `titles_out.txt` only
4. Give user an option of choosing input file, lyrics file, and output to a file or a text box
5. Check for updates
6. Code & Performance optimizations
7. Able to identify whether that line has a timestamp + returns total non-timestamp lines at the end.
8. Console pane for status & errors


■ Other Notes

Since this program requires an compiler to run (at least for 0.01a), I suggest Replit (or any other compiler):

https://replit.com/@FlashSonic526/Lyrics-Modifier-Beta#Main.java (`Timestamp_Modifier.java` needs an update, copy from this GitHub page)
