// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP-102-112 - 2021T1, Assignment 7
 * Name: Nathan Cobbald
 * Username: cobbalnath
 * ID: 300574719
 */

import ecs100.*;
import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JButton;
import java.io.*;

/**
 * A simple drawing program.
 * The user can select from a variety of tools and options using the buttons and
 *   elements down the left side, and can use the mouse to add elements to the drawing
 *   according to the current tool and options
 * Note, most of the "action" in the program happens in response to mouse events;
 *   the buttons, textFields, and sliders mostly record information that is used
 *   later by the mouse responding.
 */


public class MiniPaint{

    // fields to remember:
    //  - the "tool" - what will be drawn when the mouse is next released.
    //                 may be a shape, or an image, or a caption,
    //    [Completion] or freehand, or eraser, or flower
    //  - whether the shape should be filled or not
    //  - the position the mouse was pressed,
    //  - the string for the text caption
    //  - the width of the lines and the font size of the text captions.
    //  - [Completion] the name of the image file
    //  - [Completion] the colors for the border and fill for shapes and captions

    private String tool = "Line";   // the current tool, governing what the mouse will do.
                                    // Initial value is "Line";  changed by the buttons.

    // More fields
    private double x1, y1, x2, y2;
    private boolean Filled = false;
    private double LineWidth;
    private double TextSize = 14;
    private Color LineColor;
    private Color FillColor;
    private JButton btnLineCol;
    private JButton btnFillCol;
    private JButton btnFillNoFill;
    private String currentImage;
    private String Image;
    private String CaptionText;
    private String Text;

    /**
     * Set up the interface: buttons, textfields, sliders,
     * listening to the mouse
    */
    public void setupGUI(){
        UI.setMouseMotionListener(this::doMouse);
        UI.addButton("Clear", UI::clearGraphics);
        UI.addButton("Line", this::doSetLine); 
        UI.addButton("Rectangle", this::doSetRect);
        UI.addButton("Oval", this::doSetOval);
        UI.addButton("Free Draw", this::doSetFreeDraw);
        UI.addTextField("Caption", this::doSetCaption);
        UI.addButton("Choose Image", this::doSetImage);
        UI.addButton("Erase", this::doSetErase);
        
        btnLineCol = UI.addButton("Line Colour", this::SetLineColor);
        btnFillCol = UI.addButton("Fill Colour", this::SetFillColor);
        btnFillNoFill = UI.addButton("No Fill", this::doSetFill);
        
        UI.addSlider("Line Width", 1, 50, 10, this::setLineWidth);
        UI.addSlider("Text Size", 1, 50, 14, this::SetTextSize);
        
        UI.addButton("Quit", UI::quit);
        UI.setDivider(0.0);  // Hide the text area.
    }   


    // Methods to respond to the buttons, textfield, and sliders
    // Mostly, These methods just save information to the fields.
    
    /** Respond to the Line button */
    public void doSetLine(){
        tool = "Line";
    }
    public void doSetRect() {
        tool = "Rect";
    }
    public void doSetOval() {
        tool = "Oval";
    }
    public void doSetCaption(String Text) {
        tool = "Caption";
        CaptionText = Text;
    }
    public void doSetErase() {
        tool = "Erase";
    }
    public void doSetFlower() {
        
    }
    public void doSetFreeDraw() {
        tool = "FreeDraw";
        UI.println("Must select line width to use");
    }
    public void doSetImage() {
        tool = "Image"; //try loop to catch any exception that result in null
        try {
            String currentImage =  UIFileChooser.open("File to draw");
            Image = currentImage;
        } catch(Exception e){UI.println("File read failed: " + e);}
    }
    public Color SetLineColor() {
        LineColor = JColorChooser.showDialog(null, "Line Colour", Color.white);
        btnLineCol.setBackground(LineColor); //Changing button colour when method is called
        return LineColor;
    }
    public Color SetFillColor() {
        FillColor = JColorChooser.showDialog(null, "Fill Colour", Color.white);
        btnFillCol.setBackground(FillColor); //Changing button colour when method is called
        return FillColor;
    }
    public void doSetFill() {
        Filled = !Filled; //Toggling filled back and forth and changing fill buttong depending on the boolean
        if (Filled == true) {
            btnFillNoFill.setText("Filled");
        }
        else {
            btnFillNoFill.setText("No Fill");
        }
    }

    public void setLineWidth(double width) {
        UI.setLineWidth(width);
        LineWidth = width;
    }
    public void SetTextSize(double size) {
        TextSize = size;
    }

    // The method header for doSetLine was given as an example; you will need other methods
    // for each button/textfield/slider
    // See hints in the Assignment description.
    
