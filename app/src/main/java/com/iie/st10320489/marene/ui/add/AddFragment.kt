package com.iie.st10320489.marene.ui.add

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.OpenableColumns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.iie.st10320489.marene.data.database.AppDatabase
import com.iie.st10320489.marene.data.database.DatabaseInstance
import com.iie.st10320489.marene.data.entities.Transaction
import com.iie.st10320489.marene.databinding.FragmentAddBinding
import kotlinx.coroutines.launch
import java.util.Calendar

// Fragment used for adding a new transaction entry
class AddFragment : Fragment() { //(Cal, 2023), (College, 2025)


    private var userId: Int = 0

    // SharedPreferences and database references
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var database: AppDatabase


    private var selectedCategoryId: Int = 0
    private var selectedSubCategoryId: Int = 0


    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!


    private val REQUEST_CODE_PICK_IMAGE = 100
    private var selectedImagePath: String? = null


    private var selectedDate: String = ""
    private var selectedTime: String = ""

    // Inflates the layout and returns the root view
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Called once the view is created
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize database and shared preferences
        database = DatabaseInstance.getDatabase(requireContext())
        sharedPreferences = requireActivity().getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)

        val spinner = binding.categorySpinner
        val currentUserEmail = sharedPreferences.getString("currentUserEmail", null)

        // Load categories and subcategories if email is found
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

                    // Handle spinner selection
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

        // Open image picker when button is clicked
        binding.btnChooseFile.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE)
        }

        // Handle "Add Entry" button click
        binding.btnAddEntry.setOnClickListener {
            val name = binding.transName.text.toString()
            val amount = binding.transAmount.text.toString().toDoubleOrNull() ?: 0.0
            val method = binding.transMethod.text.toString()
            val location = binding.transLocation.text.toString()
            val date = binding.transDate.text.toString()
            val description = binding.transDescription.text.toString()
            val transactionType = if (binding.rbExpense.isChecked) "Expense" else "Income"

            // Ensure user and category are selected
            if (userId != 0 && selectedCategoryId != 0) {
                val transaction = Transaction(
                    userId = userId,
                    name = name,
                    amount = amount,
                    transactionMethod = method,
                    location = location,
                    dateTime = date,
                    description = description,
                    photo = "@drawable/receipt.jpeg", // Placeholder photo path
                    categoryId = selectedCategoryId,
                    subCategoryId = if (selectedSubCategoryId != 0) selectedSubCategoryId else null,
                    expense = binding.rbExpense.isChecked,
                    recurring = false
                )

                // Insert transaction into database
                lifecycleScope.launch {
                    database.transactionDao().insert(transaction)
                    Toast.makeText(requireContext(), "Transaction saved successfully", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Please select a category first!", Toast.LENGTH_SHORT).show()
            }

            // Clear the input fields
            resetFields()
        }

        // Handle date picker
        val calendar = Calendar.getInstance()
        binding.btnPickDate.setOnClickListener {
            val datePicker = DatePickerDialog(requireContext(), { _, year, month, dayOfMonth ->
                selectedDate = String.format("%04d-%02d-%02d", year, month + 1, dayOfMonth)
                updateDateTimeField()
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
            datePicker.show()
        }

        // Handle time picker
        binding.btnPickTime.setOnClickListener {
            val timePicker = TimePickerDialog(requireContext(), { _, hourOfDay, minute ->
                selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                updateDateTimeField()
            }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true)
            timePicker.show()
        }
    }

    // Updates the date/time field after selection
    private fun updateDateTimeField() {
        if (selectedDate.isNotEmpty() && selectedTime.isNotEmpty()) {
            val dateTime = "$selectedDate $selectedTime"
            binding.transDate.setText(dateTime)
        }
    }

    // Handle result from image picker and display the selected image
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_PICK_IMAGE && resultCode == AppCompatActivity.RESULT_OK && data != null) {
            val selectedImageUri = data.data

            selectedImagePath = getFilePathFromUri(selectedImageUri)

            Glide.with(requireContext())
                .load(selectedImageUri)
                .into(binding.imageView)

            val fileName = getFileNameFromUri(selectedImageUri)
            binding.tvFileName.text = fileName
        }
    }

    // Extracts file name from a content URI
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

    // Gets the absolute file path from URI
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

    // Clears all input fields in the form
    private fun resetFields() {
        binding.transName.text.clear()
        binding.transAmount.text.clear()
        binding.transMethod.text.clear()
        binding.transLocation.text.clear()
        binding.transDate.text.clear()
        binding.transDescription.text.clear()
        binding.rbExpense.isChecked = true
        binding.imageView.setImageDrawable(null)
        binding.tvFileName.text = ""
    }

    // Clean up the binding reference
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}//(Cal, 2023), (College, 2025)


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
