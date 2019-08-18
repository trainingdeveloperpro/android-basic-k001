package com.trainingdeveloperpro.giang

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.*
import com.trainingdeveloperpro.giang.AddNewStudent.Companion.EXTRA_AGE
import com.trainingdeveloperpro.giang.AddNewStudent.Companion.EXTRA_NAME
import com.trainingdeveloperpro.giang.AddNewStudent.Companion.EXTRA_PHONE
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.trainingdeveloperpro.giang.StudentViewModel as studentViewModel

val newStudentctivityRequestCode = 1

class StudentFragment : Fragment() {
    private lateinit var studentViewModel: studentViewModel
    private lateinit var recyclerView : RecyclerView
    lateinit var adapter: StudentAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_student, container, false)

        recyclerView = rootView.findViewById<RecyclerView>(R.id.listStdudent)
        adapter = StudentAdapter(activity!!.applicationContext)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)

        studentViewModel = ViewModelProviders.of(this).get(com.trainingdeveloperpro.giang.StudentViewModel::class.java)

        studentViewModel.allStudents.observe(this, Observer { words ->
            words?.let { adapter.setStudent(it) }
        })

        val btnAdd = rootView.findViewById<FloatingActionButton>(R.id.btnAdd)
        btnAdd.setOnClickListener {
            val intent = Intent(activity, AddNewStudent::class.java)
            startActivityForResult(intent, newStudentctivityRequestCode)
        }

        setGridLayout()

        setLines()

        return rootView
    }

    private fun setLines() {
        val vertical = DividerItemDecoration(activity!!, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(vertical)
    }

    private fun setGridLayout() {
        val gridLayoutManager = GridLayoutManager(activity, 2)
        gridLayoutManager.orientation = GridLayoutManager.VERTICAL
        recyclerView.setLayoutManager(gridLayoutManager)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {

        if (requestCode == newStudentctivityRequestCode && resultCode == RESULT_OK) {
            intentData?.let { data ->
                val student = Student(
                    data.getStringExtra(EXTRA_NAME),
                    data.getStringExtra(EXTRA_PHONE),
                    data.getStringExtra(EXTRA_AGE).toInt()
                )

                var newListStudent: com.trainingdeveloperpro.giang.StudentViewModel = studentViewModel
                newListStudent.insert(student)
                var diffUtil: MyDiffUtil = MyDiffUtil(newListStudent,studentViewModel)
                val diffResult = DiffUtil.calculateDiff(diffUtil)

                studentViewModel = newListStudent
                diffResult.dispatchUpdatesTo(adapter)
            }
        } else {
            Toast.makeText(
                activity,
                R.string.toastAddNoone,
                Toast.LENGTH_LONG
            ).show()
        }
    }

}
