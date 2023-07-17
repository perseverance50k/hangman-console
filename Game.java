import java.util.Scanner;

public class Game {
    private final HangmanDrawer hangmanDrawer = new HangmanDrawer();
    private final RandomWordSelector wordSelector = new RandomWordSelector();
    private final WordMaskOperator maskOperator = new WordMaskOperator();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String option;
        int mistakesCount;

        while (true) {
            System.out.println("Menu: [N]ew game / [E]xit");
            option = scanner.nextLine();

            if (option.equalsIgnoreCase("N")) {
                mistakesCount = 0;
                maskOperator.clearBuffer();
                hangmanDrawer.clearDrawing();
                String letter;
                String guessedWord = wordSelector.getRandomlySelectedWord();
                maskOperator.setWord(guessedWord);
                System.out.println("Random word selected!");
                maskOperator.printMask();

                while (!maskOperator.userWon()) {
                    System.out.println("Guess a letter: ");
                    letter = scanner.nextLine();

                    if (maskOperator.isLetterAlreadyUsed(letter)) {
                        System.out.printf("You've used the letter '%s' already!\n", letter);
                    } else {
                        maskOperator.useUserInputLetter(letter);
                        if (maskOperator.containsLetter(letter)) {
                            System.out.println("You guessed!");
                            System.out.print("Word: ");
                            maskOperator.updateMask(letter);
                            maskOperator.printMask();
                        } else {
                            System.out.println("You didn't guess!");
                            mistakesCount++;
                            System.out.printf("Number of mistakes: %s/5\n", mistakesCount);
                            hangmanDrawer.printHangman(mistakesCount);
                        }
                    }

                    if (mistakesCount == 5) {
                        System.out.println("You lose!");
                        System.out.printf("The word you had to guess: %s\n", guessedWord);
                        break;
                    } else if (maskOperator.userWon()) {
                        System.out.println("You won! Congratulations!");
                    }
                }
            } else if (option.equalsIgnoreCase("E")) {
                System.out.println("Exiting...");
                System.exit(0);
            } else {
                System.out.println("You entered an incorrect input, try again!");
            }
        }
    }
}
