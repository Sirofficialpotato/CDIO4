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
            int totalValue = ((Properties) fields[1]).getTotalPropertyValue(players, player, fields) + players[player].getMoney();
            if (choice == true) {
                players[player].setMoney(-4000);
            } else {
                players[player].setMoney(-totalValue);
            }
        }
        else{
            players[player].setMoney(-2000);
        }
    }
}
