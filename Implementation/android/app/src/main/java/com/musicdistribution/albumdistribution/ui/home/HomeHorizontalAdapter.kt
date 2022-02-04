package com.musicdistribution.albumdistribution.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.musicdistribution.albumdistribution.R
import com.musicdistribution.albumdistribution.model.CategoryItem
import com.musicdistribution.albumdistribution.model.CategoryItemType

class HomeHorizontalAdapter(categoryItemList: MutableList<CategoryItem>, fragment: Fragment) :
    RecyclerView.Adapter<HomeHorizontalAdapter.ViewHolder>() {

    private var activityContext: Context? = null
    private var categoryData: MutableList<CategoryItem> = categoryItemList
    private var parentFragment = fragment

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val categoryImageControl: ImageView = view.findViewById(R.id.categoryItemView)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = layoutPosition
            if (position != RecyclerView.NO_POSITION) {
                val clickedItem = categoryData[position]
                if (clickedItem.itemType == CategoryItemType.ARTIST) {
                    parentFragment.findNavController()
                        .navigate(R.id.action_homeFragment_to_artistFragment)
                } else if (clickedItem.itemType == CategoryItemType.ALBUM) {
                    parentFragment.findNavController()
                        .navigate(R.id.action_homeFragment_to_albumFragment)
                } else if (clickedItem.itemType == CategoryItemType.SONG) {
                    parentFragment.findNavController()
                        .navigate(R.id.action_homeFragment_to_songFragment)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.category_item_adapter, parent, false)
        activityContext = parent.context
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentCategoryItem: CategoryItem = categoryData[position]
        Glide.with(activityContext!!.applicationContext)
            .load(currentCategoryItem.imageUrl)
            .placeholder(R.drawable.default_picture)
            .into(holder.categoryImageControl)
    }

    override fun getItemCount(): Int {
        return categoryData.size
    }
}