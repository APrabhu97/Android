package time.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.MenuPopupWindow;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    MenuItem l;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.ex_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.home:
                startActivity(new Intent(this, MainActivity.class));
                break;
            case R.id.contacts:
                startActivity(new Intent(this, contactUs.class));
                break;
            case R.id.item1:
                startActivity(new Intent(this, cour.class));
                break;
            case R.id.item2:
                startActivity(new Intent(this, admin.class));
                break;
            case R.id.item3:
                setContentView(R.layout.faculty);
                break;
            case R.id.about:
                setContentView(R.layout.about_me);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
