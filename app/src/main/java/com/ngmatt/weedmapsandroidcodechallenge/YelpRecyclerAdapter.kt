package com.ngmatt.weedmapsandroidcodechallenge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ngmatt.weedmapsandroidcodechallenge.models.YelpBusiness
import kotlinx.android.synthetic.main.layout_yelp_list_item.view.*

class YelpRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<YelpBusiness> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return YelpViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_yelp_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is YelpViewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    fun submitList(yelpList: List<YelpBusiness>){
        items = yelpList
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class YelpViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView){
        val yelpImage: ImageView = itemView.yelp_image
        val yelpName: TextView = itemView.yelp_name
        val yelpReview: TextView = itemView.topReview
        val rating: RatingBar = itemView.rating

        fun bind(yelpResult: YelpBusiness){
            yelpName.setText(yelpResult.name)
            val reviewText: String = "Top Rated Review: ${yelpResult.topReview}"
            yelpReview.setText(reviewText)
            rating.rating = yelpResult.rating.toFloat()

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(yelpResult.image)
                .into(yelpImage)
        }
    }
}