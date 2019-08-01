package com.trainingdeveloperpro.androidk001basic.utils

import android.util.Log
import com.trainingdeveloperpro.androidk001basic.BuildConfig

class DebugLog {

    companion object {
        fun logD(message: String) {
            if (BuildConfig.DEBUG)
                Log.d("TAG", message)
        }

        fun logD(tag: String, message: String) {
            if (BuildConfig.DEBUG) Log.d(tag, message)
        }
    }

}