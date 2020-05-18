import org.junit.jupiter.api.Test;

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
    void setBet() {
    }

    @Test
    void getBet() {
    }
}