package startup.excited.salon;

import android.content.Context;
import android.graphics.Typeface;
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
public class TipsListViewAdapter extends ArrayAdapter<TipsListItem> {

    public TipsListViewAdapter(Context context, List<TipsListItem> items) {
        super(context, R.layout.tips_row, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView == null) {
            // inflate the GridView item layout
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.tips_row, parent, false);
            Typeface ralewayMed = Typeface.createFromAsset(getContext().getAssets(), "font/Raleway-Medium.ttf");

            // initialize the view holder
            viewHolder = new ViewHolder();
            viewHolder.tipImage = (ImageView) convertView.findViewById(R.id.tips_image);

            viewHolder.tipHead = (TextView) convertView.findViewById(R.id.tips_title);
            viewHolder.tipHead.setTypeface(ralewayMed);
            viewHolder.tipDescription = (TextView) convertView.findViewById(R.id.tips_description);
            viewHolder.tipDescription.setTypeface(ralewayMed);
            viewHolder.tipsLikeCount = (TextView)convertView.findViewById(R.id.like_count);
            viewHolder.tipsShareCount = (TextView)convertView.findViewById(R.id.share_count);
            convertView.setTag(viewHolder);
        } else {
            // recycle the already inflated view
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // update the item view
        TipsListItem item = getItem(position);
        viewHolder.tipImage.setBackgroundResource(item.icon);
        viewHolder.tipHead.setText(item.title);
        viewHolder.tipDescription.setText(item.description);
        viewHolder.tipsLikeCount.setText(item.likeCount);
        viewHolder.tipsShareCount.setText(item.shareCount);
        return convertView;
    }


    private static class ViewHolder {
        ImageView tipImage;
        TextView tipHead;
        TextView tipDescription;
        TextView tipsLikeCount,tipsShareCount;
    }
}
