package com.tobykurien.tron_ai.engine

class Engine {
   public static int MOVE_FORWARD = 1;
   public static int MOVE_LEFT = 1;
   public static int MOVE_RIGHT = 1;
   
   var game = new GameState();
   var opponent = null;
   
   new() {
      
   }

   def yourTurn() {
      if (game.whoseTurn == GameState::YOU) return true 
      false
   }      

   def youMove(int direction) {
      
   }

   def opponentMove(int direction) {
      
   }
   
   def isHumanOpponent() {
      return opponent == null
   }
   
   def getState() {
      game.board
   }
}