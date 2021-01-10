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
                    if(((Properties) fields[1]).getOwnedBy() == this.getOwnedBy() && ((Properties) fields[3]).getOwnedBy() == this.getOwnedBy()){
                        if(this.buildings > 0) {buildingSwitch();}
                        else if(((Properties) fields[1]).buildings == 0 && ((Properties) fields[3]).buildings == 0){priceMulti = 2;}
                    } break;
                case 6,8,9:
                    if(((Properties) fields[6]).getOwnedBy() == this.getOwnedBy() && ((Properties) fields[8]).getOwnedBy() == this.getOwnedBy() && ((Properties) fields[9]).getOwnedBy() == this.getOwnedBy()){
                        if(this.buildings > 0) {buildingSwitch();}
                        else if(((Properties) fields[6]).buildings == 0 && ((Properties) fields[8]).buildings == 0 && ((Properties) fields[9]).buildings == 0){this.priceMulti = 2;}
                    } break;
                case 11,13,14:
                    if(((Properties) fields[11]).getOwnedBy() == this.getOwnedBy() && ((Properties) fields[13]).getOwnedBy() == this.getOwnedBy() && ((Properties) fields[14]).getOwnedBy() == this.getOwnedBy()){
                        if(this.buildings > 0) {buildingSwitch();}
                        else if(((Properties) fields[11]).buildings == 0 && ((Properties) fields[13]).buildings == 0 && ((Properties) fields[14]).buildings == 0){this.priceMulti = 2;}
                    } break;
                case 16,18,19:
                    if(((Properties) fields[16]).getOwnedBy() == this.getOwnedBy() && ((Properties) fields[18]).getOwnedBy() == this.getOwnedBy() && ((Properties) fields[19]).getOwnedBy() == this.getOwnedBy()){
                        if(this.buildings > 0) {buildingSwitch();}
                        else if(((Properties) fields[16]).buildings == 0 && ((Properties) fields[18]).buildings == 0 && ((Properties) fields[19]).buildings == 0){this.priceMulti = 2;}
                    } break;
                case 21,23,24:
                    if(((Properties) fields[21]).getOwnedBy() == this.getOwnedBy() && ((Properties) fields[23]).getOwnedBy() == this.getOwnedBy() && ((Properties) fields[24]).getOwnedBy() == this.getOwnedBy()){
                        if(this.buildings > 0) {buildingSwitch();}
                        else if(((Properties) fields[21]).buildings == 0 && ((Properties) fields[23]).buildings == 0 && ((Properties) fields[24]).buildings == 0){this.priceMulti = 2;}
                    } break;
                case 26,27,29:
                    if(((Properties) fields[26]).getOwnedBy() == this.getOwnedBy() && ((Properties) fields[27]).getOwnedBy() == this.getOwnedBy() && ((Properties) fields[29]).getOwnedBy() == this.getOwnedBy()){
                        if(this.buildings > 0) {buildingSwitch();}
                        else if(((Properties) fields[26]).buildings == 0 && ((Properties) fields[27]).buildings == 0 && ((Properties) fields[29]).buildings == 0){this.priceMulti = 2;}
                    } break;
                case 31,32,34:
                    if(((Properties) fields[31]).getOwnedBy() == this.getOwnedBy() && ((Properties) fields[32]).getOwnedBy() == this.getOwnedBy() && ((Properties) fields[34]).getOwnedBy() == this.getOwnedBy()){
                        if(this.buildings > 0) {buildingSwitch();}
                        else if(((Properties) fields[31]).buildings == 0 && ((Properties) fields[32]).buildings == 0 && ((Properties) fields[34]).buildings == 0){this.priceMulti = 2;}
                    } break;
                case 37,39:
                    if(((Properties) fields[37]).getOwnedBy() == this.getOwnedBy() && ((Properties) fields[39]).getOwnedBy() == this.getOwnedBy()){
                        if(this.buildings > 0) {buildingSwitch();}
                        else if(((Properties) fields[37]).buildings == 0 && ((Properties) fields[39]).buildings == 0){this.priceMulti = 2;}
                    } break;
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
        //int buildings = ((Properties) fields[player]).getBuildings();
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
}
