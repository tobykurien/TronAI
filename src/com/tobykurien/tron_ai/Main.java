package com.tobykurien.tron_ai;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.tobykurien.tron_ai.view.Board;

public class Main extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Board b = (Board) findViewById(R.id.main_board);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    
}
