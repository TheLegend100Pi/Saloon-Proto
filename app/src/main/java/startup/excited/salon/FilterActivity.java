package startup.excited.salon;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class FilterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        ActionBar actionBar = getActionBar();
        final TextView filter_distance = (TextView) findViewById(R.id.filter_distance);
        filter_distance.setTag(R.drawable.filter_letter_round);
        filter_distance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Integer) filter_distance.getTag() == R.drawable.filter_letter_round) {
                    filter_distance.setBackgroundResource(R.drawable.filter_letter_round_yellow);
                    filter_distance.setTag(R.drawable.filter_letter_round_yellow);
                } else {
                    filter_distance.setBackgroundResource(R.drawable.filter_letter_round);
                    filter_distance.setTag(R.drawable.filter_letter_round);
                }
            }
        });

        final TextView filter_popular = (TextView) findViewById(R.id.filter_popular);
        filter_popular.setTag(R.drawable.filter_letter_round);
        filter_popular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Integer) filter_popular.getTag() == R.drawable.filter_letter_round) {
                    filter_popular.setBackgroundResource(R.drawable.filter_letter_round_yellow);
                    filter_popular.setTag(R.drawable.filter_letter_round_yellow);
                } else {
                    filter_popular.setBackgroundResource(R.drawable.filter_letter_round);
                    filter_popular.setTag(R.drawable.filter_letter_round);
                }
            }
        });

        final TextView filter_rating = (TextView) findViewById(R.id.filter_rating);
        filter_rating.setTag(R.drawable.filter_letter_round);
        filter_rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Integer)filter_rating.getTag() == R.drawable.filter_letter_round) {
                    filter_rating.setBackgroundResource(R.drawable.filter_letter_round_yellow);
                    filter_rating.setTag(R.drawable.filter_letter_round_yellow);
                }
                else {
                    filter_rating.setBackgroundResource(R.drawable.filter_letter_round);
                    filter_rating.setTag(R.drawable.filter_letter_round);
                }
            }
        });

        final TextView filter_men = (TextView) findViewById(R.id.filter_men);
        filter_men.setTag(R.drawable.filter_filter_by);
        filter_men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Integer)filter_men.getTag() == R.drawable.filter_filter_by) {
                    filter_men.setBackgroundResource(R.drawable.filter_filter_by_yellow);
                    filter_men.setTag(R.drawable.filter_filter_by_yellow);
                }
                else {
                    filter_men.setBackgroundResource(R.drawable.filter_filter_by);
                    filter_men.setTag(R.drawable.filter_filter_by);
                }
            }
        });

        final TextView filter_women = (TextView) findViewById(R.id.filter_women);
        filter_women.setTag(R.drawable.filter_filter_by);
        filter_women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Integer)filter_women.getTag() == R.drawable.filter_filter_by) {
                    filter_women.setBackgroundResource(R.drawable.filter_filter_by_yellow);
                    filter_women.setTag(R.drawable.filter_filter_by_yellow);
                }
                else {
                    filter_women.setBackgroundResource(R.drawable.filter_filter_by);
                    filter_women.setTag(R.drawable.filter_filter_by);
                }
            }
        });

        final TextView filter_unisex = (TextView) findViewById(R.id.filter_unisex);
        filter_unisex.setTag(R.drawable.filter_filter_by);
        filter_unisex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Integer)filter_unisex.getTag() == R.drawable.filter_filter_by) {
                    filter_unisex.setBackgroundResource(R.drawable.filter_filter_by_yellow);
                    filter_unisex.setTag(R.drawable.filter_filter_by_yellow);
                }
                else {
                    filter_unisex.setBackgroundResource(R.drawable.filter_filter_by);
                    filter_unisex.setTag(R.drawable.filter_filter_by);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_filter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
