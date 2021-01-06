package Fields;

import static java.lang.Integer.parseInt;


public class FieldsOnBoard {
    private Field[] fieldArr = new Field[40];

    public FieldsOnBoard(){
        String[][] allFields = new String[40][];
        /*allFields[0] = new String[]{"Start", "Modtag 2M når du passerer start"};
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

        Ting fra GUI måske brugbart????
        allFields[23] = new String[]{"Start", "Modtag 2M når du passerer start"};
        allFields[23] = new String[]{"Rødovrevej", "M60", "Rødovrevej", "Leje:  20", new Color(75, 155, 225), Color.BLACK};
        allFields[23] = new String[]{"?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK};
        allFields[23] = new String[]{"Hvidovrevej", "M60", "Hvidovrevej", "Leje:  20", new Color(75, 155, 225), Color.BLACK};
        allFields[23] = new String[]{"Betal\nindkomst-\nskat", "10% el. 200", "Betal indkomstskat\n10% eller kr. 200,-", Color.GRAY, Color.BLACK};
        allFields[23] = new String[]{"default", "Øresund", "M200", "Øresundsredderiet", "Leje:  75", Color.WHITE, Color.BLACK};
        allFields[23] = new String[]{"Roskildevej", "M100", "Roskildevej", "Leje:  40", new Color(255, 135, 120), Color.BLACK};
        allFields[23] = new String[]{"?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK};
        allFields[23] = new String[]{"Valby\nLanggade", "M100", "Valby Langgade", "Leje:  40", new Color(255, 135, 120), Color.BLACK};
        allFields[23] = new String[]{"Allégade", "M120", "Allégade", "Leje:  45", new Color(255, 135, 120), Color.BLACK};
        allFields[23] = new String[]{"default", "Fængsel", "Fængsel", "På besøg i fængslet", new Color(125, 125, 125), Color.BLACK};
        allFields[23] = new String[]{"Frederiks-\nberg Allé", "M140", "Frederiksberg Allé", "Leje:  50", new Color(102, 204, 0), Color.BLACK};
        allFields[23] = new String[]{"default", "Tuborg", "M150", "Tuborg bryggeri", "10 x [Terningslag]", Color.BLACK, Color.WHITE};
        allFields[23] = new String[]{"Bülowsvej", "M140", "Bülowsvej", "Leje:  50", new Color(102, 204, 0), Color.BLACK};
        allFields[23] = new String[]{"Gammel Kongevej", "M140", "Gammel Kongevej", "Leje:  50", new Color(102, 204, 0), Color.BLACK};
        allFields[23] = new String[]{"default", "D.F.D.S.", "M200", "D.F.D.S.", "Leje:  75", Color.WHITE, Color.BLACK};
        allFields[23] = new String[]{"Bernstorffsvej", "M180", "Bernstorffsvej", "Leje:  60", new Color(153, 153, 153), Color.BLACK};
        allFields[23] = new String[]{"?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK};
        allFields[23] = new String[]{"Hellerupvej", "M180", "Hellerupvej", "Leje:  60", new Color(153, 153, 153), Color.BLACK};
        allFields[23] = new String[]{"Strandvejen", "M180", "Strandvejen", "Leje:  60", new Color(153, 153, 153), Color.BLACK};
        allFields[23] = new String[]{"default", "Helle", "Helle", "Ta' en pause", Color.WHITE, Color.BLACK};
        allFields[23] = new String[]{"Trianglen", "M220", "Trianglen", "Leje:  70", Color.RED, Color.BLACK};
        allFields[23] = new String[]{"?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK};
        allFields[23] = new String[]{"Østerbro-\ngade", "M220", "Østerbrogade", "Leje:  70", Color.RED, Color.BLACK};
        allFields[23] = new String[]{"Grønningen", "M240", "Grønningen", "Leje:  80", Color.RED, Color.BLACK};
        allFields[23] = new String[]{"default", "Ø.S.", "M200", "Ø.S. redderiet", "Leje:  75", Color.WHITE, Color.BLACK};
        allFields[23] = new String[]{"Bredgade", "M260", "Bredgade", "Leje:  80", Color.WHITE, Color.BLACK};
        allFields[23] = new String[]{"Kgs. Nytorv", "M260", "Kongens Nytorv", "Leje:  80", Color.WHITE, Color.BLACK};
        allFields[23] = new String[]{"default", "Carlsberg", "M150", "Carlsberg bryggeri", "10 x [Terningslag]", Color.BLACK, Color.WHITE};
        allFields[23] = new String[]{"Østergade", "M280", "Østergade", "Leje:  85", Color.WHITE, Color.BLACK};
        allFields[23] = new String[]{"default", "Gå i fængsel", "Gå i fængsel", "De fængsles\nSlå to ens for at komme ud", new Color(125, 125, 125), Color.BLACK};
        allFields[23] = new String[]{"Amagertorv", "M300", "Amagertorv", "Leje:  95", new Color(255, 255, 50), Color.BLACK};
        allFields[23] = new String[]{"Vimmel-\nskaftet", "M300", "Vimmelskaftet", "Leje:  95", new Color(255, 255, 50), Color.BLACK};
        allFields[23] = new String[]{"?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK);
        allFields[23] = new String[]{"Nygade", "M320", "Nygade", "Leje:  100", new Color(255, 255, 50), Color.BLACK};
        allFields[23] = new String[]{"default", "Bornholm", "M200", "Bornholms redderi", "Leje:  75", Color.WHITE, Color.BLACK};
        allFields[23] = new String[]{"?", "Prøv lykken", "Ta' et chancekort.", new Color(204, 204, 204), Color.BLACK};
        allFields[23] = new String[]{"Frederiks-\nberggade", "M350", "Frederiksberggade", "Leje:  120", new Color(150, 60, 150), Color.WHITE};
        allFields[23] = new String[]{"Ekstra-\nordinær\nstatsskat", "Betal 100", "Betal ekstraordinær\nstatsskat: kr. 100,-", Color.GRAY, Color.BLACK};
        allFields[23] = new String[]{"Rådhuspladsen", "M400", "Rådhuspladsen", "Leje:  150", new Color(150, 60, 150), Color.WHITE};
         */

        allFields[0] = new String[]{"Start", "Modtag 2M når du passerer start"};
        allFields[1] = new String[]{"Rødovrevej", "M60", "blå"};

        allFields[2] = new String[]{"CHANCEKORTHER!!!", "M60", "sort"};
        //allFields[2] = new String[]{"Chance", "Tag et kort"};

        allFields[3] = new String[]{"Hvidovrevej", "M60", "blå"};
        allFields[4] = new String[]{"Betal indkomst-skat??????", "M200", ""};
        allFields[5] = new String[]{"Øresundsredderiet", "M200", "blå"};
        allFields[6] = new String[]{"Roskildevej", "M100", "orange"};

        allFields[7] = new String[]{"CHANCEKORTHER!!!", "M60", "sort"};
        //allFields[7] = new String[]{"Chance", "Tag et kort"};

        allFields[8] = new String[]{"Valby Langgade", "M100", "orange"};
        allFields[9] = new String[]{"Allégade", "M120", "orange"};
        allFields[10] = new String[]{"I fængsel", "På besøg"};
        allFields[11] = new String[]{"Frederiksberg Allé", "M140", "grøn"};
        allFields[12] = new String[]{"Tuborg bryggeri", "M150", "pink"};
        allFields[13] = new String[]{"Bülowsvej", "M140", "grøn"};
        allFields[14] = new String[]{"Gammel Kongevej", "M140", "grøn"};
        allFields[15] = new String[]{"D.F.D.S.", "M200", "lyseblå"};
        allFields[16] = new String[]{"Bernstorffsvej", "M180", "grå"};

        allFields[17] = new String[]{"CHANCEKORTHER!!!", "M60", "sort"};
        //allFields[17] = new String[]{"Chance", "Tag et kort"};

        allFields[18] = new String[]{"Hellerupvej", "M180", "grå"};
        allFields[19] = new String[]{"Strandvejen", "M180", "grå"};
        allFields[20] = new String[]{"Gratis", "Parkering"};
        allFields[21] = new String[]{"Trianglen", "M220", "rød"};

        allFields[22] = new String[]{"CHANCEKORTHER!!!", "M60", "sort"};
        //allFields[17] = new String[]{"Chance", "Tag et kort"};

        allFields[23] = new String[]{"Østerbro-gade", "M220", "rød"};
        allFields[24] = new String[]{"Grønningen", "M240", "rød"};
        allFields[25] = new String[]{"Ø.S. redderiet", "M200", "lyseblå"};
        allFields[26] = new String[]{"Bredgade", "M260", "hvid"};
        allFields[27] = new String[]{"Kgs. Nytorv", "M260", "hvid"};
        allFields[28] = new String[]{"Carlsberg bryggeri", "M150", "pink"};
        allFields[29] = new String[]{"Østergade", "M280", "hvid"};
        allFields[30] = new String[]{"Gå i fængsel", "fængsel"};
        allFields[31] = new String[]{"Amagertorv", "M300", "gul"};
        allFields[32] = new String[]{"Vimmel-skaftet", "M300", "gul"};

        allFields[33] = new String[]{"CHANCEKORTHER!!!", "M60", "sort"};
        //allFields[33] = new String[]{"Chance", "Tag et kort"};

        allFields[34] = new String[]{"Nygade", "M320", "gul"};
        allFields[35] = new String[]{"Bornholm redderi", "M200", "lyseblå"};

        allFields[36] = new String[]{"CHANCEKORTHER!!!", "M60", "sort"};
        //allFields[36] = new String[]{"Chance", "Tag et kort"};

        allFields[37] = new String[]{"Frederiksberggade", "M350", "lilla"};
        allFields[38] = new String[]{"Ekstra-ordinærstatsskat", "M100", ""};
        allFields[39] = new String[]{"Rådhuspladsen", "M400", "lilla"};

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

