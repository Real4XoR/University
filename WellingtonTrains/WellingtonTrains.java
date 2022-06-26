// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP103 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP103 - 2021T2, Assignment 2
 * Name: Nathan Cobbald
 * Username: cobbalnath
 * ID: 300574719
 */

import ecs100.*;
import java.util.*;
import java.util.Map.Entry;
import java.io.*;
import java.nio.file.*;

/**
 * WellingtonTrains
 * A program to answer queries about Wellington train lines and timetables for
 *  the train services on those train lines.
 *
 * See the assignment page for a description of the program and what you have to do.
 */

public class WellingtonTrains{
    //Fields to store the collections of Stations and Lines
    private Map<String, Station> allStations = new HashMap<String, Station>();
    private Map<String, TrainLine> allLines = new HashMap<String, TrainLine>();
    
    // Fields for the suggested GUI.
    private String stationName;        // station to get info about, or to start journey from
    private String lineName;           // train line to get info about.
    private String destinationName;
    private int startTime = 0;         // time for enquiring about

    /**
     * main method:  load the data and set up the user interface
     */
    public static void main(String[] args){
        WellingtonTrains wel = new WellingtonTrains();
        wel.loadData();   // load all the data
        wel.setupGUI();   // set up the interface
    }

    /**
     * Load data files
     */
    public void loadData(){
        loadStationData();
        UI.println("Loaded Stations");
        loadTrainLineData();
        UI.println("Loaded Train Lines");
        // The following is only needed for the Completion and Challenge
        loadTrainServicesData();
        UI.println("Loaded Train Services");
    }

    /**
     * User interface has buttons for the queries and text fields to enter stations and train line
     * You will need to implement the methods here.
     */
    public void setupGUI(){
        UI.addButton("All Stations",        this::listAllStations);
        UI.addButton("Stations by name",    this::listStationsByName);
        UI.addButton("All Lines",           this::listAllTrainLines);
        UI.addTextField("Station",          (String name) -> {this.stationName=name;});
        UI.addTextField("Train Line",       (String name) -> {this.lineName=name;});
        UI.addTextField("Destination",      (String name) -> {this.destinationName=name;});
        UI.addTextField("Time (24hr)",      (String time) ->
        {try{this.startTime=Integer.parseInt(time);}catch(Exception e){UI.println("Enter four digits");}});
        UI.addButton("Lines of Station",    () -> {listLinesOfStation(this.stationName);});
        UI.addButton("Stations on Line",    () -> {listStationsOnLine(this.lineName);});
        UI.addButton("Stations connected?", () -> {checkConnected(this.stationName, this.destinationName);});
        UI.addButton("Next Services",       () -> {findNextServices(this.stationName, this.startTime);});
        UI.addButton("Find Trip",           () -> {findTrip(this.stationName, this.destinationName, this.startTime);});

        UI.addButton("Quit", UI::quit);
        UI.setMouseListener(this::doMouse);

        UI.setWindowSize(900, 400);
        UI.setDivider(0.2);
        // this is just to remind you to start the program using main!
        if (allStations.isEmpty()){
            UI.setFontSize(36);
            UI.drawString("Start the program from main", 2, 36);
            UI.drawString("in order to load the data", 2, 80);
            UI.sleep(2000);
            UI.quit();
        }
        else {
            UI.drawImage("data/geographic-map.png", 0, 0);
            UI.drawString("Click to list closest stations", 2, 12);
        }
    }

    public void doMouse(String action, double x, double y){
        if (action.equals("released")){
            closestStation(x, y);
        }
    }

