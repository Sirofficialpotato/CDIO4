package Cards;
import Fields.*;
import Cards.*;
import Player.*;
import java.util.Scanner;


import Player.Player;

import java.util.Scanner;

public class ChooseToMove extends Cards
{
    public ChooseToMove(String text, int index)
    {
        super(text, index);
    }

    @Override
    //Updates the playerPosition **** not sure if it should use landOnField method on new field as well
    public void drawCard(Player[] players, int player, Field[] fields, int choice)
    {
        switch (this.getCardText().substring(0,2)){
            //Chancecard where you choose how to move 1-5 fields
            case("3:"):
                players[player].setPosition(choice);
                if(fields[players[player].getPosition()] instanceof Properties) {
                    ((Properties) fields[players[player].getPosition()]).landOnField(players, player, fields);
                }
                else{
                    fields[players[player].getPosition()].landOnField(players, player);
                }
                break;
            //Card where you choose between Skaterpark or swimmingpool(Orange fields)
            case("4:"):
                if(choice == 0){
                    players[player].setSpecificPosition(10);}
                else { players[player].setSpecificPosition(11);}
                if(((Properties)fields[players[player].getPosition()]).getOwnedBy() == -1){players[player].setMoney(((Properties)fields[players[player].getPosition()]).getPrice());}
                ((Properties) fields[players[player].getPosition()]).landOnField(players, player, fields);
                break;
            //Card where you choose between moving one field or drawing a new card
            case("5:"):
                if(choice == 0){
                    this.setDrawAgain(true);
                }
                else{
                    this.setDrawAgain(false);
                    players[player].setPosition(choice);
                    if(fields[players[player].getPosition()] instanceof Properties) {
                        ((Properties) fields[players[player].getPosition()]).landOnField(players, player, fields);
                    }
                    else{
                        fields[players[player].getPosition()].landOnField(players, player);
                    }
                }
                break;
            //Card where you choose between orange or green fields: Skatepark, swimmingpool(orange). Bowling, Zoo(Green)
            case("8:"):
                if(choice == 0){ players[player].setSpecificPosition(10);}
                else if(choice == 1) { players[player].setSpecificPosition(11);}
                else if(choice == 2){ players[player].setSpecificPosition(19);}
                else if(choice == 3){ players[player].setSpecificPosition(20);}
                //Checks if field is owned by noone and if so gives the player the money the fields costs so they get it for free
                if(((Properties)fields[players[player].getPosition()]).getOwnedBy() == -1){players[player].setMoney(((Properties)fields[players[player].getPosition()]).getPrice());}
                ((Properties) fields[players[player].getPosition()]).landOnField(players, player, fields);
                break;
            //Choose a lightblue field: Candystore or Icecream joint
            case("9:"):
                if(choice == 0){ players[player].setSpecificPosition(4);}
                else { players[player].setSpecificPosition(5);}
                if(((Properties)fields[players[player].getPosition()]).getOwnedBy() == -1){players[player].setMoney(((Properties)fields[players[player].getPosition()]).getPrice());}
                ((Properties) fields[players[player].getPosition()]).landOnField(players, player, fields);
                break;
            //Choose between pink or dark blue field: Museeum, Library(pink), Water park, beach promenade(dark blue)
            case("15"):
                if(choice == 0){ players[player].setSpecificPosition(7);}
                else if(choice == 1) { players[player].setSpecificPosition(8);}
                else if(choice == 2){ players[player].setSpecificPosition(22);}
                else if(choice == 3){ players[player].setSpecificPosition(23);}
                if(((Properties)fields[players[player].getPosition()]).getOwnedBy() == -1){players[player].setMoney(((Properties)fields[players[player].getPosition()]).getPrice());}
                ((Properties) fields[players[player].getPosition()]).landOnField(players, player, fields);
                break;
            //Choice between red fields: arcade and Cinema
            case("17"):
                if(choice == 0){ players[player].setSpecificPosition(13);}
                else { players[player].setSpecificPosition(14);}
                if(((Properties)fields[players[player].getPosition()]).getOwnedBy() == -1){players[player].setMoney(((Properties)fields[players[player].getPosition()]).getPrice());}
                ((Properties) fields[players[player].getPosition()]).landOnField(players, player, fields);
                break;
            //Choice between red and lightblue: arcade and Cinema(red), Candystore and icecream joint (lightblue)
            case("19"):
                if(choice == 0){ players[player].setSpecificPosition(4);}
                else if(choice == 1) { players[player].setSpecificPosition(5);}
                else if(choice == 2){ players[player].setSpecificPosition(13);}
                else if(choice == 3){ players[player].setSpecificPosition(14);}
                if(((Properties)fields[players[player].getPosition()]).getOwnedBy() == -1){players[player].setMoney(((Properties)fields[players[player].getPosition()]).getPrice());}
                ((Properties) fields[players[player].getPosition()]).landOnField(players, player, fields);
                break;
            //choose grey or yellow field: Pizzahouse, burger joint (grey). Toyshop, Petstore(yellow)
            case("20"):
                if(choice == 0){ players[player].setSpecificPosition(1);}
                else if(choice == 1) { players[player].setSpecificPosition(2);}
                else if(choice == 2){ players[player].setSpecificPosition(16);}
                else if(choice == 3){ players[player].setSpecificPosition(17);}
                if(((Properties)fields[players[player].getPosition()]).getOwnedBy() == -1){players[player].setMoney(((Properties)fields[players[player].getPosition()]).getPrice());}
                ((Properties) fields[players[player].getPosition()]).landOnField(players, player, fields);
                break;

        }
        //Checks that the one case with no movement i not the path and calls land on field method
        if(!this.getCardText().substring(0,2).equals("5:") && choice != 0) {

            if(fields[players[player].getPosition()] instanceof Properties){
                ((Properties) fields[players[player].getPosition()]).landOnField(players, player, fields);
            }
            else {fields[players[player].getPosition()].landOnField(players, player);

            }

        }

    }



}





