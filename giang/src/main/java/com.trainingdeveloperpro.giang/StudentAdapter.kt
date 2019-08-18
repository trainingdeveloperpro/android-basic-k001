package com.trainingdeveloperpro.giang

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.*


class StudentAdapter internal constructor(
        context: Context
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var students = Collections.emptyList<Student>() // Cached copy of words

    inner class StudentViewHolder(private val itemview: View) : RecyclerView.ViewHolder(itemview) {
        var name: TextView
        var phone: TextView
        var age: TextView


        init {
            name = itemview.findViewById(R.id.txtName)
            age = itemview.findViewById(R.id.txtAge)
            phone = itemview.findViewById(R.id.txtPhone)
            itemview.setOnClickListener { deleteStudent(adapterPosition) }
        }

        fun deleteStudent(position: Int) {
            students.removeAt(position)
            notifyItemRemoved(position)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val itemView = inflater.inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val current = students[position]
        holder.name.text = current.name
        holder.age.text = current.age.toString()
        holder.phone.text = current.phone
    }

    internal fun setStudent(students: List<Student>) {
        this.students = students
        notifyDataSetChanged()
    }

    override fun getItemCount() = students.size
}


