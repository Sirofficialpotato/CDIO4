import Cards.Cards;
import Cards.GetOutOfJail;
import Cards.PlayerSpecific;
import Fields.*;
import Player.Player;
import ViewLayer.UIController;
import Cards.*;


import java.awt.*;
import java.util.Arrays;


//**************************************************!!!Thoughts!!!******************************************************
// TODO: 26-11-2020  - Maybe make it so you can see who pays to whom i.e. Jens pays 1M to Mads to stay overnight.
// TODO: 26-11-2020  - Divide gameboard into several methods? see possibly places with many ****
// TODO: 26-11-2020  - Optimize the entire gameboard ??
//**********************************************************************************************************************


public class GameBoard {

    private FieldsOnBoard f1;
    private Field[] myFields;
    private String[] currentLang;
    FieldChance fieldChance;



    public GameBoard(){
        f1 = new FieldsOnBoard();
        myFields = f1.getFieldArr();
        fieldChance = (FieldChance) myFields[3];
        fieldChance.mixCards();
        Language langSelector = new Language("dk");
        currentLang = langSelector.returnLang();
    }

    public Field[] getFields(){
        return this.myFields;
    }

}
