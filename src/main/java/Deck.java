import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private final ArrayList<Card> cards;
    private int size;

    public Deck(){
        cards = new ArrayList<Card>();
        for (Suit suit : Suit.values()){
            for(Face face : Face.values()){
                cards.add(new Card(face,suit));
                size = size + 1;
            }
        }
    }

    public int getSize(){
        return size;
    }


    public void shuffleDeck(){
        Collections.shuffle(cards);
    }

    public Card drawCard(){
        size--;
        return cards.remove(0);
    }
}
