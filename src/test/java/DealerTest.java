import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

        Hand dh = mock(Hand.class);
        when(dh.sum()).thenReturn(22);
        Hand ph = mock(Hand.class);
        when(ph.sum()).thenReturn(20);
        assertEquals(1, d1.winorlose(ph,dh));
    }
    @Test
    @DisplayName("Win - Player > Dealer - No Busts")
    void winorlose_winnorm(){
        Hand dh = mock(Hand.class);
        when(dh.sum()).thenReturn(18);
        Hand ph = mock(Hand.class);
        when(ph.sum()).thenReturn(20);
        assertEquals(1, d1.winorlose(ph,dh));
    }
    @Test
    @DisplayName("Lose - Player Bust")
    void winorlose_losebust(){
        Hand dh = mock(Hand.class);
        when(dh.sum()).thenReturn(17);
        Hand ph = mock(Hand.class);
        when(ph.sum()).thenReturn(22);
        assertEquals(0, d1.winorlose(ph,dh));
    }
    @Test
    @DisplayName("Lose - Player and Dealer Bust")
    void winorlose_losebothbust(){
        Hand dh = mock(Hand.class);
        when(dh.sum()).thenReturn(22);
        Hand ph = mock(Hand.class);
        when(ph.sum()).thenReturn(22);
        assertEquals(0, d1.winorlose(ph,dh));
    }
    @Test
    @DisplayName("Lose - Dealer > Player")
    void winorlose_losenorm(){
        Hand dh = mock(Hand.class);
        when(dh.sum()).thenReturn(21);
        Hand ph = mock(Hand.class);
        when(ph.sum()).thenReturn(20);
        assertEquals(0, d1.winorlose(ph,dh));
    }

    @Test
    @DisplayName("Tie")
    void winorlose_tie(){
        Hand dh = mock(Hand.class);
        when(dh.sum()).thenReturn(18);
        Hand ph = mock(Hand.class);
        when(ph.sum()).thenReturn(18);
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