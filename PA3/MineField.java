// Name:Ziyi Xu
// USC NetID:ziyix
// CS 455 PA3
// Fall 2018

import java.util.Random;

/** 
   MineField
      class with locations of mines for a game.
      This class is mutable, because we sometimes need to change it once it's created.
      mutators: populateMineField, resetEmpty
      includes convenience method to tell the number of mines adjacent to a location.
 */
public class MineField {
   
   // <put instance variables here>
   private int numOfRow;         //The number of rows of the minefield.
   private int numOfColumn;       //The number of columns of the minefield.
   private int numOfMines;  //The number of mines should be in the minefield. It may not equal to the number of mines in the minefield actually.
   private int[][] mineField;  //A 2D array to simulate the minefield. 
   private Random generator;   //declare the Random generator.
   private static final int NO_MINE = 0;//If the value of the elements in array mineField is NO_MINE. This location doesn't have a mine.
   private static final int A_MINE = 1;//If the value of the elements in array mineField is A_MINE. This location has a mine.
   
   
   
   
   /**
      Create a minefield with same dimensions as the given array, and populate it with the mines in the array
      such that if mineData[row][col] is true, then hasMine(row,col) will be true and vice versa.  numMines() for
      this minefield will corresponds to the number of 'true' values in mineData.
    * @param mineData  the data for the mines; must have at least one row and one col.
    */
   public MineField(boolean[][] mineData) {
      numOfRow = mineData.length;    // get the number of rows from the mineData.
      numOfColumn = mineData[0].length;// get the number of columns from the mineData.
      mineField = new int[numOfRow][numOfColumn];//the minefield with the size of numOfRow * numofColumn
      int numOfTrue = 0;  // record the number of the value of true in the array mineData.
      
      for(int i = 0; i < mineData.length; i++){
         for(int j = 0; j < mineData[0].length; j++){
            if(mineData[i][j] == true){
               mineField[i][j] = A_MINE;   //put the mine on this location in the minefield 
               numOfTrue = numOfTrue + 1;
            }
         }
      }
      
      numOfMines = numOfTrue; // get the number of mines should be in the minefield.
             
            
      
   }
   
   
   /**
      Create an empty minefield (i.e. no mines anywhere), that may later have numMines mines (once 
      populateMineField is called on this object).  Until populateMineField is called on such a MineField, 
      numMines() will not correspond to the number of mines currently in the MineField.
      @param numRows  number of rows this minefield will have, must be positive
      @param numCols  number of columns this minefield will have, must be positive
      @param numMines   number of mines this minefield will have,  once we populate it.
      PRE: numRows > 0 and numCols > 0 and 0 <= numMines < (1/3 of total number of field locations). 
    */
   public MineField(int numRows, int numCols, int numMines) {
      assert numRows > 0 && numCols > 0;
      int limit = numRows * numCols;
      assert numMines < limit / 3.0;
      
      numOfRow = numRows;   //get the number of rows
      numOfColumn = numCols; //get the number of columns
      numOfMines = numMines; //get the number of mines should be in the minefield.
      mineField = new int [numOfRow][numOfColumn]; //the minefield with the size of numOfRow * numofColumn
      generator = new Random();  // initialize the generator
   }
   

