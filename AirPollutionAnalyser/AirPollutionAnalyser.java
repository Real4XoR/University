// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP-102-112 - 2021T1, Assignment 9
 * Name: Natha Cobbald
 * Username: cobbalnath
 * ID: 300475719
 */

import ecs100.*;
import java.util.*;
import java.nio.file.*;
import java.io.*;
import java.awt.Color;

/**
 * AirPollutionAnalyser analyses hourly data about PM2.5 concentration of five
 * cities in China in October, November and December in 2015.
 * Each line of the file "pollution.txt" has information about the pollution
 * level and weather in a city at a particular hour and date.
 * Data is from https://archive.ics.uci.edu/ml/datasets.php.
 *
 * Core: two methods:
 *   loadData
 *      Loads the data from a file into a field containing an ArrayList of
 *      AirPollution objects.
 *      Hint: read all the lines from the file, and then take each line
 *            apart into the values to pass to the AirPollution constructor.
 *   findHazardousLevels
 *      Prints out all the records in the ArrayList that have a
 *      PM2.5 concentration 300 and over.
 *      Hint: see the methods in the AirPollution class, especially getPM and toString
 *
 * Completion: one method:
 *   findContrastingCities
 *      Compares each record in the list with every other record and finds
 *      every pair of cities that having a difference of PM2.5 concentration
 *      larger than 400, at the same hour on the same day.
 *      For each pair, it should print cityA, cityB, hour, date, difference
 *
 * Challenge: two methods
 *   findDailyAverage(String city)
 *      -Prints the average daily PM2.5 value for each day for the given city.
 *      -Finds the longest sequence of days there the average PM2.5 is always
 *       above 200 ("Very unhealthy").
 *      Hint: Use an array where the index corresponds to the day of the year.
 *   plotPollutionLevels
 *      Makes a line plot for the daily average PM2.5 concentration data of
 *      the five cities in the same figure. You may choose different colours
 *      to represent different cities.
 *      Hint: Make the findDailyAverage(String city) method return the array
 *      for a given city.
 */

public class AirPollutionAnalyser {

    private ArrayList<AirPollution> pollutions = new ArrayList<AirPollution>();

    /**
     * CORE
     *
     * Load data from the data file into the pollutions field:
     * clear the pollutions field.
     * Read lines from file
     * For each line, use Scanner to break up each line and make an AirPollution
     *  adding it to the pollutions field.
     */
    public void loadData() {
        String filename = "pollution.txt";
        try {
            Scanner sc = new Scanner(Path.of(filename));
            while (sc.hasNext()) {
                String city = sc.next();
                String date = sc.next();
                int hour = sc.nextInt();
                double pm = sc.nextDouble();
                double humidity = sc.nextDouble();
                double tempeture = sc.nextDouble();
                pollutions.add(new AirPollution(city, date, hour, pm, humidity, tempeture));
            } 
        
            UI.printf("Loaded %d pollution information into list\n", this.pollutions.size());
            UI.println("----------------------------");
        } catch(IOException e){UI.println("File reading failed");}  
    }

    /**
     * CORE
     *
     * Prints out all the records in the ArrayList that have a PM2.5 concentration
     * 300 and over
     */
    public void findHazardousLevels() {
        UI.clearText();
        UI.println("PM2.5 Concentration 300 and above:");
        for (AirPollution city : pollutions) {
            if (city.getPM() >= 300) {
                UI.println(city);
            }
        }

        UI.println("------------------------");
    }

    /**
     * COMPLETION
     * 
     * Finds every pair of cities that have at the same hour on the same day 
     * a difference of PM2.5 concentration larger than 400.
     * You need to compare each record in the list with every other record
     * For each pair, it should print
     * cityA, cityB, hour, date, difference
     */
    public void findContrastingCities() {
        UI.clearText();
        UI.println("Pairs of cities whose PM2.5 differs by more than 400 at the same time");
        for (int i = 0; i < pollutions.size(); i++) {
            for (int j = 0; j >= 400; j++) {
                if ( i != j && pollutions.get(i).getHour() == pollutions.get(j).getHour() && pollutions.get(i).getDate() == pollutions.get(j).getDate()); {
                    UI.println();
                }
            }
        }

        UI.println("----------------------------");
    }

    public void findDailyAverage() {
        
    }
    
    public void PlotLevels() {
        UI.clearPanes();
    }
    
    // ------------------ Set up the GUI (buttons) ------------------------
    /** Make buttons to let the user run the methods */
    public void setupGUI() {
        UI.initialise();
        UI.addButton("Load", this::loadData);
        UI.addButton("Hazardous Levels", this::findHazardousLevels);
        UI.addButton("Contrasting Cities", this::findContrastingCities);
        UI.addButton("Daily Average", this::findDailyAverage);
        UI.addButton("Plot", this::PlotLevels);
        UI.addButton("Quit", UI::quit);
        UI.setDivider(1.0); // text pane only
    }

    public static void main(String[] arguments) {
        AirPollutionAnalyser obj = new AirPollutionAnalyser();
        obj.setupGUI();
    }

}
