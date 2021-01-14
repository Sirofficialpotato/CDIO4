import org.junit.jupiter.api.Test;
import Fields.*;

import static org.junit.jupiter.api.Assertions.*;

class PropertyControllerTest {

    @Test
    void getBuyingPosibillites() {
        GameBoard gb = new GameBoard();
        PropertyController pc = new PropertyController(gb.getFields());
        Field[] returnedFields;
        ((Properties)gb.getFields()[1]).setOwnedBy(1);
        ((Properties)gb.getFields()[3]).setOwnedBy(1);
        returnedFields = pc.getBuyingPosibillites(1);
        assertEquals(2,returnedFields.length);

    }

    @Test
    void getPawningPossibilites() {
        GameBoard gb = new GameBoard();
        PropertyController pc = new PropertyController(gb.getFields());
        Field[] returnedFields;
        ((Properties)gb.getFields()[1]).setOwnedBy(1);
        ((Properties)gb.getFields()[3]).setOwnedBy(1);
        ((Properties)gb.getFields()[3]).setBuildOn(1);
        returnedFields = pc.getPawningPossibilites(1);
        assertEquals(1,returnedFields.length);
    }

    @Test
    void getSellingPossibilities() {
        GameBoard gb = new GameBoard();
        PropertyController pc = new PropertyController(gb.getFields());
        Field[] returnedFields;
        ((Properties)gb.getFields()[1]).setOwnedBy(1);
        ((Properties)gb.getFields()[3]).setOwnedBy(1);
        ((Properties)gb.getFields()[3]).setBuildOn(1);
        returnedFields = pc.getSellingPossibilities(1);
        assertEquals(1,returnedFields.length);
    }
}