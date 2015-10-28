package cs301.cannon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * Created by nathancamacho on 10/27/15.
 */
public class Cannon extends SurfaceView {

    public Cannon(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
    }

    @Override
    public void onDraw(Canvas canvas) {
        Paint darkGray = new Paint();
        darkGray.setColor(Color.DKGRAY);
        darkGray.setStyle(Paint.Style.FILL_AND_STROKE);
        darkGray.setStrokeWidth(5);
        RectF cannon = new RectF();
        cannon.set(20, 100, 500, 300);
        canvas.drawOval(cannon, darkGray);
        canvas.drawRect(20, 100, 250, 300, darkGray);
        RectF stand = new RectF();
        //canvas.drawCircle(450,150,100,darkGray);
    }
}
