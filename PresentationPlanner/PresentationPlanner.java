// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP103 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP103 - 2021T3, Assignment 1
 * Name: Nathan Cobbald
 * Username:cobbalnath
 * ID: 300574719
 */

import ecs100.*;
import java.awt.Color;
import java.util.*;
import java.io.*;
import java.nio.file.*;

/**
 * PresentationPlanner allows a user to create and view (as a slide presentation) a presentation consisting of images with descriptive text.
 *
 * This class contains the main method of the program, the GUI setup, and
 * all the methods that respond to buttons, mouse, and keys.
 * 
 * @author pondy and monique
 */
public class PresentationPlanner {

    public static final double SMALL_HEIGHT = 221;  // size of images when editing list and for the library
    public static final double SMALL_WIDTH = 40.8;  // size of images when editing list and for the library
    public static final double GAP = 5;             // gap between images when editing
    public static final double TOP_LIBRARY = 500;

    // Fields to store the ImageInfo objects in the presentation and the library 
    public String name;
    public String description;
    public double delay = 1000; //time delay between each image during the presentation
    
    public List<ImageInfo> allImages = new ArrayList<ImageInfo>(); //List of all images
    public List<ImageInfo> presentationImages = new ArrayList<ImageInfo>(); //List of images in the presentation
    
    private int currentImage = -1;     // index of currently selected image in thumbnails 

    private int candidate = -1;        // index of currently selected image in library of candidates 

    private boolean presentationRunning;      // flag signalling whether the slidepresentation is running or not

    /**
     * Load the library of images
     */
    public void loadLibrary() {
        String filename = "list-of-images.txt";
        try {
            Scanner sc = new Scanner(Path.of(filename));
            while (sc.hasNext()) {
                String name = sc.next();
                String description = sc.nextLine();
                allImages.add(new ImageInfo(name, description));
            }
            displayLibrary();
        } catch(IOException e){UI.println("File reading failed " + e);}        
    }

    /**
     * Display the thumbnails in the presentation and the library
     * highlighting the selected images
     * Will be called after
     *  - each change to the list of images in the presentation or
     *  - after selecting a thumbnail 
     */
    public void display(){
        UI.clearGraphics();
        displayThumbnails();
        displayLibrary();
        // Setting line width and colour aswell as drawing the highlights around the selected image
        UI.setColor(Color.red);
        UI.setLineWidth(4);
        if (!allImages.isEmpty() && candidate != -1) { // Highlight for library images
            UI.drawRect((SMALL_WIDTH + GAP) * candidate, TOP_LIBRARY, SMALL_WIDTH+2, SMALL_HEIGHT+2);
        }
        if (!presentationImages.isEmpty() && currentImage != -1) { // Highlight for presentation images
            UI.drawRect((SMALL_WIDTH + GAP) * currentImage, 20, SMALL_WIDTH+2, SMALL_HEIGHT+2);
        }
    }

    /**
     * Display the thumbnails of all the images in the presentation
     * across the top of the graphics pane.
     * Hint: use the displaySmall(...) method in ImageInfo
     */
    public void displayThumbnails(){
        for (int i = 0; i < presentationImages.size(); i++) { // Looping through all presentation imageg
            presentationImages.get(i).displaySmall((SMALL_WIDTH + GAP) * i, 30, SMALL_WIDTH, SMALL_HEIGHT);
        }
    }

    /**
     * Display the library of images across the bottom of the graphics pane.
     * Hint: use the displaySmall(...) method in ImageInfo
     */
    public void displayLibrary() {
        UI.drawString("Library", SMALL_WIDTH/2, TOP_LIBRARY-20);
        for (int i =0; i < allImages.size(); i++) { // Looping through all images loaded in the library
            allImages.get(i).displaySmall((SMALL_WIDTH + GAP) * i , TOP_LIBRARY, SMALL_WIDTH, SMALL_HEIGHT);
        }
    }

    // RUNNING

    /**
     * As long as the presentation isn't already running, and there are some
     * images to show, start the presentation running from the currently selected image.
     * The presentation should keep running indefinitely, as long as the
     * presentationRunning field is still true.
     * Cycles through the images, going back to the start when it gets to the end.
     * The currentImage field should always contain the index of the current image.
     * Hint: use the displayLarge() method in ImageInfo
     */
    public void runPresentation(){
        presentationRunning = true;
        //Checks if the conditions are met then infinitely loops through the presentationImages
        if (!presentationImages.isEmpty() && presentationRunning) {
            while (presentationRunning == true) {
                for (ImageInfo image : presentationImages) {
                    UI.clearGraphics();
                    image.displayLarge();
                    UI.sleep(delay);
                }
            }
        } else { UI.println("No images loaded"); }
    }

    /**
     * Stop the presentation by changing presentationRunning to false.
     * Redisplay the thumbnails in the slide presentation and the library
     */
    public void editPresentation(){
        presentationRunning = false;
        UI.clearGraphics();

        //redisplaying both the libaries
        displayLibrary();
        displayThumbnails();
    }

