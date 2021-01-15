package Fields;

import Player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertiesTest {

    @Test
    void landOnField() {
        Player[] players = new Player[]{new Player("test"),new Player("test"),new Player("test")};
        players[0].setMoney(20000);
        Field[] fields = new Field[40];
        FieldsOnBoard f1 = new FieldsOnBoard();
        fields = f1.getFieldArr();
        players[1].setMoney(20000);

        //Test with first group
        ((Properties)fields[1]).setOwnedBy(0);
        ((Properties)fields[3]).setOwnedBy(1);
        players[0].setPosition(3);
        ((Properties)fields[3]).landOnField(players, 0, fields, true);
        assertEquals(19700,players[0].getMoney());
        assertEquals(20300,players[1].getMoney());

        //test with most last group
        ((Properties)fields[21]).setOwnedBy(0);
        ((Properties)fields[23]).setOwnedBy(0);
        players[1].setSpecificPosition(23);
        ((Properties)fields[23]).landOnField(players, 1, fields, true);
        assertEquals(20800,players[0].getMoney());
        assertEquals(19200,players[1].getMoney());

        assertEquals(-1, ((Properties)fields[6]).getOwnedBy());
        players[2].setSpecificPosition(6);
        ((Properties)fields[6]).landOnField(players, 2, fields, true);
        assertEquals(2, ((Properties)fields[6]).getOwnedBy());
        //
//       for (int i = 1; i <= 23; i++) {
//           if (i % 3 == 0 )
//            {
//                continue;
//           }

//            System.out.println(((Properties) fields[i]).getOwnedBy());
//        }

        //System.out.println(((Properties)fields[2]).getTotalPropertyValue(players, 2, fields));


    }
}