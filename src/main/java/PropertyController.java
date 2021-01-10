import Fields.*;
//[group][Property][info]


public class PropertyController {
    private int[][][] properties = new int[8][][];
    private Field[] fields = new Field[40];
    private boolean[] canBuy = new boolean[40];

    public PropertyController(Field[] fields){
        this.fields = fields;
        //Loops through each group in properties
        for (int i = 0; i < properties.length; i++) {
            int probCounter = 0;
            //for each group in propeties loops through fields to find coresponding fields
            for (int j = 0; j < fields.length; j++) {
                //Checks if field is Properties and if the
                if(fields[j] instanceof Properties && findPropGroup((Properties) fields[j]) == i){
                    properties[i][probCounter][0] = ((Properties) fields[j]).getOwnedBy();
                    properties[i][probCounter][1] = 0;
                    probCounter++;
                }
            }
        }
        initCanBuy();
    }
    //Takes in a field and returns what group it belongs to based on the color
    private int findPropGroup(Properties field) {
        switch (field.getFieldColor()){
            case "blå":
                return 0;
            case "orange":
                return 1;
            case "grøn":
                return 2;
            case "grå":
                return 3;
            case "rød":
                return 4;
            case "hvid":
                return 5;
            case "gul":
                return 6;
            case "lilla":
                return 7;
            default: return -1;
        }
    }
    //Checks if a specific player can build on a specific field
    public boolean isFieldBuildable(Field field, int playerNumber) {
        boolean groupOwner = false;
        for (int i = 0; i < properties.length; i++) {
            //Checks if player owns a group
            if (playerNumber == properties[i][0][0] && playerNumber == properties[i][1][0]) {
                groupOwner = true;
                //Try if group is of size 3
                try {
                    if (playerNumber != properties[i][2][0]) {
                        groupOwner = false;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }
            }

        }
        return groupOwner;
    }
    //Generates array of fields that player can build on
    public void generatePossibilities(int playerNumber){
            for (int i = 0; i < fields.length; i++) {
                if(fields[i] instanceof Properties && isFieldBuildable(fields[i], playerNumber)){
                    canBuy[i] = true;
                }
            }

    }

    public Field[] getPosibillites(){
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
            }
        }
        return possibilities;
    }

    public void initCanBuy(){
        for (int i = 0; i < canBuy.length; i++) {
            canBuy[i] = false;
        }
    }
    public Object[][] possibleToBuy(){
        return new Object[40][2];
    }

    public int[][][] getProperties() {
        return properties;
    }
}

