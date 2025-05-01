package com.iie.st10320489.marene.ui.filter

import android.content.Context
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
import com.iie.st10320489.marene.databinding.FragmentFilterBinding
import com.iie.st10320489.marene.data.database.DatabaseInstance
import com.iie.st10320489.marene.ui.transaction.TransactionAdapter
import kotlinx.coroutines.launch

class FilterFragment : Fragment() {

    private var _binding: FragmentFilterBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: TransactionAdapter
    private var userId: Int = 0
    private var categoryName: String? = null
    private var subCategoryName: String? = null

    // Get arguments passed via navigation (category or subcategory name)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            categoryName = it.getString("categoryName")
            subCategoryName = it.getString("subCategoryName")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFilterBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val db = DatabaseInstance.getDatabase(requireContext())

        // Initialize adapter with empty list and click listener to navigate to details screen
        adapter = TransactionAdapter(emptyList()) { transactionWithCategory ->
            val bundle = Bundle().apply {
                putInt("transactionId", transactionWithCategory.transaction.transactionId)
            }
            findNavController().navigate(
                R.id.action_transactionFragment_to_transactionDetailsFragment,
                bundle
            )
        }

        // Set RecyclerView layout manager and adapter
        binding.recyclerViewFilterTransactions.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewFilterTransactions.adapter = adapter

        // Get current user email from SharedPreferences and load their transactions
        lifecycleScope.launch {
            val sharedPreferences = requireActivity().getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)
            val currentUserEmail = sharedPreferences.getString("currentUserEmail", null)

            if (currentUserEmail != null) {
                val resolvedUserId = db.userDao().getUserIdByEmail(currentUserEmail)
                if (resolvedUserId != null) {
                    userId = resolvedUserId
                    loadFilteredTransactions(db)
                } else {
                    println("No user found with email: $currentUserEmail")
                }
            } else {
                println("currentUserEmail not found in SharedPreferences")
            }
        }

        return root
    }

    // Load filtered transactions based on subCategory, category, or fallback to all
    private fun loadFilteredTransactions(db: AppDatabase) {
        lifecycleScope.launch {
            val transactions = when {
                !subCategoryName.isNullOrEmpty() -> {
                    println(" Fetching transactions for subCategoryName = $subCategoryName and userId = $userId")
                    val result = db.transactionDao().getTransactionsByUserIdAndSubCategoryName(userId, subCategoryName!!)
                    println(" DAO returned ${result.size} transactions for subcategory '$subCategoryName'")
                    result.forEach {
                        println(" Transaction ID: ${it.transaction.transactionId}, Name: ${it.transaction.name}, subCategoryId: ${it.transaction.subCategoryId}")
                    }
                    result
                }
                !categoryName.isNullOrEmpty() -> {
                    println(" Fetching transactions for categoryName = $categoryName and userId = $userId")
                    val result = db.transactionDao().getTransactionsByUserIdAndCategoryName(userId, categoryName!!)
                    println(" DAO returned ${result.size} transactions for category '$categoryName'")
                    result
                }
                else -> {
                    println(" Fetching all transactions for userId = $userId")
                    val result = db.transactionDao().getTransactionsByUserId(userId)
                    println(" DAO returned ${result.size} total transactions")
                    result
                }
            }

            // Update the RecyclerView with new list
            adapter.updateTransactions(transactions)
        }
    }

    // Clean up view binding to prevent memory leaks
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}