package startup.excited.salon;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity {
    private ImageView imageViewDot;
    private ViewPager viewPager;
    private ImagePagerAdapter adapter;
    CollapsingToolbarLayout collapsingToolbar;
    private ArrayList<String> mPlanetTitles=new ArrayList<String>();
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ListView secondList;
    private ActionBarDrawerToggle mDrawerToggle;
    // private DrawerLayout mDrawerLayout;
    // private String mActivityTitle;
    ArrayList<NavItem> mNavItems = new ArrayList<NavItem>();
    ArrayList<NavItem> mSepItems=new ArrayList<NavItem>();


    private int[] mImages = new int[] {R.drawable.sale1,R.drawable.sale1,R.drawable.sale1,R.drawable.sale1,R.drawable.sale1 };

    private int[] mImagesDot = new int[] { R.drawable.scroll_dot51,
            R.drawable.scroll_dot52, R.drawable.scroll_dot53,
            R.drawable.scroll_dot54, R.drawable.scroll_dot55 };

    int page = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_home);
       // ActionBar actionBar = getSupportActionBar();
       // actionBar.hide();

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayShowHomeEnabled(false);
        ab.setDisplayHomeAsUpEnabled(false);
        ab.setDisplayShowTitleEnabled(false);
        //  LayoutInflater li = LayoutInflater.from(this);
       // View customView = getLayoutInflater().inflate(R.layout.home_custom_action_bar, null);
        ab.setCustomView(R.layout.home_custom_action_bar);
       createCutomActionBarTitle();
        Typeface tf = Typeface.createFromAsset(getAssets(),"font/gothic_bold.ttf");
        ((TextView)findViewById(R.id.beauty_tips)).setTypeface(tf);
        ((TextView)findViewById(R.id.top_brands)).setTypeface(tf);
        ((TextView)findViewById(R.id.services)).setTypeface(tf);
        ((TextView)findViewById(R.id.book_now)).setTypeface(tf);

        Typeface raleway = Typeface.createFromAsset(getAssets(),"font/Raleway-Medium.ttf");
        ((TextView)findViewById(R.id.men_text)).setTypeface(raleway);
        ((TextView)findViewById(R.id.women_text)).setTypeface(raleway);
        ((TextView)findViewById(R.id.salon_under)).setTypeface(raleway);
        ((TextView)findViewById(R.id.spa_under)).setTypeface(raleway);
        ((TextView)findViewById(R.id.nail_under)).setTypeface(raleway);
        ((TextView) findViewById(R.id.body_under)).setTypeface(raleway);
        ((TextView) findViewById(R.id.search_text)).setTypeface(raleway);
        ((TextView) findViewById(R.id.ask_our_experts)).setTypeface(raleway);
        ((TextView) findViewById(R.id.bigTipTitle)).setTypeface(raleway);
        ((TextView) findViewById(R.id.bigTipDesc)).setTypeface(raleway);
        ((TextView) findViewById(R.id.smallTip1)).setTypeface(raleway);
        ((TextView) findViewById(R.id.smallTip2)).setTypeface(raleway);
        //((TextView) findViewById(R.id.smallTip2)).setTypeface(raleway);
        //((TextView) findViewById(R.id.SmallTip3)).setTypeface(raleway);

        Typeface ralewayIt = Typeface.createFromAsset(getAssets(),"font/Raleway-Italic.ttf");
        ((TextView)findViewById(R.id.quote1)).setTypeface(ralewayIt);
        ((TextView)findViewById(R.id.quote2)).setTypeface(ralewayIt);



    LinearLayout manImage = (LinearLayout) findViewById(R.id.man_image);
        manImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, SpaList.class);
                startActivity(i);
            }
        });
        LinearLayout beautyContainer = (LinearLayout)findViewById(R.id.beautyTipsContainer);
        beautyContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, BeautyTipsActivity.class);
                startActivity(i);
            }
        });
        imageViewDot = (ImageView) this.findViewById(R.id.imageView_dot);

        viewPager = (ViewPager) this.findViewById(R.id.view_pager);
      //  viewPagerBottom = (ViewPager)this.findViewById(R.id.view_pager_bottom);
        adapter = new ImagePagerAdapter();
        viewPager.setAdapter(adapter);
     //   viewPagerBottom.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new OnPageChangeListener() {

            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub

            }

            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub
                imageViewDot.setImageResource(mImagesDot[arg0]);
            }

            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });



