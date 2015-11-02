package cs301.cannon;

import android.graphics.Canvas;
import android.graphics.Path;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SimpleAdapter;

/**
 * CannonMainActivity
 * 
 * This is the activity for the cannon animation. It creates a AnimationCanvas
 * containing a particular Animator object
 * 
 * @author Andrew Nuxoll
 * @author Nathan Camacho
 * @version November 2015
 * 
 */
public class CannonMainActivity extends Activity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

	//Instance variables
	//variables needed for rotation of cannon
	Cannon cannon;
	private Canvas canvas;


	private Button fire;
	private Button changeGravity;//not implemented
	private EditText inGravity;
	private SeekBar adjustCannon;
	private int progressChanged = 0;//store seekBar progress
	private int rotation = 0;//degrees that cannon will be rotated

	//variables for cannon sound
	private SoundPool cannonSound = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
	private int soundId;


	/**
	 * initializes instance variables
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cannon_main);

		//initialize buttons and set onClickListeners
		fire = (Button) findViewById(R.id.fireButton);
		fire.setOnClickListener(this);
		changeGravity = (Button) findViewById(R.id.changeGravity);
		changeGravity.setOnClickListener(this);
		inGravity = (EditText) findViewById(R.id.inGravity);

		//initialize seekBar and setOnSeekBarChangeListener
		adjustCannon = (SeekBar)findViewById(R.id.cannonSeekBar);
		adjustCannon.setOnSeekBarChangeListener(this);

		//load the cannon sound
		this.soundId = cannonSound.load(this, R.raw.cannon, 1);

		//initialize cannon surface view object and set onTouchListener
		//on touch method not implemented
		cannon = (Cannon) findViewById(R.id.cannonSV);
		cannon.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				return true;
			}
		});


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.cannon_main, menu);
		return true;
	}


	public int getRotation() { return rotation; }

	//Handles when a button is clicked
	@Override
	public void onClick(View view) {
		if (view == fire) { //if fire button is clicked
			cannonSound.play(this.soundId, 1, 1, 1, 0, 1.0f);//play the sound
			//create new AnimationCanvas and CannonBallAnimator object and draw it on main layout
			//does not work, animation is displayed over all other drawings on screen
			Animator cannonBall = new CanonBallAnimator();
			AnimationCanvas cannonCanvas = new AnimationCanvas(this, cannonBall);
			LinearLayout layout = (LinearLayout) this.findViewById(R.id.topLevelLayout);
			layout.addView(cannonCanvas);
		}
	}


	//method to handle when the seekBar is changed
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
		//code to rotate the canvas that the cannon is drawn on
		progressChanged = progress;
		canvas = cannon.getHolder().lockCanvas();
		rotation = progressChanged;//update the rotation angle
		cannon.getHolder().unlockCanvasAndPost(canvas);
		cannon.postInvalidate();
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {

	}

	//return the new Gravity entered by the user
	public int getGravity() { return Integer.parseInt(inGravity.getText().toString()); }

}
