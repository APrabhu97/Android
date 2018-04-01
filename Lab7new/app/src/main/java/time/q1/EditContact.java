package time.q1;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static time.q1.MainActivity.mydatabase;

/**
 * Created by mahe on 3/23/2018.
 */

public class EditContact extends Activity {
    String mName;
    String mNumber;
    String mEmail;
    EditText edi1;
    EditText edi2;
    EditText edi3;
    Cursor res;
    Button but;
    Cursor part;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_edit);
        Intent intent = getIntent();
        int intValue = intent.getIntExtra("intVariableName", 0);

        edi1 = (EditText)findViewById(R.id.editText4);
        edi2 = (EditText)findViewById(R.id.editText5);
        edi3 = (EditText)findViewById(R.id.editText6);
        but  = (Button)findViewById(R.id.addy2);

        res = mydatabase.rawQuery("select * from Contacts", null);
        res.moveToPosition(intValue);

        mName = res.getString(0);
        mNumber = res.getString(1);
        mEmail = res.getString(3);

        edi1.setText(mName);
        edi2.setText(mNumber);
        edi3.setText(mEmail);

        if(!but.getText().toString().equals("Done")){
            but.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    edi1.setFocusable(true);
                    edi1.setClickable(true);
                    edi2.setFocusable(true);
                    edi2.setClickable(true);
                    edi3.setFocusable(true);
                    edi3.setClickable(true);
                    but.setText("Done");

                }
            });
        }
//
            but.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   // res = mydatabase.rawQuery("select * from Contacts where Number = "+mNumber+"", null);
                    mydatabase.execSQL("UPDATE Contacts SET Name = '"+edi1.getText().toString()
                            +"', Phone = '"+edi2.getText().toString()
                            +"', Email = '"+ edi3.getText().toString()
                            +"' WHERE Phone ='"+mNumber+"'");
                    Toast.makeText(getApplicationContext(), "Updated Successfully", Toast.LENGTH_SHORT).show();
                }
            });


    }
}
