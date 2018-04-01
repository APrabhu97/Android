package time.trainbooking;

import android.app.DatePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    int d,m,y;
    Spinner spi1,spi2;
     EditText dateText;
     public void onClear(View v){
         spi1.setSelection(0);
         spi2.setSelection(0);

         DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
         Calendar cal = Calendar.getInstance();
         dateText.setText(dateFormat.format(cal.getTime()));
     }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         spi1 = (Spinner)findViewById(R.id.spinn);
         spi2 = (Spinner)findViewById(R.id.spinn2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.places
                ,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spi1.setAdapter(adapter);
        spi2.setAdapter(adapter);

        final Button but = (Button)findViewById(R.id.submit);

         dateText = (EditText)findViewById(R.id.editText3);
        dateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogFragment dt = new DatePickerFragment();
                dt.show(getSupportFragmentManager(), "anish");

            }
        });

        ToggleButton tg = (ToggleButton)findViewById(R.id.toggleButton2);
        tg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    //toggle enbled: tatkal
                    DateFormat dateFormat = new SimpleDateFormat("HHmm");
                    Calendar cal = Calendar.getInstance();
                    int time = Integer.parseInt(dateFormat.format(cal.getTime()));
                    if (time > 1100){
                        but.setEnabled(true);
                    }
                    else{
                        but.setEnabled(false);
                        Toast.makeText(getApplicationContext(),"Tatkal onlt available after 1100 hours",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    //toggle disabled: General
                    but.setEnabled(true);
                }
            }
        });

    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

        dateText.setText(i2+"--"+(i1+1)+"--"+i);
    }

    public void onSubmit(View v){
         if(dateText.getText()!=null){
             setContentView(R.layout.booking_result);
             TextView b = (TextView)findViewById(R.id.Result);
             b.setText("No trains available between"+ spi1.getSelectedItem()+ " to "+ spi2.getSelectedItem()+" on "+ dateText.getText());

         }
         else{
             Toast.makeText(getApplicationContext(),"Please specify the date",Toast.LENGTH_SHORT);
         }
     }
}
