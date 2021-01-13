package Fields;

import Player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JailTest {

    @Test
    void landOnField() {
        Player[] players = new Player[]{new Player("tester")};
        players[0].setSpecificPosition(7);
        System.out.println(players[0].getSpecificPosition());

        players[0].setInJail(false);
        System.out.println(players[0].getInJail());
    }

}