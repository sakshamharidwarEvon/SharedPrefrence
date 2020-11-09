package com.example.sharedpreference

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_another.*

class AnotherActivity : AppCompatActivity() {

    lateinit var preferences:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)

        preferences = getSharedPreferences("Shared_Pref",Context.MODE_PRIVATE)

        var name = preferences.getString("Name","")
        nameTv.text=name

        var age=preferences.getInt("Age",0)
        ageTv.text=""+age

        buttonLogout.setOnClickListener {

            var editor=preferences.edit()
            editor.clear()
            editor.apply()

            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()

        }

    }
}