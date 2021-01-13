package Cards;
import Player.*;
import Fields.*;

public class PayTheBank extends Cards
{
    int value;
    public PayTheBank(String text, int value)
    {
        super(text);
        this.value = value;
    }

    @Override
    public void drawCard(Player player)
    {
        player.setMoney(-value);

    }
}
