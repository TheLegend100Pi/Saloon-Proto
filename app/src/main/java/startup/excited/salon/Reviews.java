package startup.excited.salon;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Reviews extends Fragment {
    private TextView textView;
    public static Reviews getInstance(int position){
        Reviews reviews=new Reviews();
        Bundle args=new Bundle();
        args.putInt("position", position);
        reviews.setArguments(args);
        return reviews;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.activity_reviews,container,false);
        textView= (TextView) v.findViewById(R.id.textView);
        Bundle bundle=getArguments();
        if(bundle!=null)
            textView.setText("The Page is"+bundle.getInt("position"));
        return v;
    }
}
