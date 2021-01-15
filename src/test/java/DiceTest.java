import DiceStuff.Die;
import DiceStuff.Rafflecup;

import java.util.ArrayList;

public class DiceTest {
    public static void DiceTest() {
        final int NUMBEROFTRIES = 100000;
        int[] counterArray = new int[11];
        double[] percentArray = new double[11];
        Rafflecup tester = new Rafflecup();
        ArrayList<Integer> testList = new ArrayList<Integer>();
        // for loop that initialises an integer array to keep track of number of times a specific roll has happened
        for (int i = 0; i < 10; i++) {
            counterArray[i] = 0;
        }

        for (int i = 0; i < NUMBEROFTRIES; i++) {
            tester.useRafflecup();
            testList.add(tester.getD1() + tester.getD2());
            counterArray[ ((int)testList.get(i))-2]++;
        }

        for (int i = 0; i < 11; i++) {
            //System.out.println(counterArray[i]);
            percentArray[i] = (double) counterArray[i]/ (double) NUMBEROFTRIES * 100;
        }
        System.out.println("Dice occurrences displayed in procent:");
        for (int i = 0; i < 11; i++) {
            System.out.println(i+2+": "+percentArray[i]+"%");
        }
        System.out.println("Dice occurrences:");
        for (int i = 0; i < 11; i++) {
            System.out.println(i+2+": "+counterArray[i]);
        }
    }
}