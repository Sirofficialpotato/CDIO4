package Cards;
import Player.*;
import Fields.*;


public class GetOutOfJail extends Cards
{
    public GetOutOfJail(String text, int index)
    {
        super(text,index);
    }


    @Override
    public void drawCard(Player[] players, int player, Field[] fields, int choice)
    {
        players[player].getCardArray().add(this);
        players[player].setJailCard(true);
    }
}
