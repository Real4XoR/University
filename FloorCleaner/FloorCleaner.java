// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP-102-112 - 2021T1, Assignment 6
 * Name: Nathan Cobbald
 * Username: cobbalnath
 * ID: 300574719
 */

import ecs100.*;
import java.awt.Color;

/** Runs a simulation of a robot vacuum cleaner that moves around a floor area,
 *      changing to a new random direction every time it hits the edge of the
 *      floor area.
 */
public class FloorCleaner{

    // Constants for drawing the robot and the floor.
    public static final double DIAM = 60;  //diameter of the robot.
    public static final double LEFT = 50;  // borders of the floor area.
    public static final double TOP = 50;
    public static final double RIGHT = 550;
    public static final double BOT = 420;

    /* Simulation loop.
     * The method should draw a dirty floor (a gray rectangle), and then
     * create one robot (core) or two robots (completion) and make them run around for ever.
     * Each time step, each robot will erase the "dirt" under it, and then
     *  move forward a small amount.
     * After it has moved, the program should ask for the robot's
     *  position and check the position against the edges of the floor area.
     * If it has gone over the edge, it will make the robot step back onto the floor
     *  and change its direction.
     * For the completion, it will also check if the robots have hit each other, and
     *  if so, make them both back off and change direction
     * 
     * Hint: A robot should start in a "safe" initial position (not over the edge):
     *  its x position should be between  LEFT+DIAM/2 and RIGHT-DIAM/2
     *  its y position should be between  TOP+DIAM/2 and BOT-DIAM/2
     * Hint: For the completion, you have to make sure that starting positions of
     *  the robots are not on top of each other (otherwise they get "stuck" to each other!)
     */
    public void cleanFloor(){
        UI.clearGraphics();
        this.drawFloor();
        
        double x = LEFT+DIAM/2+Math.random()*(RIGHT-DIAM/2-LEFT+DIAM/2);
        double y = TOP+DIAM/2+Math.random()*(BOT-DIAM/2-TOP+DIAM/2);
        
        Robot r1 = new Robot(DIAM, x, y, Color.red);
        
        while(true) {
            r1.erase();
            if (x > LEFT+DIAM/2 && x < RIGHT-DIAM/2 && y > TOP+DIAM/2 && y < BOT-DIAM/2) {
                r1.step();   
            }
            else {
                r1.changeDirection();
                r1.step();
            }
            r1.draw(x, y, DIAM);
            UI.sleep(50);
        }
    }
    
    public void drawFloor() {
        UI.setColor(Color.gray);
        UI.fillRect(LEFT, TOP, RIGHT, BOT);
    }

    //------------------ Set up the GUI (buttons) ------------------------
    /** Make buttons to let the user run the methods */
    public void setupGUI(){
        UI.addButton("Reset", UI::clearPanes); 
        UI.addButton("Start", this::cleanFloor);
        UI.addButton("Quit", UI::quit);
        UI.setWindowSize(650,500);
        UI.setDivider(0);
    }    

    // Main
    public static void main(String[] arguments){
        FloorCleaner fc = new FloorCleaner();
        fc.setupGUI();
    }    

}
