package com.hampoo.home.setting.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import com.hampoo.common.utils.app.AppHolder;
import com.hampoo.home.setting.Const;
import com.hampoo.home.setting.R;


public class OuterGlowFrameLayout extends FrameLayout {
    private Paint mMaskPaint;
    private float mRadius;
    private Paint mBackgroundPaint;
    private Paint mSelBackgroundPaint;

    public OuterGlowFrameLayout(@NonNull Context context) {
        super(context);
        init();
    }

    public OuterGlowFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public OuterGlowFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public OuterGlowFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mMaskPaint = new Paint();
        mMaskPaint.setColor(getResources().getColor(R.color.outer_glow));
        mRadius = getResources().getDimension(R.dimen.outer_glow_width);
        BlurMaskFilter maskFilter = new BlurMaskFilter(mRadius, BlurMaskFilter.Blur.OUTER);
        mMaskPaint.setMaskFilter(maskFilter);
        mMaskPaint.setAntiAlias(true);

        mBackgroundPaint = new Paint();
        mBackgroundPaint.setColor(getResources().getColor(R.color.transparent));
        mBackgroundPaint.setAntiAlias(true);

        mSelBackgroundPaint = new Paint();
        mSelBackgroundPaint.setColor(getResources().getColor(R.color.outer_glow_bg));
        mSelBackgroundPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (isFocused()) {
            canvas.drawRect(mRadius, mRadius, getWidth() - mRadius, getHeight() - mRadius, mSelBackgroundPaint);
            canvas.drawRect(mRadius, mRadius, getWidth() - mRadius, getHeight() - mRadius, mMaskPaint);
        }
        super.onDraw(canvas);
    }


    //The trigger of key click
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                Intent mIntent = new Intent(Const.ACTION_ON_KEY_DOWN);
                mIntent.putExtra(Const.KEY_CODE, -1);
                AppHolder.getContext().sendBroadcast(mIntent);
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                Intent intent = new Intent(Const.ACTION_ON_KEY_DOWN);
                intent.putExtra(Const.KEY_CODE, 1);
                AppHolder.getContext().sendBroadcast(intent);
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

}
