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

class AddFragment : Fragment() {

    private var userId: Int = 0
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var database: AppDatabase

    private var selectedCategoryId: Int = 0
    private var selectedSubCategoryId: Int = 0

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    private val REQUEST_CODE_PICK_IMAGE = 100
    private var selectedImagePath: String? = null // <-- NEW: Store the file path

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
                                val category = categories.first { it.name == selectedItem.first }
                                selectedCategoryId = category.categoryId
                                selectedSubCategoryId = 0
                            } else if (selectedItem.second == "subcategory") {
                                val subCategory = subCategories.first { it.name == selectedItem.first }
                                selectedSubCategoryId = subCategory.subCategoryId
                                val otherCategory = categories.first { it.name == "Other" }
                                selectedCategoryId = otherCategory.categoryId
                            }
                        }

                        override fun onNothingSelected(parent: AdapterView<*>?) {
                            selectedCategoryId = 0
                            selectedSubCategoryId = 0
                        }
                    }
                }
            }
        }

        binding.btnChooseFile.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE)
        }

        binding.btnAddEntry.setOnClickListener {
            val name = binding.transName.text.toString()
            val amount = binding.transAmount.text.toString().toDoubleOrNull() ?: 0.0
            val method = binding.transMethod.text.toString()
            val location = binding.transLocation.text.toString()
            val date = binding.transDate.text.toString()
            val description = binding.transDescription.text.toString()
            val transactionType = if (binding.rbExpense.isChecked) "Expense" else "Income"

            println("Transaction Details: Name: $name, Amount: $amount, Method: $method, Location: $location, Date: $date, Description: $description, Type: $transactionType, Category ID: $selectedCategoryId, SubCategory ID: $selectedSubCategoryId")

            if (userId != 0 && selectedCategoryId != 0) {
                val transaction = Transaction(
                    userId = userId,
                    name = name,
                    amount = amount,
                    transactionMethod = method,
                    location = location,
                    dateTime = date,
                    description = description,
                    photo = selectedImagePath ?: "", // <-- SAVE image path
                    categoryId = selectedCategoryId,
                    subCategoryId = if (selectedSubCategoryId != 0) selectedSubCategoryId else null,
                    expense = binding.rbExpense.isChecked,
                    recurring = false
                )

                lifecycleScope.launch {
                    database.transactionDao().insert(transaction)

                    println("Transaction saved: ${transaction.toString()}")

                    Toast.makeText(requireContext(), "Transaction saved successfully", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Please select a category first!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Updated file picker result handling
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_PICK_IMAGE && resultCode == AppCompatActivity.RESULT_OK && data != null) {
            val selectedImageUri = data.data

            selectedImagePath = getFilePathFromUri(selectedImageUri) // <-- Save file path

            Glide.with(requireContext())
                .load(selectedImageUri)
                .into(binding.imageView)

            val fileName = getFileNameFromUri(selectedImageUri)
            binding.tvFileName.text = fileName
        }
    }

    private fun getFileNameFromUri(uri: Uri?): String {
        var fileName = ""
        uri?.let {
            val cursor = requireContext().contentResolver.query(uri, null, null, null, null)
            cursor?.apply {
                moveToFirst()
                val columnIndex = getColumnIndex(OpenableColumns.DISPLAY_NAME)
                fileName = getString(columnIndex)
                close()
            }
        }
        return fileName
    }

    private fun getFilePathFromUri(uri: Uri?): String? {
        var filePath: String? = null
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
        return filePath
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
