// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP-102-112 - 2021T1, Assignment 1
 * Name:
 * Username:
 * ID:
 */

import ecs100.*;
import java.awt.Color;

/**
 * Draws various flags
 *
 * You can find lots of flag details (including the correct dimensions and colours)
 * from  http://www.crwflags.com/fotw/flags/    
 */

public class FlagDrawer{

    public static final double LEFT = 100;  // the left side of the flags
    public static final double TOP = 50;    // the top of the flags

    /**   CORE
     * Draw the flag of Belgium.
     * The flag has three vertical stripes;
     * The left is black, the middle is yellow, and the right is red.
     * The flag is 13/15 as high as it is wide (ratio 13:15).
     */
    public void drawBelgiumFlag(){
        UI.clearGraphics();
        UI.println("Belgium Flag");
        double width = UI.askDouble("How wide: ");
        UI.setColor(Color.black);
        UI.drawRect(LEFT+0.1, TOP-0.1, width+0.1, (width*13/15));
        UI.setColor(Color.black);
        UI.fillRect(LEFT, TOP, width/3, (width*13/15));
        UI.setColor(Color.yellow);
        UI.fillRect(LEFT+width/3,TOP, width/3, (width*13/15));
        UI.setColor(Color.red);
        UI.fillRect(LEFT+width*2/3,TOP, width/3, (width*13/15));

    }

    /**   CORE
     *  The Red Cross flag consists of a white square with a red cross in the center
     *  The cross can be drawn as a horizontal rectangle and a vertical rectangle.
     */
    public void drawRedCrossFlag() {
        UI.println("Red Cross Flag: ");
        UI.clearGraphics();
        double size = UI.askDouble("How wide: ");
        UI.setColor(Color.black);
        UI.drawRect(LEFT, TOP , size+0.1, size+0.1);
        UI.setColor(Color.red);
        UI.fillRect(LEFT+size*0.2, TOP+size*0.4, size*0.6, size*0.2);
        UI.setColor(Color.red);
        UI.fillRect(LEFT+size*0.4, TOP+size*0.2, size*0.2, size*0.6);    

    }

    /**   COMPLETION
     *  Pacman
     *  A red pacman facing up on a black background chasing yellow, green, and blue dots.
     *  
     */
    public  void drawPacman() {
        UI.clearGraphics();        
        UI.println("Pacman Flag");
        double width = UI.askDouble("How wide: ");
        UI.setColor(Color.black);
        UI.fillRect(LEFT, TOP, width*2/3, width);
        UI.setColor(Color.red);
        UI.fillArc(LEFT+width*0.2, TOP+width*0.55, width*0.3, width*0.3, 110, 320);
        UI.setColor(Color.yellow);
        UI.fillArc(LEFT+width*0.3, TOP+width*0.4, width*0.1, width*0.1, 0, 360);
        UI.setColor(Color.green);
        UI.fillArc(LEFT+width*0.3, TOP+width*0.22, width*0.1, width*0.1, 0, 360);
        UI.setColor(Color.blue);
        UI.fillArc(LEFT+width*0.3, TOP+width*0.05, width*0.1, width*0.1, 0, 360);


    }

    /**   COMPLETION
     * Draw the flag of Greenland.
     * The top half of the flag is white, and the bottom half is red.
     * There is a circle in the middle (off-set to left)  which is
     * also half white/red but on the opposite sides.
     * The flag is 2/3 as high as it is wide (ratio 2:3).
     */
    public void drawGreenlandFlag() {
        UI.clearGraphics();
        UI.println("Greenland Flag");
        double width = UI.askDouble("How wide: ");
        UI.setColor(Color.black);
        UI.drawRect(LEFT-1, TOP-1, width+1, width*2/3+1);
        UI.setColor(Color.red);
        UI.fillRect(LEFT, TOP, width , (width*2/3));
        UI.setColor(Color.white);
        UI.fillRect(LEFT, TOP, width, (width*2/3)*0.5);
        UI.setColor(Color.white);
        UI.fillArc(LEFT+width*0.15, TOP+width*0.13, width*0.4, width*0.4, 180, 360);
        UI.setColor(Color.red);
        UI.fillArc(LEFT+width*0.15, TOP+width*0.13, width*0.4, width*0.4, 0, 180);
   }

    /**   CHALLENGE
     * Draw the Koru Flag.
     * It was one of the new flag designs for the 2016 referendum,
     * designed by Sven Baker from Wellington
     * The flag is 1/2 as high as it is wide (ratio 1:2).
     */
    public void drawKoruFlag() {
        UI.clearGraphics();
        UI.println("Koru Flag");
        double width = UI.askDouble("How wide: ");
        UI.setColor(Color.black);
        UI.drawRect(LEFT, TOP, width, width*1/2);
        UI.setColor(Color.red);
        UI.fillRect(LEFT, TOP, width/2, width*1/2);
        UI.setColor(Color.blue.darker());
        UI.fillRect(LEFT+width*0.5 , TOP , width/2, width*1/2);
        UI.setColor(Color.white);
        UI.fillArc(LEFT+width*0.2, TOP+width*-0.05, width*0.6, width*0.6, 0, 360);
         UI.setColor(Color.blue.darker());
        UI.fillArc(LEFT+width*0.27, TOP+width*0.02, width*0.47, width*0.47, 0, 360);
        UI.fillArc(LEFT+width*0.57, TOP+width*0.15, width*0.25, width*0.23, 0, 360);
        UI.setColor(Color.white);
        UI.fillArc(LEFT+width*0.603, TOP+width*0.14, width*0.2, width*0.2, 0, 360);
        
        

    }

    /**   CHALLENGE
     * Draw the flag of Samoa,
     * The flag is 1/2 as high as it is wide (ratio 1:2).
     * A red field with the blue rectangle on the top left quadrant bearing the Southern Cross
     *    of four white larger five-pointed stars and the smaller star in the center.
     * A full marks solution will have a method for drawing a 5 pointed star,
     * and call that method for each of the stars
     */
    public void drawSamoaFlag() {
        UI.clearGraphics();        
        UI.println("Samoa Flag");
        double width = UI.askDouble("How wide: ");
        UI.setColor(Color.black);
        UI.drawRect(LEFT-1, TOP-1, width+1, width*1/2+1);
        UI.setColor(Color.red.darker());
        UI.fillRect(LEFT, TOP, width, width*1/2);
        UI.setColor(Color.blue.darker());
        UI.fillRect(LEFT, TOP, width/2, width/4);

    }
    
    public static final double inner_vertices = 15;
    public static final double outer_vertices = 20;
    
    
    public void drawStar() {
        
    }



    public void setupGUI(){
        UI.addButton("Clear", UI::clearPanes);
        UI.addButton("Core: Flag of Belgium", this::drawBelgiumFlag);
        UI.addButton("Core: Red Cross Flag",  this::drawRedCrossFlag);
        // COMPLETION
        UI.addButton("Completion: Pacman Flag", this::drawPacman);
        UI.addButton("Completion: Flag of Greenland", this::drawGreenlandFlag);
        // CHALLENGE
        UI.addButton("Challenge: Koru flag", this::drawKoruFlag);
        UI.addButton("Challenge: Flag of Samoa", this::drawSamoaFlag);
        UI.addButton("Quit", UI::quit);

        UI.setDivider(0.3);
    }

    public static void main(String[] arguments){
        FlagDrawer fd = new FlagDrawer();
        fd.setupGUI();
    }

}