    /**
     * Respond to mouse events
     * When pressed, remember the position.
     * When released, draw what is specified by current tool
     * Uses the value stored in the field to determine which kind of tool to draw.
     *  It should call the drawALine, drawARectangle, drawAnOval, etc, methods
     *  passing the pressed and released positions
     * [Completion] should respond to "dragged" events also to do erasing and freehand drawing
     */
    public void doMouse(String action, double x, double y) {
        if (action.equals("pressed")) {
            x1 = x;
            y1 = y;
        }
        if (action.equals("released")) {
            x2 = x;
            y2 = y;
            if (tool == "Line") {
                this.drawALine(x1, y1, x2, y2);
            }
            if (tool == "Rect") {
                this.drawARectangle(x1, y1, x2, y2);
            }
            if (tool == "Oval") {
                this.drawAnOval(x1, y1, x2, y2);
            }
            if (tool == "Caption") {
                this.drawACaption(x, y);
            }
            if (tool == "Image") {
                this.drawAnImage(x1, y1, x2, y2);
            }
        }
        else if (action.equals("dragged") && tool.equals("Erase")) {
            this.Erase(x, y);
        }
        else if (action.equals("dragged") && tool.equals("FreeDraw")) {
            this.FreeDraw(x, y);
            UI.sleep(5);
        }
        else if (action.equals("dragged") && tool.equals("Caption")) {
            this.drawACaption(x, y);
        }
    }

    /**
     * Draw a line between the two positions (x1, y1) and (x2, y2)
     */
    public void drawALine(double x1, double y1, double x2, double y2){
        this.setLineWidth(LineWidth);
        UI.setColor(LineColor);
        UI.drawLine(x1, y1, x2, y2);
    }

    /**
     * Draw a rectangle between the two diagonal corners
     * [Completion] Works out the left, top, width, and height 
     * Then draws the rectangle, based on the options
     */
    public void drawARectangle(double x1, double y1, double x2, double y2){
        if (Filled == false) {
            UI.setColor(LineColor);
            UI.drawRect(x1, y1, x2-x1, y2-y1);
        }
        else {
            UI.setColor(FillColor);
            UI.fillRect(x1, y1, x2-x1, y2-y1);
            UI.setColor(LineColor);
            UI.drawRect(x1, y1, x2-x1, y2-y1);
        }
    }

    /**
     * Draw an oval to fit the rectangle between the the two diagonal corners
     * [Completion] Works out the left, top, width, and height 
     * Then draws the oval, based on the options
     */
    public void drawAnOval(double x1, double y1, double x2, double y2){
        if (Filled == false) {
            UI.setColor(LineColor);
            UI.drawOval(x1, y1, x2-x1, y2-y1);
        }
        if (Filled == true) {
            UI.setColor(FillColor);
            UI.fillOval(x1, y1, x2-x1, y2-y1);
            UI.setColor(LineColor);
            UI.drawOval(x1, y1, x2-x1, y2-y1);
        }

    }
    public void Erase(double x, double y) {
        UI.setColor(Color.white);
        UI.fillOval(x-10, y-10, 20, 20); //Making sure erase is centered on mouse
    }
    public void FreeDraw(double x, double y) { 
        //Not necasary it was just fun to do some free drawing
        UI.setColor(LineColor);
        UI.fillOval(x-(LineWidth/2), y-(LineWidth/2), LineWidth, LineWidth); //Making sure free draw is centered on mouse
    }

    /** 
     * Draws the current caption at the mouse released point.
     */
    public void drawACaption(double x, double y){
        UI.setFontSize(TextSize);
        UI.setColor(LineColor);
        UI.drawString(CaptionText, x, y);
    }

    /** [Completion]
     * Draws the current image between the two diagonal corners, unless
     *  they are very close, and then just draws the image at its natural size
     *  Works out the left, top, width, and height 
     * Then draws the image, if there is one.
     */
    public void drawAnImage(double x1, double y1, double x2, double y2){
        if (x2-x1 < 10 || y2-y1 < 10) { //If image is to small it will draw it at its normal size
            UI.drawImage(Image, x1, y1);
        }
        else {
            UI.drawImage(Image, x1, y1, x2-x1, y2-y1);
        }
    }

    /** [Completion]
     * Draws a simple flower with 6 petals, centered at (x,y) with the given radius
     */
    public void drawAFlower(double x, double y, double radius){

    }
    
    // Main:  constructs a new MiniPaint object and set up GUI
    public static void main(String[] arguments){
        MiniPaint mp = new MiniPaint();
        mp.setupGUI();
    }
}


