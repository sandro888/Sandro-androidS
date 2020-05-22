package com.example.midterm.activities
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.midterm.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity()
{
    var mAuth: FirebaseAuth? = null
    var user: FirebaseUser? = null
    var mAuthListener: FirebaseAuth.AuthStateListener? = null
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAuth = FirebaseAuth.getInstance()
        mAuthListener = FirebaseAuth.AuthStateListener{ firebaseAuth: FirebaseAuth ->
            user = firebaseAuth.currentUser
            if(user != null) {
                startActivity(Intent(this, DashboardActivity::class.java))
            finish() }else { Toast.makeText(
            this, "Not Signed In", Toast.LENGTH_LONG) .show() } }
        createActButon.setOnClickListener {
            startActivity(Intent(this, CreateAcountActivity::class.java))
        }
        loginButton.setOnClickListener {

            startActivity(Intent(this, LoginActivity::class.java))
        } }
            override fun onStart() { super.onStart()
            mAuth!!.addAuthStateListener(mAuthListener!!) } override fun onStop() {
                super.onStop()
            if (mAuthListener != null) { mAuth!!.removeAuthStateListener(mAuthListener!!)
            }
        }
}