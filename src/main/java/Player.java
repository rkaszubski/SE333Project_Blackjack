import java.util.ArrayList;
import java.util.Scanner;

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

    public Boolean verifyBet(String input){
        int in;
        try{
            in = Integer.parseInt(input);
            if(in <= 0){
                System.out.println("Your bet must be more than $0");
                return false;

            }
            else if(in > cash){
                System.out.println("Your bet cannot be more than your available cash");
                return false;

            }
            else{
                return true;
            }
        }
        catch (Exception e){
            System.out.println("Your bet must be an integer value");
            return false;
        }
    }

    public void setBet(){
        Scanner scanner = new Scanner(System.in, "UTF-8");
        System.out.println(name + ", How much would you like to bet? Your balance is " + cash);

        String input = (scanner.nextLine());

        while (!verifyBet(input)){
            input = (scanner.nextLine());
        }
        int in = Integer.parseInt(input);

        bet = in;
        adjustCash(-bet);
    }

    public int getBet(){ return bet;}


}
