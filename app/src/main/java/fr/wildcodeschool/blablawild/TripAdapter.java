package fr.wildcodeschool.blablawild;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TripAdapter extends ArrayAdapter<TripModel> {

    public TripAdapter(Context context, ArrayList<TripModel> trips){
        super(context, 0, trips);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy-kk:mm");


        // Get the data item for this position
        TripModel trip = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_trip, parent, false);
        }
        // Lookup view for data population
        TextView nom = convertView.findViewById(R.id.nom);
        TextView prenom = convertView.findViewById(R.id.prenom);
        TextView date = convertView.findViewById(R.id.date);
        TextView prix = convertView.findViewById(R.id.prix);



        // Populate the data into the template view using the data object
        nom.setText(trip.getNom());
        prenom.setText(trip.getPrenom());
        prix.setText(Integer.toString(trip.getPrix())+" €");
        date.setText(simpleDateFormat.format(trip.getDate()));



        // Return the completed view to render on screen
        return convertView;
    }


}






