package com.example.davaleba7

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    Edit.setOnClickListener {
        val intent = Intent(this, edit::class.java)
        startActivityForResult(intent, 1)
    }
}

override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (requestCode == 1)
        if (resultCode == Activity.RESULT_OK) {
            if (data != null) {
                firstName.text = data.getStringExtra("FIRST_NAME")
                lastName.text = data.getStringExtra("LAST_NAME")
                email.text = data.getStringExtra("EMAIL")
                year.text = data.getStringExtra("DATE")
                sex.text = data.getStringExtra("SEX")
            }
        }
}
}
