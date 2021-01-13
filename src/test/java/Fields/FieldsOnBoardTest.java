package Fields;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldsOnBoardTest {

    @Test
    void testToString() {
        FieldsOnBoard f1 = new FieldsOnBoard();
        System.out.println(f1.toString());
    }
}