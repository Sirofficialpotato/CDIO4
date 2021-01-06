package Cards;
import Player.*;
import Fields.*;

public class GetPaidOrPay extends Cards
{
    public GetPaidOrPay(String text, int index)
    {
        super(text, index);
    }

    @Override
    public void drawCard(Player[] players, int player, Field[] fields, int choice)
    {
        switch (this.getCardText().substring(0, 2)){
            //case for fødselsdagskort
            case("14"):
                for (int i = 0; i < players.length; i++) {
                    if(i != player){
                        players[i].setMoney(-1);
                    }
                }
                players[player].setMoney(players.length-1);
                break;
            //case for modtag 2M fra bank
            case("16"):
                players[player].setMoney(2);
                break;
            case("7:"):
                players[player].setMoney(-2);
                break;

        }
    }
}
