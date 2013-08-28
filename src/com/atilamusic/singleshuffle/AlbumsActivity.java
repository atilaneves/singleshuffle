package com.atilamusic.singleshuffle;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AlbumsActivity extends Activity /*implements LoaderManager.LoaderCallbacks<Cursor>*/ {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);
        ListView albums = (ListView)findViewById(R.id.albums_list);
        albums.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                new String[]{"Foo", "Bar", "Baz's greatest hits"}));
    }
}
