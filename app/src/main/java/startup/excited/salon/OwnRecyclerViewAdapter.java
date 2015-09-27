package startup.excited.salon;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.List;


/**
 * Created by JMDMajid on 7/21/2015.
 */
public class OwnRecyclerViewAdapter extends RecyclerView.Adapter<OwnRecyclerViewAdapter.DataObjectHolder> {

        private List<DataObject> mDataset;
        private Context ctx;

        public static class DataObjectHolder extends RecyclerView.ViewHolder {
            CardView cv;
            TextView storename;
            TextView address;
            TextView services,cost,location,rating,facilities;



            public DataObjectHolder(View itemView,Context ct) {
                super(itemView);
                cv=(CardView)itemView.findViewById(R.id.card_view);
                Typeface ralewayMed = Typeface.createFromAsset(ct.getAssets(),"font/Raleway-Medium.ttf");
                Typeface ralewayIt = Typeface.createFromAsset(ct.getAssets(),"font/Raleway-Italic.ttf");
                storename = (TextView) itemView.findViewById(R.id.storename);
                TextView booking=(TextView)itemView.findViewById(R.id.booking);
                booking.setTypeface(ralewayMed);
                TextView rating=(TextView)itemView.findViewById(R.id.curr_loc);
                rating.setTypeface(ralewayMed);
                TextView loc=(TextView)itemView.findViewById(R.id.rating);
                loc.setTypeface(ralewayMed);
                storename.setTypeface(ralewayMed);

                address = (TextView) itemView.findViewById(R.id.address);
                address.setTypeface(ralewayMed);
                //rating=(TextView)itemView.findViewById(R.id.rating);
                services=(TextView)itemView.findViewById(R.id.services);
                services.setTypeface(ralewayIt);
                facilities=(TextView)itemView.findViewById(R.id.facilties);
                facilities.setTypeface(ralewayIt);
                //location=(TextView)itemView.findViewById(R.id.location);
            }

        }



    public OwnRecyclerViewAdapter(Context ct,List<DataObject> myDataset) {
        ctx=ct;
        mDataset = myDataset;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view,ctx);
        return dataObjectHolder;
    }

    @Override
        public void onBindViewHolder(DataObjectHolder holder,int position){

            holder.storename.setText(mDataset.get(position).storename);
            holder.address.setText(mDataset.get(position).address);
           // holder.rating.setText(mDataset.get(position).rating);
            holder.services.setText(mDataset.get(position).services);

           // holder.location.setText(mDataset.get(position).location);
    }


    @Override
    public int getItemCount() {
        return mDataset.size();
    }



}
