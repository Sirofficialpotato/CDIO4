package ViewLayer;

import Cards.Cards;
import Fields.*;
import Player.Player;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;


public class UIController {
    private final GUI gui;
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
                guiFields[i] = new GUI_Start(fieldArray[i].getFieldName(), fieldArray[i].getFieldDescription(), fieldArray[i].getFieldDescription(), Color.white, Color.BLACK);
            }
            else if(fieldArray[i] instanceof FieldChance) {
                guiFields[i] = new GUI_Chance(fieldArray[i].getFieldName(), fieldArray[i].getFieldDescription(), fieldArray[i].getFieldDescription(), Color.WHITE, Color.BLACK);

            }
            else if(fieldArray[i] instanceof Jail) {
                guiFields[i] = new GUI_Jail( "default", fieldArray[i].getFieldName(), fieldArray[i].getFieldDescription(), fieldArray[i].getFieldDescription(), Color.RED, Color.BLACK);
            }
            else if(fieldArray[i] instanceof FieldShipYard){
                guiFields[i] = new GUI_Shipping("default", fieldArray[i].getFieldName(),/*String.valueOf(((FieldShipYard) fieldArray[i]).getPrice())*/"M4000", fieldArray[i].getFieldDescription(), String.valueOf(((FieldShipYard) fieldArray[i]).getRentTimesMulti()), Color.WHITE, Color.BLACK);
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

                switch (((Properties) fieldArray[i]).getFieldColor()) {
                    case "blå" -> {
                        color = Color.blue;
                        txtcolor = Color.white;
                    }
                    case "lilla" -> color = Color.magenta;
                    case "grå" -> color = Color.gray;
                    case "rød" -> color = Color.red;
                    case "gul" -> color = Color.yellow;
                    case "orange" -> color = OrangeColor;
                    case "lyseblå" -> color = Color.cyan;
                    case "grøn" -> color = Color.green;
                    case "hvid" -> color = Color.white;
                    case "pink" -> color = Color.PINK;
                    case "sort" -> color = Color.black;
                }

                guiFields[i] = new GUI_Street(fieldArray[i].getFieldName(),"M" + ((Properties) fieldArray[i]).getPrice(), (fieldArray[i]).getFieldDescription(), String.valueOf(((Properties) fieldArray[i]).getRentTimesMulti()), color, txtcolor);
            }
            else if(fieldArray[i] instanceof FieldInfo && fieldArray[i].getFieldName().equals("I fængsel")) {
                guiFields[i] = new GUI_Jail("default", fieldArray[i].getFieldName(), fieldArray[i].getFieldDescription(), fieldArray[i].getFieldDescription(), Color.RED, Color.BLACK);
            }
            else if(fieldArray[i] instanceof FieldInfo && fieldArray[i].getFieldName().equals("Gratis")) {
                guiFields[i] = new GUI_Refuge("default", fieldArray[i].getFieldName(), fieldArray[i].getFieldDescription(), fieldArray[i].getFieldDescription(), Color.WHITE, Color.BLACK);
            }

        }
        return guiFields;
    }
        //Updates GUI_Player according to corresponding Player
        public void updateGUIPlayerPos(Player player, int oldPosition,int newPosition){

            for (GUI_Player guiPlayer : guiPlayers) {
                if (guiPlayer.getName().equals(player.getName())) {
                    gui.getFields()[oldPosition].setCar(guiPlayer, false);
                    gui.getFields()[newPosition].setCar(guiPlayer, true);

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
                    return switch (choice) {
                        case "Skaterparken" -> 0;
                        case "Swimmingpoolen" -> 1;
                        case "Bowlinghallen" -> 2;
                        default -> 3;
                    };
                case("9:"):
                    choice = this.gui.getUserButtonPressed("Vælg dit felt", "Godtebutikken", "Iskiosken");
                    if(choice.equals("Godtebutikken")){return 0;}
                    else{return 1;}
                case("15"):
                    choice = this.gui.getUserButtonPressed("Vælg dit felt", "Museet", "Biblioteket", "Vandlandet", "Strandpromenaden");
                    return switch (choice) {
                        case "Museet" -> 0;
                        case "Biblioteket" -> 1;
                        case "Vandlandet" -> 2;
                        default -> 3;
                    };
                case("17"):
                    choice = this.gui.getUserButtonPressed("Vælg dit felt", "Spillehallen", "Biografen");
                    if(choice.equals("Spillehallen")){return 0;}
                    else{return 1;}
                case("19"):
                    choice = this.gui.getUserButtonPressed("Vælg dit felt", "Godtebutikken", "Iskiosken", "Spillehallen", "Biografen");
                    return switch (choice) {
                        case "Godtebutikken" -> 0;
                        case "Iskiosken" -> 1;
                        case "Spillehallen" -> 2;
                        default -> 3;
                    };
                case("20"):
                    choice = this.gui.getUserButtonPressed("Vælg dit felt", "Burgerbar", "Pizzahus", "Lejetøjsbutikken", "Dyrehandlen");
                    return switch (choice) {
                        case "Burgerbar" -> 0;
                        case "Pizzahus" -> 1;
                        case "Lejetøjsbutikken" -> 2;
                        default -> 3;
                    };
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
                ((GUI_Shipping) this.gui.getFields()[field]).setRent("M"+ ((FieldShipYard) fields[field]).getRentTimesMulti());
            }
        }
        else if(field == 12 || field == 28){
            if (((Brewery) fields[field]).getOwnedBy() != -1) {
                ((GUI_Brewery) this.gui.getFields()[field]).setOwnerName(players[((Brewery) fields[field]).getOwnedBy()].getName());
                ((GUI_Brewery) this.gui.getFields()[field]).setBorder(this.guiPlayers[((Brewery) fields[field]).getOwnedBy()].getPrimaryColor());
            }
        }
        else {
            if(((Properties)fields[field]).getOwnedBy() != -1) {
                ((GUI_Street) this.gui.getFields()[field]).setOwnerName(players[((Properties) fields[field]).getOwnedBy()].getName());
                ((GUI_Street) this.gui.getFields()[field]).setBorder(this.guiPlayers[((Properties)fields[field]).getOwnedBy()].getPrimaryColor());
                ((GUI_Street)getGUI().getFields()[field]).setRent("M"+ ((Properties)fields[field]).getRentTimesMulti());
            }
        }
    }
    public void removeGUIFieldOwner(Field[] fields, int field){
        if(field == 5 || field == 15 || field == 25 || field == 35) {
            if (((FieldShipYard) fields[field]).getOwnedBy() != -1) {
                ((GUI_Shipping) this.gui.getFields()[field]).setOwnerName(null);
                ((GUI_Shipping) this.gui.getFields()[field]).setBorder(Color.lightGray);
                ((FieldShipYard) fields[field]).checkIfSameShippingOwner(field,fields);
                ((GUI_Shipping) this.gui.getFields()[field]).setRent("M" + ((FieldShipYard) fields[field]).getRentTimesMulti());
            }
        }
        if(field == 12 || field == 28) {
            if (((Brewery) fields[field]).getOwnedBy() != -1) {
                ((GUI_Brewery) this.gui.getFields()[field]).setOwnerName(null);
                ((GUI_Brewery) this.gui.getFields()[field]).setBorder(Color.lightGray);
            }
        }
        else {
            if(((Properties)fields[field]).getOwnedBy() != -1) {
                ((GUI_Street) this.gui.getFields()[field]).setOwnerName(null);
                ((GUI_Street) this.gui.getFields()[field]).setBorder(Color.lightGray);
                ((GUI_Street) this.gui.getFields()[field]).setHotel(false);
                ((GUI_Street) this.gui.getFields()[field]).setHouses(0);
            }
        }
    }

    public void buildPropertiesOnGui(int i,int j,int houses, Player[] players, Field[] fields){
        if(houses <= 4)((GUI_Street)getGUI().getFields()[players[i].getPlayerOwnedFields().atIndex(j)]).setHouses(houses);
        else if(houses == 5){
            ((GUI_Street)getGUI().getFields()[players[i].getPlayerOwnedFields().atIndex(j)]).setHouses(0);
            ((GUI_Street)getGUI().getFields()[players[i].getPlayerOwnedFields().atIndex(j)]).setHotel(true);
        }
        ((GUI_Street)getGUI().getFields()[players[i].getPlayerOwnedFields().atIndex(j)]).setRent("M"+ ((Properties)fields[players[i].getPlayerOwnedFields().atIndex(j)]).getRentTimesMulti());
    }

    public GUI_Player getGuiPlayer(int playerNumber){
        return guiPlayers[playerNumber];
    }

    public GUI getGUI(){return this.gui;}

    public void updateRent(int currentField, Field[] fields){
        if(fields[currentField] instanceof Properties){
            ((GUI_Street)getGUI().getFields()[currentField]).setRent("M"+ ((Properties)fields[currentField]).getRentTimesMulti());
        } else if(fields[currentField] instanceof FieldShipYard){
            ((GUI_Shipping)getGUI().getFields()[currentField]).setRent("M"+ ((FieldShipYard)fields[currentField]).getRentTimesMulti());
        }
    }

}
