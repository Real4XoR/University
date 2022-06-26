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
import java.util.Random;

/** The robot is a circular vacuum cleaner than runs around
 * a floor, erasing any "dirt".
 * The parameters of the constructor should include the initial position,
 * and possibly its size and color.
 * It has methods to make it step and change direction:
 *  step() makes it go forward one step in its current direction.
 *  changeDirection() makes it go backward one step, and then turn to a new
 *     (random) direction.
 * It has methods to report its current position (x and y) with the
 *     getX() and getY() methods.
 * It has methods to erase and draw itself
 *  draw() will make it draw itself,
 *  erase() will make it erase itself (cleaning the floor under it also!)
 *
 * Hint: if the the current direction of the robot is d (expressed in
 *  degrees clockwise from East), then it should step
 *     cos(d * pi/180) in the horizontal direction, and
 *     sin(d * pi/180) in the vertical direction.
 * Hint: see the Math class documentation!
 */

public class Robot{

    // Fields to store the state of the robot.
    public double CONV = Math.PI / 180;
    public double REV = 30;
    
    private double x,y;
    private double diameter;
    private double direction;
    private Color colour;

    /** Construct a new Robot object.
     *  set its direction to a random direction, 0..360
     */
    public Robot(double DIAM, double xpos, double ypos, Color colour){
        this.x = xpos;
        this.y = ypos;
        this.colour = colour;
        this.diameter = DIAM;
        this.direction = Math.random()*REV;

    }

    // Methods to return the x and y coordinates of the current position
    /** Step one unit in the current direction (but don't redraw) */
    public void step() {
        double xpos = Math.cos(direction * CONV);
        double ypos = Math.sin(direction * CONV);

    }

    /** changeDirection: move backwards one unit and change direction randomly */
    public double changeDirection() {
        this.x = Math.cos(this.direction*CONV);
        this.y = Math.sin(this.direction*CONV);
        this.direction = Math.random()*REV;
        return direction;
    }

    /** Erase the robot */
    public void erase(){
        UI.eraseOval(this.x, this.y, this.diameter, this.diameter);
    }

    /** Draw the robot */
    public void draw(double xpos, double ypos, double DIAM){
        UI.setColor(this.colour);
        UI.fillOval(this.x, this.y, this.diameter, this.diameter);
        
    }
}
