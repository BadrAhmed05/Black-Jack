/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author badr0
 */
public class Game {
    int value=0,count=0;
    public Player[] players= new Player[4];
  //  players[] = new Player();
    public  Card[] deck=new Card[52];
    int [] highscore = new int[4];
    public void generatecard (){
        for(int i=0;i<4;i++)
        {
         for(int j=0;j<13;j++) 
         {
             if(j<=8)
             {
             value=j+1;
             }
             else
             {
             value=10;
             }
             
             Card cards=new Card(i,j,value);
             deck[count] = cards;
             count++;
         }
        }
    }
    public Card draws()
    {
    
        Random rand=new Random();
        Card card=null;
        while (card==null)
        {
        int randno=rand.nextInt(51);
        card=deck[randno];
        deck[randno]=null;
        }
        return card;
     
    }     
    
    public void setinfo()
    {
        Scanner input = new Scanner(System.in);
      for(int i=0;i<3;i++)
      {
       System.out.println("Enter the Name of Player number"+(i+1)+" : ");
       players[i]=new Player();
       players[i].name=input.next();
       players[i].adding(draws());
       players[i].adding(draws());

      }
       players[3]=new Player();
       players[3].name="dealer";
       players[3].adding(draws());
       players[3].adding(draws());
    }
    
    public void updatescore()
    {
    for(int i=0;i<4;i++)
    {
    //players[i]=new Player();
    if(players[i].score <=21)
    {
    highscore[i]=players[i].score;
    }
    else
        players[i].score =0;
    
    }
    
    }
      
    
    }
    
