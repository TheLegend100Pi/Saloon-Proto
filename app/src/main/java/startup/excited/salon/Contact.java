package startup.excited.salon;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Contact extends Fragment {

    private TextView textView;
    public static Contact getInstance(int position){
        Contact contact=new Contact();
        Bundle args=new Bundle();
        args.putInt("position", position);
        contact.setArguments(args);
        return contact;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.activity_contact,container,false);
        textView= (TextView) v.findViewById(R.id.textView);
        Bundle bundle=getArguments();
        if(bundle!=null)
            textView.setText("The Page is"+bundle.getInt("position"));
        return v;
    }
}
