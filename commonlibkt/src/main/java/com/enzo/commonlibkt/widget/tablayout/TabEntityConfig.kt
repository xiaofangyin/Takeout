package com.enzo.commonlibkt.widget.tablayout

import com.enzo.commonlibkt.R
import java.util.*

/**
 * 文 件 名: TabEntityConfig
 * 创 建 人: xiaofangyin
 * 创建日期: 2018/5/25
 * 邮   箱: xiaofangyinwork@163.com
 */
object TabEntityConfig {
    val entities: List<TabEntity>
        get() {
            val list: MutableList<TabEntity> = ArrayList()
            val entity1 =
                TabEntity(
                    "首页",
                    -0x555556,
                    -0xfb2e56,
                    R.mipmap.icon_home_tab_1_normal,
                    R.mipmap.icon_home_tab_1_selected
                )
            val entity2 =
                TabEntity(
                    "关注",
                    -0x555556,
                    -0xfb2e56,
                    R.mipmap.icon_home_tab_2_normal,
                    R.mipmap.icon_home_tab_2_selected
                )
            val entity3 =
                TabEntity(
                    "消息",
                    -0x555556,
                    -0xfb2e56,
                    R.mipmap.icon_home_tab_4_normal,
                    R.mipmap.icon_home_tab_4_selected
                )
            val entity4 =
                TabEntity(
                    "我",
                    -0x555556,
                    -0xfb2e56,
                    R.mipmap.icon_home_tab_5_normal,
                    R.mipmap.icon_home_tab_5_selected
                )
            list.add(entity1)
            list.add(entity2)
            list.add(entity3)
            list.add(entity4)
            return list
        }
}