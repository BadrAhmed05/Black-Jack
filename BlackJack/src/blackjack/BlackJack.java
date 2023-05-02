/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.Scanner;
/**
 *
 * @author badr0
 */
public class BlackJack {

    /**
     * @param args the command line arguments
     */
    
    static Game game = new Game();
   // static Player players=new Player();
    static Player players = new Player();
    public static void main(String[] args) {
        // TODO code application logic here
        GUI gui = new GUI();
        
      game.generatecard();
      game.setinfo();

      
      
      gui.runGUI( game.deck,game.players[0].getHand() ,game.players[1].getHand(), game.players[2].getHand(), game.players[3].getHand() );
      
      startgamepl(gui);
      game.updatescore();
      dealer(gui);
      game.updatescore();
      gamewin();
      
     }
    
    public static void gamewin()
    {
    int highscore=0,highscore1=0,highscore2=0,highscore3=0;
    int thewinner=-5,thewinner1=-5,thewinner2=-5;
    for(int i=0;i<4;i++)
    {
    if(game.highscore[i]>highscore)
    {
    highscore=game.highscore[i];
    thewinner=i;
             if(game.highscore[thewinner]==game.highscore[thewinner +1])     
             {
             thewinner=-4;
             }
    }

    
    else
     
       System.out.println("The player's name : "+ game.players[i].name +" is Busted");
    }
    if(thewinner>=0)
    {
    System.out.println("the Winner IS : "+ game.players[thewinner].name);
    System.out.println("His Score IS : "+ highscore);
    }
    else if(thewinner==-4)
    {
    System.out.println("PUSH");
    }
   
   
    
    }
    
    public static void startgamepl(GUI gui)
    {
    Scanner input =new Scanner (System.in);
    for(int i=0;i<3;i++)
    {
        while(!input.equals("stand"))
        {
        System.out.println("Player number "+(i+1)+"(hit/stand)");
         String x=input.next();
    if( "hit".equals(x))
    {
        Card card=game.draws();
        game.players[i].adding(card);
        gui.updatePlayerHand(card,i);
    }
    else
    {
    break;
    }
    
   
    }
    }
    
    }
   
    public static void dealer(GUI gui)
    {
    int highscore=0;
    boolean win=true;

    for(int i=0;i<3;i++)
    {
    if(game.highscore[i]>=game.players[3].score){
        
        win=false;
        
    }
    if(game.highscore[i]>highscore)
    {
    highscore=game.highscore[i];
    }
    if(!win)
    {
    while(game.players[3].score<highscore)
        {
            Card card=game.draws();
            game.players[3].adding(card);
            gui.updateDealerHand(card,game.deck);
        }
    }
        
    else 
    {
        return;
    }
    
    }
    
    
    
    
    
    }

}
