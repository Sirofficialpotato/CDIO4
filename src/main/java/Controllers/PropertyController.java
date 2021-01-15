package Controllers;

import Fields.*;

import java.util.Arrays;
//[group][Property][info]
/*
* Info in properties[x][y] = {owner, buildOn, index}
* */


public class PropertyController {
    private final int[][][] properties = new int[8][3][3];
    private final Field[] fields;
    private final boolean[] canBuy = new boolean[40];
    private boolean[] canPawn = new boolean[40];
    private boolean[] canSell = new boolean[40];

    public PropertyController(Field[] fields){
        this.fields = fields;
        set3rdSpaceIn2PropGroupsToN2();
        updateProperties();
        //Loops through each group in properties
        initCanBuy();
    }
    //Method that updates the properties array according to the field[]
    private void updateProperties(){
        for (int i = 0; i < properties.length; i++) {
            int probCounter = 0;
            //for each group in propeties loops through fields to find coresponding fields
            for (Field field : fields) {
                //Checks if field is Properties and if the
                if (field instanceof Properties) {
                    if (((Properties) field).getGroup() == i) {
                        properties[i][probCounter][0] = ((Properties) field).getOwnedBy();
                        properties[i][probCounter][1] = ((Properties) field).getBuildOn();
                        properties[i][probCounter][2] = ((Properties) field).getIndex();
                        probCounter++;
                    }
                }

            }
        }
    }
    //Takes in a field and returns what group it belongs to based on the color

    //Checks if a specific player can build on a specific field
    public boolean isFieldBuildable(Properties field, int playerNumber) {
        boolean groupOwner = false;
        boolean evenBuildingDistribution = false;
        int groupChecker = -1;
        for (int i = 0; i < properties.length; i++) {
            for (int j = 0; j < properties[0].length; j++) {
                if(properties[i][j][2] == field.getIndex()){
                    groupChecker = i;
                    break;
                }
            }
        }
        if(groupChecker != -1 && isBuildingDistEvenForBuy(field)) {
            if(properties[groupChecker][2][0] != -2) {
                if (playerNumber == properties[groupChecker][0][0] && playerNumber == properties[groupChecker][1][0] && playerNumber == properties[groupChecker][2][0]) {
                    groupOwner = true;
                }
            }
            else {
                if (playerNumber == properties[groupChecker][0][0] && playerNumber == properties[groupChecker][1][0]) {
                    groupOwner = true;
                }

            }
        }

        return groupOwner;
    }

    public boolean isBuildingDistEvenForSell(Properties field){
        boolean isEven = false;
        int groupChecker = -1;
        int indexOfOtherGroupMember1 = -1;
        int indexOfOtherGroupMember2 = -1;
        for (int i = 0; i < properties.length; i++) {
            for (int j = 0; j < properties[0].length; j++) {
                if(properties[i][j][2] == field.getIndex()){
                    groupChecker = i;
                    break;
                }
            }
        }
        for (int i = 0; i < properties[groupChecker].length; i++) {
            if(properties[groupChecker][i][2] != field.getIndex()){
                if(indexOfOtherGroupMember1 == -1){
                    indexOfOtherGroupMember1 = properties[groupChecker][i][2];
                }
                else{
                    indexOfOtherGroupMember2 = properties[groupChecker][i][2];
                }
            }
        }
        int i = 0;
        if(groupChecker != -1) {
            if (groupChecker == 0 || groupChecker == 7) {
                if (Math.abs(((Properties) fields[indexOfOtherGroupMember1]).getBuildOn() - ((Properties) fields[field.getIndex()]).getBuildOn()) == 0
                        || ((Properties) fields[indexOfOtherGroupMember1]).getBuildOn() < ((Properties) fields[field.getIndex()]).getBuildOn()){
                    isEven = true;
                }
            }
            else{
                if(((Properties) fields[indexOfOtherGroupMember1]).getBuildOn() >= ((Properties) fields[field.getIndex()]).getBuildOn() && ((Properties) fields[indexOfOtherGroupMember2]).getBuildOn() <= ((Properties) fields[field.getIndex()]).getBuildOn()){
                    isEven = true;
                }
            }
        }
        return isEven;
    }

    public boolean isBuildingDistEvenForBuy(Properties field){
        boolean isEven = false;
        int groupChecker = -1;
        int indexOfOtherGroupMember1 = -1;
        int indexOfOtherGroupMember2 = -1;
        for (int i = 0; i < properties.length; i++) {
            for (int j = 0; j < properties[0].length; j++) {
                if(properties[i][j][2] == field.getIndex()){
                    groupChecker = i;
                    break;
                }
            }
        }
        for (int i = 0; i < properties[groupChecker].length; i++) {
            if(properties[groupChecker][i][2] != field.getIndex()){
                if(indexOfOtherGroupMember1 == -1){
                    indexOfOtherGroupMember1 = properties[groupChecker][i][2];
                }
                else{
                    indexOfOtherGroupMember2 = properties[groupChecker][i][2];
                }
            }
        }
        int i = 0;
        if(groupChecker != -1) {
            if (groupChecker == 0 || groupChecker == 7) {
                if (Math.abs(((Properties) fields[indexOfOtherGroupMember1]).getBuildOn() - ((Properties) fields[field.getIndex()]).getBuildOn()) == 0
                || ((Properties) fields[indexOfOtherGroupMember1]).getBuildOn() > ((Properties) fields[field.getIndex()]).getBuildOn()){
                    isEven = true;
                }
            }
            else{
                if(((Properties) fields[indexOfOtherGroupMember1]).getBuildOn() >= ((Properties) fields[field.getIndex()]).getBuildOn() && ((Properties) fields[indexOfOtherGroupMember2]).getBuildOn() >= ((Properties) fields[field.getIndex()]).getBuildOn()){
                    isEven = true;
                }
            }
        }
        return isEven;
    }

