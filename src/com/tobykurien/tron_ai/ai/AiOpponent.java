package com.tobykurien.tron_ai.ai;

import com.tobykurien.tron_ai.engine.GameState;

public abstract class AiOpponent {
   public static final int AI_MONTE_CARLO_BOT = 1;
   
   
   private AiOpponent() {
      
   }
   
   public AiOpponent getInstance(int type) {
//      if (type == AI_MONTE_CARLO_BOT) {
//         return new AiMonteCarlo();
//      }
      
      return null;
   }

   public abstract void yourMove(GameState state);
   
}
