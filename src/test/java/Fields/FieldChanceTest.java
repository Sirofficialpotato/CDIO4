package Fields;
import Cards.*;
import Controllers.GameBoard;
import Player.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldChanceTest {

    @Test
    void landOnField() {
    }

    @Test
    void takeChanceCard() {
        Player[] p1 = {new Player("test1"),  new Player("test2"),  new Player("test3"), new Player("test4")};
        FieldsOnBoard fieldCreator = new FieldsOnBoard();
        Field[] fields = fieldCreator.getFieldArr();
        GameBoard f1 = new GameBoard();
        //f1.mixCards();
        for (int i = 0; i < 100; i++) {
            System.out.println(f1.getCards().size + ": " + f1.getCards().atIndex(f1.getCards().size-1).getCardText());
            f1.getCards().getLast().drawCard(p1[0]);
            f1.getCards().lastItemToFront();

        }
    }

    @Test
    void generateChanceCards() {
        GameBoard f1 = new GameBoard();
        //f1.generateChanceCards(false);
        for (int i = 0; i < f1.getCards().size; i++) {
            System.out.println(f1.getCards().atIndex(i).getCardText());
        }
        //f1.mixCards();
        for (int i = 0; i < f1.getCards().size; i++) {
            System.out.println(f1.getCards().atIndex(i).getCardText());
        }
    }

}