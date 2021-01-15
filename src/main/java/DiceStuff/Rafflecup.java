package DiceStuff;

import DiceStuff.Die;

public class Rafflecup {

    private Die d1, d2;

    public Rafflecup() {
        Die dice1 = new Die(2);
        Die dice2 = new Die(2);
        this.d1 = dice1;
        this.d2 = dice2;
    }

    //Går igen med samme værdier. Dette skal fikses. Skriv test der tjekker om der er dobbeltslag
    public void useRafflecup() {
        d1.rollDie();
        d2.rollDie();
        }


    //}
    public int RafflecupFaceValue()
    {
        return d1.getFaceValue() + d2.getFaceValue();
    }

    public Boolean SameDie() { /*return d1.getFaceValue() == d2.getFaceValue()*/ return true; }

    public int getD1(){
        return d1.getFaceValue();
    }
    public int getD2(){
        return d2.getFaceValue();
    }


}