package com.example.hydration

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class WaterViewModel(private val repository: WaterRepository): ViewModel() {

    val allRecords = repository.getAllRecords().asLiveData()

    fun insertNewRecord(record: WaterRecord) {
        viewModelScope.launch {
            repository.insert(record)
        }
    }

    fun updateRecord(record: WaterRecord) {
        viewModelScope.launch {
            repository.update(record)
        }
    }

    fun deleteRecord(record: WaterRecord) {
        viewModelScope.launch {
            repository.delete(record)
        }
    }

    fun getRecordForDay(day: String): LiveData<WaterRecord> {
        return repository.getRecordForDay(day).asLiveData()
    }
//    fun getAllRecords(): LiveData<List<WaterRecord>> {
//        return repository.getAllRecords().asLiveData()
//    }
//
}
    class WaterViewModelFactory(private val repository: WaterRepository): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(WaterViewModel::class.java)) {
                return WaterViewModel(repository) as T
            }
            throw IllegalArgumentException("$modelClass is not a WaterViewModel")
        }
    }
