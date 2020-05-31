import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Main {
    public static boolean verifyYesNo(String input){
        if(input instanceof String){
            input = input.toLowerCase();
            if(input.equals("yes") || input.equals("no")) return true;
            else{
                System.out.println("invalid input");
                return false;
            }
        }
        System.out.println("invalid input");
        return false;
    }

    public static void main(String[] args) throws InterruptedException {


        Dealer dealer = new Dealer();
        dealer.startGame();
        boolean cont = true;

        //Rounds
        while (cont) {
            dealer.newRound();
            System.out.println("Play another hand? yes/no");
            Scanner scanner = new Scanner(System.in, "UTF-8");
            String in = (scanner.nextLine());
            while (!verifyYesNo(in)){
                in = (scanner.nextLine());
            }
            if (in.toLowerCase().equals("yes")) continue;
            else {
                cont = false;
            }
            TimeUnit.SECONDS.sleep(2);
        }

        //Final Standings
        dealer.endgame();
        System.out.println("Thank you for playing!");

    }

}
