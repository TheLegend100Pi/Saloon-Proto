package startup.excited.salon;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private static int SPLASH_TIME_OUT = 2000;
	ImageButton fButton = null;
	ImageButton gButton = null;
	ImageView panacheText = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.first_splash);
		DisplayMetrics displaymetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		final int screenHeight = displaymetrics.heightPixels;
		int screenWidth = displaymetrics.widthPixels;
	//	ActionBar actionBar = getActionBar();
	//	actionBar.hide();
		final TextView splashSkip = (TextView) findViewById(R.id.splash_skip);
		splashSkip.setAlpha(0f);
		splashSkip.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(MainActivity.this, HomeActivity.class);
				startActivity(i);
				overridePendingTransition(R.anim.fade_in, R.anim.slide_up_out);
			}
		});
		 fButton = (ImageButton) findViewById(R.id.fButton);
		 gButton = (ImageButton) findViewById(R.id.gButton);
		panacheText = (ImageView) findViewById(R.id.panache_text);
		fButton.setVisibility(View.INVISIBLE);
		gButton.setVisibility(View.INVISIBLE);
		new Handler().postDelayed(new Runnable() {
			 
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
 
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
				/*
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
				overridePendingTransition(R.anim.fade_in, R.anim.slide_up_out);

                // close this activity
                finish();
                */

				/*
				final ObjectAnimator horizontalAnimator = ObjectAnimator.ofInt(new ButtonAnimatorHelper(fButton), "marginLeft", 0, 600);

				horizontalAnimator.setDuration(2000);
				horizontalAnimator.setRepeatCount(ValueAnimator.INFINITE);
				horizontalAnimator.setRepeatMode(ValueAnimator.REVERSE);
				horizontalAnimator.setInterpolator(new LinearInterpolator());

				horizontalAnimator.start();

				final ObjectAnimator verticalAnimator = ObjectAnimator.ofInt(fButton,"y",400);
				verticalAnimator.setDuration(1000);
				verticalAnimator.setRepeatCount(ValueAnimator.INFINITE);
				verticalAnimator.setRepeatMode(ValueAnimator.REVERSE);
				verticalAnimator.setInterpolator(new LinearInterpolator());

				verticalAnimator.start();
				*/
				panacheText.animate().translationY(-screenHeight/5).setDuration(500).setInterpolator(new AccelerateDecelerateInterpolator());
				fButton.setVisibility(View.VISIBLE);
				fButton.animate().translationY(-screenHeight/2.5f).setDuration(1000).setInterpolator(new OvershootInterpolator());
				splashSkip.animate().alpha(1f).setDuration(1200).setInterpolator(new AccelerateDecelerateInterpolator());
				new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

					@Override
					public void run() {
						gButton.setVisibility(View.VISIBLE);
						gButton.animate().translationY(-screenHeight/2.5f).setDuration(1000).setInterpolator(new OvershootInterpolator());
					}
				}, 75);


            }
        }, SPLASH_TIME_OUT);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private static class ButtonAnimatorHelper {

		final ImageButton mButton;

		public ButtonAnimatorHelper(final ImageButton button) {
			mButton = button;
		}

		public void setMarginLeft(final int margin) {
			final ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) mButton.getLayoutParams();

			params.leftMargin = margin;

			mButton.setLayoutParams(params);
		}
	}
}
