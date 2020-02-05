public class Sudoku {
  int[][] original;
  int[][] board;
  
  public Sudoku() {
    original = new int[9][9];
    board = new int[9][9];
  }
  
  public Sudoku(int[][] b) {
    original = b;
    board = new int[9][9];
    for(int i = 0; i < 9; i++) {
      for(int j = 0; j < 9; j++) {
        board[i][j] = original[i][j];
      }
    }
  }
  
  public void solveSudoku() {
    solve();
  }
  
  public boolean solve() {
    for(int i = 0; i < 9; i++) {
      for(int j = 0; j < 9; j++) {
        if(board[i][j] == 0) {
          for(int num = 1; num <= 9; num++) {
            if(isLegal(i, j, num)) {
              board[i][j] = num;
              if(solve()) {
                return true;
              }
              else {
                board[i][j] = 0;
              }
            }
          }
          return false;
        }
      }
    }
    return true;
  }
  
  private boolean isLegal(int row, int col, int num) {
    return !(inRow(row, num) || inCol(col, num) || inBox(row, col, num));
  }
  
  public int[][] getOriginal(){
    return original;
  }
  
  public int[][] getBoard(){
    return board;
  }
  
  private boolean inRow(int row, int num) {
    for(int i = 0; i < 9; i++) {
      if(board[row][i] == num) {
        return true;
      }
    }
    return false;
  }
  
  private boolean inCol(int col, int num) {
    for(int i = 0; i < 9; i++) {
      if(board[i][col] == num) {
        return true;
      }
    }
    return false;
  }
  
  private boolean inBox(int row, int col, int num) {
    int r = row - row % 3;
    int c = col - col % 3;
    for(int i = r; i < r + 3; i++) {
      for(int j = c; j < c + 3; j++) {
        if(board[i][j] == num) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void drawSudoku()
  {
    for(int i = 0; i < 9; i++) {  
      for(int j = 0; j < 9; j++) {
        System.out.print(board[i][j] + "  ");
      }
      System.out.println();
      System.out.println();
    }
  }
}
