package com.tobykurien.tron_ai.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tobykurien.tron_ai.engine.Engine;
import com.tobykurien.tron_ai.engine.GameState;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IntegerExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

/**
 * Main board. This board is spherical, but represented as a flat 2D board.
 */
@SuppressWarnings("all")
public class Board extends View {
  private Paint pBoardLine;
  
  private Paint pYou;
  
  private Paint pOpponent;
  
  private Engine engine = null;
  
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
  
  public Engine setEngine(final Engine e) {
    Engine _engine = this.engine = e;
    return _engine;
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
    boolean _notEquals = ObjectExtensions.operator_notEquals(this.engine, null);
    if (_notEquals) {
      byte[][] state = this.engine.getState();
      Iterable<Integer> _upTo_2 = IntegerExtensions.operator_upTo(Integer.valueOf(0), Integer.valueOf(29));
      for (final Integer x_1 : _upTo_2) {
        Iterable<Integer> _upTo_3 = IntegerExtensions.operator_upTo(Integer.valueOf(0), Integer.valueOf(29));
        for (final Integer y_1 : _upTo_3) {
          {
            final byte[][] _converted_state = (byte[][])state;
            byte[] _get = ((List<byte[]>)Conversions.doWrapArray(_converted_state)).get((x_1).intValue());
            Byte _get_1 = ((List<Byte>)Conversions.doWrapArray(_get)).get((y_1).intValue());
            boolean _equals = ObjectExtensions.operator_equals(_get_1, Byte.valueOf(GameState.YOU));
            if (_equals) {
              int _multiply = IntegerExtensions.operator_multiply((x_1).intValue(), xInc);
              int _multiply_1 = IntegerExtensions.operator_multiply((y_1).intValue(), yInc);
              c.drawCircle(_multiply, _multiply_1, 8, this.pYou);
            }
            final byte[][] _converted_state_1 = (byte[][])state;
            byte[] _get_2 = ((List<byte[]>)Conversions.doWrapArray(_converted_state_1)).get((x_1).intValue());
            Byte _get_3 = ((List<Byte>)Conversions.doWrapArray(_get_2)).get((y_1).intValue());
            boolean _equals_1 = ObjectExtensions.operator_equals(_get_3, Byte.valueOf(GameState.OPPONENT));
            if (_equals_1) {
              int _multiply_2 = IntegerExtensions.operator_multiply((x_1).intValue(), xInc);
              int _multiply_3 = IntegerExtensions.operator_multiply((y_1).intValue(), yInc);
              c.drawCircle(_multiply_2, _multiply_3, 8, this.pOpponent);
            }
          }
        }
      }
    }
    super.onDraw(c);
  }
}
