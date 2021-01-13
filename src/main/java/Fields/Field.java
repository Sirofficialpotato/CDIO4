package Fields;

import Player.Player;

public abstract class Field {

    protected String fieldName;
    protected String fieldDescription;


    public Field(String fieldName, String fieldDescription){
        this.fieldName = fieldName;
        this.fieldDescription = fieldDescription;
    }

    public String getFieldName() { return this.fieldName;}

    public String getFieldDescription() {
        return fieldDescription;
    }

    public abstract void landOnField(Player[] players, int player);

}
