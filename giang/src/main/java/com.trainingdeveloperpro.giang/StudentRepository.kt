package com.trainingdeveloperpro.giang

import androidx.lifecycle.LiveData


class StudentRepository(private val studentDao: StudentDao) {
    val allStudents: LiveData<List<Student>> = studentDao.getAlphabetizedWords()

    suspend fun insert(student: Student) {
        studentDao.insert(student)
    }
}
