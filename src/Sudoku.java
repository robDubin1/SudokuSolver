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
    return safeRow(row, num) && safeCol(col, num) && safeBox(row, col, num);
  }
  
  public int[][] getOriginal(){
    return original;
  }
  
  public int[][] getBoard(){
    return board;
  }
  
  private boolean safeRow(int row, int num) {
    for(int i = 0; i < 9; i++) {
      if(board[row][i] == num) {
        return false;
      }
    }
    return true;
  }
  
  private boolean safeCol(int col, int num) {
    for(int i = 0; i < 9; i++) {
      if(board[i][col] == num) {
        return false;
      }
    }
    return true;
  }
  
  private boolean safeBox(int row, int col, int num) {
    int r = row - row % 3;
    int c = col - col % 3;
    for(int i = r; i < r + 3; i++) {
      for(int j = c; j < c + 3; j++) {
        if(board[i][j] == num) {
          return false;
        }
      }
    }
    return true;
  }
  
  public void drawSolution()
  {
    for(int i = 0; i < 9; i++) {  
      for(int j = 0; j < 9; j++) {
        if(j != 0 && j % 3 == 0) {
          System.out.print("| ");
        }
        System.out.print(board[i][j] + "  ");
      }
      System.out.println();
      if(i == 2 || i == 5) {
        System.out.println("- - - - - - - - - - - - - - -");
      }
      System.out.println();
    }
  }
  
  public void drawOriginal()
  {
    for(int i = 0; i < 9; i++) {  
      for(int j = 0; j < 9; j++) {
        if(j != 0 && j % 3 == 0) {
          System.out.print("| ");
        }
        System.out.print(original[i][j] + "  ");
      }
      System.out.println();
      if(i == 2 || i == 5) {
        System.out.println("- - - - - - - - - - - - - - -");
      }
      System.out.println();
    }
  }
}
