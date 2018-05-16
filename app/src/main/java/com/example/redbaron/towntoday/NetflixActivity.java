package com.example.redbaron.towntoday;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class NetflixActivity extends AppCompatActivity {

    private Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netflix);
        LinearLayout mainLinear = findViewById(R.id.netflixMainLinear);

        c = this;
        int testAdder = 0;
        for(String category : Constants.selected){
            TextView categoryTitle = new TextView(this);
            categoryTitle.setText(category);
            categoryTitle.setTextSize(25);
            categoryTitle.setTextColor(Color.YELLOW);
            mainLinear.addView(categoryTitle);

            LinearLayout linear2 = new LinearLayout(this);
            linear2.setOrientation(LinearLayout.HORIZONTAL);

            for(int a = 0; a < 5; a++){
                Bitmap event = scaleDown(BitmapFactory.decodeResource(this.getResources(), this.getResources().getIdentifier(Constants.eventThumbs.get(a + testAdder), "drawable", this.getPackageName())), Constants.dpWidth - 2 * Constants.dpPadding, false);
                ImageView iv = new ImageView(this);
                iv.setImageBitmap(event);
                iv.setPadding((int) Constants.dpEventPadding, (int) Constants.dpPadding,
                        (int) Constants.dpEventPadding, (int) Constants.dpPadding);
                iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(c, "This feature is in the works", Toast.LENGTH_SHORT).show();
                    }
                });
                linear2.addView(iv);
            }
            HorizontalScrollView sv = new HorizontalScrollView(this);
            sv.addView(linear2);
            mainLinear.addView(sv);
            testAdder+=5;
        }
    }

    public static Bitmap scaleDown(Bitmap realImage, float maxImageSize,
                                   boolean filter) {
        float ratio = Math.min(
                (float) maxImageSize / realImage.getWidth(),
                (float) maxImageSize / realImage.getHeight());
        int width = Math.round((float) ratio * realImage.getWidth());
        int height = Math.round((float) ratio * realImage.getHeight());

        Bitmap newBitmap = Bitmap.createScaledBitmap(realImage, width,
                height, filter);
        return newBitmap;
    }
}
