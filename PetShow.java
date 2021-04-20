// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP-102-112 - 2021T1, Assignment 2
 * Name: Nathan Cobbald
 * Username: cobbalnath
 * ID:300574719
 */

import ecs100.*;

/** Program to create simple animated animal character using the
 *  Animal class.  
 */

public class PetShow{

    /** animate creates two or several animals on the window.
     *  Then animates them according to a fixed script by calling a series
     *  of methods on the animals.
     *  
     *  CORE
     */
    public void animate() {
        Animal Turtle = new Animal("turtle", "sir. Shell", 400, 220);
        Animal Dinosaur = new Animal("dinosaur", "long neck", 50, 200);
        Dinosaur.goRight(0);
        Dinosaur.goLeft(0);
        Dinosaur.goRight(0);
        Dinosaur.speak("Hey, who are you?"); 
        Turtle.introduce("I'm ");
        Dinosaur.introduce("I'm ");
        Turtle.think("What's a dinosaur doing here?");
        Turtle.speak("So what are you doing here?"); 
        Turtle.speak("thought you guys died ages ago");
        Dinosaur.speak("Some of us got lucky");
        Turtle.speak("Oh that's cool");
        Dinosaur.speak("Anyway, I'm gonna go swim");
        Dinosaur.speak("Bye");
        Turtle.speak("Okay see ya");
        Dinosaur.goLeft(200);
        Turtle.think("Well I better go too");
        Turtle.goRight(200);
        
        
    }

    /** threeAnimalsRoutine creates three animals on the window.
     *  Then makes each animal do the same routine in turn.
     *  You should define a routine method, and threeAnimalsRoutine
     *   should call the routine method three times, to make
     *   each of the three animals perform the routine in turn.
     *   
     *   COMPLETION
     */
    public void threeAnimalsRoutine(){
        Animal dog = new Animal ("dog", "scruffy", 50, 200);
        Animal bird = new Animal ("bird", "flappy", 250, 200);
        Animal grasshopper = new Animal ("grasshopper", "springy", 450, 200);
    }

    /** makes the animal character do a little routine
     */
    public void routine() {
        
    }

    /** Make buttons to let the user run the methods */
    public void setupGUI(){
        UI.initialise();
        UI.addButton("Clear", UI::clearGraphics );
        UI.addButton("Animate", this::animate );
        UI.addButton("Three", this::threeAnimalsRoutine );
        UI.addButton("Quit", UI::quit );
        UI.setDivider(0);       // Expand the graphics area
    }

    public static void main(String[] args){
        PetShow ps = new PetShow();
        ps.setupGUI();
    }
}

