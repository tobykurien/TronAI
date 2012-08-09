package com.tobykurien.tron_ai.view

import android.view.View
import android.content.Context
import android.util.AttributeSet
import android.graphics.Canvas
import android.graphics.Paint

/**
 * Main board. This board is spherical, but represented as a flat 2D board.
 */
class Board extends View {
   Paint pBoardLine;
   
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
   }
   
   override protected onDraw(Canvas c) {
      val height = c.height
      val width = c.width
      
      val xInc = width / 30.0f;
      val yInc = height / 30.0f;
      
      for (x : (0..29)) {
         val x1 = x * xInc
         c.drawLine(x1, 0, x1, width, pBoardLine)
      }
      
      for (y : (0..29)) {
         val y1 = y * yInc
         c.drawLine(0, y1, height, y1, pBoardLine)
      }

      super.onDraw(c)
   }
   
}