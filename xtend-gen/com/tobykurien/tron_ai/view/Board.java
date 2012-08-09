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
  
  private Paint pYou;
  
  private Paint pOpponent;
  
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
    this.pBoardLine.setStrokeWidth(2);
    Paint _paint_1 = new Paint();
    this.pYou = _paint_1;
    this.pYou.setARGB(255, 255, 0, 0);
    this.pYou.setStrokeWidth(4);
    Paint _paint_2 = new Paint();
    this.pOpponent = _paint_2;
    this.pOpponent.setARGB(255, 0, 0, 255);
    this.pOpponent.setStrokeWidth(4);
  }
  
  protected void onDraw(final Canvas c) {
    int _width = this.getWidth();
    final int xInc = IntegerExtensions.operator_divide(Integer.valueOf(_width), Float.valueOf(30.0f));
    int _height = this.getHeight();
    final int yInc = IntegerExtensions.operator_divide(Integer.valueOf(_height), Float.valueOf(30.0f));
    Iterable<Integer> _upTo = IntegerExtensions.operator_upTo(Integer.valueOf(0), Integer.valueOf(29));
    for (final Integer x : _upTo) {
      {
        final int x1 = IntegerExtensions.operator_multiply((x).intValue(), xInc);
        int _height_1 = this.getHeight();
        c.drawLine(x1, 0, x1, _height_1, this.pBoardLine);
      }
    }
    Iterable<Integer> _upTo_1 = IntegerExtensions.operator_upTo(Integer.valueOf(0), Integer.valueOf(29));
    for (final Integer y : _upTo_1) {
      {
        final int y1 = IntegerExtensions.operator_multiply((y).intValue(), yInc);
        int _width_1 = this.getWidth();
        c.drawLine(0, y1, _width_1, y1, this.pBoardLine);
      }
    }
    int _width_1 = this.getWidth();
    int _height_1 = this.getHeight();
    c.drawLine(0, 0, _width_1, _height_1, this.pYou);
    super.onDraw(c);
  }
}
