package Cards;
import Fields.Field;
import Fields.FieldChance;
import Fields.FieldsOnBoard;
import Player.Player;
import ViewLayer.UIController;
import org.junit.jupiter.api.Test;

class CardsTest {

    @Test
    void getCardIndex() {
    }

    @Test
    void getCardText() {
    }

    @Test
    void setDrawAgain() {
    }

    @Test
    void drawCard() {
        FieldsOnBoard f1 = new FieldsOnBoard();
        Field[] myFields = f1.getFieldArr();
        Player[] players = new Player[]{new Player("test1"), new Player("test2"), new Player("test3"), new Player("test4")};
        UIController uiController = new UIController(players, myFields);
        String stop = "";

        for (int i = 0; i < players.length; i++) {
            uiController.getGUI().addPlayer(uiController.UIPlayerGen(players)[i]);
        }

        while(!stop.equals("stop")){
            stop = uiController.getGUI().getUserButtonPressed("asd", "ok", "stop");
            for (int i = 0; i < players.length; i++) {
                players[i].setSpecificPosition(3);
                uiController.getGUI().getFields()[players[i].getOldposition()].setCar(uiController.getGuiPlayer(i), false);
                uiController.getGUI().getFields()[players[i].getPosition()].setCar(uiController.getGuiPlayer(i), true);
                if(players[i].getPosition() == 3 || players[i].getPosition() == 9 || players[i].getPosition() == 15 || players[i].getPosition() == 21){
                    int input = uiController.getGuiInput(((FieldChance)myFields[3]).nextCard());
                    uiController.getGUI().displayChanceCard(((FieldChance)myFields[3]).nextCard().getCardText());
                    ((FieldChance) myFields[3]).landOnField(players[0]);
                    uiController.getGuiPlayer(i).setBalance(players[i].getMoney());
                    uiController.updateGUIPlayerPos(players[i], players[i].getOldposition() , players[i].getPosition());
                }
            }

        }


    }
}