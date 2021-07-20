package com.uche.userapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uche.userapp.api.UserProvider
import com.uche.userapp.model.Item
import com.uche.userapp.model.Student
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val itemLiveData = MutableLiveData<List<Item>>()
    val studentsLiveData = MutableLiveData<List<Student>>()
    fun getItem(){
        CoroutineScope(Dispatchers.IO).launch {
            itemLiveData.postValue(UserProvider.placeHolderAPI.getItem())
        }
    }

    fun addStudent(newStudent: Student){
        CoroutineScope(Dispatchers.IO).launch {
          studentsLiveData.postValue(UserProvider.placeHolderAPI.addStudents(newStudent))
        }
    }
}
