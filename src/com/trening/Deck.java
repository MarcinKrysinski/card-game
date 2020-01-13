package com.trening;

import java.util.Arrays;
import java.util.Random;

public class Deck {

    private Card[] cards;

    public Deck(int n){
        this.cards = new Card[n];
    }

    public Deck(){
        this.cards = new Card[52];
        int i = 0;
        for(int suit = 0; suit < 4; suit++){
            for (int rank = 1; rank < 14; rank++) {
                this.cards[i] = new Card(rank, suit);
                i++;
            }
        }
    }

    public void printDeck(){
        for (Card card : this.cards) {
            System.out.println(card);
        }
    }

    /** Wybiera losową liczbę z przedziału od low do high włącznie z tymi wartościami.
     */

    public int randomInt(int low, int high) {
        int range = (high - low) + 1;
        return (int) (Math.random() * range) + low;
    }

    /**
     * Zamienia miejscami karty, których indeksy to i oraz j.
     */
    public void swapCards(int i, int j) {
        Card tmp = this.cards[i];
        this.cards[i] = this.cards[j];
        this.cards[j] = tmp;
    }
    /**
     * Losowo tasuje tablicę kart.
     */
    public void shuffle() {
        for (int i = 0; i<cards.length; i++) {
            int j = randomInt(0,52);
            swapCards(i,j);
        }
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + Arrays.toString(cards) +
                '}';
    }
}
