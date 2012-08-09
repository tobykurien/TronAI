package com.tobykurien.tron_ai.engine;

public class GameState {
   
   public static final byte EMPTY = 0;
   public static final byte INVALID = 3;
   public static final byte YOU = -1;
   public static final byte YOUR_WALL = 1;
   public static final byte OPPONENT = -2;
   public static final byte OPPONENT_WALL = 2;
   
   byte[][] board = new byte[30][30];
   byte turn = YOU;
   
   public GameState() {
      
      // initialize to zero
      for (int i=0; i < board.length; i++) {
         for (int j=0; j < board[i].length; j++) {
            board[i][j] = 0;
         }
      }

      // starting positions
      board[5][5] = YOU;
      board[25][25] = OPPONENT;
   }
   
   public byte whoseTurn() {
      return turn;
   }
   
   public byte whatsHere(byte row, byte column) {
      if (row < 0 || row > board.length) return INVALID;
      if (column < 0 || column > board[row].length) return INVALID;
      return board[row][column];
   }
   
   public byte[][] getBoard() {
      return board;
   }
   
}
