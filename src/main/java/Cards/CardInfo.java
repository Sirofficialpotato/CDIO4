package Cards;


import java.lang.reflect.Array;

public class CardInfo<T> {

    private String[] text;
    private int[] values;
    private Object[][] cardInfo;

    public CardInfo(){
        this.cardInfo = new Object[][]{
                {//Prisen stiger
                        "Priser stiger: Oliepriserne er steget, og De skal betale kr 500 pr hus og kr 2000 pr hotel",
                        "Priser stiger: Ejendomsskatten er steget. Ekstraudgifterne er: 800 kr pr hus, 2300 kr pr hotel.",
                        //Betal penge til banken
                        "Betal penge til banken: De har kørt frem for “fuldt stop”, Betal 1000 kroner i bøde",
                        "Betal penge til banken: Betal for vognvask og smøring kr 300",
                        "Betal penge til banken: Betal kr 200 for levering af 2 kasser øl",
                        "Betal penge til banken: Betal 3000 for reparation af deres vogn",
                        "Betal penge til banken: Betal 3000 for reparation af deres vogn",
                        "Betal penge til banken: De har købt 4 nye dæk til Deres vogn, betal kr 1000",
                        "Betal penge til banken: De har fået en parkeringsbøde, betal kr 200 i bøde",
                        "Betal penge til banken: Betal deres bilforsikring, kr 1000",
                        "Betal penge til banken: De har været udenlands og købt for mange smøger, betal kr 200 i told.",
                        "Betal penge til banken: Tandlægeregning, betal kr 2000.",

                        //Modtag penge !!!!I GANG HER!!!!
                        "Modtag penge: De har vundet i klasselotteriet. Modtag 500 kr.",
                        "Modtag penge: De har vundet i klasselotteriet. Modtag 500 kr.",
                        "Modtag penge: De modtager Deres aktieudbytte. Modtag kr 1000 af banken",
                        "Modtag penge: De modtager Deres aktieudbytte. Modtag kr 1000 af banken",
                        "Modtag penge: De modtager Deres aktieudbytte. Modtag kr 1000 af banken",
                        "Modtag penge: Kommunen har eftergivet et kvartals skat. Hæv i banken 3000 kr.",
                        "Modtag penge: De have en række med elleve rigtige i tipning, modtag kl 1000",
                        "Modtag penge: Grundet dyrtiden har De fået gageforhøjelse, modtag kr 1000.",
                        "Modtag penge: Deres præmieobligation er udtrykket. De modtager 1000 kr af banken.",
                        "Modtag penge: Deres præmieobligation er udtrykket. De modtager 1000 kr af banken.",
                        "Modtag penge: De har solg nogle gamle møbler på auktion. Modtag 1000 kr af banken.",
                        "Modtag penge: Værdien af egen avl fra nyttehaven udgør 200 som de modtager af banken",
                        //Implementeres først efter samlet værdi kan udregnes
                        "Modtag penge: De modtager “Matador-legatet” på kr 40.000, men kun hvis værdier ikke overstiger 15.000 kr",

                        //Få penge fra spillere
                        "Få penge fra spillere: Det er deres fødselsdag. Modtag af hver medspiller 200 kr.",
                        "Få penge fra spillere: De har lagt penge ud til et sammenskudsgilde. Mærkværdigvis betaler alle straks. Modtag fra hver medspiller 500 kr.",
                        "Få penge fra spillere: De skal holde familiefest og får et tilskud fra hver medspiller på 500 kr.",
                        //    Ryk felt
                        "Ryk felt: Ryk frem til START",
                        "Ryk felt: Ryk frem til START",
                        "Ryk felt: Ryk tre felter frem",
                        "Ryk felt: Ryk tre felter tilbage",
                        "Ryk felt: Ryk tre felter tilbage",
                        "Ryk felt: Ryk frem til Frederiksberg Allé. Hvis De passere START, indkasser da 4000 kr.",
                        "Ryk felt: Ryk frem til det nærmeste rederi og betal ejeren to gange den leje han ellers er berettiget til, hvis selskabet ikke ejes af nogen kan De købe det af banken.",
                        "Ryk felt: Tag med Mols-Linien, flyt brikken frem og hvis De passerer START indkassér da kr 4000.",
                        "Ryk felt: Ryk frem til Grønningen, hvis De passerer start indkasser da kr 4000",
                        "Ryk felt: Ryk frem til Vimmelskaftet, hvis de passerer start indkasser da kr 4000",
                        "Ryk felt: Tag med den nærmeste færge, hvis de passerer start indkasser da kr 4000",
                        "Ryk felt: Ryk frem til Strandvejen. Hvis De passere START, indkasser da 4000 kr.",
                        "Ryk felt: Tag til Rådhuspladsen ",
                        //Noget med fængsel
                        "Noget med fængsel: I anledning af kongens fødselsdag benådes De herved for fængsel. Dette kort kan opbevares indtil De får brug for det, eller De kan sælge det.",
                        "Noget med fængsel: I anledning af kongens fødselsdag benådes De herved for fængsel. Dette kort kan opbevares indtil De får brug for det, eller De kan sælge det.",
                        "Noget med fængsel: Gå i fængsel, De indkasserer ikke 4000 kr for at passere start.",
                        "Noget med fængsel: Gå i fængsel, De indkasserer ikke 4000 kr for at passere start."},

                //Value for the field (price, field etc.)
                {500, 800,
                        1000, 300, 200, 3000, 3000, 1000, 200, 1000, 200, 2000,
                        500, 500, 1000, 1000, 1000, 3000, 1000, 1000, 1000, 1000, 1000, 200, 40000,
                        200, 500, 500,
                        0, 0, 3, -3, -3, 37, 404, 15, 24, 32, 404, 19, 39},
                //Extra value for priceIncrease fields
                {2000, 2300},
                //Used for MoveToField. True means it is a relative position
                {false, false, true, true, true, false, true, false, false, false, true, false, false}};


        this.text =
                new String[]{
                        //Priser stiger
                        "Priser stiger: Oliepriserne er steget, og De skal betale kr 500 pr hus og kr 2000 pr hotel",
                        "Priser stiger: Ejendomsskatten er steget. Ekstraudgifterne er: 800 kr pr hus, 2300 kr pr hotel.",
                        //Betal penge til banken
                        "Betal penge til banken: De har kørt frem for “fuldt stop”, Betal 1000 kroner i bøde",
                        "Betal penge til banken: Betal for vognvask og smøring kr 300",
                        "Betal penge til banken: Betal kr 200 for levering af 2 kasser øl",
                        "Betal penge til banken: Betal 3000 for reparation af deres vogn (antal kort: 2)",
                        "Betal penge til banken: De har købt 4 nye dæk til Deres vogn, betal kr 1000",
                        "Betal penge til banken: De har fået en parkeringsbøde, betal kr 200 i bøde",
                        "Betal penge til banken: Betal deres bilforsikring, kr 1000",
                        "Betal penge til banken: De har været udenlands og købt for mange smøger, betal kr 200 i told.",
                        "Betal penge til banken: Tandlægeregning, betal kr 2000.",
                        //Modtag penge
                        "Modtag penge: De har vundet i klasselotteriet. Modtag 500 kr. (Antal kort: 2)",
                        "Modtag penge: De modtager Deres aktieudbytte. Modtag kr 1000 af banken (antal: 3)",
                        "Modtag penge: Kommunen har eftergivet et kvartals skat. Hæv i banken 3000 kr.",
                        "Modtag penge: De have en række med elleve rigtige i tipning, modtag kl 1000",
                        "Modtag penge: Grundet dyrtiden har De fået gageforhøjelse, modtag kr 1000.",
                        "Modtag penge: Deres præmieobligation er udtrykket. De modtager 1000 kr af banken. (antal 2)",
                        "Modtag penge: De har solg nogle gamle møbler på auktion. Modtag 1000 kr af banken.",
                        "Modtag penge: Værdien af egen avl fra nyttehaven udgør 200 som de modtager af banken",
                        "Modtag penge: De modtager “Matador-legatet” på kr 40.000, men kun hvis værdier ikke overstiger 15.000 kr",
                        //Få penge fra spillere
                        "Få penge fra spillere: Det er deres fødselsdag. Modtag af hver medspiller 200 kr.",
                        "Få penge fra spillere: De har lagt penge ud til et sammenskudsgilde. Mærkværdigvis betaler alle straks. Modtag fra hver medspiller 500 kr.",
                        "Få penge fra spillere: De skal holde familiefest og får et tilskud fra hver medspiller på 500 kr.",
                        //    Ryk felt
                        "Ryk felt: Ryk frem til START (antal 2)",
                        "Ryk felt: Ryk tre felter frem",
                        "Ryk felt: Ryk tre felter tilbage (Antal kort: 2)",
                        "Ryk felt: Ryk frem til Frederiksberg Allé. Hvis De passere START, indkasser da 4000 kr.",
                        "Ryk felt: Ryk frem til det nærmeste rederi og betal ejeren to gange den leje han ellers er berettiget til, hvis selskabet ikke ejes af nogen kan De købe det af banken.(Antal 2)",
                        "Ryk felt: Tag med Mols-Linien, flyt brikken frem og hvis De passerer START indkassér da kr 4000.",
                        "Ryk felt: Ryk frem til Grønningen, hvis De passerer start indkasser da kr 4000",
                        "Ryk felt: Ryk frem til Vimmelskaftet, hvis de passerer start indkasser da kr 4000",
                        "Ryk felt: Tag med den nærmeste færge, hvis de passerer start indkasser da kr 4000",
                        "Ryk felt: Ryk frem til Strandvejen. Hvis De passere START, indkasser da 4000 kr.",
                        "Ryk felt: Tag til Rådhuspladsen ",
                        //Noget med fængsel
                        "Noget med fængsel: I anledning af kongens fødselsdag benådes De herved for fængsel. Dette kort kan opbevares indtil De får brug for det, eller De kan sælge det. (antal kort: 2)",
                        "Noget med fængsel: Gå i fængsel, De indkasserer ikke 4000 kr for at passere start. (antal kort: 2)"
                };



    }


    public String[] getText()
    {
        return this.text;
    }
    public Object[][] getCardInfo(){
        return this.cardInfo;
    }
}
