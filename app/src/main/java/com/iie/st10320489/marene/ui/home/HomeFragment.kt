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

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: TransactionAdapter
    private lateinit var transactionDao: TransactionDao
    private var userId: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the Home layout using ViewBinding
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Logic runs after view is created
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get current user's email from SharedPreferences
        val sharedPref = requireContext().getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)
        val currentUserEmail = sharedPref.getString("currentUserEmail", null)

        // If email exists, fetch user data from DB
        if (currentUserEmail != null) {
            viewLifecycleOwner.lifecycleScope.launch {
                val database = DatabaseInstance.getDatabase(requireContext())
                userId = database.userDao().getUserIdByEmail(currentUserEmail) ?: 0

                // Load user name and display greeting
                val userName = database.userDao().getUserNameByEmail(currentUserEmail)
                binding.greetingTextView.text = "Hi, ${userName ?: "User"}"

                // Continue setup only if fragment is still attached
                if (userId != 0 && isAdded && _binding != null) {
                    setupButton()
                    loadUserSettings()
                    setupRecyclerView()
                    loadTop5Transactions()
                    addMonthlySummaryFragment() // Add embedded graph
                }
            }
        }
    }

    // Sets up navigation to full transaction list when "See More" is clicked
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

    // Loads user-specific settings like budget goals and avatar image
    private suspend fun loadUserSettings() {
        val dao = DatabaseInstance.getDatabase(requireContext()).userSettingsDao()
        val settings = dao.getUserSettingsByUserId(userId)

        // Update UI only if fragment is still attached
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

    // Configures the RecyclerView for recent transactions
    private fun setupRecyclerView() {
        adapter = TransactionAdapter(emptyList()) {
            // Optional click listener: currently does nothing
        }

        binding.recyclerRecentTransactions.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerRecentTransactions.adapter = adapter
    }

    // Loads and displays the top 5 recent transactions for the user
    private fun loadTop5Transactions() {
        val db = DatabaseInstance.getDatabase(requireContext())
        transactionDao = db.transactionDao()

        viewLifecycleOwner.lifecycleScope.launch {
            val topTransactions = transactionDao.getTop5RecentTransactionsByUserId(userId)
            if (isAdded && _binding != null) {
                adapter = TransactionAdapter(topTransactions) {
                    // Optional: handle click on a transaction (e.g., open detail view)
                }
                binding.recyclerRecentTransactions.adapter = adapter
            }
        }
    }

    // Dynamically adds the MonthlySummaryFragment into this fragment
    private fun addMonthlySummaryFragment() {
        val fragmentManager = childFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val fragment = MonthlySummaryFragment()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.addToBackStack(null) // Optional: supports back navigation
        fragmentTransaction.commit()
    }

    // Clear binding reference to prevent memory leaks
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}