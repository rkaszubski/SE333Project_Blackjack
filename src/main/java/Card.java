public class Card {
    private final Suit suit;
    private final Face face;

    public Card(Face face, Suit suit){
        this.face = face;
        this.suit = suit;
    }

    public Suit getSuit() {
        return suit;
    }

    public Face getFace() {
        return face;
    }

    @Override
    public String toString() {
        return face + " of " + suit;
    }

    public boolean CompareTo(Card other){
        if(this.face == other.face){
            if(this.suit == other.suit){
                return true;
            }
        }
        return false;
    }
}
