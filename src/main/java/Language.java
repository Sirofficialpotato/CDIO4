//Class that takes care of language support by returning the array that holds the wanted language
public class Language {

    String lang;
    //array that stores string in danish
    String[] dk = {"Indtast antallet af spillere fra 3-6", "Prøv igen i intervallet 3-6", "Indtast navn til spiller ", " vælg venligst en farve til din bil som ingen andre har",
            "RØD", "SORT", "BLÅ", "MAGENTA", "ROSE", "CYAN", "GUL", "HVID", " har 0M og taber spillet", "Og vinderen er ... "," tryk på knappen for at kaste terningen!",
            "Kast", "Spil igen?", "Ja!", "Nej!", "To spillere med samme navn er ikke tilladt! Prøv igen spiller ", " er i fængsel", " bruger sit fængselskort og løslades uden omkostninger"
            ,": Bilen", ": Skibet", ": Katten", ": Hunden", "Lad venligst yngste spiller indtaste sit navn først"};

    //array that store strings in english
    String[] eng = {"Enter the number of players ranging from 2-4", "Please try again in the range of 2-4", "Enter name for player ", " choose a color for your car which noone else has",
            "RED", "BLACK", "BLUE","MAGENTA","PINK","CYAN","YELLOW","WHITE", " has reached 0 and lost the game", "And the winner is...  ", " press button to roll the die!",
            "Roll", "Play Again?", "Yes!", "No!", "Two players with the same name isn't allowed! Try again player ", " is in jail and pays 1M to get released", " uses their jailcard and gets released for free"
            ,": The Car" , ": The Ship", ": The Cat", ": The Dog", "Please let the youngest player enter their name first"};


    public Language(String lang) {
        this.lang = lang;
    }
    //Method that takes in a language choice as a string and returns the correct string array to display console text
    public String[] returnLang() {
        return switch (this.lang) {
            case "WIP English" -> this.eng;
            case "Dansk" -> this.dk;
            default -> this.dk;
        };

    }

}