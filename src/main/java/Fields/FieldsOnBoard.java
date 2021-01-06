package Fields;

import Fields.Field;

import java.util.Arrays;

import static java.lang.Integer.parseInt;


public class FieldsOnBoard {
    private Field[] fieldArr = new Field[24];

    public FieldsOnBoard(){
        String[][] allFields = new String[24][];
        allFields[0] = new String[]{"Start", "Modtag 2M når du passerer start"};
        allFields[1] = new String[]{"Burgerbaren", "M1", "grå"};
        allFields[2] = new String[]{"Pizzahuset", "M1", "grå"};
        allFields[3] = new String[]{"Chance", "Tag et kort"};
        allFields[4] = new String[]{"Godtebutikken", "M1", "lyseblå"};
        allFields[5] = new String[]{"Iskiosken", "M1" , "lyseblå"};
        allFields[6] = new String[]{"I fængsel", "På besøg"};
        allFields[7] = new String[]{"Museet", "M2", "lilla"};
        allFields[8] = new String[]{"Biblioteket", "M2", "lilla"};
        allFields[9] = new String[]{"Chance", "Tag et kort"};
        allFields[10] = new String[]{"Skaterparken", "M2", "orange"};
        allFields[11] = new String[]{"Svømmebassinet", "M2", "orange"};
        allFields[12] = new String[]{"Gratis", "Parkering"};
        allFields[13] = new String[]{"Spillehallen", "M3", "Rød"};
        allFields[14] = new String[]{"Biografen", "M3", "Rød"};
        allFields[15] = new String[]{"Chance", "Tag et kort"};
        allFields[16] = new String[]{"Legetøjsbutikken", "M3", "gul"};
        allFields[17] = new String[]{"Dyrehandlen", "M3", "gul"};
        allFields[18] = new String[]{"Gå i fængsel", "fængsel"};
        allFields[19] = new String[]{"Bowlinghallen", "M4", "grøn"};
        allFields[20] = new String[]{"Zoologisk have", "M4", "grøn"};
        allFields[21] = new String[]{"Chance", "Tag et kort"};
        allFields[22] = new String[]{"Vandlandet", "M5", "blå"};
        allFields[23] = new String[]{"Strandpromenaden", "M5", "blå"};

        //Creates a field array based on Strings
        for (int i = 0; i < allFields.length; i++) {
            if(allFields[i][0].equals("Start")){
                this.fieldArr[i] = new FieldStart();

            }
            else if(allFields[i][0].equals("Chance")){
                if (i == 3) {
                    //initialises first FieldChance
                    this.fieldArr[i] = new FieldChance();

                }
                //makes all chanceFields the same object reference
                else{fieldArr[i] = fieldArr[3];}


            }
            else if(allFields[i][0].equals("I fængsel") || allFields[i][0].equals("Gratis")){
                this.fieldArr[i] = new FieldInfo(allFields[i][0], allFields[i][1]);

            }
            else if(allFields[i][0].equals("Gå i fængsel")){
                this.fieldArr[i] = new Jail("Fængsel", allFields[i][0], "test");

            }
            else {
                this.fieldArr[i] = new Properties(allFields[i][0], allFields[i][1], allFields[i][2], parseInt(allFields[i][1].substring(1)));

            }
        }

    }


    @Override
    public String toString() {
        String fieldString = "";
        for (int i = 0; i < fieldArr.length; i++) {
            fieldString+= fieldArr[i].getFieldName() + ": " + fieldArr[i].getFieldDescription()+"\n";
        }
        return fieldString;
    }

    public Field[] getFieldArr(){
        return this.fieldArr;
    }

}

