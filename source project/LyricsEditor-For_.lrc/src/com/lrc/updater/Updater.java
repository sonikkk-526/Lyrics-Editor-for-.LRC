package com.lrc.updater;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;
/**
 * The current version (or v1/s1) is referring to the version that this program is using.
 * The latest version (or v2/s2) is referring to the version found on the GitHub repo name tag (no matter is it newer or not).
 * 
 * @author sonic.-
 */
public class Updater {
    private static String[] latestVer;
    private String[] currentVer = { "1.1.1" };

    /**
     * Obtain the latest GitHub Lyrics Editor repository release tag name
     */
    static {
        try {
            // establish HTTP connection wtih GitHub repo
            URL gitRepoAPI = new URL("https://api.github.com/repos/FlashSonic526/Lyrics-Editor-for-.LRC/releases/latest");
            HttpURLConnection conn = (HttpURLConnection) gitRepoAPI.openConnection();
            conn.setRequestMethod("GET");

            // obtain the provided .JSON file
            StringBuilder input = new StringBuilder();
            Scanner scan = new Scanner(gitRepoAPI.openStream()); // could use BufferedReader

            while(scan.hasNext()) {
                    String temp = scan.nextLine();
                    input.append(temp);


            }
            scan.close();

            // parse StringBuilder .JSON to JSONObject 
            JSONObject json = new JSONObject(input.toString());

            // get the latest repo release name
            latestVer = ((String) json.get("name")).substring(1).split(" ");
        } catch (MalformedURLException e) {
            System.out.println("Invalid GitHub repo URL: ");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Unable to establish connection with GitHub Repo API:");
            e.printStackTrace();
        }
    }

    /**
     * Compare the two give versions and return the newest version.
     * @return 0 -> No new updates; x < 0 -> New updates; 
     */
    private int compareVersion() {
            String[] s1 = currentVer[0].split("\\.");
            String[] s2 = latestVer[0].split("\\.");

            int maxLength = Math.max(s1.length, s2.length);
            for(int i = 0; i < maxLength; i++) {
                Integer v1 = i < s1.length ? Integer.parseInt(s1[i]) : 0;
                Integer v2 = i < s2.length ? Integer.parseInt(s2[i]) : 0;

                // compareTo() will return 0 if v1 == v2
                int compare = v1.compareTo(v2);
                if (compare != 0) return compare;
            }

            return 0;
    }


    // Accessor Methods
    public String[] getLatestVer() {
        return latestVer;
    }

    public String[] getCurrentVer() {
        return currentVer;
    }
}