// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP-102-112 - 2021T1, Assignment 2
 * Name: Nathan Cobbald
 * Username: cobbalnath
 * ID: 300574719
 */

import ecs100.*;
import java.awt.Color;


/**
 * Key:
 * Core:       Method must report whether the key is valid, or
 *             report that it is invalid and give one reason why it is invalid.
 *             To be valid, the key must
 *             - be at least 8 characters and at most 16 characters long,
 *             - not end with the special characters '#' or '$',
 *             - not have a hyphen ('-') character anywhere
 *            
 * Completion: Method should either report that the key is valid, or
 *             report that it is invalid and list ALL the reasons that it is invalid.
 *             To be valid, the key must
 *             - satisfy all of the conditions above AND
 *             - have at least one Upper case character and at least one Lower case character,
 *             - not start with the same character as the first character of the user's name
 *             - contain either a '#' or a '$', but not both.
 * Challenge:  Same as completion, except that to be valid, the key must
 *             - satisfy all of the conditions above AND
 *             - have a mix of numbers and letters
 *             - not contain any "suffix" of the user's name of 2 characters or more in any case.
 *               (eg if name is Peter, it does not contain "er", or "eR" or "ter", or "eTer" or "ETER", or...)
 *
 * Hint.  Look at the documentation in the String class.
 * You will definitely find the length(), endsWith(...), and contains(...) methods to be helpful
 */

public class KeyValidator {

    /**
     * Asks user for key word and then checks if it is a valid key word.
     */
    public void doCore(){
        UI.clearText();
        String key = UI.askString("Key:   ");
        UI.println();
        this.validateKeyCore(key);
    }

    /** CORE
     * Report "Valid" or "Invalid: ...reason...."
     */
    public int min_str_size = 8;
    public int max_str_size = 16;
    
    public void validateKeyCore(String key){
        if (key.length() < min_str_size) {
            UI.println("Invalid:  Key is too short"); 
            }
        else if (key.length() > max_str_size) {
                UI.println("Invalid:  Key is too long");
        }
        else if (key.endsWith("#") || key.endsWith("$")) {
             UI.println("Invalid:  Key cannot end with # ");
        }
        else if (key.contains("-")) {
            UI.println("Invalid:  Key cannot contain - ");
        }
        else {
            UI.println("Key is valid");
        }
    }    
    /**
     * Asks user for key word and the name and then checks if it is a valid key word.
     */
    public void doCompletion(){
        UI.clearText();
        String key = UI.askString("Key:   ");
        String name = UI.askString("Your name:   ");
        UI.println();
        this.validateKeyCompletion(key, name);
    }

    /** COMPLETION
     * Report that the key is valid or report ALL the rules that the key failed.
     */
    
    public void validateKeyCompletion(String key, String name){
        char[] key_array = key.toCharArray();
        char[] name_array = name.toCharArray();
        boolean hasUppercase = !key.equals(key.toLowerCase());
        boolean hasLowercase = !key.equals(key.toUpperCase());
        boolean failed = false;
        
        if (key.length() < min_str_size) {
            UI.println("Invalid:  Key is too short"); 
            failed = true;
        } 
        if (key.length() > max_str_size) {
            UI.println("Invalid:  Key is too long");
            failed = true;
        } 
        if (key.endsWith("#") || key.endsWith("$")) {
            UI.println("Invalid:  Key cannot end with # or $");
            failed = true;
        } 
        if (key.contains("-")) {
            UI.println("Invalid:  Key cannot contain - ");
            failed = true;
        } 
        if ((!key.contains("#") && !key.contains("$")) || (key.contains("#") && key.contains("$"))){
            UI.println("Invalid:  Key must contain either a $ or #, but cannot contain both");
            failed = true;
        }
        if ((!hasUppercase) || (!hasLowercase)) {
            UI.println("Invalid:  key must have at least one uppercase letter"
            + " and one lower case letter");
            failed = true;
        }
        if (key.charAt(0) == name.charAt(0)) {
            UI.println("Invalid:  Key cannot start with the same character as your name"); 
            failed = true;
        }
        else if (failed=false) {
            UI.println("-" + key + "-" + " is valid ");
        }
    }
    public void doChallenge() {
        UI.clearText();
        String key = UI.askString("Key:   ");
        String name = UI.askString("Your name:   ");
        UI.println();
        this.validateKeyCompletion(key, name);
    }
    
    public void validateKeyChallenge (String key, String name) {

    }


/**           - satisfy all of the conditions above AND
*             - have a mix of numbers and letters
*             - not contain any "suffix" of the user's name of 2 characters or more in any case.
*              (eg if name is Peter, it does not contain "er", or "eR" or "ter", or "eTer" or "ETER", or...)
*/
    public void setupGUI(){
        UI.initialise();
        UI.addButton("Clear", UI::clearText );
        UI.addButton("Validate Key Core", this::doCore );
        UI.addButton("Validate Key Completion", this::doCompletion );
        UI.addButton("Validate Key Challenge", this::doChallenge );
        UI.addButton("Quit", UI::quit );
        UI.setDivider(1);       // Expand the text area
    }

    public static void main(String[] args){
        KeyValidator kv = new KeyValidator();
        kv.setupGUI();
    }
}
