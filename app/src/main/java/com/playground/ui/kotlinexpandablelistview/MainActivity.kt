package com.playground.ui.kotlinexpandablelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ExpandableListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item.*

class MainActivity : AppCompatActivity() {

    private lateinit var expandableListView: ExpandableListView
    private lateinit var expandableListAdapter: CustomExpandableListAdapter
    private var titleList = mutableListOf<String>()

    private val data: HashMap<String, List<String>>
        get() {
            val listData = HashMap<String, List<String>>()

            val redmiMobiles = ArrayList<String>()
            redmiMobiles.add("Redmi Y2")
            redmiMobiles.add("Redmi S2")
            redmiMobiles.add("Redmi Note 5 Pro")
            redmiMobiles.add("Redmi Note 5")
            redmiMobiles.add("Redmi 5 Plus")
            redmiMobiles.add("Redmi Y1")
            redmiMobiles.add("Redmi 3S Plus")

            val micromaxMobiles = ArrayList<String>()
            micromaxMobiles.add("Micromax Bharat Go")
            micromaxMobiles.add("Micromax Bharat 5 Pro")
            micromaxMobiles.add("Micromax Bharat 5")
            micromaxMobiles.add("Micromax Canvas 1")
            micromaxMobiles.add("Micromax Dual 5")

            val appleMobiles = ArrayList<String>()
            appleMobiles.add("iPhone 8")
            appleMobiles.add("iPhone 8 Plus")
            appleMobiles.add("iPhone X")
            appleMobiles.add("iPhone 7 Plus")
            appleMobiles.add("iPhone 7")
            appleMobiles.add("iPhone 6 Plus")

            val samsungMobiles = ArrayList<String>()
            samsungMobiles.add("Samsung Galaxy S9+")
            samsungMobiles.add("Samsung Galaxy Note 7")
            samsungMobiles.add("Samsung Galaxy Note 5 Dual")
            samsungMobiles.add("Samsung Galaxy S8")
            samsungMobiles.add("Samsung Galaxy A8")
            samsungMobiles.add("Samsung Galaxy Note 4")

            listData["Redmi"] = redmiMobiles
            listData["Micromax"] = micromaxMobiles
            listData["Apple"] = appleMobiles
            listData["Samsung"] = samsungMobiles

            return listData
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        expandableListView = expandable_list_view

        val listData = data
        titleList = ArrayList(listData.keys)
        expandableListAdapter = CustomExpandableListAdapter(this, titleList as ArrayList<String>, listData)
        expandableListView.setAdapter(expandableListAdapter)

        expandableListView.setOnGroupExpandListener { position ->
            Toast.makeText(this, "${(titleList as ArrayList<String>)-position} List Expand.", Toast.LENGTH_SHORT).show()
        }

        expandableListView.setOnGroupCollapseListener {  position ->
            Toast.makeText(this, "${(titleList as ArrayList<String>)-position} List Expand.", Toast.LENGTH_SHORT).show()
        }

        expandableListView.setOnChildClickListener { expandableListView, view, groupPosition, childPosition, id ->
            Toast.makeText(this,
                "Clicked: ${(titleList as ArrayList<String>)[groupPosition]} -> ${listData[(titleList as ArrayList<String>)[groupPosition]]!!.get(childPosition)}",Toast.LENGTH_SHORT).show()
            false
        }

    }
}