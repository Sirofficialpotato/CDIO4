import static org.junit.jupiter.api.Assertions.*;
import Fields.*;
import org.junit.jupiter.api.Test;

class PropertyControllerTest {
//6, 8 , 9
    @Test
    void constructTest(){
       FieldsOnBoard f1 = new FieldsOnBoard();
       PropertyController controller = new PropertyController(f1.getFieldArr());
       //Changing the owner for group 1 to test functionality
       ((Properties)controller.getFields()[1]).setOwnedBy(1);
        ((Properties)controller.getFields()[3]).setOwnedBy(1);
        ((Properties)controller.getFields()[9]).setOwnedBy(1);
        //used to generate posibillities
       //Used the get the generated posibillities
       Field[] tester = controller.getPosibillites(2);
       int i = 0;
    }


}