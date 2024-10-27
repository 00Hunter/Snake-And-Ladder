import  java.util.Random;
public class Dice {


    private int Dice_upperBound;
    private int Dice_lowerBound;
    private int numberOfDice = 1;

    public Dice(int UpperBound, int LowerBound) {
        this.Dice_upperBound = UpperBound;
        this.Dice_lowerBound = LowerBound;
    }

    public void setNumberOfDice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public int RollDice() {
        int totalNumberRolled = 0;
        Random random = new Random();
        for (int i = 0; i < this.numberOfDice; i++) {
            totalNumberRolled = totalNumberRolled + random.nextInt(Dice_upperBound - Dice_lowerBound+1) + Dice_lowerBound;
        }
        return totalNumberRolled;
    }
}
