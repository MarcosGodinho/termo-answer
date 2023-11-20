import java.io.IOException;
import java.util.*;

import static java.lang.Thread.sleep;

public class WordleSolver {

    private List<String> possibleWords;
    private Random random;
    private String correctWord;

    public WordleSolver(List<String> possibleWords, String correctWord) {
        this.possibleWords = new ArrayList<>(possibleWords);
        this.random = new Random();
        this.correctWord = correctWord;
    }

    public String makeGuess() {
        if (possibleWords.isEmpty()) {
            System.out.println("No more possible words left.");
            System.exit(1);
        }
        return possibleWords.get(random.nextInt(possibleWords.size()));
    }

    public void updatePossibleWords(String guess, String feedback) {
        possibleWords.removeIf(word -> !matchesFeedback(word, guess, feedback));
    }

    private boolean matchesFeedback(String word, String guess, String feedback) {
        for (int i = 0; i < word.length(); i++) {
            char wordChar = word.charAt(i);
            char guessChar = guess.charAt(i);
            char feedbackChar = feedback.charAt(i);

            if (feedbackChar == 'g' && wordChar != guessChar) {
                return false;
            } else if (feedbackChar == 'y' && (wordChar == guessChar || word.indexOf(guessChar) == -1)) {
                return false;
            } else if (feedbackChar == 'r' && word.indexOf(guessChar) != -1) {
                return false;
            }
        }
        return true;
    }

    public boolean noMorePossibleWords() {
        return possibleWords.isEmpty();
    }

    public List<String> getPossibleWords() {
        return possibleWords;
    }

    public String getFeedback(String guess) {
        StringBuilder feedback = new StringBuilder();

        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == correctWord.charAt(i)) {
                feedback.append('g');
            } else if (correctWord.contains(String.valueOf(guess.charAt(i)))) {
                feedback.append('y');
            } else {
                feedback.append('r');
            }
        }

        return feedback.toString();
    }
}