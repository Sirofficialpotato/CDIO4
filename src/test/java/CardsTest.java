import Cards.*;
import org.junit.jupiter.api.Test;

class CardsTest {

//    public void mix() {
//
//        Random rand = new Random();
//        for (int i = 0; i < ChanceCards.length; i++) {
//            int randomIndexToSwap = rand.nextInt(ChanceCards.length);
//            String temp = ChanceCards[randomIndexToSwap];
//            ChanceCards[randomIndexToSwap] = ChanceCards[i];
//            ChanceCards[i] = temp;
//        }
//    }

    @Test
    public void testnr2()
    {
        CardInfo info = new CardInfo();
        for (int i = 0; i < info.getCardInfo()[0].length; i++) {
            System.out.println(info.getCardInfo()[0][i]);
        }


    }

}



