package fr.wildcodeschool.blablawild;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicReference;

public class ItinarySearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinary_search);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Button searchItin = findViewById(R.id.buttItinSearch);
        final TextView departureIn = findViewById(R.id.departIn);
        final TextView destinationIn = findViewById(R.id.destinationIn);
        final Intent itinaryList = new Intent(ItinarySearchActivity.this, ItinaryListActivity.class);

        searchItin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final boolean entriesNok= departureIn.getText().toString().isEmpty()||destinationIn.getText().toString().isEmpty();
                if (entriesNok){
                    Toast searchNok = Toast.makeText(getApplicationContext(), getString(R.string.toast), Toast.LENGTH_LONG);
                    searchNok.show();
                }
                else {
                    itinaryList.putExtra("destinationExtra", destinationIn.getText().toString());
                    itinaryList.putExtra("departureExtra", departureIn.getText().toString());
                    startActivity(itinaryList);
                }
            }
        });
    }
}
