// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP103 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP103 - 2021T3, Assignment 4
 * Name: Nathan Cobbald
 * Username: cobbalnath
 * ID: 300574719
 */

/**
 * Implements a binary tree that represents the Morse code symbols, named after its inventor
 *   Samuel Morse.
 * Each Morse code symbol is formed by a sequence of dots and dashes.
 *
 * To increase the efficiency of encoding, Morse code was designed so that the length of each symbol
 * is approximately inverse to the frequency of the character in English text.
 * Thus the most common letter in English, the letter "E", has the shortest code: a single dot.
 *
 * The International Morse Code encodes the 26 English letters A through Z, some non-English letters,
 * the Arabic numerals and a small set of punctuation and procedural codes (prosigns).
 *
 * A Morse code chart has been provided with this assignment. This chart only contains the 26 letters
 * and 10 numerals. These are given in alphanumerical order. 
 * Some nodes will not be matched with any symbols (text).
 *
 */

import ecs100.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class MorseCode {

    public Character root;    // root of the morse code binary tree;
    public String indentation = "";
    public List<Character> loadedMorse = new ArrayList<>();
    public String decoded;
    public String code;
    public String morse; // String of morse to print out
    
    /**
     * Setup the GUI and creates the morse code with characters up to 2 symbols
     */
    public static void main(String[] args){
        MorseCode mc = new MorseCode();
        mc.setupGUI();
        mc.makeBasicTree();
    }

    /**
     * Set up the interface
     */
    public void setupGUI(){
        UI.addButton("Decode", this::decode);
        UI.addButton("Extend Tree Core", this::extendTreeCore);
        UI.addButton("Print Tree", this::printTree);
        UI.addButton("Extend Tree Comp", this::extendTreeComp);
        UI.addButton("Draw Tree", this::drawTree);
        UI.addButton("Load Alphabet", this::loadAlphabet);
        UI.addButton("Reset", this::makeBasicTree);
        UI.addButton("Quit", UI::quit);
        UI.setWindowSize(1000,400);
        UI.setDivider(0.25);
    }

    /**
     * Makes an initial tree with the 6 characters that have at most 2 symbols.
     */
    public void makeBasicTree(){
        root = new Character(null,
                new Character("T",                             
                new Character("M", null, null),
                new Character("N", null, null)),
                new Character("E",                             
                new Character("A", null, null),
                new Character("I", null, null)));
    }

    /**
     * Run the tree by starting at the top (root), and working
     * down the tree following the dash or dot nodes according to the
     * given sequence.
     * FOR CORE: you may assume that the code entered exists in the tree
     * FOR COMPLETION: your program needs to be more robust
     */
    public void decode() {
        Character currentNode = root;
        
        do {
            code = UI.askString("Morse code:");
        }
        while ( ! isValidCode(code));
        for (int i =0; i < code.length(); i++) {
            if (code.substring(i, i+1).equals("-")) {
                if (currentNode.getDash() != null) {
                    currentNode = currentNode.getDash();
                }
            }
            else if (code.substring(i, i+1).equals(".")) {
                if (currentNode.getDot() != null) {
                    currentNode = currentNode.getDot();
                }
            }
            decoded = currentNode.getText();
        }
        UI.println("Decoded message is: " + decoded);
    }

    public boolean isValidCode (String code) {
        if (code.length() <= 0){
            UI.println("Must be at least 1 character long");
            return false;
        }
        for (int index=0; index<code.length(); index++){
            char c = code.charAt(index);
            if (c != '-' && c != '.'){
                UI.println(c + "is invalid; Must only contain . (dot) or - (dash)");
                return false;
            }
        }
        return true;
    }

    // You will need to define at least headers for the other methods to make the GUI work.
    public void extendTreeCore() {
        String letter;
        Character currentNode = root;
        
        do {
            letter = UI.askString("Letter to add: ");
            code = UI.askString("Associated morse code: ");
        }
        while ( ! isValidCode(code));
        
        for (int i =0; i < code.length(); i++) {
            if (code.substring(i, i+1).equals("-")) {
                if (currentNode.getDash() != null) {
                    currentNode = currentNode.getDash();
                }
            }
            else if (code.substring(i, i+1).equals(".")) {
                if (currentNode.getDot() != null) {
                    currentNode = currentNode.getDot();
                }
            }
            Character newNode = new Character(letter, currentNode.getDash(), currentNode.getDot());
        }
        printTree();
    }
    public void extendTreeComp() {
        
    }
    public void printTree() {
        UI.clearText();
        Character currentNode = root;
        printHelper(currentNode, indentation);
    }
    public void loadAlphabet() {
        String filename = "morse-code.txt";
        try {
            Scanner sc = new Scanner(Path.of(filename));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                loadedMorse.add(new Character(line));
            }
            UI.println(loadedMorse.size() + " symbols loaded successfully");
        } catch(IOException e) { UI.println("File read failed" + e); }
    }
    public void drawTree() {
        Character currentNode = root; 
        //currentNode.draw(x, y);
    }
    //helpers
    public void printHelper(Character currentNode, String indentation) {
        if (currentNode != null) {
            UI.println(indentation + ":" + currentNode.getText());
            printHelper(currentNode.getDash(), indentation + "  " + "-");
            printHelper(currentNode.getDot(), indentation + "  " + ".");
        }
    }
}
