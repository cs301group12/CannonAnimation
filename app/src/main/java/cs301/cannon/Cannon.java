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
 * class that draws a cannon using a surface view
 *
 * @author Nathan Camacho
 * @version November 2015
 */
public class Cannon extends SurfaceView {

    //Instance variables
    public float x = 1;
    public float y = 1;

    //Constuctor
    public Cannon(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);//we will be drawing
    }

    //draws a cannon
    // does not rotate correctly
    @Override
    public void onDraw(Canvas canvas) {
        //code to rotate the canvas that the cannon is drawn on
        //does not work correctly
        canvas.save();
        canvas.rotate((float) Math.toDegrees(getRotation()),(float)150,(float)600);
        Paint darkGray = new Paint();
        darkGray.setColor(Color.DKGRAY);
        darkGray.setStyle(Paint.Style.FILL_AND_STROKE);
        darkGray.setStrokeWidth(5);
        Path cannon = new Path();
        cannon.moveTo(50,550);
        cannon.lineTo(500,550);
        cannon.lineTo(500,620);
        cannon.lineTo(50,620);
        canvas.drawPath(cannon,darkGray);//draw cannon
        canvas.restore();


        Path triangle = new Path();
        triangle.moveTo(150,600);
        triangle.lineTo(200,750);
        triangle.lineTo(100,750);
        canvas.drawPath(triangle,darkGray);//draw stand for the cannon
    }
}
