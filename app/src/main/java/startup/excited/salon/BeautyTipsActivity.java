package startup.excited.salon;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.support.v7.app.ActionBar;



public class BeautyTipsActivity extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beauty_tips);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayShowHomeEnabled(false);
        ab.setDisplayHomeAsUpEnabled(false);
        ab.setDisplayShowTitleEnabled(false);
        //  LayoutInflater li = LayoutInflater.from(this);
        // View customView = getLayoutInflater().inflate(R.layout.home_custom_action_bar, null);
        ab.setCustomView(R.layout.home_custom_action_bar);
        createCutomActionBarTitle();
        ab.setElevation(3.0f);

        ViewPager pager = (ViewPager) findViewById(R.id.beautyViewPager);
        pager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager);

    }

    private void createCutomActionBarTitle(){
        this.getSupportActionBar().setDisplayShowCustomEnabled(true);
        this.getSupportActionBar().setDisplayShowTitleEnabled(false);

        LayoutInflater inflator = LayoutInflater.from(this);
        View v = inflator.inflate(R.layout.home_custom_action_bar, null);

        Typeface tf = Typeface.createFromAsset(getAssets(), "font/Raleway-Medium.ttf");
        ((TextView)v.findViewById(R.id.actionbar_panache)).setTypeface(tf);

        //assign the view to the actionbar
        this.getSupportActionBar().setCustomView(v);
    }
    public static class MyAdapter extends FragmentStatePagerAdapter {
        private static final int NUM_ITEMS = 4;
        CharSequence Titles[] = {"Home", "Services", "Offers", "Reviews"};


        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return beautyTipFragment.newInstance(position);
                case 1:
                    return beautyTipFragment.newInstance(position);
                case 2:
                    return beautyTipFragment.newInstance(position);
                case 3:
                    return beautyTipFragment.newInstance(position);
                default:
                    return beautyTipFragment.newInstance(position);
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return Titles[position];
        }
    }

}

