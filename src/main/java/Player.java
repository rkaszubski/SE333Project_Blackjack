import java.util.ArrayList;

public class Player {
    private final String name;

    private Hand hand;

    private int cash;

    private int bet;

    public Player(String name, int cash){
        this.name = name;
        this.hand = new Hand();
        this.cash = cash;
        this.bet = 0;
    }

    public String getName(){
        return name;
    }

    public Hand getHand(){
        return hand;
    }

    public void clearHand(){
        hand = new Hand();
        bet = 0;
    }

    public int getCash(){
        return cash;
    }

    public void adjustCash(int val){
        cash += val;
    }

    public void setBet(int betting){
        bet = betting;
    }

    public int getBet(){ return bet;}


}
