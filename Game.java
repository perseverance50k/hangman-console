import java.util.Scanner;

public class Game {
    private final HangmanDrawer hangmanDrawer = new HangmanDrawer();
    private final RandomWordSelector wordSelector = new RandomWordSelector();
    private final WordMaskOperator maskOperator = new WordMaskOperator();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String option = "";
        int mistakesCount = 0;

        while (true) {
            System.out.println("Menu: [N]ew game / [E]xit");
            option = scanner.nextLine();

            if (option.equalsIgnoreCase("N")) {
                mistakesCount = 0;
                maskOperator.clearBuffer();
                hangmanDrawer.clearDrawing();
                String letter = "";
                maskOperator.setWord(wordSelector.getRandomlySelectedWord());
                System.out.println("Random word selected!");
                maskOperator.printWordMask(""); // FIXME: maybe it's not the best decision for printing the initial
                                                      // FIXME: word hidden by the mask

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
                            maskOperator.printWordMask(letter);
                        } else {
                            System.out.println("You didn't guess!");
                            mistakesCount++;
                            System.out.println("Number of mistakes: " + mistakesCount + "/5");
                            hangmanDrawer.printHangman(mistakesCount);
                        }
                    }

                    if (mistakesCount == 5) {
                        System.out.println("You lose!");
                        System.out.println("The word you had to guess: " + maskOperator.getWord());
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
