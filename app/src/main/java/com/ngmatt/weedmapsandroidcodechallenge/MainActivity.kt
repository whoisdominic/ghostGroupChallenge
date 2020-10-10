package com.ngmatt.weedmapsandroidcodechallenge

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.ngmatt.weedmapsandroidcodechallenge.models.YelpBusiness
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

/**
 * Dominic Cobb, Thank you for giving me the opportunity to demonstrate my skill set.
 */
class MainActivity: Activity() {
    private lateinit var yelpAdapter: YelpRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hides the action bar
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        // search
        val searchBar = findViewById<SearchView>(R.id.searchView)
        val results = findViewById<TextView>(R.id.query)

        initRecyclerView()

        searchBar.setOnQueryTextListener(object :SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                searchBar.clearFocus()
                results.setText("Showing results for: $query")

                GlobalScope.launch(Dispatchers.IO) {
                    addDataSet(query)
                    joinAll()
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }

    fun addDataSet(query: String?) {
        val onSuccess: (ArrayList<YelpBusiness>) -> Unit = { data ->
            runOnUiThread {
                yelpAdapter.submitList(data)
                yelpAdapter.notifyDataSetChanged()
            }
        }
        DataSource.createDataSet(query, onSuccess)
    }

    private fun initRecyclerView(){
        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val topSpacingItemDecloration = TopSpacingItemDecoration(22)
            addItemDecoration(topSpacingItemDecloration)
            yelpAdapter = YelpRecyclerAdapter()
            adapter = yelpAdapter
        }
    }
}