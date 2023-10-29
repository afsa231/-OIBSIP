import java.util.Scanner;
import java.util.Random;

public class Game {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String play = "yes";
        int r = 0, ts = 0, tries = 0;
        System.out.println();
        System.out.println("A number is chosen between 1 to 100. Guess the number within 3 tries");

        while (play.equals("yes")) {
            r++;
            int gs, i, k = 3, tri = 0, score = 3;
            Random ran = new Random();
            int num = ran.nextInt(100);
            
            for (i = 0; i < k; i++) {
                System.out.println("Guess the star number:");
                gs = sc.nextInt();
                if (num == gs) {
                    tri++;
                    System.out.println("Congratulations, that's the true star!!");
                    System.out.println("Tries: " + tri);
                    System.out.println("Score: " + score);
                    tries += tri;
                    ts += score;
                    System.out.println("Would you like to play again? (yes or no):");
                    play = sc.next().toLowerCase();
                    break;
                } else if (num > gs && i != k - 1) {
                    System.out.println("The number is greater than " + gs);
                    tri++;
                    score--;
                } else {
                    System.out.println("The number is less than " + gs);
                    tri++;
                    score--;
                }
            }
            
            if (i == k) {
                System.out.println("You have completed your tries");
                System.out.println("The star number was " + num);
                tries += tri;
                ts += score;
                System.out.println("Tries: " + tri);
                System.out.println("Score: " + score);
                System.out.println();
                System.out.print("Would you like to play again? (yes or no): ");
                play = sc.next().toLowerCase();
            }
        }
        
        System.out.println("\nRounds: " + r);
        System.out.println("Total tries: " + tries);
        System.out.println("Total score: " + ts);
    }
}
