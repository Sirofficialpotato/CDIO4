package Fields;


import Player.Player;

public class Properties extends Field {
    private String fieldColor;
    private int ownedBy;
    private int price;
    // All ownable properties with a value and a color
    public Properties(String name, String description, String color,int value){
        super(name, description);
        this.fieldColor = color;
        this.price = value;
        this.ownedBy = -1;
    }
    @Override
    public void landOnField(Player[] players, int player){

    }


    public void landOnField(Player[] players, int player, Field[] fields, boolean wantToBuyBool) {
        //is 1 if group is not owned by same but 2 if group is owned by same
        int priceMulti = 1;
        //Case when no one owns
        if(this.getOwnedBy() == -1 && wantToBuyBool){
            players[player].setMoney(-this.getPrice());
            this.setOwnedBy(player);
        }
        else if(!wantToBuyBool) {}
        //case if you dont own meaning someone else owns
        else if(this.getOwnedBy() != player){
            if(fields[players[player].getPosition()-1] instanceof Properties){
                if(((Properties) fields[players[player].getPosition()-1]).getOwnedBy() == this.getOwnedBy()){
                    priceMulti = 2;
                }
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
    //methode for when 2 players have the same amount of money in the end of the game
    public int getTotalPropertyValue(Player[] players, int player, Field[] fields)
    {
        int propertiesTotalValue = 0;
        for (int i = 1; i <= 23; i++) {
           // hvis felt i er en property check ellers continue
            if (i % 3 == 0 )
            {
                continue;
            }
            if (((Properties) fields[i]).getOwnedBy() == player){
               propertiesTotalValue += ((Properties) fields[i]).getPrice();
            }

        }
        return propertiesTotalValue;
    }




    public String getFieldName() {
        return fieldName;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }
    public int getFieldValue() {
        return getFieldValue();
    }

    public String getFieldColor() {
        return fieldColor;
    }
    public int getOwnedBy() {
        return ownedBy;
    }
    public void setOwnedBy(int ownerIndex){this.ownedBy = ownerIndex;}

    public int getPrice() {
        return price;
    }
}
