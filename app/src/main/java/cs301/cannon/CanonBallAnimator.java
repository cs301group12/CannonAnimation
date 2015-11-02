package cs301.cannon;



import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

/**
 * class that animates a cannonBall being fired from a cannon
 *
 * @author Nathan Camacho
 * @version November 2015
 */
public class CanonBallAnimator implements Animator {

    //Instance variables needed for cannon ball motion
    private int xPos;
    private int yPos;
    private double xVel = 10;
    private double yVel = 10;
    private double yAcc = -9.8;
    private int time = 2;
    private int count = 0; // counts the number of logical clock ticks


    @Override
    public int interval() {
        return 30;//time interval between frames (milliseconds)
    }

    //returns a white background color
    @Override
    public int backgroundColor() {
        return Color.rgb(255,255,255);//white
    }

    //never pause the animation
    @Override
    public boolean doPause() {
        return false;
    }

    //never quit the animation
    @Override
    public boolean doQuit() {
        return false;
    }

    //Method that draws the cannon ball in each frame
    //not fully implemented, does not do what it should
    @Override
    public void tick(Canvas canvas) {
        count++;
        xPos = (int) ((xVel*time)*count);//x equation for projectile motion
        yPos = (int) ((yVel*time + 0.5*yAcc*(time^2))*count);//y equation for projectile motion
        Paint black = new Paint();
        black.setColor(Color.BLACK);
        canvas.drawCircle(xPos,yPos,40,black);//draw cannon ball
    }

    @Override
    public void onTouch(MotionEvent event) {

    }

}
