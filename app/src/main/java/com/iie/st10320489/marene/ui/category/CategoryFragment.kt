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
import kotlinx.coroutines.launch

class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: CategoryViewModel
    private lateinit var adapter: CategoryAdapter
    private var userId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPref = requireContext().getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)
        val currentUserEmail = sharedPref.getString("currentUserEmail", null)

        if (currentUserEmail != null) {
            lifecycleScope.launch {
                val database = DatabaseInstance.getDatabase(requireContext())
                userId = database.userDao().getUserIdByEmail(currentUserEmail) ?: 0
                if (userId != 0) {
                    loadCategoriesForUser(userId)
                }
            }
        }
    }

    private fun loadCategoriesForUser(userId: Int) {
        viewModel.getCategoriesByUser(userId).observe(viewLifecycleOwner) { categories ->
            adapter.updateCategories(categories ?: emptyList())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        viewModel = ViewModelProvider(this)[CategoryViewModel::class.java]

        binding.recyclerViewCategories.layoutManager = GridLayoutManager(requireContext(), 3)
        adapter = CategoryAdapter(emptyList()) { category ->

            val bundle = Bundle().apply {
                putInt("userId", userId)
                putString("categoryName", category.name)
            }

            if (category.name == "Other") {
                findNavController().navigate(R.id.action_categoryFragment_to_subcategoryFragment, bundle)
            } else {
                findNavController().navigate(R.id.action_categoryFragment_to_transactionFragment, bundle)
            }
        }


        binding.recyclerViewCategories.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
