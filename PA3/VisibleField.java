// Name:Ziyi Xu
// USC NetID:ziyix
// CS 455 PA3
// Fall 2018


/**
  VisibleField class
  This is the data that's being displayed at any one point in the game (i.e., visible field, because it's what the
  user can see about the minefield), Client can call getStatus(row, col) for any square.
  It actually has data about the whole current state of the game, including  
  the underlying mine field (getMineField()).  Other accessors related to game status: numMinesLeft(), isGameOver().
  It also has mutators related to moves the player could do (resetGameDisplay(), cycleGuess(), uncover()),
  and changes the game state accordingly.
  
  It, along with the MineField (accessible in mineField instance variable), forms
  the Model for the game application, whereas GameBoardPanel is the View and Controller, in the MVC design pattern.
  It contains the MineField that it's partially displaying.  That MineField can be accessed (or modified) from 
  outside this class via the getMineField accessor.  
 */
public class VisibleField {
   // ----------------------------------------------------------   
   // The following public constants (plus numbers mentioned in comments below) are the possible states of one
   // location (a "square") in the visible field (all are values that can be returned by public method 
   // getStatus(row, col)).
   
   // Covered states (all negative values):
   public static final int COVERED = -1;   // initial value of all squares
   public static final int MINE_GUESS = -2;
   public static final int QUESTION = -3;

   // Uncovered states (all non-negative values):
   
   // values in the range [0,8] corresponds to number of mines adjacent to this square
   
   public static final int MINE = 9;      // this loc is a mine that hasn't been guessed already (end of losing game)
   public static final int INCORRECT_GUESS = 10;  // is displayed a specific way at the end of losing game
   public static final int EXPLODED_MINE = 11;   // the one you uncovered by mistake (that caused you to lose)
   // ----------------------------------------------------------   
  
   // <put instance variables here>
   private MineField mineField; //declare the MineField named mineField.
   private int[][]status;     //the array to record the status of the square the user can see.
   private boolean[][]mineUncover; //to show whether a certain square is uncovered. If the value of a certain element is true, this location is uncovered.
   private static final int NO_ADJACENT_MINE = 0;// to show there isn'nt any mine nearby
   
