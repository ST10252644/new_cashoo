package com.iie.st10320489.marene.ui.transaction

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iie.st10320489.marene.data.entities.TransactionWithCategory
import com.iie.st10320489.marene.data.repository.TransactionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

<<<<<<< HEAD
class TransactionViewModel(private val repository: TransactionRepository) : ViewModel() {
=======
class TransactionViewModel(private val repository: TransactionRepository) : ViewModel() { // (Android Developers, 2025)
>>>>>>> nathan

    private val _transactions = MutableStateFlow<List<TransactionWithCategory>>(emptyList())
    val transactions: StateFlow<List<TransactionWithCategory>> = _transactions

    fun loadTransactions(userId: Int) {
        viewModelScope.launch {
            _transactions.value = repository.getTransactionsByUserId(userId)
        }
<<<<<<< HEAD
    }
}

=======
    } // (Android Developers, 2025)
}

//Reference List:
// Android Developers. 2025. Accessing data using Room DAOs. [online]. Available at: https://developer.android.com/training/data-storage/room/accessing-data [Accessed on 15 April 2025]
//Android Developers. 2025. Fragment lifecycle. [online]. Available at: https://developer.android.com/guide/fragments/lifecycle [Accessed on 12 April 2025]
//Android Knowledge. 2024. ViewModel in Android Studio using Kotlin | Android Knowledge. [video online]. Available at: https://www.youtube.com/watch?v=v32hSKtlH9A [Accessed on 11 April 2025]
//Code With Cal. 2025. Room Database Android Studio Kotlin Example Tutorial. [video online]. Available at: https://www.youtube.com/watch?v=-LNg-K7SncM [Accessed on 12 April 2025]

>>>>>>> nathan
