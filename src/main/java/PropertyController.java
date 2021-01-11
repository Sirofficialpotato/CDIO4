import Fields.*;
//[group][Property][info]


public class PropertyController {
    private int[][][] properties = new int[8][3][3];
    private Field[] fields = new Field[40];
    private boolean[] canBuy = new boolean[40];

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
            for (int j = 0; j < fields.length; j++) {
                //Checks if field is Properties and if the
                if(fields[j] instanceof Properties){
                    if(((Properties) fields[j]).getIndex() == i) {
                        properties[i][probCounter][0] = ((Properties) fields[j]).getOwnedBy();
                        properties[i][probCounter][1] = ((Properties) fields[j]).getBuildOn();
                        properties[i][probCounter][2] = ((Properties) fields[j]).getIndex();
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
        int groupChecker = -1;
        for (int i = 0; i < properties.length; i++) {
            for (int j = 0; j < properties[0].length; j++) {
                if(properties[i][j][2] == field.getIndex()){
                    groupChecker = i;
                    break;
                }
            }
        }
        if(groupChecker != -1) {
            if (playerNumber == properties[groupChecker][0][0] && playerNumber == properties[groupChecker][1][0] && playerNumber == properties[groupChecker][2][0]) {
                groupOwner = true;
            }
        }

        return groupOwner;
    }

    //Generates boolean field with true for all fields that player can build on
    public void generatePossibilities(int playerNumber){
        updateProperties();
            for (int i = 0; i < fields.length; i++) {
                if(fields[i] instanceof Properties && isFieldBuildable((Properties) fields[i], playerNumber)){
                    canBuy[i] = true;
                }
            }

    }
    //sets fields not to be used to -2
    public void set3rdSpaceIn2PropGroupsToN2(){
        properties[0][2][0] = -2;
        properties[0][2][0] = -2;
        properties[7][2][0] = -2;
        properties[7][2][0] = -2;
    }
    //builds field[] that returns all fields player can build on
    public Field[] getPosibillites(int player){
        generatePossibilities(player);
        Field[] possibilities;
        int totalPossibilities = 0;
        for (int i = 0; i < canBuy.length; i++) {
            if (canBuy[i] == true) {
                totalPossibilities++;
            }
        }
        possibilities = new Field[totalPossibilities];
        int fieldCounter = 0;
        for (int i = 0; i < fields.length; i++) {
            if(canBuy[i] == true){
                possibilities[fieldCounter] = fields[i];
                fieldCounter++;
            }
        }
        return possibilities;
    }

    public void initCanBuy(){
        for (int i = 0; i < canBuy.length; i++) {
            canBuy[i] = false;
        }
    }

    public int[][][] getProperties() {
        return properties;
    }

    public Field[] getFields(){
        return this.fields;
    }
}

