package com.example.testcoding.storage

import android.content.Context
import com.example.testcoding.models.User

class SharedPrefManager private constructor(private val mCtx: Context) {
    val isLoggedIn: User
        get() {
            val sharedPrefReference =
                mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return User(
                sharedPrefReference.getString("username", null),
                sharedPrefReference.getString("password", null)
            )
        }

    fun saveUser(user: String?) {
        val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putInt("id", user.id)
        editor.putString("password", user)

        editor.apply()
    }

    companion object {
        private val SHARED_PREF_NAME = "my_shared_pref"
        private var mInstance: SharedPrefManager? = null

        @Synchronized
        fun getInstance(mCtx: Context): SharedPrefManager {
            if (mInstance == null) {
                mInstance = SharedPrefManager(mCtx)
            }

            return mInstance as SharedPrefManager
        }
    }
}