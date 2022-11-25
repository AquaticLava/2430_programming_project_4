package Monopoly;

public class Player {
    /**
     * number of out of jail free cards this player has.
     */
    private int outOfJailFreeCards;

    /**
     * The monopoly instance the player is attached to. used to get the gameboard, chance deck, and communtiy chest deck.
     */
    private Monopoly monopoly;

    /**
     * represents the number of times a boardsquare has been landed on.
     */
    private int landedOnSquares;

    private boolean inJail;
    
    public Player(Monopoly monopoly) {
    	this.monopoly = monopoly;
    	currentSquare = 0; //TODO : Change to GO square
    }

    // Getter And Setter Methods
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
    
    public void setCurrentSquare(int currentSquare) {
        this.currentSquare = currentSquare;
    }

    public void setOutOfJailFreeCards(int outOfJailFreeCards) {
        this.outOfJailFreeCards = outOfJailFreeCards;
    }

    /**
     * the current square the player is on.
     */
    private int currentSquare;
    
    /**
     * do this players turn.
     */
    //TODO : fill the required methods
    public void DoTurn() {
    	//roll the dice
    	int doubles = 0;
    	int rollsLeft = 1;
    	Die die = new Die();
    	int roll1;
    	int roll2;
    	
    	//Put as a loop for ease of handling die roll
    	while(doubles < 2 || rollsLeft > 0) {
    		roll1 = die.Roll();
    		roll2 = die.Roll();
    		rollsLeft--;
    		
	    	//check for doubles
	    	if(roll1 == roll2) {
	    		doubles++;
	    		rollsLeft++;
	    	}
	
	    	//if not on jail, go amount on dice and set current square
	    	//TODO: replace 0 with jail square and 1 with no action square
	    	if(currentSquare != 0) {
	    		currentSquare = currentSquare + roll1 + roll2;
	    		
	    		if(currentSquare != 1) {
	    			//currentSquare.doAction();
	    		}
	    	} else if (doubles > 0){ //checks for doubles in jail
	    		//TODO: replace this V with the logic to get out of jail
	    		currentSquare = 0 + 1;
	    	}
    	}
    }

    	
}

