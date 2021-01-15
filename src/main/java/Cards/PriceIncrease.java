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

    }

    public void drawCard(Player player, Field[] fields){
        int totalValue = 0;
        if(player.getPlayerOwnedFields().current > 0) {
            for (int i = 0; i < player.getPlayerOwnedFields().size; i++) {
                if (fields[player.getPlayerOwnedFields().atIndex(i)] instanceof Properties) {
                    if (((Properties) fields[player.getPlayerOwnedFields().atIndex(i)]).getBuildOn() < 5 && ((Properties) fields[player.getPlayerOwnedFields().atIndex(i)]).getBuildOn() > 0) {
                        totalValue += ((Properties) fields[player.getPlayerOwnedFields().atIndex(i)]).getBuildOn() * value;
                    } else if (((Properties) fields[player.getPlayerOwnedFields().atIndex(i)]).getBuildOn() == 5) {
                        totalValue += value1;
                    }
                }
            }
        }
        player.setMoney(-totalValue);
    }

}





