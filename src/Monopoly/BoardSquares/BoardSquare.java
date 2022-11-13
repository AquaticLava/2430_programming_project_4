package Monopoly.BoardSquares;

import Monopoly.Player;

public abstract class BoardSquare {
    /**
     * name of the square
     */
    private String name;

    /**
     * action that the square takes.
     */
    public abstract void Action(Player player);

}
