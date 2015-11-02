package cs301.cannon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * class that draws the targets using a surface view
 *
 * @author Nathan Camacho
 * @version November 2015
 */
public class Target extends SurfaceView {
    public Target(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);//we will be drawing
    }

    //draws a ship with a sail in brown
    @Override
    public void onDraw(Canvas canvas) {
        //Code to draw a ship and its sail in brown
        Paint brown = new Paint();
        brown.setColor(Color.rgb(165,42,42));
        brown.setStyle(Paint.Style.FILL_AND_STROKE);
        brown.setStrokeWidth(5);
        RectF ship1Rect = new RectF();
        ship1Rect.set(10, 30, 210,150);
        canvas.drawArc(ship1Rect,0,180,false,brown);
        Path ship1sail = new Path();
        ship1sail.moveTo(60,70);
        ship1sail.lineTo(110, 0);
        ship1sail.lineTo(160,70);
        ship1sail.moveTo(110,70);
        ship1sail.lineTo(110,100);
        canvas.drawPath(ship1sail, brown);
    }
}
