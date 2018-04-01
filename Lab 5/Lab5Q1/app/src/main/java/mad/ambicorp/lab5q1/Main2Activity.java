package mad.ambicorp.lab5q1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import static mad.ambicorp.lab5q1.MainActivity.r;
import static mad.ambicorp.lab5q1.MainActivity.text;
import static mad.ambicorp.lab5q1.MainActivity.v;


public class Main2Activity extends Activity {

   public static int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String str = null;
     //   Bundle b = getIntent().getExtras();


        str = " Vehicle Type : "+ text + "\nVehicle Number : " +  v + "\n" + "RC Number : " + r + "\n" + "Press The Button to Verify ";
        final Button button = (Button) this.findViewById(R.id.button);
        final TextView tv = (TextView) this.findViewById(R.id.textView2);

        tv.setText(str);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                counter  += 1;
                String str = "Your Parking is Confirmed !!\n ID : " + counter;
                Toast.makeText(Main2Activity.this , str , Toast.LENGTH_SHORT ).show();

                Intent i = new Intent(getApplicationContext() , MainActivity.class);
                Main2Activity.this.startActivity(i);

            }
        });
    }
}
