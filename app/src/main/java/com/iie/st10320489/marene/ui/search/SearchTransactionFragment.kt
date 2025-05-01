package com.iie.st10320489.marene.ui.search

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.iie.st10320489.marene.data.database.AppDatabase
import com.iie.st10320489.marene.databinding.FragmentHomeSearchBinding
import com.iie.st10320489.marene.data.database.DatabaseInstance
import com.iie.st10320489.marene.data.entities.TransactionWithCategory
import com.iie.st10320489.marene.ui.transaction.TransactionAdapter
import android.app.DatePickerDialog
import android.util.Log
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class SearchTransactionFragment : Fragment() {

    private var _binding: FragmentHomeSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var transactionAdapter: TransactionAdapter
    private var allTransactions: List<TransactionWithCategory> = listOf()
    private var filteredTransactions: List<TransactionWithCategory> = listOf()
    private val calendar = Calendar.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.transactionRecyclerView.visibility = View.GONE
        binding.btnSearch.visibility = View.GONE

        transactionAdapter = TransactionAdapter(filteredTransactions) { transaction ->
            Toast.makeText(
                requireContext(),
                "Transaction clicked: ${transaction.transaction.name}",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.transactionRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.transactionRecyclerView.adapter = transactionAdapter

        val db = DatabaseInstance.getDatabase(requireContext())
        loadTransactions(db)

        val filterOptions = listOf("Name", "Date/Time", "Amount")
        val spinnerAdapter = ArrayAdapter(requireContext(), R.layout.simple_spinner_item, filterOptions)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerFilter.adapter = spinnerAdapter

        binding.spinnerFilter.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                binding.transactionRecyclerView.visibility = View.GONE
                binding.btnSearch.visibility = View.VISIBLE

                resetFilterInputs()
                binding.filterInputContainer.visibility = View.VISIBLE

                when (position) {
                    0 -> binding.nameInputGroup.visibility = View.VISIBLE
                    1 -> binding.dateInputGroup.visibility = View.VISIBLE
                    2 -> binding.amountInputGroup.visibility = View.VISIBLE
                }

                filteredTransactions = allTransactions
                transactionAdapter.updateTransactions(filteredTransactions)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        binding.btnSearch.setOnClickListener {
            val filter = binding.spinnerFilter.selectedItem.toString()
            val query = when (filter) {
                "Name" -> binding.nameInput.text.toString().trim()
                "Date/Time" -> binding.transDate.text.toString().trim()
                "Amount" -> binding.amountInput.text.toString().trim()
                else -> ""
            }

            if (query.isEmpty()) {
                Toast.makeText(requireContext(), "Please enter a search term", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                performSearch(query, filter)

                if (filteredTransactions.isNotEmpty()) {
                    binding.transactionRecyclerView.visibility = View.VISIBLE
                } else {
                    Toast.makeText(requireContext(), "No results found", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Error performing search: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnPickDate.setOnClickListener {
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(requireContext(), { _, selectedYear, selectedMonth, selectedDay ->
                calendar.set(Calendar.YEAR, selectedYear)
                calendar.set(Calendar.MONTH, selectedMonth)
                calendar.set(Calendar.DAY_OF_MONTH, selectedDay)
                updateDateFieldOnly()
            }, year, month, day).show()
        }
    }

    private fun loadTransactions(db: AppDatabase) {
        lifecycleScope.launch {
            try {
                db.transactionDao().getAllTransactionsWithCategoryFlow().collect { transactions ->
                    allTransactions = transactions
                    filteredTransactions = transactions
                    transactionAdapter.updateTransactions(filteredTransactions)
                }
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "Error loading transactions: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun performSearch(query: String, filterType: String) {
        if (allTransactions.isEmpty()) {
            Toast.makeText(requireContext(), "No transactions available for search", Toast.LENGTH_SHORT).show()
            return
        }

        filteredTransactions = when (filterType) {
            "Name" -> allTransactions.filter {
                it.transaction.name.contains(query, ignoreCase = true)
            }

            "Date/Time" -> {
                val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
                val onlyDateFormat = SimpleDateFormat("yyyy/MM/dd", Locale.getDefault())

                allTransactions.filter { transaction ->
                    try {
                        val storedDate = inputFormat.parse(transaction.transaction.dateTime)
                        val formattedDate = onlyDateFormat.format(storedDate!!)
                        Log.d("SearchTransaction", "Checking transaction date: $formattedDate vs user input: $query")
                        formattedDate == query
                    } catch (e: Exception) {
                        Log.e("SearchTransaction", "Date parse failed for: ${transaction.transaction.dateTime}", e)
                        false
                    }
                }
            }


            "Amount" -> {
                val queryAmount = query.toDoubleOrNull()
                if (queryAmount != null) {
                    allTransactions.filter {
                        it.transaction.amount == queryAmount
                    }
                } else {
                    emptyList()
                }
            }

            else -> allTransactions
        }

        transactionAdapter.updateTransactions(filteredTransactions)

        // Optional: log filtered results
        Log.d("SearchTransaction", "Filtered Results: ${filteredTransactions.size}")
    }

    private fun updateDateFieldOnly() {
        val formatter = SimpleDateFormat("yyyy/MM/dd", Locale.getDefault())
        val formattedDate = formatter.format(calendar.time)
        binding.transDate.setText(formattedDate)
    }

    private fun resetFilterInputs() {
        binding.nameInput.setText("")
        binding.amountInput.setText("")
        binding.transDate.setText("")
        binding.nameInputGroup.visibility = View.GONE
        binding.dateInputGroup.visibility = View.GONE
        binding.amountInputGroup.visibility = View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
