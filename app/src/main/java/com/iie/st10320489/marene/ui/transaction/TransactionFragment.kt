package com.iie.st10320489.marene.ui.transaction

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.iie.st10320489.marene.databinding.FragmentTransactionBinding
import com.iie.st10320489.marene.data.database.AppDatabase
import com.iie.st10320489.marene.data.database.DatabaseInstance
import kotlinx.coroutines.launch

class TransactionFragment : Fragment() {

    private var _binding: FragmentTransactionBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: TransactionAdapter
    private lateinit var db: AppDatabase

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
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentTransactionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        db = DatabaseInstance.getDatabase(requireContext())

        adapter = TransactionAdapter(emptyList()) { transaction ->
            // Handle item click if needed
        }

        binding.recyclerViewTransactions.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewTransactions.adapter = adapter

        loadTransactions()
    }

    private fun loadTransactions() {
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
