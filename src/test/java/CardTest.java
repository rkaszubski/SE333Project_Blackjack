import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Test to make sure two cards are compared properly in terms of suit and face - no two cards should have the same in a deck")
    void CompareTo(Card one, Card other, boolean outcome){
        assertEquals(outcome, one.CompareTo(other));}
    private static Stream<Arguments> args(){
        return Stream.of(
                //different suit same face
                Arguments.of(new Card(Face.ACE, Suit.DIAMONDS), new Card(Face.ACE, Suit.CLUBS), false),
                Arguments.of(new Card(Face.ACE, Suit.DIAMONDS), new Card(Face.ACE, Suit.HEARTS), false),
                Arguments.of(new Card(Face.ACE, Suit.DIAMONDS), new Card(Face.ACE, Suit.SPADES), false),
                Arguments.of(new Card(Face.ACE, Suit.DIAMONDS), new Card(Face.ACE, Suit.DIAMONDS), true),
                //same suit different face
                Arguments.of(new Card(Face.FIVE, Suit.DIAMONDS), new Card(Face.FIVE, Suit.DIAMONDS), true),
                Arguments.of(new Card(Face.FIVE, Suit.DIAMONDS), new Card(Face.SIX, Suit.DIAMONDS), false),
                Arguments.of(new Card(Face.FIVE, Suit.DIAMONDS), new Card(Face.SEVEN, Suit.DIAMONDS), false),
                Arguments.of(new Card(Face.FIVE, Suit.DIAMONDS), new Card(Face.EIGHT, Suit.DIAMONDS),false)
        );
    }
}