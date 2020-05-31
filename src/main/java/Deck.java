import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private final ArrayList<Card> cards;
    private int size;
    private boolean isEmpty;

    public Deck(){
        cards = new ArrayList<Card>();
        for (Suit suit : Suit.values()){
            for(Face face : Face.values()){
                cards.add(new Card(face,suit));
                size = size + 1;
            }
        }
        isEmpty = false;
    }

    public int getSize(){
        return size;
    }


    public void shuffleDeck(){
        Collections.shuffle(cards);
    }

    public Card drawCard(){
        size--;
        if(size == 0) isEmpty = true;
        return cards.remove(0);
    }

    public boolean getisEmpty(){
        return isEmpty;
    }
}
