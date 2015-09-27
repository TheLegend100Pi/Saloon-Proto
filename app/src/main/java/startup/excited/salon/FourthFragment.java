


/**
 * Created by MAJID on 09-08-2015.
 */
package startup.excited.salon;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
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

public  class FourthFragment extends ListFragment {
    int mNum;
    private List<ReviewListViewItem> mItems;


    /**
     * Create a new instance of CountingFragment, providing "num"
     * as an argument.
     */
    static FourthFragment newInstance(int num) {
        FourthFragment f = new FourthFragment();

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
        View v = inflater.inflate(R.layout.activity_fourth_fragment, container, false);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT);


        mItems = new ArrayList<ReviewListViewItem>();
        Resources resources = getResources();


        mItems.add(new ReviewListViewItem(resources.getDrawable(R.drawable.sale1), "Gautham Sreenivas", "This spa is awesome dashasf ahsfhjfh hdhas hhahdidah sihfiahi haihiadh diahidh adhihaih dhiahdi adhiadhida dhiadhidhshaaua adhdhahdi idhiahih aifhaif", "4.2"));
        mItems.add(new ReviewListViewItem(resources.getDrawable(R.drawable.sale2), "Md Majid Jahangir", "Rs. 100 off on any massage hahahhf iafhdhaidh aidhidh aidhiahdi ihaidhaidhiadh ihiadhdihaidhh iadhiadhid adhidhaid iihiadhiadh ", "4.5"));
        mItems.add(new ReviewListViewItem(resources.getDrawable(R.drawable.sale3), "Balachandran AR", "hihifh daiaidhidh i idhiahdiahdi ihdaihdiahdi iahdiahdih ihdiahdihadi iadhihdihd ihaddihdaihdiah ihadihdihid iadhihihdo cchiihdihidhidah aidhiadhiadhi", "4.0"));

        ReviewListViewAdapter revAdapter =new ReviewListViewAdapter(getActivity(), mItems);
        setListAdapter(revAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Log.i("FragmentList", "Item clicked: " + id);
    }
}



