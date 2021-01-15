package Fields;

import Player.Player;

public class FieldShipYard extends Field {
    private String fieldColor;
    private int ownedBy;
    private final int price;
    private int rent;
    int priceMulti = 1;
    boolean pawned = false;

    public FieldShipYard(String fieldName, String fieldDescription, String color,int value) {
        super(fieldName, fieldDescription);
        this.fieldColor = color;
        this.price = value;
        this.ownedBy = -1;
        this.rent = 500;
    }

    @Override
    public void landOnField(Player[] players, int player) {

    }

    public void landOnField(Player[] players, int player, Field[] fields, boolean wantToBuyBool, boolean gotHereByCard) {
        //is 1 if group is not owned by same but 2 if group is owned by same
        int cardMulti = 1;
        //Case when no one owns
        if(this.getOwnedBy() == -1 && wantToBuyBool){
            players[player].setMoney(-this.getPrice());
            this.setOwnedBy(player,fields, players[player].getPosition());
        }
        //case if you dont own meaning someone else owns
        else if(this.getOwnedBy() != player && this.getOwnedBy() != -1){
            if(gotHereByCard){
                cardMulti = 2;
            }

            checkIfSameShippingOwner(players[player].getPosition(), fields);

            System.out.println(priceMulti);
            if(pawned == false) {
                players[player].setMoney(-this.rent * priceMulti * cardMulti);
                players[this.getOwnedBy()].setMoney(this.rent * priceMulti * cardMulti);
            }
        }
    }


    public void setOwnedBy(int ownerIndex, Field[] fields, int fieldToCheck){
        this.ownedBy = ownerIndex;
        checkIfSameShippingOwner(fieldToCheck, fields);
    }

    public String getFieldDescription() {
        return fieldDescription;
    }

    public int getPrice() {
        return this.price;
    }

    public int getRent() {
        return this.rent;
    }

    public boolean getPawned(){
        return this.pawned;
    }

    public int getRentTimesMulti(){
        return (this.rent*this.priceMulti);
    }

    public int getOwnedBy() {
        return this.ownedBy;
    }

    public void pawnShipYard(Player player) {
        if (pawned == false) {
            pawned = true;
            player.setMoney(this.price);
        } else {
            pawned = false;
            player.setMoney(-this.price * 110 / 100);
        }
    }


