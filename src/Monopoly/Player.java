package Monopoly;

public class Player {
    /**
     * number of out of jail free cards this player has.
     */
    private int outOfJailFreeCards;

    public void setOutOfJailFreeCards(int outOfJailFreeCards) {
        this.outOfJailFreeCards = outOfJailFreeCards;
    }

    /**
     * The monopoly instance the player is attached to. used to get the gameboard, chance deck, and comuntiy chest deck.
     */
    private Monopoly monopoly;

    /**
     * represents the number of times a boardsquare has been landed on.
     */
    private int landedOnSquares;

    private boolean inJail;

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public int getOutOfJailFreeCards() {
        return outOfJailFreeCards;
    }

    public Monopoly getMonopoly() {
        return monopoly;
    }

    public int getCurrentSquare() {
        return currentSquare;
    }

    /**
     * the current square the player is on.
     */
    private int currentSquare;

    /**
     * do this players turn.
     */
    public void DoTurn() {
//        int DoubleCount = 0;
//        int spacesToMove = Die.Roll();
//        setCurrentSquare(getCurrentSquare() + spacesToMove);
    }

    public void setCurrentSquare(int currentSquare) {
        this.currentSquare = currentSquare;
    }
}
