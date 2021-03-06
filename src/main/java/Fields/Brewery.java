package Fields;

import Player.Player;

public class Brewery extends Field{
    private int ownedBy = -1;
    private int index;
    private int price;
    private String color;
    private boolean pawned = false;

    public Brewery(String fieldName, String fieldDescription, String color, int price, int index) {
        super(fieldName, fieldDescription);
        this.index = index;
        this.price = price;
        this.color = color;
    }

    @Override
    public void landOnField(Player[] players, int player) {

    }

    public void landOnField(Player[] players, int player, Field[] fields, boolean wantToBuyBool){
        if(this.getOwnedBy() == -1 && wantToBuyBool){
            players[player].setMoney(-this.getPrice());
            this.setOwnedBy(player);
        }
        //case if you dont own meaning someone else owns
        else if(this.getOwnedBy() != player && this.getOwnedBy() != -1){
            if(pawned == false) {
                if (((Brewery) fields[12]).getOwnedBy() == ((Brewery) fields[28]).getOwnedBy()) {
                    players[player].setMoney(-players[player].getLastRoll() * 200);
                    players[this.getOwnedBy()].setMoney(players[player].getLastRoll() * 200);
                } else {
                    players[player].setMoney(-players[player].getLastRoll() * 100);
                    players[this.getOwnedBy()].setMoney(players[player].getLastRoll() * 100);
                }
            }
        }
    }
    public void pawnBrewery(Player player) {
        if (pawned == false) {
            pawned = true;
            player.setMoney(this.price);
        } else {
            pawned = false;
            player.setMoney(-this.price * 110 / 100);
        }
    }

    public boolean getPawned(){
        return this.pawned;
    }
    public int getOwnedBy() {
        return ownedBy;
    }

    public int getPrice() {
        return price;
    }

    public void setOwnedBy(int player){
        this.ownedBy = player;
    }
}
