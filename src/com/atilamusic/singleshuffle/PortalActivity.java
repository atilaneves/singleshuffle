package com.atilamusic.singleshuffle;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class PortalActivity extends Activity {

    private static final String ROOT = "/sdcard/";
    private static final String TAG = "singleshuffle.portal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal);

        final File albums = findMainDir("Albums");
        final File singles = findMainDir("Singles");
    }

    private File findMainDir(final String dirName) {
        final File rootDir = new File(ROOT);
        if(!rootDir.isDirectory()) {
            final String errMsg = "rootDir: " + rootDir.toString() + " is not a directory";
            Log.e(TAG, errMsg);
            throw new RuntimeException(errMsg);
        }

        return findDir(rootDir, dirName);
    }

    private File findDir(final File rootDir, final String dirName) {
        for(final String entryName: rootDir.list()) {
            final File entryFile = new File(rootDir.getAbsolutePath() + File.separator + entryName);
            if(entryFile.isDirectory() && entryName.equals(dirName)) {
                return entryFile;
            } else if(entryFile.isDirectory()) {
                final File recursiveFile = findDir(entryFile, dirName);
                if(recursiveFile != null) {
                    return recursiveFile;
                }
            }
        }

        return null;
    }

    public void viewAlbums(View view) {
        Intent intent = new Intent(this, AlbumsActivity.class);
        startActivity(intent);
    }

    public void playSingles(View view) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.portal, menu);
        return true;
    }
    
}
