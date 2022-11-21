package Monopoly.BoardSquares;

import Monopoly.Player;

public class GoToJail extends BoardSquare{
    public GoToJail(String name) {
        super(name);
    }

    @Override
    public void Action(Player player) {
        player.setCurrentSquare(41);
        player.getMonopoly().getGameBoard()[41].Action(player);
    }
}
