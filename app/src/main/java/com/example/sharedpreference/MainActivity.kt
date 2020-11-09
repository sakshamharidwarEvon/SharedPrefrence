package com.example.sharedpreference

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPrefrence:SharedPreferences
    var isRemembered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        sharedPrefrence = getSharedPreferences("Shared_Pref",Context.MODE_PRIVATE)

        isRemembered = sharedPrefrence.getBoolean("CHECKBOX",false)

        if (isRemembered){

            var intent = Intent(this,AnotherActivity::class.java)
            startActivity(intent)
            finish()

        }


        login.setOnClickListener {

            var name = nameEt.text.toString()
            var age = ageEt.text.toString().toInt()
            var check = checkedBox.isChecked

            val editor= sharedPrefrence.edit()
            editor.putString("Name",name)
            editor.putInt("Age",age)
            editor.putBoolean("check",check)
            editor.apply()

            Toast.makeText(this, "Information Saved", Toast.LENGTH_SHORT).show()

            var intent = Intent(this,AnotherActivity::class.java)
            startActivity(intent)
            finish()
        }




    }
}