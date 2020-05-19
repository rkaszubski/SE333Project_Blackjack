import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    Deck deck = new Deck();

    @Test
    void shuffleDeck() {
    }

    @Test
    void drawCard() {
        assertEquals(deck.getSize(), 52);
        deck.drawCard();
        assertEquals(deck.getSize(), 51);
        deck.drawCard();
        deck.drawCard();
        assertEquals(deck.getSize(), 49);
    }
    @Test
    void uniqueCards(){
        ArrayList<Card> cards = new ArrayList<Card>();
    }
}