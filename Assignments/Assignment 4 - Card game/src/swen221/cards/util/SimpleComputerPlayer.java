// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.cards.util;

import swen221.cards.core.Card;
import swen221.cards.core.Hand;
import swen221.cards.core.Player;
import swen221.cards.core.Trick;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Implements a simple computer player who plays the highest card available when
 * the trick can still be won, otherwise discards the lowest card available. In
 * the special case that the player must win the trick (i.e. this is the last
 * card in the trick), then the player conservatively plays the least card
 * needed to win.
 *
 * @author David J. Pearce
 *
 */
public class SimpleComputerPlayer extends AbstractComputerPlayer {

	/**
	 * Construct a new (simple) computer player with the given player information.
	 *
	 * @param player Key player informmation.
	 */
	public SimpleComputerPlayer(Player player) {
		super(player);
	}
	@Override
	public Card getNextCard(Trick trick) {
		// TODO: you need to implement this!

		Hand hand = this.player.getHand();
		Card.Suit trumpSuit = trick.getTrumps();

		Player.Direction leadDirection = trick.getLeadPlayer();
		Player.Direction playerDirection = this.player.getDirection();
		Player.Direction lastDirection = trick.getLeadPlayer();

		if(trick.getCardsPlayed().isEmpty()) {
			return computerLeading(trumpSuit, hand);
		}
		if (playerDirection == lastDirection) {
			return end(trick, trumpSuit, hand);
		}
		else {
			return computerMiddle(trick);
		}
	}

	public Card end(Trick t, Card.Suit trumpSuit, Hand hand) {
		Card someBitches = null;

		List<Card> cards = t.getCardsPlayed();
		boolean trumpPlayed=false;
		boolean firstIsTrump = false;
		Card.Suit lastPlayedSuit = t.getCardsPlayed().get(t.getCardsPlayed().size()-1).suit();
		//Set<Card> sameSuitCardWithFirst = hand.matches(firstCardSuit);
		if(cards.get(0).suit()==trumpSuit) firstIsTrump = true;
		for(Card c: cards) {
			if(c.suit()==trumpSuit) trumpPlayed=true;
		}

		return someBitches;
	}
	/**
	 * When AI leads
	 *
	 * @param hand
	 * @param trumpSuit
	 * @return
	 */
	public Card computerLeading(Card.Suit trumpSuit, Hand hand) {
		//Cannot play trump so plays the highest card of other highest suit
		if (hand.matches(trumpSuit).isEmpty()) {
			List<Card> highestRank = highestRank(hand);
			Card c = findHighest(highestRank);
			return c;
		}
		//else plays the highest trump card
		else {
			Card maxTrump = new Card(trumpSuit, Card.Rank.TWO);
			Set<Card> inHandTrump = hand.matches(trumpSuit);
			for (Card c : inHandTrump) {
				if (c != null && c.rank().compareTo(maxTrump.rank()) > 0) {
					maxTrump = c;
				}
			}
			return maxTrump;
		}
	}

	/**
	 * When AI is mid-game
	 *
	 * @param trick
	 */
	public Card computerMiddle(Trick trick) {
		Card.Suit lastPlayedSuit = trick.getCardsPlayed().get(trick.getCardsPlayed().size()-1).suit();

		// Follow the last played cards suit
		if (trick.getTrumps() != lastPlayedSuit) {
			//Player has a trump but can't follow suit
			if (this.player.getHand().matches(trick.getTrumps()).isEmpty() && this.player.getHand().matches(lastPlayedSuit).isEmpty()) {
				if (trick.getTrumps() != null){
					return findLowest();
				}
			}

			//Follow the previous suit, if player doesn't have a higher ranked card discard
			if (findHighest(trick.getCardsPlayed()).rank().ordinal() > findHighest(lastPlayedSuit).rank().ordinal()) {
				return findLowest(lastPlayedSuit);
			} else {
				return findHighest(lastPlayedSuit);
			}
		}

		//If a trump has been played
		if (trick.getTrumps() != null) {
			//Return highest trump, if it can't beat or doesn't have one,  return lowest trump
			if(findHighest(trick.getCardsPlayed()).rank().ordinal() > findHighest(trick.getTrumps()).rank().ordinal()) {
				return findLowest(trick.getTrumps());
			} else {
				return findHighest(trick.getTrumps());
			}

		}
		return null;
	}

	public Card findHighest(Card.Suit trump) {
		Card highest = new Card(trump, Card.Rank.TWO);
		for (Card c : this.player.getHand()) {
			if(c.hashCode() > highest.hashCode()) {
				highest = c;
			}
		}
		return highest;
	}
	/**
	 * Finds the highest value card in a given list of cards
	 *
	 * @param cards
	 * @return
	 */
	public Card findHighest(List<Card> cards) {
		if(cards.isEmpty()) { return null; } //If cards is empty

		Card highest = new Card(Card.Suit.HEARTS, Card.Rank.TWO);
		for (Card c : cards) {
			int current = c.rank().ordinal();
			int high = highest.rank().ordinal();
			//if same rank and suit, but higher suit
			if(current == high && highest.suit().ordinal() < c.suit().ordinal()) {
				highest = c;
				//if same suit, but higher rank
			} else if(high < current) {
				highest = c;
			}
		}
		return highest;
	}
	/**
	 * Returns a list with the highest ranked cards in hand
	 *
	 * @param hand
	 * @return
	 */
	public ArrayList<Card> highestRank (Hand hand) {
		Card.Rank rank = Card.Rank.TWO;
		ArrayList<Card> highestRank = new ArrayList<>();

		for (Card c1 : hand) {
			if (c1.rank().compareTo(rank) > 0) {
				rank = c1.rank();
			}
		}
		for (Card c2 : hand) {
			if (c2.rank() == rank) {
				highestRank.add(c2);
			}
		}
		return highestRank;
	}

	/**
	 * Finds the lowest ranked card in hand
	 * @return
	 */
	public Card findLowest() {
		Card lowest = new Card(Card.Suit.SPADES, Card.Rank.ACE);
		for (Card c : this.player.getHand()) {
			if(c.hashCode() < lowest.hashCode()) { //Finding the lowest card in hand
				lowest = c;
			}
		}
		return lowest;
	}

	/**
	 * Finds the lowest card that follows trump suit
	 * @param trumpSuit
	 * @return
	 */
	public Card findLowest(Card.Suit trumpSuit) {
		Card lowest = new Card(Card.Suit.SPADES, Card.Rank.ACE);
		for (Card c : this.player.getHand()) {
			int current = c.rank().ordinal();
			int low = lowest.rank().ordinal();
			//if same rank and suit, but lower suit
			if(current == low && lowest.suit().ordinal() > c.suit().ordinal() && c.suit() == trumpSuit) {
				lowest = c;
			//if same suit, but lower rank
			} else if(low > current && c.suit() == trumpSuit) {
				lowest = c;
			}
		}
		return lowest;
	}

}
