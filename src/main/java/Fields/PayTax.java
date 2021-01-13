package Fields;

import Player.Player;

public class PayTax extends Field{

    public PayTax(String fieldName, String fieldDescription) {
        super(fieldName, fieldDescription);
    }

    @Override
    public void landOnField(Player[] players, int player) {

    }

    public void landOnField(Player[] players, int player, Field[] fields, boolean choice) {
        if(this.fieldName.equals("Betal indkomst-skat")) {
            if (choice == true) {
                players[player].setMoney(-4000);
            } else {
                players[player].setMoney(-(players[player].getPlayerAssets(fields) + players[player].getMoney())/10);
            }
        }
        else{
            players[player].setMoney(-2000);
        }
    }
}
