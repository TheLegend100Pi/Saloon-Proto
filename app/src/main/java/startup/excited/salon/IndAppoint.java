package startup.excited.salon;

import android.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;


public class IndAppoint extends AppCompatActivity {
    final static ArrayList<HashMap<String, ?>> data = new ArrayList<HashMap<String, ? >>();
    static{
        HashMap<String, String> row  = new HashMap<String, String>();
        row.put("Service","Hair Cut" );
        row.put("Cost","Rs. 100" );
        data.add(row);
        row  = new HashMap<String, String>();
        row.put("Service", "Head Massage");
        row.put("Cost","Rs. 70" );
        data.add(row);
        row  = new HashMap<String,String>();
        row.put("Service", "Shaving");
        row.put("Cost","Rs. 50" );
        data.add(row);
        row  = new HashMap<String,String>();
        row.put("Service", "Discount");
        row.put("Cost","- Rs. 50" );
        data.add(row);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ind_appoint);
        Toolbar mToolbar = (Toolbar)findViewById(R.id.toolbar);
        mToolbar.setTitle("Naturals");
        ListView serviceList = (ListView) findViewById(R.id.appoint_service);
        SimpleAdapter adapter = new SimpleAdapter(this,
                data,
                R.layout.appoint_service_row,
                new String[] {"Service","Cost"},
                new int[] { R.id.appoint_row_service,R.id.appoint_row_cost});
        serviceList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ind_appoint, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
