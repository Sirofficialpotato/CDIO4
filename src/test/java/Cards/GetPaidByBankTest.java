package Cards;

import Controllers.GameBoard;
import Fields.Field;
import Fields.FieldChance;
import Player.Player;
import org.junit.jupiter.api.Test;

class GetPaidByBankTest {

    @Test
    void drawCard() {
        Player[] players = new Player[]{new Player("test1"), new Player("test2"), new Player("test3"), new Player("test4")};
        Field[] f2 = new Field[0];
        GameBoard f1 = new GameBoard();
        players[0].setMoney(10000);
        players[1].setMoney(10000);
        players[2].setMoney(10000);
        players[3].setMoney(10000);
        System.out.println("spiller1:" + players[0].getMoney());
        DynamicArr<GetPaidByBank> choiceCards = new DynamicArr<GetPaidByBank>();
        int choiceCounter = 0;
        for (int i = 0; i < f1.getCards().size; i++) {
            if(f1.getCards().getLast() instanceof GetPaidByBank){
                choiceCards.add((GetPaidByBank) f1.getCards().getLast());
            }
            f1.getCards().lastItemToFront();
        }
        for (int i = 0; i < choiceCards.size; i++) {

            System.out.print(choiceCards.getLast().getCardText());
            choiceCards.getLast().drawCard(players[0]);
            System.out.println(" Spiller 1:" + players[0].getMoney());
            choiceCards.lastItemToFront();
        }

    }
    }