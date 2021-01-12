import Cards.*;
import Fields.*;

import Player.Player;
import ViewLayer.UIController;

import java.awt.*;
import java.util.Arrays;

public class GameController {
    private final GameBoard gameBoard = new GameBoard();
    private int numberOfPlayers = 0;
    String ready;
    int Losers = 0;
    private Player[] playerList;
    Rafflecup rafflecup = new Rafflecup();
    private boolean GameOver = false;
    private PropertyController pController;


    private UIController uiController;
    private String[] currentLang;
    String lang = "Dansk";

    public GameController() {

    }

    private int SetPlayerAmount() {
        while (numberOfPlayers > 6 || numberOfPlayers < 3) {
            String numbofplayerstring = uiController.getGUI().getUserString(currentLang[0]);
            try {
                numberOfPlayers = Integer.parseInt(numbofplayerstring);
                if (numbofplayerstring.equals("")) {
                    numberOfPlayers = 0;
                    uiController.getGUI().showMessage(currentLang[1]);
                }
            } catch (NumberFormatException e) {
                numberOfPlayers = 0;
                uiController.getGUI().showMessage(currentLang[1]);
            }
        }
        return numberOfPlayers;
    }

    private void PlayerCreator() {
        //sets player name and sets start money amount
        for (int i = 1; i < numberOfPlayers + 1; i++) {
            Player player = new Player(uiController.getGUI().getUserString(currentLang[2] + i));
            //Made quickly to check if name is already taken
            if (i == 2) {
                while (player.getName().equals(playerList[0].getName())) {
                    player.setName(uiController.getGUI().getUserString(currentLang[19] + 2));
                }
            } else if (i == 3) {
                while (player.getName().equals(playerList[0].getName()) || player.getName().equals(playerList[1].getName())) {
                    player.setName(uiController.getGUI().getUserString(currentLang[19] + 3));
                }
            } else if (i == 4) {
                while (player.getName().equals(playerList[0].getName()) || player.getName().equals(playerList[1].getName()) || player.getName().equals(playerList[2].getName())) {
                    player.setName(uiController.getGUI().getUserString(currentLang[19] + 4));
                }
            } else if (i == 5) {
                while (player.getName().equals(playerList[0].getName()) || player.getName().equals(playerList[1].getName()) || player.getName().equals(playerList[2].getName()) || player.getName().equals(playerList[3].getName())) {
                    player.setName(uiController.getGUI().getUserString(currentLang[19] + 5));
                }
            } else if (i == 6) {
                while (player.getName().equals(playerList[0].getName()) || player.getName().equals(playerList[1].getName()) || player.getName().equals(playerList[2].getName()) || player.getName().equals(playerList[3].getName()) || player.getName().equals(playerList[4].getName())) {
                    player.setName(uiController.getGUI().getUserString(currentLang[19] + 6));
                }
            }
            //Sets the players money according the rules
            switch (numberOfPlayers) {
                case 3, 4, 5, 6 -> player.setMoney(30000);
            }
            playerList[i - 1] = player;
        }
    }

    public void Game() {
        pController = new PropertyController(gameBoard.getFields());
        uiController = new UIController(gameBoard.getFields());
        GameOver = false;
        //lang = uiController.getGUI().getUserButtonPressed("", /*"WIP English",*/ "Dansk");
        Language langSelector = new Language("Dansk");
        currentLang = langSelector.returnLang();
        playerList = new Player[SetPlayerAmount()];

        PlayerCreator();
        uiController.addPlayers(playerList);

        ChooseColor();
        GameFlow();
    }

