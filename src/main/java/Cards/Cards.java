package Cards;
import Player.*;
import Fields.*;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import Player.Player;

public abstract class Cards
{

    private String cardText;
    private CardInfo info;
    private boolean drawAgain;


        public Cards (String text)
        {
            this.info = new CardInfo();

            this.cardText = text;
            this.drawAgain = false;
        }



    public String getCardText() {
        return cardText;
    }

    public void setDrawAgain(boolean input){
            this.drawAgain = input;
    }

    public boolean getDrawAgain(){return this.drawAgain;}

    public abstract void drawCard(Player player);


}
