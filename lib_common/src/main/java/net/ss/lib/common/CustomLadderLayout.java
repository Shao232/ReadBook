package net.ss.lib.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * @author ss
 * created 2019/11/9 16:41
 */
public class CustomLadderLayout extends LinearLayout {

    private static final int WIDTH_DEFAULT = 1920;
    private static final int HEIGHT_DEFAULT = 1080;
    private static final int PAINT_TEXT_SIZE = 5;
    private static final int OFFSET = 30;

    private float mTopWidth;
    private float mBottomWidth;
    private float mHeight;

    private Paint mPaint;
    private Path mPath;

    public CustomLadderLayout(Context context) {
        this(context, null);
    }

    public CustomLadderLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomLadderLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray =
                context.obtainStyledAttributes(attrs, R.styleable.CustomLadderLayout);
        mTopWidth = typedArray.getDimension(R.styleable.CustomLadderLayout_topWidth, WIDTH_DEFAULT);
        mBottomWidth = typedArray.getDimension(R.styleable.CustomLadderLayout_bottomWidth,
                WIDTH_DEFAULT);
        mHeight = typedArray.getDimension(R.styleable.CustomLadderLayout_android_layout_height,
                HEIGHT_DEFAULT);
        typedArray.recycle();

        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeWidth(PAINT_TEXT_SIZE);

        int width = (int) mTopWidth;
        int height = (int) mHeight;
        mPath = new Path();
        mPath.moveTo(OFFSET,0);
        mPath.lineTo(width,0);
        mPath.lineTo(width,height);
        mPath.lineTo(0,height);
        mPath.close();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measureWidth = (int) mTopWidth;
        int measureHeight = (int) mHeight;

        setMeasuredDimension(measureWidth, measureHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.clipPath(mPath);

        canvas.drawColor(Color.RED);
        canvas.drawPath(mPath,mPaint);
    }
}
