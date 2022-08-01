# Lyrics Editor for .LRC
<p align="center">
  <img alt="Editor-Icon" src="https://github.com/sonikkk-526/Lyrics-Editor-for-.LRC/blob/main/jar%20build%20and%20clean/editor_icon.png"><br><br>
  
  <a href="https://github.com/sonikkk-526">
    <img alt="Author" src="https://img.shields.io/badge/Author-FlashSonic526-brightgreen?style=for-the-badge">
  </a>
  
  <a href="https://github.com/sonikkk-526/Lyrics-Editor-for-.LRC/releases/latest">
	<img alt="Download Counts" src="https://img.shields.io/github/downloads/sonikkk-526/Lyrics-Editor-for-.LRC/total?style=for-the-badge">
  </a>
  
  <a href="https://github.com/sonikkk-526/Lyrics-Editor-for-.LRC/releases/latest" target="_blank">
    <img alt="Release" src="https://img.shields.io/github/v/release/FlashSonic526/Lyrics-Editor-for-.LRC?style=for-the-badge">
  </a>
  
  <a href="https://github.com/sonikkk-526/Lyrics-Editor-for-.LRC/blob/main/LICENSE" target="_blank">
    <img alt="License" src="https://img.shields.io/github/license/FlashSonic526/Lyrics-Editor-for-.LRC?style=for-the-badge">
  </a>
</p>

## ■ About this program
This is an open-sourced project that allows the user to easily modify and manage their .LRC (lyrics) files~!
  - Users need to download runtime on their computer before using the .JAR application. (At least for the current version)
  - Current version: [v1.2.0](https://github.com/FlashSonic526/Lyrics-Editor-for-.LRC/releases/latest)
![Lyrics Editor Screenshot](editor_showcase.png)

Users should have a corresponding music player so that their lyrics files can be displayed (such as foobar2000, FiiO Music App, or others).
  - In general, your .LRC file and the song (.MP3/.FLAC/.WAV etc.) file should have the same name and be put under the same directory.
  - For details, please refer to your music player lyrics display instruction/documentation.

## ■ Current features
1. Lyrics Editor
   - (a) Lyrics Merging: Allow users to combine the original timestamp with a new lyrics line without much of a stretch.
   - (b) Timestamp Editing: Allow users to easily edit every line of the timestamp.
     - Only 6 positive or negative integers (prefix “-”) and 2 decimal places are allowed
   - (c) Auto-generating Header Tags: Generate header tags for easy `.LRC` file management (`title tag [ti]`, `artist [ar]`, `album [al]`, `song duration [length]`).
2. Lyrics Trimming
   - Allow users to trim one or more languages if the lyrics they copied contain the original language and one or more translated languages of the song.
   - Also allow users to use their trimmed lyrics for merging lyrics.

_*For more information and .JAR installation, please refer to the [latest release note](https://github.com/FlashSonic526/Lyrics-Editor-for-.LRC/releases).*_


## ■ Download Instructions
### For the users of this program, you can:
1. Goto ["jar build and clean"](jar%20build%20and%20clean/) and download the whole folder (you could discard the .png and .ico)
2. Or, download the zipped file from the [latest release](https://github.com/FlashSonic526/Lyrics-Editor-for-.LRC/releases/latest)

_Note: downloading the .JAR requires java runtime, you can [download it here](https://java.com/en/download/manual.jsp) or [here](https://www.oracle.com/java/technologies/downloads/)._

**Also, the `lib` folder and its contents cannot be deleted!!** Otherwise the program would not work and you would have to re-download it here.


### For those working with the codes, you can:
1. Goto [source project/LyricsEditor-For_.lrc](source%20project/LyricsEditor-For_.lrc/); the library used in this project is in the [`lib`](source%20project/LyricsEditor-For_.lrc/lib)
2. Then, for the source codes, goto [src/com/lrc](source%20project/LyricsEditor-For_.lrc/src/com/lrc)

## ■ Uninstall Instructions
This program is a portable application which means that it is a standalone executable file, simply delete the entire folder would uninstall the program.

_*Since it is a portable application, it may not show up in "Programs and Features".*_

## ■ License & Copyright
Copyright (c) FlashSonic526.

Licensed under the [BSD-4 Clause License](LICENSE).