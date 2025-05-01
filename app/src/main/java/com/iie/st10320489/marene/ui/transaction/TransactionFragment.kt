package com.iie.st10320489.marene.ui.transaction

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
import com.iie.st10320489.marene.databinding.FragmentTransactionBinding
import com.iie.st10320489.marene.data.database.DatabaseInstance
import kotlinx.coroutines.launch

<<<<<<< HEAD
class TransactionFragment : Fragment() {
=======
class TransactionFragment : Fragment() { // (Android Developers, 2025)
>>>>>>> nathan

    private var _binding: FragmentTransactionBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: TransactionAdapter
    private var userId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userId = it.getInt("userId") // Fetch the userId passed as an argument
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentTransactionBinding.inflate(inflater, container, false)
<<<<<<< HEAD
        return binding.root
=======
        return binding.root // (Android Developers, 2025)
>>>>>>> nathan
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = DatabaseInstance.getDatabase(requireContext())

        // Set up the adapter for the recycler view
        adapter = TransactionAdapter(emptyList()) { transactionWithCategory ->
            val bundle = Bundle().apply {
                putInt("transactionId", transactionWithCategory.transaction.transactionId)  // Correct reference
            }
            findNavController().navigate(R.id.action_transactionFragment_to_transactionDetailsFragment, bundle)
<<<<<<< HEAD
        }
=======
        } // (Android Developers, 2025)
>>>>>>> nathan



        binding.recyclerViewTransactions.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewTransactions.adapter = adapter

        loadTransactions(db)  // Load all transactions for the user
    }

    private fun loadTransactions(db: AppDatabase) {
        lifecycleScope.launch {
            // Get all transactions by userId without filtering by category
            val transactions = db.transactionDao().getTransactionsByUserId(userId)
            adapter.updateTransactions(transactions)  // Update the adapter with the transactions
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
<<<<<<< HEAD
    }
=======
    } // (Android Developers, 2025)

    //Reference List:
// Android Developers. 2025. Accessing data using Room DAOs. [online]. Available at: https://developer.android.com/training/data-storage/room/accessing-data [Accessed on 15 April 2025]
//Android Developers. 2025. Fragment lifecycle. [online]. Available at: https://developer.android.com/guide/fragments/lifecycle [Accessed on 12 April 2025]
//Android Knowledge. 2024. ViewModel in Android Studio using Kotlin | Android Knowledge. [video online]. Available at: https://www.youtube.com/watch?v=v32hSKtlH9A [Accessed on 11 April 2025]
//Code With Cal. 2025. Room Database Android Studio Kotlin Example Tutorial. [video online]. Available at: https://www.youtube.com/watch?v=-LNg-K7SncM [Accessed on 12 April 2025]
>>>>>>> nathan
}
