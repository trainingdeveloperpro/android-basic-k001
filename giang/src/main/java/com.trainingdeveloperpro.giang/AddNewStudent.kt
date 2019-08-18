package com.trainingdeveloperpro.giang

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_add_new_student.*

class AddNewStudent : AppCompatActivity() {
    private lateinit var name: EditText
    private lateinit var age: EditText
    private lateinit var phone: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_student)
        supportActionBar!!.hide()

        name = findViewById(R.id.edtName)
        age = findViewById(R.id.edtAge)
        phone = findViewById(R.id.edtPhone)

        val button = findViewById<Button>(R.id.btnAddAStudent)
        button.setOnClickListener {
            val replyIntent = Intent()

            if (TextUtils.isEmpty(name.text) ||
                TextUtils.isEmpty(age.text) ||
                TextUtils.isEmpty(phone.text)
            ) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            }
            else {
                val name = edtName.text.toString()
                val age = edtAge.text.toString()
                val phone = edtPhone.text.toString()

                replyIntent.putExtra(EXTRA_AGE, age)
                replyIntent.putExtra(EXTRA_PHONE, phone)
                replyIntent.putExtra(EXTRA_NAME, name)

                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_NAME = "com.example.android.studentlistsql.EXTRA_NAME"
        const val EXTRA_AGE = "com.example.android.studentlistsql.EXTRA_AGE"
        const val EXTRA_PHONE = "com.example.android.studentlistsql.EXTRA_PHONE"

    }
}
