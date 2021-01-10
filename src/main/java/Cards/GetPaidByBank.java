package Cards;
import Player.*;
import Fields.*;

public class GetPaidByBank extends Cards
{
    int value;
    public GetPaidByBank(String text, int value)
    {
        super(text);
        this.value = value;
    }

    @Override
    public void drawCard(Player player)
    {
        player.setMoney(value);
    }
}
