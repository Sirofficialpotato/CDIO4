import Controllers.GameBoard;
import Controllers.PropertyController;
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
        ((Properties)gb.getFields()[3]).setOwnedBy(0);
        returnedFields = pc.getBuyingPosibillites(1);
        assertEquals(0,returnedFields.length);

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
        assertEquals(0,returnedFields.length);
        ((Properties)gb.getFields()[3]).setBuildOn(0);
        returnedFields = pc.getPawningPossibilites(1);
        assertEquals(2,returnedFields.length);
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
        ((Properties)gb.getFields()[1]).setBuildOn(1);
        returnedFields = pc.getSellingPossibilities(1);
        assertEquals(2,returnedFields.length);
    }

    @Test
    void EvenBuildingDist(){
        GameBoard gb = new GameBoard();
        PropertyController pc = new PropertyController(gb.getFields());
        //Two field group test
        ((Properties)gb.getFields()[1]).setOwnedBy(1);
        ((Properties)gb.getFields()[3]).setOwnedBy(1);
        ((Properties)gb.getFields()[1]).setBuildOn(2);
        ((Properties)gb.getFields()[3]).setBuildOn(1);
        assertTrue(pc.isBuildingDistEvenForBuy((Properties) gb.getFields()[3]));
        //three field group test
        ((Properties)gb.getFields()[6]).setOwnedBy(1);
        ((Properties)gb.getFields()[8]).setOwnedBy(1);
        ((Properties)gb.getFields()[9]).setOwnedBy(1);

        ((Properties)gb.getFields()[6]).setBuildOn(3);
        ((Properties)gb.getFields()[8]).setBuildOn(3);
        ((Properties)gb.getFields()[9]).setBuildOn(4);
        assertTrue(pc.isBuildingDistEvenForBuy((Properties) gb.getFields()[8]));
        assertTrue(!pc.isBuildingDistEvenForBuy((Properties) gb.getFields()[9]));
    }
}