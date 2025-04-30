package com.iie.st10320489.marene.ui.add

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.iie.st10320489.marene.R
import com.iie.st10320489.marene.data.database.AppDatabase
import com.iie.st10320489.marene.data.database.DatabaseInstance
import com.iie.st10320489.marene.databinding.FragmentAddBinding
import com.iie.st10320489.marene.data.entities.Transaction
import kotlinx.coroutines.launch
import com.bumptech.glide.Glide
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.DatePicker
import java.util.*
import java.text.SimpleDateFormat

class AddFragment : Fragment() {

    private var userId: Int = 0
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var database: AppDatabase

    private var selectedCategoryId: Int = 0
    private var selectedSubCategoryId: Int = 0

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    private val REQUEST_CODE_PICK_IMAGE = 100
    private var selectedImagePath: String? = null // <-- Store the file path

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        database = DatabaseInstance.getDatabase(requireContext())
        sharedPreferences = requireActivity().getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)

        val spinner = binding.categorySpinner

        val currentUserEmail = sharedPreferences.getString("currentUserEmail", null)

        if (currentUserEmail != null) {
            lifecycleScope.launch {
                try {
                    val userDao = database.userDao()
                    val categoryDao = database.categoryDao()
                    val subCategoryDao = database.subCategoryDao()

                    val fetchedUserId = userDao.getUserIdByEmail(currentUserEmail)

                    if (fetchedUserId != null) {
                        userId = fetchedUserId

                        val categories = categoryDao.getCategoriesForUser(fetchedUserId)
                        val subCategories = subCategoryDao.getSubCategoriesForUser(fetchedUserId)

                        val categoryNames = categories.map { it.name }
                        val subCategoryNames = subCategories.map { it.name }
                        val combinedNames = categoryNames + listOf("Other") + subCategoryNames
                        val combinedItems = categoryNames.map { it to "category" } +
                                listOf("Other" to "category") +
                                subCategoryNames.map { it to "subcategory" }

                        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, combinedNames)
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        spinner.adapter = adapter

                        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                                val selectedItem = combinedItems[position]

                                if (selectedItem.second == "category") {
                                    val category = categories.firstOrNull { it.name == selectedItem.first }
                                    selectedCategoryId = category?.categoryId ?: 0
                                    selectedSubCategoryId = 0
                                } else if (selectedItem.second == "subcategory") {
                                    val subCategory = subCategories.firstOrNull { it.name == selectedItem.first }
                                    selectedSubCategoryId = subCategory?.subCategoryId ?: 0
                                    val otherCategory = categories.firstOrNull { it.name == "Other" }
                                    selectedCategoryId = otherCategory?.categoryId ?: 0
                                }
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                selectedCategoryId = 0
                                selectedSubCategoryId = 0
                            }
                        }
                    } else {
                        showError("User not found!")
                    }
                } catch (e: Exception) {
                    showError("Error fetching user data: ${e.message}")
                }
            }
        } else {
            showError("User email not found in preferences")
        }

        // Date picker button click listener
        binding.btnPickDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

            // Show the DatePickerDialog
            val datePickerDialog = DatePickerDialog(
                requireContext(),
                { _, selectedYear, selectedMonth, selectedDay ->
                    // Format the selected date as "dd/MM/yyyy"
                    val selectedDate = formatDate(selectedDay, selectedMonth + 1, selectedYear)
                    binding.transDate.setText(selectedDate) // Set the selected date to transDate EditText
                },
                year, month, dayOfMonth
            )
            datePickerDialog.show()
        }

        // Time Picker button click listener
        binding.btnPickTime.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            // Show the TimePickerDialog
            val timePickerDialog = TimePickerDialog(
                requireContext(),
                { _, selectedHour, selectedMinute ->
                    val selectedTime = "$selectedHour:${selectedMinute.toString().padStart(2, '0')}"
                    // Append the selected time to the selected date
                    val currentDateTime = binding.transDate.text.toString()
                    binding.transDate.setText("$currentDateTime $selectedTime") // Set both date and time
                },
                hour, minute, true
            )
            timePickerDialog.show()
        }

        binding.btnChooseFile.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_PICK)
                intent.type = "image/*"
                startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE)
            } catch (e: Exception) {
                showError("Error opening file picker: ${e.message}")
            }
        }

        binding.btnAddEntry.setOnClickListener {
            val name = binding.transName.text.toString()
            val amount = binding.transAmount.text.toString().toDoubleOrNull() ?: 0.0
            val method = binding.transMethod.text.toString()
            val location = binding.transLocation.text.toString()
            val date = binding.transDate.text.toString() // Ensure this is in dd/MM/yyyy format
            val description = binding.transDescription.text.toString()
            val transactionType = if (binding.rbExpense.isChecked) "Expense" else "Income"

            if (name.isEmpty() || amount <= 0 || method.isEmpty() || location.isEmpty() || date.isEmpty()) {
                showError("Please fill all the required fields!")
                return@setOnClickListener
            }

            if (userId != 0 && selectedCategoryId != 0) {
                val transaction = Transaction(
                    userId = userId,
                    name = name,
                    amount = amount,
                    transactionMethod = method,
                    location = location,
                    dateTime = date, // This will store the date in dd/MM/yyyy format
                    description = description,
                    photo = selectedImagePath ?: "", // <-- SAVE image path
                    categoryId = selectedCategoryId,
                    subCategoryId = if (selectedSubCategoryId != 0) selectedSubCategoryId else null,
                    expense = binding.rbExpense.isChecked,
                    recurring = false
                )

                lifecycleScope.launch {
                    try {
                        database.transactionDao().insert(transaction)
                        Toast.makeText(requireContext(), "Transaction saved successfully", Toast.LENGTH_SHORT).show()
                        resetFields()
                    } catch (e: Exception) {
                        showError("Error saving transaction: ${e.message}")
                    }
                }
            } else {
                showError("Please select a category first!")
            }
        }
    }

    // Error handling function
    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    // Updated file picker result handling
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_PICK_IMAGE && resultCode == AppCompatActivity.RESULT_OK && data != null) {
            val selectedImageUri = data.data

            try {
                selectedImagePath = getFilePathFromUri(selectedImageUri) // <-- Save file path
                Glide.with(requireContext())
                    .load(selectedImageUri)
                    .into(binding.imageView)

                val fileName = getFileNameFromUri(selectedImageUri)
                binding.tvFileName.text = fileName
            } catch (e: Exception) {
                showError("Error selecting image: ${e.message}")
            }
        }
    }

    private fun getFileNameFromUri(uri: Uri?): String {
        var fileName = ""
        try {
            uri?.let {
                val cursor = requireContext().contentResolver.query(uri, null, null, null, null)
                cursor?.apply {
                    moveToFirst()
                    val columnIndex = getColumnIndex(OpenableColumns.DISPLAY_NAME)
                    fileName = getString(columnIndex)
                    close()
                }
            }
        } catch (e: Exception) {
            showError("Error retrieving file name: ${e.message}")
        }
        return fileName
    }

    private fun getFilePathFromUri(uri: Uri?): String? {
        var filePath: String? = null
        try {
            uri?.let {
                val projection = arrayOf(MediaStore.Images.Media.DATA)
                val cursor: Cursor? = requireContext().contentResolver.query(uri, projection, null, null, null)
                cursor?.use {
                    if (it.moveToFirst()) {
                        val columnIndex = it.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
                        filePath = it.getString(columnIndex)
                    }
                }
            }
        } catch (e: Exception) {
            showError("Error retrieving file path: ${e.message}")
        }
        return filePath
    }

    private fun formatDate(day: Int, month: Int, year: Int): String {
        val formattedDay = day.toString().padStart(2, '0')
        val formattedMonth = month.toString().padStart(2, '0')
        return "$formattedDay/$formattedMonth/$year"
    }

    private fun resetFields() {
        // Reset all the fields to empty
        binding.transName.text.clear()
        binding.transAmount.text.clear()
        binding.transMethod.text.clear()
        binding.transLocation.text.clear()
        binding.transDate.text.clear()
        binding.transDescription.text.clear()
        binding.rbExpense.isChecked = true  // Reset the radio button to Expense
        binding.imageView.setImageDrawable(null)  // Clear the selected image
        binding.tvFileName.text = ""  // Clear the file name text
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
