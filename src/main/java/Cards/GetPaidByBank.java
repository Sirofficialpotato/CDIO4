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

    public void drawCard(Player player, Field[] fields){
        if(player.getPlayerAssets(fields) + player.getMoney() < 15000){
            player.setMoney(40000);
        }
    }

    public int getValue(){
        return this.value;
    }
}
