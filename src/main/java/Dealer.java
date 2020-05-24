import java.util.ArrayList;
import java.util.Scanner;

public class Dealer{

    private final ArrayList<Player> players;
    //private final ArrayList<boolean> stillin;

    private  Hand hand;
    private Deck deck;

    public Dealer(){
        this.players = new ArrayList<Player>();
        this.hand = new Hand();
    }

    public Boolean verifyPlayerCount(String input){
        int in;
        try{
            in = Integer.valueOf(input);
            if(in <= 0){
                System.out.println("Your input must be greater than 0");
                return false;
            }
            else if(in > 5){
                System.out.println("Your input must be 5 or less");
                return false;
            }

            return true;

            }
        catch (Exception e){
            System.out.println("Your input must be an integer value");
            return false;
        }
    }

    public void addPlayer(String name){
        players.add(new Player(name, 1000));
    }

    public void startGame(){
        Scanner scanner = new Scanner(System.in);
        String name;
        String in;

        System.out.println("How many players?");
        in = (scanner.nextLine());
        while (!verifyPlayerCount(in)){
            in = (scanner.nextLine());
        }
        int input = Integer.valueOf(in);
        int playernum = 1;
        while (input > 0){
            System.out.println("What is Player #" + playernum +"'s name?");
            name = scanner.nextLine();
            addPlayer(name);
            playernum++;
            input--;
        }
    }

    public void newDeck(){
        deck = new Deck();
        deck.shuffleDeck();
    }

    public void dealCards(ArrayList<Player> players){

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
    }


    public void newRound(){
        System.out.println("Place your bets!");
        for(Player player : players){
            player.setBet();
        }
        System.out.println("All bets are locked in");
        System.out.println("Dealing Cards!");
        newDeck();
        dealCards(players);

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
            int result = winorlose(player.getHand(),hand);
            if (result == 0){
                System.out.println(player.getName() + " lost!");
                System.out.println(player.getName() + "'s new balance is " + player.getCash());
            }
            else if(result == 1){
                System.out.println(player.getName() + " won!");
                player.adjustCash(player.getBet()*2);
                System.out.println(player.getName() + "'s new balance is " + player.getCash());
            }
            else if(result == 2){
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

    public int winorlose(Hand playerhand, Hand dealerhand){
        //if player wins returns 1
        //if player loses returns 0
        //if player ties returns 2
        int playersum = playerhand.sum();
        int dealersum = dealerhand.sum();
        if(playersum > 21){
            return 0;
        }
        else if(dealersum> 21){
            return 1;
        }
        else if(playersum > dealersum){
            return 1;
        }
        else if(playersum < dealersum){
            return 0;
        }
        else if(playersum == dealersum){
            return 2;
        }
        return 0;

    }

    public void endgame(){
        System.out.println("The final standings are:");
        for(Player player : players){
            System.out.println(player.getName() + " - $" + player.getCash());
        }
    }







}
