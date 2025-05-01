package com.iie.st10320489.marene.ui.category

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.iie.st10320489.marene.data.database.DatabaseInstance
import com.iie.st10320489.marene.data.entities.Category
import com.iie.st10320489.marene.data.repository.CategoryRepository
import kotlinx.coroutines.launch

class CategoryViewModel(application: Application) : AndroidViewModel(application) {

    // Initialize the repository using the DAO from the Room database
    private val repository: CategoryRepository =
        CategoryRepository(DatabaseInstance.getDatabase(application).categoryDao())

    // Lazily load all categories (can be observed from UI)
    val allCategories by lazy { repository.getAll() }

    // Insert a new category asynchronously
    fun insert(category: Category) = viewModelScope.launch {
        repository.insert(category)
    }

    // Get categories specific to a user
    fun getCategoriesByUser(userId: Int) = repository.getCategoriesByUser(userId)
}