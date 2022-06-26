// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP103 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP103 - 2021T3, Assignment 2
 * Name: Nathan Cobbald
 * Username: cobbalnath
 * ID: 300574719
 */

import ecs100.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;

/**
 * EarthquakeSorter
 * Sorts data about a collection of 4335 NZ earthquakes from May 2016 to May 2017
 * Each line of the file "earthquake-data.txt" has a description of one earthquake:
 *   ID time longitude latitude magnitude depth region
 * Data is from http://quakesearch.geonet.org.nz/
 *  Note the earthquakes' ID have been modified to suit this assignment.
 *  Note bigearthquake-data.txt has just the 421 earthquakes of magnitude 4.0 and above
 *   which may be useful for testing, since it is not as big as the full file.
 * 
 * Core:  three methods:
 *   loadData
 *      Loads the data from a file into a field containing an
 *      ArrayList of Earthquake objects.
 *      Hint : to make an Earthquake object, read all the lines from the file
 *              and then take each line apart into the values to pass to the
 *              Earthquake constructor
 *   sortByID
 *      Sorts the list of earthquakes using their natural ordering (based on their ID number).
 *   sortByTime
 *      Sorts the list of earthquakes according to the date and time that they occurred.
 *   
 * Completion: two methods:
 *   sortByRegion
 *      Sorts the list of earthquakes according to region. If two earthquakes have the same
 *      region, they should be sorted by magnitude and then depth.
 *   sortByProximity
 *      Sorts the list of earthquakes according to their proximity (distance) to a given location.
 *   
 * Challenge: one method
 *   sortByProximityChallenge
 *      Sorts the earthquakes by proximity to a location first, but then sorts the earthquakes
 *      within similar distances (i.e. within the same 1 km increment from the location)
 *      according to magnitude and depth.
 */

public class EarthquakeSorter{

    private List<Earthquake> earthquakes = new ArrayList<Earthquake>();

    /*
     * Load data from the data file into the earthquakes field:
     * Clear the earthquakes field.
     * Read lines from file
     * For each line, use Scanner to break up each line and make an Earthquake
     *  adding it to the earthquakes field.
     */
    public void loadData(String filename) {
        try {
            Scanner sc = new Scanner(Path.of(filename));
            while (sc.hasNext()) {
                String ID = sc.next();
                String date = sc.next();
                String time = sc.next();
                double longitude = sc.nextDouble();
                double latitude = sc.nextDouble();
                double depth = sc.nextDouble();
                double magnitude = sc.nextDouble();
                String region = sc.next();
                earthquakes.add(new Earthquake(ID, date, time, longitude, latitude, depth, magnitude, region));
            }
            
            UI.printf("Loaded %d earthquakes into list\n", this.earthquakes.size());
            UI.println("----------------------------");
        } catch(IOException e){UI.println("File reading failed");}
    }

    /**
     * Sorts the earthquakes by ID
     * The file "output-ID.txt" lists the output for the "bigearthquake-data.txt"
     */
    public void sortByID(){
        UI.clearText();
        UI.println("Earthquakes sorted by ID");
        Collections.sort(earthquakes);
        for (Earthquake e : this.earthquakes){
            UI.println(e.toString());
        }
        UI.println("------------------------");
    }

    /**
     * Sorts the list of earthquakes according to the date and time that they occurred.
     * The file "output-Time.txt" lists the output for the "bigearthquake-data.txt"
     */
    public void sortByTime(){
        UI.clearText();
        UI.println("Earthquakes sorted by time");
        Comparator<Earthquake> timeComparator = Comparator.comparing(Earthquake::getDate)
                                                .thenComparing(Earthquake::getTime);
        
        earthquakes.sort(timeComparator);
        for (Earthquake e : this.earthquakes){
            UI.println(e.toString());
        }
        UI.println("------------------------");
    }

    /**
     * Sorts the list of earthquakes according to region. If two earthquakes have the same
     *   region, they should be sorted by magnitude (highest first) and then depth (more shallow first)
     * The file "output-Region.txt" lists the output for the "bigearthquake-data.txt"
     */
    public void sortByRegion(){
        UI.clearText();
        UI.println("Earthquakes sorted by region, then by magnitude and depth");

        Comparator<Earthquake> regionComparator = Comparator.comparing(Earthquake::getRegion)
                                                    .thenComparing(Earthquake::getMagnitude)
                                                    .thenComparing(Earthquake::getDepth);       
        earthquakes.sort(regionComparator);
        for (Earthquake e : this.earthquakes){
            UI.println(e.toString());
        }
        UI.println("------------------------");
    }

