import java.util.ArrayList;

public class Hand {
    private final ArrayList<Card> cards;
    private int count;

    public Hand(){
        this.cards = new ArrayList<Card>();
        this.count = 0;
    }

    public void add(Card card){
        cards.add(card);
        count++;
    }

    public int sum(){
        int cardsum = 0;
        int aces = 0;
        for (Card card : cards) {
            cardsum = cardsum + card.getFace().getVal();
            if (cardsum > 21 && aces > 0) {
                cardsum = cardsum - 11 + 1;
            }
        }
        return cardsum;
    }
    public Card getDealerCard(){
        return cards.get(0);
    }

    @Override
    public String toString(){
        String out = "Hand: ";
        for (Card card : cards){
            out = out + card.toString() + " / ";
        }
        return out;
    }
}
