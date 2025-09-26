import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {
    private static final String ROCK = "Rock";
    private static final String PAPER = "Paper";
    private static final String SCISSORS = "Scissors";


    // ако комп бие 3 пъти подред трябва да намалим шансовете за победа с 50%!
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("If you want to stop playing the game type \"STOP\"\n");
        System.out.print("Choose [r]ock, [p]aper or [s]cissors: \n");
        String playerMove = scanner.nextLine();

        int computerVictories = 0;
        int playerVictories = 0;
        int draws = 0;
        int computerConsecutiveWins = 0;
        int playerConsecutiveWins = 0;

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

            String computerMove = getComputerMove(computerRandomNumber);

            boolean lossCheck = (playerMove.equals(ROCK) && computerMove.equals(PAPER)) ||
                    (playerMove.equals(PAPER) && computerMove.equals(SCISSORS)) ||
                    (playerMove.equals(SCISSORS) && computerMove.equals(ROCK));

            boolean winCheck = (playerMove.equals(ROCK) && computerMove.equals(SCISSORS)) ||
                    (playerMove.equals(PAPER) && computerMove.equals(ROCK)) ||
                    (playerMove.equals(SCISSORS) && computerMove.equals(PAPER));

            if (computerConsecutiveWins==3){
                if (lossCheck){
                    computerRandomNumber=random.nextInt(3);
                    computerMove=getComputerMove(computerRandomNumber);
                }
            } else if (playerConsecutiveWins == 3) {
                if (winCheck){
                    computerRandomNumber=random.nextInt(3);
                    computerMove=getComputerMove(computerRandomNumber);
                }
            }

            System.out.printf("The computer picked %s\n",computerMove);

            if (winCheck){
                System.out.println("You win.");
                playerVictories++;
                playerConsecutiveWins++;
            } else if (lossCheck) {
                System.out.println("You lose.");
                computerVictories++;
                computerConsecutiveWins++;
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

    private static String getComputerMove(int computerRandomNumber) {
        return switch (computerRandomNumber) {
            case 0 -> ROCK;
            case 1 -> PAPER;
            case 2 -> SCISSORS;
            default -> "";
        };
    }

}
