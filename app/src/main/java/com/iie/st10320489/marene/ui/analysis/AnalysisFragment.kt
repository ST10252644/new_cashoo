package com.iie.st10320489.marene.ui.analysis

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.google.android.material.tabs.TabLayout
import com.iie.st10320489.marene.R
import com.iie.st10320489.marene.data.database.AppDatabase
import com.iie.st10320489.marene.data.database.DatabaseInstance
import com.iie.st10320489.marene.graphs.MonthlySummaryFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDate
import java.time.format.DateTimeFormatter

//Fragment Page
class AnalysisFragment : Fragment() {

    private val TAG = "AnalysisFragment"
    private lateinit var pieChart: PieChart
    private lateinit var barChart: BarChart
    private lateinit var tabLayout: TabLayout
    private lateinit var db: AppDatabase
    private val viewModel: AnalysisViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_analysis, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize views
        pieChart = view.findViewById(R.id.pieChart)
        barChart = view.findViewById(R.id.barChart)
        tabLayout = view.findViewById(R.id.tabLayout)

        // Get database instance
        db = DatabaseInstance.getDatabase(requireContext())
        Log.d(TAG, "Database initialized")

        // Load charts and fragments
        setupPieChart()
        setupTabs()
        addMonthlySummaryFragment()
    }

    // Sets up the pie chart using category-wise expenses
    private fun setupPieChart() {
        val sharedPreferences = requireContext().getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)
        val email = sharedPreferences.getString("currentUserEmail", null)

        if (email == null) {
            Toast.makeText(context, "No user logged in", Toast.LENGTH_SHORT).show()
            Log.e(TAG, "No email found in SharedPreferences")
            return
        }

        lifecycleScope.launch {
            val userId = withContext(Dispatchers.IO) {
                db.userDao().getUserIdByEmail(email)
            }

            if (userId == null) {
                Log.e(TAG, "User ID not found for email: $email")
                return@launch
            }

            // Retrieve transactions with their category
            val transactionsWithCategory = withContext(Dispatchers.IO) {
                db.transactionDao().getTransactionsWithCategory(userId)
            }

            if (transactionsWithCategory.isEmpty()) {
                Toast.makeText(context, "No expense data", Toast.LENGTH_SHORT).show()
                return@launch
            }

            val totalExpenses = transactionsWithCategory.sumOf { it.transaction.amount }

            // Group by category and sum
            val categorySums = transactionsWithCategory.groupBy { it.category }
                .mapValues { entry -> entry.value.sumOf { it.transaction.amount } }

            // Convert to PieEntries with percentage
            val entries = categorySums.map { (category, amount) ->
                val percentage = (amount / totalExpenses * 100).toFloat()
                PieEntry(percentage, category.name)
            }

            // Assign category colors
            val colors = categorySums.keys.map {
                try {
                    ContextCompat.getColor(requireContext(), it.colour)
                } catch (e: Resources.NotFoundException) {
                    Color.GRAY
                }
            }

            val dataSet = PieDataSet(entries, "").apply {
                this.colors = colors
                valueTextColor = Color.TRANSPARENT // Hide label values
            }

            // Set up pie chart with formatted center text
            val data = PieData(dataSet)
            pieChart.data = data
            pieChart.description.isEnabled = false
            pieChart.legend.isEnabled = false
            pieChart.setDrawEntryLabels(false)
            pieChart.setHoleColor(Color.WHITE)
            pieChart.setDrawCenterText(true)
            pieChart.centerText = "Total Expense\nR %.2f".format(totalExpenses)
            pieChart.setCenterTextSize(16f)
            pieChart.setCenterTextTypeface(Typeface.DEFAULT_BOLD)
            pieChart.animateY(1000)
            pieChart.invalidate()

            // Add summary rows under the chart
            val detailsLayout = view?.findViewById<LinearLayout>(R.id.detailsLayout)
            if (detailsLayout != null && detailsLayout.childCount > 1) {
                detailsLayout.removeViews(1, detailsLayout.childCount - 1)
            }

            categorySums.forEach { (category, amount) ->
                val percentage = (amount / totalExpenses * 100)
                val color = try {
                    ContextCompat.getColor(requireContext(), category.colour)
                } catch (e: Resources.NotFoundException) {
                    Color.GRAY
                }

                // Create a horizontal layout row for each category
                val row = LinearLayout(requireContext()).apply {
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    ).apply {
                        setMargins(0, 0, 0, 8)
                    }
                    orientation = LinearLayout.HORIZONTAL
                }

                // Colored dot and category name
                val dotAndCategory = TextView(requireContext()).apply {
                    layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
                    text = "● ${category.name}"
                    setTextColor(color)
                    textSize = 14f
                }

                // Amount
                val amountView = TextView(requireContext()).apply {
                    layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
                    text = "R %.2f".format(amount)
                    setTextColor(Color.parseColor("#1C1C1E"))
                    textSize = 14f
                }

                // Percentage
                val percentView = TextView(requireContext()).apply {
                    layoutParams = LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
                    text = "%.1f%%".format(percentage)
                    setTextColor(Color.parseColor("#1C1C1E"))
                    setTypeface(null, Typeface.BOLD)
                    textSize = 14f
                    gravity = Gravity.END
                }

                row.addView(dotAndCategory)
                row.addView(amountView)
                row.addView(percentView)

                detailsLayout?.addView(row)
            }
        }
    }

    // Adds tabs and logic for Weekly, Monthly, and Yearly view modes
    private fun setupTabs() {
        tabLayout.addTab(tabLayout.newTab().setText("Weekly"))
        tabLayout.addTab(tabLayout.newTab().setText("Monthly"), true)
        tabLayout.addTab(tabLayout.newTab().setText("Yearly"))

        setChartData("Monthly") // default

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                setChartData(tab.text.toString())
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    // Embeds the MonthlySummaryFragment into the UI
    private fun addMonthlySummaryFragment() {
        val fragment = MonthlySummaryFragment()
        childFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    // Sets up and updates the bar chart data based on selected time filter
    private fun setChartData(mode: String) {
        val sharedPreferences = requireContext().getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)
        val email = sharedPreferences.getString("currentUserEmail", null) ?: return

        lifecycleScope.launch {
            val userId = withContext(Dispatchers.IO) {
                db.userDao().getUserIdByEmail(email)
            } ?: return@launch

            val transactions = withContext(Dispatchers.IO) {
                db.transactionDao().getTransactionsByUser(userId)
            }

            // Sum income and expenses
            val incomeTotal = transactions.filter { !it.transaction.expense }.sumOf { it.transaction.amount }
            val expenseTotal = transactions.filter { it.transaction.expense }.sumOf { it.transaction.amount }

            view?.findViewById<TextView>(R.id.incomeAmountTextView)?.text = "R %.2f".format(incomeTotal)
            view?.findViewById<TextView>(R.id.expenseAmountTextView)?.text = "R %.2f".format(expenseTotal)

            val incomeEntries = ArrayList<BarEntry>()
            val expenseEntries = ArrayList<BarEntry>()
            val labels = ArrayList<String>()
            val now = LocalDate.now()
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")

            // Handle each mode (weekly, monthly, yearly) separately
            when (mode) {
                "Weekly" -> {
                    val weekStart = now.with(java.time.DayOfWeek.MONDAY)
                    for (i in 0..6) {
                        val day = weekStart.plusDays(i.toLong())
                        val dailyTrans = transactions.filter {
                            LocalDate.parse(it.transaction.dateTime, formatter) == day
                        }
                        val income = dailyTrans.filter { !it.transaction.expense }.sumOf { it.transaction.amount }.toFloat()
                        val expense = dailyTrans.filter { it.transaction.expense }.sumOf { it.transaction.amount }.toFloat()
                        incomeEntries.add(BarEntry(i.toFloat(), income))
                        expenseEntries.add(BarEntry(i.toFloat(), expense))
                        labels.add(day.dayOfWeek.name.take(3))
                    }
                }

                "Monthly" -> {
                    val monthStart = now.withDayOfMonth(1)
                    val weeks = listOf(0, 7, 14, 21)
                    for ((i, offset) in weeks.withIndex()) {
                        val weekStart = monthStart.plusDays(offset.toLong())
                        val weekEnd = weekStart.plusDays(6)
                        val weeklyTrans = transactions.filter {
                            val txDate = LocalDate.parse(it.transaction.dateTime, formatter)
                            txDate in weekStart..weekEnd
                        }
                        val income = weeklyTrans.filter { !it.transaction.expense }.sumOf { it.transaction.amount }.toFloat()
                        val expense = weeklyTrans.filter { it.transaction.expense }.sumOf { it.transaction.amount }.toFloat()
                        incomeEntries.add(BarEntry(i.toFloat(), income))
                        expenseEntries.add(BarEntry(i.toFloat(), expense))
                        labels.add("W${i + 1}")
                    }
                }

                "Yearly" -> {
                    for (i in 1..12) {
                        val monthlyTrans = transactions.filter {
                            val txDate = LocalDate.parse(it.transaction.dateTime, formatter)
                            txDate.monthValue == i && txDate.year == now.year
                        }
                        val income = monthlyTrans.filter { !it.transaction.expense }.sumOf { it.transaction.amount }.toFloat()
                        val expense = monthlyTrans.filter { it.transaction.expense }.sumOf { it.transaction.amount }.toFloat()
                        incomeEntries.add(BarEntry((i - 1).toFloat(), income))
                        expenseEntries.add(BarEntry((i - 1).toFloat(), expense))
                        labels.add(java.time.Month.of(i).name.take(3))
                    }
                }
            }

            // Prepare bar chart
            val incomeDataSet = BarDataSet(incomeEntries, "Income").apply {
                color = ContextCompat.getColor(requireContext(), R.color.income)
            }

            val expenseDataSet = BarDataSet(expenseEntries, "Expenses").apply {
                color = ContextCompat.getColor(requireContext(), R.color.outcome)
            }

            val barData = BarData(incomeDataSet, expenseDataSet).apply {
                barWidth = 0.4f
                groupBars(0f, 0.2f, 0f) // group bars with spacing
            }

            // Configure bar chart view
            barChart.apply {
                data = barData
                xAxis.apply {
                    valueFormatter = IndexAxisValueFormatter(labels)
                    granularity = 1f
                    setCenterAxisLabels(true)
                    axisMinimum = 0f
                    axisMaximum = labels.size.toFloat()
                    position = XAxis.XAxisPosition.BOTTOM
                }
                axisLeft.axisMinimum = 0f
                axisRight.isEnabled = false
                description.isEnabled = false
                legend.isEnabled = true
                setVisibleXRangeMaximum(labels.size.toFloat())
                invalidate()
            }
        }
    }
}