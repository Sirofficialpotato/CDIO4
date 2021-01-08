package Cards;
import Player.*;
import Fields.*;


public class JailInteractions extends Cards
{
    public JailInteractions(String text, int index)
    {
        super(text);
    }


    @Override
    public void drawCard(Player player)
    {
       player.getCardArray().add(this);
       player.setJailCard(true);
    }
}
