package Cards;

import Fields.Field;
import Fields.FieldChance;
import Player.Player;
import org.junit.jupiter.api.Test;

class PlayerSpecificTest {

    @Test
    void drawCard() {
        Player[] players = new Player[]{new Player("test1"), new Player("test2"), new Player("test3"), new Player("test4")};
        Field[] f2 = new Field[0];
        FieldChance f1 = new FieldChance();
        System.out.println(players[0].getCardArray());
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
            System.out.print(choiceCards.getLast().getCardText());
            System.out.print("player1 -bil: ");
            players[0].getCardArray().print();
            System.out.println();
            System.out.print("player2 -skib: ");
            players[1].getCardArray().print();
            System.out.println();
            System.out.print("player3 -kat: ");
            players[2].getCardArray().print();
            System.out.println();
            System.out.print("player4 -hund: ");
            players[3].getCardArray().print();
            choiceCards.lastItemToFront();
        }



    }
}