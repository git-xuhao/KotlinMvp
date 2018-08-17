package com.hazz.kotlinmvp.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.hazz.kotlinmvp.R


/**
 * 可折叠，展开的TextView
 * Created by xuhao on 2017/11/27
 */
class ExpandableTextView : LinearLayout, View.OnClickListener {

    private var mTextView: TextView? = null
    private var mButton: ImageView? = null

    private var mRelayout: Boolean = false

    private var mCollapsed = true  // 用来标记处于折叠还是展开的状态，Show short version as default.默认显示为折叠状态

    private var mExpandDrawable: Drawable? = null   // 折叠时候的显示图标▼

    private var mCollapseDrawable: Drawable? = null // 展开时候的显示图标▲

    private var mMaxCollapsedLines: Int = 0     // 设置最多的折叠行数

    private var mTextHeightWithMaxLines: Int = 0    // TextView的最大高度

    private var mMarginBetweenTxtAndBottom: Int = 0
    private var mCollapsedHeight: Int = 0
    private var mAnimating: Boolean = false
    private var mAnimAlphaStart: Float = 0.toFloat()
    private var mAnimationDuration: Int = 0

    /* Listener for callback */
    private val mListener: OnExpandStateChangeListener? = null


    var text: CharSequence?
        get() = if (mTextView == null) "" else mTextView!!.text
        set(text) {
            mRelayout = true
            mTextView!!.text = text
            visibility = if (TextUtils.isEmpty(text)) View.GONE else View.VISIBLE
        }


    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView(attrs)

    }

    private fun initView(attrs: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ExpandableTextView)
        mMaxCollapsedLines = typedArray.getInt(R.styleable.ExpandableTextView_maxCollapsedLines, MAX_COLLAPSED_LINES)
        mAnimationDuration = typedArray.getInt(R.styleable.ExpandableTextView_animDuration, DEFAULT_ANIM_DURATION)
        mAnimAlphaStart = typedArray.getFloat(R.styleable.ExpandableTextView_animAlphaStart, DEFAULT_ANIM_ALPHA_START)
        mExpandDrawable = typedArray.getDrawable(R.styleable.ExpandableTextView_expandDrawable)
        mCollapseDrawable = typedArray.getDrawable(R.styleable.ExpandableTextView_collapseDrawable)

        if (mExpandDrawable == null) {
            mExpandDrawable = getDrawable(context, R.mipmap.ic_action_down_white)
        }
        if (mCollapseDrawable == null) {
            mCollapseDrawable = getDrawable(context, R.mipmap.ic_action_up_white)
        }

        typedArray.recycle()

        // enforces vertical orientation
        orientation = LinearLayout.VERTICAL

        // default visibility is gone
        visibility = View.GONE
    }


    /**
     * 该组合控件只支持垂直布局
     *
     * @param orientation
     */
    override fun setOrientation(orientation: Int) {
        if (LinearLayout.HORIZONTAL == orientation) {
            throw IllegalArgumentException("ExpandableTextView only supports Vertical Orientation.")
        }
        super.setOrientation(orientation)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // If no change, measure and return
        if (!mRelayout || visibility == View.GONE) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
            return
        }
        mRelayout = false

        // Setup with optimistic case
        // i.e. Everything fits. No button needed
        mButton!!.visibility = View.GONE
        mTextView!!.maxLines = Integer.MAX_VALUE

        // Measure
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        // If the text fits in collapsed mode, we are done.
        if (mTextView!!.lineCount <= mMaxCollapsedLines) {
            return
        }

        // Saves the text height w/ max lines
        mTextHeightWithMaxLines = getRealTextViewHeight(mTextView!!)

        // Doesn't fit in collapsed mode. Collapse text view as needed. Show
        // button.
        if (mCollapsed) {
            mTextView!!.maxLines = mMaxCollapsedLines
        }
        mButton!!.visibility = View.VISIBLE

        // Re-measure with new setup
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        if (mCollapsed) {
            // Gets the margin between the TextView's bottom and the ViewGroup's bottom
            mTextView!!.post { mMarginBetweenTxtAndBottom = height - mTextView!!.height }
            // Saves the collapsed height of this ViewGroup
            mCollapsedHeight = measuredHeight
        }
    }

    override fun onFinishInflate() {
        findViews()
        super.onFinishInflate()
    }

    private fun findViews() {
        mTextView = findViewById<View>(R.id.expandable_text) as TextView
        mButton = findViewById<View>(R.id.expand_collapse) as ImageView

        mTextView!!.setOnClickListener(this)
        mButton!!.setOnClickListener(this)
        mButton!!.setImageDrawable(if (mCollapsed) mExpandDrawable else mCollapseDrawable)
    }

    /**
     * 点击展开/折叠
     */
    override fun onClick(view: View) {
        if (mButton!!.visibility != View.VISIBLE) {
            return
        }

        mCollapsed = !mCollapsed
        mButton!!.setImageDrawable(if (mCollapsed) mExpandDrawable else mCollapseDrawable)

        // mark that the animation is in progress
        mAnimating = true

        val animation: Animation = if (mCollapsed) {
            ExpandCollapseAnimation(this, height, mCollapsedHeight)
        } else {
            ExpandCollapseAnimation(this, height, height + mTextHeightWithMaxLines - mTextView!!.height)
        }

        animation.fillAfter = true
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                applyAlphaAnimation(mTextView, mAnimAlphaStart)
            }

            override fun onAnimationEnd(animation: Animation) {
                // clear animation here to avoid repeated applyTransformation() calls
                clearAnimation()
                // clear the animation flag
                mAnimating = false

                // notify the listener
                mListener?.onExpandStateChanged(mTextView, !mCollapsed)
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })

        clearAnimation()
        startAnimation(animation)
    }


    internal inner class ExpandCollapseAnimation(private val mTargetView: View, private val mStartHeight: Int, private val mEndHeight: Int) : Animation() {

        init {
            duration = mAnimationDuration.toLong()
        }

        override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
            val newHeight = ((mEndHeight - mStartHeight) * interpolatedTime + mStartHeight).toInt()
            mTextView!!.maxHeight = newHeight - mMarginBetweenTxtAndBottom
            if (java.lang.Float.compare(mAnimAlphaStart, 1.0f) != 0) {
                applyAlphaAnimation(mTextView, mAnimAlphaStart + interpolatedTime * (1.0f - mAnimAlphaStart))
            }
            mTargetView.layoutParams.height = newHeight
            mTargetView.requestLayout()
        }

        override fun willChangeBounds(): Boolean {
            return true
        }
    }


    interface OnExpandStateChangeListener {
        /**
         * Called when the expand/collapse animation has been finished
         *
         * @param textView - TextView being expanded/collapsed
         * @param isExpanded - true if the TextView has been expanded
         */
        fun onExpandStateChanged(textView: TextView?, isExpanded: Boolean)
    }

    companion object {

        /* The default number of lines */
        private val MAX_COLLAPSED_LINES = 8

        /* The default animation duration */
        private val DEFAULT_ANIM_DURATION = 300

        /* The default alpha value when the animation starts */
        private val DEFAULT_ANIM_ALPHA_START = 0.7f

        /**
         * 获取TextView真正的高度
         *
         * @param textView
         * @return
         */
        private fun getRealTextViewHeight(textView: TextView): Int {
            val textHeight = textView.layout.getLineTop(textView.lineCount)
            val padding = textView.compoundPaddingTop + textView.compoundPaddingBottom
            return textHeight + padding
        }

        private fun getDrawable(context: Context, @DrawableRes resId: Int): Drawable? {
            val resources = context.resources
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                resources.getDrawable(resId, context.theme)
            } else {
                ContextCompat.getDrawable(context,resId)
            }
        }
    }

    private fun applyAlphaAnimation(view: View?, alpha: Float) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            view!!.alpha = alpha
        } else {
            val alphaAnimation = AlphaAnimation(alpha, alpha)
            // make it instant
            alphaAnimation.duration = 0
            alphaAnimation.fillAfter = true
            view!!.startAnimation(alphaAnimation)
        }
    }



}



