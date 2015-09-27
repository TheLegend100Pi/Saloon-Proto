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
 * Created by MAJID on 21-08-2015.
 */
public class ReviewListViewAdapter extends ArrayAdapter<ReviewListViewItem> {

    public ReviewListViewAdapter(Context context, List<ReviewListViewItem> items) {
        super(context, R.layout.reviews_row, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null) {
            // inflate the GridView item layout
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.reviews_row, parent, false);

            // initialize the view holder
            viewHolder = new ViewHolder();
            viewHolder.revImage = (ImageView) convertView.findViewById(R.id.review_image);
            viewHolder.revName = (TextView) convertView.findViewById(R.id.review_name);
            viewHolder.revDescription = (TextView) convertView.findViewById(R.id.review_descrp);
            viewHolder.revRating=(TextView) convertView.findViewById(R.id.rating);
            convertView.setTag(viewHolder);
        } else {
            // recycle the already inflated view
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // update the item view
        ReviewListViewItem item = getItem(position);
        viewHolder.revImage.setImageDrawable(item.icon);
        viewHolder.revName.setText(item.name);
        viewHolder.revDescription.setText(item.description);
        viewHolder.revRating.setText(item.rating);
        return convertView;
    }


    private static class ViewHolder {
        ImageView revImage;
        TextView revName;
        TextView revDescription;
        TextView revRating;
    }
}
