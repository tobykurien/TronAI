package com.tobykurien.tron_ai.view

import android.view.View
import android.content.Context
import android.util.AttributeSet
import android.graphics.Canvas
import android.graphics.Paint
import com.tobykurien.tron_ai.engine.Engine
import com.tobykurien.tron_ai.engine.GameState

/**
 * Main board. This board is spherical, but represented as a flat 2D board.
 */
class Board extends View {
   Paint pBoardLine;
   Paint pYou;
   Paint pOpponent;

   Engine engine = null;
   
   new(Context arg0) {
      super(arg0)
      init()
   }

   new(Context arg0, AttributeSet arg1) {
      super(arg0, arg1)
      init()
   }
   
   new(Context arg0, AttributeSet arg1, int arg2) {
      super(arg0, arg1, arg2)
      init()
   }
   
   def init() {
      pBoardLine = new Paint();
      pBoardLine.setARGB(255, 0, 255, 0);      
      pBoardLine.setStrokeWidth(2);

      pYou = new Paint();
      pYou.setARGB(255, 255, 0, 0);      
      pYou.setStrokeWidth(4);

      pOpponent = new Paint();
      pOpponent.setARGB(255, 0, 0, 255);      
      pOpponent.setStrokeWidth(4);
   }
   
   def setEngine(Engine e) {
      engine = e
   }
   
   override protected onDraw(Canvas c) {      
      val xInc = width / 30.0f
      val yInc = height / 30.0f
        
      for (x : (0..29)) {
         val x1 = x * xInc
         c.drawLine(x1, 0, x1, height, pBoardLine)
      }
      
      for (y : (0..29)) {
         val y1 = y * yInc
         c.drawLine(0, y1, width, y1, pBoardLine)
      }

      if (engine != null) {
         var state = engine.state
         
         for (x : (0..29)) {
            for (y : (0..29)) {
               if (state.get(x).get(y) == GameState::YOU) {
                  c.drawCircle(x * xInc, y * yInc, 8, pYou)
               }
               
               if (state.get(x).get(y) == GameState::OPPONENT) {
                  c.drawCircle(x * xInc, y * yInc, 8, pOpponent)
               }
               
            }
         }
      }

      super.onDraw(c)
   }
}