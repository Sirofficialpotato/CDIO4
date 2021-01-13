package Cards;

import Fields.Field;
import Fields.FieldChance;
import Fields.FieldsOnBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import Player.*;

class ChooseToMoveTest {

    @Test
    void drawCard() {
        Field[] fields = new Field[24];
        FieldsOnBoard f1 = new FieldsOnBoard();
        fields = f1.getFieldArr();
        DynamicArr<PriceIncrease> choiceCards = new DynamicArr<PriceIncrease>();
        Player[] players = new Player[]{new Player("test1"), new Player("test2"), new Player("test3"), new Player("test4"), new Player("test5")};
        int choiceCounter = 0;
        for (int i = 0; i < ((FieldChance)fields[3]).getCards().size; i++) {
            if(((FieldChance)fields[3]).getCards().getLast() instanceof PriceIncrease){
                choiceCards.add((PriceIncrease) ((FieldChance)fields[3]).getCards().getLast());
            }
            ((FieldChance)fields[3]).getCards().lastItemToFront();
        }
        //test for kort 3 "Ryk op til 5 felter frem"
        for (int i = 0; i < 5; i++) {
            choiceCards.getLast().drawCard(players[i]);
            assertEquals(i+1, players[i].getPosition());
        }
        choiceCards.lastItemToFront();

        //Test for kort 4 "Vælg orange felt" (Skatepark: position 10 og swimmingpool: position 11)
        choiceCards.getLast().drawCard(players[0]);
        assertEquals(10, players[0].getPosition());
        choiceCards.getLast().drawCard(players[1]);
        assertEquals(11,players[0].getPosition());
        choiceCards.lastItemToFront();

        //Tester for kort 5 "Ryk et felt frem eller tag et chancekort"
        players[0].setSpecificPosition(4);
        choiceCards.getLast().drawCard(players[0]);
        assertEquals(true, choiceCards.getLast().getDrawAgain());
        choiceCards.getLast().drawCard(players[1]);
        assertEquals(5, players[0].getPosition());
        assertEquals(false, choiceCards.getLast().getDrawAgain());
        choiceCards.lastItemToFront();

        //Tester for kort 8: "Vælg orange eller grøn". Skatepark, swimmingpool(orange). Bowling, Zoo(Green)
        players[0].setSpecificPosition(3);
        choiceCards.getLast().drawCard(players[0]);
        assertEquals(10, players[0].getPosition());
        players[0].setSpecificPosition(3);
        choiceCards.getLast().drawCard(players[1]);
        assertEquals(11, players[0].getPosition());
        players[0].setSpecificPosition(3);
        choiceCards.getLast().drawCard(players[2]);
        assertEquals(19, players[0].getPosition());
        players[0].setSpecificPosition(3);
        choiceCards.getLast().drawCard(players[3]);
        assertEquals(20, players[0].getPosition());
        choiceCards.lastItemToFront();

        //Tester for kort 9: "Vælg lyseblot felt". Godtebutik eller isbod
        players[0].setSpecificPosition(3);
        choiceCards.getLast().drawCard(players[0]);
        assertEquals(4, players[0].getPosition());
        players[0].setSpecificPosition(3);
        choiceCards.getLast().drawCard(players[1]);
        assertEquals(5, players[0].getPosition());
        players[0].setSpecificPosition(3);
        choiceCards.lastItemToFront();

        //Test for kort 15: "Vælg lilla eller mørkeblå"
        players[0].setSpecificPosition(3);
        choiceCards.getLast().drawCard(players[0]);
        assertEquals(7, players[0].getPosition());
        players[0].setSpecificPosition(3);
        choiceCards.getLast().drawCard(players[1]);
        assertEquals(8, players[0].getPosition());
        players[0].setSpecificPosition(3);
        choiceCards.getLast().drawCard(players[2]);
        assertEquals(22, players[0].getPosition());
        players[0].setSpecificPosition(3);
        choiceCards.getLast().drawCard(players[3]);
        assertEquals(23, players[0].getPosition());
        choiceCards.lastItemToFront();

        //test for kort 17: "Vælg rødt felt": Spillehal eller biograf
        players[0].setSpecificPosition(3);
        choiceCards.getLast().drawCard(players[0]);
        assertEquals(13, players[0].getPosition());
        players[0].setSpecificPosition(3);
        choiceCards.getLast().drawCard(players[1]);
        assertEquals(14, players[0].getPosition());
        players[0].setSpecificPosition(3);
        choiceCards.lastItemToFront();

        //Test for kort 19: "Vælg Rødt eller lyseblåt felt": Spillehal, biograt(Rød). Godtebutik, iskiosk(Lyseblå)
        players[0].setSpecificPosition(3);
        choiceCards.getLast().drawCard(players[0]);
        assertEquals(4, players[0].getPosition());
        players[0].setSpecificPosition(3);
        choiceCards.getLast().drawCard(players[1]);
        assertEquals(5, players[0].getPosition());
        players[0].setSpecificPosition(3);
        choiceCards.getLast().drawCard(players[2]);
        assertEquals(13, players[0].getPosition());
        players[0].setSpecificPosition(3);
        choiceCards.getLast().drawCard(players[3]);
        assertEquals(14, players[0].getPosition());
        choiceCards.lastItemToFront();

        //Test for kort 20: "Vælgt gråt eller gult"
        players[0].setSpecificPosition(3);
        choiceCards.getLast().drawCard(players[0]);
        assertEquals(1, players[0].getPosition());
        players[0].setSpecificPosition(3);
        choiceCards.getLast().drawCard(players[1]);
        assertEquals(2, players[0].getPosition());
        players[0].setSpecificPosition(3);
        choiceCards.getLast().drawCard(players[2]);
        assertEquals(16, players[0].getPosition());
        players[0].setSpecificPosition(3);
        choiceCards.getLast().drawCard(players[3]);
        assertEquals(17, players[0].getPosition());



    }
}