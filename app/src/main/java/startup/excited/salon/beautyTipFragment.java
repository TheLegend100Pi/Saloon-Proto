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

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MAJID on 09-08-2015.
 */

public  class beautyTipFragment extends ListFragment {
    int mNum;
    //private List<OfferListViewItem> mItems;
    private static View view;
    private List<TipsListItem> mItems;



    /**
     * Create a new instance of CountingFragment, providing "num"
     * as an argument.
     */
    static beautyTipFragment newInstance(int num) {
        beautyTipFragment f = new beautyTipFragment();

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
        if (container == null) {
            return null;
        }
        view = inflater.inflate(R.layout.beauty_tip_frag, container, false);


        // setUpMapIfNeeded();
        return view;
    }


    /* public  void setUpMapIfNeeded() {
         // Do a null check to confirm that we have not already instantiated the map.
         if (mMap == null) {
             // Try to obtain the map from the SupportMapFragment.
             mMap = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.location_map)).getMap();
             // Check if we were successful in obtaining the map.
             if (mMap != null)
                 setUpMap();
         }
     }
 
     private static void setUpMap() {
         // For showing a move to my loction button
         mMap.setMyLocationEnabled(true);
         // For dropping a marker at a point on the Map
         mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title("Majid's SPa").snippet("Address"));
         // For zooming automatically to the Dropped PIN Location
         mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude,
                 longitude), 12.0f));
     }
 */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT);
        mItems = new ArrayList<TipsListItem>();
        Resources resources = getResources();

        //mItems.add(new OfferListViewItem(resources.getDrawable(R.drawable.sale1), "Independence Day Freedom Sale", "Flat 20% off", "Valid till 30th August"));
        mItems.add(new TipsListItem(R.drawable.tip_top,"Half up Fishtail hair","I totally meant to post this tutorial this weekend but as it happens I got super sick Friday night and was locked in my room all day Saturday to recover and not to contaminate the rest of our house. Read more at http://manouvellemode.com/2015/08/17/half-up-fishtail-hair-tutorial/#XIIRzTV024oIH0zT.99","2.5k","3.5k"));
        mItems.add(new TipsListItem(R.drawable.tip_two,"How to wear a Turban Headband","You know those weeks days when you are hair is dirty and you just dont want to throw it in a ponytail again? You dont have time to braid and you are out of ideas.\n" +
                "Read more at http://manouvellemode.com/2015/08/10/how-to-wear-a-turban-headband/#KJI58xzilpsfIcRP.99","4.7k","6.7k"));
        mItems.add(new TipsListItem(R.drawable.tip_three,"Half up Fishtail hair","The weather is warming up and we are all headed to the water! Okay, maybe not just yet, but we are getting closer! I thought it would be the perfect time to share a simple beach makeup routine for when you are by the water\n" +
                "Read more at http://manouvellemode.com/category/beauty/page/3/#7RY6rhytKT8gKbxp.99","1.1k","5.5k"));
        TipsListViewAdapter offerAdapter =new TipsListViewAdapter(getActivity(), mItems);
        setListAdapter(offerAdapter);
    }
   /* public void onViewCreated(View view, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
      /*  if (mMap != null)
            setUpMap();

        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) DetailedShop.fragmentManager
                    .findFragmentById(R.id.location_map)).getMap(); // getMap is deprecated
            // Check if we were successful in obtaining the map.
            if (mMap != null)
                setUpMap();
        }*
    }

    /**** The mapfragment's id must be removed from the FragmentManager
     **** or else if the same it is passed on the next time then
     **** app will crash ****/
    //@Override
 /*  public void onDestroyView() {
        super.onDestroyView();
        if (mMap != null) {
            DetailedShop.fragmentManager.beginTransaction()
                    .remove(DetailedShop.fragmentManager.findFragmentById(R.id.location_map)).commit();
            mMap = null;
        }
    }*/

}



