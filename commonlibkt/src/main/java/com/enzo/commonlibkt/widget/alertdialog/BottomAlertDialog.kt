package com.enzo.commonlibkt.widget.alertdialog

import android.app.Dialog
import android.content.Context
import android.text.TextUtils
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.enzo.commonlibkt.R
import com.enzo.commonlibkt.utils.DensityUtil
import kotlinx.android.synthetic.main.lib_alert_dialog_bottom.*
import java.util.*

/**
 * 文 件 名: BottomAlertDialog
 * 创 建 人: xiaofangyin
 * 创建日期: 2017/4/26
 * 邮   箱: xiaofangyinwork@163.com
 */
class BottomAlertDialog private constructor(
    context: Context,
    private val mBuilder: Builder
) : Dialog(context, R.style.BaseDialogTheme) {

    init {
        window!!.setWindowAnimations(R.style.BottomDialogStyle)
        setContentView(R.layout.lib_alert_dialog_bottom)
        configScreenSize(context)
        findView()
    }

    private fun findView() {
        for (i in mBuilder.mItems.indices) {
            val textView = TextView(context)
            val layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                DensityUtil.dip2px(context, 45f)
            )
            layoutParams.setMargins(
                0, 0,
                0, DensityUtil.dip2px(context, 0.5f)
            )
            textView.layoutParams = layoutParams
            textView.background =
                ContextCompat.getDrawable(context, R.drawable.lib_selector_white_bg)
            textView.textSize = 16f
            textView.setTextColor(-0xcccccd)
            textView.gravity = Gravity.CENTER
            textView.text = mBuilder.mItems[i]
            ll_alert_dialog_bottom_layout.addView(textView)
            textView.setOnClickListener {
                dismiss()
                if (mBuilder.itemClickListener != null) {
                    mBuilder.itemClickListener!!.onItemClick(i, mBuilder.mItems[i])
                }
            }
        }
        val cancel =
            if (TextUtils.isEmpty(mBuilder.mCancel)) "取消" else mBuilder.mCancel!!
        tv_cancel.text = cancel
        tv_cancel.setOnClickListener { dismiss() }
    }

    private fun configScreenSize(context: Context) {
        val display = DisplayMetrics()
        val manager =
            context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        manager.defaultDisplay.getMetrics(display)
        val mScreenWidth = Math.min(display.heightPixels, display.widthPixels)
        val lp = window!!.attributes
        lp.width = mScreenWidth
        window!!.attributes = lp
        window!!.setGravity(Gravity.BOTTOM) // 底部展示
    }

    fun addExtView(view: View?) {
        ll_alert_dialog_bottom_layout!!.removeAllViews()
        ll_alert_dialog_bottom_layout!!.addView(view)
    }

    class Builder(private val mContext: Context) {
        internal var mCancel: String? = null
        internal val mItems: MutableList<String>
        internal var itemClickListener: OnItemClickListener? = null

        fun cancel(cancel: String?): Builder {
            mCancel = cancel
            return this
        }

        fun add(item: String): Builder {
            mItems.add(item)
            return this
        }

        fun listener(listener: OnItemClickListener?): Builder {
            itemClickListener = listener
            return this
        }

        fun build(): BottomAlertDialog {
            return BottomAlertDialog(mContext, this)
        }

        init {
            mItems = ArrayList()
        }
    }

    interface OnItemClickListener {
        fun onItemClick(i: Int, data: String?)
    }
}