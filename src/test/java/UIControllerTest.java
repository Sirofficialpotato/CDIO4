import ViewLayer.UIController;
import gui_fields.GUI_Player;
import gui_main.GUI;
import org.junit.jupiter.api.Test;
import Cards.*;
import Fields.*;
import ViewLayer.*;
import Player.*;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UIControllerTest {

    @Test
    void UIFieldGen() {
        Field[] myFields = new Field[24];
        FieldsOnBoard f1 = new FieldsOnBoard();
        myFields = f1.getFieldArr();
        Player[] players = {new Player("test1"), new Player("test2"), new Player("test3"), new Player("test4")};
        UIController myControl = new UIController(players);

        myControl.getGUI().showMessage("UIFieldGen virker");
        myControl.getGUI().close();
    }

    @Test
    void updateGuiPlayerPos(){
        Field[] myFields = new Field[24];
        FieldsOnBoard f1 = new FieldsOnBoard();
        myFields = f1.getFieldArr();
        Player[] players = {new Player("test1"), new Player("test2"), new Player("test3"), new Player("test4")};
        UIController myControl = new UIController(players, myFields);
        for (int i = 0; i < players.length; i++) {
            myControl.getGUI().addPlayer(myControl.UIPlayerGen(players)[i]);
        }
        myControl.getGUI().getUserButtonPressed( "Click a button",
                "Button 1", "Button 2");
        for (int i = 0; i < players.length; i++) {
            myControl.updateGUIPlayerPos(players[i], 0, 5);
        }
        myControl.getGUI().getUserButtonPressed( "Click a button",
                "Button 1", "Button 2");
        myControl.updateGUIPlayerPos(players[0],5, 7);
        myControl.updateGUIPlayerPos(players[1],5, 8);
        myControl.updateGUIPlayerPos(players[2],5, 10);
        myControl.updateGUIPlayerPos(players[3],5, 11);
        myControl.getGUI().getUserButtonPressed( "Click a button",
                "Button 1", "Button 2");
    }

    @Test
    void updateGUIFieldOwner(){
        Field[] myFields = new Field[40];
        FieldsOnBoard f1 = new FieldsOnBoard();
        myFields = f1.getFieldArr();
        Player[] players = {new Player("test1"), new Player("test2"), new Player("test3"), new Player("test4")};
        UIController myControl = new UIController(players, myFields);
        ((Properties)myFields[1]).setOwnedBy(1);
        myControl.updateGUIFieldOwner(players, myFields, 1);
        String[] test = new String[]{"hej", "test"};
        myControl.getGUI().getUserButtonPressed("hej", test);
    }
}