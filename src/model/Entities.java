package src.model;

import java.util.*;

public class Entities {
    HashMap<Integer,Integer> snakes;
    HashMap<Integer,Integer> ladders;
    HashMap<Integer,String> players;
    static Entities instance = null;

    private Entities(){
        snakes = new HashMap<>();
        ladders = new HashMap<>();
        players = new HashMap<>();
    }

    public void setSnakes(int start,int end){
        snakes.put(start,end);
    }
    public HashMap<Integer,Integer> getSnakes(){
       return snakes;
    }
    public void setLadders(int start,int end){
        ladders.put(start,end);
    }
    public HashMap<Integer,Integer> getLadders(){
        return ladders;
     }
    public void setPlayers(int index,String playerName){
        players.put(index,playerName);
    }
    public HashMap<Integer,String> getPlayers(){
       return players;
    }
    public static Entities getInstance(){
        if(instance==null){
            instance = new Entities();
        }
        return instance;
    }
}
