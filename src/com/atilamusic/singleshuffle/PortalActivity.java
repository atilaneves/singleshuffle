package com.atilamusic.singleshuffle;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

import java.io.File;

public class PortalActivity extends Activity {

    private static final String ROOT = "/sdcard/";
    private static final String TAG = "singleshuffle.portal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal);

        final TextView albumsView = (TextView)findViewById(R.id.albums_text_view);
        albumsView.setText(findMainDir("Albums").toString());

        final TextView singlesView = (TextView)findViewById(R.id.singles_text_view);
        singlesView.setText(findMainDir("Singles").toString());
    }

    private File findMainDir(final String dirName) {
        final File rootDir = new File(ROOT);
        Log.d(TAG, "rootDir: " + rootDir.toString());
        if(!rootDir.isDirectory()) {
            final String errMsg = "rootDir: " + rootDir.toString() + " is not a directory";
            Log.e(TAG, errMsg);
            throw new RuntimeException(errMsg);
        }

        return findDir(rootDir, dirName);
    }

    private File findDir(final File rootDir, final String dirName) {
        for(final String entryName: rootDir.list()) {
            Log.d(TAG, "Looking at entry " + entryName);
            final File entryFile = new File(rootDir.getAbsolutePath() + File.separator + entryName);
            Log.d(TAG, "Is entry dir? " + entryFile.isDirectory());
            if(entryFile.isDirectory() && entryName.equals(dirName)) {
                Log.d(TAG, "Found it, returning");
                return entryFile;
            } else if(entryFile.isDirectory()) {
                Log.d(TAG, "Recursing into directory " + entryName);
                final File recursiveFile = findDir(entryFile, dirName);
                if(recursiveFile != null) {
                    return recursiveFile;
                }
            }
        }

        Log.d(TAG, "Did not find it, returning null");
        return null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.portal, menu);
        return true;
    }
    
}
