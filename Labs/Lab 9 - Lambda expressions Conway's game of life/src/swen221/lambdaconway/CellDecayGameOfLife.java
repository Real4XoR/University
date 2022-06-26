// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.lambdaconway;

import static swen221.lambdaconway.GameOfLife.*;

import swen221.lambdaconway.model.*;
import swen221.lambdaconway.util.Pair;
import swen221.lambdaconway.util.Point;
import swen221.lambdaconway.view.BoardFrame;

public class CellDecayGameOfLife {
	/**
	 * The standard rule set for Conway's "Game of Life".
	 */
	public static final Rule[] CellDecayRules = {
			// TODO: The underproduction rule
			(Pair<Point,Board> p) -> neighbours(p) <2 ?  p.second().getCellState(p.first().getX(), p.first().getY())+1 : null,
			// TODO: The reproduction rule
			(Pair<Point,Board> p) -> neighbours(p) ==2 ?   p.second().getCellState(p.first().getX(), p.first().getY()):null,
			// TODO: The overpopulation rule
			(Pair<Point,Board> p) -> neighbours(p) >3 ?  p.second().getCellState(p.first().getX(), p.first().getY())+1:null,
			//happiness rule
			(Pair<Point,Board>p)-> neighbours(p) ==3 ?  p.second().getCellState(p.first().getX(), p.first().getY())-1:null,
	
	};
	
	/**
	 * The entry point for the GameOfLife application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Board board = new Board(50,50);
		Simulation sim = new Simulation(board,CellDecayRules);
		new BoardFrame(sim);
	}
}
