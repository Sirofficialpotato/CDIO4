package Cards;

import Controllers.GameBoard;
import Fields.Field;
import Fields.FieldsOnBoard;
import Player.Player;
import org.junit.jupiter.api.Test;

class SpecificFieldTest {

    @Test
    void drawCard() {
        Player[] players = new Player[]{new Player("test1"), new Player("test2"), new Player("test3"), new Player("test4")};
        GameBoard f1 = new GameBoard();
        FieldsOnBoard f3 = new FieldsOnBoard();
        Field[] f2 = f3.getFieldArr();
        players[0].setMoney(10);
        players[1].setMoney(10);
        players[0].setPosition(12);
        DynamicArr<MoveToField> choiceCards = new DynamicArr<MoveToField>();
        //MoveToField MoveCard = new MoveToField("Ryk felt: Ryk frem til START", 0, false);
        int choiceCounter = 0;
        for (int i = 0; i < f1.getCards().size; i++) {
            if (f1.getCards().getLast() instanceof MoveToField) {
                choiceCards.add((MoveToField) f1.getCards().getLast());
            }
            f1.getCards().lastItemToFront();
        }
        for (int i = 0; i < choiceCards.size; i++) {
            System.out.println("Before moving Player 0's pos:" + players[0].getPosition() + " ");
            //System.out.print(MoveCard.getCardText());
            choiceCards.getLast().drawCard(players[0]);
            //MoveCard.drawCard(players[0]);
            System.out.println("After moving Player 0's pos:" + players[0].getPosition() + " ");
            choiceCards.getLast().drawCard(players[0]);
            System.out.println("Player1 money:" + players[0].getMoney() + " Player2 money:" + players[1].getMoney());
            choiceCards.lastItemToFront();

        }

    }
}
