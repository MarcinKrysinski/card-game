package com.trening;


import java.util.Arrays;
import java.util.Random;


public class Main {
    //Metoda która tworzy talie kart
    private static Card[] makeDeck(){
        Card[] cards = new Card[52];
        int i = 0;
        for(int suit = 0; suit < 4; suit++){
            for (int rank = 1; rank < 14; rank++) {
                cards[i] = new Card(rank, suit);
                i++;
            }
        }
        return cards;
    }
    //Metoda która zwraca określoną ilośc randomowych kart
    private static Card[] makeNumberDeck(int howMany){
        Card[] cards = new Card[howMany];
        Random generator = new Random();
        for(int i = 0; i < cards.length; i++){
            int rank = generator.nextInt(13)+1;
            int suit = 0;//generator.nextInt(4);
            cards[i] = new Card(rank, suit);
            }
        return cards;
        }



    public static void main(String[] args) {

//        Card[] cards = makeDeck();
//        Card card = new Card(3,0);
//        System.out.println("Card: " + card);
//        Card card1 = new Card(3, 0);
//        Card card2 = new Card(2, 0);
////        System.out.println(card2);
////        System.out.println(card1.compareTo(card2));
////        System.out.println(Arrays.toString(cards));
////        Card[] cardsTest =makeNumberDeck(5);
////        System.out.println(Arrays.toString(cardsTest));
////        Card.pokerColor(cardsTest);
////        int test = Card.binarySearch(cards, card1);
////        System.out.println(test);
//        Deck deck = new Deck();
//        System.out.println(deck);
//        deck.shuffle();
//        System.out.println(deck);

        DeckCollection deck = new DeckCollection("Talia");
        deck.shuffle();

        Hand hand = new Hand("W dłoni");
        deck.deal(hand, 5);
        hand.display();


        Hand drawPile = new Hand("Stos pozostałych kart");
        deck.dealAll(drawPile);
        System.out.println("liczba pozostałych kart: " + drawPile.size());






    }
}
