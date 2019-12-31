package com.enzo.takeout.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.enzo.commonlibkt.base.BaseFragment
import com.enzo.commonlibkt.widget.alertdialog.BottomAlertDialog
import com.enzo.commonlibkt.widget.alertdialog.CenterAlertDialog
import com.enzo.takeout.R
import kotlinx.android.synthetic.main.fragment_home_4.*

/**
 * 文 件 名: HomeFragment4
 * 创 建 人: xiaofy
 * 创建日期: 2019/11/24
 * 邮   箱: xiaofangyinwork@163.com
 */
class HomeFragment4 : BaseFragment() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_home_4
    }

    override fun initView(rootView: View?) {

    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun initListener(rootView: View?) {
        bottom_dialog.setOnClickListener {
            BottomAlertDialog.Builder(it.context)
                .add("1")
                .add("2")
                .add("3")
                .cancel("取消")
                .listener(object : BottomAlertDialog.OnItemClickListener {
                    override fun onItemClick(i: Int, data: String?) {
                        Toast.makeText(view!!.context, data, Toast.LENGTH_SHORT).show()
                    }
                })
                .build()
                .show()
        }

        center_dialog.setOnClickListener {
            CenterAlertDialog.Builder(it.context)
                .title("退出登录")
                .content("是否退出登录")
                .cancel("取消")
                .confirm("确定")
                .listener(object : CenterAlertDialog.AlertDialogListener {
                    override fun onNegClick() {
                        Toast.makeText(view!!.context, "取消", Toast.LENGTH_SHORT).show()

                    }

                    override fun onPosClick() {
                        Toast.makeText(view!!.context, "确定", Toast.LENGTH_SHORT).show()

                    }
                })
                .build()
                .show()
        }
    }
}