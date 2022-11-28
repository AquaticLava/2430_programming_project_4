package Monopoly.BoardSquares;

import Monopoly.Player;

public class GoToJail extends BoardSquare{
    public GoToJail(String name) {
        super(name);
    }

    @Override
    public void Action(Player player) {
        player.setCurrentSquare(40);
        player.getMonopoly().getGameBoard()[40].Action(player);
    }
}
