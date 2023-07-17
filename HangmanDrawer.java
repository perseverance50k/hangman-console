import java.util.Arrays;
public class HangmanDrawer {

    private final String[][] hangmanDrawingMatrix = new String[8][6];

    public HangmanDrawer() {
        clearDrawing();
    }

    public void printHangman(int numberOfMistakes) {
        updateHangmanDrawingMatrix(numberOfMistakes);
        for (String[] drawingMatrixRow : hangmanDrawingMatrix) {
            for (int j = 0; j < drawingMatrixRow.length; j++) {
                System.out.print(drawingMatrixRow[j]);
                if (j == drawingMatrixRow.length - 1) System.out.print("\n");
            }
        }
    }

    private void updateHangmanDrawingMatrix(int numberOfMistakes) {
        switch (numberOfMistakes) {
            case (1) -> {
                hangmanDrawingMatrix[7][0] = "/";
                hangmanDrawingMatrix[7][1] = "—";
                hangmanDrawingMatrix[7][2] = "\\";
                hangmanDrawingMatrix[6][1] = "|";
                hangmanDrawingMatrix[5][1] = "|";
                hangmanDrawingMatrix[4][1] = "|";
                hangmanDrawingMatrix[3][1] = "|";
            }
            case (2) -> {
                hangmanDrawingMatrix[2][1] = "|";
                hangmanDrawingMatrix[1][1] = "|";
                hangmanDrawingMatrix[0][2] = "_";
            }
            case (3) -> {
                hangmanDrawingMatrix[0][3] = "_";
                hangmanDrawingMatrix[0][4] = "_";
                hangmanDrawingMatrix[0][5] = "_";
                hangmanDrawingMatrix[1][4] = "|";
            }
            case (4) -> {
                hangmanDrawingMatrix[2][4] = "(";
                hangmanDrawingMatrix[2][5] = ")";
                hangmanDrawingMatrix[3][4] = "/";
                hangmanDrawingMatrix[3][5] = "\\";
            }
            case (5) -> {
                hangmanDrawingMatrix[4][4] = "|";
                hangmanDrawingMatrix[5][4] = "/";
                hangmanDrawingMatrix[5][5] = "\\";
            }
        }
    }

    public void clearDrawing() {
        for (int i = 0; i < hangmanDrawingMatrix.length; i++) {
            Arrays.fill(hangmanDrawingMatrix[i], " ");
        }
    }
}