    public boolean hasGroupPawnedProperties(Properties field){
        boolean pawnedProps = false;
        for (int i = 0; i < properties[field.getGroup()].length; i++) {
            if(properties[field.getGroup()][i][0] != -2){
                if(((Properties)fields[properties[field.getGroup()][i][2]]).getPawned()){
                    pawnedProps = true;
                }
            }

        }
        return pawnedProps;
    }
    //Checks if any building are present on the group of the field that is parsed
    public boolean hasGroupBuildingsOnIt(Properties field){
        boolean hasBuildings = false;
        for (int i = 0; i < properties[field.getGroup()].length; i++) {
            if(properties[field.getGroup()][i][1] != 0){
                hasBuildings = true;
            }
        }
        return hasBuildings;
    }
    //Checks if the player that is parsed can pawn the field that is parsed
    public boolean isFieldPawnable(Properties field, int playerNumber){
        boolean pawnable = false;
        if(field.getOwnedBy() == playerNumber && field.getBuildOn() == 0 && !hasGroupBuildingsOnIt(field)){
            pawnable = true;
        }


        return pawnable;
    }



    //Generates boolean field with true for all fields that player can build on
    public void generatePossibilities(int playerNumber){
        updateProperties();
        Arrays.fill(canBuy, false);
            for (int i = 0; i < fields.length; i++) {
                if(fields[i] instanceof Properties && isFieldBuildable((Properties) fields[i], playerNumber) && ((Properties) fields[i]).getBuildOn() < 5 && !hasGroupPawnedProperties((Properties) fields[i])){
                    canBuy[i] = true;
                }
            }
    }
    //Generates a boolean array where indecies are true if the field can be pawned
    public void generatePawningPossibilities(int playerNumber){
        Arrays.fill(canPawn, false);
        updateProperties();
        for (int i = 0; i < fields.length; i++) {
            if(fields[i] instanceof Properties && isFieldPawnable((Properties) fields[i], playerNumber)){
                canPawn[i] = true;
            }
            else if(fields[i] instanceof Brewery && ((Brewery) fields[i]).getOwnedBy() == playerNumber){
                canPawn[i] = true;
            }
            else if(fields[i] instanceof FieldShipYard && ((FieldShipYard) fields[i]).getOwnedBy() == playerNumber){
                canPawn[i] = true;
            }
        }
    }
    //sets fields not to be used to -2
    public void set3rdSpaceIn2PropGroupsToN2(){
        properties[0][2][0] = -2;
        properties[7][2][0] = -2;
    }

    //builds field[] that returns all fields player can build on
    public Field[] getBuyingPosibillites(int player){
        generatePossibilities(player);
        Field[] possibilities;
        int totalPossibilities = 0;
        for (boolean b : canBuy) {
            if (b) {
                totalPossibilities++;
            }
        }
        possibilities = new Field[totalPossibilities];
        int fieldCounter = 0;
        for (int i = 0; i < fields.length; i++) {
            if(canBuy[i]){
                possibilities[fieldCounter] = fields[i];
                fieldCounter++;
            }
        }
        return possibilities;
    }
    public Field[] getPawningPossibilites(int player){
        generatePawningPossibilities(player);
        Field[] possibilities;
        int totalPossibilities = 0;
        for (boolean b : canPawn) {
            if (b) {
                totalPossibilities++;
            }
        }
        possibilities = new Field[totalPossibilities];
        int fieldCounter = 0;
        for (int i = 0; i < fields.length; i++) {
            if(canPawn[i]){
                possibilities[fieldCounter] = fields[i];
                fieldCounter++;
            }
        }
        return possibilities;
    }
    public void generateSellingPossibilities(int player){
        Arrays.fill(canSell, false);
        for (int i = 0; i < fields.length; i++) {
            if(fields[i] instanceof Properties){
                if(((Properties) fields[i]).getOwnedBy() == player && ((Properties) fields[i]).getBuildOn() > 0 && isBuildingDistEvenForSell((Properties) fields[i])){
                    canSell[i] = true;
                }
            }
        }
    }
    public Field[] getSellingPossibilities(int player){
        generateSellingPossibilities(player);
        Field[] possibilities;
        int totalPossibilities = 0;
        for (boolean b : canSell  ) {
            if (b) {
                totalPossibilities++;
            }
        }
        possibilities = new Field[totalPossibilities];
        int fieldCounter = 0;
        for (int i = 0; i < fields.length; i++) {
            if(canSell[i]){
                possibilities[fieldCounter] = fields[i];
                fieldCounter++;
            }
        }

        return possibilities;

    }
    public void initCanBuy(){
        Arrays.fill(canBuy, false);
    }

    public int[][][] getProperties() {
        return properties;
    }

    public Field[] getFields(){
        return this.fields;
    }
}

