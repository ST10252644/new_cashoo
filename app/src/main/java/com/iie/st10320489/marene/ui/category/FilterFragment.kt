package com.iie.st10320489.marene.ui.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            userId = it.getInt("userId")
            categoryName = it.getString("categoryName")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFilterBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val db = DatabaseInstance.getDatabase(requireContext())

        adapter = TransactionAdapter(emptyList()) { transaction ->
            // Handle item click if needed
        }

        binding.recyclerViewFilterTransactions.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewFilterTransactions.adapter = adapter

        loadFilteredTransactions(db)  // Load transactions based on category and userId

        return root
    }

    private fun loadFilteredTransactions(db: AppDatabase) {
        lifecycleScope.launch {
            val transactions = if (categoryName.isNullOrEmpty()) {
                db.transactionDao().getTransactionsByUserId(userId)
            } else {
                db.transactionDao().getTransactionsByUserIdAndCategoryName(userId, categoryName!!)
            }
            adapter.updateTransactions(transactions)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
