package Fields;


import Player.Player;

public class Properties extends Field {
    private final String fieldColor;
    private int ownedBy;
    private final int price;
    private int buildOn = 0;
    private final int index;
    private int priceMulti = 1;
    private int rent;
    private boolean pawned = false;
    // All ownable properties with a value and a color
    public Properties(String name, String description, String color,int value, int index){
        super(name, description);
        this.fieldColor = color;
        this.price = value;
        this.ownedBy = -1;
        this.index = index;
        this.rent = this.price / 4;
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
            for (int i = 0; i < 39; i++) {
                switch (players[player].getPosition()) {
                    case 1, 3 -> doubleSizedGroup(fields, 1, 3);
                    case 6, 8, 9 -> tripleSizedGroup(fields, 6, 8, 9);
                    case 11, 13, 14 -> tripleSizedGroup(fields, 11, 13, 14);
                    case 16, 18, 19 -> tripleSizedGroup(fields, 16, 18, 19);
                    case 21, 23, 24 -> tripleSizedGroup(fields, 21, 23, 24);
                    case 26, 27, 29 -> tripleSizedGroup(fields, 26, 27, 29);
                    case 31, 32, 34 -> tripleSizedGroup(fields, 31, 32, 34);
                    case 37, 39 -> doubleSizedGroup(fields, 37, 39);
                }
            }
            /*switch (players[player].getPosition()) {
                case 1, 3 -> doubleSizedGroup(fields, 1, 3);
                case 6, 8, 9 -> tripleSizedGroup(fields, 6, 8, 9);
                case 11, 13, 14 -> tripleSizedGroup(fields, 11, 13, 14);
                case 16, 18, 19 -> tripleSizedGroup(fields, 16, 18, 19);
                case 21, 23, 24 -> tripleSizedGroup(fields, 21, 23, 24);
                case 26, 27, 29 -> tripleSizedGroup(fields, 26, 27, 29);
                case 31, 32, 34 -> tripleSizedGroup(fields, 31, 32, 34);
                case 37, 39 -> doubleSizedGroup(fields, 37, 39);
            }*/
        }

