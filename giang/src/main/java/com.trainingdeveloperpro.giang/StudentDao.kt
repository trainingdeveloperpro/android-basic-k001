package com.trainingdeveloperpro.giang

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface StudentDao {

    @Query("SELECT * from student_table ORDER BY name ASC")
    fun getAlphabetizedWords(): LiveData<List<Student>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(student: Student)

    @Query("DELETE FROM student_table")
    suspend fun deleteAll()
}