    private void EndGame() {
        for (int k = 0; k < playerList.length; k++) {
            // Disable player with 0 or less cash
            if (uiController.getGuiPlayer(k).getBalance() <= 0) {
                if (playerList[k] != null) {
                    uiController.getGUI().getFields()[playerList[k].getPosition()].setCar(uiController.getGuiPlayer(k), false);

                    //Virker ikke måske brugbart???
                    for (int i = 0; i < playerList[k].getPlayerOwnedFields().size; i++) {
                        System.out.println(playerList[k].getPlayerOwnedFields().atIndex(i));
                        if (playerList[k].getPlayerOwnedFields().atIndex(i) == null)
                        {
                            continue;
                        }
                        else if(playerList[k].getPlayerOwnedFields().atIndex(i) != null){

                            int deleteField = playerList[k].getPlayerOwnedFields().atIndex(i);
                            uiController.removeGUIFieldOwner(gameBoard.getFields(), playerList[k].getPlayerOwnedFields().atIndex(i));
                            if (deleteField == 5 || deleteField == 15 || deleteField == 25 || deleteField == 35) {
                                ((FieldShipYard) gameBoard.getFields()[deleteField]).setOwnedBy(-1);
                            }
                            else if(deleteField == 12 || deleteField == 28){
                                ((Brewery) gameBoard.getFields()[deleteField]).setOwnedBy(-1);
                            }
                            else {
                                ((Properties) gameBoard.getFields()[deleteField]).setOwnedBy(-1);
                            }
                        }
                    }

                    playerList[k] = null;
                    Losers++;
                }
            }
            if (Losers == playerList.length - 1) {
                GameOver = true;
            }

        }
    }

