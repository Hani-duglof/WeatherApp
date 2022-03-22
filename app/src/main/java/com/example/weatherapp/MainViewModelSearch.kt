package com.example.weatherapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random
import androidx.lifecycle.MutableLiveData as MutableLiveData1

class MainViewModelSearch : ViewModel() {

    private var zipCode: String? = null

    private val _enableButton = MutableLiveData1(false)
    private val _showErrorDialog = MutableLiveData1(false)

    val showErrorDialog: LiveData<Boolean>
        get() = _showErrorDialog


    val enableButton: LiveData<Boolean>
        get() = _enableButton


    fun updateZipCode(zipCode: String) {
        if (zipCode != this.zipCode) {
            this.zipCode = zipCode
            _enableButton.value = isValidZipCode(zipCode)
        }
    }

    private fun isValidZipCode(zipCode: String): Boolean {
        return zipCode.length == 5 && zipCode.all { it.isDigit() }
    }

    fun submitButtonClicked() {

        Log.d(MainViewModelSearch::class.simpleName, zipCode ?: "No Zip yet!")
        _showErrorDialog.value = Random.nextBoolean()
    }
}
