package Fields;

import Player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertiesTest {

    @Test
    void landOnField() {
        Player[] players = new Player[]{new Player("test"),new Player("test"),new Player("test")};
        players[0].setMoney(20);
        Field[] fields = new Field[24];
        FieldsOnBoard f1 = new FieldsOnBoard();
        fields = f1.getFieldArr();
        players[1].setMoney(20);

        //Test with first group
        ((Properties)fields[1]).setOwnedBy(0);
        ((Properties)fields[2]).setOwnedBy(1);
        players[0].setPosition(2);
        ((Properties)fields[2]).landOnField(players, 0, fields);
        assertEquals(19,players[0].getMoney());
        assertEquals(21,players[1].getMoney());

        //test with most last group
        ((Properties)fields[22]).setOwnedBy(0);
        ((Properties)fields[23]).setOwnedBy(0);
        players[1].setSpecificPosition(23);
        ((Properties)fields[23]).landOnField(players, 1, fields);
        assertEquals(29,players[0].getMoney());
        assertEquals(11,players[1].getMoney());

        assertEquals(-1, ((Properties)fields[5]).getOwnedBy());
        players[2].setSpecificPosition(5);
        ((Properties)fields[5]).landOnField(players, 2, fields);
        assertEquals(2, ((Properties)fields[5]).getOwnedBy());
        //
//       for (int i = 1; i <= 23; i++) {
//           if (i % 3 == 0 )
//            {
//                continue;
//           }

//            System.out.println(((Properties) fields[i]).getOwnedBy());
//        }

        System.out.println(((Properties)fields[2]).getTotalPropertyValue(players, 2, fields));


    }
}