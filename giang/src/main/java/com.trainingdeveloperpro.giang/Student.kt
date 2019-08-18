package com.trainingdeveloperpro.giang

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
data class Student(@PrimaryKey @ColumnInfo(name = "name") val name: String                   ,
                   @ColumnInfo(name = "phone") val phone: String,
                   @ColumnInfo(name = "age") val age: Int)
