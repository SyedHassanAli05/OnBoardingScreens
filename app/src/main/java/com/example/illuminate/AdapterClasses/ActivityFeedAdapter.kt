package com.example.illuminate.AdapterClasses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.illuminate.ModelClasses.ActivityFeedModel
import com.example.illuminate.R

class ActivityFeedAdapter():RecyclerView.Adapter<ActivityFeedAdapter. ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityFeedAdapter.ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.items_feedpage,parent,false)
        return ViewHolder(view)
    }

    lateinit var arrlist:ArrayList<ActivityFeedModel>
    fun set_Data(list: ArrayList<ActivityFeedModel>){
        arrlist=list
    }

    override fun onBindViewHolder(holder: ActivityFeedAdapter.ViewHolder, position: Int) {
        val currentItem = arrlist[position]
        holder.ivProfile.setImageResource(currentItem.ivProfile)
        holder.tvPersonName.text = currentItem.tvPersonName
        holder.tvTimesAgo.text = currentItem.tvTimesAgo
        holder.tvTitle.text = currentItem.tvTitle
        holder.tvDescription.text = currentItem.tvDescription
        holder.tvLikes.text = currentItem.tvLikes
        holder.tvComments.text = currentItem.tvComments

        // Check if the current item has an image or not
        if (currentItem.ivImageUpload != null) {
            holder.ivImageUpload.setImageResource(currentItem.ivImageUpload)
            holder.ivImageUpload.visibility = View.VISIBLE
        } else {
            holder.ivImageUpload.visibility = View.GONE
        }

        if (currentItem.tvDate != null) {
            holder.tvDate.text = currentItem.tvDate
            holder.tvDate.visibility = View.VISIBLE
        } else {
            holder.tvDate.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return arrlist.size
    }

    class ViewHolder(Itemview: View):RecyclerView.ViewHolder(Itemview)
    {
        val ivProfile:ImageView=itemView.findViewById(R.id.ivProfile)
        val tvPersonName:TextView=itemView.findViewById(R.id.tvPersonName)
        val tvTimesAgo:TextView=itemView.findViewById(R.id.tvTimesAgo)
        val tvTitle:TextView=itemView.findViewById(R.id.tvTitle)
        val tvDate:TextView=itemView.findViewById(R.id.tvDate)
        val tvDescription:TextView=itemView.findViewById(R.id.tvDescription)
        val ivImageUpload:ImageView=itemView.findViewById(R.id.ivImageUpload)
        val tvLikes:TextView=itemView.findViewById(R.id.tvLikes)
        val tvComments:TextView=itemView.findViewById(R.id.tvComments)

    }

}