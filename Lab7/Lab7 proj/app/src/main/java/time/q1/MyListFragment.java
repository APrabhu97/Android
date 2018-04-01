package time.q1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by mahe on 3/5/2018.
 */

public class MyListFragment extends Fragment {
String[] menuI ={
        "Anish", "Sau", "Gau"
};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.list_fragment, container, false);

        ListView ls = (ListView) getView().findViewById(R.id.listy);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
            getActivity(),android.R.layout.simple_list_item_1, menuI
        );
        ls.setAdapter(adapter);
        return v;
    }


}
