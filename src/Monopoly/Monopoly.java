package Monopoly;

import Monopoly.BoardSquares.BoardSquare;

public class Monopoly {
    private Player player;

    public BoardSquare[] getGameBoard() {
        return gameBoard;
    }

    public Deck getChanceDeck() {
        return chanceDeck;
    }

    public Deck getCommunityChestDeck() {
        return communityChestDeck;
    }

    private BoardSquare[] gameBoard;

    private Deck chanceDeck;

    private Deck communityChestDeck;

    private int turnsTaken;

    public void DoGameTurn() {
    }

    public void InitGame() {
    }

    public static void main(String[] args) {

    }

}
