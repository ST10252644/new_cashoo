/*
package com.iie.st10320489.marene.ui.transaction

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.iie.st10320489.marene.R
import com.iie.st10320489.marene.data.dao.UserDao
import com.iie.st10320489.marene.data.database.AppDatabase
import com.iie.st10320489.marene.data.database.DatabaseInstance
import com.iie.st10320489.marene.data.entities.TransactionWithCategory
import com.iie.st10320489.marene.data.repository.UserRepository
import com.iie.st10320489.marene.databinding.FragmentTransactionDetailBinding
import com.iie.st10320489.marene.viewmodel.TransactionViewModel
import kotlinx.coroutines.launch

class TransactionDetailFragment : Fragment() {
    private lateinit var binding: FragmentTransactionDetailBinding
    private val transactionViewModel: TransactionViewModel by viewModels()
    private val userRepository: UserRepository by lazy { UserRepository(UserDao()) } // Make sure to inject this properly in your app
    private var userId: Int = 0
    private var transactionId: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTransactionDetailBinding.inflate(inflater, container, false)

        // Retrieve the userId from SharedPreferences
        val sharedPreferences = requireActivity().getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)
        val currentUserEmail = sharedPreferences.getString("currentUserEmail", null)

        val db = DatabaseInstance.getDatabase(requireContext())
        val userDao = db.userDao()
        val userRepository = UserRepository(userDao)


        // Fetch userId from the database
        lifecycleScope.launch {
            userId = userRepository.getUserIdByEmail(currentUserEmail) ?: 0 // Handle null cases
            if (userId != 0) {
                transactionViewModel.loadTransactions(userId)
            }
        }

        // Assuming the transactionId is passed as an argument
        transactionId = arguments?.getInt("transactionId") ?: 0

        // Observe transaction data from ViewModel
        transactionViewModel.transactions.observe(viewLifecycleOwner, Observer { transactions ->
            val transactionWithCategory = transactions.find { it.transaction.transactionId == transactionId }
            transactionWithCategory?.let { bindTransactionDetails(it) }
        })

        return binding.root
    }

    private fun bindTransactionDetails(transactionWithCategory: TransactionWithCategory) {
        val transaction = transactionWithCategory.transaction
        val category = transactionWithCategory.category

        binding.txtName.text = transaction.name
        binding.txtAmount.text = String.format("-R%.2f", transaction.amount)  // Assuming expense
        binding.txtMethod.text = transaction.transactionMethod
        binding.txtLocation.text = transaction.location
        binding.txtTransactionDate.text = transaction.dateTime
        binding.txtDescription.text = transaction.description

        // Update the image for category icon
        binding.imgCategoryIcon.setImageResource(category.icon)
        binding.imgCategoryIconBackground.setBackgroundColor(
            ContextCompat.getColor(requireContext(), category.colour)
        )

        // If you have a receipt image attached, you can set it like so
        binding.imgReceipt.setImageResource(R.drawable.receipt)  // Example, replace with actual image URI if available
    }
}

*/
