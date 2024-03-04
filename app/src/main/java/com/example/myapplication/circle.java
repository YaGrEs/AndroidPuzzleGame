package com.example.myapplication;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class circle extends Drawable {

    private Paint circlePaint;
    private int fillColor;
    private int strokeColor;
    private float radius;

    public circle(int fillColor, float radius) {
        this.fillColor = fillColor;
        this.radius = radius;
        circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        int x = getBounds().centerX();
        int y = getBounds().centerY();
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setColor(fillColor);
        canvas.drawCircle(x, y, radius, circlePaint);
    }
    @Override
    public void setAlpha(int alpha) {
        circlePaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        circlePaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
