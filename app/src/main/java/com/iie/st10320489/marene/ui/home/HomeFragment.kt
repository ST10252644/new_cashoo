package com.iie.st10320489.marene.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import android.content.Intent
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.iie.st10320489.marene.R
import com.iie.st10320489.marene.data.database.DatabaseInstance
import com.iie.st10320489.marene.databinding.FragmentHomeBinding
import com.iie.st10320489.marene.data.dao.TransactionDao
import com.iie.st10320489.marene.ui.transaction.TransactionAdapter
import kotlinx.coroutines.launch
import com.iie.st10320489.marene.ui.settings.ActivitySettings

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
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

/*        // Greeting
        val userName = activity?.intent?.getStringExtra("USER_NAME")
        binding.greetingTextView.text = "Hi, $userName"*/
        binding.profileImageView.setOnClickListener {
            val intent = Intent(requireContext(), ActivitySettings::class.java)
            startActivity(intent)
        }

        val sharedPref = requireContext().getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)
        val currentUserEmail = sharedPref.getString("currentUserEmail", null)


        if (currentUserEmail != null) {
            viewLifecycleOwner.lifecycleScope.launch {
                val database = DatabaseInstance.getDatabase(requireContext())
                userId = database.userDao().getUserIdByEmail(currentUserEmail) ?: 0

                val userName = database.userDao().getUserNameByEmail(currentUserEmail)
                binding.greetingTextView.text = "Hi, ${userName ?: "User"}"


                if (userId != 0 && isAdded && _binding != null) {
                    setupButton()
                    loadUserSettings()
                    setupRecyclerView()
                    loadTop5Transactions()
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
