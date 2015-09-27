package startup.excited.salon;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by MAJID on 09-08-2015.
 */

public  class SecondFragment extends Fragment {
    int mNum;
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    HashMap<String,String> cost;
    HashMap<String,Boolean> tickEnabled;
    private int lastExpandedPosition = -1;
    private  int totalSelected =0;
    private Button book;





    /**
     * Create a new instance of CountingFragment, providing "num"
     * as an argument.
     */
    static SecondFragment newInstance(int num) {
        SecondFragment f = new SecondFragment();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("num", num + 1);
        f.setArguments(args);

        return f;
    }

    /**
     * When creating, retrieve this instance's number from its arguments.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNum = getArguments() != null ? getArguments().getInt("num") : 1;
    }

    /**
     * The Fragment's UI is just a simple text view showing its
     * instance number.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.second_frag, container, false);
        expListView = (ExpandableListView) v.findViewById(R.id.serviceslist);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        int width = displaymetrics.widthPixels;
        //book=(Button)v.findViewById(R.id.bookAppt);
        //book.setVisibility(View.INVISIBLE);
        if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            expListView.setIndicatorBounds(width-100, width);
        } else {
            expListView.setIndicatorBoundsRelative(width - 100, width);
        }

        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandedPosition != -1
                        && groupPosition != lastExpandedPosition) {
                    expListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
            }
        });

        // preparing list data
        prepareListData();

        listAdapter = new ServicesListAdapter(getActivity(), listDataHeader, listDataChild,cost);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                ImageView tick=(ImageView)v.findViewById(R.id.tick);
                tick.setVisibility(View.INVISIBLE);
                if(!tickEnabled.get((listDataChild.get(listDataHeader.get(groupPosition))).get(childPosition)))
                {
                    tickEnabled.put(listDataChild.get(
                            listDataHeader.get(groupPosition)).get(
                            childPosition),new Boolean(Boolean.TRUE));
                    tick.setVisibility(View.VISIBLE);
                    v.setBackgroundColor(Color.parseColor("#FAFAFA"));
                    totalSelected++;
                }
                else
                {
                    tickEnabled.put(listDataChild.get(
                            listDataHeader.get(groupPosition)).get(
                            childPosition),new Boolean(Boolean.FALSE));
                    tick.setVisibility(View.INVISIBLE);
                    v.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    totalSelected--;
                }

                if(totalSelected>0)
                {
                    //book.setVisibility(View.VISIBLE);
                    //book.animate().translationY(-100f).setDuration(1000).setInterpolator(new OvershootInterpolator());
                }
                else
                {
                   // book.setVisibility(View.INVISIBLE);
                   // book.animate().translationY(0f).setDuration(1000).setInterpolator(new OvershootInterpolator());
                }
                Toast.makeText(
                        getActivity().getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition)+" selected", Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });
        return v;
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
        cost=new HashMap<String,String>();
        tickEnabled=new HashMap<String,Boolean>();

        // Adding child data
        listDataHeader.add("Hair Cut");
        listDataHeader.add("Massage");
        listDataHeader.add("Facial");

        // Adding child data
        List<String> hair = new ArrayList<String>();
        hair.add("French Cut");
        cost.put(hair.get(0), "55");
        tickEnabled.put(hair.get(0), new Boolean(Boolean.FALSE));
        hair.add("ghgff");
        cost.put(hair.get(1), "55");
        tickEnabled.put(hair.get(1), new Boolean(Boolean.FALSE));

        hair.add("bkbkjbjb");
        cost.put(hair.get(2), "55");
        tickEnabled.put(hair.get(2), new Boolean(Boolean.FALSE));

        hair.add("bbjjn");
        cost.put(hair.get(3), "55");
        tickEnabled.put(hair.get(3), new Boolean(Boolean.FALSE));

        hair.add("hhjjhjhg");
        cost.put(hair.get(4), "55");
        tickEnabled.put(hair.get(4), new Boolean(Boolean.FALSE));

        hair.add("bhbjbkjj");
        cost.put(hair.get(5), "55");
        tickEnabled.put(hair.get(5), new Boolean(Boolean.FALSE));

        hair.add("jkbkbkjbkj");
        cost.put(hair.get(6), "55");
        tickEnabled.put(hair.get(6), new Boolean(Boolean.FALSE));


        List<String> massage = new ArrayList<String>();
        massage.add("  m m m m m ");
        cost.put(massage.get(0), "55");
        tickEnabled.put(massage.get(0), new Boolean(Boolean.FALSE));

        massage.add("kjbjbkjbjb");
        cost.put(massage.get(1), "55");
        tickEnabled.put(massage.get(1), new Boolean(Boolean.FALSE));

        massage.add("jhvhvjhv");
        cost.put(massage.get(2), "55");
        tickEnabled.put(massage.get(2), new Boolean(Boolean.FALSE));

        massage.add("gcvjhjhb");
        cost.put(massage.get(3), "55");
        tickEnabled.put(massage.get(3), new Boolean(Boolean.FALSE));

        massage.add("jjnkjnjn");
        cost.put(massage.get(4), "55");
        tickEnabled.put(massage.get(4), new Boolean(Boolean.FALSE));

        massage.add("jbjbbjbjk");
        cost.put(massage.get(5), "55");
        tickEnabled.put(massage.get(5), new Boolean(Boolean.FALSE));



        List<String> facial = new ArrayList<String>();
        facial.add("jjnlnlnk");
        cost.put(facial.get(0), "55");
        tickEnabled.put(facial.get(0), new Boolean(Boolean.FALSE));

        facial.add("jjjnnnkn");
        cost.put(facial.get(1), "55");
        tickEnabled.put(facial.get(1), new Boolean(Boolean.FALSE));

        facial.add("njjkjkjbjb");
        cost.put(facial.get(2), "55");
        tickEnabled.put(facial.get(2), new Boolean(Boolean.FALSE));

        facial.add("jnnjnjnjn");
        cost.put(facial.get(3), "55");
        tickEnabled.put(facial.get(3), new Boolean(Boolean.FALSE));

        facial.add("nnnnnlknl");
        cost.put(facial.get(4), "55");
        tickEnabled.put(facial.get(4), new Boolean(Boolean.FALSE));


        listDataChild.put(listDataHeader.get(0), hair); // Header, Child data
        listDataChild.put(listDataHeader.get(1), massage);
        listDataChild.put(listDataHeader.get(2), facial);
    }

/*
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT);

        TextView textView = new TextView(getActivity());
        textView.setPadding(16, 16, 16, 16);
        textView.setText("Fragment#" + mNum);
        textView.setLayoutParams(params);
        getListView().addHeaderView(textView);
        mItems = new ArrayList<OfferListViewItem>();
        Resources resources = getResources();

        mItems.add(new OfferListViewItem(resources.getDrawable(R.drawable.sale1), "Independence Day Freedom Sale", "Flat 20% off", "Valid till 30th August"));
        mItems.add(new OfferListViewItem(resources.getDrawable(R.drawable.sale2), "Diwali Bonanza", "Rs. 100 off on any massage", "Valid till 20th November"));

        OfferListViewAdapter offerAdapter =new OfferListViewAdapter(getActivity(), mItems);
        setListAdapter(offerAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Log.i("FragmentList", "Item clicked: " + id);
    }*/
}



