package Fields;

import Player.Player;

public class FieldInfo extends Field{

    // Chance card, straight to jail and free parking
    public FieldInfo(String fieldName, String fieldDescription){
        super(fieldName, fieldDescription);

    }

    @Override
    public void landOnField(Player[] players, int player) {

    }
}
