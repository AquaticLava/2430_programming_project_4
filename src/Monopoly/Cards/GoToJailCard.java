package Monopoly.Cards;

import Monopoly.Player;

public class GoToJailCard extends Card{
    public GoToJailCard(String name) {
        super(name);
    }

    @Override
    public void Action(Player player) {
        player.setCurrentSquare(40);
        player.getMonopoly().getGameBoard()[40].Action(player);
    }
}
