import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class Main {
    public static void main(String[] args) throws InterruptedException {


        Dealer dealer = new Dealer();
        dealer.startGame();
        boolean cont = true;

        //Rounds
        while (cont) {
            dealer.newRound();
            System.out.println("Play another hand?");
            Scanner scanner = new Scanner(System.in);
            if (scanner.nextLine().equals("yes")) continue;
            else {
                cont = false;
            }
            TimeUnit.SECONDS.sleep(2);
        }

        //Final Standings
        dealer.endgame();
        System.out.println("Thank you for playing!");
        System.exit(1);
    }

}
