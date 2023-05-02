package blackjack;

/**
 *
 * @author badr0
 */
public class Player {
    public String name;
    public int score=0;
    private Card[] hand=new Card[11];
    boolean blackjack=false;
    boolean lost=false;
    int countcards=0;

   /* public Player() {
        this.hand = new Card[11];
    }*/

    public Card[] getHand() {
        return hand;
    }
   
    
public void adding(Card card)
{
    if(countcards<11)
    {
this.hand[countcards]=card;
countcards++;
score+=card.getValue();
    }
}

   

}
