package com.iie.st10320489.marene.ui.subcategory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.iie.st10320489.marene.R
import com.iie.st10320489.marene.data.entities.SubCategory

// Adapter class for displaying a list of SubCategory items in a RecyclerView
class SubcategoryAdapter(
    private val subcategories: MutableList<SubCategory>, // List of subcategories to display
    private val onItemClick: (SubCategory) -> Unit
) : RecyclerView.Adapter<SubcategoryAdapter.SubcategoryViewHolder>() { // (GeeksforGeeks. 2025)

    // Called when RecyclerView needs a new ViewHolder of the given type to represent an item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubcategoryViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_subcategory, parent, false)
        return SubcategoryViewHolder(view)
    } // (GeeksforGeeks. 2025)

    // Called by RecyclerView to display the data at the specified position
    override fun onBindViewHolder(holder: SubcategoryViewHolder, position: Int) {
        val subcategory = subcategories[position]
        holder.title.text = subcategory.name
        holder.itemView.setOnClickListener { onItemClick(subcategory) }
    }

    // Returns the total number of items in the list
    override fun getItemCount(): Int = subcategories.size


    inner class SubcategoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.subcategoryTitle)
    }

        fun updateList(newList: List<SubCategory>) {   // Updates the list of subcategories and refreshes the RecyclerView
            subcategories.clear()
            subcategories.addAll(newList)
            notifyDataSetChanged() // (GeeksforGeeks. 2025)
        }
    }
 // (Code With Cal, 2025)

//Reference List
//CodeWithMazn. 2020. Dialog Fragment in Android [Kotlin 2020]. [video online]. Available at: https://www.youtube.com/watch?v=SkFcDWt9GV4 [Accessed on 13 April 2025]
//GeeksforGeeks. 2025. Android UI Layouts. [online]. Available at: https://www.geeksforgeeks.org/android-ui-layouts/ [Accessed on 10 April 2025]
//Muhammadumarch. 2023. Implementing Navigation in Your Android App with Android Navigation Component. [online]. Available at: https://medium.com/@muhammadumarch321/implementing-navigation-in-your-android-app-with-android-navigation-component-ff22a3d300a [Accessed on 11 April 2025]
//Android Developers. 2025. Fragment lifecycle. [online]. Available at: https://developer.android.com/guide/fragments/lifecycle [Accessed on 12 April 2025]
//Android Knowledge. 2024. ViewModel in Android Studio using Kotlin | Android Knowledge. [video online]. Available at: https://www.youtube.com/watch?v=v32hSKtlH9A [Accessed on 11 April 2025]
//Code With Cal. 2025. Room Database Android Studio Kotlin Example Tutorial. [video online]. Available at: https://www.youtube.com/watch?v=-LNg-K7SncM [Accessed on 12 April 2025]
//Coding With T. 2020. 06 - Categories Design in Android Studio - Android Studio Cardview. Available at: https://www.youtube.com/watch?v=7S7646Cymn0 [Accessed on 12 April 2025]
//Android Developers. 2025. Accessing data using Room DAOs. [online]. Available at: https://developer.android.com/training/data-storage/room/accessing-data [Accessed on 15 April 2025]