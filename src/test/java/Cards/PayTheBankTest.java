package Cards;

import Controllers.GameBoard;
import Fields.Field;
import Fields.FieldChance;
import Player.Player;
import org.junit.jupiter.api.Test;

class PayTheBankTest {

    @Test
    void drawCard() {
        Player[] players = new Player[]{new Player("test1"), new Player("test2"), new Player("test3"), new Player("test4")};
        Field[] f2 = new Field[0];
        players[0].setMoney(20000);
        GameBoard f1 = new GameBoard();
        System.out.println(players[0].getjailCards());
        DynamicArr<PayTheBank> choiceCards = new DynamicArr<PayTheBank>();
        int choiceCounter = 0;
        for (int i = 0; i < f1.getCards().size; i++) {
            if(f1.getCards().getLast() instanceof PayTheBank){
                choiceCards.add((PayTheBank) f1.getCards().getLast());
            }
            f1.getCards().lastItemToFront();
        }
        for (int i = 0; i < choiceCards.size; i++) {
            choiceCards.getLast().drawCard(players[0]);
            System.out.println(choiceCards.getLast().getCardText());
            System.out.println("Spilleren " + players[0].getName() + "'s pengebeholdning:" + players[0].getMoney());
            choiceCards.lastItemToFront();
        }



    }
}