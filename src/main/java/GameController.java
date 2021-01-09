import Cards.*;
import Fields.Field;
import Fields.FieldChance;

import Fields.FieldsOnBoard;
import Fields.Properties;
import Player.Player;
import ViewLayer.UIController;

import java.awt.*;
import java.util.Arrays;

public class GameController {
    private GameBoard gameBoard = new GameBoard();
    private int numberOfPlayers = 0;
    String ready;
    int Losers = 0;
    private Player[] playerList;
    //nye terninger?
    Die d1 = new Die(2);
    Die d2 = new Die(2);
    Rafflecup rafflecup = new Rafflecup(d1, d2);
    private boolean GameOver = false;

    private UIController uiController;
    private String[] currentLang;
    String lang = "Dansk";

    public GameController() {

    }

    private int SetPlayerAmount() {
        numberOfPlayers = uiController.getGUI().getUserInteger(currentLang[0]);
        while (numberOfPlayers > 6 || numberOfPlayers < 3) {
            uiController.getGUI().showMessage(currentLang[1]);
            numberOfPlayers = uiController.getGUI().getUserInteger(currentLang[0]);
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
                case 3 -> player.setMoney(30000);
                case 4 -> player.setMoney(30000);
                case 5 -> player.setMoney(30000);
                case 6 -> player.setMoney(30000);
            }
            playerList[i - 1] = player;
        }
        //Adds playerfigure at end of playerName
        for (int i = 1; i < numberOfPlayers + 1; i++) {
            playerList[i - 1].setName(playerList[i - 1].getName() + currentLang[i + 21]);
        }
    }

    public void Game() {
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
                        int deleteField = playerList[k].getPlayerOwnedFields().atIndex(i);
                        uiController.removeGUIFieldOwner(gameBoard.getFields(), playerList[k].getPlayerOwnedFields().atIndex(i));
                        ((Properties) gameBoard.getFields()[deleteField]).setOwnedBy(-1);
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
            for (int j = 0; j < choiceArr.length; j++) {
                if (!choiceArr[j].equals(color)) {
                    temp[tempCount] = choiceArr[j];
                    tempCount++;
                }
            }
            choiceArr = temp;
            // we update GUIPLAYERPOS here to set player at start
            uiController.updateGUIPlayerPos(playerList[i], playerList[i].getOldposition(), playerList[i].getPosition());
        }
    }

    private void DoAfterMove(int i){
        uiController.updateGUIPlayerPos(playerList[i], playerList[i].getOldposition(), playerList[i].getPosition());
        //********************checks is player is on a chancefield if so he draws a card***********************************
        if (gameBoard.getFields()[playerList[i].getPosition()] instanceof FieldChance) {
                        /*boolean draw = true;
                        //Loop that draws cards until the last drawn card has drawAgain == false
                        //If else statements keeps track of which type of card and acts accordingly
                        while (draw) {
                            uiController.getGUI().displayChanceCard(gameBoard.fieldChance.getCards().getLast().getCardText());
                            if (gameBoard.fieldChance.getCards().getLast() instanceof PlayerSpecific) {
                                draw = true;
                                gameBoard.fieldChance.takeChanceCard(playerList, i, gameBoard.getFields(), uiController.getGuiInput(gameBoard.fieldChance.nextCard()));
                            } else if (gameBoard.fieldChance.getCards().getLast() instanceof GetOutOfJail) {
                                draw = false;
                                gameBoard.fieldChance.takeChanceCard(playerList, i, gameBoard.getFields(), uiController.getGuiInput(gameBoard.fieldChance.nextCard()));
                            } else {
                                gameBoard.fieldChance.takeChanceCard(playerList, i, gameBoard.getFields(), uiController.getGuiInput(gameBoard.fieldChance.nextCard()));
                                draw = gameBoard.fieldChance.getCards().atIndex(0).getDrawAgain();
                            }

                            if (draw == true) {
                                uiController.getGUI().getUserButtonPressed("Du skal trække igen", "træk");
                            }
                        }*/
        } else if (gameBoard.getFields()[playerList[i].getPosition()] instanceof Properties) {
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
        } else {
            gameBoard.getFields()[playerList[i].getPosition()].landOnField(playerList, i);
        }//***************************************************************************************************************

        if (gameBoard.getFields()[playerList[i].getPosition()] instanceof Properties) {
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
                if (playerList[i] != null) {
                    // Gotta update Money here to make sure the gui displays the correct amount.
                    for (int j = 0; j < playerList.length; j++) {
                        if (playerList[j] != null) {
                            uiController.getGuiPlayer(j).setBalance(playerList[j].getMoney());
                        }
                    }
                    //************************************JAIL************************************
                    if (playerList[i].getInJail() && !playerList[i].getJailCard()) {
                        //uiController.getGUI().showMessage(playerList[i].getName() + currentLang[20]);
                        //if the player has over 1000 gives both opportunities:
                        String chosenbutton = "";
                        if (uiController.getGuiPlayer(i).getBalance() > 999 && playerList[i].getTurnsInJail() != 3) {
                            chosenbutton = uiController.getGUI().getUserButtonPressed(uiController.getGuiPlayer(i).getName() + " er i fængsel og kan nu vælge imellem følgende muligheder for at komme ud", "Betal 1000,-", "Slå 2 ens");
                        } else if (playerList[i].getTurnsInJail() == 3) {
                            chosenbutton = uiController.getGUI().getUserButtonPressed(uiController.getGuiPlayer(i).getName() + " er i fængsel og kan nu vælge imellem følgende muligheder for at komme ud", "Betal 1000,-");
                            playerList[i].addToTurnsInJail(-3);
                            System.out.println(playerList[i].getTurnsInJail());
                        } else {
                            chosenbutton = uiController.getGUI().getUserButtonPressed(uiController.getGuiPlayer(i).getName() + " er i fængsel og kan nu vælge imellem følgende muligheder for at komme ud", "Slå 2 ens");
                        }

                        if (chosenbutton.equals("Betal 1000,-")) {
                            playerList[i].setMoney(+-1000);
                            uiController.getGuiPlayer(i).setBalance(playerList[i].getMoney());
                            playerList[i].setInJail(false);
                        } else {

                            rafflecup.useRafflecup();
                            uiController.getGUI().setDice(d1.getFaceValue(), d2.getFaceValue());

                            if (rafflecup.SameDie()) {
                                playerList[i].setInJail(false);
                                playerList[i].setPosition(+rafflecup.RafflecupFaceValue());
                                //updates gui player position
                                uiController.updateGUIPlayerPos(playerList[i], playerList[i].getOldposition(), playerList[i].getPosition());
                                DoAfterMove(i);

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
                    }//***********************************JAIL************************************
                    //Check for if player has a player specific card and gives them the choice


                    //loop to check if a player as reached 0
                    EndGame();
                    if (GameOver) break;


                    //Guibutton to read the next user input
                    if (!playerList[i].getInJail())
                        ready = uiController.getGUI().getUserButtonPressed(uiController.getGuiPlayer(i).getName() + currentLang[14], currentLang[15]);
                    // if statement to check if the user typed in throw
                    if (ready.equals(currentLang[15]) && !playerList[i].getInJail()) {

                        //Change die on in gui to reflect new roll and update player position
                        rafflecup.useRafflecup();
                        uiController.getGUI().setDice(d1.getFaceValue(), d2.getFaceValue());
                        playerList[i].setPosition(+/*rafflecup.RafflecupFaceValue()*/30);

                        //updates gui player position
                        uiController.updateGUIPlayerPos(playerList[i], playerList[i].getOldposition(), playerList[i].getPosition());

                        if (playerList[i].getPosition() == 30) {
                            uiController.getGUI().showMessage(playerList[i].getName() + " landede på gå i fængsel feltet og bliver derfor smidt direkte i fængsel!");
                        }
                    }
                    //Part 1 of landOnField test see part 2
                    //System.out.println(playerList[i].getName() + " before landing on field: " + playerList[i].getMoney());


                    DoAfterMove(i);

                    //here we update the player position again to make sure it's correct if a chancecard has been used
                    uiController.updateGUIPlayerPos(playerList[i], playerList[i].getOldposition(), playerList[i].getPosition());
                    //Checks if player lands on Property and updates GUI with owner
                    /*if (gameBoard.getFields()[playerList[i].getPosition()] instanceof Properties) {
                        uiController.updateGUIFieldOwner(playerList, gameBoard.getFields(), playerList[i].getPosition());

                        //Part 2 of landOnField test
                        //System.out.println(playerList[i].getName() + " after landing on field: " + playerList[i].getMoney());

                        //we use set balance here to update the gui
                        uiController.getGuiPlayer(i).setBalance(playerList[i].getMoney());
                    }*/
                }
            }

        }
        //The last remaining player is found here and made the winner
        for (int j = 0; j < playerList.length; j++) {
            if (playerList[j] != null) {
                uiController.getGUI().showMessage("Den sidste spiller tilbage og derved vinderen er..... " + playerList[j].getName() + "!!!");
            }
        }
        //****************************************Restart game?!!*******************************************
        if (uiController.getGUI().getUserLeftButtonPressed(currentLang[16], currentLang[17], currentLang[18])) {
            uiController.getGUI().close();
            Game();
        } else uiController.getGUI().close();
        //****************************************Restart game?!!*******************************************
    }

    private void UsefullMaybe() {
    /*int[] a = new int[numberOfPlayers];
                int max = 0;
                int lastmax = max;
                GameOver = true;
                uiController.getGUI().showMessage("Gameover! " + uiController.getGuiPlayer(k).getName() + currentLang[12]);

                //first loop to check for game winner
                for (int j = 0; j < numberOfPlayers; j++) {
                    a[j] = uiController.getGuiPlayer(j).getBalance();
                    if (a[j] > max) {
                        max = a[j];
                        lastmax = j;
                    }
                    //if 2 players have the same amount of money at the end of the game SLET FRA HER
                    else if (a[j] == max){
                        uiController.getGUI().showMessage("player: " + j + " propertyvalue: " + ((Properties) gameBoard.getFields()[2]).getTotalPropertyValue(playerList,j, gameBoard.getFields()) + " player: " + lastmax + " propertyvalue: " +((Properties) gameBoard.getFields()[2]).getTotalPropertyValue(playerList,lastmax, gameBoard.getFields()));
                        //System.out.println("player: " + j + " propertyvalue: " + ((Properties) gameBoard.getFields()[2]).getTotalPropertyValue(playerList,j, gameBoard.getFields()) + " player: " + lastmax + " propertyvalue: " +((Properties) gameBoard.getFields()[2]).getTotalPropertyValue(playerList,lastmax, gameBoard.getFields()));
                        if (((Properties) gameBoard.getFields()[2]).getTotalPropertyValue(playerList,j, gameBoard.getFields()) > ((Properties) gameBoard.getFields()[2]).getTotalPropertyValue(playerList,lastmax, gameBoard.getFields())){
                            uiController.getGuiPlayer(j).setBalance(max + 1);
                            max = a[j];
                        }
                        else if ((((Properties) gameBoard.getFields()[2]).getTotalPropertyValue(playerList,j, gameBoard.getFields()) < ((Properties) gameBoard.getFields()[2]).getTotalPropertyValue(playerList,lastmax, gameBoard.getFields()))){
                            uiController.getGuiPlayer(lastmax).setBalance(max+1);
                            max = a[j];
                        }
                        else
                        {
                            uiController.getGUI().showMessage("begge spillere har samme værdi i egendomme... I begge vinder!!!");
                        }
                    }
                    //SLET TIL HER
                }
                // second loop to announce winner
                for (int j = 0; j < a.length; j++) {
                    if (uiController.getGuiPlayer(j).getBalance() == max)
                        uiController.getGUI().showMessage(currentLang[13] + uiController.getGuiPlayer(j).getName() + " !!!");
                }
                break;*/
    }
}