package fr.wildcodeschool.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ItinaryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinary_list);

        Intent intent = getIntent();
        String destination = intent.getStringExtra("destinationExtra");
        String departure = intent.getStringExtra("departureExtra");
        setTitle(departure + " >>>>> " + destination );

        ListView listTrip = findViewById(R.id.list_trip);
        ArrayList<TripModel> results = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-kk:mm");

        try {
            results.add(new TripModel("Eric", "Cartman", sdf.parse("21/02/2017-15:30"), 15));
            results.add(new TripModel("Stan", "Marsh", sdf.parse("21/02/2017-16:00"), 20));
            results.add(new TripModel("Kenny", "Broflovski", sdf.parse("21/02/2017-16:30"), 16));
            results.add(new TripModel("Kyle", "McCormick", sdf.parse("21/02/2017-17:00"), 40));
            results.add(new TripModel("Wendy", "Testaburger", sdf.parse("21/02/2017-17:30"), 20));
        } catch (ParseException e) {
           Toast toast = Toast.makeText(this, "exception", Toast.LENGTH_LONG);
            toast.show();
        }
        

        TripAdapter adapter = new TripAdapter(this, results);
        listTrip.setAdapter(adapter);


    }
}
