// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.conway.rules;

import swen221.conway.model.Rule;
import swen221.conway.util.ConwayAbstractRule;


public class ConwaysUnderpopulationRule extends ConwayAbstractRule {

	/**
	 * Implements Conways underpopulation rule. If a cell has fewer than two neighbours it dies as if by underpopulation
	 *
	 * @param x
	 *            Horizontal position of cell on the board
	 * @param y
	 *            Vertical position of cell on the board
	 * @param neighbours
	 *            Number of alive neighbours on the board.
	 * @return
	 */

	@Override
	public int apply(int x, int y, int neighbours) {
		if (neighbours < 2) {
			// This rule was applied in this case
			return ConwayAbstractRule.DEAD;
		} else {
			// This rule was not applied in this case
			return Rule.NOT_APPLICABLE;
		}
	}
}
