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

class FilterFragment : Fragment() {//((Cal, 2023), (College, 2025)

    private var _binding: FragmentFilterBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: TransactionAdapter
    private var userId: Int = 0
    private var categoryName: String? = null
    private var subCategoryName: String? = null

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

        adapter = TransactionAdapter(emptyList()) { transactionWithCategory ->
            val bundle = Bundle().apply {
                putInt("transactionId", transactionWithCategory.transaction.transactionId)  // Correct reference
            }
            findNavController().navigate(R.id.action_transactionFragment_to_transactionDetailsFragment, bundle)
        }



        binding.recyclerViewFilterTransactions.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewFilterTransactions.adapter = adapter

        // Resolve userId using SharedPreferences and load transactions
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

    private fun loadFilteredTransactions(db: AppDatabase) {
        lifecycleScope.launch {
            val transactions = when {
                !subCategoryName.isNullOrEmpty() -> {
                    println("🔍 Fetching transactions for subCategoryName = $subCategoryName and userId = $userId")
                    val result = db.transactionDao().getTransactionsByUserIdAndSubCategoryName(userId, subCategoryName!!)
                    println("✅ DAO returned ${result.size} transactions for subcategory '$subCategoryName'")
                    result.forEach {
                        println("🧾 Transaction ID: ${it.transaction.transactionId}, Name: ${it.transaction.name}, subCategoryId: ${it.transaction.subCategoryId}")
                    }
                    result
                }
                !categoryName.isNullOrEmpty() -> {
                    println("🔍 Fetching transactions for categoryName = $categoryName and userId = $userId")
                    val result = db.transactionDao().getTransactionsByUserIdAndCategoryName(userId, categoryName!!)
                    println("✅ DAO returned ${result.size} transactions for category '$categoryName'")
                    result
                }
                else -> {
                    println("🔍 Fetching all transactions for userId = $userId")
                    val result = db.transactionDao().getTransactionsByUserId(userId)
                    println("✅ DAO returned ${result.size} total transactions")
                    result
                }
            }
            adapter.updateTransactions(transactions)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }//((Cal, 2023), (College, 2025)
}


//Bibliography
//AndroidDevelopers, 2024. Save data in a local database using Room. [Online] Available at: hRps://developer.android.com/training/data-storage/room [Accessed 27 April 2025].
//AndroidDevelopers, 2024. Write asynchronous DAO queries. [Online]
//Available at: hRps://developer.android.com/training/data-storage/room/async- queries?authuser=2
//[Accessed 26 April 2025].
//Raikwar, A., 2024. Ge=ng Started with Room Database in Android. [Online]
//Available at: hRps://amitraikwar.medium.com/ge[ng-started-with-room-database-in- android-fa1ca23ce21e
//[Accessed 27 April 2025].
//Raikwar, A., 2023. Ge=ng Started with Room Database in Android. [Online]
//Available at: hRps://developer.android.com/develop#core-areas
//[Accessed 28 April 2025].
//Cal, C. W., 2023. Room Database Android Studio Kotlin Example Tutorial. [Online] Available at: hRps://youtu.be/-LNg-K7SncM?si=y8cbMdvhhp48Pp9-
//[Accessed 27 April 2025].
//College, I. V., 2025. PROG7313 Module-Manual / Module-Outline. Pretoria: Varsity College Pretoria.
//Viegen, F. v., 2022. A PracKcal introducKon to Android Room-3 : EnKty, Dao and Database objects.. [Online]
//Available at: hRps://youtu.be/RstQg7f4Edk?si=8RoAGp-OKPpMNVdY
//[Accessed 28 April 2025].

//androidbyexample, 2024. EnKKes ,Dao and Database -Android By Example. [Online] Available at: hRps://androidbyexample.com/modules/movie-db/STEP-050_Repo.html [Accessed 25 April 2025].
//AndroidDevelopers, 2023. Layouts in Views. [Online]
//Available at: hRps://developer.android.com/developer/ui/views/layout/declaring-layout [Accessed 23 April 2025].
//Kay, R. M., 2022. IntroducKon To Development WithAndroid Studio: XML The Five Minute Language. [Online]
//Available at: hRps://youtu.be/94tm21PIBMs?si=BpJQ9meXr1_ynL2m
//[Accessed 15 April 2025].
//Team, G. D. T., 2024. Add repository and Manual DI. [Online]
//Available at: hRps://developer.android.com/codelabs/basic-android-kotlin-compose-add- repository#0
//[Accessed 22 April 2025].
//Coder, O., 2022. Implament Pie Chart in Android Studio Using Kotlin. [Online] Available at: hRps://youtu.be/TUJHcU0FOkA?si=jk90LRSO1_eyMyIG
//[Accessed 24 April 2025].
//Coder, E. O., 2024. hot to create bar chart | MP Android Chart | Android Studio 2024. [Online]
//Available at: hRps://youtu.be/WdsmQ3Zyn84?si=jz2AtkIRsNEUwNbX
//[Accessed 23 April 2025].

