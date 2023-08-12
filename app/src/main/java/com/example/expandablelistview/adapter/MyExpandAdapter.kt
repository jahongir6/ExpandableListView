package com.example.expandablelistview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.example.expandablelistview.databinding.ItemChildBinding
import com.example.expandablelistview.databinding.ItemParentBinding

class MyExpandAdapter(
    val titleList: ArrayList<String>,
    val map: HashMap<String, ArrayList<String>>
) :
    BaseExpandableListAdapter() {
    override fun getGroupCount(): Int { //grupppa nechta bolishini qaytarish
        return titleList.size
    }

    override fun getChildrenCount(groupPosition: Int): Int { //har bitta guruhdagi bolani nechtaligini jonatish kerak
        return map[titleList[groupPosition]]!!.size
    }

    override fun getGroup(groupPosition: Int): Any { //gruppani elementini qaytaribberish kerak
        return titleList[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any { //childni ozini qaytaradi
        val list = map[titleList[groupPosition]]!!
        return list[childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun hasStableIds(): Boolean = true

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val itemGroupBinding =
            ItemParentBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        itemGroupBinding.tvName.text = titleList[groupPosition]
        return itemGroupBinding.root
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val itemChildBinding =
            ItemChildBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        itemChildBinding.tvName.text =map[titleList[groupPosition]]?.get(childPosition)
        return itemChildBinding.root
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true

    }
}