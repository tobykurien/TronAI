package com.tobykurien.tron_ai.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;

/**
 * Main board. This board is spherical, but represented as a flat 2D board.
 */
@SuppressWarnings("all")
public class Board extends View {
  private Paint pBoardLine;
  
  public Board(final Context arg0) {
    super(arg0);
    this.init();
  }
  
  public Board(final Context arg0, final AttributeSet arg1) {
    super(arg0, arg1);
    this.init();
  }
  
  public Board(final Context arg0, final AttributeSet arg1, final int arg2) {
    super(arg0, arg1, arg2);
    this.init();
  }
  
  public void init() {
    Paint _paint = new Paint();
    this.pBoardLine = _paint;
    this.pBoardLine.setARGB(255, 0, 255, 0);
  }
  
  protected void onDraw(final Canvas c) {
    final int height = c.getHeight();
    final int width = c.getWidth();
    final int xInc = IntegerExtensions.operator_divide(Integer.valueOf(width), Float.valueOf(30.0f));
    final int yInc = IntegerExtensions.operator_divide(Integer.valueOf(height), Float.valueOf(30.0f));
    Iterable<Integer> _upTo = IntegerExtensions.operator_upTo(Integer.valueOf(0), Integer.valueOf(29));
    for (final Integer x : _upTo) {
      {
        final int x1 = IntegerExtensions.operator_multiply((x).intValue(), xInc);
        c.drawLine(x1, 0, x1, width, this.pBoardLine);
      }
    }
    Iterable<Integer> _upTo_1 = IntegerExtensions.operator_upTo(Integer.valueOf(0), Integer.valueOf(29));
    for (final Integer y : _upTo_1) {
      {
        final int y1 = IntegerExtensions.operator_multiply((y).intValue(), yInc);
        c.drawLine(0, y1, height, y1, this.pBoardLine);
      }
    }
    super.onDraw(c);
  }
}
