package Cards;

import Fields.Field;
import Player.Player;

public class GetPaidByPlayers extends Cards {
    int value;
    public GetPaidByPlayers(String text, int value) {
        super(text);
        this.value = value;
    }

    @Override
    public void drawCard(Player player) {

    }
}
