package Monopoly;

import Monopoly.BoardSquares.*;
import Monopoly.Cards.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Creates a game object of Monopoly. Use to play a game of monopoly without the use of money.
 */
public class Monopoly {

    private Player player;
    private BoardSquare[] gameBoard;
    private Deck chanceDeck;
    private Deck communityChestDeck;
    private int turnsTaken;


    /**
     * Instantiates a new Monopoly.
     */
    public Monopoly(){
        int numberOfSquares = 41; // 40 board squares starting at 0, index 40 is the jail
        chanceDeck = generateChanceDeck();
        communityChestDeck = generateCommunityDeck();
        gameBoard = generateBoard(numberOfSquares);// TODO check switched order, Decks were null when generating gameBoard

        player = new Player(this, false);

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
                gameBoard[i] = new NoActionSquare("Rail Station");

            }else if (i == 12 || i == 28) { // utility squares
                gameBoard[i] = new NoActionSquare("Utility");

            } else if ( i == 30) { // go to jail square
               gameBoard[i] = new GoToJailSquare("Go to Jail");

            } else if (i == 40) { // Jail square
                gameBoard[i] = new Jail("Jail");
            }
             else { // added else bracket, all squares were defaulting to blank
                 gameBoard[i] = new NoActionSquare("blank"); // default square is blank, with no action
            }
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
        cards.add(new MoveToRail("Advance to the nearest Railroad."));
        cards.add(new MoveToRail("Advance to the nearest Railroad."));
        cards.add(new MoveToUtility("Advance to the nearest utility."));
        cards.add(new NoActionCard("Bank pays you dividend 0f $50."));
        cards.add(new NoActionCard("Make general repairs on all your property. Pay $25 for each house and $100 for each hotel you own."));
        cards.add(new NoActionCard("Speeding fine $15"));
        cards.add(new NoActionCard("You have been elected Chairman of the Board. Pay each player $50."));
        cards.add(new NoActionCard("Your building loan matures. Collect $150."));
        cards.add(new OutOfJail("Get out of jail Free"));
        cards.add(new MoveBack("Move Back 3 spaces",3));
        cards.add(new GoToJailCard("Go to Directly to Jail. Do not pass go. Do not collection $200."));
        return new Deck(cards);
    }

    /**
     * Generates community deck.
     * @return Deck of type cards.
     */
    private Deck generateCommunityDeck() {

        List<Card> cards = new ArrayList<>();
        cards.add(new MoveToSquare("Advance to Go. Collect $200.",0 ));
        cards.add(new NoActionCard("Bank error in your favor. Collect $200."));
        cards.add(new NoActionCard("From sale of stock you get $50."));
        cards.add(new NoActionCard("Holiday fund matures. Receive $100."));
        cards.add(new NoActionCard("Income tax refund. Collect $20."));
        cards.add(new NoActionCard("Its your birthday. Collect $10 from every player."));
        cards.add(new NoActionCard("Life insurance matures. Collect $100."));
        cards.add(new NoActionCard("Pay hospital fees of $100."));
        cards.add(new NoActionCard("Pay school fees of $50."));
        cards.add(new NoActionCard("Receive 25$ consultancy fee"));
        cards.add(new NoActionCard("You are assessed for street repair. $40 per house. $115 per hotel"));
        cards.add(new NoActionCard("You have won second prize in a beauty contest. Collect $10."));
        cards.add(new NoActionCard("You inherit $100."));
        cards.add(new OutOfJail("Get out of jail Free"));
        cards.add(new GoToJailCard("Go to Directly to Jail. Do not pass go. Do not collection $200."));
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



    /**
     * Do game turn.
     */
    public void DoGameTurn() {
            player.DoTurn();
            turnsTaken++;
        }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Monopoly m = new Monopoly();
        int targetNumberOfTurns = 10;
        while (m.turnsTaken < targetNumberOfTurns){
            m.DoGameTurn();
        }
        System.out.println(Arrays.toString(m.player.getLandedOnSquares()));
        int playerTurns = 0;
        for (int i : m.player.getLandedOnSquares()) {
            playerTurns += i;
        }
        System.out.println("player turns taken: " + playerTurns);
    }
}
