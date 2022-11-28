package Monopoly.Cards;

import Monopoly.Player;

public class MoveToRail extends Card{
    public MoveToRail(String name) {
        super(name);
    }

    @Override
    public void Action(Player player) {
        int currentSquare = player.getCurrentSquare();
        int[] railStations = {5, 15, 25, 35};

        for (int j : railStations) {
            if (currentSquare < j) {
                player.setCurrentSquare(j);
            }
            player.setCurrentSquare(railStations[0]); // currentSquare > last railStation
        }
    }
}
