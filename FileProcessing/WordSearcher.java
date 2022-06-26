// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP-102-112 - 2021T1, Assignment 4
 * Name: Nathan Cobbald
 * Username: cobbalnath
 * ID: 300574719
 */

import ecs100.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class WordSearcher {

    /**
     * Asks the user for a pattern and then finds and prints out (one per line)
     *     all the words in a dictionary that contain that pattern.
     * At the end, it prints out how many words in the dictionary contained
     *    the pattern.
     * It should print the words as it finds them, but should stop printing
     *    after it has found 100 of them
     * The dictionary is in the file dictionary.txt, and has one word per line.
     */
    public void searchPattern() {
        String filename = UIFileChooser.save("File to read: "); //asks user for file to read

        String userIN = UI.askString("Pattern to search for: ");
        
        try {
            List<String> allLines = Files.readAllLines(Path.of(filename));
            int match_total = 0; // varibale to keep track of amount of matching words
            for (String line : allLines) {
                if (line.contains(userIN)) {
                    match_total += 1;
                    if (match_total <= 100) { // if matched words is below 100 it continues printing
                        UI.println(line);
                    }
                    else { // if count is anything other than below 100 it just adds to the count and doesnt print anything
                        match_total += 1;
                    }
                }

            }
            UI.println("Total matching words = " + match_total);
        } catch (IOException e) {UI.println("File read failed");}

    }

    /** set up the buttons */
    public void setupGUI(){
        UI.addButton("Clear", UI::clearPanes);
        UI.addButton("Search", this::searchPattern);
        UI.addButton("quit", UI::quit);
        UI.setDivider(1.0);
    }

    public static void main(String[] args){
        WordSearcher ws = new WordSearcher();
        ws.setupGUI();
    }
}