/*
        try {
            Field mScroller;
            Interpolator sInterpolator = new AccelerateInterpolator();
            mScroller = ViewPager.class.getDeclaredField("mScroller");
            mScroller.setAccessible(true);
            FixedSpeedScroller scroller = new FixedSpeedScroller(viewPagerBottom.getContext(), sInterpolator);
            //scroller.setFixedDuration(5000);
            mScroller.set(viewPagerBottom, scroller);
        } catch (NoSuchFieldException e) {
        } catch (IllegalArgumentException e) {
        } catch (IllegalAccessException e) {
        }

*/
        String dummy="";
        mNavItems.add(new NavItem("Recently Viewed", "Meetup destination"));
        mNavItems.add(new NavItem("My Appointments", "Change your preferences"));
        mNavItems.add(new NavItem("Notifications", "Get to know about us"));
        mNavItems.add(new NavItem("Favourites",dummy ));
        mNavItems.add(new NavItem("Forum(Ask Experts)",dummy));
        mNavItems.add(new NavItem("Refer",dummy));
        mNavItems.add(new NavItem("Support",dummy));
        mNavItems.add(new NavItem("Rate this App",dummy));
        mNavItems.add(new NavItem("Sign Out",dummy));



        mSepItems.add(new NavItem("Rate",dummy));
        mSepItems.add(new NavItem("Settings",dummy));


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mDrawerList = (ListView) findViewById(R.id.navList);
        DrawerListAdapter adapter = new DrawerListAdapter(this, mNavItems);

        // Set the adapter for the list view
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        // secondList=(ListView) findViewById(R.id.sepList);
        // DrawerListAdapter secondAdapter=new DrawerListAdapter(this,mSepItems);
        // secondList.setAdapter(secondAdapter);



        // Set the list's click listener
        // mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        setupDrawer();

    }


    private class ImagePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mImages.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((ImageView) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Context context = HomeActivity.this;

            ImageView imageView = new ImageView(context);

            int padding = 0;
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            imageView.setImageResource(mImages[position]);

            ((ViewPager) container).addView(imageView, 0);

            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((ImageView) object);

        }

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle
        // If it returns true, then it has handled
        // the nav drawer indicator touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }

    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }
    private void setupDrawer() {

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.drawer_open, R.string.drawer_close){
            /** Called when a drawer has settled in a completely open state. */
           // @SuppressLint("NewApi")
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("Navigation!");
                invalidateOptionsMenu();
            }

            /** Called when a drawer has settled in a completely closed state. */
          //  @SuppressLint("NewApi")
            public void onDrawerClosed(View view) {

                super.onDrawerClosed(view);
                getSupportActionBar().setTitle("My Appointments");
                invalidateOptionsMenu();
            }
        };


        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }
    class NavItem {
        String mTitle;
        String mSubtitle;
        int mIcon;

        public NavItem(String title, String subtitle) {
            mTitle = title;
            mSubtitle = subtitle;

        }


    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView parent, View view, int position,long id) {

            // Highlight the selected item, update the title, and close the drawer
            // update selected item and title, then close the drawer
            Intent i;
            mDrawerList.setItemChecked(position, true);
            setTitle("......");
            if(position==1){
                String text= "menu click... should be implemented";
             //   Toast.makeText(MainActivity.this, text , Toast.LENGTH_LONG).show();
              //  i=new Intent(HomeActivity.this,MyAppointments.class);
              //  startActivity(i);
            }


            //  mDrawer.closeDrawer(mDrawerList);

        }


    }
    class DrawerListAdapter extends BaseAdapter {

        Context mContext;
        ArrayList<NavItem> mNavItems;

        public DrawerListAdapter(Context context, ArrayList<NavItem> navItems) {
            mContext = context;
            mNavItems = navItems;
        }

        @Override
        public int getCount() {
            return mNavItems.size();
        }

        @Override
        public Object getItem(int position) {
            return mNavItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.activity_drawer_item, null);
            }
            else {
                view = convertView;
            }

            TextView titleView = (TextView) view.findViewById(R.id.title);
            //  TextView subtitleView = (TextView) view.findViewById(R.id.subTitle);
            ImageView iconView = (ImageView) view.findViewById(R.id.icon);

            titleView.setText( mNavItems.get(position).mTitle );
            // subtitleView.setText( mNavItems.get(position).mSubtitle );
            iconView.setImageResource(mNavItems.get(position).mIcon);

            return view;
        }



    }

    private void selectItemFromDrawer(int position) {
        if(position==0){
            //ntent intent=new Intent(this,RecentlyAdded.class);
            //tartActivity(intent);
        }
    }

    private void createCutomActionBarTitle(){
        this.getSupportActionBar().setDisplayShowCustomEnabled(true);
        this.getSupportActionBar().setDisplayShowTitleEnabled(false);

        LayoutInflater inflator = LayoutInflater.from(this);
        View v = inflator.inflate(R.layout.home_custom_action_bar, null);

        Typeface tf = Typeface.createFromAsset(getAssets(),"font/Raleway-Medium.ttf");
        ((TextView)v.findViewById(R.id.actionbar_panache)).setTypeface(tf);

        //assign the view to the actionbar
        this.getSupportActionBar().setCustomView(v);
    }

    private class FixedSpeedScroller extends Scroller {

        private int mDuration = 1000;

        public FixedSpeedScroller(Context context) {
            super(context);
        }

        public FixedSpeedScroller(Context context, Interpolator interpolator) {
            super(context, interpolator);
        }

        public FixedSpeedScroller(Context context, Interpolator interpolator, boolean flywheel) {
            super(context, interpolator, flywheel);
        }


        @Override
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            // Ignore received duration, use fixed one instead
            super.startScroll(startX, startY, dx, dy, mDuration);
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy) {
            // Ignore received duration, use fixed one instead
            super.startScroll(startX, startY, dx, dy, mDuration);
        }
    }

}

