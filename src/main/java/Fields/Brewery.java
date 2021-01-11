package Fields;

import Player.Player;

public class Brewery extends Field{
    int ownedBy = -1;
    int index;
    int price;

    public Brewery(String fieldName, String fieldDescription, int index, int price) {
        super(fieldName, fieldDescription);
        this.index = index;
        this.price = price;
    }

    @Override
    public void landOnField(Player[] players, int player) {

    }

    public void landOnField(Player[] players, int player, Field[] fields, boolean wantToBuyBool){
        if(this.getOwnedBy() == -1 && wantToBuyBool){
            players[player].setMoney(-this.getPrice());
            this.setOwnedBy(player);
        }
        else if(!wantToBuyBool) {}
        //case if you dont own meaning someone else owns
        else if(this.getOwnedBy() != player){
            if(((Brewery)fields[12]).getOwnedBy() == ((Brewery)fields[28]).getOwnedBy()){
                players[player].setMoney(-players[player].getLastRoll());
            }
            else if(fields[players[player].getPosition()+1] instanceof Properties){
                if(((Properties) fields[(players[player].getPosition()+1)%40]).getOwnedBy() == this.getOwnedBy()){
                    priceMulti = 2;
                }
            }
            players[player].setMoney(-this.getPrice() * priceMulti);
            players[this.getOwnedBy()].setMoney(this.getPrice() * priceMulti);
        }
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
