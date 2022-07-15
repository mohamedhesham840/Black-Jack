package blackjack;
import java.util.Random;
import java.util.Scanner;

public class BlackJack {

    //Game game = new Game();

    public  static void main(String[] args) {

        GUI gui = new GUI();
        Game game = new Game();
        game.generate();
        //Take names///////////
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter 3 names");
        String player1 = scan.nextLine();
        String player2 = scan.nextLine();
        String player3 = scan.nextLine();

        //Add players to the game//////////
        game.addPlayer(player1, player2, player3);
        gui.runGUI(game.getCardDick(),game.players[0].getCards(), game.players[1].getCards(), game.players[2].getCards(), game.players[3].getCards());

        //Game process//////////
        String ans=null;
        for (int i = 0; i < 3; i++)
        {

            do {
                System.out.println(game.players[i].getName() + "  hit or stand  ?");
                ans = scan.nextLine();
                if (ans.equals("hit"))                                                            //&&game.players[i].getScore()<21  (bs kdha kdah bykon awl warqten maximum sum hykon 20 fa kdha kdha lazm ykon aql mn 21)
                {
                    Card carr=new Card(game.draw());
                    game.players[i].addCard(carr);
                    gui.updatePlayerHand(carr,i);
                }

            } while (ans.equals("hit") && game.players[i].getScore() < 21);                              //////////SEE IT AGAIN /////   (momken n7t tool ma hwa msh busted )
            if (game.players[i].getScore()> Game.HighScore &&game.players[i].getScore()<= 21&&!game.players[i].getBusted()) {
                Game.HighScore = game.players[i].getScore();
            }
        }

       /* if(game.players[0].getBusted()&&game.players[1].getBusted()&&game.players[2].getBusted())
        {
          gui.updateDealerHand(,game.CardDick);
        }*/

        //Delar turn

            int oldHighScore = Game.HighScore;

            if (game.players[3].getScore() < oldHighScore)
            {
                while (game.players[3].getScore() < oldHighScore)
                {
                    if (game.players[3].getScore() < 21)
                    {
                        Card carr2 = new Card(game.draw());
                        game.players[3].addCard(carr2);
                        if (game.players[3].getScore()> Game.HighScore &&game.players[3].getScore()<= 21&&!game.players[3].getBusted()) {
                            Game.HighScore = game.players[3].getScore();
                        }
                        gui.updateDealerHand(carr2, game.CardDick);
                    }

                }
            }
            else
            {
                Card carr2 = new Card(game.draw());
                game.players[3].addCard(carr2);
                if (game.players[3].getScore()> Game.HighScore &&game.players[3].getScore()<= 21&&!game.players[3].getBusted()) {
                    Game.HighScore = game.players[3].getScore();
                }
                gui.updateDealerHand(carr2, game.CardDick);
            }

            //who is the winner??
        game.TheWinner(game);

      }

}
