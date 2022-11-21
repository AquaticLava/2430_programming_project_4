package Monopoly.Cards;

import Monopoly.BoardSquares.BoardSquare;
import Monopoly.Player;

public class MoveBack extends Card{
    private int numberOfSquares;

    public MoveBack(String name, int numberOfSquares) {
        super(name);
        this.numberOfSquares = numberOfSquares;
    }

    @Override
    public void Action(Player player) {
        player.setCurrentSquare(player.getCurrentSquare() - numberOfSquares);
        BoardSquare[] board = player.getMonopoly().getGameBoard();
        board[player.getCurrentSquare()].Action(player);
    }
}
