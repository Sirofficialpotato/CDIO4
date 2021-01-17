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

    public void landOnField(Player[] players, int player, Field[] fields, DynamicArr<Cards> cards ) {
        Cards currentCard = cards.getLast();
        if (currentCard instanceof JailInteractions) {
            if (currentCard.getCardText().equals("I anledning af kongens fødselsdag benådes De herved for fængsel. Dette kort kan opbevares indtil De får brug for det, eller De kan sælge det.")) {
                cards.removeLast();
                players[player].addJailCard((JailInteractions) currentCard);
                players[player].setJailCard(true);
            } else {
                players[player].setInJail(true);
                players[player].setSpecificPosition(10);
            }
        } else if (currentCard instanceof GetPaidByPlayers) {
            ((GetPaidByPlayers) currentCard).drawCard(players, player);
            cards.lastItemToFront();
        } else if (currentCard instanceof MoveToField) {
            currentCard.drawCard(players[player]);
            cards.lastItemToFront();
        }
        else if(currentCard instanceof PayTheBank) {
            currentCard.drawCard(players[player]);
            cards.lastItemToFront();
        }
        else if(currentCard instanceof GetPaidByBank){
            if(((GetPaidByBank)currentCard).getValue() == 40000){
                ((GetPaidByBank)currentCard).drawCard(players[player], fields);
                cards.lastItemToFront();
            }
            else {
                currentCard.drawCard(players[player]);
                cards.lastItemToFront();
            }
        }
        else if(currentCard instanceof PriceIncrease){
            ((PriceIncrease)currentCard).drawCard(players[player], fields);
            cards.lastItemToFront();
        }
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
