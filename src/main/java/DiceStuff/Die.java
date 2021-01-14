package DiceStuff;

public class Die {

    private int MAX = 6; // max value of a die
    private int faceValue; // value of the die

    public Die(int value) {
        faceValue = value;
    }

    public int rollDie() {
        faceValue = (int) (Math.random() * MAX) + 1;
        return faceValue;
        }

    public int getFaceValue() { return faceValue;
    }
}