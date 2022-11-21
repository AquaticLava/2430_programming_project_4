package Monopoly.Cards;

import Monopoly.Player;

public abstract class Card {
    /**
     * name of this card
     */
    private String name;

    public Card(String name) {
        this.name = name;
    }

    /**
     * action of this card.
     */
    public abstract void Action(Player player);

}
