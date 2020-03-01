package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemClickListener {
    ListView listView;
    List<DataItem> dataItem;

    //Variable for each intent key
    protected static final String EXTRA_RES_ID = "POS";
    protected static final String URL = "URL";
    protected static final String TEXT = "TEXT";

    //Variable for each list
    private ArrayList<String> IUriList = new ArrayList<String>();
    private ArrayList<String> WUriList = new ArrayList<String>();
    private ArrayList<String> TUriList = new ArrayList<String>();
    private ArrayList<String> TextList = new ArrayList<String>();


    //Array for store the movies' name
    public static final String[] titles = new String[]{"1917", "Avengers Endgame", "Joker",
            "The Invisible Guest", "Your name",
            "Room", "Spotlight",};

    //Array for the movies' year
    public static final String[] years = new String[]{"2019", "2019", "2019", "2016", "2016",
            "2015", "2015",};

    //Array for the image
    public static final Integer[] images = {R.drawable.movie1917, R.drawable.avengersendgame, R.drawable.jokers,
            R.drawable.the_invisible_guest, R.drawable.your_name,
            R.drawable.room, R.drawable.spotlight,};

    //Array for the bigger image
    public static final ArrayList<Integer> bigImages = new ArrayList<Integer>(
            Arrays.asList(R.drawable.movie19172, R.drawable.avengersendgame2,
                          R.drawable.jokers2, R.drawable.theinvisibleguest2,
                          R.drawable.yourname2, R.drawable.room2, R.drawable.spotlight2));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set array to dataItem
        dataItem = new ArrayList<DataItem>();

        //Initialize each list
        initializeStateIMDbUris();
        initializeStateTrailerUris();
        initializeStateWikiUris();
        initializeTextList();

        //Loop to create new DataItem object
        for (int i = 0; i < titles.length; i++) {
            DataItem item = new DataItem(images[i], titles[i], years[i]);
            dataItem.add(item);
        }

        //Assign list id
        listView = (ListView) findViewById(R.id.list);
        //For the long click
        registerForContextMenu(listView);

        //Create new adapter object
        CustomListViewAdapter adapter = new CustomListViewAdapter(this, R.layout.list_item, dataItem);
        listView.setAdapter(adapter);

        //Set an setOnItemClickListener on the ListView
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Create an Intent to start the ImageViewActivity
        Intent intent = new Intent(MainActivity.this, ImageViewActivity.class);
        // Add the ID of the thumbnail to display as an Intent Extra
        intent.putExtra(EXTRA_RES_ID, bigImages.get(position));
        intent.putExtra(URL, IUriList.get(position));
        startActivity(intent);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        //Get position for each list
        String temp = IUriList.get(info.position);
        String temp1 = TUriList.get(info.position);
        String temp2 = WUriList.get(info.position);
        String temp3 = TextList.get(info.position);

        Log.i("temp3", temp3);
        Uri uri;
        //Set up new intent for uri
        Intent uriIntent = new Intent(Intent.ACTION_VIEW);

        switch(item.getItemId()){
            case R.id.info:
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                intent.putExtra(TEXT, temp3);
                startActivity(intent);
                return true;
            case R.id.trailer:
                uri = Uri.parse(temp1);
                uriIntent.setData(uri);
                uriIntent.addCategory(uriIntent.CATEGORY_BROWSABLE);
                startActivity(uriIntent);
                return true;
            case R.id.wikipedia:
                uri = Uri.parse(temp2);
                uriIntent.setData(uri);
                uriIntent.addCategory(uriIntent.CATEGORY_BROWSABLE);
                startActivity(uriIntent);
                return true;
            case R.id.imdb:
                uri = Uri.parse(temp);
                uriIntent.setData(uri);
                uriIntent.addCategory(uriIntent.CATEGORY_BROWSABLE);
                startActivity(uriIntent);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void initializeTextList() {
        TextList.add("M1917");
        TextList.add("AvengerEndGame");
        TextList.add("Joker");
        TextList.add("TIG");
        TextList.add("YourName");
        TextList.add("Room");
        TextList.add("SpotLight");
    }

    private void initializeStateIMDbUris() {
        IUriList.add("https://www.imdb.com/title/tt8579674/?ref_=fn_al_tt_1");
        IUriList.add("https://www.imdb.com/title/tt4154796/?ref_=nv_sr_srsg_0");
        IUriList.add("https://www.imdb.com/title/tt7286456/?ref_=nv_sr_srsg_0");
        IUriList.add("https://www.imdb.com/title/tt4857264/?ref_=fn_al_tt_1");
        IUriList.add("https://www.imdb.com/title/tt5311514/?ref_=nv_sr_srsg_3");
        IUriList.add("https://www.imdb.com/title/tt3170832/?ref_=nv_sr_srsg_0");
        IUriList.add("https://www.imdb.com/title/tt1895587/?ref_=nv_sr_srsg_0");
    }

    private void initializeStateTrailerUris() {
        TUriList.add("https://www.youtube.com/watch?v=YqNYrYUiMfg");
        TUriList.add("https://www.youtube.com/watch?v=TcMBFSGVi1c");
        TUriList.add("https://www.youtube.com/watch?v=zAGVQLHvwOY");
        TUriList.add("https://www.youtube.com/watch?v=epCg2RbyF80");
        TUriList.add("https://www.youtube.com/watch?v=xU47nhruN-Q");
        TUriList.add("https://www.youtube.com/watch?v=E_Ci-pAL4eE");
        TUriList.add("https://www.youtube.com/watch?v=EwdCIpbTN5g");
    }

    private void initializeStateWikiUris() {
        WUriList.add("https://en.wikipedia.org/wiki/Sam_Mendes");
        WUriList.add("https://en.wikipedia.org/wiki/Russo_brothers");
        WUriList.add("https://en.wikipedia.org/wiki/Todd_Phillips");
        WUriList.add("https://en.wikipedia.org/wiki/Oriol_Paulo");
        WUriList.add("https://en.wikipedia.org/wiki/Makoto_Shinkai");
        WUriList.add("https://en.wikipedia.org/wiki/Lenny_Abrahamson");
        WUriList.add("https://en.wikipedia.org/wiki/Tom_McCarthy_(director)");
    }
}

