package fr.wildcodeschool.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ItinaryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinary_list);

        Intent intent = getIntent();
        String destination = intent.getStringExtra("destinationExtra");
        String departure = intent.getStringExtra("departureExtra");
        setTitle(departure + " >>>>> " + destination );
    }
}
