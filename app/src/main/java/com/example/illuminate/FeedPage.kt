package com.example.illuminate

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.PendingIntent.getActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.illuminate.AdapterClasses.ActivityFeedAdapter
import com.example.illuminate.ModelClasses.ActivityFeedModel


class FeedPage : AppCompatActivity() {

lateinit var rvFeedListing:RecyclerView

    private lateinit var spinnerLayout: ConstraintLayout
    private lateinit var spinnerText: TextView
    private lateinit var spinnerArrow: ImageView
    private lateinit var listView: ListView
    private val items = listOf("Item 1", "Item 2", "Item 3")
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed_page)
        finView()
        displayRecycleView()
        onClickListener()
        setAdapterListing()


    }

    private fun setAdapterListing() {
        // Set adapter for the list view
        listView.adapter = ArrayAdapter(this, R.layout.simple_spinner_dropdown, items)
        listView.setOnItemClickListener { parent, view, position, id ->
            spinnerText.text = parent.getItemAtPosition(position).toString()
            listView.visibility = View.GONE
        }
    }


    private fun finView()
    {
        rvFeedListing=findViewById(R.id.rvFeedListing)
        spinnerLayout = findViewById(R.id.spinner_layout)
        spinnerText = findViewById(R.id.spinner_text)
        spinnerArrow = findViewById(R.id.spinner_arrow)
        listView = findViewById(R.id.list_view)
    }

    private fun onClickListener()
    {
        // Set click listener for the spinner
        spinnerLayout.setOnClickListener {
            toggleDropdownMenu()
        }

    }

    private fun toggleDropdownMenu() {
        if (listView.visibility == View.VISIBLE) {
            // Hide the list view and set arrow icon to down
            listView.visibility = View.GONE
            spinnerArrow.setImageResource(R.drawable.ic_arrow_down)
        } else {
            // Show the list view and set arrow icon to up
            listView.visibility = View.VISIBLE
            spinnerArrow.setImageResource(R.drawable.ic_arrow_up)
        }

    }

    private fun displayRecycleView()
    {
        val layoutManager = LinearLayoutManager(this)
        rvFeedListing.layoutManager = layoutManager

        val showlist=ArrayList<ActivityFeedModel>()
        showlist.add(
            ActivityFeedModel(R.drawable.hassimg, "Philip Convay is currently with Sofia Maev and 5 others at Emporium Mall","3 hours ago","The Bacon Experience Dinner",
                null,"Bringing @Jasmine and good food around a table that warms the soul.", R.drawable.rectangle_529,"10 Likes","View  all 167 comments")
        )
        showlist.add(
            ActivityFeedModel(R.drawable.hassimg, "Maria John is going at Theme Park","3 hours ago","Music concert ",
                "March 4 at 9 AM","Bringing @Mark As far as events go, those with live music are some of the most engaging and entertaining for attendees. But without the right plan in place, they can also be the most likely to hit some bumps in the road. That’s why we put together this guide on how to plan a concert.",null,"10 Likes","View  all 167 comments")
        )

        showlist.add(
            ActivityFeedModel(R.drawable.hassan, "Philip Convay is currently with Sofia Maev and 5 others at Emporium Mall","3 hours ago","The Bacon Experience Dinner",
                "March 4 at 9 AM","Bringing @Jasmine and good food around a table that warms the soul.", R.drawable.rectangle_529,"10 Likes","View  all 167 comments")
        )

        val adopter= ActivityFeedAdapter()
        adopter.set_Data(showlist)
        rvFeedListing.adapter=adopter

    }
}