package com.hazz.kotlinmvp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

import com.hazz.kotlinmvp.R;

import java.lang.ref.WeakReference;

/**
 * Created by xuhao on 2017/12/4.
 * desc:LoadingView 加载动画
 */

public class LoadingView extends View {

    private int mOuterCircleRadius;
    private int mOuterCircleColor;
    private int mInnerTriangleRadius;
    private int mInnerTriangleColor;
    private int mBackgroundColor;
    private int mStrokeWidth;
    private boolean mIsNeedBackground;

    private Paint mPaint;
    private Paint mTrianglePaint;
    private Paint mBackGroundPaint;
    private boolean isReverse = false;
    private int mProgress = 0;
    private int mStartAngle = -90;
    private int mRotateAngle = 0;
    private int mDel = 30;
    private RectF mRectF;
    private RectF mRoundRectF;
    private Path mPath;
    private PointF mRotateCenter;
    private MyHandler mHandler;


    public LoadingView(Context context) {
        this(context, null);

    }

    public LoadingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.LoadingView);
        mOuterCircleRadius = typedArray.getDimensionPixelSize(R.styleable.LoadingView_outerCircleRadius, 50);
        mOuterCircleColor = typedArray.getColor(R.styleable.LoadingView_outerCircleColor, 0xFF228B22);
        mInnerTriangleRadius = typedArray.getDimensionPixelSize(R.styleable.LoadingView_innerTriangleRadius, 25);
        mInnerTriangleColor = typedArray.getColor(R.styleable.LoadingView_innerTriangleColor, 0xFF228B22);
        mIsNeedBackground = typedArray.getBoolean(R.styleable.LoadingView_isNeedBackground, true);
        mBackgroundColor = typedArray.getColor(R.styleable.LoadingView_backgroundColor, 0xBB222222);
        mStrokeWidth = typedArray.getDimensionPixelSize(R.styleable.LoadingView_strokeWidth, 5);

        typedArray.recycle();

        init();
    }

    private void init() {
        //设置画进度圈的画笔
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(mOuterCircleColor);
        mPaint.setStrokeWidth(mStrokeWidth);
        mPaint.setStyle(Paint.Style.STROKE);

        //设置画三角形的画笔
        mTrianglePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTrianglePaint.setColor(mInnerTriangleColor);

        //设置画背景的画笔
        mBackGroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBackGroundPaint.setColor(mBackgroundColor);

        mPath = new Path();
        mRotateCenter = new PointF();
        mRoundRectF = new RectF();
        mHandler = new MyHandler(this);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //判断外圆的半径
        mOuterCircleRadius = (int) (Math.min(mOuterCircleRadius,
                (Math.min(w - getPaddingRight() - getPaddingLeft(), h - getPaddingTop() - getPaddingBottom()) - 4 * mPaint.getStrokeWidth()) / 2));
        if (mOuterCircleRadius < 0) {
            mStrokeWidth = Math.min(w - getPaddingRight() - getPaddingLeft(), h - getPaddingTop() - getPaddingBottom()) / 2;
            mOuterCircleRadius = Math.min(w - getPaddingRight() - getPaddingLeft(), h - getPaddingTop() - getPaddingBottom()) / 4;
        }
        float left = (w - 2 * mOuterCircleRadius) / 2;
        float top = (h - 2 * mOuterCircleRadius) / 2;
        float diameter = 2 * mOuterCircleRadius;
        mRectF = new RectF(left, top, left + diameter, top + diameter);

        //判断内圆的半径大小
        mInnerTriangleRadius = (mInnerTriangleRadius < mOuterCircleRadius) ? mInnerTriangleRadius : 3 * mOuterCircleRadius / 5;
        if (mInnerTriangleRadius < 0) {
            mInnerTriangleRadius = 0;
        }
        //计算内圆的圆心，圆心应该和外圆圆心相同
        float centerX = left + mOuterCircleRadius;
        float centerY = top + mOuterCircleRadius;
        //计算内圆的内接三角形的三个定点组成的path
        mPath.moveTo(centerX - mInnerTriangleRadius / 2, (float) (centerY - Math.sqrt(3) * mInnerTriangleRadius / 2));
        mPath.lineTo(centerX + mInnerTriangleRadius, centerY);
        mPath.lineTo(centerX - mInnerTriangleRadius / 2, (float) (centerY + Math.sqrt(3) * mInnerTriangleRadius / 2));
        mPath.close();

        mRotateCenter.set(getMeasuredWidth() / 2, getMeasuredHeight() / 2);
        mRoundRectF.left = 0;
        mRoundRectF.top = 0;
        mRoundRectF.right = w;
        mRoundRectF.bottom = h;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureSize(widthMeasureSpec, 140), measureSize(heightMeasureSpec, 140));
    }

    private int measureSize(int measureSpec, int defaultSize) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        int resultSize = defaultSize;
        switch (specMode) {
            case MeasureSpec.EXACTLY:
                resultSize = specSize;
                break;
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                resultSize = Math.min(specSize, resultSize);
                break;
        }
        return resultSize;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        if (mIsNeedBackground) {
            canvas.drawRoundRect(mRoundRectF, 8, 8, mBackGroundPaint);
        }

        if (isReverse) {
            mProgress -= mDel;
            mStartAngle += mDel;
            if (mStartAngle >= 270) {
                mStartAngle = -90;
                isReverse = false;
            }
            mRotateAngle += mDel;
            if (mRotateAngle >= 360) {
                mRotateAngle = 0;
            }
            canvas.save();
            canvas.rotate(mRotateAngle, mRotateCenter.x, mRotateCenter.y);
            canvas.drawPath(mPath, mTrianglePaint);
            canvas.restore();
        } else {
            mProgress += mDel;
            if (mProgress >= 360) {
                isReverse = true;
            }
            canvas.drawPath(mPath, mTrianglePaint);
        }

        canvas.drawArc(mRectF, mStartAngle, mProgress, false, mPaint);
        mHandler.sendEmptyMessageDelayed(MyHandler.REFRESH_VIEW, 80);
    }


    private static class MyHandler extends Handler {
        static final int REFRESH_VIEW = 0;
        private final WeakReference<LoadingView> mLoadingViewWeakReference;

        private MyHandler(LoadingView loadingView) {
            mLoadingViewWeakReference = new WeakReference<>(loadingView);
        }

        @Override
        public void handleMessage(Message msg) {
            if (mLoadingViewWeakReference.get() != null) {
                switch (msg.what) {
                    case REFRESH_VIEW:
                        mLoadingViewWeakReference.get().postInvalidate();
                        break;
                }
            }
        }
    }
}
