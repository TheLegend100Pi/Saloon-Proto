package startup.excited.salon;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;


public class SpaList extends Activity {

    private RecyclerView mRecyclerView;
    /*private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;*/
    private List<DataObject> data;
    private Context ctx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spa_list);

        //getActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar ab = getActionBar();
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayShowHomeEnabled(false);
        ab.setDisplayHomeAsUpEnabled(false);
        ab.setDisplayShowTitleEnabled(false);
      //  LayoutInflater li = LayoutInflater.from(this);
        View customView = getLayoutInflater().inflate(R.layout.custom_action_bar, null);
        ab.setCustomView(R.layout.custom_action_bar);
        createCutomActionBarTitle();

      /*  ImageButton ibItem1 = (ImageButton) customView.findViewById(R.id.search_button);
        ibItem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ...
            }
        });

        ImageButton ibItem2 = (ImageButton) customView.findViewById(R.id.back_button);
        ibItem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ...
            }
        });
*/
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        LinearLayoutManager llm=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(llm);
        mRecyclerView.setHasFixedSize(true);
        initData();
        initialiseAdapter();
        TextView loc = (TextView) findViewById(R.id.edit_currnt_loc);
        Context context=getApplicationContext();
        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(context, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent i = new Intent(SpaList.this, DetailedShop.class);
                        startActivity(i);
                    }
                })
        );
        /*CardView card=(CardView)findViewById(R.id.card_view);
        card.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent i = new Intent(SpaList.this, DetailedShop.class);
                startActivity(i);
        }});*/
        /*loc.setOnClickListener(new View.OnClickListener() {
            @Override

            }
        });*/

        /*ImageButton filterCards = (ImageButton) findViewById(R.id.filter_cards);
        filterCards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SpaList.this, FilterActivity.class);
                startActivity(i);
            }
        });
        *

        TextView filterCheck = (TextView) findViewById(R.id.filter1);
        filterCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SpaList.this, DetailedShop.class);
                startActivity(i);
            }
        });*/

    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_spa_list, menu);
        return super.onCreateOptionsMenu(menu);
    }
*/
private void createCutomActionBarTitle(){
    this.getActionBar().setDisplayShowCustomEnabled(true);
    this.getActionBar().setDisplayShowTitleEnabled(false);

    LayoutInflater inflator = LayoutInflater.from(this);
    View v = inflator.inflate(R.layout.custom_action_bar, null);
    Typeface ralewayIt = Typeface.createFromAsset(getAssets(), "font/Raleway-Medium.ttf");
    ((TextView)v.findViewById(R.id.title_text)).setTypeface(ralewayIt);

    //assign the view to the actionbar
    this.getActionBar().setCustomView(v);
}
    private void initialiseAdapter(){
        ctx=getBaseContext();

        OwnRecyclerViewAdapter adapter=new OwnRecyclerViewAdapter(ctx,data);
        mRecyclerView.setAdapter(adapter);
    }

    private void initData() {
        data = new ArrayList<>();
        data.add(new DataObject("Majid's Spa", "Hosur Road, Bangalore","4.7","Unisex Salon","250m from CV Raman Nagar"));
        data.add(new DataObject("Bala's Spa", "CV Raman Nagar, Bangalore","4.0","Unisex Salon","150m from CV Raman Nagar"));
        data.add(new DataObject("Gautham's Spa", "Marathalli, Bangalore","4.8","Unisex Salon","50m from CV Raman Nagar"));
        data.add(new DataObject("Gautham's Spa", "Marathalli, Bangalore","4.8","Unisex Salon","50m from CV Raman Nagar"));
        data.add(new DataObject("Gautham's Spa", "Marathalli, Bangalore","4.8","Unisex Salon","50m from CV Raman Nagar"));
    }

}

