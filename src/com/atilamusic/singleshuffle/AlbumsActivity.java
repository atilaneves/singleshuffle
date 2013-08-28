package com.atilamusic.singleshuffle;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class AlbumsActivity extends ListActivity /*implements LoaderManager.LoaderCallbacks<Cursor>*/ {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                new String[]{"Foo", "Bar", "Baz's greatest hits"}));
    }
}
