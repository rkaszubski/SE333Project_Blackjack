import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    void add() {
        Hand h = new Hand();
        Card c = new Card(Face.SEVEN, Suit.DIAMONDS);
        h.add(c);
        assertEquals(c,h.get(0));
        Card c2 = new Card(Face.SIX, Suit.DIAMONDS);
        h.add(c2);
        assertEquals(c2,h.get(1));
    }

    @Test
    void sum() {
        Hand h = new Hand();
        Card c = new Card(Face.SEVEN, Suit.DIAMONDS);
        Card c2 = new Card(Face.SIX, Suit.DIAMONDS);
        h.add(c);
        h.add(c2);
        assertEquals(13,h.sum());
    }
    @Test
    @DisplayName("Sum with Ace as 11")
    void sumAce() {
        Hand h = new Hand();
        Card c = new Card(Face.SEVEN, Suit.DIAMONDS);
        Card c2 = new Card(Face.ACE, Suit.DIAMONDS);
        h.add(c);
        h.add(c2);
        assertEquals(18,h.sum());

    }
    @Test
    @DisplayName("Sum with Ace as 1")
    void sumAceOne() {
        Hand h = new Hand();
        Card c = new Card(Face.SEVEN, Suit.DIAMONDS);
        Card c2 = new Card(Face.SIX, Suit.DIAMONDS);
        Card c3 = new Card(Face.ACE, Suit.DIAMONDS);
        h.add(c);
        h.add(c2);
        assertEquals(13,h.sum());
        h.add(c3);
        assertEquals(14,h.sum());
    }

    @Test
    @DisplayName("Sum with Multiple Aces as 1 and 11")
    void sumMultiAce() {
        Hand h = new Hand();
        Card c = new Card(Face.ACE, Suit.HEARTS);
        Card c2 = new Card(Face.ACE, Suit.CLUBS);
        Card c3 = new Card(Face.ACE, Suit.DIAMONDS);
        Card c4 = new Card(Face.ACE, Suit.SPADES);
        h.add(c);
        assertEquals(11,h.sum());
        h.add(c2);
        assertEquals(12,h.sum());
        h.add(c3);
        assertEquals(13,h.sum());
        h.add(c4);
        assertEquals(14,h.sum());
    }

    @Test
    void getDealerCard() {
    }

    @Test
    void testToString() {
    }
}