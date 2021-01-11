package ViewLayer;

import Cards.Cards;
import Fields.*;
import Player.*;
import gui_fields.*;
import gui_main.GUI;
import javax.swing.BorderFactory;
import javax.swing.*;
import java.awt.*;


public class UIController {
    private GUI gui;
    private GUI_Player[] guiPlayers;
    // Constructer that automatically generates GUI with all the players
    public UIController(Field[] fields){
        Color BgColor = new Color(99, 90, 75);
        this.gui = new GUI(UIFieldGen(fields), BgColor);
    }

    public UIController(Player[] players, Field[] fields){
        this.gui = new GUI(UIFieldGen(fields));
        guiPlayers = new GUI_Player[players.length];
        guiPlayers = this.UIPlayerGen(players);
    }
   //Generates GUI_Player array from logic player array
   public GUI_Player[] UIPlayerGen(Player[] players){
       GUI_Player[] guiPlayers = new GUI_Player[players.length];
       for (int i = 0; i < players.length; i++) {
           guiPlayers[i] = new GUI_Player(players[i].getName(), players[i].getMoney());
       }
        return guiPlayers;
   }
   public UIController(Player[] players){
        this.gui = new GUI();
        guiPlayers = new GUI_Player[players.length];
        guiPlayers = this.UIPlayerGen(players);
   }

   public void addPlayers(Player[] players){
        guiPlayers = new GUI_Player[players.length];
        for (int i = 0; i < players.length; i++) {
            guiPlayers[i] = new GUI_Player(players[i].getName(), players[i].getMoney());
            this.gui.addPlayer(guiPlayers[i]);
        }
   }

