import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    //Sample test file
    @Test
    void getSuit() {
        Card card = new Card(Face.ACE, Suit.DIAMONDS);
        Suit suit = card.getSuit();
        assertEquals(suit, Suit.DIAMONDS);
        Card card2 = new Card(Face.ACE, Suit.CLUBS);
        Card card3 = new Card(Face.FOUR, Suit.DIAMONDS);
        assertEquals(suit, card3.getSuit());
        assertNotEquals(suit,card2.getSuit());
    }

    @Test
    void getFace() {
        Card card = new Card(Face.ACE, Suit.DIAMONDS);
        Face face = card.getFace();
        assertEquals(face, Face.ACE);
        Card card2 = new Card(Face.ACE, Suit.CLUBS);
        Card card3 = new Card(Face.FOUR, Suit.DIAMONDS);
        assertEquals(face, card2.getFace());
        assertNotEquals(face,card3.getFace());
    }
}