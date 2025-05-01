package com.iie.st10320489.marene.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    // LiveData holding a default text message for the Home Fragment UI
    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }

    // Public immutable LiveData for observers
    val text: LiveData<String> = _text
}