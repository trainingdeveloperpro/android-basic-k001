package com.trainingdeveloperpro.androidk001basic.lesson.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.trainingdeveloperpro.androidk001basic.R
import com.trainingdeveloperpro.androidk001basic.utils.DebugLog

/**
 * https://developer.android.com/guide/components/activities.html?hl=vi
 * Tạo 1 file TestActivity.kt
 * Tạo 1 file activity_test.xml ở thư mục layout
 * Khai báo ở AndroidManifest.xml
 *
 * **/
class TestActivity : AppCompatActivity(){

    private val TAG = TestActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        DebugLog.logD(TAG, "onCreate()")
    }

    override fun onStart() {
        super.onStart()

        DebugLog.logD(TAG, "onStart()")
    }

    override fun onResume() {
        super.onResume()

        DebugLog.logD(TAG, "onResume()")
    }

    override fun onPause() {
        super.onPause()

        DebugLog.logD(TAG, "onPause()")
    }

    override fun onStop() {
        super.onStop()

        DebugLog.logD(TAG, "onStop()")
    }

    override fun onRestart() {
        super.onRestart()

        DebugLog.logD(TAG, "onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()

        DebugLog.logD(TAG, "onDestroy()")
    }

}