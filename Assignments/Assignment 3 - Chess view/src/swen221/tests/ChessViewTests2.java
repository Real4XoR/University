package swen221.tests;

import java.util.List;

import org.junit.Test;

import org.opentest4j.AssertionFailedError;
import swen221.chessview.Board;
import swen221.chessview.ChessGame;
import swen221.chessview.Position;
import swen221.chessview.Round;
import swen221.chessview.moves.*;
import swen221.chessview.pieces.*;

import static org.junit.jupiter.api.Assertions.*;

public class ChessViewTests2 {

	// ================================================
	// Valid Tests
	// ================================================


	@Test public void testValid_01() {
		String input =
			"a2-a3\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|P|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_02() {
		String input =
			"a2-a3 b7-b6\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|_|p|p|p|p|p|p|\n" +
			"6|_|p|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|P|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_03() {
		String input =
			"a2-a4 b7-b5\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|_|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|p|_|_|_|_|_|_|\n" +
			"4|P|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_04() {
		String input =
			"d2-d4 d7-d5\n" +
			"e2-e4 d5xe4\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|_|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|P|p|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|_|_|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_05() {
		String input =
			"d2-d3 d7-d5\n" +
			"e2-e4 d5xe4\n" +
			"d3xe4\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|_|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|P|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|_|_|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_06() {
		String input =
			"Nb1-c3\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|_|_|N|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|_|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_07() {
		String input =
			"Nb1-a3\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|_|_|\n" +
			"3|N|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|P|P|P|P|\n" +
			"1|R|_|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_08() {
		String input =
			"d2-d4 Nb8-c6\n" +
			"e2-e4 Nc6xd4\n" +
			"";
		String output =
			"8|r|_|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|n|P|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|_|_|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_09() {
		String input =
			"Nb1-c3 e7-e5\n" +
			"e2-e3 e5-e4\n" +
			"Nc3xe4\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|_|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|_|_|_|_|N|_|_|_|\n" +
			"3|_|_|_|_|P|_|_|_|\n" +
			"2|P|P|P|P|_|P|P|P|\n" +
			"1|R|_|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_10() {
		String input =
			"d2-d3 d7-d5\n" +
			"Bc1-g5 Bc8-g4\n" +
			"";
		String output =
			"8|r|n|_|q|k|b|n|r|\n" +
			"7|p|p|p|_|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|p|_|_|B|_|\n" +
			"4|_|_|_|_|_|_|b|_|\n" +
			"3|_|_|_|P|_|_|_|_|\n" +
			"2|P|P|P|_|P|P|P|P|\n" +
			"1|R|N|_|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_11() {
		String input =
			"d2-d3 d7-d5\n" +
			"Bc1-g5 Bc8-g4\n" +
			"Bg5-h4\n" +
			"";
		String output =
			"8|r|n|_|q|k|b|n|r|\n" +
			"7|p|p|p|_|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|p|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|b|B|\n" +
			"3|_|_|_|P|_|_|_|_|\n" +
			"2|P|P|P|_|P|P|P|P|\n" +
			"1|R|N|_|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_12() {
		String input =
			"d2-d3 d7-d5\n" +
			"Bc1-g5 Bc8-g4\n" +
			"Bg5xe7\n" +
			"";
		String output =
			"8|r|n|_|q|k|b|n|r|\n" +
			"7|p|p|p|_|B|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|p|_|_|_|_|\n" +
			"4|_|_|_|_|_|_|b|_|\n" +
			"3|_|_|_|P|_|_|_|_|\n" +
			"2|P|P|P|_|P|P|P|P|\n" +
			"1|R|N|_|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_13() {
		String input =
			"e2-e4 e7-e5\n" +
			"Qd1-g4 Qd8-h4\n" +
			"Qg4-f4 Qh4-h6\n" +
			"Qf4-f6 Qh6xh2\n" +
			"";
		String output =
			"8|r|n|b|_|k|b|n|r|\n" +
			"7|p|p|p|p|_|p|p|p|\n" +
			"6|_|_|_|_|_|Q|_|_|\n" +
			"5|_|_|_|_|p|_|_|_|\n" +
			"4|_|_|_|_|P|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|P|P|P|P|_|P|P|q|\n" +
			"1|R|N|B|_|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}
	@Test public void testValid_14() {
		String input =
			"a2-a4 h7-h5\n" +
			"Ra1-a3 Rh8-h6\n" +
			"Ra3-d3 Rh6-g6\n" +
			"Rd3xd7\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|_|\n" +
			"7|p|p|p|R|p|p|p|_|\n" +
			"6|_|_|_|_|_|_|r|_|\n" +
			"5|_|_|_|_|_|_|_|p|\n" +
			"4|P|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|_|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Castling white side.
	 */
	@Test public void testValid_15() {
		String input =
				"Ng1-f3 Nb8-a6\n" +
				"e2-e4 e7-e5\n" +
				"Bf1-d3 h7-h5\n" +
				"O-O\n" +
				"";
		String output =
				"8|r|_|b|q|k|b|n|r|\n" +
				"7|p|p|p|p|_|p|p|_|\n" +
				"6|n|_|_|_|_|_|_|_|\n" +
				"5|_|_|_|_|p|_|_|p|\n" +
				"4|_|_|_|_|P|_|_|_|\n" +
				"3|_|_|_|B|_|N|_|_|\n" +
				"2|P|P|P|P|_|P|P|P|\n" +
				"1|R|N|B|Q|_|R|K|_|\n" +
				"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test hash code
	 */
	@Test public void testValid_16() {
		String input =
				"a2-a4 h7-h5\n" +
				"Ra1-a3 Rh8-h6\n" +
				"Ra3-d3 Rh6-g6\n" +
				"Rd3xd7\n" +
				"";
		String output =
				"8|r|n|b|q|k|b|n|_|\n" +
				"7|p|p|p|R|p|p|p|_|\n" +
				"6|_|_|_|_|_|_|r|_|\n" +
				"5|_|_|_|_|_|_|_|p|\n" +
				"4|P|_|_|_|_|_|_|_|\n" +
				"3|_|_|_|_|_|_|_|_|\n" +
				"2|_|P|P|P|P|P|P|P|\n" +
				"1|_|N|B|Q|K|B|N|R|\n" +
				"  a b c d e f g h";

		Position pos = new Position(4,1);
		assertEquals(4^1, pos.hashCode());
	}

	/**
	 * Test to string.
	 */
	@Test public void testValid_17() {
		String input =
				"a2-a4 h7-h5\n" +
				"Ra1-a3 Rh8-h6\n" +
				"Ra3-d3 Rh6-g6\n" +
				"Rd3xd7\n" +
				"";
		String output =
				"8|r|n|b|q|k|b|n|_|\n" +
				"7|p|p|p|R|p|p|p|_|\n" +
				"6|_|_|_|_|_|_|r|_|\n" +
				"5|_|_|_|_|_|_|_|p|\n" +
				"4|P|_|_|_|_|_|_|_|\n" +
				"3|_|_|_|_|_|_|_|_|\n" +
				"2|_|P|P|P|P|P|P|P|\n" +
				"1|_|N|B|Q|K|B|N|R|\n" +
				"  a b c d e f g h";

		Position pos = new Position(4,1);
		assertEquals("a4", pos.toString());
	}

	@Test public void testValid_18() {
		String output = "Hi";
		Position pos = new Position(4,1);
		assertEquals(false, pos.equals(output));
	}

	/**
	 * Test en passant.
	 */
	@Test public void testValid_19() {
		String input =
				"f2-f4 a7-a5\n" +
				"f4-f5 e7-e5\n" +
				"f5xe6ep\n" +
				"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
				"7|_|p|p|p|_|p|p|p|\n" +
				"6|_|_|_|_|P|_|_|_|\n" +
				"5|p|_|_|_|_|_|_|_|\n" +
				"4|_|_|_|_|_|_|_|_|\n" +
				"3|_|_|_|_|_|_|_|_|\n" +
				"2|P|P|P|P|P|_|P|P|\n" +
				"1|R|N|B|Q|K|B|N|R|\n" +
				"  a b c d e f g h";

		check(input,output);
	}


	/**
	 * Test pawn take pawn
	 */
	@Test public void testValid_20() {
		String input =
				"b2-b4 a7-a5\n" +
				"b4xa5\n" +
				"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
				"7|_|p|p|p|p|p|p|p|\n" +
				"6|_|_|_|_|_|_|_|_|\n" +
				"5|P|_|_|_|_|_|_|_|\n" +
				"4|_|_|_|_|_|_|_|_|\n" +
				"3|_|_|_|_|_|_|_|_|\n" +
				"2|P|_|P|P|P|P|P|P|\n" +
				"1|R|N|B|Q|K|B|N|R|\n" +
				"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test pawn takes rook and test pawn promotion
	 */
	@Test public void testValid_21() {
		String input =
				"b2-b4 a7-a5\n" +
				"b4xa5 Ra8xa5\n" +
				"c2-c4 Ra5-b5\n" +
				"c4xRb5 h7-h5\n" +
				"a2-a4 g7-g5\n" +
				"a4-a5 f7-f5\n" +
				"a5-a6 e7-e5\n" +
				"a6-a7 d7-d5\n" +
				"a7-a8=N\n" +
				"";
		String output =
				"8|N|n|b|q|k|b|n|r|\n" +
				"7|_|p|p|_|_|_|_|_|\n" +
				"6|_|_|_|_|_|_|_|_|\n" +
				"5|_|P|_|p|p|p|p|p|\n" +
				"4|_|_|_|_|_|_|_|_|\n" +
				"3|_|_|_|_|_|_|_|_|\n" +
				"2|_|_|_|P|P|P|P|P|\n" +
				"1|R|N|B|Q|K|B|N|R|\n" +
				"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test en passant - black.
	 **/
	@Test public void testValid_22() {
		String input =
				"e2-e3 b7-b5\n" +
				"g2-g3 b5-b4\n" +
				"a2-a4 b4xa3ep" +
				"";

		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
				"7|p|_|p|p|p|p|p|p|\n" +
				"6|_|_|_|_|_|_|_|_|\n" +
				"5|_|_|_|_|_|_|_|_|\n" +
				"4|_|_|_|_|_|_|_|_|\n" +
				"3|p|_|_|_|P|_|P|_|\n" +
				"2|_|P|P|P|_|P|_|P|\n" +
				"1|R|N|B|Q|K|B|N|R|\n" +
				"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Check PieceImpl if object is not PieceImpl
	 */
	@Test public void testValid_23() {
		String output = "Hi";
		Queen q = new Queen(true);
		assertEquals(false, q.equals(output));
	}

	/**
	 * Test valid position.
	 */
	@Test public void testValid_24() {
		Position pos = new Position(1,8);
		assertEquals(true, pos.isValid());
	}

	/**
	 * Test invalid position
	 */
	@Test public void testValid_25() {
		Position pos = new Position(0,9);
		assertEquals(false, pos.isValid());
	}

	/**
	 * Simple pawn tests and pawn take pawn.
	 */
	@Test public void testValid_26() {
		String input =
				"d2-d4 e7-e5\n" +
				"e2-e3 d7-d5\n" +
				"c2-c4 d5xc4\n" +
				"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
				"7|p|p|p|_|_|p|p|p|\n" +
				"6|_|_|_|_|_|_|_|_|\n" +
				"5|_|_|_|_|p|_|_|_|\n" +
				"4|_|_|p|P|_|_|_|_|\n" +
				"3|_|_|_|_|P|_|_|_|\n" +
				"2|P|P|_|_|_|P|P|P|\n" +
				"1|R|N|B|Q|K|B|N|R|\n" +
				"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Simple bishop move tests.
	 */
	@Test public void testValid_27() {
		String input =
						"d2-d4 d7-d5\n" +
						"e2-e4 e7-e5\n" +
						"Bc1-e3 Bc8-g4\n" +
						"Bf1-c4 Bf8-a3\n" +
						"";
		String output =
						"8|r|n|_|q|k|_|n|r|\n" +
						"7|p|p|p|_|_|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|p|p|_|_|_|\n" +
						"4|_|_|B|P|P|_|b|_|\n" +
						"3|b|_|_|_|B|_|_|_|\n" +
						"2|P|P|P|_|_|P|P|P|\n" +
						"1|R|N|_|Q|K|_|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Simple bishop move tests.
	 */
	@Test public void testValid_28() {
		String input =
						"e2-e4 e7-e5\n" +
						"Bf1-a6 Bf8-a3\n" +
						"Ba6xb7 Ba3xb2\n" +
						"";
		String output =
						"8|r|n|b|q|k|_|n|r|\n" +
						"7|p|B|p|p|_|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|p|_|_|_|\n" +
						"4|_|_|_|_|P|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|b|P|P|_|P|P|P|\n" +
						"1|R|N|B|Q|K|_|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Simple knight move tests.
	 */
	@Test public void testValid_29() {
		String input =
						"Ng1-f3 Ng8-f6\n" +
						"c2-c3 Nf6-e4\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|_|r|\n" +
						"7|p|p|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|n|_|_|_|\n" +
						"3|_|_|P|_|_|N|_|_|\n" +
						"2|P|P|_|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|_|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Simple knight take test.
	 */
	@Test public void testValid_30() {
		String input =
						"Nb1-c3 b7-b5\n" +
						"Nc3xb5\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|_|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|N|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|P|P|P|P|\n" +
						"1|R|_|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Pawn take test.
	 */
	@Test public void testValid_31() {
		String input =
						"c2-c3 b7-b5\n" +
						"c3-c4 b5xc4\n" +
						"h2-h4\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|_|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|p|_|_|_|_|P|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|_|P|P|P|P|_|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test valid King move
	 */
	@Test public void testValid_32() {
		String input =
						"g2-g4 d7-d6\n" +
						"h2-h4 Ke8-d7\n" +
						"";
		String output =
						"8|r|n|b|q|_|b|n|r|\n" +
						"7|p|p|p|k|p|p|p|p|\n" +
						"6|_|_|_|p|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|P|P|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|P|P|_|_|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test valid King take
	 */
	@Test public void testValid_33() {
		String input =
						"a2-a4 e7-e6\n" +
						"b2-b4 Bf8-e7\n" +
						"c2-c4 Be7-g5\n" +
						"d2-d4 Bg5-d2+\n" +
						"Ke1xBd2\n" +
						"";
		String output =
						"8|r|n|b|q|k|_|n|r|\n" +
						"7|p|p|p|p|_|p|p|p|\n" +
						"6|_|_|_|_|p|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|P|P|P|P|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|_|_|_|K|P|P|P|P|\n" +
						"1|R|N|B|Q|_|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test valid Black castle
	 */
	@Test public void testValid_34() {
		String input =
						"a2-a4 e7-e5\n" +
						"b2-b3 Ng8-f6\n" +
						"c2-c3 Bf8-c5\n" +
						"d2-d3 O-O\n" +
						"";
		String output =
						"8|r|n|b|q|_|r|k|_|\n" +
						"7|p|p|p|p|_|p|p|p|\n" +
						"6|_|_|_|_|_|n|_|_|\n" +
						"5|_|_|b|_|p|_|_|_|\n" +
						"4|P|_|_|_|_|_|_|_|\n" +
						"3|_|P|P|P|_|_|_|_|\n" +
						"2|_|_|_|_|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test valid Black king move - to the side
	 */
	@Test public void testValid_35() {
		String input =
						"a2-a4 d7-d5\n" +
						"c2-c4 Qd8-d6\n" +
						"b2-b4 Ke8-d8\n" +
						"";
		String output =
						"8|r|n|b|k|_|b|n|r|\n" +
						"7|p|p|p|_|p|p|p|p|\n" +
						"6|_|_|_|q|_|_|_|_|\n" +
						"5|_|_|_|p|_|_|_|_|\n" +
						"4|P|P|P|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|_|_|_|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test valid Black king take
	 */
	@Test public void testValid_36() {
		String input =
						"f2-f4 e7-e5\n" +
						"Ke1-f2 a7-a5\n" +
						"Kf2-e3 b7-b6\n" +
						"Ke3-e4 h7-h5\n" +
						"Ke4xe5 f7-f5\n" +
						"Ke5xf5\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|_|_|p|p|_|_|p|_|\n" +
						"6|_|p|_|_|_|_|_|_|\n" +
						"5|p|_|_|_|_|K|_|p|\n" +
						"4|_|_|_|_|_|P|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|P|_|P|P|\n" +
						"1|R|N|B|Q|_|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	@Test public void testValid_37() {
		Position p = new Position(0,0);
		assertFalse(p.isValid());

		p = new Position(0,9);
		assertFalse(p.isValid());

		p = new Position(9,0);
		assertFalse(p.isValid());

		p = new Position(3,9);
		assertFalse(p.isValid());

		p = new Position(9,9);
		assertFalse(p.isValid());

		p = new Position(9,3);
		assertFalse(p.isValid());

		p = new Position(-1,-1);
		assertFalse(p.isValid());

		p = new Position(8,1);
		assertTrue(p.isValid());

		p = new Position(1,1);
		assertTrue(p.isValid());

		p = new Position(8,-1);
		assertFalse(p.isValid());

		p = new Position(-1,8);
		assertFalse(p.isValid());
	}

	/**
	 * Valid en passants
	 */
	@Test public void testValid_38() {
		String input =
						"a2-a4 h7-h5\n" +
						"a4-a5 b7-b5\n" +
						"a5xb6ep c7-c5\n" +
						"g2-g4 c5-c4\n" +
						"d2-d4 c4xd3ep\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|_|_|p|p|p|p|_|\n" +
						"6|_|P|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|p|\n" +
						"4|_|_|_|_|_|_|P|_|\n" +
						"3|_|_|_|p|_|_|_|_|\n" +
						"2|_|P|P|_|P|P|_|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Valid check
	 */
	@Test public void testValid_39() {
		String input =
						"d2-d4 e7-e5\n" +
						"d4-d5 Ke8-e7\n" +
						"d5-d6+ c7xd6\n" +
						"";
		String output =
						"8|r|n|b|q|_|b|n|r|\n" +
						"7|p|p|_|p|k|p|p|p|\n" +
						"6|_|_|_|p|_|_|_|_|\n" +
						"5|_|_|_|_|p|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|_|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Valid check for left side castling on white
	 */
	@Test public void testValid_40() {
		String input =
						"d2-d4 a7-a5\n" +
						"Qd1-d3 b7-b6\n" +
						"Bc1-e3 c7-c5\n" +
						"Nb1-a3 d7-d6\n" +
						"O-O-O\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|_|_|_|_|p|p|p|p|\n" +
						"6|_|p|_|p|_|_|_|_|\n" +
						"5|p|_|p|_|_|_|_|_|\n" +
						"4|_|_|_|P|_|_|_|_|\n" +
						"3|N|_|_|Q|B|_|_|_|\n" +
						"2|P|P|P|_|P|P|P|P|\n" +
						"1|_|_|K|R|_|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Valid check for left side castling on black
	 */
	@Test public void testValid_41() {
		String input =
						"h2-h4 d7-d5\n" +
						"g2-g4 Qd8-d6\n" +
						"f2-f4 Bc8-e6\n" +
						"e2-e4 Nb8-a6\n" +
						"d2-d4 O-O-O\n" +
						"";
		String output =
						"8|_|_|k|r|_|b|n|r|\n" +
						"7|p|p|p|_|p|p|p|p|\n" +
						"6|n|_|_|q|b|_|_|_|\n" +
						"5|_|_|_|p|_|_|_|_|\n" +
						"4|_|_|_|P|P|P|P|P|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|_|_|_|_|_|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Throws exception if white move null.
	 */
	@Test public void testValid_42() {
		assertThrows(IllegalArgumentException.class, () -> {Round r = new Round(null, new SinglePieceMove(new Bishop(true), new Position(3, 8), new Position(4, 7)));});
	}

	/**
	 * Test move to string
	 */
	@Test public void testValid_43() {
		Move m = new SinglePieceMove(new Bishop(true), new Position(8, 3), new Position(7, 4));
		Move mm = new SinglePieceMove(new Bishop(false), new Position(1, 3), new Position(2, 4));
		Round r = new Round(m,mm);
		assertEquals(r.toString(), "Bc8-d7 Bc1-d2");
	}

	/**
	 * Test move to string
	 */
	@Test public void testValid_44() {
		Move m = new SinglePieceMove(new Bishop(true), new Position(8, 3), new Position(7, 4));
		Round r = new Round(m,null);
		assertEquals(r.toString(), "Bc8-d7");
	}

	/**
	 * Test En Passant
	 */
	@Test public void testValid_45() {
		String input =
						"h2-h4 b7-b5\n" +
						"g2-g4 b5-b4\n" +
						"a2-a4 b4xa3ep\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|_|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|P|P|\n" +
						"3|p|_|_|_|_|_|_|_|\n" +
						"2|_|P|P|P|P|P|_|_|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test En Passant
	 */
	@Test public void testValid_46() {
		String input =
						"a2-a4 d7-d5\n" +
						"a4-a5 b7-b5\n" +
						"a5xb6ep\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|_|p|_|p|p|p|p|\n" +
						"6|_|P|_|_|_|_|_|_|\n" +
						"5|_|_|_|p|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|_|P|P|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test Pawn Promotion to Queen
	 */
	@Test public void testValid_47() {
		String input =
						"a2-a4 b7-b5\n" +
						"a4xb5 Nb8-c6\n" +
						"b5-b6 a7-a5\n" +
						"Nb1-c3 Bc8-a6\n" +
						"Ng1-h3 e7-e6\n" +
						"b6-b7 Qd8-h4\n" +
						"b7-b8=Q+ Ke8-e7\n" +
						"";
		String output =
						"8|r|Q|_|_|_|b|n|r|\n" +
						"7|_|_|p|p|k|p|p|p|\n" +
						"6|b|_|n|_|p|_|_|_|\n" +
						"5|p|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|q|\n" +
						"3|_|_|N|_|_|_|_|N|\n" +
						"2|_|P|P|P|P|P|P|P|\n" +
						"1|R|_|B|Q|K|B|_|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test toString for check
	 */
	@Test public void testValid_48() {
		MultiPieceMove m = new SinglePieceMove(new Bishop(true), new Position(8, 3), new Position(7, 4));
		Check c = new Check(m);
		assertEquals("Bc8-d7+",c.toString());
	}

	/**
	 * Test skip no space
	 */
	@Test public void testValid_50() {
		String input =
						"h2-h4 b7-b5\n" +
						""+
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|_|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|p|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|P|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|P|P|P|_|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test Pawn Promotion to Rock
	 */
	@Test public void testValid_51() {
		String input =
				"a2-a4 b7-b5\n" +
						"a4xb5 Nb8-c6\n" +
						"b5-b6 a7-a5\n" +
						"Nb1-c3 Bc8-a6\n" +
						"Ng1-h3 e7-e6\n" +
						"b6-b7 Qd8-h4\n" +
						"b7-b8=R+ Ke8-e7\n" +
						"";
		String output =
						"8|r|R|_|_|_|b|n|r|\n" +
						"7|_|_|p|p|k|p|p|p|\n" +
						"6|b|_|n|_|p|_|_|_|\n" +
						"5|p|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|q|\n" +
						"3|_|_|N|_|_|_|_|N|\n" +
						"2|_|P|P|P|P|P|P|P|\n" +
						"1|R|_|B|Q|K|B|_|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test Pawn Promotion to Bishop
	 */
	@Test public void testValid_52() {
		String input =
				"a2-a4 b7-b5\n" +
						"a4xb5 Nb8-c6\n" +
						"b5-b6 a7-a5\n" +
						"Nb1-c3 Bc8-a6\n" +
						"Ng1-h3 e7-e6\n" +
						"b6-b7 Qd8-h4\n" +
						"b7-b8=B\n" +
						"";
		String output =
						"8|r|B|_|_|k|b|n|r|\n" +
						"7|_|_|p|p|_|p|p|p|\n" +
						"6|b|_|n|_|p|_|_|_|\n" +
						"5|p|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|q|\n" +
						"3|_|_|N|_|_|_|_|N|\n" +
						"2|_|P|P|P|P|P|P|P|\n" +
						"1|R|_|B|Q|K|B|_|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}


    /**
            * Test pieceChar of singlepiecemove - Pawn
     */
    @Test public void testValid_53() {
        SinglePieceMove spm = new SinglePieceMove(new Pawn(true), new Position(3, 3), new Position(4, 3));
        assertEquals("c3-c4",spm.toString());
    }

    /**
     * Test pieceChar of singlepiecemove - Knight
     */
    @Test public void testValid_54() {
        SinglePieceMove spm = new SinglePieceMove(new Knight(true), new Position(1, 7), new Position(3, 6));
        assertEquals("Ng1-f3",spm.toString());
    }

    /**
     * Test pieceChar of singlepiecemove - Bishop
     */
    @Test public void testValid_55() {
        SinglePieceMove spm = new SinglePieceMove(new Bishop(true), new Position(1, 6), new Position(2, 5));
        assertEquals("Bf1-e2",spm.toString());
    }

    /**
     * Test pieceChar of singlepiecemove - Rook
     */
    @Test public void testValid_56() {
        SinglePieceMove spm = new SinglePieceMove(new Rook(true), new Position(1, 1), new Position(2, 1));
        assertEquals("Ra1-a2",spm.toString());
    }

    /**
     * Test pieceChar of singlepiecemove - Queen
     */
    @Test public void testValid_57() {
        SinglePieceMove spm = new SinglePieceMove(new Queen(true), new Position(1, 1), new Position(2, 1));
        assertEquals("Qa1-a2",spm.toString());
    }

    /**
     * Test pieceChar of singlepiecemove - King
     */
    @Test public void testValid_58() {
        SinglePieceMove spm = new SinglePieceMove(new King(true), new Position(1, 1), new Position(2, 1));
        assertEquals("Ka1-a2",spm.toString());
    }

	/**
	 * Castling to string, kingside true.
	 */
	@Test public void testValid_59() {
		Castling c = new Castling(true,true);
		assertEquals("O-O", c.toString());
	}

	/**
	 * Castling to string, kingside false;
	 */
	@Test public void testValid_60() {
		Castling c = new Castling(true,false);
		assertEquals("O-O-O", c.toString());
	}

	/**
	 * Take knight.
	 */
	@Test public void testValid_61() {
		String input =
						"b2-b4 Nb8-c6\n" +
						"b4-b5 f7-f6\n"+
						"b5xNc6\n"+
						"";
		String output =
						"8|r|_|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|p|_|p|p|\n" +
						"6|_|_|P|_|_|p|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|_|P|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test for check and taking piece with Queen.
	 */
	@Test public void testValid_62() {
		String input =
				"e2-e3 h7-h6\n" +
				"Bf1-c4 a7-a5\n" +
				"Qd1-f3 g7-g5\n" +
				"Qf3xf7+\n" +
				"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
				"7|_|p|p|p|p|Q|_|_|\n" +
				"6|_|_|_|_|_|_|_|p|\n" +
				"5|p|_|_|_|_|_|p|_|\n" +
				"4|_|_|B|_|_|_|_|_|\n" +
				"3|_|_|_|_|P|_|_|_|\n" +
				"2|P|P|P|P|_|P|P|P|\n" +
				"1|R|N|B|_|K|_|N|R|\n" +
				"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test for check and taking piece with Queen.
	 */
	@Test public void testValid_99() {
		String input =
				"e2-e3 h7-h6\n" +
						"Bf1-c4 a7-a5\n" +
						"Qd1-f3 g7-g5\n" +
						"Qf3xf7+\n" +
						"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
						"7|_|p|p|p|p|Q|_|_|\n" +
						"6|_|_|_|_|_|_|_|p|\n" +
						"5|p|_|_|_|_|_|p|_|\n" +
						"4|_|_|B|_|_|_|_|_|\n" +
						"3|_|_|_|_|P|_|_|_|\n" +
						"2|P|P|P|P|_|P|P|P|\n" +
						"1|R|N|B|_|K|_|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}



	/**
	 * Test queen to take rook.
	 */
	@Test public void testValid_100() {
		String input =
				"a2-a4 h7-h5\n" +
				"Ra1-a3 Rh8-h6\n" +
				"Ra3-d3 Rh6-g6\n" +
				"Rd3xd7 Qd8xRd7\n" +
				"";
		String output =
				"8|r|n|b|_|k|b|n|_|\n" +
				"7|p|p|p|q|p|p|p|_|\n" +
				"6|_|_|_|_|_|_|r|_|\n" +
				"5|_|_|_|_|_|_|_|p|\n" +
				"4|P|_|_|_|_|_|_|_|\n" +
				"3|_|_|_|_|_|_|_|_|\n" +
				"2|_|P|P|P|P|P|P|P|\n" +
				"1|_|N|B|Q|K|B|N|R|\n" +
				"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test
	 */
	@Test public void testValid_101() {
		String input =
				"a2-a4 h7-h5\n" +
						"Ra1-a3 Rh8-h6\n" +
						"Ra3-d3 Rh6-g6\n" +
						"Rd3xd7 Qd8xRd7\n" +
						"";
		String output =
				"8|r|n|b|_|k|b|n|_|\n" +
						"7|p|p|p|q|p|p|p|_|\n" +
						"6|_|_|_|_|_|_|r|_|\n" +
						"5|_|_|_|_|_|_|_|p|\n" +
						"4|P|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|_|P|P|P|P|P|P|P|\n" +
						"1|_|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}



	// ================================================
	// Invalid Tests
	// ================================================

	@Test public void testInvalid_01() {
		String input =
			"a2-a4 a7-a4\n" +
			"";
		String output =
			"8|r|n|b|q|k|b|n|r|\n" +
			"7|p|p|p|p|p|p|p|p|\n" +
			"6|_|_|_|_|_|_|_|_|\n" +
			"5|_|_|_|_|_|_|_|_|\n" +
			"4|P|_|_|_|_|_|_|_|\n" +
			"3|_|_|_|_|_|_|_|_|\n" +
			"2|_|P|P|P|P|P|P|P|\n" +
			"1|R|N|B|Q|K|B|N|R|\n" +
			"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Using en passant on wrong row.
	 */
	@Test public void testInvalid_02() {
		String input =
				"f2-f4 e7-e5\n" +
				"h2-h4 e5-e4\n" +
				"f4xe5ep\n" +
				"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
				"7|p|p|p|p|_|p|p|p|\n" +
				"6|_|_|_|_|_|_|_|_|\n" +
				"5|_|_|_|_|_|_|_|_|\n" +
				"4|_|_|_|_|p|P|_|P|\n" +
				"3|_|_|_|_|_|_|_|_|\n" +
				"2|P|P|P|P|P|_|P|_|\n" +
				"1|R|N|B|Q|K|B|N|R|\n" +
				"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test taking own pawn with en passant.
	 */
	@Test public void testInvalid_03() {
		String input =
				"f2-f4 a7-a5\n" +
				"f4-f5 b7-b5\n" +
				"e2-e4 c7-c5\n" +
				"e4-e5 d7-d5\n" +
				"f5xe6ep\n" +
				"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
				"7|_|_|_|_|p|p|p|p|\n" +
				"6|_|_|_|_|_|_|_|_|\n" +
				"5|p|p|p|p|P|P|_|_|\n" +
				"4|_|_|_|_|_|_|_|_|\n" +
				"3|_|_|_|_|_|_|_|_|\n" +
				"2|P|P|P|P|_|_|P|P|\n" +
				"1|R|N|B|Q|K|B|N|R|\n" +
				"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test en passant.
	 */
	@Test public void testInvalid_05() {
		String input =
				"f2-f4 e7-e5\n" +
				"f4-f5 a7-a5\n" +
				"f5xe6ep\n" +
				"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
				"7|_|p|p|p|_|p|p|p|\n" +
				"6|_|_|_|_|_|_|_|_|\n" +
				"5|p|_|_|_|p|P|_|_|\n" +
				"4|_|_|_|_|_|_|_|_|\n" +
				"3|_|_|_|_|_|_|_|_|\n" +
				"2|P|P|P|P|P|_|P|P|\n" +
				"1|R|N|B|Q|K|B|N|R|\n" +
				"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test invalid move - black first
	 */
	@Test public void testInvalid_06() {
		String input =
				"b7-b5\n" +
				"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
				"7|p|p|p|p|p|p|p|p|\n" +
				"6|_|_|_|_|_|_|_|_|\n" +
				"5|_|_|_|_|_|_|_|_|\n" +
				"4|_|_|_|_|_|_|_|_|\n" +
				"3|_|_|_|_|_|_|_|_|\n" +
				"2|P|P|P|P|P|P|P|P|\n" +
				"1|R|N|B|Q|K|B|N|R|\n" +
				"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test invalid move - black checked try to move.
	 */
	@Test public void testInvalid_07() {
		String input =
				"e2-e4 d7-d5\n" +
				"e4xd5 h7-h5\n" +
				"Bf1-b5+ g7-g5\n" +
				"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
				"7|p|p|p|_|p|p|p|_|\n" +
				"6|_|_|_|_|_|_|_|_|\n" +
				"5|_|B|_|P|_|_|_|p|\n" +
				"4|_|_|_|_|_|_|_|_|\n" +
				"3|_|_|_|_|_|_|_|_|\n" +
				"2|P|P|P|P|_|P|P|P|\n" +
				"1|R|N|B|Q|K|_|N|R|\n" +
				"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test pawn promotes to pawn and testing en passant.
	 */
	@Test public void testInvalid_08() {
		String input =
			"a2-a3 d7-d5\n" +
			"b2-b3 d5-d4\n" +
			"c2-c4 d4xc3ep\n" +
			"Bc1-b2 c3xBb2\n" +
			"Qd1-c1 b2xQc1=Q\n" +
			"";
		String output = "8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|_|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|P|P|_|_|_|_|_|_|\n" +
						"2|_|_|_|P|P|P|P|P|\n" +
						"1|R|N|q|_|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Simple pawn test. Invalid pawn move.
	 */
	@Test public void testInvalid_09() {
		String input =
						"e2-e3 c7-c6\n" +
						"e3-e5\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|_|p|p|p|p|p|\n" +
						"6|_|_|p|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|P|_|_|_|\n" +
						"2|P|P|P|P|_|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Simple pawn test. Invalid pawn take.
	 */
	@Test public void testInvalid_10() {
		String input =
						"c2-c4 d7-d5\n" +
						"c4-c5 d5-d4\n" +
						"c5xd4\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|_|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|P|_|_|_|_|_|\n" +
						"4|_|_|_|p|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|_|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test bishop take itself
	 */
	@Test public void testInvalid_11() {
		String input =
						"e2-e4 e7-e5\n" +
						"Bf1xBf1\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|_|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|p|_|_|_|\n" +
						"4|_|_|_|_|P|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|_|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test bishop move to invalid position - diagonal through piece
	 */
	@Test public void testInvalid_12() {
		String input =
						"e2-e4 e7-e5\n" +
						"Bf1-h3\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|_|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|p|_|_|_|\n" +
						"4|_|_|_|_|P|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|_|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test bishop move to invalid position - move a non-bishop piece diagonally
	 */
	@Test public void testInvalid_13() {
		String input =
						"e2-e4 e7-e5\n" +
						"Bf2-e3\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|_|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|p|_|_|_|\n" +
						"4|_|_|_|_|P|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|_|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test queen move to invalid position - move a non-queen piece
	 */
	@Test public void testInvalid_14() {
		String input =
						"d2-d4 d7-d5\n" +
						"Qf2-e3\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|_|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|p|_|_|_|_|\n" +
						"4|_|_|_|P|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|_|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test queen move to invalid position - move through a piece
	 */
	@Test public void testInvalid_15() {
		String input =
						"d2-d4 d7-d5\n" +
						"Qd1-b3\n" +
						"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|_|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|p|_|_|_|_|\n" +
						"4|_|_|_|P|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|_|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test rook to move invalid position - move rook throw pawn
	 */
	@Test public void testInvalid_16() {
		String input =
						"Rh1-h4\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test rook to move invalid position - move a non-rook piece
	 */
	@Test public void testInvalid_17() {
		String input =
						"Rh2-h4\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}


	/**
	 * Test rook to move invalid position - move a rook to get wrong piece (wrong input)
	 */
	@Test public void testInvalid_18() {
		String input =
						"h2-h4 g7-g5\n" +
						"h4xg5 a7-a6\n" +
						"Rh1xBh7\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|_|p|p|p|p|p|_|p|\n" +
						"6|p|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|P|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|P|P|P|_|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test queen move to invalid position - move a queen to get wrong piece (wrong input)
	 */
	@Test public void testInvalid_19() {
		String input =
						"d2-d4 c7-c5\n" +
						"d4xc5 h7-h6\n" +
						"Qd1xBd7\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|_|p|p|p|p|_|\n" +
						"6|_|_|_|_|_|_|_|p|\n" +
						"5|_|_|P|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|_|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test Knight to invalid position - Move non-knight piece as a knight.
	 */
	@Test public void testInvalid_20() {
		String input =
						"Nh2-g4\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test Knight to invalid position - move a knight to get wrong piece (wrong input)
	 */
	@Test public void testInvalid_21() {
		String input =
						"Ng1-f3 b7-b6\n" +
						"Nf3-g5 b6-b5\n" +
						"Ng5xBh7\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|_|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|p|_|_|_|_|N|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|_|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test Knight to invalid position - Take piece not specified correctly
	 */
	@Test public void testInvalid_22() {
		String input =
						"Nb1-c3 b7-b5\n" +
						"Nc3xBb5\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|_|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|p|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|N|_|_|_|_|_|\n" +
						"2|P|P|P|P|P|P|P|P|\n" +
						"1|R|_|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test Knight to invalid position
	 */
	@Test public void testInvalid_23() {
		String input =
						"Nb1-c3 h7-h6\n" +
						"Nc3-a3\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|p|p|p|_|\n" +
						"6|_|_|_|_|_|_|_|p|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|N|_|_|_|_|_|\n" +
						"2|P|P|P|P|P|P|P|P|\n" +
						"1|R|_|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test invalid pawn moves
	 */
	@Test public void testInvalid_24() {
		String input =
						"b2-b3 d7-d5\n" +
						"b3-b4 d5-d4\n" +
						"b4-b5 d4-d3\n" +
						"d2-d4\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|_|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|P|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|p|_|_|_|_|\n" +
						"2|P|_|P|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test invalid pawn moves - take nothing
	 */
	@Test public void testInvalid_25() {
		String input =
						"b2xa3\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Move bishop like pawn
	 */
	@Test public void testInvalid_26() {
		String input =
						"c2-c3 b7-b5\n" +
						"c1-c2\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|_|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|p|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|P|_|_|_|_|_|\n" +
						"2|P|P|_|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Land on another piece.
	 */
	@Test public void testInvalid_27() {
		String input =
						"b2-b4 b7-b5\n" +
						"b4-b5\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|_|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|p|_|_|_|_|_|_|\n" +
						"4|_|P|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|_|P|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Take piece as pawn but not same specified
	 */
	@Test public void testInvalid_28() {
		String input =
						"c2-c4 b7-b5\n" +
						"c4xQb5\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|_|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|p|_|_|_|_|_|_|\n" +
						"4|_|_|P|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|_|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Take piece with pawn in ways that dont work
	 */
	@Test public void testInvalid_29() {
		String input =
						"c2-c4 c7-c5\n" +
						"c4xc5\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|_|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|p|_|_|_|_|_|\n" +
						"4|_|_|P|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|_|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Take piece with pawn in ways that dont work - missing 1 diagonal square
	 */
	@Test public void testInvalid_30() {
		String input =
						"c2-c4 d7-d6\n" +
						"c4xd6\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|_|p|p|p|p|\n" +
						"6|_|_|_|p|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|P|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|_|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Take piece with pawn in ways that dont work - missing 1 diagonal square
	 */
	@Test public void testInvalid_31() {
		String input =
						"c2-c4 d7-d6\n" +
						"c4xd5\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|_|p|p|p|p|\n" +
						"6|_|_|_|p|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|P|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|_|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Take piece with pawn in ways that dont work - backwards sideways
	 */
	@Test public void testInvalid_32() {
		String input =
				"b2-b4 c7-c5\n" +
				"b4-b5 c5-c4\n" +
				"b5xc4\n" +
				"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|_|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|P|_|_|_|_|_|_|\n" +
						"4|_|_|p|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|_|P|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Invalid move with King - through pieces and move as knight
	 */
	@Test public void testInvalid_33() {
		String input =
						"Ke1-d3\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Invalid move with King - take non existant piece
	 */
	@Test public void testInvalid_34() {
		String input =
				"Ke1xe7\n" +
						"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Invalid move with King - take own piece in front
	 */
	@Test public void testInvalid_35() {
		String input =
						"Ke1xe2\n" +
						"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test King take non specified piece
	 */
	@Test public void testInvalid_36() {
		String input =
						"a2-a4 e7-e6\n" +
						"b2-b4 Bf8-e7\n" +
						"c2-c4 Be7-g5\n" +
						"d2-d4 Bg5-d2\n" +
						"Ke1xNd2\n" +
						"";
		String output =
						"8|r|n|b|q|k|_|n|r|\n" +
						"7|p|p|p|p|_|p|p|p|\n" +
						"6|_|_|_|_|p|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|P|P|P|P|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|_|_|_|b|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test King take non specified piece
	 */
	@Test public void testInvalid_37() {
		String input =
						"a2-a4 e7-e6\n" +
						"b2-b4 Bf8-e7\n" +
						"c2-c4 Be7-g5\n" +
						"d2-d4 Bg5-d2+\n" +
						"Ke1xNd3\n" +
						"";
		String output =
						"8|r|n|b|q|k|_|n|r|\n" +
						"7|p|p|p|p|_|p|p|p|\n" +
						"6|_|_|_|_|p|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|P|P|P|P|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|_|_|_|b|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Invalid move with King - move onto square with piece present.
	 */
	@Test public void testInvalid_38() {
		String input =
				"Ke1-e2\n" +
						"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Invalid move with King - move through
	 */
	@Test public void testInvalid_39() {
		String input =
				"Ke1-e2\n" +
						"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test King move square cant get
	 */
	@Test public void testInvalid_40() {
		String input =
				"a2-a4 e7-e6\n" +
						"b2-b4 Bf8-e7\n" +
						"c2-c4 Be7-g5\n" +
						"d2-d4 h7-h5\n" +
						"Ke1-a2\n" +
						"";
		String output =
						"8|r|n|b|q|k|_|n|r|\n" +
						"7|p|p|p|p|_|p|p|_|\n" +
						"6|_|_|_|_|p|_|_|_|\n" +
						"5|_|_|_|_|_|_|b|p|\n" +
						"4|P|P|P|P|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|_|_|_|_|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test King take non specified piece
	 */
	@Test public void testInvalid_41() {
		String input =
				"a2-a4 e7-e6\n" +
						"b2-b4 Bf8-e7\n" +
						"c2-c4 Be7-g5\n" +
						"d2-d4 h7-h5\n" +
						"Ke1-h3\n" +
						"";
		String output =
				"8|r|n|b|q|k|_|n|r|\n" +
						"7|p|p|p|p|_|p|p|_|\n" +
						"6|_|_|_|_|p|_|_|_|\n" +
						"5|_|_|_|_|_|_|b|p|\n" +
						"4|P|P|P|P|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|_|_|_|_|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Invalid move with Knight - move inexistant
	 */
		@Test public void testInvalid_42() {
				String input =
						"Ng1-h5\n" +
						"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Invalid en passant
	 */
	@Test public void testInvalid_43() {
		String input =
						"g2-g4 b7-b5\n" +
						"a2-a3 b5-b4\n" +
						"a3-a4 b4xa3ep\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|_|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|P|p|_|_|_|_|P|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|_|P|P|P|P|P|_|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Invalid en passant
	 */
	@Test public void testInvalid_44() {
		String input =
						"d2-d4 e7-e5\n" +
						"d4-d5 a7-a5\n" +
						"d5xe6ep\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|_|p|p|p|_|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|p|_|_|P|p|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|_|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test invalid en passant
	 */
	@Test public void testInvalid_45() {
		String input =
						"d2-d4 e7-e5\n" +
						"d4-d5 a7-a5\n" +
						"d5xe6ep\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|_|p|p|p|_|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|p|_|_|P|p|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|_|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test King move into check.
	 */
	@Test public void testInvalid_46() {
		String input =
						"e2-e4 e7-e5\n" +
						"Ke1-e2 d7-d5\n" +
						"Ke2-d3 c7-c5\n" +
						"Kd3-c4\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|_|_|_|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|p|p|p|_|_|_|\n" +
						"4|_|_|_|_|P|_|_|_|\n" +
						"3|_|_|_|K|_|_|_|_|\n" +
						"2|P|P|P|P|_|P|P|P|\n" +
						"1|R|N|B|Q|_|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test invalid Black king take
	 */
	@Test public void testInvalid_47() {
		String input =
				"f2-f4 e7-e5\n" +
						"Ke1-f2 a7-a5\n" +
						"Kf2-e3 b7-b6\n" +
						"Ke3-e4 h7-h5\n" +
						"Ke4xe5 f7-f5\n" +
						"Ke5xBf5\n" +
						"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
						"7|_|_|p|p|_|_|p|_|\n" +
						"6|_|p|_|_|_|_|_|_|\n" +
						"5|p|_|_|_|K|p|_|p|\n" +
						"4|_|_|_|_|_|P|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|P|_|P|P|\n" +
						"1|R|N|B|Q|_|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test invalid Black king take
	 */
	@Test public void testInvalid_48() {
		String input =
						"f2-f4 e7-e5\n" +
						"Ke1-f2 a7-a5\n" +
						"Kf2-e3 b7-b6\n" +
						"Ke3-e4 h7-h5\n" +
						"Ke4xe5 f7-f5\n" +
						"Ke5xd4\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|_|_|p|p|_|_|p|_|\n" +
						"6|_|p|_|_|_|_|_|_|\n" +
						"5|p|_|_|_|K|p|_|p|\n" +
						"4|_|_|_|_|_|P|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|P|_|P|P|\n" +
						"1|R|N|B|Q|_|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Invalid King move
	 */
	@Test public void testInvalid_49() {
		String input =
						"d2-d4 e7-e5\n" +
						"Ke1-a5\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|_|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|p|_|_|_|\n" +
						"4|_|_|_|P|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|_|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input, output);
	}

	/**
	 * Test king can't move more than one space vertically at once
	 */
	@Test public void testInvalid_50() {
		String input =
				"e2-e4 f7-f6\n" +
						"e4-e6" +
						"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|p|_|p|p|\n" +
						"6|_|_|_|_|_|p|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|P|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|_|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test king can't take own pawn
	 */
	@Test public void testInvalid_51() {

		String input =
				"e2-e4 e7-e5\n" +
						"Ke1-e2 Ke8-e7\n" +
						"Ke2-e3 Ke7-e6\n" +
						"Ke3xe4" +
						"";
		String output =
				"8|r|n|b|q|_|b|n|r|\n" +
						"7|p|p|p|p|_|p|p|p|\n" +
						"6|_|_|_|_|k|_|_|_|\n" +
						"5|_|_|_|_|p|_|_|_|\n" +
						"4|_|_|_|_|P|_|_|_|\n" +
						"3|_|_|_|_|K|_|_|_|\n" +
						"2|P|P|P|P|_|P|P|P|\n" +
						"1|R|N|B|Q|_|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test invalid en passant
	 */
	@Test public void testInvalid_52() {

		String input =
						"g2-g4 b7-b5\n" +
						"a2-a3 b5-b4\n" +
						"a3-a4 b4xa3ep\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|_|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|P|p|_|_|_|_|P|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|_|P|P|P|P|P|_|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test invalid en passant
	 */
	@Test public void testInvalid_53() {

		String input =
						"a2-a4 b7-b5\n" +
						"a4-a5 b5xa4ep\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|_|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|P|p|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|_|P|P|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test invalid en passant
	 */
	@Test public void testInvalid_54() {

		String input =
						"d2-d4 e7-e6\n" +
						"d4-d5 Bf8-c5\n" +
						"d5xc6ep\n" +
						"";
		String output =
						"8|r|n|b|q|k|_|n|r|\n" +
						"7|p|p|p|p|_|p|p|p|\n" +
						"6|_|_|_|_|p|_|_|_|\n" +
						"5|_|_|b|P|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|_|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test invalid en passant - piece in way
	 */
	@Test public void testInvalid_55() {

		String input =
						"e2-e4 e7-e6\n" +
						"e4-e5 f7-f5\n" +
						"a2-a4 Qd8-f6\n" +
						"e5xf6ep\n" +
						"";
		String output =
						"8|r|n|b|_|k|b|n|r|\n" +
						"7|p|p|p|p|_|_|p|p|\n" +
						"6|_|_|_|_|p|q|_|_|\n" +
						"5|_|_|_|_|P|p|_|_|\n" +
						"4|P|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|_|P|P|P|_|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test invalid en passant
	 */
	@Test public void testInvalid_56() {

		String input =
						"g2-g4 Ng8-h6\n" +
						"g4-g5 Nh6-f5\n" +
						"g5xf6ep\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|_|r|\n" +
						"7|p|p|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|n|P|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|P|P|_|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test invalid en passant - null target
	 */
	@Test public void testInvalid_57() {

		String input =
						"f2-f4 a7-a5\n" +
						"f4-f5 b7-b5\n" +
						"f5xg6ep\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|_|_|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|p|p|_|_|_|P|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|P|_|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test invalid en passant - take own piece
	 */
	@Test public void testInvalid_58() {

		String input =
						"f2-f4 g7-g5\n" +
						"e2-e4 a7-a6\n" +
						"f4-f5 a6-a5\n" +
						"e4-e5 b7-b5\n" +
						"e5xf6ep\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|_|_|p|p|p|p|_|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|p|p|_|_|P|P|p|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|_|_|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test non check move
	 */
	@Test public void testInvalid_59() {

		String input =
						"f2-f4+\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|p|p|p|p|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|P|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test non check move
	 */
	@Test public void testInvalid_60() {

		String input =
						"Nb1-c3 h7-h5\n" +
						"Nc3-b5 f7-f6\n" +
						"Nb5-d6+ g7-g5\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|p|_|p|_|\n" +
						"6|_|_|_|N|_|p|_|_|\n" +
						"5|_|_|_|_|_|_|_|p|\n" +
						"4|_|_|_|_|_|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|P|P|P|P|\n" +
						"1|R|_|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}


	/**
	 * Test non check move
	 */
	@Test public void testInvalid_61() {

		String input =
						"e2-e4 h7-h5\n" +
						"Bf1xBd3\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|p|p|p|_|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|_|p|\n" +
						"4|_|_|_|_|P|_|_|_|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|P|P|P|P|_|P|P|P|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test invalid castling - rock moved away
	 */
	@Test public void testInvalid_62() {

		String input =
						"h2-h4 h7-h5\n" +
						"Rh1-h3 g7-g5\n" +
						"O-O\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|p|p|p|_|_|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|_|_|_|p|p|\n" +
						"4|_|_|_|_|_|_|_|P|\n" +
						"3|_|_|_|_|_|_|_|R|\n" +
						"2|P|P|P|P|P|P|P|_|\n" +
						"1|R|N|B|Q|K|B|N|_|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test invalid castling - rock moved away
	 */
	@Test public void testInvalid_63() {

		String input =
						"h2-h4 h7-h5\n" +
						"Rh1-h3 g7-g5\n" +
						"Ng1-f3 f7-f5\n" +
						"g2-g3 e7-e5\n" +
						"Bf1-g2 d7-d5\n" +
						"O-O\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|p|_|_|_|_|_|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|_|_|_|p|p|p|p|p|\n" +
						"4|_|_|_|_|_|_|_|P|\n" +
						"3|_|_|_|_|_|N|P|R|\n" +
						"2|P|P|P|P|P|P|B|_|\n" +
						"1|R|N|B|Q|K|_|_|_|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test invalid castling - king in check
	 */
	@Test public void testInvalid_64() {

		String input =
						"a2-a3 h7-h5\n" +
						"c2-c3 Ng8-h6\n" +
						"Qd1-a4 g7-g5\n" +
						"Qa4-c4 Bf8-g7\n" +
						"b2-b3 f7-f5\n" +
						"e2-e3 O-O\n" +
						"";
		String output =
						"8|r|n|b|q|k|_|_|r|\n" +
						"7|p|p|p|p|p|_|b|_|\n" +
						"6|_|_|_|_|_|_|_|n|\n" +
						"5|_|_|_|_|_|p|p|p|\n" +
						"4|_|_|Q|_|_|_|_|_|\n" +
						"3|P|P|P|_|P|_|_|_|\n" +
						"2|_|_|_|P|_|P|P|P|\n" +
						"1|R|N|B|_|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test Pawn Promotion to King, returns error.
	 */
	@Test public void testInvalid_65() {
				String input =
						"a2-a4 b7-b5\n" +
						"a4xb5 Nb8-c6\n" +
						"b5-b6 a7-a5\n" +
						"Nb1-c3 Bc8-a6\n" +
						"Ng1-h3 e7-e6\n" +
						"b6-b7 Qd8-h4\n" +
						"b7-b8=K\n" +
						"";
		String output =
						"8|r|P|_|_|k|b|n|r|\n" +
						"7|_|_|p|p|_|p|p|p|\n" +
						"6|b|_|n|_|p|_|_|_|\n" +
						"5|p|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|_|_|_|_|q|\n" +
						"3|_|_|N|_|_|_|_|N|\n" +
						"2|_|P|P|P|P|P|P|P|\n" +
						"1|R|_|B|Q|K|B|_|R|\n" +
						"  a b c d e f g h";

		assertThrows(AssertionFailedError.class, () -> {check(input,output);});
	}


	/**
	 * Test Singlepiecemove is valid
	 */
	@Test public void testInvalid_66() {
		Board b = new Board();
		assertFalse(new SinglePieceMove(new Bishop(true), new Position(3, 8), new Position(3, 7)).isValid(b));
	}

	/**
	 * Test invalid castling - king moved
	 */
	@Test public void testInvalid_67() {
		String input =
						"d2-d4 c7-c6\n" +
						"Qd1-d3 a7-a6\n" +
						"Bc1-f4 b7-b6\n" +
						"Nb1-a3 d7-d6\n" +
						"Ke1-d1 h7-h6\n" +
						"Kd1-e1 g7-g6\n" +
						"O-O-O\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|_|_|_|_|p|p|_|_|\n" +
						"6|p|p|p|p|_|_|p|p|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|P|_|B|_|_|\n" +
						"3|N|_|_|Q|_|_|_|_|\n" +
						"2|P|P|P|_|P|P|P|P|\n" +
						"1|R|_|_|_|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test invalid castling - rook moved
	 */
	@Test public void testInvalid_68() {
		String input =
						"d2-d4 c7-c6\n" +
						"Qd1-d3 a7-a6\n" +
						"Bc1-f4 b7-b6\n" +
						"Nb1-c3 d7-d6\n" +
						"a2-a3 h7-h6\n" +
						"Ra1-a2 g7-g6\n" +
						"Ra2-a1 f7-f6\n" +
						"O-O-O\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|_|_|_|_|p|_|_|_|\n" +
						"6|p|p|p|p|_|p|p|p|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|P|_|B|_|_|\n" +
						"3|P|_|N|Q|_|_|_|_|\n" +
						"2|_|P|P|_|P|P|P|P|\n" +
						"1|R|_|_|_|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test invalid castling - in check
	 */
	@Test public void testInvalid_69() {
		String input =
						"d2-d4 c7-c5\n" +
						"Nb1-a3 Qd8-b6\n" +
						"Bc1-f4 e7-e5\n" +
						"c2-c4 h7-h5\n" +
						"Qd1-a4 Qb6-a5+\n" +
						"O-O-O\n" +
						"";
		String output =
						"8|r|n|b|_|k|b|n|r|\n" +
						"7|p|p|_|p|_|p|p|_|\n" +
						"6|_|_|_|_|_|_|_|_|\n" +
						"5|q|_|p|_|p|_|_|p|\n" +
						"4|Q|_|P|P|_|B|_|_|\n" +
						"3|N|_|_|_|_|_|_|_|\n" +
						"2|P|P|_|_|P|P|P|P|\n" +
						"1|R|_|_|_|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test invalid castling - in check
	 */
	@Test public void testInvalid_70() {
		String input =
						"b2-b4 d7-d5\n" +
						"a2-a4 Qd8-d6\n" +
						"c2-c4 Bc8-g4\n" +
						"h2-h4 O-O-O\n" +
						"";
		String output =
						"8|r|n|_|_|k|b|n|r|\n" +
						"7|p|p|p|_|p|p|p|p|\n" +
						"6|_|_|_|q|_|_|_|_|\n" +
						"5|_|_|_|p|_|_|_|_|\n" +
						"4|P|P|P|_|_|_|b|P|\n" +
						"3|_|_|_|_|_|_|_|_|\n" +
						"2|_|_|_|P|P|P|P|_|\n" +
						"1|R|N|B|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test invalid castling - bishop in position of king
	 */
	@Test public void testInvalid_71() {
		String input =
						"d2-d4 h7-h6\n" +
						"e2-e4 g7-g6\n" +
						"Ke1-e2 f7-f6\n" +
						"Bc1-d2 e7-e6\n" +
						"Bd2-e1 d7-d6\n" +
						"Qd1-d3 c7-c6\n" +
						"Nb1-c3 b7-b6\n" +
						"O-O-O\n" +
						"";
		String output =
						"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|_|_|_|_|_|_|_|\n" +
						"6|_|p|p|p|p|p|p|p|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|_|_|_|P|P|_|_|_|\n" +
						"3|_|_|N|Q|_|_|_|_|\n" +
						"2|P|P|P|_|K|P|P|P|\n" +
						"1|R|_|_|_|B|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}

	/**
	 * Test invalid castling - bishop in position of rook
	 */
	@Test public void testInvalid_72() {
		String input =
				"b2-b3 h7-h6\n" +
						"Nb1-c3 g7-g6\n" +
						"a2-a4 f7-f6\n" +
						"Bc1-b2 e7-e6\n" +
						"Ra1-a3 d7-d6\n" +
						"Bb2-a1 c7-c6\n" +
						"O-O-O\n" +
						"";
		String output =
				"8|r|n|b|q|k|b|n|r|\n" +
						"7|p|p|_|_|_|_|_|_|\n" +
						"6|_|_|p|p|p|p|p|p|\n" +
						"5|_|_|_|_|_|_|_|_|\n" +
						"4|P|_|_|_|_|_|_|_|\n" +
						"3|R|P|N|_|_|_|_|_|\n" +
						"2|_|_|P|P|P|P|P|P|\n" +
						"1|B|_|_|Q|K|B|N|R|\n" +
						"  a b c d e f g h";

		check(input,output);
	}


	// The following provides a simple helper method for all tests.
	public static void check(String input, String expectedOutput) {
		try {
			ChessGame game = new ChessGame(input);
			List<Board> boards = game.boards();
			if (boards.isEmpty()) {
				fail("test failed with insufficient boards on input: " + input);
			}
			String actualOutput = boards.get(boards.size() - 1).toString();
			assertEquals(expectedOutput, actualOutput);
		} catch (Exception e) {
			fail("test failed because of exception on input: " + input);
		}
	}
}
