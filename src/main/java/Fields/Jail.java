package Fields;

import Fields.Field;
import Player.Player;

public class Jail extends Field {
    // Fields.Jail field

    private String occupiedBy;

    public Jail(String fieldName, String fieldDescription, String occupiedBy){
        super(fieldName, fieldDescription);
        this.occupiedBy = occupiedBy;
        this.fieldName = "Fængsel";
        this.fieldDescription = "Gå i fængsel";
    }

    @Override
    public void landOnField(Player[] players, int player) {
        players[player].setSpecificPosition(6);
        players[player].setInJail(true);
    }

    public String getOccupiedBy() {
        return occupiedBy;
    }
}