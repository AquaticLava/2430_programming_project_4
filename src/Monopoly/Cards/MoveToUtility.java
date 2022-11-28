package Monopoly.Cards;

import Monopoly.Player;

public class MoveToUtility extends Card{
    public MoveToUtility(String name) {
        super(name);
    }

    @Override
    public void Action(Player player) {
        int currentSquare = player.getCurrentSquare();
        int[] utilities = {12, 28};

        for (int j : utilities) {
            if (currentSquare < j) {
                player.setCurrentSquare(j);
            }
            player.setCurrentSquare(utilities[0]); // currentSquare > last utility square
        }
    }
}
