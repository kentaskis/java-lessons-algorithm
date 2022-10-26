package _26102022;

import java.util.Stack;

public class CardGame {
    public Stack<Card> deck;

    private Stack<Card> graveyard;

    public Stack<Card> getDeck() {
        return deck;
    }

    public void setDeck(Stack<Card> deck) {
        this.deck = deck;
    }

    public Stack<Card> getGraveyard() {
        return graveyard;
    }

    public void setGraveyard(Stack<Card> graveyard) {
        this.graveyard = graveyard;
    }

    public Card getCardFromDeck(){
        return deck.pop();
    }

    public void discard(Card card){
        graveyard.push(card);
    }

    public Card lookTopCard(){
        return deck.peek();
    }
}