   /**
      Removes any current mines on the minefield, and puts numMines() mines in random locations on the minefield,
      ensuring that no mine is placed at (row, col).
      @param row the row of the location to avoid placing a mine
      @param col the column of the location to avoid placing a mine
      PRE: inRange(row, col)
    */
   public void populateMineField(int row, int col) {
      assert inRange(row, col);
      //remove all the mines on the minefield
      for(int i = 0; i < mineField.length; i++){
         for(int j = 0; j < mineField[0].length; j++){
            mineField[i][j] = NO_MINE;
         }
      }
      
      int minesPut = 0;  //record how many mines have been put on the minefield
      int ranRow = ranNum(numOfRow, row); //generate a random number from 0(inclusive) to numOfRow(exculsive) and not equal to row
      int ranCol = ranNum(numOfColumn, col);//generate a random number from 0(inclusive) to numOfColumn(exculsive) and not equal to col
      
      //While the mines aren't be put completely, put a new mine on the location that hasn't been chosen.
      while(minesPut < numOfMines){
         if(!hasMine(ranRow, ranCol)){
            mineField[ranRow][ranCol] = A_MINE;
            minesPut = minesPut + 1;
         }
         ranRow = ranNum(numOfRow, row);  //generate a new random number
         ranCol = ranNum(numOfColumn, col);//generate a new random number
      }
            
   }
   
   
   /**
      Reset the minefield to all empty squares.  This does not affect numMines(), numRows() or numCols()
      Thus, after this call, the actual number of mines in the minefield does not match numMines().  
      Note: This is the state the minefield is in at the beginning of a game.
    */
   public void resetEmpty() {
      //Reset the minefield. Make all the squares in the minefield empty.
      for(int i = 0; i < mineField.length; i++){
         for(int j = 0; j < mineField[0].length; j++){
            mineField[i][j] = NO_MINE;
         }
      }  
   }

   
  /**
     Returns the number of mines adjacent to the specified mine location (not counting a possible 
     mine at (row, col) itself).
     Diagonals are also considered adjacent, so the return value will be in the range [0,8]
     @param row  row of the location to check
     @param col  column of the location to check
     @return  the number of mines adjacent to the square at (row, col)
     PRE: inRange(row, col)
   */
   public int numAdjacentMines(int row, int col) {
      assert inRange(row, col);
      int minesAdjacent = 0; //record the number of mines adjacent to a certain square in eight direction
      for (int i = row - 1; i <= row + 1; i++){
         for ( int j = col - 1; j <= col + 1; j++){
            if(inRange(i, j) && hasMine(i, j)){ // Firstly, you should test whether the row and col are valid. And then if here is a mine,                                          record it.
               minesAdjacent = minesAdjacent + 1;
            }
         }
      }
      //remove the record of a mine of itself
      if(hasMine(row, col)){
         minesAdjacent = minesAdjacent - 1;
      }
               
      return minesAdjacent;       
   }
   
   
   /**
      Returns true iff (row,col) is a valid field location.  Row numbers and column numbers
      start from 0.
      @param row  row of the location to consider
      @param col  column of the location to consider
      @return whether (row, col) is a valid field location
   */
   public boolean inRange(int row, int col) {
      if((row >= 0 && row < numOfRow) && (col >= 0 && col < numOfColumn)){
         return true;
      }
      return false;       
   }
   
   
   /**
      Returns the number of rows in the field.
      @return number of rows in the field
   */  
   public int numRows() {
      return numOfRow;       
   }
   
   
   /**
      Returns the number of columns in the field.
      @return number of columns in the field
   */    
   public int numCols() {
      return numOfColumn;       
   }
   
   
   /**
      Returns whether there is a mine in this square
      @param row  row of the location to check
      @param col  column of the location to check
      @return whether there is a mine in this square
      PRE: inRange(row, col)   
   */    
   public boolean hasMine(int row, int col) {
      assert inRange(row, col);
      if(mineField[row][col] == A_MINE){
         return true;
      }
      return false;       
   }
   
   
   /**
      Returns the number of mines you can have in this minefield.  For mines created with the 3-arg constructor,
      some of the time this value does not match the actual number of mines currently on the field.  See doc for that
      constructor, resetEmpty, and populateMineField for more details.
    * @return
    */
   public int numMines() {
      return numOfMines;       
   }

   
   // <put private methods here>
   
   /**
     generate a random number from 0(inclusive) to ranRange(exclusive) and not equal to notEqual.
     @param ranRange the upper bound of the random number(excluseive)
     @param notEqual the return number cann't be equal to it 
     @return the required random number
   */
   private int ranNum(int ranRange, int notEqual){
      int randomNum;
      randomNum = generator.nextInt(ranRange);
      
      while(randomNum == notEqual){
         randomNum = generator.nextInt(ranRange);
      }
     
      return randomNum;
   }
   
         
}