    //Generates a GUI_Field array from a logic Field array
    public GUI_Field[] UIFieldGen(Field[] fieldArray){
        GUI_Field[] guiFields = new GUI_Field[fieldArray.length];
        for (int i = 0; i < fieldArray.length; i++) {

            if(fieldArray[i] instanceof FieldStart){
                guiFields[i] = new GUI_Start(((FieldStart) fieldArray[i]).getFieldName(), ((FieldStart) fieldArray[i]).getFieldDescription(), ((FieldStart) fieldArray[i]).getFieldDescription(), Color.white, Color.BLACK);
            }
            else if(fieldArray[i] instanceof FieldChance) {
                guiFields[i] = new GUI_Chance(((FieldChance) fieldArray[i]).getFieldName(), ((FieldChance) fieldArray[i]).getFieldDescription(), ((FieldChance) fieldArray[i]).getFieldDescription(), Color.WHITE, Color.BLACK);

            }
            else if(fieldArray[i] instanceof Jail) {
                guiFields[i] = new GUI_Jail( "default",((Jail) fieldArray[i]).getFieldName(), ((Jail) fieldArray[i]).getFieldDescription(), ((Jail) fieldArray[i]).getFieldDescription(), Color.RED, Color.BLACK);
            }
            else if(fieldArray[i] instanceof FieldShipYard){
                guiFields[i] = new GUI_Shipping("default", ((FieldShipYard) fieldArray[i]).getFieldName(),/*String.valueOf(((FieldShipYard) fieldArray[i]).getPrice())*/"M4000", ((FieldShipYard) fieldArray[i]).getFieldDescription(), String.valueOf(((FieldShipYard) fieldArray[i]).getRent()), Color.WHITE, Color.BLACK);
            }
            //String picture, String title, String subText, String description, String rent, Color bgColor, Color fgColor
            else if(fieldArray[i] instanceof Brewery){
                guiFields[i] = new GUI_Brewery("default", fieldArray[i].getFieldName(), fieldArray[i].getFieldDescription(), fieldArray[i].getFieldDescription(), "100/200 times roll", Color.RED, Color.BLACK);
            }
            //String title, String subText, String description, Color bgColor, Color fgColor
            else if(fieldArray[i] instanceof PayTax){
                guiFields[i] = new GUI_Tax(fieldArray[i].getFieldName(), fieldArray[i].getFieldDescription(), fieldArray[i].getFieldDescription(), Color.RED, Color.BLACK);
            }

            else if(fieldArray[i] instanceof Properties) {
                Color color, txtcolor;
                Color OrangeColor = new Color(207, 151, 23);
                txtcolor = Color.black;
                color = Color.red;

                if(((Properties)((Properties) fieldArray[i])).getFieldColor().equals("blå")){
                    color = Color.blue;
                    txtcolor = Color.white;
                }
                else if(((Properties)((Properties) fieldArray[i])).getFieldColor().equals("lilla")){
                    color = Color.magenta;
                }
                else if(((Properties)((Properties) fieldArray[i])).getFieldColor().equals("grå")){
                    color = Color.gray;
                }
                else if(((Properties)((Properties) fieldArray[i])).getFieldColor().equals("rød")){
                    color = Color.red;
                }
                else if(((Properties)((Properties) fieldArray[i])).getFieldColor().equals("gul")){
                    color = Color.yellow;
                }
                else if(((Properties)((Properties) fieldArray[i])).getFieldColor().equals("orange")){
                    color = OrangeColor;
                }
                else if(((Properties)((Properties) fieldArray[i])).getFieldColor().equals("lyseblå")){
                    color = Color.cyan;
                }
                else if(((Properties)((Properties) fieldArray[i])).getFieldColor().equals("grøn")){
                    color = Color.green;
                }
                else if(((Properties)((Properties) fieldArray[i])).getFieldColor().equals("hvid")){
                    color = Color.white;
                }
                else if(((Properties)((Properties) fieldArray[i])).getFieldColor().equals("pink")){
                    color = Color.PINK;
                }
                else if(((Properties)((Properties) fieldArray[i])).getFieldColor().equals("sort")){
                    color = Color.black;
                }

                guiFields[i] = new GUI_Street(((Properties) fieldArray[i]).getFieldName(), ((Properties) fieldArray[i]).getFieldDescription(), (fieldArray[i]).getFieldName(), String.valueOf(((Properties) fieldArray[i]).getPrice()), color, txtcolor);
            }
            else if(fieldArray[i] instanceof FieldInfo && ((FieldInfo)fieldArray[i]).getFieldName().equals("I fængsel")) {
                guiFields[i] = new GUI_Jail("default",((FieldInfo) fieldArray[i]).getFieldName(), ((FieldInfo) fieldArray[i]).getFieldDescription(), ((FieldInfo) fieldArray[i]).getFieldDescription(), Color.RED, Color.BLACK);
            }
            else if(fieldArray[i] instanceof FieldInfo && ((FieldInfo)fieldArray[i]).getFieldName().equals("Gratis")) {
                guiFields[i] = new GUI_Refuge("default",((FieldInfo) fieldArray[i]).getFieldName(), ((FieldInfo) fieldArray[i]).getFieldDescription(), ((FieldInfo) fieldArray[i]).getFieldDescription(), Color.WHITE, Color.BLACK);
            }

        }
        return guiFields;
    }
        //Updates GUI_Player according to corresponding Player
        public void updateGUIPlayerPos(Player player, int oldPosition,int newPosition){

            for (int i = 0; i < guiPlayers.length; i++) {
                if(guiPlayers[i].getName().equals(player.getName())){
                    gui.getFields()[oldPosition].setCar(guiPlayers[i], false);
                    gui.getFields()[newPosition].setCar(guiPlayers[i], true);

                }
            }

        }
        //Takes in a card and asks user for input if nessecary
        public int getGuiInput(Cards card){
            switch (card.getCardText().substring(0, 2)){
                case("3:"):
                    return this.gui.getUserInteger("Ryk 1 - 5 felter", 1, 5);
                case("4:"):
                    String choice = this.gui.getUserButtonPressed("Vælg dit felt", "Skaterparken", "Swimmingpoolen");
                    if(choice.equals("Skaterparken")){return 0;}
                    else{return 1;}
                case("5:"):
                    choice = this.gui.getUserButtonPressed("Hvad vælger du?", "1 felt frem", "1 chancekort");
                    if(choice.equals("1 chancekort")){return 0;}
                    else{return 1;}
                case("8:"):
                    choice = this.gui.getUserButtonPressed("Vælg dit felt", "Skaterparken", "Swimmingpoolen", "Bowlinghallen", "Zoologisk have");
                    if(choice.equals("Skaterparken")){return 0;}
                    else if(choice.equals("Swimmingpoolen")){return 1;}
                    else if(choice.equals("Bowlinghallen")){return 2;}
                    else{return 3;}
                case("9:"):
                    choice = this.gui.getUserButtonPressed("Vælg dit felt", "Godtebutikken", "Iskiosken");
                    if(choice.equals("Godtebutikken")){return 0;}
                    else{return 1;}
                case("15"):
                    choice = this.gui.getUserButtonPressed("Vælg dit felt", "Museet", "Biblioteket", "Vandlandet", "Strandpromenaden");
                    if(choice.equals("Museet")){return 0;}
                    else if(choice.equals("Biblioteket")){return 1;}
                    else if(choice.equals("Vandlandet")){return 2;}
                    else{return 3;}
                case("17"):
                    choice = this.gui.getUserButtonPressed("Vælg dit felt", "Spillehallen", "Biografen");
                    if(choice.equals("Spillehallen")){return 0;}
                    else{return 1;}
                case("19"):
                    choice = this.gui.getUserButtonPressed("Vælg dit felt", "Godtebutikken", "Iskiosken", "Spillehallen", "Biografen");
                    if(choice.equals("Godtebutikken")){return 0;}
                    else if(choice.equals("Iskiosken")){return 1;}
                    else if(choice.equals("Spillehallen")){return 2;}
                    else{return 3;}
                case("20"):
                    choice = this.gui.getUserButtonPressed("Vælg dit felt", "Burgerbar", "Pizzahus", "Lejetøjsbutikken", "Dyrehandlen");
                    if(choice.equals("Burgerbar")){return 0;}
                    else if(choice.equals("Pizzahus")){return 1;}
                    else if(choice.equals("Lejetøjsbutikken")){return 2;}
                    else{return 3;}
                default:
                    return -1;

            }
        }

