package Monopoly.BoardSquares;

import Monopoly.Player;

public class GoToJailSquare extends BoardSquare{
    public GoToJailSquare(String name) {
        super(name);
    }

    @Override
    public void Action(Player player) {
        player.setCurrentSquare(40);
        player.getMonopoly().getGameBoard()[40].Action(player);
    }
}
