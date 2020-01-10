package com.enzo.takeout.ui.fragment

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.enzo.commonlibkt.base.BaseFragment
import com.enzo.commonlibkt.widget.banner.ScaleInTransformer
import com.enzo.commonlibkt.widget.banner.creator.ImageHolderCreator
import com.enzo.commonlibkt.widget.banner.indicator.IndicatorView
import com.enzo.takeout.R
import kotlinx.android.synthetic.main.fragment_home_1.*

/**
 * 文 件 名: HomeFragment1
 * 创 建 人: xiaofy
 * 创建日期: 2019/11/24
 * 邮   箱: xiaofangyinwork@163.com
 */
class HomeFragment1 : BaseFragment() {

    companion object {
        val URLS = arrayOf(
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2860421298,3956393162&fm=26&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=163638141,898531478&fm=26&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1028426622,4209712325&fm=26&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1462142898,440466184&fm=26&gp=0.jpg",
            "https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3210855908,3095539181&fm=26&gp=0.jpg",
            "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2080505558,2205047574&fm=26&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2894881224,342594760&fm=26&gp=0.jpg",
            "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2894881224,342594760&fm=26&gp=0.jpg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3162346827,2000964752&fm=26&gp=0.jpg"
        )
    }

    private val list = ArrayList<String>()

    override fun getLayoutId(): Int {
        return R.layout.fragment_home_1
    }

    override fun initData(savedInstanceState: Bundle?) {
        for (url in URLS) {
            list.add(url)
        }
        val indicatorView: IndicatorView = IndicatorView(
            activity
        )
            .setIndicatorColor(Color.GRAY)
            .setIndicatorSelectorColor(Color.WHITE)
        banner.setIndicator(indicatorView)
            .setHolderCreator(ImageHolderCreator())
            .setOuterPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    Log.e("xfy", "onPageScrolled $position ")
                }

                override fun onPageSelected(position: Int) {
                    Log.e("xfy", "onPageSelected $position")
                }

                override fun onPageScrollStateChanged(state: Int) {
                    Log.e("xfy", "onPageScrollStateChanged $state")
                }
            })
            .setPages(list)

        banner.setPageMargin(40, 20)
        banner.setPageTransformer(true, ScaleInTransformer())
        banner.isAutoPlay = true
    }

    override fun initListener(rootView: View?) {

    }
}