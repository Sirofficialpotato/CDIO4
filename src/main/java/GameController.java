import Cards.GetOutOfJail;
import Cards.PlayerSpecific;
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
    private Player[] playerList;
    private final Die die = new Die(1);
    private boolean GameOver = false;

    private UIController uiController;
    private String[] currentLang;
    String lang = "Dansk";

    public GameController(){

    }

    private int SetPlayerAmount(){
        numberOfPlayers = uiController.getGUI().getUserInteger(currentLang[0]);
        while (numberOfPlayers > 4 || numberOfPlayers < 2) {
            uiController.getGUI().showMessage(currentLang[1]);
            numberOfPlayers = uiController.getGUI().getUserInteger(currentLang[0]);
        } return numberOfPlayers;
    }

    private void PlayerCreator(){
        uiController.getGUI().showMessage(currentLang[26]);
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
            }
            //Sets the players money according the rules
            switch (numberOfPlayers) {
                case 2 -> player.setMoney(20);
                case 3 -> player.setMoney(18);
                case 4 -> player.setMoney(16);
            }
            playerList[i - 1] = player;

        }
        //Adds playerfigure at end of playerName
        for (int i = 1; i < numberOfPlayers + 1; i++) {
            playerList[i-1].setName(playerList[i-1].getName() + currentLang[i+21]);
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
        int endGameIf = 0;
        for (int k = 0; k < numberOfPlayers; k++) {
            if (uiController.getGuiPlayer(k).getBalance() <= endGameIf) {
                int[] a = new int[numberOfPlayers];
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
                    //if 2 players have the same amount of money at the end of the game
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
                }
                // second loop to announce winner
                for (int j = 0; j < a.length; j++) {
                    if (uiController.getGuiPlayer(j).getBalance() == max)
                        uiController.getGUI().showMessage(currentLang[13] + uiController.getGuiPlayer(j).getName() + " !!!");
                }
                break;
            }
        }
    }

    private void ChooseColor(){
        String[] choiceArr = Arrays.copyOfRange(currentLang, 4, 12);
        String[] temp;
        String color;
        for (int i = 0; i < playerList.length; i++) {
            color = uiController.getGUI().getUserSelection(uiController.getGuiPlayer(i).getName()+currentLang[3], choiceArr);
            if(lang.equals("WIP English")) {
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
            } else if(lang.equals("Dansk")) {
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
            temp = new String[choiceArr.length-1];
            int tempCount = 0;
            //Creates new array where player choice has been removed and update choiceArr so it no longer contains choice
            for (int j = 0; j < choiceArr.length; j++) {
                if(!choiceArr[j].equals(color)) {
                    temp[tempCount] = choiceArr[j];
                    tempCount++;
                }
            }
            choiceArr = temp;
            // we update GUIPLAYERPOS here to set player at start
            uiController.updateGUIPlayerPos(playerList[i],playerList[i].getOldposition(), playerList[i].getPosition());
        }
    }

    private void GameFlow(){
        while (!GameOver) {

            for (int i = 0; i < playerList.length; i++) {
                // Gotta update Money here to make sure the gui displays the correct amount.
                for (int j = 0; j < playerList.length; j++) {
                    uiController.getGuiPlayer(j).setBalance(playerList[j].getMoney());
                }
                //************************************JAIL************************************
                if(playerList[i].getInJail() && !playerList[i].getJailCard())
                {
                    playerList[i].setInJail(false);
                    uiController.getGUI().showMessage(playerList[i].getName() + currentLang[20]);
                    playerList[i].setMoney(+-1);
                    uiController.getGuiPlayer(i).setBalance(playerList[i].getMoney());
                    //break;
                } else if(playerList[i].getInJail() && playerList[i].getJailCard())
                {
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
                if(GameOver) break;


                //Guibutton to read the next user input
                String ready = uiController.getGUI().getUserButtonPressed(uiController.getGuiPlayer(i).getName() + currentLang[14], currentLang[15]);
                // if statement to check if the user typed in throw
                if (ready.equals(currentLang[15])) {
                    //Change die on in gui to reflect new roll and update player position
                    uiController.getGUI().setDie(die.rollDie());
                    playerList[i].setPosition(+die.getFaceValue());

                    //updates gui player position
                    uiController.updateGUIPlayerPos(playerList[i],playerList[i].getOldposition(), playerList[i].getPosition());

                }
                //Part 1 of landOnField test see part 2
                //System.out.println(playerList[i].getName() + " before landing on field: " + playerList[i].getMoney());



                //********************checks is player is on a chancefield if so he draws a card***********************************
                if(gameBoard.getFields()[playerList[i].getPosition()] instanceof FieldChance){
                    boolean draw = true;
                    //Loop that draws cards until the last drawn card has drawAgain == false
                    //If else statements keeps track of which type of card and acts accordingly
                    while(draw) {
                        uiController.getGUI().displayChanceCard(gameBoard.fieldChance.getCards().getLast().getCardText());
                        if(gameBoard.fieldChance.getCards().getLast() instanceof PlayerSpecific){
                            draw = true;
                            gameBoard.fieldChance.takeChanceCard(playerList, i, gameBoard.getFields(), uiController.getGuiInput(gameBoard.fieldChance.nextCard()));
                        }
                        else if(gameBoard.fieldChance.getCards().getLast() instanceof GetOutOfJail)
                        {
                            draw = false;
                            gameBoard.fieldChance.takeChanceCard(playerList, i, gameBoard.getFields(), uiController.getGuiInput(gameBoard.fieldChance.nextCard()));
                        }
                        else {
                            gameBoard.fieldChance.takeChanceCard(playerList, i, gameBoard.getFields(), uiController.getGuiInput(gameBoard.fieldChance.nextCard()));
                            draw = gameBoard.fieldChance.getCards().atIndex(0).getDrawAgain();
                        }

                        if(draw == true) {
                            uiController.getGUI().getUserButtonPressed("Du skal trække igen", "træk");
                        }
                    }
                }
                else if(gameBoard.getFields()[playerList[i].getPosition()] instanceof Properties){
                    ((Properties) gameBoard.getFields()[playerList[i].getPosition()]).landOnField(playerList,i, gameBoard.getFields());
                }
                else{
                    gameBoard.getFields()[playerList[i].getPosition()].landOnField(playerList, i);
                }//***************************************************************************************************************


                //here we update the player position again to make sure it's correct if a chancecard has been used
                uiController.updateGUIPlayerPos(playerList[i],playerList[i].getOldposition(), playerList[i].getPosition());
                //Checks if player lands on Property and updates GUI with owner
                if(gameBoard.getFields()[playerList[i].getPosition()] instanceof Properties) {
                    uiController.updateGUIFieldOwner(playerList, gameBoard.getFields(), playerList[i].getPosition());

                    //Part 2 of landOnField test
                    //System.out.println(playerList[i].getName() + " after landing on field: " + playerList[i].getMoney());

                    //we use set balance here to update the gui
                    uiController.getGuiPlayer(i).setBalance(playerList[i].getMoney());
                }
            }
        }
        //****************************************Restart game?!!*******************************************
        if(uiController.getGUI().getUserLeftButtonPressed(currentLang[16], currentLang[17], currentLang[18])){
            uiController.getGUI().close();
            Game();
        } else uiController.getGUI().close();
        //****************************************Restart game?!!*******************************************
    }

}
