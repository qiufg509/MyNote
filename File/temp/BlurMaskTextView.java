package com.hampoo.home.setting.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

import com.hampoo.home.setting.R;

public class BlurMaskTextView extends TextView {

    private final int mUnFocusColor;
    private final boolean mSelectType;
    private final Bitmap mGotoBitmap;
    private final Bitmap mGobackBitmap;
    private final boolean mShowArrow;
    private Paint mMaskPaint;
    private float mRadius;
    private Paint mBackgroundPaint;
    private int mBackgroundColor;

    public BlurMaskTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta = null;
        int maskColor;
        try {
            ta = context.obtainStyledAttributes(attrs, R.styleable.BlurMaskTextView);
            mBackgroundColor = ta.getColor(R.styleable.BlurMaskTextView_tv_bg_color, 0xF1563E);
            maskColor = ta.getColor(R.styleable.BlurMaskTextView_tv_mask_color, 0x99F1563E);
            mUnFocusColor = ta.getColor(R.styleable.BlurMaskTextView_tv_un_focus_color, 0);
            mSelectType = ta.getBoolean(R.styleable.BlurMaskTextView_tv_select_type, false);
            mShowArrow = ta.getBoolean(R.styleable.BlurMaskTextView_tv_show_arrow, false);
            mRadius = ta.getDimension(R.styleable.BlurMaskTextView_tv_blur_width, getResources().getDimension(R.dimen.blur_mask_radius));
        } finally {
            if (ta != null) {
                ta.recycle();
            }
        }

        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mMaskPaint = new Paint();
        mMaskPaint.setColor(maskColor);
        BlurMaskFilter maskFilter = new BlurMaskFilter(mRadius, BlurMaskFilter.Blur.OUTER);
        mMaskPaint.setMaskFilter(maskFilter);

        mBackgroundPaint = new Paint();
        mBackgroundPaint.setColor(mBackgroundColor);
        mBackgroundPaint.setAntiAlias(true);

        mGotoBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.goto_dialog);
        mGobackBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.goback_dialog);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mSelectType) {
            if (isFocused()) {
                mBackgroundPaint.setColor(mBackgroundColor);
                canvas.drawRoundRect(mRadius, mRadius, getWidth() - mRadius, getHeight() - mRadius, getHeight() / 2, getHeight() / 2, mBackgroundPaint);
                canvas.drawRoundRect(mRadius, mRadius, getWidth() - mRadius, getHeight() - mRadius, getHeight() / 2, getHeight() / 2, mMaskPaint);
                if (mShowArrow) {
                    canvas.drawBitmap(mGobackBitmap, getHeight() / 2, (getHeight() - mGobackBitmap.getHeight()) / 2, mBackgroundPaint);
                    canvas.drawBitmap(mGotoBitmap, getWidth() - getHeight() / 2 - mGotoBitmap.getWidth(), (getHeight() - mGobackBitmap.getHeight()) / 2, mBackgroundPaint);
                }
            } else {
                mBackgroundPaint.setColor(mUnFocusColor);
                canvas.drawRoundRect(mRadius, mRadius, getWidth() - mRadius, getHeight() - mRadius, getHeight() / 2, getHeight() / 2, mBackgroundPaint);
            }
        } else {
            canvas.drawRoundRect(mRadius, mRadius, getWidth() - mRadius, getHeight() - mRadius, getHeight() / 2, getHeight() / 2, mBackgroundPaint);
            canvas.drawRoundRect(mRadius, mRadius, getWidth() - mRadius, getHeight() - mRadius, getHeight() / 2, getHeight() / 2, mMaskPaint);
        }
        super.onDraw(canvas);
    }
}
