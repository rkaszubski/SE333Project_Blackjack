import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    Deck deck = new Deck();

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
    @DisplayName("Test to make sure each card is different in a deck")
    void uniqueCards(){
        ArrayList<Card> cards = new ArrayList<Card>();
        for(int i = 0; i<52; i++){
            cards.add(deck.drawCard());
        }
        assertTrue(deck.getisEmpty());
        for(int i = 0; i<52; i++){
            for(int j = 0; i <52; i++){
                if(j!=i)assertFalse(cards.get(i).CompareTo(cards.get(j)));
            }
        }
    }
}