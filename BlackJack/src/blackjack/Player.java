package blackjack;

public class Player {
   private String Name=null;
   private int Score=0;
   private int cardCounter=0;
   private Card cards[] =new Card[11];////////////////i changed something
   private Boolean blackjack=false;
   private  Boolean winner=false;
   private Boolean busted=false;

   Player(String Name)
    {
    this.Name=Name;
    }
    public String getName() {
        return Name;

    }

    public Boolean getBlackjack() {
        return blackjack;
    }

    public int getScore() {
        return Score;
    }

    public Boolean getWinner() {
        return winner;
    }

    public void displayCards()
    {
        for(int i=0; i <11 ;i++)
        {
            if(cards[i]!=null)
            {
                cards[i].displayCardInfo();
            }
        }
    }

    public int getCardCounter() {
        return cardCounter;
    }

    public void setBlackjack(Boolean blackjack) {
        this.blackjack = blackjack;
    }

    public void setScore(int score) {
        Score = score;
    }
    public void addCard(Card cardd)
    {

              cards[cardCounter] = new Card(cardd);///////////
              Score += cards[cardCounter].getValue();
              cardCounter++;

              if (Score == 21) {
                  blackjack = true;
                  winner = true;
              }
              if (Score > 21) {
                  busted = true;
                  System.out.println("You are busted ! ");
              }
            /*        (useless i changes it's place in the for before do whhile because get the
             top score the number before it got busted we have to delete the top score of number got busted  )if (Score > Game.HighScore && Score <= 21) {
                  Game.HighScore = Score;
              }*/

    }

    public void setWinner(Boolean winner) {
        this.winner = winner;
    }


    public Card[] getCards() {
        return cards;
    }

    public void setBusted(Boolean busted) {
        this.busted = busted;
    }

    public Boolean getBusted() {
        return busted;
    }
}