    private void ChooseColor() {
        String[] choiceArr = Arrays.copyOfRange(currentLang, 4, 12);
        String[] temp;
        String color;
        for (int i = 0; i < playerList.length; i++) {
            color = uiController.getGUI().getUserSelection(uiController.getGuiPlayer(i).getName() + currentLang[3], choiceArr);
            if (lang.equals("WIP English")) {
                switch (color) {
                    case "RED" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.RED);
                    case "BLACK" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.BLACK);
                    case "BLUE" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.BLUE);
                    case "MAGENTA" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.MAGENTA);
                    case "PINK" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.PINK);
                    case "CYAN" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.CYAN);
                    case "YELLOW" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.YELLOW);
                    case "WHITE" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.WHITE);
                }
            } else if (lang.equals("Dansk")) {
                switch (color) {
                    case "RØD" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.RED);
                    case "SORT" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.BLACK);
                    case "BLÅ" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.BLUE);
                    case "MAGENTA" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.MAGENTA);
                    case "ROSE" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.PINK);
                    case "CYAN" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.CYAN);
                    case "GUL" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.YELLOW);
                    case "HVID" -> uiController.getGuiPlayer(i).getCar().setPrimaryColor(Color.WHITE);
                }
            }
            temp = new String[choiceArr.length - 1];
            int tempCount = 0;
            //Creates new array where player choice has been removed and update choiceArr so it no longer contains choice
            for (String s : choiceArr) {
                if (!s.equals(color)) {
                    temp[tempCount] = s;
                    tempCount++;
                }
            }
            choiceArr = temp;
            // we update GUIPLAYERPOS here to set player at start
            uiController.updateGUIPlayerPos(playerList[i], playerList[i].getOldposition(), playerList[i].getPosition());
        }
    }

    private void Jailfunc(int i){
        if (playerList[i].getInJail() && !playerList[i].getJailCard()) {
            //uiController.getGUI().showMessage(playerList[i].getName() + currentLang[20]);
            //if the player has over 1000 gives both opportunities:
            String chosenbutton;
            if (uiController.getGuiPlayer(i).getBalance() > 999 && playerList[i].getTurnsInJail() != 3) {
                chosenbutton = uiController.getGUI().getUserButtonPressed(uiController.getGuiPlayer(i).getName() + " er i fængsel og kan nu vælge imellem følgende muligheder for at komme ud", "Betal M1000", "Slå 2 ens");
            } else if (playerList[i].getTurnsInJail() == 3) {
                chosenbutton = uiController.getGUI().getUserButtonPressed(uiController.getGuiPlayer(i).getName() + " er i fængsel og kan nu vælge imellem følgende muligheder for at komme ud", "Betal M1000");
                playerList[i].addToTurnsInJail(-3);
                System.out.println(playerList[i].getName()+ " has been in prison for " + playerList[i].getTurnsInJail());
            } else {
                chosenbutton = uiController.getGUI().getUserButtonPressed(uiController.getGuiPlayer(i).getName() + " er i fængsel og kan nu vælge imellem følgende muligheder for at komme ud", "Slå 2 ens");
            }

            if (chosenbutton.equals("Betal M1000")) {
                playerList[i].setMoney(+-1000);
                uiController.getGuiPlayer(i).setBalance(playerList[i].getMoney());
                playerList[i].setInJail(false);
            } else {

                rafflecup.useRafflecup();
                uiController.getGUI().setDice(rafflecup.getD1(), rafflecup.getD2());

                if (rafflecup.SameDie()) {
                    playerList[i].setInJail(false);
                    playerList[i].setPosition(+rafflecup.RafflecupFaceValue());
                    //updates gui player position
                    uiController.updateGUIPlayerPos(playerList[i], playerList[i].getOldposition(), playerList[i].getPosition());
                    DoAfterMove(i, false);

                } else if (!rafflecup.SameDie() && playerList[i].getTurnsInJail() == 3) {
                    playerList[i].setInJail(false);
                    playerList[i].setMoney(+-1000);
                } else if (!rafflecup.SameDie()) {
                    playerList[i].addToTurnsInJail(+1);
                    System.out.println(playerList[i].getTurnsInJail());
                }
            }
        } else if (playerList[i].getInJail() && playerList[i].getJailCard()) {
            playerList[i].setJailCard(false);
            playerList[i].setInJail(false);
            gameBoard.fieldChance.getCards().add(playerList[i].getJailCardOject());
            gameBoard.fieldChance.getCards().lastItemToFront();
            playerList[i].removeJailCardObect();
            uiController.getGUI().showMessage(playerList[i].getName() + currentLang[21]);
        }
    }

    private void DoAfterMove(int i, boolean gotHereByCard){

        uiController.updateGUIPlayerPos(playerList[i], playerList[i].getOldposition(), playerList[i].getPosition());
        //********************checks is player is on a chancefield if so he draws a card***********************************
        if (gameBoard.getFields()[playerList[i].getPosition()] instanceof FieldChance) {
            /*Cards currentCard = gameBoard.getCards().getLast();
            ((FieldChance)gameBoard.getFields()[playerList[i].getPosition()]).landOnField(playerList, i, gameBoard.getFields(), gameBoard.getCards());
            uiController.getGUI().displayChanceCard(currentCard.getCardText());
            //Loop that draws cards until the last drawn card has drawAgain == false
            //If else statements keeps track of which type of card and acts accordingly
            gameBoard.getCards().lastItemToFront();
            boolean shippingCardCheck = false;
            if(currentCard.getCardText().equals("Ryk frem til det nærmeste rederi og betal ejeren to gange den leje han ellers er berettiget til, hvis selskabet ikke ejes af nogen kan De købe det af banken.")){
                shippingCardCheck = true;
            }
            DoAfterMove(i, shippingCardCheck);*/
        }

        else if (gameBoard.getFields()[playerList[i].getPosition()] instanceof Properties) {
            if (((Properties) gameBoard.getFields()[playerList[i].getPosition()]).getOwnedBy() == -1) {
                boolean buyOrNot = uiController.getGUI().getUserLeftButtonPressed(playerList[i].getName() + " landede på " + gameBoard.getFields()[playerList[i].getPosition()].getFieldName() + " og har nu muligheden for at købe", "Køb", "Ignorere");
                if (buyOrNot) {
                    playerList[i].addToPlayerOwnedFields();
                    ((Properties) gameBoard.getFields()[playerList[i].getPosition()]).landOnField(playerList, i, gameBoard.getFields(), true);
                } else {
                    ((Properties) gameBoard.getFields()[playerList[i].getPosition()]).landOnField(playerList, i, gameBoard.getFields(), false);
                }
            } else {
                ((Properties) gameBoard.getFields()[playerList[i].getPosition()]).landOnField(playerList, i, gameBoard.getFields(), true);
            }
        } else if (gameBoard.getFields()[playerList[i].getPosition()] instanceof FieldShipYard) {
            if (((FieldShipYard) gameBoard.getFields()[playerList[i].getPosition()]).getOwnedBy() == -1) {
                boolean buyOrNot = uiController.getGUI().getUserLeftButtonPressed(playerList[i].getName() + " landede på " + gameBoard.getFields()[playerList[i].getPosition()].getFieldName() + " og har nu muligheden for at købe", "Køb", "Ignorere");
                if (buyOrNot) {
                    playerList[i].addToPlayerOwnedFields();
                    ((FieldShipYard) gameBoard.getFields()[playerList[i].getPosition()]).landOnField(playerList, i, gameBoard.getFields(), true, gotHereByCard);
                } else {
                    ((FieldShipYard) gameBoard.getFields()[playerList[i].getPosition()]).landOnField(playerList, i, gameBoard.getFields(), false, gotHereByCard);
                }
            } else {
                ((FieldShipYard) gameBoard.getFields()[playerList[i].getPosition()]).landOnField(playerList, i, gameBoard.getFields(), true, gotHereByCard);
            }

        }
        else if(gameBoard.getFields()[playerList[i].getPosition()] instanceof PayTax){
            if(gameBoard.getFields()[playerList[i].getPosition()].getFieldName().equals("Betal indkomst-skat")) {
                boolean choice = uiController.getGUI().getUserLeftButtonPressed("Vil du betale 4000 eller 10% af dine samlede værdier?", "4000", "10%");
                ((PayTax) gameBoard.getFields()[playerList[i].getPosition()]).landOnField(playerList, i, gameBoard.getFields(), choice);
            }
            else {
                uiController.getGUI().showMessage("Betal 2000 i skat!");
            }
        }
        else if(gameBoard.getFields()[playerList[i].getPosition()] instanceof Brewery) {
            if (((Brewery) gameBoard.getFields()[playerList[i].getPosition()]).getOwnedBy() == -1) {
                boolean buyOrNot = uiController.getGUI().getUserLeftButtonPressed(playerList[i].getName() + " landede på " + gameBoard.getFields()[playerList[i].getPosition()].getFieldName() + " og har nu muligheden for at købe", "Køb", "Ignorere");
                if (buyOrNot) {
                    playerList[i].addToPlayerOwnedFields();
                    ((Brewery) gameBoard.getFields()[playerList[i].getPosition()]).landOnField(playerList, i, gameBoard.getFields(), true);
                } else {
                    ((Brewery) gameBoard.getFields()[playerList[i].getPosition()]).landOnField(playerList, i, gameBoard.getFields(), false);
                }

            }
            else {
                ((Brewery)gameBoard.getFields()[playerList[i].getPosition()]).landOnField(playerList, i, gameBoard.getFields(), false);
            }
        }
        else{
            gameBoard.getFields()[playerList[i].getPosition()].landOnField(playerList, i);
        }

        //***************************************************************************************************************

        if (gameBoard.getFields()[playerList[i].getPosition()] instanceof Properties || gameBoard.getFields()[playerList[i].getPosition()] instanceof FieldShipYard || gameBoard.getFields()[playerList[i].getPosition()] instanceof Brewery) {
            uiController.updateGUIFieldOwner(playerList, gameBoard.getFields(), playerList[i].getPosition());

            //Part 2 of landOnField test
            //System.out.println(playerList[i].getName() + " after landing on field: " + playerList[i].getMoney());

            //we use set balance here to update the gui
            uiController.getGuiPlayer(i).setBalance(playerList[i].getMoney());
        }
    }

    private void GameFlow() {
        while (!GameOver) {

            for (int i = 0; i < playerList.length; i++) {
                while(true) {


                    if (playerList[i] != null) {
                        //************************************JAIL************************************
                        Jailfunc(i);
                        //***********************************JAIL************************************
                        //Check for if player has a player specific card and gives them the choice


                        //loop to check if a player as reached 0
                        EndGame();
                        if (GameOver) break;

                        buyOrRoll(i, currentLang[15]);


                        // if statement to check if the user typed in throw
                        if (ready.equals(currentLang[15]) && !playerList[i].getInJail()) {

                            //Change die on in gui to reflect new roll and update player position
                            rafflecup.useRafflecup();
                            uiController.getGUI().setDice(rafflecup.getD1(), rafflecup.getD2());
                            playerList[i].setPosition(+/*rafflecup.RafflecupFaceValue()*/1);

                            //updates gui player position
                            uiController.updateGUIPlayerPos(playerList[i], playerList[i].getOldposition(), playerList[i].getPosition());

                            if (playerList[i].getPosition() == 30) {
                                uiController.getGUI().showMessage(playerList[i].getName() + " landede på gå i fængsel feltet og bliver derfor smidt direkte i fængsel!");
                            }
                        }
                        //Part 1 of landOnField test see part 2
                        //System.out.println(playerList[i].getName() + " before landing on field: " + playerList[i].getMoney());


                        DoAfterMove(i, false);

                        //here we update the player position again to make sure it's correct if a chancecard has been used
                        uiController.updateGUIPlayerPos(playerList[i], playerList[i].getOldposition(), playerList[i].getPosition());

                        // Gotta update Money here to make sure the gui displays the correct amount.
                        for (int j = 0; j < playerList.length; j++) {
                            if (playerList[j] != null) {
                                uiController.getGuiPlayer(j).setBalance(playerList[j].getMoney());
                            }
                        }
                        if (pController.getPosibillites(i).length != 0) buyOrRoll(i, "Afslut tur");

                    }

                    if(!rafflecup.SameDie()){break;}

                }
            }
        }
        //The last remaining player is found here and made the winner
        for (Player player : playerList) {
            if (player != null) {
                uiController.getGUI().showMessage("Den sidste spiller tilbage og derved vinderen er..... " + player.getName() + "!!!");
            }
        }
        //****************************************Restart game?!!*******************************************
        if (uiController.getGUI().getUserLeftButtonPressed(currentLang[16], currentLang[17], currentLang[18])) {
            uiController.getGUI().close();
            Game();
        } else uiController.getGUI().close();
        //****************************************Restart game?!!*******************************************
    }

    private void buyOrRoll(int i, String RollOrEndTurn){
        //*************************************Player gets the choice to either buy houses/hotels or roll with the dice*******************************************************
        if (!playerList[i].getInJail() && pController.getPosibillites(i).length != 0) {
            String[] choiceArr = new String[pController.getPosibillites(i).length];
            for (int j = 0; j < pController.getPosibillites(i).length; j++) {
                choiceArr[j] = pController.getPosibillites(i)[j].getFieldName();
            }
            ready = uiController.getGUI().getUserButtonPressed(uiController.getGuiPlayer(i).getName() + currentLang[14], RollOrEndTurn, "Køb huse/hoteller");


            while(!ready.equals(RollOrEndTurn)) {
                if(ready.equals("Køb huse/hoteller") && !playerList[i].getInJail()){
                    String propertyToBuyAt = uiController.getGUI().getUserButtonPressed("Vælg en grund at købe huse/hoteller til", choiceArr);

                    //Loop to check what field the player selected by matching the String propertyTOBuyAt with the fields of which the player owns
                    for (int j = 0; j < playerList[i].getPlayerOwnedFields().current; j++) {
                        if(propertyToBuyAt.equals(gameBoard.getFields()[playerList[i].getPlayerOwnedFields().atIndex(j)].getFieldName())){
                            ((Properties)gameBoard.getFields()[playerList[i].getPlayerOwnedFields().atIndex(j)]).buildOnProperty(playerList[i]);
                            uiController.buildPropertiesOnGui(i,j,((Properties) gameBoard.getFields()[playerList[i].getPlayerOwnedFields().atIndex(j)]).getBuildOn(),playerList, gameBoard.getFields());
                            uiController.getGuiPlayer(i).setBalance(playerList[i].getMoney());
                        }

                    }
                }
                ready = uiController.getGUI().getUserButtonPressed(uiController.getGuiPlayer(i).getName() + currentLang[14], RollOrEndTurn, "Køb huse/hoteller");

            }
        pController.initCanBuy();
        } else if (!playerList[i].getInJail() && pController.getPosibillites(i).length == 0) {
            ready = uiController.getGUI().getUserButtonPressed(uiController.getGuiPlayer(i).getName() + currentLang[14], RollOrEndTurn);
        }
        //*************************************Player gets the choice to either buy houses/hotels or roll with the dice*******************************************************
    }


}