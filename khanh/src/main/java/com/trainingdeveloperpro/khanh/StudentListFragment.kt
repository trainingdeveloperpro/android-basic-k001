package com.trainingdeveloperpro.khanh

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

private const val GRID_NUMBER = 2

class StudentListFragment : Fragment() {
    private lateinit var studentViewModel: StudentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_student_list, container, false)
        val adapter = StudentListAdapter()
        val recyclerView: RecyclerView = rootView.findViewById(R.id.recyclerview)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(activity, GRID_NUMBER)

        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel::class.java)
        studentViewModel.allStudent.observe(this, Observer {students ->
            students?.let { adapter.setStudent(it) }
        })

        val buttonFab = rootView.findViewById<FloatingActionButton>(R.id.fab)
        buttonFab.setOnClickListener {
            val intent = Intent(activity, NewStudentActivity::class.java)
            startActivityForResult(intent, newStudentActivityRequestCode)
        }
        return rootView
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newStudentActivityRequestCode && resultCode == Activity.RESULT_OK){
            data?.let {
                val newName = it.getStringExtra(NewStudentActivity.EXTRA_NAME)
                val newAge = it.getStringExtra(NewStudentActivity.EXTRA_AGE)
                val newTelephone = it.getStringExtra(NewStudentActivity.EXTRA_TELEPHONE)
                studentViewModel.insert(Student(newName, newAge, newTelephone))
            }
        } else {
            Toast.makeText(activity, R.string.empty_not_save, Toast.LENGTH_LONG).show()
        }
    }

    companion object {
        const val newStudentActivityRequestCode = 1
    }
}
