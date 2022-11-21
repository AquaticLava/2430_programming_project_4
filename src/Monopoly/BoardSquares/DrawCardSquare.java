package Monopoly.BoardSquares;

import Monopoly.Deck;
import Monopoly.Player;

public class DrawCardSquare extends BoardSquare{
    private Deck deckToDrawFrom;

    public DrawCardSquare(String name, Deck deck) {
        super(name);
        deckToDrawFrom = deck;
    }

    @Override
    public void Action(Player player) {
        deckToDrawFrom.Draw().Action(player);
    }
}
