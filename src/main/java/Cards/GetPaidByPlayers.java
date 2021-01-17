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

    public  void drawCard(Player[] players, int player){
        for (int i = 0; i < players.length; i++) {
            if(i == player){
                players[i].setMoney(value * (players.length-1));
            }
            else{
                players[i].setMoney(-value);
            }
        }
    }
}
