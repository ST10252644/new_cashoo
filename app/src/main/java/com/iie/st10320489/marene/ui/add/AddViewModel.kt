package com.iie.st10320489.marene.ui.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddViewModel : ViewModel() {

    // LiveData to expose a sample text to the UI (can be observed in the Fragment)
    private val _text = MutableLiveData<String>().apply {
        value = "This is Add Fragment"
    }

    // Public immutable LiveData
    val text: LiveData<String> = _text
}