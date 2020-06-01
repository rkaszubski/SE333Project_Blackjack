import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Proper Values - All faces and corresponding values work")
    void sums(Card one, Card two, int total){
        Hand h = new Hand();
        h.add(one);
        h.add(two);
        assertEquals(total,h.sum());
    }
    private static Stream<Arguments> args(){
        return Stream.of(
                Arguments.of(new Card(Face.ACE, Suit.DIAMONDS), new Card(Face.ACE, Suit.HEARTS), 12),
                Arguments.of(new Card(Face.TWO, Suit.DIAMONDS), new Card(Face.TWO, Suit.HEARTS), 4),
                Arguments.of(new Card(Face.THREE, Suit.DIAMONDS), new Card(Face.THREE, Suit.HEARTS), 6),
                Arguments.of(new Card(Face.FOUR, Suit.DIAMONDS), new Card(Face.FOUR, Suit.HEARTS), 8),
                Arguments.of(new Card(Face.FIVE, Suit.DIAMONDS), new Card(Face.FIVE, Suit.HEARTS), 10),
                Arguments.of(new Card(Face.SIX, Suit.DIAMONDS), new Card(Face.SIX, Suit.HEARTS), 12),
                Arguments.of(new Card(Face.SEVEN, Suit.DIAMONDS), new Card(Face.SEVEN, Suit.HEARTS), 14),
                Arguments.of(new Card(Face.EIGHT, Suit.DIAMONDS), new Card(Face.EIGHT, Suit.HEARTS),16),
                Arguments.of(new Card(Face.NINE, Suit.DIAMONDS), new Card(Face.NINE, Suit.HEARTS),18),
                Arguments.of(new Card(Face.TEN, Suit.DIAMONDS), new Card(Face.TEN, Suit.HEARTS),20),
                Arguments.of(new Card(Face.JACK, Suit.DIAMONDS), new Card(Face.JACK, Suit.HEARTS),20),
                Arguments.of(new Card(Face.QUEEN, Suit.DIAMONDS), new Card(Face.QUEEN, Suit.HEARTS),20),
                Arguments.of(new Card(Face.KING, Suit.DIAMONDS), new Card(Face.KING, Suit.HEARTS),20)

        );
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
        Hand h = new Hand();
        Card c = new Card(Face.SEVEN, Suit.DIAMONDS);
        h.add(c);
        Card c2 = new Card(Face.SIX, Suit.DIAMONDS);
        h.add(c2);
        assertEquals(h.getDealerCard(),c);
    }

    @Test
    void testToString() {
        Hand h = new Hand();
        Card c = new Card(Face.SEVEN, Suit.DIAMONDS);
        h.add(c);
        assertEquals(h.toString(), "Hand: SEVEN of DIAMONDS / ");
        Card c2 = new Card(Face.SIX, Suit.DIAMONDS);
        h.add(c2);
        assertEquals(h.toString(), "Hand: SEVEN of DIAMONDS / SIX of DIAMONDS / ");
    }
}