    /**
     * Sorts the list of earthquakes according to their proximity (distance) to a given location.
     *   Auckland: -36.8485, 174.7633
     *   Wellington: -41.2865, 174.7762
     *   Christchurch: -43.5321, 172.6362
     *   Queenstown: -45.0312, 168.6626
     *   Dunedin -45.8788, 170.5028
     *   Invercargill: -46.4132, 168.3538
     * The file "output-Proximity-Completion-ChCh.txt" lists the output for the 
     *     "bigearthquake-data.txt" for Christchurch
     * The latitude and longitude of Christchurch are stored in chch.txt
     */
    public void sortByProximity(double latitude, double longitude){
        UI.clearText();
        UI.println("Earthquakes sorted by proximity");
        UI.println("Latitude: " + latitude + " Longitude: " + longitude);  
        
        
        
        UI.println("------------------------");
    }

    /**
     * Sorts the earthquakes by proximity to a location first, but then sorts the earthquakes
     *      within similar distances (i.e. within the same 1 km increment from the location)
     *      according to magnitude (highest first) and depth (more shallow first).
     *   Auckland: -36.8485, 174.7633
     *   Wellington: -41.2865, 174.7762
     *   Christchurch: -43.5321, 172.6362
     *   Queenstown: -45.0312, 168.6626
     *   Dunedin -45.8788, 170.5028
     *   Invercargill: -46.4132, 168.3538
     *
     * The file "output-Proximity-Challenge-ChCh.txt" lists the output for the 
     *     "bigearthquake-data.txt" for Christchurch
     * The latitude and longitude of Christchurch are stored in chch.txt
     */
    public void sortByProximityChallenge(double latitude, double longitude){
        UI.clearText();
        UI.println("Earthquakes sorted according to their distance to a given location first,\n but earthquakes within similar distances (i.e. within the same 1 km increment from the location) are sorted according to magnitude and depth.");
        UI.println("Latitude: " + latitude + " Longitude: " + longitude);
        /*# YOUR CODE HERE */

        UI.println("------------------------");
    }

    /**
     * Add the buttons
     */
    public void setupGUI(){
        UI.initialise();
        UI.addButton("Load", this::loadData);
        UI.addButton("sort by ID",  this::sortByID);
        UI.addButton("sort by Time",  this::sortByTime);
        UI.addButton("sort by Region", this::sortByRegion);
        UI.addButton("sort by Proximity", this::sortByProximity);
        UI.addButton("sort by Proximity CHALLENGE", this::sortByProximityChallenge);
        UI.addButton("Quit", UI::quit);
        UI.setWindowSize(900,400);
        UI.setDivider(1.0);  //text pane only 
    }

    public static void main(String[] arguments){
        EarthquakeSorter obj = new EarthquakeSorter();
        obj.setupGUI();
    }   

    //================================================
    // DO NOT CHANGE ANYTHING BELOW THIS LINE!
    // THESE METHODS ARE REQUIRED FOR MARKING
    //================================================
    public void loadData(){
        this.loadData(UIFileChooser.open("Choose data file"));
    }

    public void sortByProximity(){
        this.sortByProximity(UI.askDouble("Give latitude: "), UI.askDouble("Give longitude: "));
    }

    public void sortByProximityChallenge(){
        this.sortByProximityChallenge(UI.askDouble("Give latitude: "), UI.askDouble("Give longitude: "));
    }

    public List<Earthquake> getEarthquakes(String filename){
        this.earthquakes = new ArrayList<Earthquake>();
        this.loadData(filename);
        return this.earthquakes;
    }

    public List<Earthquake> checkSortByID(List<Earthquake> eq){
        this.earthquakes = eq;
        this.sortByID();
        return this.earthquakes;
    }

    public List<Earthquake> checkSortByTime(List<Earthquake> eq){
        this.earthquakes = eq;
        this.sortByTime();
        return this.earthquakes;
    }

    public List<Earthquake> checkSortByRegion(List<Earthquake> eq){
        this.earthquakes = eq;
        this.sortByRegion();
        return this.earthquakes;
    }

    public List<Earthquake> checkSortByProximity(List<Earthquake> eq, double lat, double longi){
        this.earthquakes = eq;
        this.sortByProximity(lat,longi);
        return this.earthquakes;
    }

    public List<Earthquake> checkSortByProximityChallenge(List<Earthquake> eq, double lat, double longi){
        this.earthquakes = eq;
        this.sortByProximityChallenge(lat, longi);
        return this.earthquakes;
    }
}
