package com.example.gridrecyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gridrecyclerviewdemo.adapter.ParentAdapter
import com.example.gridrecyclerviewdemo.model.ChildData
import com.example.gridrecyclerviewdemo.model.ParentData
import java.util.Locale

class MainActivity : AppCompatActivity() {

    lateinit var parentItemList: ArrayList<ParentData>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvRecycleView = findViewById<RecyclerView>(R.id.main_recyclerView)

        rvRecycleView.setHasFixedSize(true)
        rvRecycleView.layoutManager = LinearLayoutManager(this)

        parentItemList = arrayListOf() //now its  initialized

        val adapter = ParentAdapter(parentItemList)

        val searchView = findViewById<SearchView>(R.id.search_view)

        setData()

        rvRecycleView.adapter = adapter


        searchView.setOnQueryTextListener(object:SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val searchList = ArrayList<ParentData>()

                if (newText != null){

                    for (i in parentItemList){
                        if(i.title.lowercase(Locale.ROOT).contains(newText)){
                            searchList.add(i)
                        }
                    }
                    if (searchList.isEmpty()){
                        Toast.makeText(this@MainActivity, "No Data", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        adapter.onApplySearch(searchList)
                    }
                }
                return true
            }
        })

    }

    private fun setData() {

        var chilItemList = ArrayList<ChildData>()

        chilItemList.add(ChildData(R.drawable.b1))
        chilItemList.add(ChildData(R.drawable.b2))
        chilItemList.add(ChildData(R.drawable.b3))
        chilItemList.add(ChildData(R.drawable.b4))
        chilItemList.add(ChildData(R.drawable.b5))
        chilItemList.add(ChildData(R.drawable.b6))
        chilItemList.add(ChildData(R.drawable.b7))
        chilItemList.add(ChildData(R.drawable.b8))
        chilItemList.add(ChildData(R.drawable.b9))
        chilItemList.add(ChildData(R.drawable.b10))
        chilItemList.add(ChildData(R.drawable.b11))
        chilItemList.add(ChildData(R.drawable.b12))


        parentItemList.add(ParentData("Top Seller", chilItemList))

        var chList = chilItemList.reversed()
        parentItemList.add(ParentData("Motivational", chList))

        parentItemList.add(ParentData("Self Help", chilItemList))

    }

}