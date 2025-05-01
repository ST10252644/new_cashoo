package com.iie.st10320489.marene.ui.subcategory

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.iie.st10320489.marene.R
import com.iie.st10320489.marene.data.database.AppDatabase
import com.iie.st10320489.marene.data.database.DatabaseInstance
import com.iie.st10320489.marene.data.entities.SubCategory
import com.iie.st10320489.marene.databinding.FragmentSubcategoryBinding
import kotlinx.coroutines.launch

class SubcategoryFragment : Fragment() { // (Code With Cal, 2025)

    // View binding for the fragment's layout
    private var _binding: FragmentSubcategoryBinding? = null
    private val binding get() = _binding!!

    // Adapter for the RecyclerView to display subcategories
    private lateinit var adapter: SubcategoryAdapter

    private lateinit var database: AppDatabase

    // SharedPreferences to store and retrieve user data
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSubcategoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Called after the view is created, initialize database, SharedPreferences, adapter, and load data
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        database = DatabaseInstance.getDatabase(requireContext()) // (CodeWithMazn, 2020)

        sharedPreferences = requireActivity().getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)

        // Initialize the adapter with an empty list and set click listener for each item
        adapter = SubcategoryAdapter(mutableListOf()) { selectedSubcategory ->
            // Pass category and subcategory name to the next fragment using Bundle
            val bundle = Bundle().apply {
                putString("categoryName", selectedSubcategory.name)
                putString("subCategoryName", selectedSubcategory.name)
            }
            // Navigate to the FilterFragment with the selected subcategory
            findNavController().navigate(R.id.action_subcategoryFragment_to_filterFragment, bundle) // (CodeWithMazn, 2020)
        }


        binding.recyclerViewSubcategories.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewSubcategories.adapter = adapter // (CodeWithMazn, 2020)

        // Load subcategories from the database
        loadSubcategories()
    }

    // Loads subcategories from the database based on the current user
    fun loadSubcategories() {

        lifecycleScope.launch {
            // Retrieve shared preferences again
            sharedPreferences = requireActivity().getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)
            val currentUserEmail = sharedPreferences.getString("currentUserEmail", null)

            // Check if a user email exists
            if (currentUserEmail != null) {
                // Fetch user ID associated with the email
                val userId = database.userDao().getUserIdByEmail(currentUserEmail)

                // If user ID is valid, fetch subcategories and update the adapter
                if (userId != null) {
                    val subcategoriesFromDb = database.subCategoryDao().getSubCategoriesForUser(userId)
                    adapter.updateList(subcategoriesFromDb)
                }
            }
        }
    }

    // Clean up binding to avoid memory leaks
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // (Code With Cal, 2025)
    } // (Android Developers, 2025)
}

//Reference List
//CodeWithMazn. 2020. Dialog Fragment in Android [Kotlin 2020]. [video online]. Available at: https://www.youtube.com/watch?v=SkFcDWt9GV4 [Accessed on 13 April 2025]
//GeeksforGeeks. 2025. Android UI Layouts. [online]. Available at: https://www.geeksforgeeks.org/android-ui-layouts/ [Accessed on 10 April 2025]
//Muhammadumarch. 2023. Implementing Navigation in Your Android App with Android Navigation Component. [online]. Available at: https://medium.com/@muhammadumarch321/implementing-navigation-in-your-android-app-with-android-navigation-component-ff22a3d300a [Accessed on 11 April 2025]
//Android Developers. 2025. Fragment lifecycle. [online]. Available at: https://developer.android.com/guide/fragments/lifecycle [Accessed on 12 April 2025]
//Android Knowledge. 2024. ViewModel in Android Studio using Kotlin | Android Knowledge. [video online]. Available at: https://www.youtube.com/watch?v=v32hSKtlH9A [Accessed on 11 April 2025]
//Code With Cal. 2025. Room Database Android Studio Kotlin Example Tutorial. [video online]. Available at: https://www.youtube.com/watch?v=-LNg-K7SncM [Accessed on 12 April 2025]
//Coding With T. 2020. 06 - Categories Design in Android Studio - Android Studio Cardview. Available at: https://www.youtube.com/watch?v=7S7646Cymn0 [Accessed on 12 April 2025]
//Android Developers. 2025. Accessing data using Room DAOs. [online]. Available at: https://developer.android.com/training/data-storage/room/accessing-data [Accessed on 15 April 2025]