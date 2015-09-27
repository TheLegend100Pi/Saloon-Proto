package startup.excited.salon;

import android.graphics.drawable.Drawable;

public class OfferListViewItem {
    public final Drawable icon;       // the drawable for the ListView item ImageView
    public final String title;        // the text for the ListView item title
    public final String description;// the text for the ListView item description
    public final String validity;

    public OfferListViewItem(Drawable icon, String title, String description,String validity) {
        this.icon = icon;
        this.title = title;
        this.description = description;
        this.validity=validity;
    }
}