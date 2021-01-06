package Cards;
import Player.*;
import Fields.*;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import Player.Player;

public abstract class Cards
{
    private int cardIndex;
    private String cardText;
    private CardInfo info;
    private boolean drawAgain;


        public Cards (String text, int index)
        {
            this.info = new CardInfo();
            this.cardIndex = index;
            this.cardText = text;
            this.drawAgain = false;
        }

    public int getCardIndex() {
        return cardIndex;
    }

    public String getCardText() {
        return cardText;
    }

    public void setDrawAgain(boolean input){
            this.drawAgain = input;
    }

    public boolean getDrawAgain(){return this.drawAgain;}

    public abstract void drawCard(Player[] players, int player, Field[] fields, int choice);


}
