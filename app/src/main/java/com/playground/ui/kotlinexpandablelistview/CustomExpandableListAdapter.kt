package com.playground.ui.kotlinexpandablelistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView

class CustomExpandableListAdapter constructor(
    private val context: Context,
    private val titleList: List<String>,
    private val dataList: HashMap<String, List<String>>
) : BaseExpandableListAdapter() {

    override fun getGroup(listposition: Int): Any {
        return this.titleList[listposition]
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(
        listPosition: Int,
        isExpaneded: Boolean,
        convertView: View?,
        parent: ViewGroup?): View {
        var convertViewAlternate = convertView
        val listTitle = getGroup(listPosition) as String
        if (convertViewAlternate == null) {
            val layoutInflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertViewAlternate = layoutInflater.inflate(R.layout.list_group, null)
        }
        val listTitleTextView = convertViewAlternate!!.findViewById<TextView>(R.id.listTitle)
        listTitleTextView.text = listTitle
        return convertViewAlternate
    }

    override fun getChildrenCount(listPosition: Int): Int {
        return this.dataList[this.titleList[listPosition]]!!.size
    }

    override fun getChild(listPosition: Int, expandedListPosition: Int): Any {
        return this.dataList[this.titleList[listPosition]]!![expandedListPosition]
    }

    override fun getGroupId(listPosition: Int): Long {
        return listPosition.toLong()
    }

    override fun getChildView(
        listPosition: Int,
        expanedListPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?): View {
        var convertViewAlternate = convertView
        val expandedListText = getChild(listPosition, expanedListPosition) as String
        if (convertViewAlternate == null) {
            val layoutInflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertViewAlternate = layoutInflater.inflate(R.layout.list_item, null)
        }
        val expandedListTextView = convertViewAlternate!!.findViewById<TextView>(R.id.expandedListItem)
        expandedListTextView.text = expandedListText
        return convertViewAlternate
    }

    override fun getChildId(listPosition: Int, expanedListPosition: Int): Long {
        return expanedListPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return this.titleList.size
    }

}