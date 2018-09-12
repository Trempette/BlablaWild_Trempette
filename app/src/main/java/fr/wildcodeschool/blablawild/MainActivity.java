package fr.wildcodeschool.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /////////////////////////////////////////////////////////////////////////////////////
        Button buttonInit = findViewById(R.id.buttItin);
        final Intent itinarySearch = new Intent(MainActivity.this, ItinarySearchActivity.class);

        buttonInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(itinarySearch);
            }
        });

    }
}
