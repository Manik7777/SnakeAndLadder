package src.model;
import java.util.Random;

public class Dice {
    private int numberOnDice=6;
    Random random;
    public Dice(){
        random = new Random();
    }
    public int getDiceValueAfterRoll(){
        return random.nextInt(this.numberOnDice) + 1;
    }
    
}
