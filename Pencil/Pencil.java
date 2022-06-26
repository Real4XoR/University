// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP103 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP103 - 2021T3, Assignment 1
 * Name: Nathan Cobbald
 * Username: cobbalnath
 * ID: 300574719
 */

import ecs100.*;
import java.util.*;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JColorChooser;

/** Pencil */
public class Pencil{
    private double lastX;
    private double lastY;
    
    Color lineColor;
    double lineWidth;
    private JButton btnLineCol;
    
    Stroke stroke;
    
    public Stack<Stroke> undoStack = new Stack<Stroke>();
    public Stack<Stroke> redoStack = new Stack<Stroke>();
    
    /**
    * Setup the GUI
    */
    public void setupGUI(){
        UI.addButton("Undo", this::undo);
        UI.addButton("Redo", this::redo);

        UI.addSlider("Line Width", 1, 50, 3, this::setLineWidth);
        btnLineCol = UI.addButton("Line Colour", this::setColor);
        
        UI.setMouseMotionListener(this::doMouse);
        UI.addButton("Clear", UI::clearGraphics);
        UI.addButton("Quit", UI::quit);
        UI.setLineWidth(3);
        UI.setDivider(0.0);
    }
        /**
    * Respond to mouse events
    */
    public void doMouse(String action, double x, double y) {
        if (action.equals("pressed")){
            lastX = x;
            lastY = y;
            UI.setColor(lineColor);
            stroke = new Stroke(lineColor, lineWidth, x,y);
        }
        else if (action.equals("dragged")){
            UI.drawLine(lastX, lastY, x, y);
            lastX = x;
            lastY = y;
            
            stroke.add(x,y);
        }
        else if (action.equals("released")){
            UI.drawLine(lastX, lastY, x, y);

            undoStack.push(stroke);
            redoStack.clear();
        }
    }
    /**
     * Undo your mistakes :(
     */
    public void undo() {
        if (!undoStack.isEmpty()) {
            Stroke line = undoStack.pop();
            redoStack.push(line);
            line.erase();
            if (undoStack.size() == 0) {
                UI.setColor(Color.black);
                setLineWidth(3);
            } else {
                UI.setColor(lineColor);
                setLineWidth(undoStack.peek().lineWidth);
            }
        } else { 
            UI.println("Undo stack is empty");
        }
    }
    /**
     * Undoes the undo
     */
    public void redo() {
        if (!redoStack.isEmpty()) {
            Stroke line = redoStack.pop();

            line.draw();
            undoStack.push(line);
        } else {
            UI.println("Redo stack is empty");
        }
    }
    /**
     * Changes line width
     */
    public void setLineWidth(double width) {
        UI.setLineWidth(width);
        lineWidth = width;
    }
    /**
     * Changes the colour of the line being drawn
     */
    public void setColor() {
        lineColor = JColorChooser.showDialog(null, "Line Colour", Color.white);
        btnLineCol.setBackground(lineColor);
    }
    
    public static void main(String[] arguments){
        new Pencil().setupGUI();
    }
}



