package time.eval;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
    String[] text0 = { "Book1", "Book2", "Book3",
            "Book4", "Book5", "Book6", "Book7" };
    String[] text1 = { "1", "2", "3",
            "4", "5", "6", "7" };
    int[] val1 = { 50, 100, 200, 300, 400, 500, 600};

    MyClass[] obj2 ={
            new MyClass("Book1", 0),
            new MyClass("Book2", 1),
            new MyClass("Book3", 2),
            new MyClass("Book4", 3),
            new MyClass("Book5", 4),
            new MyClass("Book6", 5),
            new MyClass("Book7", 6)
    };

    Spinner spinner0, spinner1, spinner2;
    TextView textView0, textView1, textView2;
    Button b1;

    EditText ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView0 = (TextView)findViewById(R.id.text0);
        spinner0 = (Spinner)findViewById(R.id.spinner0);
        ed=(EditText)findViewById(R.id.editText);
        ArrayAdapter<String> adapter0 =
                new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_spinner_item, text0);
        adapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner0.setAdapter(adapter0);
        spinner0.setOnItemSelectedListener(onItemSelectedListener0);

        textView1 = (TextView)findViewById(R.id.text1);
        spinner1 = (Spinner)findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter1 =
                new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_spinner_item, text1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(onItemSelectedListener1);

        textView2 = (TextView)findViewById(R.id.text2);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        MySpinnerAdapter adapter2 =
                new MySpinnerAdapter(MainActivity.this,
                        android.R.layout.simple_spinner_item, obj2);
        //adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(onItemSelectedListener2);

    }

    AdapterView.OnItemSelectedListener onItemSelectedListener0 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    String s0 = (String)parent.getItemAtPosition(position);
                    textView0.setText(s0);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            };

    AdapterView.OnItemSelectedListener onItemSelectedListener1 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    String s1 = String.valueOf(val1[position]);
                    textView1.setText(s1);
                }


                @Override
                public void onNothingSelected(AdapterView<?> parent) {}

            };

    AdapterView.OnItemSelectedListener onItemSelectedListener2 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {
                    MyClass obj = (MyClass)(parent.getItemAtPosition(position));
                    textView2.setText(String.valueOf(obj.getValue()));
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}

            };

    //define our custom class
    public class MyClass{

        private String text;
        private int value;


        public MyClass(String text, int value){
            this.text = text;
            this.value = value;
        }

        public void setText(String text){
            this.text = text;
        }

        public String getText(){
            return this.text;
        }

        public void setValue(int value){
            this.value = value;
        }

        public int getValue(){
            return this.value;
        }
    }

    //custom adapter
    public class MySpinnerAdapter extends ArrayAdapter<MyClass> {

        private Context context;
        private MyClass[] myObjs;

        public MySpinnerAdapter(Context context, int textViewResourceId,
                                MyClass[] myObjs) {
            super(context, textViewResourceId, myObjs);
            this.context = context;
            this.myObjs = myObjs;
        }

        public int getCount(){
            return myObjs.length;
        }

        public MyClass getItem(int position){
            return myObjs[position];
        }

        public long getItemId(int position){
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView label = new TextView(context);
            label.setText(myObjs[position].getText());
            return label;
        }

        @Override
        public View getDropDownView(int position, View convertView,
                                    ViewGroup parent) {
            TextView label = new TextView(context);
            label.setText(myObjs[position].getText());
            return label;
        }
    }

}


