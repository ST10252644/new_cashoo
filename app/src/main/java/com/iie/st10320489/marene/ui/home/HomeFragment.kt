package com.iie.st10320489.marene.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.iie.st10320489.marene.R
import com.iie.st10320489.marene.data.database.DatabaseInstance
import com.iie.st10320489.marene.databinding.FragmentHomeBinding
import com.iie.st10320489.marene.data.dao.TransactionDao
import com.iie.st10320489.marene.graphs.MonthlySummaryFragment
import com.iie.st10320489.marene.ui.transaction.TransactionAdapter
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {//((Cal, 2023), (College, 2025)

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: TransactionAdapter
    private lateinit var transactionDao: TransactionDao
    private var userId: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

/*        // Greeting
        val userName = activity?.intent?.getStringExtra("USER_NAME")
        binding.greetingTextView.text = "Hi, $userName"*/

        val sharedPref = requireContext().getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)
        val currentUserEmail = sharedPref.getString("currentUserEmail", null)

        if (currentUserEmail != null) {
            viewLifecycleOwner.lifecycleScope.launch {
                val database = DatabaseInstance.getDatabase(requireContext())
                userId = database.userDao().getUserIdByEmail(currentUserEmail) ?: 0

                val userName = database.userDao().getUserNameByEmail(currentUserEmail)
                binding.greetingTextView.text = "Hi, ${userName ?: "User"}"


                if (userId != 0 && isAdded && _binding != null) {
                    profileButton()
                    setupButton()
                    loadUserSettings()
                    setupRecyclerView()
                    loadTop5Transactions()

                    // Dynamically add the fragment here
                    addMonthlySummaryFragment()
                }
            }
        }
    }

    private fun setupButton() {
        binding.seeMoreTransactions.setOnClickListener {
            val bundle = Bundle().apply {
                putInt("userId", userId)
            }
            findNavController().navigate(
                R.id.action_homeFragment_to_transactionFragment, bundle
            )
        }
    }

    private fun profileButton() {
        binding.profileImageView.setOnClickListener {
            val bundle = Bundle().apply {
                putInt("userId", userId)
            }
            findNavController().navigate(
                R.id.action_homeFragment_to_settingsFragment, bundle
            )
        }
    }

    private suspend fun loadUserSettings() {
        val dao = DatabaseInstance.getDatabase(requireContext()).userSettingsDao()
        val settings = dao.getUserSettingsByUserId(userId)

        if (isAdded && _binding != null) {
            settings?.let {
                binding.minGoalTextView.text = "R ${"%,.0f".format(it.minGoal)}"
                binding.maxGoalTextView.text = "R ${"%,.0f".format(it.maxGoal)}"

                val chinchillaResId = resources.getIdentifier(it.chinchilla, "drawable", requireContext().packageName)
                binding.profileImageView.setImageResource(chinchillaResId)
                binding.greenCardImageView.setImageResource(chinchillaResId)
            }
        }
    }

    private fun setupRecyclerView() {
        adapter = TransactionAdapter(emptyList()) { transactionWithCategory ->
            // Optional: handle click on transaction item
            // For now, do nothing
        }

        binding.recyclerRecentTransactions.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerRecentTransactions.adapter = adapter
    }

    private fun loadTop5Transactions() {
        val db = DatabaseInstance.getDatabase(requireContext())
        transactionDao = db.transactionDao()

        viewLifecycleOwner.lifecycleScope.launch {
            val topTransactions = transactionDao.getTop5RecentTransactionsByUserId(userId)
            if (isAdded && _binding != null) {
                adapter = TransactionAdapter(topTransactions) { transactionWithCategory ->
                    // Optional: navigate or show details
                }
                binding.recyclerRecentTransactions.adapter = adapter
            }
        }
    }

    private fun addMonthlySummaryFragment() {
        // Check if the fragment already exists
        val fragmentManager = childFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        // Create an instance of MonthlySummaryFragment
        val fragment = MonthlySummaryFragment()

        // Add or replace the fragment in the container
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.addToBackStack(null)  // Optionally add the transaction to the back stack
        fragmentTransaction.commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}//((Cal, 2023), (College, 2025)


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

