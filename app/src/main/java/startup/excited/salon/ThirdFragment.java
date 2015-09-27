package startup.excited.salon;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAJID on 09-08-2015.
 */

public  class ThirdFragment extends ListFragment {
    int mNum;
    private List<OfferListViewItem> mItems;


    /**
     * Create a new instance of CountingFragment, providing "num"
     * as an argument.
     */
    static ThirdFragment newInstance(int num) {
        ThirdFragment f = new ThirdFragment();

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
        View v = inflater.inflate(R.layout.third_frag, container, false);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT);

        mItems = new ArrayList<OfferListViewItem>();
        Resources resources = getResources();

        mItems.add(new OfferListViewItem(resources.getDrawable(R.drawable.sale1), "Independence Day Freedom Sale", "Flat 20% off", "Valid till 30th August"));
        mItems.add(new OfferListViewItem(resources.getDrawable(R.drawable.sale2), "Diwali Bonanza", "Rs. 100 off on any massage", "Valid till 20th November"));
        mItems.add(new OfferListViewItem(resources.getDrawable(R.drawable.sale1), "Independence Day Freedom Sale", "Flat 20% off", "Valid till 30th August"));
        mItems.add(new OfferListViewItem(resources.getDrawable(R.drawable.sale1), "Independence Day Freedom Sale", "Flat 20% off", "Valid till 30th August"));
        mItems.add(new OfferListViewItem(resources.getDrawable(R.drawable.sale1), "Independence Day Freedom Sale", "Flat 20% off", "Valid till 30th August"));
        mItems.add(new OfferListViewItem(resources.getDrawable(R.drawable.sale3), "Christmas Offer", "Rs 200 off", "Valid till 15th December"));
        //mItems.add(new OfferListViewItem(resources.getDrawable(R.drawable.sale3), "Christmas Offer", "Rs 200 off", "Valid till 15th December"));

        OfferListViewAdapter offerAdapter =new OfferListViewAdapter(getActivity(), mItems);
        setListAdapter(offerAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Log.i("FragmentList", "Item clicked: " + id);
    }
}



