package com.lh.kotlin.wanandroid.business.systemlist

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.lh.kotlin.wanandroid.R
import com.lh.kotlin.wanandroid.base.BaseFragment
import com.lh.kotlin.wanandroid.module.Datas
import com.lh.kotlin.wanandroid.module.HomeListData

/**
 * Created by lh
 * time: 2019/6/26
 */
class SystemListAdapter(baseFragment: BaseFragment, date: MutableList<Datas>?) :
    BaseQuickAdapter<Datas, BaseViewHolder>(R.layout.item_home_list) {
    override fun convert(helper: BaseViewHolder?, item: Datas?) {
        if (item == null) {
            return
        }
        @Suppress("DEPRECATION")
        helper!!.setText(R.id.homeItemTitle, item.title)
            .setText(R.id.homeItemAuthor, item.author)
            .setVisible(R.id.homeItemType, false)
            .setText(R.id.homeItemDate, item.niceDate)
            .setImageResource(
                R.id.homeItemLike,
                if (item.collect) R.drawable.ic_action_like else R.drawable.ic_action_no_like
            )
            .addOnClickListener(R.id.homeItemLike)
    }
}