    // Other Methods (you will need quite a lot of additional methods).
    /**
     * Alters the speed at which the presentation runs
     */
    public void presentationSpeed(double speed) {
        delay = speed;
    }
    public void addBefore() {
        if (presentationRunning) { // Checking if the presentation is running before performing the operation
            UI.println("Cannot alter presentation while it's running");
        } else {
            if (presentationImages.isEmpty() || currentImage == -1 || currentImage == 0) { //Error prevention if list is empty
                presentationImages.add(0, allImages.get(candidate));
            } else {
                presentationImages.add(currentImage-1, allImages.get(candidate));
            }
            display();
        }
    }
    public void addAfter() {
        if (presentationRunning) {
            UI.printMessage("Cannot alter presentation while it is running");
        } else {
            if (presentationImages.isEmpty()) { //Error prevention if list is empty
                presentationImages.add(0, allImages.get(candidate));
            } else {
                presentationImages.add(currentImage+1, allImages.get(candidate));
            }
            display();
        }
    }
    public void moveLeft() {
        if (presentationRunning) {
            UI.printMessage("Cannot alter presentation while it is running");
        } else {
            Collections.swap(presentationImages, currentImage, currentImage-1);
            display();
        }
    }
    public void moveRight() {
        if (presentationRunning) {
            UI.printMessage("Cannot alter presentation while it is running");
        } else {
            Collections.swap(presentationImages, currentImage, currentImage+1);
            display();
        }
    }
    public void moveStart() {
        if (presentationRunning) {
            UI.printMessage("Cannot alter presentation while it is running");
        } else {
            presentationImages.add(0, presentationImages.get(currentImage));
            presentationImages.remove(currentImage);
            display();
        }
    }
    public void moveEnd() {
        if (presentationRunning) {
            UI.printMessage("Cannot alter presentation while it is running");
        } else {
            int end = presentationImages.size();
            presentationImages.add(end, presentationImages.get(currentImage));
            presentationImages.remove(currentImage);
            display();
        }
    }
    public void remove() {
        if (presentationRunning) {
            UI.printMessage("Cannot alter presentation while it is running");
        } else {
            presentationImages.remove(currentImage);
            display();
        }
    }
    public void removeAll() {
        if (presentationRunning) {
            UI.printMessage("Cannot alter presentation while it is running");
        } else {
            presentationImages.removeAll(presentationImages);
            UI.clearGraphics();
            display();
        }
    }
    public void reverse() {
        if (presentationRunning) {
            UI.printMessage("Cannot alter presentation while it is running");
        } else {
            Collections.reverse(presentationImages);
            display();
        }
    }
    public void shuffle() {
        if (presentationRunning) {
            UI.printMessage("Cannot alter presentation while it is running");
        } else {
            Collections.shuffle(presentationImages);
            display();
        }
    }
    //doKey methods
    public void goLeft() {
        currentImage -= 1;
        display();
    }
    public void goRight() {
        currentImage += 1;
        display();
    }
    public void goStart() {
        currentImage = 0;
        display();
    }
    public void goEnd() {
        currentImage = presentationImages.size()-1;
        display();
    }
    // Challenge doKey methods
    public void removeImage() {
        presentationImages.remove(currentImage);
        display();
    }
    public void addImage() {
        addAfter();
    }
    public void changeRow() {
        
    }

    // Methods for the user interface: keys, mouse (for selecting), buttons
    /**
     * Simple Mouse actions to select thumbnails on the presentation or on the library
     */
    public void doMouse(String action, double x, double y){
        if (presentationRunning) return;
        if (action.equals("pressed")) {
            if (onPresentation(y)){
                currentImage = getIndexFromPos(x); // should check if over the end!!!!
            }
            else if (onLibrary(y)){
                candidate = getIndexFromPos(x); // should check if over the end!!!!
            }
        }
        else if (action.equals("released")){
            display();
        }
    }

    /**
     * Is mouse over the presentation 
     */
    public boolean onPresentation(double y){
        return (y >= GAP && y<= GAP+SMALL_HEIGHT);
    }

    /**
     * Is mouse is over the library
     */
    public boolean onLibrary(double y){
        return (y >= TOP_LIBRARY && y<= TOP_LIBRARY+SMALL_HEIGHT*2);
    }

    /**
     * Return the index in the list of the image that the mouse is on.
     * Note, it might return an invalid index!!!!
     */
    public int getIndexFromPos(double x){
        return (int) (x/(SMALL_WIDTH + GAP));
    }

    /**
     * Interprets key presses.
     * works in both editing the list and in the slide presentation.
     */  
    public void doKey(String key) {
        if (key.equals("Left"))         goLeft();
        else if (key.equals("Right"))   goRight();
        else if (key.equals("Home"))    goStart();
        else if (key.equals("End"))     goEnd();
        // Challege 
        else if (key.equals("Delete"))  removeImage();
        else if (key.equals("Insert"))  addImage();
        else if (key.equals("Up"))      changeRow();
        else if (key.equals("Down"))    changeRow();
    }


    /**
     * Initialises the UI window, and sets up the buttons. 
     */
    public void setupGUI() {
        UI.addButton("Load library",     this::loadLibrary);
        UI.addButton("Run presentation", this::runPresentation);
        UI.addButton("Edit presentation",this::editPresentation);
        UI.addButton("add before",       this::addBefore);
        UI.addButton("add after",        this::addAfter);
        UI.addButton("move left",        this:: moveLeft);
        UI.addButton("move right",       this:: moveRight);
        UI.addButton("move to start",    this:: moveStart);
        UI.addButton("move to end",      this:: moveEnd);
        UI.addButton("remove",           this::remove);
        UI.addButton("remove all",       this::removeAll);
        UI.addButton("reverse",          this::reverse);
        UI.addButton("shuffle",          this::shuffle);
        
        UI.addSlider("Presentation speed",100,4000,1000,this::presentationSpeed);
        UI.addButton("Quit",             UI::quit);

        UI.setKeyListener(this::doKey);
        UI.setMouseListener(this::doMouse);
        UI.setWindowSize(1200,800);
        UI.setDivider(0);
        UI.printMessage("Mouse must be over graphics pane to use the keys");
    }

    public static void main(String[] args) {
        PresentationPlanner pp =new PresentationPlanner();
        pp.setupGUI();
    }

}
