package time.grocery;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spi;
    TextView txt;
    SQLiteDatabase myDB;
    ListView list;
    Cursor res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spi = (Spinner)findViewById(R.id.spin);
        txt = (TextView)findViewById(R.id.textView);
        list = (ListView)findViewById(R.id.list);

        myDB = openOrCreateDatabase("grocery",MODE_PRIVATE,null);
        myDB.execSQL("delete from grocery");
        myDB.execSQL("create table if not exists grocery(Items varchar(20), Price varchar(20));");
        myDB.execSQL("insert into grocery values('Celery','10')");
        myDB.execSQL("insert into grocery values('Spinach','20')");
        myDB.execSQL("insert into grocery values('Cabbage','30')");
        myDB.execSQL("insert into grocery values('Carrots','40')");
        myDB.execSQL("insert into grocery values('Tomatos','50')");

        res = myDB.rawQuery("select * from grocery", null);
        res.moveToFirst();

        ArrayList<String> str = new ArrayList<>();
        for(int i=0; i<res.getCount();i++){
            String one = res.getString(0);
            String two = res.getString(1);
            String val = one+" - "+two;
            str.add(val);
            res.moveToNext();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, android.R.id.text1, str);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spi.setAdapter(adapter);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_dropdown_item, android.R.id.text1, str);
//        spi.setAdapter(adapter);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, list);
    }
}
