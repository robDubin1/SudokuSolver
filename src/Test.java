
public class Test {
  public static void main(String[] args) {
    int[][] board1 = {
        { 0, 0, 7, 2, 4, 0, 0, 0, 0 },
        { 2, 6, 0, 5, 8, 0, 0, 0, 0 },
        { 8, 4, 0, 0, 6, 1, 0, 0, 0 },
        { 0, 3, 0, 0, 0, 0, 0, 0, 8 },
        { 0, 0, 9, 0, 0, 0, 6, 0, 0 },
        { 4, 0, 0, 0, 0, 0, 0, 5, 0 },
        { 0, 0, 0, 6, 2, 0, 0, 3, 1 },
        { 0, 0, 0, 0, 7, 5, 0, 2, 4 },
        { 0, 0, 0, 0, 1, 8, 5, 0, 0 } 
    };
    Sudoku puzzle1 = new Sudoku(board1);
    puzzle1.solveSudoku();
    puzzle1.drawSudoku();
  }
}
