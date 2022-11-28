package Monopoly;

import Monopoly.Cards.Card;
import Monopoly.Cards.OutOfJail;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Deck {

    public Deck(List<Card> cards) {
        this.discardedCards = cards;
        this.cards = new LinkedList<>();
        this.size = cards.size();
        Shuffle();
    }

    /**
     * cards in this deck
     */
    private Queue<Card> cards;
    private Random random = new Random();
    private int size = 0;

    /**
     * cards that have been discarded.
     */
    private List<Card> discardedCards;

    /**
     * shuffles the deck
     */
    public void Shuffle() {
        int numOfCards = discardedCards.size();
        for (int i = 0; i < numOfCards; i++) {
            int randomIndex = random.nextInt(discardedCards.size());
            cards.add(discardedCards.remove(randomIndex));
        }
    }

    /**
     * Returns the next card, if there is no next card the discard pile is shuffled and put into the deck of cards.
     */
    public Card Draw() {
        if (cards.isEmpty()){
            Shuffle();
        }
        Card card = cards.remove();
        if (!(card instanceof OutOfJail)){
            discardedCards.add(card);
            size--;
        }

        return card;
    }

    public void AddOutOfJailCard(){
        discardedCards.add(new OutOfJail("Get out of jail Free"));
        size++;
    }
}
