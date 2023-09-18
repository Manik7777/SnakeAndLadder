package src.service;

import src.model.Dice;
import src.model.Entities;
import src.model.Pair;
import java.util.*;

public class SnakeAndLadderService {
    HashMap<String, Pair> playerHistory;
    HashMap<String, Integer> playerLatestPosition;
    Entities entities;
    Dice dice;
    public SnakeAndLadderService(){
        playerHistory = new HashMap<>();
        playerLatestPosition = new HashMap<>();
        entities = Entities.getInstance();
        dice = new Dice();

    }
        public String playGame() {
            startGame();
            int i = 0; // Start with the first player
            while (true) {
                String playerName = entities.getPlayers().get(i);
                int diceNumber = dice.getDiceValueAfterRoll();
                int currentPosition = playerLatestPosition.get(playerName);
                
                StringBuilder result = new StringBuilder(playerName);
        
                if (checkFordiceNumberGreaterThan100(currentPosition + diceNumber)) {
                    result.append(" rolled a ").append(diceNumber);
                    result.append(" and moved from ").append(currentPosition);
        
                    int endPosition = currentPosition + diceNumber;
                    String sl = "";
        
                    if (entities.getSnakes().containsKey(endPosition)) {
                        // Captures snake
                        sl = " after Snake dinner";
                        currentPosition = entities.getSnakes().get(endPosition);
                    } else if (entities.getLadders().containsKey(endPosition)) {
                        // Climbs a ladder
                        sl = " after Ladder ride";
                        currentPosition = entities.getLadders().get(endPosition);
                    } else {
                        currentPosition += diceNumber;
                    }
        
                    playerLatestPosition.put(playerName, currentPosition);
                    result.append(" to ").append(currentPosition);
                    result.append(sl);
                }
                System.out.println(result);
        
                if (isPlayerWon(playerName)) {
                    return playerName;
                }
        
                i = (i + 1) % entities.getPlayers().size(); // Move to the next player
            }
        
    }
    private boolean isPlayerWon(String player){
        return playerLatestPosition.get(player) == 100;
    }
    private boolean checkFordiceNumberGreaterThan100(int endPostion){
        return endPostion<=100;
    }
    private void startGame(){
        for(int i=0;i<entities.getPlayers().size();i++){
            playerLatestPosition.put(entities.getPlayers().get(i),0);
        }
    }
}