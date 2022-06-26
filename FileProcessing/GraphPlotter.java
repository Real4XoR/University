// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP-102-112 - 2021T1, Assignment 4
 * Name:
 * Username:
 * ID:
 */

import ecs100.*;
import java.awt.Color;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class GraphPlotter {

    // Constants for plotting the graph
    public static final double GRAPH_LEFT = 50;
    public static final double GRAPH_RIGHT = 550;
    public static final double GRAPH_BASE = 400;

    /**
     * Plot a graph of a sequence of numbers read from a file using +'s for each point.
     * The origin of the graph should be at (GRAPH_LEFT, GRAPH_BASE)
     * The method should ask the user for the name of a file that contains only numbers
     * It should then plot the numbers:
     *  - Draw two axes
     *  - Plot each number as a small +      eg, to plot at (x,y),
     *       draw a line from (x-2,y) to (x+2,y) and a line from (x,y-2) to (x,y+2)
     *  - The x value of the first point should be at GRAPH_LEFT, and
     *    the last point should be at GRAPH_RIGHT.
     *  - (ie, the points should be separated by (GRAPH_RIGHT - GRAPH_LEFT)/(number of points - 1)
     * Hints:
     *   look at the model answers for the Temperature Analyser problem from assignment 3.
     */
    public void plotGraph() {
        UI.drawLine(GRAPH_LEFT, GRAPH_BASE, GRAPH_LEFT, 20); // Y axis
        UI.drawLine(GRAPH_LEFT, GRAPH_BASE, GRAPH_RIGHT, GRAPH_BASE); // X axis
        String filename = UIFileChooser.save("File to read: ");
        
        try {
            List<String> allLines = Files.readAllLines(Path.of(filename));
            int NoP = 0; //counter to keep track of number of points
            for (String line : allLines) {
                Scanner sc = new Scanner(line); //creating new scanner object
                while (sc.hasNext()) { //while the scanner object has next integer keep going through while loop
                    int num = sc.nextInt();
                    NoP += 2; 
                    UI.drawString("+", GRAPH_LEFT + NoP, GRAPH_BASE - (num));
                }
                sc.close();
            }

        } catch(IOException e){UI.println("File read failed" + e);} // any exceptions of the code, it prints them out
    }

    /** set up the buttons */
    public void setupGUI(){
        UI.addButton("Clear", UI::clearPanes);
        UI.addButton("Plot", this::plotGraph);
        UI.addButton("quit", UI::quit);
        UI.setDivider(0.0);
    }

    public static void main(String[] args){
        GraphPlotter gp = new GraphPlotter();
        gp.setupGUI();
    }
}

