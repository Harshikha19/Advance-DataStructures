import java.util.*;

public class WordSearch {

    static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public static void main(String[] args) {
        char[][] matrix = {
            {'A', 'B', 'C', 'D'},
            {'E', 'F', 'G', 'H'},
            {'I', 'J', 'K', 'L'},
            {'M', 'N', 'O', 'P'}
        };
        String word = "ABC";

        // Initialize the solution matrix.
        int[][] solution = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[0].length; j++) {
                solution[i][j] = -1;
            }
        }

        // Search for the word in the matrix.
        boolean found = false;
        int startRow = -1;
        int startCol = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (searchWord(matrix, word, i, j, solution)) {
                    found = true;
                    startRow = i;
                    startCol = j;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        if (found) {
            System.out.println("The word \"" + word + "\" is found in the matrix.");
            System.out.println("The beginning position is (" + startRow + ", " + startCol + ").");
        } else {
            System.out.println("The word \"" + word + "\" is not found in the matrix.");
        }
    }

    private static boolean searchWord(char[][] matrix, String word, int row, int col, int[][] solution) {
        if (word.length() == 0) {
            return true;
        }

        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || solution[row][col] != -1) {
            return false;
        }

        if (matrix[row][col] != word.charAt(0)) {
            return false;
        }

        solution[row][col] = 0;
        for (int[] direction : DIRECTIONS) {
            if (searchWord(matrix, word.substring(1), row + direction[0], col + direction[1], solution)) {
                return true;
            }
        }

        solution[row][col] = -1;
        return false;
    }
}

