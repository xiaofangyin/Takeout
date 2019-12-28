package com.enzo.commonlibkt.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * 文 件 名: BaseFragment
 * 创 建 人: xiaofangyin
 * 创建日期: 2017/9/26
 * 邮   箱: xiaofangyinwork@163.com
 */
abstract class BaseFragment : Fragment(), IBaseFragment {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(layoutId, null)
        initView(view)
        return view
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        initData(savedInstanceState)
        initListener(view)
    }
}