    public void checkIfSameShippingOwner(int fieldToCheck, Field[] fields){
        switch(fieldToCheck) {
        case 5:
            if (((FieldShipYard) fields[15]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[25]).getOwnedBy() == this.getOwnedBy()) && (((FieldShipYard) fields[35]).getOwnedBy() == this.getOwnedBy())) {
                this.priceMulti = 4;
                ((FieldShipYard) fields[15]).priceMulti = 4;
                ((FieldShipYard) fields[25]).priceMulti = 4;
                ((FieldShipYard) fields[35]).priceMulti = 4;
            } else if (((FieldShipYard) fields[15]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[25]).getOwnedBy() == this.getOwnedBy())) {
                this.priceMulti = 3;
                ((FieldShipYard) fields[15]).priceMulti = 3;
                ((FieldShipYard) fields[25]).priceMulti = 3;
            } else if (((FieldShipYard) fields[25]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[35]).getOwnedBy() == this.getOwnedBy())) {
                this.priceMulti = 3;
                ((FieldShipYard) fields[25]).priceMulti = 3;
                ((FieldShipYard) fields[35]).priceMulti = 3;
            } else if (((FieldShipYard) fields[15]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[35]).getOwnedBy() == this.getOwnedBy())) {
                this.priceMulti = 3;
                ((FieldShipYard) fields[15]).priceMulti = 3;
                ((FieldShipYard) fields[35]).priceMulti = 3;
            } else if(((FieldShipYard) fields[15]).getOwnedBy() == this.getOwnedBy()){
                this.priceMulti = 2;
                ((FieldShipYard) fields[15]).priceMulti = 2;
            } else if(((FieldShipYard) fields[25]).getOwnedBy() == this.getOwnedBy()){
                this.priceMulti = 2;
                ((FieldShipYard) fields[25]).priceMulti = 2;
            } else if(((FieldShipYard) fields[35]).getOwnedBy() == this.getOwnedBy()){
                this.priceMulti = 2;
                ((FieldShipYard) fields[35]).priceMulti = 2;
            } else if (((FieldShipYard) fields[15]).getOwnedBy() != this.getOwnedBy() && (((FieldShipYard) fields[25]).getOwnedBy() != this.getOwnedBy()) && (((FieldShipYard) fields[35]).getOwnedBy() != this.getOwnedBy())) {
                this.priceMulti = 1;
            }
            break;
        case 15:
            if (((FieldShipYard) fields[5]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[25]).getOwnedBy() == this.getOwnedBy()) && (((FieldShipYard) fields[35]).getOwnedBy() == this.getOwnedBy())) {
                this.priceMulti = 4;
                ((FieldShipYard) fields[5]).priceMulti = 4;
                ((FieldShipYard) fields[25]).priceMulti = 4;
                ((FieldShipYard) fields[35]).priceMulti = 4;
            } else if (((FieldShipYard) fields[5]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[25]).getOwnedBy() == this.getOwnedBy())) {
                this.priceMulti = 3;
                ((FieldShipYard) fields[5]).priceMulti = 3;
                ((FieldShipYard) fields[25]).priceMulti = 3;
            } else if (((FieldShipYard) fields[25]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[35]).getOwnedBy() == this.getOwnedBy())) {
                this.priceMulti = 3;
                ((FieldShipYard) fields[25]).priceMulti = 3;
                ((FieldShipYard) fields[35]).priceMulti = 3;
            } else if (((FieldShipYard) fields[5]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[35]).getOwnedBy() == this.getOwnedBy())) {
                this.priceMulti = 3;
                ((FieldShipYard) fields[5]).priceMulti = 3;
                ((FieldShipYard) fields[35]).priceMulti = 3;
            } else if(((FieldShipYard) fields[5]).getOwnedBy() == this.getOwnedBy()){
                this.priceMulti = 2;
                ((FieldShipYard) fields[5]).priceMulti = 2;
            } else if(((FieldShipYard) fields[25]).getOwnedBy() == this.getOwnedBy()){
                this.priceMulti = 2;
                ((FieldShipYard) fields[25]).priceMulti = 2;
            } else if(((FieldShipYard) fields[35]).getOwnedBy() == this.getOwnedBy()){
                this.priceMulti = 2;
                ((FieldShipYard) fields[35]).priceMulti = 2;
            } else if (((FieldShipYard) fields[5]).getOwnedBy() != this.getOwnedBy() && (((FieldShipYard) fields[25]).getOwnedBy() != this.getOwnedBy()) && (((FieldShipYard) fields[35]).getOwnedBy() != this.getOwnedBy())) {
                this.priceMulti = 1;
            }
            break;
        case 25:
            if (((FieldShipYard) fields[5]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[15]).getOwnedBy() == this.getOwnedBy()) && (((FieldShipYard) fields[35]).getOwnedBy() == this.getOwnedBy())) {
                this.priceMulti = 4;
                ((FieldShipYard) fields[5]).priceMulti = 4;
                ((FieldShipYard) fields[15]).priceMulti = 4;
                ((FieldShipYard) fields[35]).priceMulti = 4;
            } else if (((FieldShipYard) fields[5]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[15]).getOwnedBy() == this.getOwnedBy())) {
                this.priceMulti = 3;
                ((FieldShipYard) fields[5]).priceMulti = 3;
                ((FieldShipYard) fields[15]).priceMulti = 3;
            } else if (((FieldShipYard) fields[5]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[35]).getOwnedBy() == this.getOwnedBy())) {
                this.priceMulti = 3;
                ((FieldShipYard) fields[5]).priceMulti = 3;
                ((FieldShipYard) fields[35]).priceMulti = 3;
            } else if (((FieldShipYard) fields[15]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[35]).getOwnedBy() == this.getOwnedBy())) {
                this.priceMulti = 3;
                ((FieldShipYard) fields[15]).priceMulti = 3;
                ((FieldShipYard) fields[35]).priceMulti = 3;
            } else if(((FieldShipYard) fields[5]).getOwnedBy() == this.getOwnedBy()){
                this.priceMulti = 2;
                ((FieldShipYard) fields[5]).priceMulti = 2;
            } else if(((FieldShipYard) fields[15]).getOwnedBy() == this.getOwnedBy()){
                this.priceMulti = 2;
                ((FieldShipYard) fields[15]).priceMulti = 2;
            } else if(((FieldShipYard) fields[35]).getOwnedBy() == this.getOwnedBy()){
                this.priceMulti = 2;
                ((FieldShipYard) fields[35]).priceMulti = 2;
            } else if (((FieldShipYard) fields[5]).getOwnedBy() != this.getOwnedBy() && (((FieldShipYard) fields[15]).getOwnedBy() != this.getOwnedBy()) && (((FieldShipYard) fields[35]).getOwnedBy() != this.getOwnedBy())) {
                this.priceMulti = 1;
            }
            break;
        case 35:
            if (((FieldShipYard) fields[5]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[15]).getOwnedBy() == this.getOwnedBy()) && (((FieldShipYard) fields[25]).getOwnedBy() == this.getOwnedBy())) {
                this.priceMulti = 4;
                ((FieldShipYard) fields[5]).priceMulti = 4;
                ((FieldShipYard) fields[15]).priceMulti = 4;
                ((FieldShipYard) fields[25]).priceMulti = 4;
            } else if (((FieldShipYard) fields[5]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[15]).getOwnedBy() == this.getOwnedBy())) {
                this.priceMulti = 3;
                ((FieldShipYard) fields[5]).priceMulti = 3;
                ((FieldShipYard) fields[15]).priceMulti = 3;
            } else if (((FieldShipYard) fields[5]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[25]).getOwnedBy() == this.getOwnedBy())) {
                this.priceMulti = 3;
                ((FieldShipYard) fields[5]).priceMulti = 3;
                ((FieldShipYard) fields[25]).priceMulti = 3;
            } else if (((FieldShipYard) fields[15]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[25]).getOwnedBy() == this.getOwnedBy())) {
                this.priceMulti = 3;
                ((FieldShipYard) fields[15]).priceMulti = 3;
                ((FieldShipYard) fields[25]).priceMulti = 3;
            } else if(((FieldShipYard) fields[5]).getOwnedBy() == this.getOwnedBy()){
                this.priceMulti = 2;
                ((FieldShipYard) fields[5]).priceMulti = 2;
            } else if(((FieldShipYard) fields[15]).getOwnedBy() == this.getOwnedBy()){
                this.priceMulti = 2;
                ((FieldShipYard) fields[15]).priceMulti = 2;
            } else if(((FieldShipYard) fields[25]).getOwnedBy() == this.getOwnedBy()){
                this.priceMulti = 2;
                ((FieldShipYard) fields[25]).priceMulti = 2;
            } else if (((FieldShipYard) fields[5]).getOwnedBy() != this.getOwnedBy() && (((FieldShipYard) fields[15]).getOwnedBy() != this.getOwnedBy()) && (((FieldShipYard) fields[25]).getOwnedBy() != this.getOwnedBy())) {
                this.priceMulti = 1;
            }
            break;
        }
    }
}
