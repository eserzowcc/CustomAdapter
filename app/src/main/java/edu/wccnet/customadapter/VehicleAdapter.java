package edu.wccnet.customadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class VehicleAdapter extends ArrayAdapter<Vehicle> {
    private ArrayList<Vehicle> vehicleList;
    Context context;

    public VehicleAdapter( Context context, ArrayList<Vehicle> vehicleList) {
        super(context, R.layout.car_item, vehicleList);
        this.vehicleList = vehicleList;
        this.context=context;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

             // We are inflating the layout that we defined in car_item
            convertView = inflater.inflate(R.layout.car_item,parent, false);

            holder = new ViewHolder();
            holder.text = (TextView)convertView.findViewById(R.id.car_model);
            holder.image=(ImageView)convertView.findViewById(R.id.car_image);

            /************  Set holder with LayoutInflater ************/
            convertView.setTag( holder );
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        if(vehicleList.size()>0) {
            /***** Get each Model object from Arraylist ********/
            Vehicle workingVehicle = vehicleList.get( position );

            holder.text.setText( workingVehicle.getName() );
            holder.image.setImageResource(
                    convertView.getResources().getIdentifier(workingVehicle.getImage(), "drawable", "edu.wccnet.customadapter"));
        }
        return convertView;
    }

    /********* Create a holder Class to contain inflated xml file elements *********/
    public static class ViewHolder{
        public ImageView image;
        public TextView text;
    }

}