        //case if you dont own meaning someone else owns, case if the player is in jail, don't pay rent
        else if(this.getOwnedBy() !=player && this.ownedBy != -1 && !players[this.getOwnedBy()].getInJail()){

            /*switch (players[player].getPosition()) {
                case 1, 3 -> doubleSizedGroup(fields, 1, 3);
                case 6, 8, 9 -> tripleSizedGroup(fields, 6, 8, 9);
                case 11, 13, 14 -> tripleSizedGroup(fields, 11, 13, 14);
                case 16, 18, 19 -> tripleSizedGroup(fields, 16, 18, 19);
                case 21, 23, 24 -> tripleSizedGroup(fields, 21, 23, 24);
                case 26, 27, 29 -> tripleSizedGroup(fields, 26, 27, 29);
                case 31, 32, 34 -> tripleSizedGroup(fields, 31, 32, 34);
                case 37, 39 -> doubleSizedGroup(fields, 37, 39);
            }*/
            //Chek if a ground is pledge, and thereafter pay the right rent.
            if(pawned == false){
                players[player].setMoney(-this.rent * this.priceMulti);
                players[this.getOwnedBy()].setMoney(this.rent * this.priceMulti);
            }



        }
    }
    //method for when 2 players have the same amount of money in the end of the game
    public int getTotalPropertyValue()
    {
        return this.price + this.price * 10 / 5 * buildOn;

    }

    public int getBuildOn(){
        return buildOn;
    }

    public void buildOnProperty(Player player, Field[] fields){
        if(this.buildOn < 4){
            this.buildOn++;
            player.setMoney(-this.price/2);
            System.out.println("Hus nr. " + buildOn + " bygget");

            switch (this.getIndex()) {
                case 1, 3 -> doubleSizedGroup(fields, 1, 3);
                case 6, 8, 9 -> tripleSizedGroup(fields, 6, 8, 9);
                case 11, 13, 14 -> tripleSizedGroup(fields, 11, 13, 14);
                case 16, 18, 19 -> tripleSizedGroup(fields, 16, 18, 19);
                case 21, 23, 24 -> tripleSizedGroup(fields, 21, 23, 24);
                case 26, 27, 29 -> tripleSizedGroup(fields, 26, 27, 29);
                case 31, 32, 34 -> tripleSizedGroup(fields, 31, 32, 34);
                case 37, 39 -> doubleSizedGroup(fields, 37, 39);
            }
        }
        else if(this.buildOn == 4){
            this.buildOn++;
            System.out.println(buildOn + " Opnået hotel bygget");
            player.setMoney(-this.price*5/2);
        }
    }

    public void sellBuilding(Player player){
        if(this.buildOn == 5){
            this.buildOn = 0;
            player.setMoney(this.price*5/4);
        }
        else if(this.buildOn > 0){
            this.buildOn--;
            player.setMoney(this.price/4);
        }
    }

    public int getGroup(){
        return switch (this.getFieldColor()) {
            case "blå" -> 0;
            case "orange" -> 1;
            case "grøn" -> 2;
            case "grå" -> 3;
            case "rød" -> 4;
            case "hvid" -> 5;
            case "gul" -> 6;
            case "lilla" -> 7;
            default -> -1;
        };

    }

    public void pawnProperties(Player player){
        if(pawned == false) {
            pawned = true;
            player.setMoney(this.price/2);
        }
        else{
            pawned = false;
            player.setMoney(-this.price/2*110/100);
        }
    }
    public String getFieldName() {
        return fieldName;
    }

    public String getFieldDescription() {
        return fieldDescription;
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

    public void setBuildOn(int numberOfBuildings){
        this.buildOn = numberOfBuildings;
    }

    public int getIndex(){return this.index;}

    public boolean getPawned(){
        return this.pawned;
    }

    private void buildingSwitch(){
        switch (buildOn) {
            case 1 -> this.priceMulti = 3;
            case 2 -> this.priceMulti = 4;
            case 3 -> this.priceMulti = 5;
            case 4 -> this.priceMulti = 6;
            case 5 -> this.priceMulti = 8;
        }
    }

    private void doubleSizedGroup(Field[] fields, int fieldToCheck, int fieldToCheck2){

        if(((Properties) fields[fieldToCheck]).getOwnedBy() == this.getOwnedBy() && ((Properties) fields[fieldToCheck2]).getOwnedBy() == this.getOwnedBy()){
            if(this.buildOn > 0) {buildingSwitch();}
            else if(((Properties) fields[fieldToCheck]).buildOn == 0 && ((Properties) fields[fieldToCheck2]).buildOn == 0){
                ((Properties) fields[fieldToCheck]).priceMulti = 2;
                ((Properties) fields[fieldToCheck2]).priceMulti = 2;
            }
            if(((Properties) fields[fieldToCheck]).buildOn > 0 && ((Properties) fields[fieldToCheck2]).buildOn == 0) {
                ((Properties) fields[fieldToCheck2]).priceMulti = 1;
            }else if(((Properties) fields[fieldToCheck]).buildOn == 0 && ((Properties) fields[fieldToCheck2]).buildOn > 0) {
                ((Properties) fields[fieldToCheck]).priceMulti = 1;
            }
        }
    }

    private void tripleSizedGroup(Field[] fields, int fieldToCheck, int fieldToCheck2, int fieldToCheck3){

        if(((Properties) fields[fieldToCheck]).getOwnedBy() == this.getOwnedBy() && ((Properties) fields[fieldToCheck2]).getOwnedBy() == this.getOwnedBy() && ((Properties) fields[fieldToCheck3]).getOwnedBy() == this.getOwnedBy()){
            if(this.buildOn > 0) {buildingSwitch();}
            else if(((Properties) fields[fieldToCheck]).buildOn == 0 && ((Properties) fields[fieldToCheck2]).buildOn == 0 && ((Properties) fields[fieldToCheck3]).buildOn == 0){
                ((Properties) fields[fieldToCheck]).priceMulti = 2;
                ((Properties) fields[fieldToCheck2]).priceMulti = 2;
                ((Properties) fields[fieldToCheck3]).priceMulti = 2;}

            if(((Properties) fields[fieldToCheck]).buildOn > 0 && ((Properties) fields[fieldToCheck2]).buildOn == 0 && ((Properties) fields[fieldToCheck3]).buildOn == 0){
                ((Properties) fields[fieldToCheck2]).priceMulti = 1;
                ((Properties) fields[fieldToCheck3]).priceMulti = 1;
            } else if(((Properties) fields[fieldToCheck]).buildOn == 0 && ((Properties) fields[fieldToCheck2]).buildOn > 0 && ((Properties) fields[fieldToCheck3]).buildOn == 0) {
                ((Properties) fields[fieldToCheck]).priceMulti = 1;
                ((Properties) fields[fieldToCheck3]).priceMulti = 1;
            }else if(((Properties) fields[fieldToCheck]).buildOn == 0 && ((Properties) fields[fieldToCheck2]).buildOn == 0 && ((Properties) fields[fieldToCheck3]).buildOn > 0) {
                ((Properties) fields[fieldToCheck]).priceMulti = 1;
                ((Properties) fields[fieldToCheck2]).priceMulti = 1;
            }

        }
    }

    /*public int getRent(){
        int tempRent = rent;
        switch (buildOn) {
            case 0 -> tempRent = rent * priceMulti;
            case 1 -> {
                tempRent = rent * 3;
            }
            case 2 -> {
                tempRent = rent * 4;
            }
            case 3 -> {
                tempRent = rent * 5;
            }
            case 4 -> {
                tempRent = rent * 6;
            }
            case 5 -> {
                tempRent = rent * 8;
            }

        }
        return tempRent;
    */
    public int getRentTimesMulti(){
        return (this.rent*this.priceMulti);
    }
}
