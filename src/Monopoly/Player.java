package Monopoly;

import Monopoly.Monopoly;

public class Player {
    /**
     * number of out of jail free cards this player has.
     */
    private int outOfJailFreeCards;

    /**
     * The monopoly instance the player is attached to. used to get the gameboard, chance deck, and comuntiy chest deck.
     */
    private Monopoly monopoly;

    /**
     * represents the number of times a boardsquare has been landed on.
     */
    private int landedOnSquares;

    /**
     * the current square the player is on.
     */
    private int currentSquare;

    /**
     * do this players turn.
     */
    public void DoTurn() {
    }

}