        //Updates Owners of GUI fields, by referencing the name of the owner of logical fields
    public void updateGUIFieldOwner(Player[] players, Field[] fields, int field){
        if(field == 5 || field == 15 || field == 25 || field == 35) {
            if (((FieldShipYard) fields[field]).getOwnedBy() != -1) {
                ((GUI_Shipping) this.gui.getFields()[field]).setOwnerName(players[((FieldShipYard) fields[field]).getOwnedBy()].getName());
                ((GUI_Shipping) this.gui.getFields()[field]).setBorder(this.guiPlayers[((FieldShipYard) fields[field]).getOwnedBy()].getPrimaryColor());
                //((GUI_Shipping) this.gui.getFields()[field]).setRent("M500");
            }
        } else {
            if(((Properties)fields[field]).getOwnedBy() != -1) {
                ((GUI_Ownable) this.gui.getFields()[field]).setOwnerName(players[((Properties) fields[field]).getOwnedBy()].getName());
                ((GUI_Ownable) this.gui.getFields()[field]).setBorder(this.guiPlayers[((Properties)fields[field]).getOwnedBy()].getPrimaryColor());
            }
        }
    }
    public void removeGUIFieldOwner(Field[] fields, int field){
        if(field == 5 || field == 15 || field == 25 || field == 35) {
            if (((FieldShipYard) fields[field]).getOwnedBy() != -1) {
                ((GUI_Shipping) this.gui.getFields()[field]).setOwnerName(null);
                ((GUI_Shipping) this.gui.getFields()[field]).setBorder(Color.lightGray);
            }
        }
        else {
            if(((Properties)fields[field]).getOwnedBy() != -1) {
                ((GUI_Ownable) this.gui.getFields()[field]).setOwnerName(null);
                ((GUI_Ownable) this.gui.getFields()[field]).setBorder(Color.lightGray);
            }
        }
    }


    public GUI_Player getGuiPlayer(int playerNumber){
        return guiPlayers[playerNumber];
    }

    public GUI getGUI(){return this.gui;}

}
