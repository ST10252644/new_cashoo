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
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Greeting
        val userName = activity?.intent?.getStringExtra("USER_NAME")
        binding.greetingTextView.text = "Hi, $userName"

        // Load userId from SharedPreferences
        val sharedPref = requireContext().getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)
        val currentUserEmail = sharedPref.getString("currentUserEmail", null)

        if (currentUserEmail != null) {
            lifecycleScope.launch {
                val database = DatabaseInstance.getDatabase(requireContext())
                userId = database.userDao().getUserIdByEmail(currentUserEmail) ?: 0

                if (userId != 0) {
                    // Ensure binding is not null before proceeding
                    setupButton()
                    loadUserSettings()
                    setupRecyclerView()
                    loadTop5Transactions()
                }
            }
        }

        return binding.root
    }

    private fun setupButton() {
        // Ensure that binding is properly initialized before calling this method
        if (_binding != null) {
            binding.seeMoreTransactions.setOnClickListener {
                val bundle = Bundle().apply {
                    putInt("userId", userId)
                }
                findNavController().navigate(
                    R.id.action_homeFragment_to_transactionFragment, bundle
                )
            }
        }
    }

    private suspend fun loadUserSettings() {
        val dao = DatabaseInstance.getDatabase(requireContext()).userSettingsDao()
        val settings = dao.getUserSettingsByUserId(userId)

        settings?.let {
            binding.root.findViewById<TextView>(R.id.minGoalTextView)?.text = "R ${"%,.0f".format(it.minGoal)}"
            binding.root.findViewById<TextView>(R.id.maxGoalTextView)?.text = "R ${"%,.0f".format(it.maxGoal)}"

            val chinchillaResId = resources.getIdentifier(it.chinchilla, "drawable", requireContext().packageName)
            binding.root.findViewById<ImageView>(R.id.profileImageView)?.setImageResource(chinchillaResId)
            binding.root.findViewById<ImageView>(R.id.greenCardImageView)?.setImageResource(chinchillaResId)
        }
    }

    private fun setupRecyclerView() {
        adapter = TransactionAdapter(emptyList()) { /* Handle click if needed */ }
        binding.recyclerRecentTransactions.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerRecentTransactions.adapter = adapter
    }

    private fun loadTop5Transactions() {
        val db = DatabaseInstance.getDatabase(requireContext())
        transactionDao = db.transactionDao()

        lifecycleScope.launch {
            val topTransactions = transactionDao.getTop5RecentTransactionsByUserId(userId)
            adapter = TransactionAdapter(topTransactions) {
                // Optional click handler
            }
            binding.recyclerRecentTransactions.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

