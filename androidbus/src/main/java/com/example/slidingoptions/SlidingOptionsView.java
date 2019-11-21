package com.example.slidingoptions;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.leftsidemenu.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SlidingOptionsView extends View {
    private String[] titles;
    private float textSize;
    private int strokeColor;
    private float strokeWidth;
    private Paint whitePaint, textPaint2;
    private int height, width, count, currentItemPosition;
    private float borderWidth = 3;
    private float touchPoint = 0;
    private ValueAnimator drawAnimator;
    private List<Float> textPointLocations = new ArrayList<>();


    public SlidingOptionsView(Context context) {
        super(context);
        initPaint();
    }

    public SlidingOptionsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SlidingOptionsButton);
        titles = typedArray.getString(R.styleable.SlidingOptionsButton_optionTexts).split(",");
        textSize = typedArray.getDimension(R.styleable.SlidingOptionsButton_text_size, 15);
        strokeColor = typedArray.getColor(R.styleable.SlidingOptionsButton_stroke_color, Color.BLUE);
        strokeWidth = typedArray.getDimension(R.styleable.SlidingOptionsButton_stroke_width, 3);
        count = titles.length * 2;
        currentItemPosition = 0;
        typedArray.recycle();
        initPaint();
    }

    private void initPaint() {
        whitePaint = new Paint();
        whitePaint.setAntiAlias(true);
        whitePaint.setColor(strokeColor);
        whitePaint.setStrokeWidth(3);
        whitePaint.setStyle(Paint.Style.STROKE);

        textPaint2 = new Paint();
        textPaint2.setAntiAlias(true);
        textPaint2.setColor(Color.RED);
        textPaint2.setStrokeWidth(2);
        textPaint2.setTextSize(textSize);
        textPaint2.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        height = getMeasuredHeight();
        width = getMeasuredWidth();
        touchPoint = width / count * ((currentItemPosition + 1) * 2 - 1);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRoundRect(new RectF(borderWidth / 2, borderWidth, width - borderWidth, height - borderWidth), width / 2, width / 2, whitePaint);

        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();
        int layerId = canvas.saveLayer(0, 0, canvasWidth, canvasHeight, null, Canvas.ALL_SAVE_FLAG);

        canvas.drawRoundRect(new RectF(touchPoint - width / count, borderWidth / 2, touchPoint + width / count, height - borderWidth / 2), width / 2, width / 2, textPaint2);
        textPaint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));

        textPointLocations.clear();
        for (int i = 0; i < titles.length; i++) {
            float txtWidth = textPaint2.measureText(titles[i]);
            float location = width / count * (i * 2 + 1) - txtWidth / 2;
            canvas.drawText(titles[i], location, (height - 19) / 2 + 25, textPaint2);
            textPointLocations.add(location + txtWidth / 2);
        }
        textPaint2.setXfermode(null);
        canvas.restoreToCount(layerId);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (drawAnimator != null && drawAnimator.isRunning()) {
                    drawAnimator.cancel();
                }
                touchPoint = getTouchPoint(event);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                if (drawAnimator != null && drawAnimator.isRunning()) {
                    drawAnimator.cancel();
                }
                float startPoint = event.getX();
                startAnimator(startPoint, getNearestPoint(startPoint));
                break;
            case MotionEvent.ACTION_MOVE:
                touchPoint = getTouchPoint(event);
                invalidate();
                break;

            default:
                break;
        }
        return true;
    }

    private float getNearestPoint(final float startPoint) {
        if (textPointLocations.isEmpty())
            return startPoint;

        List<Float> abs = textPointLocations.stream().map(point -> Math.abs(point - startPoint)).collect(Collectors.toList());
        Float min = abs.stream().min(Float::compareTo).orElse(startPoint);
        return textPointLocations.get(abs.indexOf(min));
    }

    private void startAnimator(float start, float end) {
        drawAnimator = ValueAnimator.ofFloat(start, end);
        drawAnimator.setDuration(100);
        drawAnimator.addUpdateListener(valueAnimator -> {
            touchPoint = (float) valueAnimator.getAnimatedValue();
            invalidate();
        });
        drawAnimator.start();
    }

    private float getTouchPoint(MotionEvent event) {
        float x = event.getX();

        return x < textPointLocations.get(0) ? textPointLocations.get(0) : (x > textPointLocations.get(textPointLocations.size() - 1) ? textPointLocations.get(textPointLocations.size() - 1) : x);
    }
}
