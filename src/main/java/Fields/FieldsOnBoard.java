package Fields;

import Fields.Field;

import java.util.Arrays;

import static java.lang.Integer.parseInt;


public class FieldsOnBoard {
    private Field[] fieldArr = new Field[40];

    public FieldsOnBoard(){
        String[][] allFields = new String[40][];
        allFields[0] = new String[]{"Start", "Modtag 2M når du passerer start"};
        allFields[1] = new String[]{"Rødovrevej", "M1200", "blå"};

        allFields[2] = new String[]{"Prøv lykken", "sort"};
        //allFields[2] = new String[]{"Chance", "Tag et kort"};

        allFields[3] = new String[]{"Hvidovrevej", "M1200", "blå"};
        allFields[4] = new String[]{"Betal indkomst-skat", "10%/4000", ""};
        allFields[5] = new String[]{"Øresundsredderiet", "M4000", "blå"};
        allFields[6] = new String[]{"Roskildevej", "M2000", "orange"};

        allFields[7] = new String[]{"CHANCEKORTHER!!!", "sort"};
        //allFields[7] = new String[]{"Chance", "Tag et kort"};

        allFields[8] = new String[]{"Valby Langgade", "M2000", "orange"};
        allFields[9] = new String[]{"Allégade", "M2400", "orange"};
        allFields[10] = new String[]{"I fængsel", "På besøg"};
        allFields[11] = new String[]{"Frederiksberg Allé", "M2800", "grøn"};
        allFields[12] = new String[]{"Tuborg bryggeri", "M3000", "pink"};
        allFields[13] = new String[]{"Bülowsvej", "M2800", "grøn"};
        allFields[14] = new String[]{"Gammel Kongevej", "M3200", "grøn"};
        allFields[15] = new String[]{"D.F.D.S.", "M4000", "lyseblå"};
        allFields[16] = new String[]{"Bernstorffsvej", "M3600", "grå"};

        allFields[17] = new String[]{"CHANCEKORTHER!!!", "sort"};
        //allFields[17] = new String[]{"Chance", "Tag et kort"};

        allFields[18] = new String[]{"Hellerupvej", "M3600", "grå"};
        allFields[19] = new String[]{"Strandvejen", "M4000", "grå"};
        allFields[20] = new String[]{"Gratis", "Parkering"};
        allFields[21] = new String[]{"Trianglen", "M4400", "rød"};

        allFields[22] = new String[]{"CHANCEKORTHER!!!", "sort"};
        //allFields[17] = new String[]{"Chance", "Tag et kort"};

        allFields[23] = new String[]{"Østerbro-gade", "M4400", "rød"};
        allFields[24] = new String[]{"Grønningen", "M4800", "rød"};
        allFields[25] = new String[]{"Scandlines", "M4000", "lyseblå"};
        allFields[26] = new String[]{"Bredgade", "M5200", "hvid"};
        allFields[27] = new String[]{"Kgs. Nytorv", "M5200", "hvid"};
        allFields[28] = new String[]{"Coca Cola", "M3000", "pink"};
        allFields[29] = new String[]{"Østergade", "M5600", "hvid"};
        allFields[30] = new String[]{"Gå i fængsel", "fængsel"};
        allFields[31] = new String[]{"Amagertorv", "M6000", "gul"};
        allFields[32] = new String[]{"Vimmel-skaftet", "M6000", "gul"};

        allFields[33] = new String[]{"CHANCEKORTHER!!!", "M60", "sort"};
        //allFields[33] = new String[]{"Chance", "Tag et kort"};

        allFields[34] = new String[]{"Nygade", "M6400", "gul"};
        allFields[35] = new String[]{"Scandlines", "M4000", "lyseblå"};

        allFields[36] = new String[]{"CHANCEKORTHER!!!", "M60", "sort"};
        //allFields[36] = new String[]{"Chance", "Tag et kort"};

        allFields[37] = new String[]{"Frederiksberggade", "M7000", "lilla"};
        allFields[38] = new String[]{"Ekstra-ordinærstatsskat", "M2000", ""};
        allFields[39] = new String[]{"Rådhuspladsen", "M8000", "lilla"};

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

