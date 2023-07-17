import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WordMaskOperator {
    private String word;
    private String[] mask;
    private final Set<String> usedLetters = new HashSet<>();
    private final Set<String> wordUniqueLetters = new HashSet<>();
    private int numberOfGuessedLetters = 0;

    public void setWord(String word) {
        this.word = word;
        this.mask = new String[word.length()];
        Arrays.fill(mask, "*");
        Collections.addAll(wordUniqueLetters, word.split(""));
    }

    public void printMask() {
        System.out.println(String.join("", mask));
    }

    public void updateMask(String letter) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.toString(word.charAt(i)).equalsIgnoreCase(letter)) {
                mask[i] = letter;
            }
        }
        numberOfGuessedLetters++;
    }

    public boolean containsLetter(String letter) {
        return wordUniqueLetters.contains(letter);
    }

    public void useUserInputLetter(String letter) {
        usedLetters.add(letter);
    }

    public boolean isLetterAlreadyUsed(String letter) {
        return usedLetters.contains(letter);
    }

    public boolean userWon() { // TODO: move this method to the Game class, since it has noting to do with WordMaskOperator
        return numberOfGuessedLetters == wordUniqueLetters.size();
    }

    public void clearBuffer() {
        usedLetters.clear();
        wordUniqueLetters.clear();
        numberOfGuessedLetters = 0;
    }
}
