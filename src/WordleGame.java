import java.util.List;
import static java.lang.Thread.sleep;

public class WordleGame {
    private WordleSolver solver;
    private int tentativas;

    public WordleGame(List<String> possibleWords, String correctWord) {
        this.solver = new WordleSolver(possibleWords, correctWord);
        this.tentativas = 0;
    }

    public void playGame() throws InterruptedException {
        while (true) {
            String guess = solver.makeGuess();

            if (guess.equals("No more possible words left.") || guess.equals("Maximum attempts reached.")) {
                System.out.println(guess);
                break;
            }

            System.out.println("Guess: " + guess);

            String feedback = solver.getFeedback(guess);
            System.out.println("Feedback: " + feedback);

            tentativas++;

            if (feedback.equals("ggggg")) {
                System.out.println();
                System.out.println("##################################################");
                System.out.println();
                System.out.println("Word found: " + guess);
                System.out.println("Tries: " + tentativas);
                System.out.println();
                System.out.println("##################################################");
                System.out.println();
                break;
            }

            solver.updatePossibleWords(guess, feedback);

            System.out.println();
            System.out.println("##################################################");
            System.out.println();

            // Faz a thread atual dormir por 1 segundo
            sleep(1000);

            if (solver.noMorePossibleWords()) {
                System.out.println("No more possible words left.");
                break;
            }
        }
    }
}