package Fields;
import Player.*;
import Cards.*;

import java.util.Random;

public class FieldChance extends Field {

    private DynamicArr<Cards> cards = new DynamicArr<Cards>();
    private CardInfo info = new CardInfo();

    public FieldChance(){
        super("?", "Tag et chancekort");
    }

    public void landOnField(Player[] players, int player){

    }

    public void landOnField(Player player) {

        takeChanceCard(player);
    }

    public void takeChanceCard(Player player){
        cards.getLast().drawCard(player);
        //Checks if chance card is getOutOfJail and removes it from stack of cards if so
        if(cards.getLast() instanceof JailInteractions || cards.getLast() instanceof PayTheBank){
            cards.removeAt(cards.size-1);
        }
        else{cards.lastItemToFront();
        }
    }


    public Cards nextCard(){return this.cards.getLast();}

    public DynamicArr<Cards> getCards(){
        return this.cards;
    }
}
