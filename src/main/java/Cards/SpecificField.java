package Cards;
import Player.*;
import Fields.*;
import java.util.Scanner;


public class SpecificField extends Cards
{
    public SpecificField(String text, int index)
    {
        super(text, index);
    }

    @Override
    public void drawCard(Player[] players, int player, Field[] fields, int choice)
    {
        /* Se CardInfo for beskrivelse af forskellige cases */
        switch(this.getCardText().substring(0, 2))
        {
            //Gå til start kort
            case("2:"):
                players[player].setSpecificPosition(0);
                break;

            //Gå til strandpromenaden
            case("11"):
                Properties p1 = ((Properties)fields[23]);
                players[player].setSpecificPosition(23);
                p1.landOnField(players, player, fields);
                break;
            //Gå til skateparken
            case("18"):
                Properties p2 = ((Properties)fields[10]);
                players[player].setSpecificPosition(10);
                if(p2.getOwnedBy() == -1){
                    players[player].setMoney(p2.getPrice());

                }
                p2.landOnField(players, player, fields);
                break;

        }
    }
}
