package com.example.midterm.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.covid19app.covidapi.*
import com.example.midterm.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_summary.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SummaryActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)



        this.getSummaryInfo()
    }







    private fun getSummaryInfo() {
        RetrofitClient.covid19Api.getGlobal("summary")
            .enqueue(object : Callback<Covid19GlobalSummary<Global>> {
                override fun onFailure(call: Call<Covid19GlobalSummary<Global>>, t: Throwable) {

                }

                @SuppressLint("SetTextI18n")
                override fun onResponse(
                    call: Call<Covid19GlobalSummary<Global>>,
                    response: Response<Covid19GlobalSummary<Global>>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        val responseBody = response.body()!!.summary
                        globalNewConfirmed.text = "New Confirmed: ${responseBody.newConfirmed}"
                        globalTotalConfirmed.text = "Total Confirmed: ${responseBody.totalConfirmed}"
                        globalNewDeaths.text = "New Deaths: ${responseBody.newDeaths}"
                        globalTotalDeaths.text = "Total Deaths: ${responseBody.totalDeaths}"
                        globalNewRecovered.text = "New Recovered: ${responseBody.newRecovered}"
                        globalTotalRecovered.text = "Total Recovered: ${responseBody.totalRecovered}"
                    }
                }

            })

    }
}
