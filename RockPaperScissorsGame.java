import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {
    private static final String ROCK = "Rock";
    private static final String PAPER = "Paper";
    private static final String SCISSORS = "Scissors";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("If you want to stop playing the game type \"STOP\"\n");
        System.out.print("Choose [r]ock, [p]aper or [s]cissors: \n");
        String playerMove = scanner.nextLine();

        int computerVictories = 0;
        int playerVictories = 0;
        int draws = 0;
        while (!playerMove.equalsIgnoreCase("STOP")){
            if (playerMove.equalsIgnoreCase("r") || playerMove.equalsIgnoreCase("rock")){
                playerMove= ROCK;
            } else if (playerMove.equalsIgnoreCase("p") || playerMove.equalsIgnoreCase("paper")) {
                playerMove= PAPER;
            } else if (playerMove.equalsIgnoreCase("s") || playerMove.equalsIgnoreCase("scissors")) {
                playerMove= SCISSORS;
            }else {
                System.out.println("Invalid input.Try again.");
                continue;
            }

            Random random = new Random();
            int computerRandomNumber = random.nextInt(3);

            String computerMove = switch (computerRandomNumber) {
                case 0 -> ROCK;
                case 1 -> PAPER;
                case 2 -> SCISSORS;
                default -> "";
            };

            System.out.printf("The computer picked %s\n",computerMove);

            if ((playerMove.equals(ROCK) && computerMove.equals(SCISSORS)) ||
                    (playerMove.equals(PAPER) && computerMove.equals(ROCK)) ||
                    (playerMove.equals(SCISSORS) && computerMove.equals(PAPER))){
                System.out.println("You win.");
                playerVictories++;
            } else if ((playerMove.equals(ROCK) && computerMove.equals(PAPER)) ||
                    (playerMove.equals(PAPER) && computerMove.equals(SCISSORS)) ||
                    (playerMove.equals(SCISSORS) && computerMove.equals(ROCK))) {
                System.out.println("You lose.");
                computerVictories++;
            }else {
                System.out.println("Draw.");
                draws++;
            }

            playerMove= scanner.nextLine();
        }

        System.out.printf("""
                Session overview:\s
                Computer wins: %d
                Player wins: %d
                Draws: %d
                """,computerVictories,playerVictories,draws);

    }

}
