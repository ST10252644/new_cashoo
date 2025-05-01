package com.iie.st10320489.marene.ui.transaction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.iie.st10320489.marene.R
import com.iie.st10320489.marene.databinding.FragmentTransactionDetailsBinding
import com.iie.st10320489.marene.data.database.DatabaseInstance
import kotlinx.coroutines.launch

<<<<<<< HEAD
class TransactionDetailsFragment : Fragment() {

    private var _binding: FragmentTransactionDetailsBinding? = null
    private val binding get() = _binding!!

    private var transactionId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
=======
class TransactionDetailsFragment : Fragment() { // (Android Developers, 2025)

    // View binding variable to access UI elements
    private var _binding: FragmentTransactionDetailsBinding? = null
    private val binding get() = _binding!!

    // ID of the transaction to display details for
    private var transactionId: Int = 0 // (Android Developers, 2025)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Retrieve transactionId from the fragment's arguments
>>>>>>> nathan
        transactionId = arguments?.getInt("transactionId") ?: 0
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
<<<<<<< HEAD
=======
        // Inflate the layout using view binding
>>>>>>> nathan
        _binding = FragmentTransactionDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
<<<<<<< HEAD
=======
        // Load transaction details once the view has been created
>>>>>>> nathan
        loadTransactionDetails()
    }

    private fun loadTransactionDetails() {
<<<<<<< HEAD
        val db = DatabaseInstance.getDatabase(requireContext())
        lifecycleScope.launch {
            val transactionWithCategory = db.transactionDao().getTransactionWithCategoryById(transactionId)

=======

        val db = DatabaseInstance.getDatabase(requireContext())
        // Launch a coroutine tied to the fragment's lifecycle
        lifecycleScope.launch {

            val transactionWithCategory = db.transactionDao().getTransactionWithCategoryById(transactionId)

            // If transaction exists, update UI elements with transaction details
>>>>>>> nathan
            transactionWithCategory?.let { item ->
                val t = item.transaction
                binding.txtName.text = t.name
                binding.txtAmount.text = if (t.expense) "-R${t.amount}" else "+R${t.amount}"
                binding.txtDateTime.text = t.dateTime
                binding.txtMethod.text = t.transactionMethod
                binding.txtLocation.text = "${t.location ?: "N/A"}"
                binding.txtDescription.text = "${t.description ?: "N/A"}"
                binding.txtCategory.text = "${item.category.name}"
                binding.txtSubCategory.text = "${item.category?.name ?: "N/A"}"
                binding.imgTransactionPhoto.setImageResource(R.drawable.receipt)
<<<<<<< HEAD


            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
=======
            }
        }
    } // (Android Developers, 2025)

    override fun onDestroyView() {
        super.onDestroyView()
        // Avoid memory leaks by clearing binding reference
        _binding = null
    } // (Android Developers, 2025)
}

//Reference List:
// Android Developers. 2025. Accessing data using Room DAOs. [online]. Available at: https://developer.android.com/training/data-storage/room/accessing-data [Accessed on 15 April 2025]
//Android Developers. 2025. Fragment lifecycle. [online]. Available at: https://developer.android.com/guide/fragments/lifecycle [Accessed on 12 April 2025]
//Android Knowledge. 2024. ViewModel in Android Studio using Kotlin | Android Knowledge. [video online]. Available at: https://www.youtube.com/watch?v=v32hSKtlH9A [Accessed on 11 April 2025]
//Code With Cal. 2025. Room Database Android Studio Kotlin Example Tutorial. [video online]. Available at: https://www.youtube.com/watch?v=-LNg-K7SncM [Accessed on 12 April 2025]
>>>>>>> nathan
