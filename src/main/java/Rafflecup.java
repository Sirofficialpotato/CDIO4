public class Rafflecup {

    private Die d1, d2;


    public Rafflecup(Die dice1, Die dice2) {
        this.d1 = dice1;
        this.d2 = dice2;
    }

    public void useRafflecup() {
        d1.rollDie();
        d2.rollDie();
    }

    public Boolean SameDie()
    {
        if (d1.getFaceValue() == d2.getFaceValue())
        {
            return true;
        }
        else
            return false;
    }

    public int getD1(){
        return d1.getFaceValue();
    }
    public int getD2(){
        return d2.getFaceValue();
    }


}
