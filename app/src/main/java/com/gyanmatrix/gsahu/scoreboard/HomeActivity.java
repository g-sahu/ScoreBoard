package com.gyanmatrix.gsahu.scoreboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private final static String LOG_TAG = "HomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(LOG_TAG, "HomeActivity created");

        Toast toast = Toast.makeText(this, "LIBRARY UPDATED", Toast.LENGTH_LONG);
        toast.show();

        ScoreBoardDAO dao = new ScoreBoardDAO(this);

        //Fetching all kings from database
        ArrayList<King> kingsList = dao.getKings();

        ListView listView;listView = (ListView) findViewById(R.id.listView);
        ListAdapter playlistAdapter = new KingsListAdapter(this, kingsList);
        listView.setAdapter(playlistAdapter);
    }
}
