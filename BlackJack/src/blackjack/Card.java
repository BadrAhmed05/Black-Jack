/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author badr0
 */
public class Card {
    private final int suit;
    private final int rank;
    private final int value;
    public Card(int s,int r,int v)
    {
        this.suit=s;
        this.rank=r;
        this.value=v;
    }
    public Card(Card card)
    {
        this.suit=card.suit;
        this.rank=card.rank;
        this.value=card.value;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }
    
    
}
