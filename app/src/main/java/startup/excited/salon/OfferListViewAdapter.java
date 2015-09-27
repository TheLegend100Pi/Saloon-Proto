package startup.excited.salon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by MAJID on 16-08-2015.
 */
public class OfferListViewAdapter extends ArrayAdapter<OfferListViewItem> {

    public OfferListViewAdapter(Context context, List<OfferListViewItem> items) {
        super(context, R.layout.offers_row, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null) {
            // inflate the GridView item layout
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.offers_row, parent, false);

            // initialize the view holder
            viewHolder = new ViewHolder();
            viewHolder.offerImage = (ImageView) convertView.findViewById(R.id.offer_image);
            viewHolder.offerHead = (TextView) convertView.findViewById(R.id.offer_head);
            viewHolder.offerDescription = (TextView) convertView.findViewById(R.id.offerDescription);
            viewHolder.offerValidity=(TextView) convertView.findViewById(R.id.offerValidity);
            convertView.setTag(viewHolder);
        } else {
            // recycle the already inflated view
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // update the item view
        OfferListViewItem item = getItem(position);
        viewHolder.offerImage.setImageDrawable(item.icon);
        viewHolder.offerHead.setText(item.title);
        viewHolder.offerDescription.setText(item.description);
        viewHolder.offerValidity.setText(item.validity);
        return convertView;
    }


    private static class ViewHolder {
        ImageView offerImage;
        TextView offerHead;
        TextView offerDescription;
        TextView offerValidity;
    }
}
