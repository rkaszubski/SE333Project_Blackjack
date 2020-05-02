import java.util.ArrayList;
import java.util.Scanner;

public class Dealer{

    private final ArrayList<Player> players;
    //private final ArrayList<boolean> stillin;

    private  Hand hand;

    public Dealer(){
        this.players = new ArrayList<Player>();
        this.hand = new Hand();
    }
    public void startGame(){
        Scanner scanner = new Scanner(System.in);
        String name;
        int input;

        System.out.println("How many players?");
        input = Integer.valueOf(scanner.nextLine());
        int playernum = 1;
        while (input > 0){
            System.out.println("What is Player #" + playernum +"'s name?");
            name = scanner.nextLine();
            players.add(new Player(name,1000));
            playernum++;
            input--;
        }
    }

    public void newRound(){
        System.out.println("Place your bets!");
        for(Player player : players){
            Scanner scanner = new Scanner(System.in);
            System.out.println(player.getName() + ", How much would you like to bet? Your balance is " + player.getCash());
            int input = Integer.valueOf(scanner.nextLine());
            player.setBet(input);
            player.adjustCash(-player.getBet());
        }
        System.out.println("All bets are locked in");
        System.out.println("Dealing Cards!");
        Deck deck = new Deck();
        deck.shuffleDeck();

        for(Player player : players){
            player.getHand().add(deck.drawCard());
        }
        hand.add(deck.drawCard());
        for(Player player : players){
            player.getHand().add(deck.drawCard());
        }
        hand.add(deck.drawCard());
        for(Player player : players){
            System.out.println(player.getName() + "'s " + player.getHand().toString());
            System.out.println(player.getHand().sum());
        }
        System.out.println("Dealer's Hand: " + hand.getDealerCard() + " / HIDDEN");

        //Hit or Stand
        for(Player player : players){
            boolean stand = false;
            while(player.getHand().sum()<22 && !stand){
                Scanner scanner = new Scanner(System.in);
                System.out.println(player.getName() + ", Would you like to hit or stand?");
                String input = scanner.nextLine();

                if(input.equals("hit")){
                    player.getHand().add(deck.drawCard());
                }
                if(input.equals("stand")){
                    stand = true;
                }
                System.out.println(player.getName() + "'s " + player.getHand().toString());
                System.out.println(player.getHand().sum());
            }
        }
        //All players done
        //Dealer's turn
        System.out.println("Revealing Dealer's Cards");
        System.out.println(hand.toString());
        System.out.println(hand.sum());
        while(hand.sum()<17){
            hand.add(deck.drawCard());
            System.out.println("Dealer must hit");
            System.out.println(hand.toString());
            System.out.println(hand.sum());
        }

        //Reveal winners
        for(Player player : players){
            int playersum = player.getHand().sum();
            if(playersum > 21){
                System.out.println(player.getName() + " has busted!");
                System.out.println(player.getName() + "'s new balance is " + player.getCash());
            }
            else if(hand.sum()> 21){
                System.out.println(player.getName() + " won! Dealer Busted!");
                player.adjustCash(player.getBet()*2);
                System.out.println(player.getName() + "'s new balance is " + player.getCash());
            }
            else if(playersum > hand.sum()){
                System.out.println(player.getName() + " won!");
                player.adjustCash(player.getBet()*2);
                System.out.println(player.getName() + "'s new balance is " + player.getCash());
            }
            else if(playersum < hand.sum()){
                System.out.println(player.getName() + " lost!");
                System.out.println(player.getName() + "'s new balance is " + player.getCash());
            }
            else if(playersum == hand.sum()){
                System.out.println(player.getName() + " tied!");
                player.adjustCash(player.getBet());
                System.out.println(player.getName() + "'s new balance is " + player.getCash());
            }
        }

        //Clear Hands
        for(Player player: players){
            player.clearHand();

        }
        hand = new Hand();

    }

    public void endgame(){
        System.out.println("The final standings are:");
        for(Player player : players){
            System.out.println(player.getName() + " - $" + player.getCash());
        }
    }







}
