package startup.excited.salon;

import android.graphics.drawable.Drawable;

/**
 * Created by MAJID on 21-08-2015.
 */
public class ReviewListViewItem {
    public final Drawable icon;       // the drawable for the ListView item ImageView
    public final String name;        // the text for the ListView item title
    public final String description;// the text for the ListView item description
    public final String rating;

    public ReviewListViewItem(Drawable icon, String title, String description,String rating) {
        this.icon = icon;
        this.name = title;
        this.description = description;
        this.rating=rating;
    }
}