import Controllers.GameBoard;
import org.junit.jupiter.api.Test;

import Player.*;
import Fields.*;
import ViewLayer.*;

class GameBoardTest {

    @Test
    void playerSpecificCardChoice() {
        GameBoard gameBoard = new GameBoard();
        Player[] players = new Player[]{new Player("test"), new Player("test1")};
        FieldsOnBoard f1 = new FieldsOnBoard();
        Field[] myFields = f1.getFieldArr();
        FieldChance fieldChance= new FieldChance();
        UIController uiController = new UIController(players ,myFields);
        //changeFieldOwner(myFields, 24);
        //gameBoard.playerSpecificCardChoice(uiController, myFields, players, 0);
        uiController.getGUI().getUserButtonPressed("test", "ok");
    }

    public void changeFieldOwner(Field[] fields, int length){
        for (int i = 0; i < length; i++) {
            if(fields[i] instanceof Properties){
                if(i % 2 == 0){
                    ((Properties) fields[i]).setOwnedBy(0);
                }
                else {
                    ((Properties) fields[i]).setOwnedBy(1);
                }
            }
        }
    }
}