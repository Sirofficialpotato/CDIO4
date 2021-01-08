package Cards;
import Player.*;
import Fields.*;
import java.util.Scanner;


public class MoveToField extends Cards
{
    int value;
     boolean relative;
    public MoveToField(String text, int value, boolean relative)
    {
        super(text);
        this.value = value;
        this.relative = relative;
    }

    @Override
    public void drawCard(Player player)
    {
        if(this.relative == true){
            player.setPosition(this.value);
        }
        else{
            player.setSpecificPosition(this.value);
        }

        if(this.value == 404){
            //Move to shipping
        }

    }
}
