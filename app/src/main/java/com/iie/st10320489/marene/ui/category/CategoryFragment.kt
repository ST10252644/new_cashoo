package com.iie.st10320489.marene.ui.category

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.iie.st10320489.marene.R
import com.iie.st10320489.marene.databinding.FragmentCategoryBinding
import com.iie.st10320489.marene.data.database.DatabaseInstance
import com.iie.st10320489.marene.graphs.MonthlySummaryFragment
import kotlinx.coroutines.launch

class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: CategoryViewModel
    private lateinit var adapter: CategoryAdapter
    private var userId: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate layout using ViewBinding
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Initialize ViewModel
        viewModel = ViewModelProvider(this)[CategoryViewModel::class.java]

        // Set up RecyclerView with a GridLayout (3 columns)
        binding.recyclerViewCategories.layoutManager = GridLayoutManager(requireContext(), 3)

        // Initialize adapter with empty list and click listener for each category item
        adapter = CategoryAdapter(emptyList()) { category ->
            val bundle = Bundle().apply {
                putInt("userId", userId)
                putString("categoryName", category.name)
            }

            // Navigate based on category type
            if (category.name == "Other") {
                findNavController().navigate(R.id.action_categoryFragment_to_subcategoryFragment, bundle)
            } else {
                findNavController().navigate(R.id.action_categoryFragment_to_filterFragment, bundle)
            }
        }

        // Attach adapter to RecyclerView
        binding.recyclerViewCategories.adapter = adapter

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Retrieve logged-in user's email from SharedPreferences
        val sharedPref = requireContext().getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)
        val currentUserEmail = sharedPref.getString("currentUserEmail", null)

        if (currentUserEmail != null) {
            lifecycleScope.launch {
                // Fetch user ID from database
                val database = DatabaseInstance.getDatabase(requireContext())
                userId = database.userDao().getUserIdByEmail(currentUserEmail) ?: 0

                // If valid user, load their categories and attach the graph fragment
                if (userId != 0) {
                    loadCategoriesForUser(userId)
                    addMonthlySummaryFragment()
                }
            }
        }
    }

    // Observes the categories LiveData and updates the adapter
    private fun loadCategoriesForUser(userId: Int) {
        viewModel.getCategoriesByUser(userId).observe(viewLifecycleOwner) { categories ->
            adapter.updateCategories(categories ?: emptyList())
        }
    }

    // Dynamically adds MonthlySummaryFragment inside this fragment's container
    private fun addMonthlySummaryFragment() {
        val fragmentManager = childFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val fragment = MonthlySummaryFragment()

        // Replace existing fragment in container (if any)
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.addToBackStack(null) // Optional: allows navigating back
        fragmentTransaction.commit()
    }

    // Properly clean up binding to prevent memory leaks
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}