package time.q1;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static time.q1.MainActivity.adapter;
import static time.q1.MainActivity.mydatabase;

/**
 * Created by mahe on 3/23/2018.
 */

public class AddContact extends AppCompatActivity {
    Button add;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact);


        edi1 = (EditText)findViewById(R.id.editText);
        edi2 = (EditText)findViewById(R.id.editText2);
        edi3 = (EditText)findViewById(R.id.editText3);
        add = (Button)findViewById(R.id.addy);

    }
    String mName;
    String mNumber;
    String mEmail;
    EditText edi1;
    EditText edi2;
    EditText edi3;

    public void addContact(View a){

        if(edi1.getText().toString().isEmpty() || edi2.getText().toString().isEmpty() || edi3.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT);
            return;
        }
        edi1 = (EditText)findViewById(R.id.editText);
        edi2 = (EditText)findViewById(R.id.editText2);
        edi3 = (EditText)findViewById(R.id.editText3);

        mName = edi1.getText().toString();
        mNumber = edi2.getText().toString();
        mEmail = edi3.getText().toString();

        mydatabase.execSQL("Insert into Contacts values('"+mName+"', '"+mNumber+"', 'SIM', '"+mEmail+"', 'Yes')");
        adapter.notifyDataSetChanged();
        Toast.makeText(getApplicationContext(), "Contact Added", Toast.LENGTH_SHORT);
        startActivity(new Intent(this,MainActivity.class));
    }
}
