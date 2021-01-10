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
        for (Integer i:
             player.getPlayerOwnedFields().getArr()[1]) {
            if(i < 5){
                totalValue += i * value;
            }
            else{
                totalValue += value1;
            }
        }
        player.setMoney(-totalValue);
    }

}





