package time.q3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spin;
    Button b1;
    EditText ed1, ed2;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin = (Spinner)findViewById(R.id.spinner);
        b1 = (Button)findViewById(R.id.button);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed1.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Enter Vehicle Reg no", Toast.LENGTH_SHORT);
                    return;
                }
                if(ed2.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext()," Enter RC no", Toast.LENGTH_SHORT);
                    return;
                }
                setContentView(R.layout.result);
                final TextView tv = (TextView)findViewById(R.id.rese);
                tv.setText("Vehicle details:\n"+"Vecicle No: "+ed1.getText().toString()+"\nRc no: "+ed2.getText().toString()+"\nType: "+spin.getSelectedItem().toString()+"\n Parking Serial No: "+(++count));
            }
        });

    }
}
