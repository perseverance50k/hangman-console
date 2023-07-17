import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordMaskOperator {
    private String word;
    private String[] mask;
    private final Set<String> usedLetters = new HashSet<>();
    private int numberOfGuessedLetters = 0;

    public WordMaskOperator() {
        this.word = null;
        this.mask = null;
    }

    public void setWord(String word) {
        this.word = word;
        this.mask = "*".repeat(word.length()).split("");
        mask = new String[word.length()];
        Arrays.fill(mask, "*");
    }

    public WordMaskOperator(String word) {
        this.word = word;
        this.mask = new String[word.length()];
        Arrays.fill(mask, "*");
    }

    private void updateMask(String letter) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.toString(word.charAt(i)).equalsIgnoreCase(letter)) {
                mask[i] = letter;
                numberOfGuessedLetters++;
            }
        }
    }

    public void printWordMask(String letter) {
        updateMask(letter);
        System.out.println(String.join("", mask));
    }

    public boolean containsLetter(String letter) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.toString(word.charAt(i)).equalsIgnoreCase(letter)) {
                return true;
            }
        }

        return false;
    }

    public void useUserInputLetter(String letter) {
        usedLetters.add(letter);
    }

    public void clearBuffer() {
        usedLetters.clear();
    }

    public boolean isLetterAlreadyUsed(String letter) {
        return usedLetters.contains(letter);
    }

    public boolean userWon() {
        for (String s : mask) {
            if (s.equals("*")) return false;
        }
        return true;
    }

    public String getWord() {
        return word;
    }
}
