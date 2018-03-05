package edu.wccnet.customadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class CustomAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter);

        final ListView listview = (ListView)findViewById(R.id.listView2);

        // Note that
        final ArrayList<Vehicle> carList = new ArrayList<Vehicle>();
        Vehicle myVehicle = new Vehicle();
        myVehicle.setImage("old_truck");
        myVehicle.setName("Old Truck");
        carList.add(myVehicle);

        Vehicle myVehicle2 = new Vehicle();
        myVehicle2.setImage("older_truck");
        myVehicle2.setName("Older Truck");
        carList.add(myVehicle2);

        // Where the context is the activity instance, the second parameter is the XML layout for the item (more later), and the last is the array of data
        final VehicleAdapter carAdapter = new VehicleAdapter( this, carList );
        listview.setAdapter(carAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View  view, int position, long id)
            {
                Toast.makeText(CustomAdapterActivity.this, carList.get(position).getName() , Toast.LENGTH_SHORT).show();
            }
        });
    }


}