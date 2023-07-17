import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class RandomWordSelector {
    private String[] words = new String[0];

    public RandomWordSelector() {
        populateWordsArrayFromFile();
    }

    private void populateWordsArrayFromFile() {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader("resources/words.txt"))) {
            br.lines().forEach(sb::append);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String wordsSeparatedByCommaAndSpace = sb.toString();
        words = wordsSeparatedByCommaAndSpace.split(", ");
    }

    public String getRandomlySelectedWord() {
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }
}
