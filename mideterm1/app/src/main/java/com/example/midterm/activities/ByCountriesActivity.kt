package com.example.midterm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.midterm.adapters.ByCountryAdapter
import com.example.covid19app.covidapi.Country
import com.example.covid19app.covidapi.Covid19CountrySummary
import com.example.covid19app.covidapi.RetrofitClient
import com.example.midterm.R
import kotlinx.android.synthetic.main.activity_by_countries.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ByCountriesActivity : AppCompatActivity() {

    private lateinit var byCountryAdapter: ByCountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_by_countries)

        val layoutManager = LinearLayoutManager(this)
        byCountriesRecycler.layoutManager = layoutManager
        byCountryAdapter = ByCountryAdapter(ArrayList())
        byCountriesRecycler.adapter = byCountryAdapter

        getByCountry()
    }

    private fun getByCountry() {
        RetrofitClient.covid19Api.getData("summary")

            .enqueue(object : Callback<Covid19CountrySummary<List<Country>>> {
                override fun onFailure(
                    call: Call<Covid19CountrySummary<List<Country>>>,
                    t: Throwable
                ) {

                }
                override fun onResponse(
                    call: Call<Covid19CountrySummary<List<Country>>>,
                    response: Response<Covid19CountrySummary<List<Country>>>
                ) {
                    if(response.isSuccessful && response.body() != null) {
                        val byCountryList = response.body()!!.countries.sortedByDescending { it.newDeaths }
                        byCountryAdapter.updateByCountries(byCountryList)
                    }
                }

            })
    }
}
