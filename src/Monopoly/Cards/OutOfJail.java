package Monopoly.Cards;

import Monopoly.Player;

public class OutOfJail extends Card{
    public OutOfJail(String name) {
        super(name);
    }

    @Override
    public void Action(Player player) {
        int cards = player.getOutOfJailFreeCards();
        player.setOutOfJailFreeCards(++cards);
    }
}
