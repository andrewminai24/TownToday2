package com.example.redbaron.towntoday;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

public class CategoryView extends View {

    private Paint paint;
    public String identification;
    public boolean checked;
    private Canvas canvas;
    Bitmap tile;
    Bitmap highlight;
    Bitmap categoryInfo;

    public CategoryView(Context context, final String identification) {
        super(context);
        setWillNotDraw(false);
        paint = new Paint();
        checked = false;
        this.identification = identification;
        final String temp_id = this.identification;
        tile = scaleDown(BitmapFactory.decodeResource(context.getResources(), context.getResources().getIdentifier(identification, "drawable", context.getPackageName())), Constants.dpWidth - 2 * Constants.dpPadding, false);
        highlight = scaleDown(BitmapFactory.decodeResource(context.getResources(), R.drawable.tile_highlight), Constants.dpWidth - 2 * Constants.dpPadding, false);

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                checked = !checked;
                if(checked){
                    Constants.selected.add(identification);
                } else {
                    Constants.selected.remove(identification);
                }
                invalidate();
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas){
        this.canvas = canvas;
        super.onDraw(canvas);
        paint.setTextSize(15);
        paint.setColor(Color.LTGRAY);

        canvas.drawBitmap(tile, 0, 0, paint);

        if(checked){
            canvas.drawBitmap(highlight, 0, 0, paint);
        }

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        setMeasuredDimension((int) Constants.dpWidth, (int) Constants.dpWidth);
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
