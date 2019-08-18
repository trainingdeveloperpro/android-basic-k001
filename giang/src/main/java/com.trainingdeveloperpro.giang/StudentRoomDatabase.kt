package com.trainingdeveloperpro.giang

import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Student::class], version = 1)
abstract class StudentRoomDatabase : RoomDatabase() {

    abstract fun studentDao(): StudentDao

    companion object {
        @Volatile
        private var INSTANCE: StudentRoomDatabase? = null

        fun getDatabase(
                context: Context,
                scope: CoroutineScope
        ): StudentRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        StudentRoomDatabase::class.java,
                        "student_database"
                )
                        // Wipes and rebuilds instead of migrating if no Migration object.
                        // Migration is not part of this codelab.
                        .fallbackToDestructiveMigration()
                        .addCallback(StudentDatabaseCallback(scope))
                        .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

        private class StudentDatabaseCallback(
                private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                // If you want to keep the data through app restarts,
                // comment out the following line.
                INSTANCE?.let { database ->
                    scope.launch {
                        populateDatabase(database.studentDao())
                    }
                }
            }
        }

        suspend fun populateDatabase(studentDao: StudentDao) {
            studentDao.deleteAll()
            studentDao.insert(Student("Giang", "03214212381", 20))
            studentDao.insert(Student("Nam", "03214212322", 21))
            studentDao.insert(Student("Ha", "0321421322", 11))
            studentDao.insert(Student("Kha", "03214212332", 32))
            studentDao.insert(Student("Hao", "03214212441", 12))
            studentDao.insert(Student("Hoc", "03214212332", 21))
            for (i in 1..20) {
                studentDao.insert(Student("Name $i", "0321421233$i", 13 + i))
            }
        }
    }

}
