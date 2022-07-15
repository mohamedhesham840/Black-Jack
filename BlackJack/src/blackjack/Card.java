package blackjack;
public class Card {
 final private int suit;
 final private int rank;
 final private int value;

    public Card(int suit, int rank , int value)
    {
        this.suit=suit;
        this.rank=rank;
        this.value=value;
    }
    public Card(Card card)
    {
        this.suit=card.suit;
        this.rank=card.rank;
        this.value=card.value;
    }
    //get functions
    public int getRank() { return rank; }
    public int getSuit() {
        return suit;
    }
    public int getValue() {
        return value;
    }
    public void displayCardInfo() {
        getRank();
        getSuit();
        getValue();
    }
}