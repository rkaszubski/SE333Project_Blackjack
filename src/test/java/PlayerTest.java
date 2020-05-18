import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player p = new Player("Bob",1000);

    @Test
    void getName() {
        assertEquals("Bob",p.getName());
    }

    @Test
    void getHand() {
        Hand expect = new Hand();
        assertEquals(expect.toString(),p.getHand().toString());
        expect.add(new Card(Face.ACE,Suit.DIAMONDS));
        p.getHand().add(new Card(Face.ACE,Suit.DIAMONDS));
        assertEquals(expect.toString(),p.getHand().toString());
    }

    @Test
    void clearHand() {
        Hand expect = new Hand();
        p.getHand().add(new Card(Face.ACE,Suit.DIAMONDS));
        p.clearHand();
        assertEquals(expect.toString(),p.getHand().toString());

    }

    @Test
    void getCash() {
        assertEquals(p.getCash(),1000);
    }

    @Test
    void adjustCashPos() {
        p.adjustCash(50);
        assertEquals(1050,p.getCash());
    }

    @Test
    void adjustCashNeg() {
        p.adjustCash(-50);
        assertEquals(950,p.getCash());
    }

    @Test
    @DisplayName("Good bet value")
    void verifyBet() {
        assertTrue(p.verifyBet("100"));
    }
    @Test
    @DisplayName("Bad bet value - Non Integer")
    void verifyBetNonInt() {
        assertFalse(p.verifyBet("Hello"));
    }

    @Test
    @DisplayName("Bad bet value - boundary test")
    void verifyBetBad() {
        assertFalse(p.verifyBet("0"));
        assertTrue(p.verifyBet("1"));
        assertFalse(p.verifyBet("-1"));
        assertFalse(p.verifyBet("-100"));
        assertFalse(p.verifyBet("1001"));
        assertTrue(p.verifyBet("1000"));
    }
}