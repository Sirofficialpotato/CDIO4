package Cards;
import Player.*;
import Fields.*;

public class PlayerSpecific extends Cards
{
    public PlayerSpecific(String text, int index)
    {
        super(text,index);
        this.setDrawAgain(true);
    }

    @Override
    public void drawCard(Player[] players, int player, Field[] fields, int choice)
    {
        switch (this.getCardText().substring(0,2)){
            //Bilkort
            case("1:"):
                players[0].getCardArray().add(this);
                break;
            //Skibskort
            case("6:"):
                players[1].getCardArray().add(this);
                break;
            //Kattekort
            case("12"):
                if (2 >= players.length)
                {
                    break;
                }
                players[2].getCardArray().add(this);
                break;
            //Hundekort
            case("13"):
                if (3 >= players.length)
                {
                    break;
                }
                players[3].getCardArray().add(this);
                break;

        }

    }
}
