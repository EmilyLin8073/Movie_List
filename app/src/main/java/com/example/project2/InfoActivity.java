package com.example.project2;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class InfoActivity extends ListActivity {

    ListView listView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Intent intent = getIntent();

        //Get the string intent
        String pos = intent.getStringExtra(MainActivity.TEXT);
        Log.i("pos", pos);

        if (pos.equals("M1917")) {
            // Set the adapter on this ListActivity's built-in ListView
            setListAdapter(new ArrayAdapter<String>(this, R.layout.text_item,
                    getResources().getStringArray(R.array.M1917)));
        }

        else if(pos.equals("AvengerEndGame")){
            // Set the adapter on this ListActivity's built-in ListView
            setListAdapter(new ArrayAdapter<String>(this, R.layout.text_item,
                    getResources().getStringArray(R.array.aveg)));
        }

        else if(pos.equals("Joker")){
            // Set the adapter on this ListActivity's built-in ListView
            setListAdapter(new ArrayAdapter<String>(this, R.layout.text_item,
                    getResources().getStringArray(R.array.joker)));
        }
        else if(pos.equals("TIG")){
            // Set the adapter on this ListActivity's built-in ListView
            setListAdapter(new ArrayAdapter<String>(this, R.layout.text_item,
                    getResources().getStringArray(R.array.tig)));
        }
        else if(pos.equals("YourName")){
            // Set the adapter on this ListActivity's built-in ListView
            setListAdapter(new ArrayAdapter<String>(this, R.layout.text_item,
                    getResources().getStringArray(R.array.yourname)));
        }
        else if(pos.equals("Room")){
            // Set the adapter on this ListActivity's built-in ListView
            setListAdapter(new ArrayAdapter<String>(this, R.layout.text_item,
                    getResources().getStringArray(R.array.room)));
        }
        else{
            // Set the adapter on this ListActivity's built-in ListView
            setListAdapter(new ArrayAdapter<String>(this, R.layout.text_item,
                    getResources().getStringArray(R.array.spotlight)));
        }

        listView = getListView();
        listView.setTextFilterEnabled(true);
    }
}
