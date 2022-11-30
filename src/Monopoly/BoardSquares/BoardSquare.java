package Monopoly.BoardSquares;

import Monopoly.Player;

public abstract class BoardSquare {
    /**
     * name of the square
     */
    private String name;

    public BoardSquare(String name) {
        this.name = name;
    }

    /**
     * returns the name of the square
     *
     * @return the name of the square
     */
    public String getName() {
        return name;
    }

    /**
     * action that the square takes.
     */
    public abstract void Action(Player player);

}
