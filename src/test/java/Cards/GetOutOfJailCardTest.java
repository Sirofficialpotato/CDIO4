package Cards;

import Fields.Field;
import Fields.FieldChance;
import Player.Player;
import org.junit.jupiter.api.Test;
//kort 10 er fængselskort

class GetOutOfJailCardTest {

    @Test
    void drawCard() {
        Player[] players = new Player[]{new Player("test1"), new Player("test2"), new Player("test3"), new Player("test4")};
        System.out.println("Du har jailkort");
        System.out.println(players[0].getJailCard());
        //DynamicArr<JailInteractions> choiceCards = new DynamicArr<JailInteractions>();
        JailInteractions jailCard = new JailInteractions("Noget med fængsel: I anledning af kongens fødselsdag benådes De herved for fængsel. Dette kort kan opbevares indtil De får brug for det, eller De kan sælge det.",1);
        jailCard.drawCard(players[0]);
        System.out.println("Du har jailkort");
        System.out.println(players[0].getJailCard());

    }
}