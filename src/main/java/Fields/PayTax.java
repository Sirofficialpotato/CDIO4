package Fields;

import Player.Player;

public class PayTax extends Field{

    public PayTax(String fieldName, String fieldDescription) {
        super(fieldName, fieldDescription);
    }

    @Override
    public void landOnField(Player[] players, int player) {

    }

    public void landOnField(Player[] players, int player, Field[] fields) {
        int totalValue = 0;
        totalValue += ((Properties)fields[1]).getTotalPropertyValue(players, player, fields);

    }
}
