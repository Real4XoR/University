// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP103 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP103 - 2021T3, Assignment 5
 * Name: Nathan Cobbald
 * Username: cobbalnath
 * ID: 300574719
 */

import ecs100.*;
import java.io.*;
import java.util.*;
import java.nio.file.*;

public class BusNetworks {

    /** Map of towns, indexed by their names */
    private Map<String,Town> busNetwork = new HashMap<String,Town>();

    /** CORE
     * Loads a network of towns from a file.
     * Constructs a Set of Town objects in the busNetwork field
     * Each town has a name and a set of neighbouring towns
     * First line of file contains the names of all the towns.
     * Remaining lines have pairs of names of towns that are connected.
     */
    public void loadNetwork(String filename) {
        try {
            busNetwork.clear();
            UI.clearText();
            List<String> lines = Files.readAllLines(Path.of(filename));
            String firstLine = lines.remove(0);
            Scanner sc = new Scanner(firstLine);
            while (sc.hasNext()) {
                String something = sc.next();
                busNetwork.put(something, new Town(something));
            }
            for(String currentLine : lines){
                Scanner neighBourScanner = new Scanner(currentLine); 
                String firstTown = neighBourScanner.next(); 
                String secondTown = neighBourScanner.next();

                busNetwork.get(firstTown).addNeighbour(busNetwork.get(secondTown));
                busNetwork.get(secondTown).addNeighbour(busNetwork.get(firstTown));
            }
            UI.println("Loaded " + busNetwork.size() + " towns:");
        } catch (IOException e) {throw new RuntimeException("Loading data.txt failed" + e);}
    }

    
    /**  CORE
     * Print all the towns and their neighbours:
     * Each line starts with the name of the town, followed by
     *  the names of all its immediate neighbours,
     */
    public void printNetwork() {
        UI.println("The current network: \n====================");
        for (Map.Entry<String, Town> currentEntry : busNetwork.entrySet()) {
            String connectedTowns = "";
            for (Town currentTown : currentEntry.getValue().getNeighbours()) {
                connectedTowns += currentTown.getName() + " ";
            }
            UI.println(currentEntry.getKey() + "-> " + connectedTowns);
        }
    }

    /** COMPLETION
     * Return a set of all the nodes that are connected to the given node.
     * Traverse the network from this node in the standard way, using a
     * visited set, and then return the visited set
     */
    public Set<Town> findAllConnected(Town town) {
        HashSet<Town> visitedTowns = new HashSet<Town>();
        findAllConnectedHelper(town, visitedTowns); // run helper return output
        return visitedTowns;
    }

    public void findAllConnectedHelper(Town town, Set<Town> visitedTowns) {
        for(Town neighbour : town.getNeighbours()){ // for all neighbours of this town
            if(!visitedTowns.contains(neighbour)){ // if inside visited towns do nothing
                visitedTowns.add(neighbour); // else add it to visited
                findAllConnectedHelper(neighbour, visitedTowns); // recursive with its neighbours
            }
        }
    }
    
    /**  COMPLETION
     * Print all the towns that are reachable through the network from
     * the town with the given name.
     * Note, do not include the town itself in the list.
     */
    public void printReachable(String name){
        Town town = busNetwork.get(name);
        if (town==null){
            UI.println(name+" is not a recognised town");
        }
        else {
            UI.println("\nFrom "+town.getName()+" you can get to:");
            for(Town currentTown : findAllConnected(town)){
                if(currentTown != town){
                    UI.println(currentTown);
                }
            }
        }
    }

    /**  COMPLETION
     * Print all the connected sets of towns in the busNetwork
     * Each line of the output should be the names of the towns in a connected set
     * Works through busNetwork, using findAllConnected on each town that hasn't
     * yet been printed out.
     */
    public void printConnectedGroups() {
        UI.println("Groups of Connected Towns: \n================");
        int groupNum = 1;
        HashSet<Town> printedTowns = new HashSet<Town>();
        for(Map.Entry<String, Town> currentEntry : busNetwork.entrySet()){
            if(!printedTowns.contains(currentEntry.getValue())){
                printedTowns.add(currentEntry.getValue());
                String printingLine = "";
                for(Town printedTown : findAllConnected(currentEntry.getValue())){
                    printedTowns.add(printedTown); 
                    printingLine += printedTown.getName() + " "; 
                }

                UI.println("Group " + groupNum + ": " + printingLine);
                groupNum++;
            }
        }
    }

    /**
     * Set up the GUI (buttons and mouse)
     */
    public void setupGUI() {
        UI.addButton("Load", ()->{loadNetwork(UIFileChooser.open());});
        UI.addButton("Print Network", this::printNetwork);
        UI.addTextField("Reachable from", this::printReachable);
        UI.addButton("All Connected Groups", this::printConnectedGroups);
        UI.addButton("Clear", UI::clearText);
        UI.addButton("Quit", UI::quit);
        UI.setWindowSize(1100, 500);
        UI.setDivider(1.0);
        loadNetwork("data-small.txt");
    }

    // Main
    public static void main(String[] arguments) {
        BusNetworks bnw = new BusNetworks();
        bnw.setupGUI();
    }

}
