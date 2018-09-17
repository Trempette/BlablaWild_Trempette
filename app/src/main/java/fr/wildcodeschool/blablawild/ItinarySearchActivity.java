package fr.wildcodeschool.blablawild;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;



public class ItinarySearchActivity extends AppCompatActivity {

    private void updateLabel(TextView datePick, Calendar myCalendar) {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRENCH);
        datePick.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinary_search);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Button searchItin = findViewById(R.id.buttItinSearch);
        final TextView departureIn = findViewById(R.id.departIn);
        final TextView destinationIn = findViewById(R.id.destinationIn);
        final TextView datePick = findViewById(R.id.dateIn);
        final Calendar myCalendar = Calendar.getInstance();
        final int mYear=myCalendar.get(Calendar.YEAR);
        final int mMonth=myCalendar.get(Calendar.MONTH);
        final int mDay=myCalendar.get(Calendar.DAY_OF_MONTH);



        final DatePickerDialog.OnDateSetListener date =  new DatePickerDialog.OnDateSetListener() {
            @Override

            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel(datePick, myCalendar);

            }
        };

        datePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(ItinarySearchActivity.this, date,mYear,mMonth,mDay).show();
            }
        });


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
