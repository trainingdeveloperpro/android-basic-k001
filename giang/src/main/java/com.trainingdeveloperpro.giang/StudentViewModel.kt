package com.trainingdeveloperpro.giang

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch



class StudentViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: StudentRepository
    val allStudents: LiveData<List<Student>>

    init {
        val studentsDao = StudentRoomDatabase.getDatabase(application, viewModelScope).studentDao()
        repository = StudentRepository(studentsDao)
        allStudents = repository.allStudents
    }


    fun insert(student: Student) = viewModelScope.launch {
        repository.insert(student)
    }

    fun size():Int{
        return allStudents.value!!.size
    }

    fun getName(position : Int):String{
        return allStudents.value!!.get(position).name
    }
}
