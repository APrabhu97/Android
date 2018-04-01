package time.q1;

import android.Manifest;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    contacts[] con = new contacts[5];
    Cursor resultSet;
    public static SQLiteDatabase mydatabase;
    public static ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);

        mydatabase = openOrCreateDatabase("myData", MODE_PRIVATE, null);
        mydatabase.execSQL("create table if not exists Contacts(Name varchar(20), Phone varchar(12), savedin varchar(10), email varchar(50), whatsapp varchar(10));");
       // mydatabase.execSQL("delete from Contacts");
//        mydatabase.execSQL("Insert into Contacts values('Anish', '7829077303', 'SIM', 'anishprabhu1997@gmail.com', 'Yes')");
//        mydatabase.execSQL("Insert into Contacts values('Adit', '9423505045', 'Phone', 'aditKaneria@gmail.com', 'Yes')");
//        mydatabase.execSQL("Insert into Contacts values('Chirag', '8344759263', 'Phone', 'chiragIndi@gmail.com', 'No')");
//        mydatabase.execSQL("Insert into Contacts values('Anirudh', '9724478254', 'SIM', 'anirudhRao@gmail.com', 'Yes')");
//        mydatabase.execSQL("Insert into Contacts values('Saurav', '8546298774', 'Phone', 'sauravUpadhyay@gmail.com', 'Yes')");


        resultSet = mydatabase.rawQuery("select * from Contacts", null);
        resultSet.moveToFirst();

        // Defined Array values to show in ListView

//        con[0] = new contacts("Anish", "7829077303", "SIM", "anishprabhu1997@gmail.com", "Yes");
//        con[1] = new contacts("Adit", "9423505045", "Phone", "aditKaneria@gmail.com", "Yes");
//        con[2] = new contacts("Chirag", "8344759263", "Phone", "chiragIndi@gmail.com", "No");
//        con[3] = new contacts("Anirudh", "9724478254", "SIM", "anirudhRao@gmail.com", "Yes");
//        con[4] = new contacts("Saurav", "8546298774", "Phone", "sauravUpadhyay@gmail.com", "Yes");
//
//
//        String[] values = new String[]{
//                con[0].name,
//                con[1].name,
//                con[2].name,
//                con[3].name,
//                con[4].name,
//                resultSet.getString(0)
//        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayList<String> list=new ArrayList<String>();
        resultSet.moveToFirst();
        while(!resultSet.isAfterLast()){
            list.add(resultSet.getString(0));
            resultSet.moveToNext();
    }

    adapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, android.R.id.text1, list);


    // Assign adapter to ListView
        listView.setAdapter(adapter);
        registerForContextMenu(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent myIntent = new Intent(MainActivity.this, EditContact.class);
                myIntent.putExtra("intVariableName", i);
                startActivity(myIntent);
            }
        });

        // ListView Item Click Listener

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.msg:
                messageUser(info.id);
                return true;
            case R.id.call:
                callUser(info.id);
                return true;
            case R.id.saved:
                showSaved(info.id);
                return true;
            case R.id.other:
                showEmail(info.id);
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }

    public void showSaved(long id){
        resultSet.moveToPosition((int)id);
        Toast.makeText(getApplicationContext(),"Saved in: "+resultSet.getString(2),Toast.LENGTH_SHORT).show();
        //Toast.makeText(getApplicationContext(),"Saved in: "+con[(int)id].savedIn,Toast.LENGTH_SHORT).show();
    }
    public void showEmail(long id){
        resultSet.moveToPosition((int)id);
        Toast.makeText(getApplicationContext(),resultSet.getString(3),Toast.LENGTH_SHORT).show();
        // Toast.makeText(getApplicationContext(),con[(int)id].email,Toast.LENGTH_SHORT).show();
    }
    public void callUser(long id) {
        resultSet.moveToPosition((int)id);
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:"+resultSet.getString(1)));
        // callIntent.setData(Uri.parse("tel:"+con[(int)id].number));
        startActivity(callIntent);

    }
    public void messageUser(long id){
        resultSet.moveToPosition((int)id);
        String num = resultSet.getString(1);
        //String num = con[(int)id].number;
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", num, null)));
    }

    public void addNew(View v){
        Intent myIntent = new Intent(MainActivity.this, AddContact.class);
        startActivity(myIntent);
    }
}
