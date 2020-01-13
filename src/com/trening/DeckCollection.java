package com.trening;

public class DeckCollection extends CardCollection {

    public DeckCollection(String label) {
        super(label);
        for (int suit = 0; suit < 4; suit++){
            for(int rank = 1; rank < 14; rank++){
                addCard(new Card(rank,suit));
            }
        }
    }
}
