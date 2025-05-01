package com.iie.st10320489.marene.ui.subcategory

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import com.iie.st10320489.marene.R
import com.iie.st10320489.marene.data.database.DatabaseInstance
import com.iie.st10320489.marene.data.entities.SubCategory
import kotlinx.coroutines.launch

<<<<<<< HEAD
class SubCategoryDialogFragment : DialogFragment() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.dialog_add_subcategory, null)
        val editTextSubcategoryName = view.findViewById<EditText>(R.id.editTextSubcategoryName)

        sharedPreferences = requireActivity().getSharedPreferences("UserPreferences", Context.MODE_PRIVATE)

        builder.setView(view)
            .setTitle("Add Subcategory")
            .setPositiveButton("Add") { _, _ ->
                val subcategoryName = editTextSubcategoryName.text.toString().trim()
                if (subcategoryName.isNotEmpty()) {
                    addSubCategoryToDatabase(subcategoryName)
                }
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }

        return builder.create()
    }

    private fun addSubCategoryToDatabase(subcategoryName: String) {
        val db = DatabaseInstance.getDatabase(requireContext())
        val subCategoryDao = db.subCategoryDao()

        val currentUserEmail = sharedPreferences.getString("currentUserEmail", null)

        if (currentUserEmail != null) {
            lifecycleScope.launch {
                val userDao = db.userDao()
                val userId = userDao.getUserIdByEmail(currentUserEmail)

                if (userId != null) {
=======
class SubCategoryDialogFragment : DialogFragment() { // (CodeWithMazn, 2020)

    // Declare SharedPreferences to access user preferences
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Create an AlertDialog.Builder using the context of the current activity
        val builder = AlertDialog.Builder(requireContext())
        val inflater = requireActivity().layoutInflater

        // Inflate the custom dialog layout for adding a subcategory
        val view = inflater.inflate(R.layout.dialog_add_subcategory, null)
        val editTextSubcategoryName = view.findViewById<EditText>(R.id.editTextSubcategoryName)


        sharedPreferences = requireActivity().getSharedPreferences("UserPreferences", Context.MODE_PRIVATE) // (CodeWithMazn, 2020)

        // Set up the dialog view, title, and button actions
        builder.setView(view)
            .setTitle("Add Subcategory")
            .setPositiveButton("Add") { _, _ ->
                // When "Add" is clicked, retrieve and trim the subcategory name
                val subcategoryName = editTextSubcategoryName.text.toString().trim()
                // If the input is not empty, proceed to add the subcategory to the database
                if (subcategoryName.isNotEmpty()) {
                    addSubCategoryToDatabase(subcategoryName) // (CodeWithMazn, 2020)
                }
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                // When "Cancel" is clicked, simply dismiss the dialog
                dialog.dismiss()
            }


        return builder.create()
    }

    // Function to add a new subcategory entry into the database
    private fun addSubCategoryToDatabase(subcategoryName: String) {

        val db = DatabaseInstance.getDatabase(requireContext())
        val subCategoryDao = db.subCategoryDao()

        // Retrieve the current user's email from SharedPreferences
        val currentUserEmail = sharedPreferences.getString("currentUserEmail", null)

        // Only proceed if the email is not null (user is logged in)
        if (currentUserEmail != null) { // (CodeWithMazn, 2020)

            lifecycleScope.launch {
                // Access the User DAO to find the user ID using the email
                val userDao = db.userDao()
                val userId = userDao.getUserIdByEmail(currentUserEmail)

                // Only proceed if a valid user ID is found
                if (userId != null) { // (CodeWithMazn, 2020)

>>>>>>> nathan
                    val subCategory = SubCategory(
                        name = subcategoryName,
                        userId = userId
                    )

<<<<<<< HEAD
                    subCategoryDao.insertSubCategory(subCategory)

                    // After inserting new subcategory, reload list
=======
                    // Insert the new subcategory into the database
                    subCategoryDao.insertSubCategory(subCategory)


>>>>>>> nathan
                    (parentFragment as? SubcategoryFragment)?.loadSubcategories()
                }
            }
        }
    }


}
<<<<<<< HEAD
=======

//Reference List
//CodeWithMazn. 2020. Dialog Fragment in Android [Kotlin 2020]. [video online]. Available at: https://www.youtube.com/watch?v=SkFcDWt9GV4 [Accessed on 13 April 2025]
//GeeksforGeeks. 2025. Android UI Layouts. [online]. Available at: https://www.geeksforgeeks.org/android-ui-layouts/ [Accessed on 10 April 2025]
//Muhammadumarch. 2023. Implementing Navigation in Your Android App with Android Navigation Component. [online]. Available at: https://medium.com/@muhammadumarch321/implementing-navigation-in-your-android-app-with-android-navigation-component-ff22a3d300a [Accessed on 11 April 2025]
//Android Developers. 2025. Fragment lifecycle. [online]. Available at: https://developer.android.com/guide/fragments/lifecycle [Accessed on 12 April 2025]
//Android Knowledge. 2024. ViewModel in Android Studio using Kotlin | Android Knowledge. [video online]. Available at: https://www.youtube.com/watch?v=v32hSKtlH9A [Accessed on 11 April 2025]
//Code With Cal. 2025. Room Database Android Studio Kotlin Example Tutorial. [video online]. Available at: https://www.youtube.com/watch?v=-LNg-K7SncM [Accessed on 12 April 2025]
//Coding With T. 2020. 06 - Categories Design in Android Studio - Android Studio Cardview. Available at: https://www.youtube.com/watch?v=7S7646Cymn0 [Accessed on 12 April 2025]
//Android Developers. 2025. Accessing data using Room DAOs. [online]. Available at: https://developer.android.com/training/data-storage/room/accessing-data [Accessed on 15 April 2025]
>>>>>>> nathan
