package Fields;

import Player.Player;

public class FieldShipYard extends Field {
    private String fieldColor;
    private int ownedBy;
    private final int price;
    private int rent;

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
        if(gotHereByCard){
            cardMulti = 2;
        }
        int priceMulti = 1;
        //Case when no one owns
        if(this.getOwnedBy() == -1 && wantToBuyBool){
            players[player].setMoney(-this.getPrice());
            this.setOwnedBy(player);
        }
        //case if you dont own meaning someone else owns
        else if(this.getOwnedBy() != player && this.getOwnedBy() != -1){
            switch(players[player].getPosition()) {
                case 5:
                    if(((FieldShipYard) fields[15]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[25]).getOwnedBy() == this.getOwnedBy()) && (((FieldShipYard) fields[35]).getOwnedBy() == this.getOwnedBy())){priceMulti = 4;}
                    else if(((FieldShipYard) fields[15]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[25]).getOwnedBy() == this.getOwnedBy())){priceMulti = 3;}
                    else if(((FieldShipYard) fields[25]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[35]).getOwnedBy() == this.getOwnedBy())){priceMulti = 3;}
                    else if(((FieldShipYard) fields[15]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[35]).getOwnedBy() == this.getOwnedBy())){priceMulti = 3;}
                    else if(((FieldShipYard) fields[15]).getOwnedBy() == this.getOwnedBy() || (((FieldShipYard) fields[25]).getOwnedBy() == this.getOwnedBy()) || (((FieldShipYard) fields[35]).getOwnedBy() == this.getOwnedBy())){priceMulti = 2;}
                    break;
                case 15:
                    if(((FieldShipYard) fields[5]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[25]).getOwnedBy() == this.getOwnedBy()) && (((FieldShipYard) fields[35]).getOwnedBy() == this.getOwnedBy())){priceMulti = 4;}
                    else if(((FieldShipYard) fields[5]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[25]).getOwnedBy() == this.getOwnedBy())){priceMulti = 3;}
                    else if(((FieldShipYard) fields[25]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[35]).getOwnedBy() == this.getOwnedBy())){priceMulti = 3;}
                    else if(((FieldShipYard) fields[5]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[35]).getOwnedBy() == this.getOwnedBy())){priceMulti = 3;}
                    else if(((FieldShipYard) fields[5]).getOwnedBy() == this.getOwnedBy() || (((FieldShipYard) fields[25]).getOwnedBy() == this.getOwnedBy()) || (((FieldShipYard) fields[35]).getOwnedBy() == this.getOwnedBy())){priceMulti = 2;}
                    break;
                case 25:
                    if(((FieldShipYard) fields[5]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[15]).getOwnedBy() == this.getOwnedBy()) && (((FieldShipYard) fields[35]).getOwnedBy() == this.getOwnedBy())){priceMulti = 4;}
                    else if(((FieldShipYard) fields[5]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[15]).getOwnedBy() == this.getOwnedBy())){priceMulti = 3;}
                    else if(((FieldShipYard) fields[5]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[35]).getOwnedBy() == this.getOwnedBy())){priceMulti = 3;}
                    else if(((FieldShipYard) fields[15]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[35]).getOwnedBy() == this.getOwnedBy())){priceMulti = 3;}
                    else if(((FieldShipYard) fields[5]).getOwnedBy() == this.getOwnedBy() || (((FieldShipYard) fields[15]).getOwnedBy() == this.getOwnedBy()) || (((FieldShipYard) fields[35]).getOwnedBy() == this.getOwnedBy())){priceMulti = 2;}
                    break;
                case 35:
                    if(((FieldShipYard) fields[5]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[15]).getOwnedBy() == this.getOwnedBy()) && (((FieldShipYard) fields[25]).getOwnedBy() == this.getOwnedBy())){priceMulti = 4;}
                    else if(((FieldShipYard) fields[5]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[25]).getOwnedBy() == this.getOwnedBy())){priceMulti = 3;}
                    else if(((FieldShipYard) fields[5]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[15]).getOwnedBy() == this.getOwnedBy())){priceMulti = 3;}
                    else if(((FieldShipYard) fields[15]).getOwnedBy() == this.getOwnedBy() && (((FieldShipYard) fields[25]).getOwnedBy() == this.getOwnedBy())){priceMulti = 3;}
                    else if(((FieldShipYard) fields[5]).getOwnedBy() == this.getOwnedBy() || (((FieldShipYard) fields[15]).getOwnedBy() == this.getOwnedBy()) || (((FieldShipYard) fields[25]).getOwnedBy() == this.getOwnedBy())){priceMulti = 2;}
                    break;
            }
            System.out.println(priceMulti);
            players[player].setMoney(-this.rent * priceMulti * cardMulti);
            players[this.getOwnedBy()].setMoney(this.rent * priceMulti * cardMulti);
        }
    }


    public void setOwnedBy(int ownerIndex){this.ownedBy = ownerIndex;}

    public String getFieldDescription() {
        return fieldDescription;
    }

    public int getPrice() {
        return price;
    }

    public int getRent() {
        return price;
        //return rent;
    }

    public int getOwnedBy() {
        return ownedBy;
    }
}
