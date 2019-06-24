package com.lh.kotlin.wanandroid.business.system

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.lh.kotlin.wanandroid.R
import com.lh.kotlin.wanandroid.base.BaseFragment
import com.lh.kotlin.wanandroid.module.TreeListData
import com.zhy.view.flowlayout.FlowLayout
import com.zhy.view.flowlayout.TagAdapter
import com.zhy.view.flowlayout.TagFlowLayout

/**
 * Created by lh
 * time: 2019/6/24
 */
class SystemAdapter(baseFragment: BaseFragment,datas:List<TreeListData>?)
    : BaseQuickAdapter<TreeListData,BaseViewHolder>(R.layout.item_system){
    override fun convert(helper: BaseViewHolder?, item: TreeListData?) {
        var item_flow_layout = helper!!.getView<TagFlowLayout>(R.id.item_flow_layout)

        if (item == null) {
            item_flow_layout.visibility = View.VISIBLE
            return
        }
        helper!!.setText(R.id.item_system_tv,item.name)
        if (null != item.children) {
            var children = item.children

            var mSearchKeyWords = arrayOfNulls<String>(children!!.size)
            item_flow_layout.visibility = View.VISIBLE
            for (i in children.indices ) {
                var children1 = children[i]
                mSearchKeyWords[i] = children1.name
            }
            var tagAdapter = object : TagAdapter<String>(mSearchKeyWords){
                override fun getView(parent: FlowLayout?, position: Int, string: String?): View {
                    val layoutInflater = LayoutInflater.from(mContext)
                    val tv = layoutInflater.inflate(
                        R.layout.tv,
                        item_flow_layout, false
                    ) as TextView
                    tv.text = string
                    return tv
                }

                override fun onSelected(position: Int, view: View?) {
                    super.onSelected(position, view)
                }

                override fun unSelected(position: Int, view: View?) {
                    super.unSelected(position, view)
                }

            }
            item_flow_layout.adapter = tagAdapter


        }
    }
}