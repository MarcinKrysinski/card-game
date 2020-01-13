package com.trening;

import java.util.ArrayList;
import java.util.Random;

public class CardCollection {
    private String label;
    private ArrayList<Card> cards;

    public CardCollection(String label){
        this.label = label;
        this.cards = new ArrayList<Card>();
    }

    /**
     * Dodanie karty do kolekcji
     * @param card
     */
    public void addCard(Card card){
        cards.add(card);
    }

    /**
     * Usuwa karte z danej pozycji i oraz przesuwa reszte kart w lewo
     * @param i - indeks danej karty
     * @return
     */
    public Card popCard (int i){
        return cards.remove(i);
    }

    /**
     * Zwraca etykete kolekcji
     * @return
     */
    public String getLabel() {
        return label;
    }

    /**
     * Usuwa i zwraca ostanią karte z kolekcji
     * @return
     */
    public Card popCard (){
        int i = size() - 1;
        return popCard(i);
    }

    public int size(){
        return cards.size();
    }

    /**
     * Zwraca 'true' gdy metoda size() zwraca 0
     * @return
     */
    public boolean empty(){
        return cards.size() == 0;
    }

    /**
     * Usuwa n kart z kolekcji i dodaje je do innej kolekcji (rozdanie n kart)
     * @param that
     * @param n
     */
    public void deal(CardCollection that, int n){
        for (int i=0; i<n; i++){
            Card card = popCard();
            that.addCard(card);
        }
    }

    public Card getCard(int i){
        return cards.get(i);
    }

    /**
     * Zwraca ostanią karte bez usuwana jej
     * @return
     */
    public Card last(){
        int i = size() - 1;
        return cards.get(i);
    }

    /**
     * Metoda zamienijąca dwie karty w talii miejscami
     *
     * @param i
     * @param j
     */
    public void swapCards (int i, int j){
        Card temp = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, temp);
    }

    public void shuffle(){
        Random rand = new Random();
        for (int i = size()-1; i > 0; i--){ //
            int j = rand.nextInt(i);
            swapCards(i, j);
        }
    }

    /**
     * Przenosi wszystkie pozostałe karty do podanej kolekcji.
     */
    public void dealAll(CardCollection that) {
        int n = size();
        deal(that, n);
    }
}
