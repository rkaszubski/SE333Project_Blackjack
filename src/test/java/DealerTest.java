import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DealerTest {

    Dealer d1 = new Dealer();



    @Test
    void verifyPlayerCount(){
        assertTrue(d1.verifyPlayerCount("3"));
        assertFalse(d1.verifyPlayerCount(null));
        assertFalse(d1.verifyPlayerCount(" "));
        assertFalse(d1.verifyPlayerCount("0"));
        assertFalse(d1.verifyPlayerCount("6"));
    }

    @Test
    @DisplayName("Win - Dealer bust")
    void winorlose_winbust(){
        Hand dh = new Hand();
        dh.add(new Card(Face.KING,Suit.DIAMONDS));
        dh.add(new Card(Face.KING,Suit.CLUBS));
        dh.add(new Card(Face.KING,Suit.HEARTS));
        Hand ph = new Hand();
        ph.add(new Card(Face.QUEEN,Suit.DIAMONDS));
        ph.add(new Card(Face.QUEEN,Suit.CLUBS));
        assertEquals(1, d1.winorlose(ph,dh));
    }
    @Test
    @DisplayName("Win - Player > Dealer - No Busts")
    void winorlose_winnorm(){
        Hand dh = new Hand();
        dh.add(new Card(Face.KING,Suit.DIAMONDS));
        dh.add(new Card(Face.SEVEN,Suit.CLUBS));
        Hand ph = new Hand();
        ph.add(new Card(Face.QUEEN,Suit.DIAMONDS));
        ph.add(new Card(Face.QUEEN,Suit.CLUBS));
        assertEquals(1, d1.winorlose(ph,dh));
    }
    @Test
    @DisplayName("Lose - Player Bust")
    void winorlose_losebust(){
        Hand dh = new Hand();
        dh.add(new Card(Face.KING,Suit.DIAMONDS));
        dh.add(new Card(Face.SEVEN,Suit.CLUBS));
        Hand ph = new Hand();
        ph.add(new Card(Face.QUEEN,Suit.DIAMONDS));
        ph.add(new Card(Face.QUEEN,Suit.CLUBS));
        ph.add(new Card(Face.QUEEN,Suit.HEARTS));
        assertEquals(0, d1.winorlose(ph,dh));
    }
    @Test
    @DisplayName("Lose - Player and Dealer Bust")
    void winorlose_losebothbust(){
        Hand dh = new Hand();
        dh.add(new Card(Face.KING,Suit.DIAMONDS));
        dh.add(new Card(Face.KING,Suit.CLUBS));
        dh.add(new Card(Face.KING,Suit.HEARTS));
        Hand ph = new Hand();
        ph.add(new Card(Face.QUEEN,Suit.DIAMONDS));
        ph.add(new Card(Face.QUEEN,Suit.CLUBS));
        ph.add(new Card(Face.QUEEN,Suit.HEARTS));
        assertEquals(0, d1.winorlose(ph,dh));
    }
    @Test
    @DisplayName("Lose - Dealer > Player")
    void winorlose_losenorm(){
        Hand dh = new Hand();
        dh.add(new Card(Face.KING,Suit.DIAMONDS));
        dh.add(new Card(Face.KING,Suit.CLUBS));
        Hand ph = new Hand();
        ph.add(new Card(Face.QUEEN,Suit.DIAMONDS));
        ph.add(new Card(Face.SEVEN,Suit.CLUBS));
        assertEquals(0, d1.winorlose(ph,dh));
    }

    @Test
    @DisplayName("Tie")
    void winorlose_tie(){
        Hand dh = new Hand();
        dh.add(new Card(Face.KING,Suit.DIAMONDS));
        dh.add(new Card(Face.KING,Suit.CLUBS));
        Hand ph = new Hand();
        ph.add(new Card(Face.QUEEN,Suit.DIAMONDS));
        ph.add(new Card(Face.QUEEN,Suit.CLUBS));
        assertEquals(2, d1.winorlose(ph,dh));
    }

    @Test
    @DisplayName("hit/stand- good inputs, should work with all capitalizations")
    void verifyHitStand() {
        assertEquals(true,d1.verifyHitStand("hit"));
        assertEquals(true,d1.verifyHitStand("HIT"));
        assertEquals(true,d1.verifyHitStand("HiT"));
        assertEquals(true,d1.verifyHitStand("STAND"));
        assertEquals(true,d1.verifyHitStand("stand"));
        assertEquals(true,d1.verifyHitStand("StAnD"));
    }
    @Test
    @DisplayName("hit/stand - null, empty string, int")
    void verifyHitStandBad(){
        assertEquals(false,d1.verifyHitStand(""));
        assertEquals(false,d1.verifyHitStand("1"));
        assertEquals(false,d1.verifyHitStand(null));
    }

    @Test
    @DisplayName("reveal winners test - won - check bet adjustment")
    void revealwinnerWon(){
        Player winner = new Player("bob",1000);
        ByteArrayInputStream in = new ByteArrayInputStream("50".getBytes());
        System.setIn(in);
        winner.setBet();
        d1.revealwinners(winner,1);
        assertEquals(1050, winner.getCash());
    }

    @Test
    @DisplayName("reveal winners test - lost - check bet adjustment")
    void revealwinnerLost(){
        Player player = new Player("bob",1000);
        ByteArrayInputStream in = new ByteArrayInputStream("50".getBytes());
        System.setIn(in);
        player.setBet();
        d1.revealwinners(player,0);
        assertEquals(950, player.getCash());
    }

    @Test
    @DisplayName("reveal winners test - tie - check bet adjustment")
    void revealwinnerTie(){
        Player player = new Player("bob",1000);
        ByteArrayInputStream in = new ByteArrayInputStream("50".getBytes());
        System.setIn(in);
        player.setBet();
        d1.revealwinners(player,2);
        assertEquals(1000, player.getCash());
    }
}