   /**
      Create a visible field that has the given underlying mineField.
      The initial state will have all the mines covered up, no mines guessed, and the game
      not over.
      @param mineField  the minefield to use for for this VisibleField
    */
   public VisibleField(MineField mineField) {
      this.mineField = mineField; 
      
      status = new int[mineField.numRows()][mineField.numCols()]; //initialize the array status with the size of mineField.numRows() * mineField.numCols()
      toBeCovered();//reset the array status which make all the squares uncovered.
      mineUncover = new boolean[mineField.numRows()][mineField.numCols()];//initialize the array mineUncover with the size of mineField.numRows() *                                                             mineField.numCols()
   }
   
   
   /**
      Reset the object to its initial state (see constructor comments), using the same underlying MineField. 
   */     
   public void resetGameDisplay() {
      toBeCovered();//reset the array status which make all the squares uncovered.
      mineUncover = new boolean[mineField.numRows()][mineField.numCols()];      
   }
  
   
   /**
      Returns a reference to the mineField that this VisibleField "covers"
      @return the minefield
    */
   public MineField getMineField() {
      return mineField;       
   }
   
   
   /**
      get the visible status of the square indicated.
      @param row  row of the square
      @param col  col of the square
      @return the status of the square at location (row, col).  See the public constants at the beginning of the class
      for the possible values that may be returned, and their meanings.
      PRE: getMineField().inRange(row, col)
    */
   public int getStatus(int row, int col) {
      assert getMineField().inRange(row, col);
      if(!mineUncover[row][col]){   //for covered squares
         if(status[row][col] == COVERED){
            if(mineField.hasMine(row,col) && isGameOver()){  //if the square with a mine is covered, the user will be told at the end of the game.
               status[row][col] = MINE;
            }
            else{
               return COVERED;
            }
         }
         else if(status[row][col] == MINE_GUESS){
            if(!mineField.hasMine(row, col) && isGameOver()){ //if the user guess the location of mine incorrectly, he will be told at the end of the game.
               status[row][col] = INCORRECT_GUESS;
            }
            else{
               return MINE_GUESS;
            }
         }
         else if(status[row][col] == QUESTION){
            return QUESTION;
         }
      }
      else{    //for uncovered squares
         //if this location has a mine, it will explode and make you lose the game.
         if(mineField.hasMine(row, col)){
            status[row][col] = EXPLODED_MINE;
         }
         //if not, it will show the mines adjacent to this location.
         else{
            status[row][col] = mineField.numAdjacentMines(row, col);
         }
      }

      return status[row][col];       
   }

   
   /**
      Return the the number of mines left to guess.  This has nothing to do with whether the mines guessed are correct
      or not.  Just gives the user an indication of how many more mines the user might want to guess.  So the value can
      be negative, if they have guessed more than the number of mines in the minefield.     
      @return the number of mines left to guess.
    */
   public int numMinesLeft() {
      int mineGuess = 0; //record the number of mines user has guessed
      for(int i = 0; i < status.length; i++){
         for(int j = 0; j< status[0].length; j++){
            if(status[i][j] == MINE_GUESS){
               mineGuess = mineGuess + 1;
            }
               
         }
      }
      
      int mineLeft = mineField.numMines() - mineGuess; //the number of mines left to guess
      return mineLeft;       

   }
 
   
   /**
      Cycles through covered states for a square, updating number of guesses as necessary.  Call on a COVERED square
      changes its status to MINE_GUESS; call on a MINE_GUESS square changes it to QUESTION;  call on a QUESTION square
      changes it to COVERED again; call on an uncovered square has no effect.  
      @param row  row of the square
      @param col  col of the square
      PRE: getMineField().inRange(row, col)
    */
   public void cycleGuess(int row, int col) {
      assert getMineField().inRange(row, col);
      if(status[row][col] == COVERED){
         status[row][col] = MINE_GUESS;
      }
      else if(status[row][col] == MINE_GUESS){
         status[row][col] = QUESTION;
      }
      else if(status[row][col] == QUESTION){
         status[row][col] = COVERED;
      }
      
   }

   
   /**
      Uncovers this square and returns false iff you uncover a mine here.
      If the square wasn't a mine or adjacent to a mine it also uncovers all the squares in 
      the neighboring area that are also not next to any mines, possibly uncovering a large region.
      Any mine-adjacent squares you reach will also be uncovered, and form 
      (possibly along with parts of the edge of the whole field) the boundary of this region.
      Does not uncover, or keep searching through, squares that have the status MINE_GUESS. 
      @param row  of the square
      @param col  of the square
      @return false   iff you uncover a mine at (row, col)
      PRE: getMineField().inRange(row, col)
    */
   public boolean uncover(int row, int col) {
      assert getMineField().inRange(row, col);   
      if(mineField.hasMine(row, col)){
         mineUncover[row][col] = true;
         return false;  //return false when you uncover a square with a mine
      }
      //help recursion function to uncover all the squares in the neighboring area that are also not next to any mines
      floodFill(row, col);
         
      return true;
   }
 
   
   /**
      Returns whether the game is over.
      @return whether game over
    */
   public boolean isGameOver() {
      int noMine = 0; //record the number of the squares uncovered which doesn't has a mine
      for(int i = 0; i < status.length; i++){
         for(int j = 0; j < status[0].length; j++){
            if(mineField.hasMine(i, j) && mineUncover[i][j]){ //If a mine is uncoverd, the game is over.
               return true;
            }
            else if(!mineField.hasMine(i, j) && mineUncover[i][j]){
               noMine = noMine + 1;
            }
         }
      }
      if(noMine == mineField.numRows() * mineField.numCols() - mineField.numMines()){ //If all the empty squares are uncovered, the game is over
         //In this situation, you will win. And at the end of the game, you will be told all the locations of mines with a prompt of yellow color.
         //If there are some covered mines, change the status of these covered squares to MINE_GUESS
         for(int i = 0; i < status.length; i++){
            for(int j = 0; j < status[0].length; j++){
               if(!mineUncover[i][j]){
                  status[i][j] = MINE_GUESS;
               }
               
            }
         }
         return true;
      }
      return false;       
   }
 
   
   /**
      Return whether this square has been uncovered.  (i.e., is in any one of the uncovered states, 
      vs. any one of the covered states).
      @param row of the square
      @param col of the square
      @return whether the square is uncovered
      PRE: getMineField().inRange(row, col)
    */
   public boolean isUncovered(int row, int col) {
      assert getMineField().inRange(row, col);
      if(status[row][col] == COVERED || status[row][col] == MINE_GUESS || status[row][col] == QUESTION){
         return false;
      }
  
      return true;       
   }
   
 
   // <put private methods here>
   
   /**
    reset the 2Darray status and make all the squares covered.
   */
   private void toBeCovered(){
      for(int i = 0; i < status.length; i++){
         for(int j = 0; j < status[0].length; j++){
            status[i][j] = COVERED;
         }
      }
   }
   
   /**
     A help function to uncover all the squares in the neighboring area of location (row, col) that are also not next to any mines
     @param row the row of this square 
     @param col the column of this square
   */
   private void floodFill(int row, int col){
      boolean inRange = mineField.inRange(row, col); //test whether (row, col) is valid
      //if the location is not valid, return   
      if(!inRange){
         return;
      }
      //don't search through or uncover a square with the status of MINE_GUESS
      else if(status[row][col] == MINE_GUESS){
         return;
      }
      //if there are some mines near this location, finish this recurison and return
      else if(mineField.numAdjacentMines(row, col) > NO_ADJACENT_MINE){
         mineUncover[row][col] = true;
         return;
      }    
      //if this location has been uncovered, skip this to avoid unnecessary operations
      else if(mineUncover[row][col]){
         return;
      }
      else if(mineField.numAdjacentMines(row, col) == NO_ADJACENT_MINE){
         mineUncover[row][col] = true;
         floodFill(row - 1, col - 1);
         floodFill(row - 1, col);
         floodFill(row - 1, col + 1);
         floodFill(row, col - 1);
         floodFill(row, col + 1);
         floodFill(row + 1, col - 1);
         floodFill(row + 1, col);
         floodFill(row + 1, col + 1);
      }
      
      
      return;
   }
              
}
