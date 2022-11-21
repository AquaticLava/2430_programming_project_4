package Monopoly.Cards;

import Monopoly.BoardSquares.BoardSquare;
import Monopoly.Monopoly;
import Monopoly.Player;

public class MoveToSquare extends Card{
    private int squareToMoveTo;

    public MoveToSquare(String name, int square) {
        super(name);
        squareToMoveTo = square;
    }

    @Override
    public void Action(Player player) {
        player.setCurrentSquare(squareToMoveTo);
        BoardSquare[] board = player.getMonopoly().getGameBoard();
        board[player.getCurrentSquare()].Action(player);

    }
}
