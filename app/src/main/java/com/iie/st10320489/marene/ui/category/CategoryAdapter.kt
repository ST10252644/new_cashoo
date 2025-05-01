package com.iie.st10320489.marene.ui.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.iie.st10320489.marene.R
import com.iie.st10320489.marene.data.entities.Category


// RecyclerView Adapter for displaying a list of Categories
class CategoryAdapter(
    private var categories: List<Category>,                     // List of Category items to display
    private val onCategoryClick: (Category) -> Unit             // Callback when a category is clicked
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    // ViewHolder pattern for efficient view reuse
    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryButton: ImageButton = itemView.findViewById(R.id.categoryButton)  // Icon button
        val categoryTitle: TextView = itemView.findViewById(R.id.categoryTitle)       // Category name
    }

    // Inflate the layout for each item in the RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    // Bind data to the ViewHolder for the given position
    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]

        // Resolve and apply the background tint color from category
        val resolvedColor = ContextCompat.getColor(holder.itemView.context, category.colour)

        holder.categoryTitle.text = category.name     // Set category name
        holder.categoryButton.setImageResource(category.icon)    // Set icon image
        holder.categoryButton.background.setTint(resolvedColor)    // Tint button background

        // Handle item click
        holder.itemView.setOnClickListener {
            onCategoryClick(category)
        }
    }

    // Return total number of items in the list
    override fun getItemCount() = categories.size

    // Update adapter data and refresh the list
    fun updateCategories(newCategories: List<Category>) {
        categories = newCategories
        notifyDataSetChanged() // Notify that data has changed
    }
}