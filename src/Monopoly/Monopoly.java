package Monopoly;

import Monopoly.BoardSquares.BoardSquare;

public class Monopoly {
    private Player player;
    private BoardSquare[] gameBoard;
    private Deck chanceDeck;
    private Deck communityChestDeck;
    private int turnsTaken; //TODO


    /**
     * Instantiates a new Monopoly.
     */
    public Monopoly(){
        int numberOfSquares = 41; // 40 board squares starting at 0, index 40 is the jail
        player = new Player();
        gameBoard = generateBoard(numberOfSquares);
        chanceDeck = generateChanceDeck();
        communityChestDeck = generateCommunityDeck();

    }
    /**
     * Generates the board used for Monopoly.
     * @return List of type BoardSquares.
     */
    private BoardSquare[] generateBoard(int numberOfSquares) {
        BoardSquare[] gameBoard = new BoardSquare[numberOfSquares];
        for (int i = 0; i < gameBoard.length; i++) {
            if (i == 7 || i == 22 || i == 36){ // chance squares
                gameBoard[i] = new DrawCardSquare("Chance?", chanceDeck);

            } else if (i == 2 || i == 17 || i == 33) { // community chest squares
                gameBoard[i] = new DrawCardSquare("Community Chest", communityChestDeck);

            }else if (i == 5 || i == 15 || i == 25 || i == 35) { // rail station
                gameBoard[i] = new Monopoly.BoardSquares.NoAction("Rail Station");

            }else if (i == 12 || i == 28) { // utility squares
                gameBoard[i] = new Monopoly.BoardSquares.NoAction("Utility");

            } else if ( i == 30) { // go to jail square
               gameBoard[i] = new Monopoly.BoardSquares.GoToJail("Go to Jail");

            } else if (i == 40) { // Jail square
                gameBoard[i] = new Jail("Jail");
            }
            gameBoard[i] = new Monopoly.BoardSquares.NoAction("blank"); // default square is no action
        }

        return gameBoard;
    }

    /**
     * Get game board board square [ ].
     *
     * @return the board square [ ]
     */
    public BoardSquare[] getGameBoard() {
        return gameBoard;
    }

    /**
     * Get chance deck deck.
     *
     * @return the deck
     */
    public Deck getChanceDeck(){
        return chanceDeck;
    }

    /**
     * Generates a Chance Deck.
     * @return List of type Cards
     */
    private Deck generateChanceDeck() {

        List<Card> cards = new ArrayList<>();
        cards.add(new MoveToSquare("Advance to Boardwalk.",39 ));
        cards.add(new MoveToSquare("Advance to Go. Collect $200.",0 ));
        cards.add(new MoveToSquare("Advance to Illinois Avenue. if pass go, collect $200.",24 ));
        cards.add(new MoveToSquare("Advance to St. Charles PLace. if pass go, collect $200.",11 ));
        cards.add(new MoveToSquare("Take a trip to Reading Railroad. if pass go, collect $200.",5 ));
        cards.add(new MoveToSquare("Advance to the nearest Railroad.", getNextRailOrUtility(0)));
        cards.add(new MoveToSquare("Advance to the nearest Railroad.", getNextRailOrUtility(0)));
        cards.add(new MoveToSquare("Advance to the nearest utility.", getNextRailOrUtility(1)));
        cards.add(new NoAction("Bank pays you dividend 0f $50."));
        cards.add(new NoAction("Make general repairs on all your property. Pay $25 for each house and $100 for each hotel you own."));
        cards.add(new NoAction("Speeding fine $15"));
        cards.add(new NoAction("You have been elected Chairman of the Board. Pay each player $50."));
        cards.add(new NoAction("Your building loan matures. Collect $150."));
        cards.add(new OutOfJail("Get out of jail Free"));
        cards.add(new MoveBack("Move Back 3 spaces",3));
        cards.add(new GoToJail("Go to Directly to Jail. Do not pass go. Do not collection $200."));
        return new Deck(cards);
    }

    /**
     * Generates community deck.
     * @return Deck of type cards.
     */
    private Deck generateCommunityDeck() {

        List<Card> cards = new ArrayList<>();
        cards.add(new MoveToSquare("Advance to Go. Collect $200.",0 ));
        cards.add(new NoAction("Bank error in your favor. Collect $200."));
        cards.add(new NoAction("From sale of stock you get $50."));
        cards.add(new NoAction("Holiday fund matures. Receive $100."));
        cards.add(new NoAction("Income tax refund. Collect $20."));
        cards.add(new NoAction("Its your birthday. Collect $10 from every player."));
        cards.add(new NoAction("Life insurance matures. Collect $100."));
        cards.add(new NoAction("Pay hospital fees of $100."));
        cards.add(new NoAction("Pay school fees of $50."));
        cards.add(new NoAction("Receive 25$ consultancy fee"));
        cards.add(new NoAction("You are assessed for street repair. $40 per house. $115 per hotel"));
        cards.add(new NoAction("You have won second prize in a beauty contest. Collect $10."));
        cards.add(new NoAction("You inherit $100."));
        cards.add(new OutOfJail("Get out of jail Free"));
        cards.add(new GoToJail("Go to Directly to Jail. Do not pass go. Do not collection $200."));
        return new Deck(cards);
    }

    /**
     * returns Community Chest Deck
     *
     * @return Deck of type cards.
     */
    public Deck getCommunityChestDeck() {
        return communityChestDeck;
    }

    private int getNextRailOrUtility(int railOrUtility) {
        int currentSquare = player.getCurrentSquare();
        int[] railStations = {5, 15, 25, 35};
        int[] utilities = {12, 28};
        int[] option;

        if (railOrUtility == 0) {
            option = railStations;
        } else {
            option = utilities;
        }

        for (int j : option) {
            if (currentSquare < j) {
                return j;
            }
        }
        return option[0];
    }

    public void DoGameTurn() {
    }

    public void InitGame() {
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        //Monopoly m = new Monopoly();
    }

}
