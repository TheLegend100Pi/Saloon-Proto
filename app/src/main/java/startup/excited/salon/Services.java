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


public class Services extends Fragment {

    private TextView textView;
    public static Services getInstance(int position){
        Services services=new Services();
        Bundle args=new Bundle();
        args.putInt("position", position);
        services.setArguments(args);
        return services;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.activity_services,container,false);
        textView= (TextView) v.findViewById(R.id.textView);
        Bundle bundle=getArguments();
        if(bundle!=null)
            textView.setText("The Page is"+bundle.getInt("position"));
        return v;
    }}

