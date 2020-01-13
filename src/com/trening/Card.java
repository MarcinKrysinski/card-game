package com.trening;


public class Card {

    private static final String[] RANKS = {null, "as", "2", "3", "4", "5", "6", "7", "8", "9", "10", "walet", "dama", "król"};
    private static final String[] SUITS = {"trefl", "karo", "kier", "pik"};

    private final int rank;
    private final int suit;


    Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;

    }

    String compareTo(Card that) {
        if (this.rank == that.rank) {
            return "They are the same";
        }
        if (that.rank == 1) {
            return RANKS[this.rank] + " of " + SUITS[this.suit] + " is lower than " + RANKS[that.rank] + " of " + SUITS[that.suit];
        }
        if (this.rank == 1) {
            return RANKS[this.rank] + " of " + SUITS[this.suit] + " is higher than " + RANKS[that.rank] + " of " + SUITS[that.suit];
        }
        if (this.rank < that.rank) {
            return RANKS[this.rank] + " of " + SUITS[this.suit] + " is lower than " + RANKS[that.rank] + " of " + SUITS[that.suit];
        }
        if (this.rank > that.rank) {
            return RANKS[this.rank] + " of " + SUITS[this.suit] + " is higher than " + RANKS[that.rank] + " of " + SUITS[that.suit];
        }
        return "Error";
    }

    //* Kiedy karta this jest większa zwraca 1, gdy karta this jest mniejsza zwrca -1. Zwraca zero w przypadku gdy karty są identyczne
    int compareToBin(Card that) {
        if (this.rank == that.rank) {
            return 0;
        }
        if (that.rank == 1) {
            return -1;
        }
        if (this.rank == 1) {
            return 1;
        }
        if (this.rank < that.rank) {
            return -1;
        }
        if (this.rank > that.rank) {
            return 1;
        }
        return Integer.parseInt(null);
    }

    static void pokerColor(Card[] cards) {
        int i = 0;
        for (int m = 0; m < cards.length - 1; m++) {
            if (cards[m].suit == cards[m + 1].suit) {
                i++;
            }
        }
        if (i == cards.length - 1) {
            System.out.println("Kolor!");
        } else {
            System.out.println("Brak koloru");
        }
    }

    static int binarySearch(Card[] cards, Card target){
        int low = 0;
        int high = cards.length-1;
        while (low <= high){
            int mid =(low+high)/2;
            int comp = cards[mid].compareToBin(target);
            if (comp == 0){
                return mid;
            }
            else if (comp < 0){
                low = mid + 1;
            }
            else {
                high = mid -1;
            }
        }
        return -1;
    }


        public String toString () {
            return RANKS[this.rank] + " of " + SUITS[this.suit];
        }
}



