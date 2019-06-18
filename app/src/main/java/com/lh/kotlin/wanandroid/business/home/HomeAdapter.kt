package com.lh.kotlin.wanandroid.business.home

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.lh.kotlin.wanandroid.R
import com.lh.kotlin.wanandroid.base.BaseFragment
import com.lh.kotlin.wanandroid.module.Datas

/**
 * Created by lh
 */
class HomeAdapter(baseFragment: BaseFragment, data: List<Datas>?) :
    BaseQuickAdapter<Datas, BaseViewHolder>(R.layout.item_home_list) {
    override fun convert(helper: BaseViewHolder?, item: Datas?) {
        if(item == null) {
            return
        }
        @Suppress("DEPRECATION")
        helper!!.setText(R.id.homeItemTitle, item.title)
            .setText(R.id.homeItemAuthor, item.author)
            .setText(R.id.homeItemType, item.chapterName)
            .addOnClickListener(R.id.homeItemType)
            .setTextColor(R.id.homeItemType, mContext.resources.getColor(R.color.colorPrimary))
            .linkify(R.id.homeItemType)
            .setText(R.id.homeItemDate, item.niceDate)
            .setImageResource(
                R.id.homeItemLike,
                if (item.collect) R.drawable.ic_action_like else R.drawable.ic_action_no_like
            )
            .addOnClickListener(R.id.homeItemLike)
    }

}