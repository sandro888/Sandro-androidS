package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        loginBtn.setOnClickListener {
            if (mail.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()) {
                Toast.makeText(this, "login completed", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show()

            }
        }
    }

}

