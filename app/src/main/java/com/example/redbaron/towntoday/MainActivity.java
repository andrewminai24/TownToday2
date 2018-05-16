package com.example.redbaron.towntoday;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Context context;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_map:
                    return true;
                case R.id.navigation_letsgo:
                    Intent netflix = new Intent(context, NetflixActivity.class);
                    startActivity(netflix);
                    return true;
                case R.id.navigation_heart:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        DisplayMetrics displayMetrics = getApplicationContext().getResources().getDisplayMetrics();
        Constants.dpHeight = displayMetrics.heightPixels / displayMetrics.density;
        Constants.dpWidth = displayMetrics.widthPixels / displayMetrics.density;

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        Constants.selected.clear();
        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        Log.i("HEIGHT: ", String.valueOf(Constants.dpHeight));
        int counter = 0;

        LinearLayout each = null;
        while(counter < Constants.categories.size()){
            if(counter % 3 == 0){
                if(each != null){
                    mainLayout.addView(each);
                }
                each = new LinearLayout(this);
                each.setOrientation(LinearLayout.HORIZONTAL);
            }
            CategoryView cv = new CategoryView(this, Constants.categories.get(counter));
            cv.setPadding((int) Constants.dpPadding, (int) Constants.dpPadding,
                    (int) Constants.dpPadding, (int) Constants.dpPadding);
            each.addView(cv);
            counter++;
        }
        if(Constants.categories.size() % 3 != 0) {
            mainLayout.addView(each);
        }
    }

}
