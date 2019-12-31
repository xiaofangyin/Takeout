package com.enzo.commonlibkt.widget.alertdialog

import android.app.Dialog
import android.content.Context
import android.text.TextUtils
import android.view.View
import com.enzo.commonlibkt.R
import kotlinx.android.synthetic.main.lib_alert_dialog_center.*

/**
 * 文 件 名: CenterAlertDialog
 * 创 建 人: xiaofangyin
 * 创建日期: 2017/4/26
 * 邮   箱: xiaofangyinwork@163.com
 */
class CenterAlertDialog private constructor(
    context: Context,
    private val builder: Builder
) : Dialog(context, R.style.BaseDialogTheme) {

    init {
        setContentView(R.layout.lib_alert_dialog_center)
        setCanceledOnTouchOutside(false)
        setCancelable(false)
        findView()
    }

    private fun findView() {
        if (!TextUtils.isEmpty(builder.title)) {
            tv_alert_dialog_title.text = builder.title
        } else {
            tv_alert_dialog_title.visibility = View.GONE
        }
        if (!TextUtils.isEmpty(builder.content)) {
            tv_alert_dialog_content.text = builder.content
        }
        if (!TextUtils.isEmpty(builder.cancel)) {
            tv_alert_dialog_cancel.text = builder.cancel
        } else {
            tv_alert_dialog_cancel.visibility = View.GONE
        }
        if (!TextUtils.isEmpty(builder.confirm)) {
            tv_alert_dialog_confirm.text = builder.confirm
        } else {
            tv_alert_dialog_confirm.visibility = View.GONE
        }
        if (builder.gravity != 0) {
            tv_alert_dialog_content.gravity = builder.gravity
        }
        tv_alert_dialog_cancel.setOnClickListener {
            if (builder.alertDialogListener != null) {
                builder.alertDialogListener!!.onNegClick()
            }
            dismiss()
        }
        tv_alert_dialog_confirm.setOnClickListener {
            if (builder.alertDialogListener != null) {
                builder.alertDialogListener!!.onPosClick()
            }
            dismiss()
        }
    }

    class Builder(private val context: Context) {
        internal var title: String? = null
        internal var content: String? = null
        internal var cancel: String? = null
        internal var confirm: String? = null
        internal var gravity = 0
        internal var alertDialogListener: AlertDialogListener? = null
        fun title(title: String?): Builder {
            this.title = title
            return this
        }

        fun content(content: String?): Builder {
            this.content = content
            return this
        }

        fun cancel(cancel: String?): Builder {
            this.cancel = cancel
            return this
        }

        fun confirm(confirm: String?): Builder {
            this.confirm = confirm
            return this
        }

        fun gravity(gravity: Int): Builder {
            this.gravity = gravity
            return this
        }

        fun listener(listener: AlertDialogListener?): Builder {
            alertDialogListener = listener
            return this
        }

        fun build(): CenterAlertDialog {
            return CenterAlertDialog(context, this)
        }

    }

    interface AlertDialogListener {
        fun onNegClick()
        fun onPosClick()
    }
}