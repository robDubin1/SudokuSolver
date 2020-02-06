import java.io.BufferedReader;
import java.io.FileReader;

public class Test {
  public static void main(String[] args) {
    long time = System.nanoTime();
    int numPuzzles = -1;
    try {
      BufferedReader scanner = new BufferedReader(new FileReader("./src/Files/sudokuPuzzles.txt"));
      String line = scanner.readLine();
      numPuzzles = Integer.parseInt(line);
      System.out.println("Number of Puzzles: " + numPuzzles);
      int solved = 0;
      while(solved < numPuzzles) {
        line = scanner.readLine();
        int[][] board = new int[9][9];
        for(int i = 0; i < 81; i++) {
          board[i / 9][i % 9] = Integer.parseInt(line.substring(i, i + 1));
        }
        Sudoku puzzle = new Sudoku(board);
        puzzle.solveSudoku();
        solved++;
      }
    }
    catch(Exception e){
      System.out.println(e);
    }
    double timeSpent = System.nanoTime() - time;
    System.out.println("Seconds taken: " + timeSpent / 1000000000);
    System.out.println("Average seconds taken per puzzle: " + timeSpent / 1000000000 / numPuzzles);
  }
}
