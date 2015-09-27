package startup.excited.salon;

import android.graphics.drawable.Drawable;

public class TipsListItem {
    public final int icon;
    public final String shareCount,likeCount;       // the drawable for the ListView item ImageView
    public final String title;        // the text for the ListView item title
    public final String description;// the text for the ListView item description

    public TipsListItem(int icon, String title, String description,String share,String like) {
        this.icon = icon;
        this.title = title;
        this.description = description;
        this.shareCount = share;
        this.likeCount = like;

    }
}