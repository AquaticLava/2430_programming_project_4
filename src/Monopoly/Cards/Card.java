package Monopoly.Cards;

import Monopoly.Player;

public abstract class Card {
    /**
     * name of this card
     */
    private String name;

    /**
     * action of this card.
     */
    public abstract void Action(Player player);

}