    // Methods for loading data and answering queries
    /**
     * Loads all of the data from stations.data into a hashmap
     */
    public void loadStationData() {
        String filename = "data/stations.data";
        try {
            Scanner sc = new Scanner(Path.of(filename));
            while (sc.hasNext()) {
                String name = sc.next();
                int zone = sc.nextInt();
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                Station currentStation = new Station(name, zone, x, y);
                allStations.put(name, currentStation);
            }
        } catch (IOException e) {UI.println("Loading stations failed" + e);}
    }
    /**
     * Loads all of the data from train-lines.data into a hashmap
     */
    public void loadTrainLineData() {
        String filename = "data/train-lines.data";

        try {
            Scanner sc = new Scanner(Path.of(filename));
            while (sc.hasNext()) {
                String name = sc.next();
                TrainLine currentTrainLine = new TrainLine(name);
                allLines.put(name, currentTrainLine);
                
                String stationdata = "data/"+name+"-stations.data";
                Scanner sc2 = new Scanner(Path.of(stationdata));
                while (sc2.hasNext()) {
                    String stationName = sc2.next();
                    Station station = allStations.get(stationName);
                    currentTrainLine.addStation(station);
                    station.addTrainLine(currentTrainLine);
                }
            }
        } catch (IOException e) {UI.println("Loading train lines failed" + e);}
    }
    public void loadTrainServicesData() {
        
    }
    /**
     * lists the 10 closest stations and converts the pixels to Km's
     */
    public void closestStation(double x1, double y1) {
        UI.clearText();
        UI.println("10 stations closest to " + x1 + ", " + y1);
        UI.println("====================");
        Map<Double, String> closest = new TreeMap<Double, String>();
        for (Map.Entry<String, Station> station : allStations.entrySet()) {
            Station currentClicked = station.getValue();
            double x2 = currentClicked.getXCoord();
            double y2 = currentClicked.getYCoord();
            closest.put(Math.hypot(Math.abs(x1-x2)/10, Math.abs(y1-y2)), currentClicked.getName());
        }
        int count = 0;
        for (Map.Entry<Double, String> close : closest.entrySet()) {
            UI.printf("%.2fkm: %s\n", close.getKey(), close.getValue());
            count++;
            if(count >= 10) {break;}
        }
    }
    /**
     * Lists all the the stations
     */
    public void listAllStations() {
        UI.clearText();
        for (String name : allStations.keySet()) {
            UI.println(allStations.get(name));
        }
    }
    /**
     * Lists all the stations alphabetically
     */
    public void listStationsByName() { 
        UI.clearText();
        Map<String, Station> sortedMap = new TreeMap<>();
        //I decided to put everything into a TreeMap as they are automatically sorted alphabetically
        sortedMap.putAll(allStations);
        
        for (String name : sortedMap.keySet()) {
            UI.println(sortedMap.get(name));
        }
    }
    /**
     * Lists all the train lines that are availible in the region
     */
    public void listAllTrainLines() {
        UI.clearText();
        for (String name : allLines.keySet()) {
            UI.println(allLines.get(name));
        }
    }
    /**
     * lists every line that runs through the specified station
     */
    public void listLinesOfStation(String StationName) {
        UI.clearText();
        UI.println("-All lines that go through " + StationName + "-");
        
        for (TrainLine trainline : allStations.get(StationName).getTrainLines()) {
            if (allStations.containsKey(StationName)) {                
                for (String name : allLines.keySet()) {
                    UI.println(allLines.get(name));
                }
            }
            else {
                UI.println("Station doesn't exist");
            }
        }
    }
    /**
     * Lists stations that run along specified line
     */
    public void listStationsOnLine(String lineName) {
        UI.clearText();
        UI.println("-All stations on the " + lineName + "line-");
        if (allLines.containsKey(lineName)) {
            for (String name : allStations.keySet()) {
                UI.println(allStations.get(name));
            }
        }
        else {
            UI.println("No stations on selected line");
        }
    }
    public void checkConnected(String stationName, String destinationName) {
        UI.clearText();
        boolean found = false;
        ArrayList<TrainLine> connected = new ArrayList();
        connected.clear();
        
        for (TrainLine start : allStations.get(stationName).getTrainLines()) {
            connected.add(start);
            for (TrainLine end : allStations.get(destinationName).getTrainLines()) {
                if (connected.get(0).equals(end)) {
                    found = true;
                }
            }
        }
        UI.println(connected.get(1));

        if (found = true) {
            UI.println(stationName + " and " + destinationName + " are connected");
        }
        else {
            UI.println("These stations aren't connected");
        }
    }
    public void findNextServices(String StationName, int startTime) {
        //Tried getting it to work althoug I don't know how to use the getters properly lmao
        /**List <TrainService> services = allLines.getTrainServices();
        List<Station> stationsOnLine = allLines.getStations();
        int index = 0;
        
        for (int i = 0 ; i < allLines.getStations().size(); i++) {
            if (stationsOnLine.get(index).equals(StationName)) {
                index = i;
                break;
            }
        }
        TreeSet<Integer> timesAtStation = new TreeSet<>();
        for (TrainService service : services) {
            timesAtStation.add(service.getTimes().get(index));
        }
        for (int time : timesAtStation) {
            if (time > startTime && time != -1) {
                UI.println(allLines.getName() + ": " + time);
            }
        }*/
    }
    public void findTrip(String stationName, String destinationLine, int startTime) {
        
    }
}
