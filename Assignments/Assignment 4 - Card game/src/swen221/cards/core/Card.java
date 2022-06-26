// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.cards.core;

/**
 * Represents a single card in the game.
 *
 * @author David J. Pearce
 *
 */
public class Card implements Comparable<Card> {

	/**
	 * Represents a card suit.
	 *
	 * @author David J. Pearce
	 *
	 */
	public enum Suit {
		/**
		 * The suit of hearts.
		 */
		HEARTS,
		/**
		 * The suit of clubs.
		 */
		CLUBS,
		/**
		 * The suit of diamonds.
		 */
		DIAMONDS,
		/**
		 * The suit of spades.
		 */
		SPADES;
	}

	/**
	 * Represents the different card "numbers".
	 *
	 * @author David J. Pearce
	 *
	 */
	public enum Rank {
		TWO,
		THREE,
		FOUR,
		FIVE,
		SIX,
		SEVEN,
		EIGHT,
		NINE,
		TEN,
		JACK,
		QUEEN,
		KING,
		ACE;
	}

	// =======================================================
	// Card stuff
	// =======================================================

	private Suit suit; // HEARTS, CLUBS, DIAMONDS, SPADES
	private Rank rank; // 2 <= number <= 14 (ACE)

	/**
	 * Construct a card in the given suit, with a given number
	 *
	 * @param suit
	 *            --- between 0 (HEARTS) and 3 (SPADES)
	 * @param number
	 *            --- between 2 and 14 (ACE)
	 */
	public Card(Suit suit, Rank number) {
		this.suit = suit;
		this.rank = number;
	}

	/**
	 * Get the suit of this card, between 0 (HEARTS) and 3 (SPADES).
	 *
	 * @return The suite of this card.
	 */
	public Suit suit() {
		return suit;
	}

	/**
	 * Get the number of this card, between 2 and 14 (ACE).
	 *
	 * @return The rank of this card.
	 */
	public Rank rank() {
		return rank;
	}

	private static String[] suits = { "Hearts","Clubs","Diamonds","Spades"};
	private static String[] ranks = { "2 of ", "3 of ", "4 of ",
			"5 of ", "6 of ", "7 of ", "8 of ", "9 of ", "10 of ", "Jack of ",
			"Queen of ", "King of ", "Ace of " };

	@Override
	public String toString() {
		return ranks[rank.ordinal()] + suits[suit.ordinal()];
	}

	@Override
	public int compareTo(Card o) {
		// TODO: you need to implement this!
		if(this.equals(o)) return 0;
		if(this.suit.equals(o.suit)) {
			if(compareCard(this)>=compareCard(o)) {
				return 1;
			}
			else return -1;

		}
		else if(this.compareSuit( o)) {
			return 1;
		}
		return -1;
	}

	/**
	 *
	 * @param card
	 * @return
	 * returns value of card
	 */
	private int compareCard(Card card) {
		if(card.rank.equals(Rank.TWO)) return 2;
		if(card.rank.equals(Rank.THREE)) return 3;
		if(card.rank.equals(Rank.FOUR)) return 4;
		if(card.rank.equals(Rank.FIVE)) return 5;
		if(card.rank.equals(Rank.SIX)) return 6;
		if(card.rank.equals(Rank.SEVEN)) return 7;
		if(card.rank.equals(Rank.EIGHT))return 8;
		if(card.rank.equals(Rank.NINE)) return 9;
		if(card.rank.equals(Rank.TEN)) return 10;
		if(card.rank.equals(Rank.JACK)) return 11;
		if(card.rank.equals(Rank.QUEEN)) return 12;
		if(card.rank.equals(Rank.KING)) return 13;
		if(card.rank.equals(Rank.ACE)) return 14;
		return 0;
	}

	/**
	 * @param card
	 * @return
	 * Returns value of suit value
	 */
	private boolean compareSuit(Card card) {
		if(this.suit.equals(Suit.HEARTS)) {
			return false;
		}
		if(this.suit.equals(Suit.CLUBS)) {
			if(card.suit.equals(Suit.DIAMONDS)) return false;
			else if(card.suit.equals(Suit.SPADES))return false;
		}
		if(this.suit.equals(Suit.DIAMONDS)) {
			if(card.suit.equals(Suit.SPADES)) return false;
		}
		if(this.suit.equals(Suit.SPADES))return true;
		return true;

	}

	/**
	 *
	 * @param o
	 * @return
	 * Card equals method
	 */
	@Override
	public boolean equals(Object o) {
		if(this==o)return true;
		if(o==null)return false;
		Card c=(Card) o;
		if(this.suit.equals(c.suit)) {
			if(compareCard(this)==compareCard(c)) return true;
		}
		return false;
	}
	/**
	 * Hashcode generator method
	 */
	@Override
	public int hashCode() {
		return 	this.suit.ordinal()*100 + this.rank.ordinal();
	}
}
