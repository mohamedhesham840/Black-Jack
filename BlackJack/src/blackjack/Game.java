package blackjack;
import java.util.Random;

public class Game {
    Player[] players=new Player[4];
    Card[] CardDick=new Card[52];
    public static int  HighScore=0;
    protected int k=0;

    public void generate()
    {
        for (int i =0 ; i<4; i++)
        {
            for(int j=0 ; j<13 ; j++)
            {
                int value=j+1;
                if(j>9)
                {
                    value=10;
                }
                CardDick[k] = new Card(i, j,value);

                  k++;

            }

        }
        k=0;
    }
    Card draw()
    {
       Random rand = new Random();
       while (true)
       {
           int randChoice = rand.nextInt(52);
           if (CardDick[randChoice] != null)
           {
               Card card = new Card(CardDick[randChoice]);
               CardDick[randChoice] = null;
               return card;
           }
       }
    }

    public void addPlayer(String p1,String p2 ,String p3)
    {

        players[0]=new Player(p1);
        players[1]=new Player(p2);
        players[2]=new Player(p3);
        players[3]=new Player("Delar");
        for(int i=0;  i<4 ;i++)
        {
            for(int j=0 ;j<2; j++) {
                players[i].addCard(draw());
            }
        }

    }

    public void TheWinner(Game g)
    {  int counterB=0,counterW=0;
        String winnerName=null;
        for(int i=0 ; i<4 ;i++)
        {
           if(g.players[i].getBlackjack())
           {
               counterB++;
               winnerName=g.players[i].getName();


           }
           else if(g.players[i].getScore()==Game.HighScore)
           {
               counterW++;
               winnerName=g.players[i].getName();
           }
        }


        if(players[0].getBusted()&&players[1].getBusted()&&players[2].getBusted())
        {
            System.out.println(" Delarr is the winner");
        }
   else if(counterB>1 ||counterW>1)
        {
            System.out.println("PUSH");
        }
        else
        {

            System.out.println(winnerName +" is The winner");
        }

    }

    public Card[] getCardDick() {
        return CardDick;
    }


}
