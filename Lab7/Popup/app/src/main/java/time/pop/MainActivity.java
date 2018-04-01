package time.pop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showPop(View v){
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.one:
                        Toast.makeText(getApplicationContext(),"One",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.two:
                        Toast.makeText(getApplicationContext(),"Two",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.three:
                        Toast.makeText(getApplicationContext(),"Three2",Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });
        popupMenu.getMenuInflater().inflate(R.menu.context_menu,popupMenu.getMenu());
        popupMenu.show();
    }

}
