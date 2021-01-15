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
        if(this.value == 404){
            int temp;
            temp = (player.getPosition()/10)*10;
            if (player.getPosition() - temp < 5){
                player.setSpecificPosition(temp + 5);
            }
            else if(temp == 30){
                if(player.getPosition() - temp < 5) {
                    player.setSpecificPosition(35);
                }
                else{
                    player.setSpecificPosition(5);
                }
            }
            else{
                player.setSpecificPosition(temp + 15);
            }

        }
        if(this.value!=404) {
            if (this.relative == true) {
                player.setPosition(this.value);
            } else {
                player.setSpecificPosition(this.value);
            }

        }

    }
}
