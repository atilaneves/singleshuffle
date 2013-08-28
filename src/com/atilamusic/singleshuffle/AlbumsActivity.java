package com.atilamusic.singleshuffle;

import android.app.Activity;
import android.os.Bundle;

public class AlbumsActivity extends Activity /*implements LoaderManager.LoaderCallbacks<Cursor>*/ {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);
//        setListAdapter(new ArrayAdapter<String>(this, R.id.list_item,
//                new String[]{"Foo", "Bar", "Baz's greatest hits"}));
    }
}
