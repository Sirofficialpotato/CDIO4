package Cards;

import Fields.Field;
import Fields.FieldChance;
import Player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetPaidOrPayTest {

    @Test
    void drawCard() {
        Player[] players = new Player[]{new Player("test1"), new Player("test2"), new Player("test3"), new Player("test4")};
        Field[] f2 = new Field[0];
        FieldChance f1 = new FieldChance();
        players[0].setMoney(10);
        players[1].setMoney(10);
        players[2].setMoney(10);
        players[3].setMoney(10);
        System.out.println("spiller1:" + players[0].getMoney() + " spiller2:" + players[1].getMoney() + " spiller3:" + players[2].getMoney() + " spiller4:" + players[3].getMoney());
        DynamicArr<GetPaidOrPay> choiceCards = new DynamicArr<GetPaidOrPay>();
        int choiceCounter = 0;
        for (int i = 0; i < f1.getCards().size; i++) {
            if(f1.getCards().getLast() instanceof GetPaidOrPay){
                choiceCards.add((GetPaidOrPay) f1.getCards().getLast());
            }
            f1.getCards().lastItemToFront();
        }
        for (int i = 0; i < choiceCards.size; i++) {

            System.out.print(choiceCards.getLast().getCardText());
            choiceCards.getLast().drawCard(players, 0, f2, -1);
            System.out.println("Spiller1:" + players[0].getMoney() + " Spiller2:" + players[1].getMoney() + " Spiller3:" + players[2].getMoney() + " Spiller4:" + players[3].getMoney());
            choiceCards.lastItemToFront();
        }

    }
    }