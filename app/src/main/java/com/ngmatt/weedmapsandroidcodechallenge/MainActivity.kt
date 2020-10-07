package com.ngmatt.weedmapsandroidcodechallenge

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Matt Ng on 9/14/20
 */
class MainActivity: Activity() {


    private lateinit var blogAdapter: YelpRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        addDataSet()
    }

    private fun addDataSet(){
        val data = DataSource.createDataSet()
        blogAdapter.submitList(data)
    }

    private fun initRecyclerView(){
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val topSpacingItemDecloration = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingItemDecloration)
            blogAdapter = YelpRecyclerAdapter()
            adapter = blogAdapter
        }
    }
}