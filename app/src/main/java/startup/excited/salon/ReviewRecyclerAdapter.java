package startup.excited.salon;

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
public class ReviewRecyclerAdapter extends RecyclerView.Adapter<ReviewRecyclerAdapter.DataObjectHolder> {

    private List<DataObject> mDataset;

    public static class DataObjectHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView storename;
        TextView address;
        TextView services,cost,location,rating;


        public DataObjectHolder(View itemView) {
            super(itemView);
            cv=(CardView)itemView.findViewById(R.id.cardview);
            storename = (TextView) itemView.findViewById(R.id.storenames);
            address = (TextView) itemView.findViewById(R.id.addresses);
            rating=(TextView)itemView.findViewById(R.id.ratings);
            services=(TextView)itemView.findViewById(R.id.service);
            cost=(TextView)itemView.findViewById(R.id.costs);
            location=(TextView)itemView.findViewById(R.id.locations);
        }

    }



    public ReviewRecyclerAdapter(List<DataObject> myDataset) {
        mDataset = myDataset;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.review_cardview, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder,int position){
        holder.storename.setText(mDataset.get(position).storename);
        holder.address.setText(mDataset.get(position).address);
        holder.rating.setText(mDataset.get(position).rating);
        holder.services.setText(mDataset.get(position).services);
      //  holder.cost.setText(mDataset.get(position).cost);
        holder.location.setText(mDataset.get(position).location);
    }


    @Override
    public int getItemCount() {
        return mDataset.size();
    }



}
