import Cards.*;
import Fields.Field;
import Fields.FieldChance;
import Fields.FieldShipYard;
import Fields.FieldsOnBoard;

import java.util.Random;





public class GameBoard {

    private FieldsOnBoard f1;
    private Field[] myFields;
    private String[] currentLang;
    FieldChance fieldChance;
    private DynamicArr<Cards> cards = new DynamicArr<Cards>();
    private CardInfo info = new CardInfo();



    public GameBoard(){
        f1 = new FieldsOnBoard();
        myFields = f1.getFieldArr();
        Language langSelector = new Language("dk");
        currentLang = langSelector.returnLang();
        generateChanceCards(true);
        mixCards();


    }

    public Field[] getFields(){
        return this.myFields;
    }

    //Method that generates a set of cards from cardInfo
    //Get out of jail card excluded parameter is false
    public void generateChanceCards(boolean jail){
        String temp;
        //Counters to keep track of index in the 2d array
        int valueCounter = 0, value1Counter = 0, relativeCounter = 0;
        for (int i = 0; i < info.getCardInfo()[0].length; i++) {
            temp = (String)info.getCardInfo()[0][i];
            if(temp.substring(0, 8).equals("Ryk felt")){
                cards.add(new MoveToField(((String)info.getCardInfo()[0][i]).substring(10), (int) info.getCardInfo()[1][valueCounter++],(boolean) info.getCardInfo()[3][relativeCounter++]));
            }
            else if(temp.substring(0,13).equals("Priser stiger")){
                cards.add(new PriceIncrease(((String)info.getCardInfo()[0][i]).substring(15),(int) info.getCardInfo()[1][valueCounter++], (int)info.getCardInfo()[2][value1Counter++]));
            }
            else if(temp.substring(0,17).equals("Noget med fængsel")){
                cards.add(new JailInteractions(((String)info.getCardInfo()[0][i]).substring(19),0));
            }
            else if(temp.substring(0, 12).equals("Modtag penge")){
                cards.add(new GetPaidByBank(((String)info.getCardInfo()[0][i]).substring(14), (int) info.getCardInfo()[1][valueCounter++]));
            }

            else if(temp.substring(0, 21).equals("Få penge fra spillere")){
                cards.add(new GetPaidByPlayers(((String)info.getCardInfo()[0][i]).substring(23), (int) info.getCardInfo()[1][valueCounter++]));
            }
            else if(temp.substring(0, 22).equals("Betal penge til banken")){
                cards.add(new PayTheBank(((String)info.getCardInfo()[0][i]).substring(24), (int) info.getCardInfo()[1][valueCounter++]));
            }
        }

    }
    //Mixes the chance cards
    public void mixCards(){
        Cards[] tempArr = new Cards[this.cards.size];
        Random ran = new Random();
        int counter = 0;
        while(this.cards.size > 0){
            int random = ran.nextInt(this.cards.size);
            tempArr[counter]=cards.atIndex(random);
            cards.removeAt(random);
            counter++;
        }
        for (int i = 0; i < tempArr.length; i++) {
            cards.add(tempArr[i]);
        }
    }

    public DynamicArr<Cards> getCards(){
        return this.cards;
    }

}
