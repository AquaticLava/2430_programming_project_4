package Monopoly;

public class Player {
    /**
     * number of out of jail free cards this player has.
     */
    private int outOfJailFreeCards;

    /**
     * The monopoly instance the player is attached to. used to get the gameboard, chance deck, and community chest deck.
     */
    private Monopoly monopoly;

    /**
     * represents the number of times a boardsquare has been landed on.
     */
    private int[] landedOnSquares;
    
    /**
     * the current square the player is on.
     */
    private int currentSquare;
    
    /**
     * number of turns in jail
     */
    private int turnsInJail;
    private boolean useCardImmediately;
    
    /**
     * 
     * @param monopoly
     */
    public Player(Monopoly monopoly, boolean useCardImmediately) {
    	this.monopoly = monopoly;
        this.useCardImmediately = useCardImmediately;
        landedOnSquares = new int[monopoly.getGameBoard().length];
    	//Space 0 will be designated as the GO square
    	setCurrentSquare(0);
    }

    // Getter And Setter Methods

    public int getOutOfJailFreeCards() {
        return outOfJailFreeCards;
    }

    public int[] getLandedOnSquares() {
        return landedOnSquares;
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
     * do this players turn, also use get out of jail free cards right from the getgo.
     */
    public void DoTurn() {
    	//roll the dice
    	int doubles = 0;
    	int rollsLeft = 1;
    	int roll1;
    	int roll2;
    	
    	//Put as a loop for ease of handling die roll
    	while(doubles < 2 && rollsLeft > 0) {
    		roll1 = Die.Roll();
    		roll2 = Die.Roll();
    		rollsLeft--;
    		
	    	//check for doubles
	    	if(roll1 == roll2) {
	    		doubles++;
	    		rollsLeft++;
	    	}
	
	    	//if not on jail, go amount on dice and set current square
	    	if(currentSquare == 40) {
                if (useCardImmediately){
                    useCardImmediately(doubles, roll1, roll2);
                } else {
                    useCardLater(doubles, roll1, roll2);
                }

	    	} else {
                moveToSquare(roll1, roll2);
	    	}
            if (doubles == 4){
                currentSquare = 40;
            }
    	}

    }

    private void useCardImmediately(int doubles, int roll1, int roll2) {
        turnsInJail++;
        landedOnSquares[currentSquare]++;
        
        if(getOutOfJailFreeCards() > 0) {
            currentSquare = 10;
            outOfJailFreeCards--;

            //TODO add card to correct deck
             if (monopoly.getChanceDeck().isMissingCard()) {
                 monopoly.getChanceDeck().AddOutOfJailCard();
             } else {
                 monopoly.getCommunityChestDeck().AddOutOfJailCard();
             }
            /*
                I am confused,
                 if this player has an attribute of Monopoly,
                and we change that deck, will it change the deck
                of the actual Monopoly instance?

                if not, how do we access the correct Deck?
             */
            turnsInJail = 0;
        } else {
            currentSquare = 10;
            turnsInJail = 0;
            moveToSquare(roll1, roll2);
        }
    }

    private void useCardLater(int doubles, int roll1, int roll2) {
        turnsInJail++;

        if(getOutOfJailFreeCards() > 0 && turnsInJail == 4) {
            currentSquare = 10;
            outOfJailFreeCards--;

            //TODO add card to correct deck
            if (monopoly.getChanceDeck().isMissingCard()) {
                monopoly.getChanceDeck().AddOutOfJailCard();
            } else {
                monopoly.getCommunityChestDeck().AddOutOfJailCard();
            }
            
            turnsInJail = 0;
        } else if(doubles > 0){
            currentSquare = 10;
            turnsInJail = 0;
        } else if(turnsInJail == 3) {
        	currentSquare = 10;
        	turnsInJail = 0;
        	moveToSquare(roll1, roll2);
        } else {
            landedOnSquares[currentSquare]++;
        }
    }
    
    private void moveToSquare(int roll1, int roll2) {
    	currentSquare = (currentSquare + roll1 + roll2) % 39;
        landedOnSquares[currentSquare]++;

        doAction();
    }
    
    private void doAction() {
    	monopoly.getGameBoard()[currentSquare].Action(this);
    }

    /**
     * returns true if the player uses GOOJF card immediately, false if not
     *
     * @return  boolean true if this player uses GOOJF cards immediately
     */
    public boolean usesCardImmediately() {
        return useCardImmediately;
    }
}

