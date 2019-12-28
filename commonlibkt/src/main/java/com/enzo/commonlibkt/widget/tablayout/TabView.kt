package com.enzo.commonlibkt.widget.tablayout

import android.content.Context
import android.graphics.*
import android.os.Looper
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.enzo.commonlibkt.utils.DensityUtil

/**
 * 文 件 名: TabButton
 * 创 建 人: xiaofangyin
 * 创建日期: 2017/4/1
 * 邮   箱: xiaofangyinwork@163.com
 */
class TabView @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    private var textView: TextView? = null
    private var imageView: ImageView? = null
    private var mNormalBitmap = 0
    private var mSelectedBitmap = 0
    private var mTextColorNormal = 0
    private var mTextColorSelected = 0
    private var mMessageNumber = 0
    private val mMessagePaint: Paint
    private val mMessageRect: Rect
    private val mMessageRectF: RectF
    private val mRedPointPaint: Paint
    private val mRedPointRectF: RectF
    private var mShowRedPoint = false

    init {
        gravity = Gravity.CENTER_VERTICAL
        orientation = VERTICAL
        //数字画笔内容大小等创建
        mMessagePaint = Paint()
        mMessageRect = Rect()
        mMessageRectF = RectF()
        mRedPointPaint = Paint()
        mRedPointRectF = RectF()
    }

    fun initTab(entity: TabEntity) {
        mTextColorNormal = entity.normalColor
        mTextColorSelected = entity.selectedColor
        mNormalBitmap = entity.normalImage
        mSelectedBitmap = entity.selectedImage
        imageView = ImageView(context)
        imageView!!.setImageResource(mNormalBitmap)
        textView = TextView(context)
        textView!!.text = entity.title
        textView!!.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
        textView!!.setTextColor(mTextColorNormal)
        val ivLp = LayoutParams(
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT
        )
        ivLp.gravity = Gravity.CENTER_HORIZONTAL
        val tvLp = LayoutParams(
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT
        )
        tvLp.gravity = Gravity.CENTER_HORIZONTAL
        tvLp.topMargin = DensityUtil.dip2px(context, 2f)
        addView(imageView, ivLp)
        addView(textView, tvLp)
    }

    override fun dispatchDraw(canvas: Canvas) {
        super.dispatchDraw(canvas)
        if (mMessageNumber > 0) {
            drawMessages(canvas)
        } else if (mShowRedPoint) {
            drawRedPoint(canvas)
        }
    }

    /**
     * 画小红点
     */
    private fun drawRedPoint(canvas: Canvas) {
        mRedPointPaint.style = Paint.Style.FILL
        mRedPointPaint.color = -0x10000
        mRedPointPaint.isAntiAlias = true
        mRedPointPaint.isDither = true
        val radius = DensityUtil.dip2px(context, 3f)
        mRedPointRectF.left = width / 2f + imageView!!.width / 2f - radius
        mRedPointRectF.top = height / 2f - (imageView!!.height + textView!!.height) / 2f
        mRedPointRectF.right = width / 2 + imageView!!.width / 2 + radius.toFloat()
        mRedPointRectF.bottom =
            height / 2f - (imageView!!.height + textView!!.height) / 2f + radius * 2
        canvas.drawOval(mRedPointRectF, mRedPointPaint)
    }

    /**
     * 画消息数量
     */
    private fun drawMessages(canvas: Canvas) {
        val text = if (mMessageNumber > 99) "99+" else mMessageNumber.toString() + ""
        val textSize: Int
        textSize = if (text.length == 1) {
            DensityUtil.sp2px(context, 12f)
        } else if (text.length == 2) {
            DensityUtil.sp2px(context, 10f)
        } else {
            DensityUtil.sp2px(context, 8f)
        }
        mMessagePaint.color = -0x22000001
        mMessagePaint.isFakeBoldText = true
        mMessagePaint.isAntiAlias = true
        mMessagePaint.textSize = textSize.toFloat()
        mMessagePaint.typeface = Typeface.MONOSPACE
        mMessagePaint.getTextBounds(text, 0, text.length, mMessageRect)
        mMessagePaint.textAlign = Paint.Align.CENTER
        val fontMetrics = mMessagePaint.fontMetrics
        //画圆
        val radius = DensityUtil.dip2px(context, 8f)
        mMessageRectF.left = width / 2f + imageView!!.width / 2f - radius
        mMessageRectF.top = height / 2f - (imageView!!.height + textView!!.height) / 2f
        mMessageRectF.right = width / 2 + imageView!!.width / 2 + radius.toFloat()
        mMessageRectF.bottom =
            height / 2f - (imageView!!.height + textView!!.height) / 2f + radius * 2
        mRedPointPaint.style = Paint.Style.FILL
        mRedPointPaint.color = -0x10000
        mRedPointPaint.isAntiAlias = true
        mRedPointPaint.isDither = true
        canvas.drawOval(mMessageRectF, mRedPointPaint)
        //苗边
        mRedPointPaint.style = Paint.Style.STROKE
        mRedPointPaint.strokeWidth = DensityUtil.dip2px(
            context,
            1f
        ).toFloat()
        mRedPointPaint.color = -0x1
        canvas.drawOval(mMessageRectF, mRedPointPaint)
        //画数字
        val x = mMessageRectF.right - mMessageRectF.width() / 2f
        val y =
            mMessageRectF.bottom - mMessageRectF.height() / 2f - fontMetrics.descent + (fontMetrics.descent - fontMetrics.ascent) / 2
        canvas.drawText(text, x, y, mMessagePaint)
    }

    /**
     * 消息数量变化并刷新
     */
    fun addMessageNumber(number: Int) {
        mMessageNumber += number
        invalidateView()
    }

    fun resetMessageNumber() {
        mMessageNumber = 0
        invalidateView()
    }

    var messageNumber: Int
        get() = mMessageNumber
        set(number) {
            mMessageNumber = number
            invalidateView()
        }

    /**
     * 小红点
     */
    fun showRedPoint(show: Boolean) {
        if (mShowRedPoint != show) {
            mShowRedPoint = show
            invalidateView()
        }
    }

    /**
     * 没有放大
     */
    override fun setSelected(selected: Boolean) {
        textView!!.setTextColor(if (selected) mTextColorSelected else mTextColorNormal)
        imageView!!.setImageResource(if (selected) mSelectedBitmap else mNormalBitmap)
        invalidateView()
    }

    /**
     * 重绘
     */
    private fun invalidateView() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            invalidate()
        } else {
            postInvalidate()
        }
    }
}