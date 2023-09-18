package src;
import java.util.*;

import src.model.Entities;
import src.service.SnakeAndLadderService;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Entities entities= Entities.getInstance();
        
        // Input(Number of snakes)
        System.out.println("Enter Snakes");   
        int noOfSnakes = scanner.nextInt();
        while(noOfSnakes>0){
            int head =scanner.nextInt();
            int tail=scanner.nextInt();
            entities.setSnakes(head, tail);
            noOfSnakes--;
        }
        // Input(Number of ladders)
        System.out.println("Enter Ladders");  
        int noOfLadders = scanner.nextInt();
        while(noOfLadders>0){
            int start =scanner.nextInt();
            int end=scanner.nextInt();
            entities.setLadders(start, end);
            noOfLadders--;
        }


         // Input(Number of players)
         System.out.println("Enter Players");  
         int noOfPlayers = scanner.nextInt();
         int i=0;
         while(noOfPlayers>0){
             String player = scanner.next();
             entities.setPlayers(i++, player);
             noOfPlayers--;
         }
        SnakeAndLadderService play = new SnakeAndLadderService();
        System.out.println(play.playGame());   
    }
}
