package startup.excited.salon;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
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

public  class FirstFragment extends Fragment {
    int mNum;
    //private List<OfferListViewItem> mItems;
    private static GoogleMap mMap;
    private static Double latitude, longitude;
    private static View view;
    private List<OfferListViewItem> mItems;



    /**
     * Create a new instance of CountingFragment, providing "num"
     * as an argument.
     */
    static FirstFragment newInstance(int num) {
        FirstFragment f = new FirstFragment();

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
        view = inflater.inflate(R.layout.first_frag, container, false);
        latitude = 26.78;
        longitude = 72.56;
        TextView addrCap=(TextView)view.findViewById(R.id.addressCaption);
        TextView address=(TextView)view.findViewById(R.id.detAddress);
        addrCap.setTextColor(Color.parseColor("#000000"));
        TextView photoCap=(TextView)view.findViewById(R.id.photosCaption);
        photoCap.setTextColor(Color.parseColor("#000000"));
        TextView openCap=(TextView)view.findViewById(R.id.openFromCap);
        openCap.setTextColor(Color.parseColor("#000000"));
        TextView facCap=(TextView)view.findViewById(R.id.facCap);
        facCap.setTextColor(Color.parseColor("#000000"));
        address.setText("3rd Cross, Byrasandra C.V. Raman Nagar, Near Bagmane Tech Park Back Gate,Bangalore-560093");
        Typeface ralewayIt = Typeface.createFromAsset(getActivity().getAssets(), "font/Raleway-Medium.ttf");
        addrCap.setTypeface(ralewayIt);
        address.setTypeface(ralewayIt);
        photoCap.setTypeface(ralewayIt);
        openCap.setTypeface(ralewayIt);
        TextView days=(TextView)view.findViewById(R.id.days);
        TextView fac1=(TextView)view.findViewById(R.id.fac1);
        TextView fac2=(TextView)view.findViewById(R.id.fac2);
        TextView fac3=(TextView)view.findViewById(R.id.fac3);
        TextView fac4=(TextView)view.findViewById(R.id.fac4);
        TextView fac5=(TextView)view.findViewById(R.id.fac5);
        fac1.setTypeface(ralewayIt);
        fac2.setTypeface(ralewayIt);
    fac3.setTypeface(ralewayIt);
        fac4.setTypeface(ralewayIt);
        fac5.setTypeface(ralewayIt);
        TextView time=(TextView)view.findViewById(R.id.time);
        days.setTypeface(ralewayIt);
        time.setTypeface(ralewayIt);
        facCap.setTypeface(ralewayIt);
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
    /*@Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.WRAP_CONTENT);
        mItems = new ArrayList<OfferListViewItem>();
        Resources resources = getResources();

        mItems.add(new OfferListViewItem(resources.getDrawable(R.drawable.sale1), "Independence Day Freedom Sale", "Flat 20% off", "Valid till 30th August"));
        mItems.add(new OfferListViewItem(resources.getDrawable(R.drawable.sale2), "Diwali Bonanza", "Rs. 100 off on any massage", "Valid till 20th November"));
        mItems.add(new OfferListViewItem(resources.getDrawable(R.drawable.sale3), "Christmas Offer", "Rs 200 off", "Valid till 15th December"));
        mItems.add(new OfferListViewItem(resources.getDrawable(R.drawable.sale3), "Christmas Offer", "Rs 200 off", "Valid till 15th December"));

        OfferListViewAdapter offerAdapter =new OfferListViewAdapter(getActivity(), mItems);
        setListAdapter(offerAdapter);
    }*/
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



