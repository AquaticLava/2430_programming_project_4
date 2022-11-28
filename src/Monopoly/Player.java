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
    
    /**
     * the current square the player is on.
     */
    private int currentSquare;
    
    /**
     * number of turns in jail
     */
    private int turnsInJail;
    
    /**
     * 
     * @param monopoly
     */
    public Player(Monopoly monopoly) {
    	this.monopoly = monopoly;
    	//Space 0 will be designated as the GO square
    	setCurrentSquare(0);
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
     * do this players turn.
     */
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
	    	if(currentSquare != 41) {
	    		currentSquare = currentSquare + roll1 + roll2 % 40;
	    		
	    		doAction();
	    	} else {
	    		if(getOutOfJailFreeCards() > 0) {
	    			currentSquare = 11;
	    			outOfJailFreeCards--;
	    		} else if(doubles > 0){
	    			currentSquare = 11;
	    		}
	    	}
    	}
    }
    
    public void DoAlternateTurn() {
    	int doubles = 0;
    	int rollsLeft = 1;
    	Die die = new Die();
    	int roll1;
    	int roll2;
    	
    	while(doubles < 2 || rollsLeft > 0) {
    		roll1 = die.Roll();
    		roll2 = die.Roll();
    		rollsLeft--;
    		
	    	if(roll1 == roll2) {
	    		doubles++;
	    		rollsLeft++;
	    	}
	
	    	//if not on jail, go amount on dice and set current square
	    	if(currentSquare != 41) {
	    		currentSquare = currentSquare + roll1 + roll2 % 40;
	    		
	    		doAction();
	    	} else {
	    		turnsInJail++;
	    		
	    		if(getOutOfJailFreeCards() > 0 && turnsInJail == 4) {
	    			currentSquare = 11;
	    			outOfJailFreeCards--;
	    			turnsInJail = 0;
	    		} else if(doubles > 0){
	    			currentSquare = 11;
	    			turnsInJail = 0;
	    		}
	    	}
    	}
    	
    }
    
    private void doAction() {
    	monopoly.getGameBoard()[currentSquare].Action(this);
    }
}

