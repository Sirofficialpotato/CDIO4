package Cards;
import Fields.*;
import Cards.*;
import Player.*;
import java.util.Scanner;


import Player.Player;

import java.util.Scanner;

public class PriceIncrease extends Cards
{
    private int value, value1;
    public PriceIncrease(String text, int value, int value1)
    {
        super(text);
        this.value = value;
        this.value1 = value1;
    }

    @Override
    //Updates the playerPosition **** not sure if it should use landOnField method on new field as well
    public void drawCard(Player player)
    {
        int totalValue = 0;
        for (int i = 0; i < player.getPlayerOwnedFields().size; i++) {
            if(i < 5){
                if(player.getPlayerOwnedFields().current > 0) {
                    totalValue += player.getPlayerOwnedFields().atIndex(i) * value;
                }
            }
            else{
                totalValue += value1;
            }
        }
        player.setMoney(-totalValue);
    }

}





