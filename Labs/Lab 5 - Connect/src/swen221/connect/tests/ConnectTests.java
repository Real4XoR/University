// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.connect.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import swen221.connect.core.Board;
import swen221.connect.core.Game;
import swen221.connect.util.Position;

public class ConnectTests {

	//Valid tests

	@Test public void validTest_01() {
		String output = "|_|_|_|_|\n" +
						"|_|_|_|_|\n" +
						"|_|_|_|_|\n" +
						"|_|_|_|_|\n";

		Board board = new Board();

		assertEquals(output,board.toString());
	}
	@Test public void validTest_02() {
		String output = "|B|_|_|_|\n" +
						"|_|_|_|_|\n" +
						"|_|_|_|_|\n" +
						"|_|_|_|_|\n";

		Board board = new Board();

		assertEquals(output,board.toString());
	}
	@Test public void validTest_03() {
		String output = "|W|_|_|_|\n" +
						"|_|_|_|_|\n" +
						"|_|_|_|_|\n" +
						"|_|_|_|_|\n";

		Board board = new Board();

		assertEquals(output,board.toString());
	}
	@Test public void validTest_04() {
		String output = "|W|_|_|_|\n" +
						"|_|_|_|_|\n" +
						"|_|_|B|_|\n" +
						"|_|_|_|_|\n";

		Board board = new Board();

		assertEquals(output,board.toString());
	}

	//Invalid tests

	@Test public void invalidTest_01() {
		String output = "|_|_|_|_|W\n" +
						"|_|_|_|_|\n" +
						"|_|_|_|_|\n" +
						"|_|_|_|_|\n";

		Board board = new Board();

		assertNotEquals(output,board.toString());
	}

}
