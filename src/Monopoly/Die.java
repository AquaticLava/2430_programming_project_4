package Monopoly;

/**
 * represents a six sided die
 */
public class Die {

    private int sides = 6;

    /**
     * Roll the die
     *
     * @return a random number 1-6
     */
    public static int Roll() {
        return (int) (Math.random()*6) + 1;
    }

//Testing to show spread of die rolls
    public static void main(String[] args) {
        int timesToRoll = 1000;
        int[] countRolls = new int[8];

        for (int i = 0; i < timesToRoll; i++) { // roll the die and increment the associated array index by 1
           int currentRoll = Roll();
           countRolls[currentRoll]++;
        }

        for (int i = 0; i < countRolls.length; i++) {
            System.out.println(i + ": " + countRolls[i]);
        }
    }

}
