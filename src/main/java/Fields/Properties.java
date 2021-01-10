package Fields;


import Player.Player;

public class Properties extends Field {
    private String fieldColor;
    private int ownedBy;
    private int price;
    private int buildOn = 0;
    private int index;
    private int buildings = 0;
    int priceMulti = 1;
    // All ownable properties with a value and a color
    public Properties(String name, String description, String color,int value, int index){
        super(name, description);
        this.fieldColor = color;
        this.price = value;
        this.ownedBy = -1;
        this.index = index;
    }
    @Override
    public void landOnField(Player[] players, int player){

    }


    public void landOnField(Player[] players, int player, Field[] fields, boolean wantToBuyBool) {
        //is 1 if group is not owned by same but 2 if group is owned by same

        //Case when no one owns
        if(this.getOwnedBy() == -1 && wantToBuyBool){
            players[player].setMoney(-this.getPrice());
            this.setOwnedBy(player);
        }
        else if(!wantToBuyBool) {}

        //case if you dont own meaning someone else owns
        else if(this.getOwnedBy() != player){

            switch(players[player].getPosition()){
                case 1,3:
                    doubleSizedGroup(fields,1,3);
                    break;
                case 6,8,9:
                    tripleSizedGroup(fields,6,8,9);
                    break;
                case 11,13,14:
                    tripleSizedGroup(fields,11,13,14);
                    break;
                case 16,18,19:
                    tripleSizedGroup(fields,16,18,19);
                    break;
                case 21,23,24:
                    tripleSizedGroup(fields,21,23,24);
                    break;
                case 26,27,29:
                    tripleSizedGroup(fields,26,27,29);
                    break;
                case 31,32,34:
                    tripleSizedGroup(fields,31,32,34);
                    break;
                case 37,39:
                    doubleSizedGroup(fields,37,39);
                    break;
            }

            players[player].setMoney(-this.getPrice() * this.priceMulti);
            players[this.getOwnedBy()].setMoney(this.getPrice() * this.priceMulti);
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

    public int getBuildOn(){
        return buildOn;
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

    public int getIndex(){return this.index;}

    public int getBuildings(){return this.buildings;}

    private void buildingSwitch(){
        switch(buildings){
            case 1:
                this.priceMulti = 2;
                break;
            case 2:
                this.priceMulti = 3;
                break;
            case 3:
                this.priceMulti = 4;
                break;
            case 4:
                this.priceMulti = 5;
                break;
            case 5:
                this.priceMulti = 6;
                break;
        }
    }

    private void doubleSizedGroup(Field[] fields, int fieldToCheck, int fieldToCheck2){

        if(((Properties) fields[fieldToCheck]).getOwnedBy() == this.getOwnedBy() && ((Properties) fields[fieldToCheck2]).getOwnedBy() == this.getOwnedBy()){
            if(this.buildings > 0) {buildingSwitch();}
            else if(((Properties) fields[fieldToCheck]).buildings == 0 && ((Properties) fields[fieldToCheck2]).buildings == 0){priceMulti = 2;}
        }
    }

    private void tripleSizedGroup(Field[] fields, int fieldToCheck, int fieldToCheck2, int fieldToCheck3){

        if(((Properties) fields[fieldToCheck]).getOwnedBy() == this.getOwnedBy() && ((Properties) fields[fieldToCheck2]).getOwnedBy() == this.getOwnedBy() && ((Properties) fields[fieldToCheck3]).getOwnedBy() == this.getOwnedBy()){
            if(this.buildings > 0) {buildingSwitch();}
            else if(((Properties) fields[fieldToCheck]).buildings == 0 && ((Properties) fields[fieldToCheck2]).buildings == 0 && ((Properties) fields[fieldToCheck3]).buildings == 0){priceMulti = 2;}
        }
    }
}
