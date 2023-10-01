package com.example.illuminate.AdapterClasses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.illuminate.ModelClasses.OnboardingItem
import com.example.illuminate.R

class OnBoardingAdapter (private val onboardingItems: List<OnboardingItem>) :
    RecyclerView.Adapter<OnBoardingAdapter.OnboardingViewHolder>() {

    inner class OnboardingViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val imageView: ImageView = itemView.findViewById(R.id.imageView)
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)

        fun bind(item: OnboardingItem) {
            imageView.setImageResource(item.image)
            titleTextView.text = item.title
            descriptionTextView.text = item.description
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_onboarding, parent, false)
        return OnboardingViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        val item = onboardingItems[position]
        holder.bind(item)
    }

    override fun getItemCount() = onboardingItems.size
}