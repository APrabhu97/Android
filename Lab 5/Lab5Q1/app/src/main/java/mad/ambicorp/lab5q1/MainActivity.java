package mad.ambicorp.lab5q1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

    public static String v;
    public  static  String r;
    public static String text;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button submit = (Button) this.findViewById(R.id.submit);
        final EditText vNum = (EditText) this.findViewById(R.id.vno);
        final EditText rcNum=(EditText) this.findViewById(R.id.rcno);

        final Spinner spinner = (Spinner) this.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this , R.array.vehicleType , android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                 v = vNum.getText().toString();
                 r = rcNum.getText().toString();
                 text = spinner.getSelectedItem().toString();
                if((text.equals("None")) || v.equals("") || r.equals(""))
                {
                    Toast.makeText(MainActivity.this , "Fields Cannot Be Empty " , Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent i = new Intent(getApplicationContext() , Main2Activity.class);
                    //i.putExtra("Vehicle" , (CharSequence)vNum);
                   // intent.putExtra("RCNum" , (CharSequence)rcNum);
                    MainActivity.this.startActivity(i);
                }
            }
        });

    }
}
