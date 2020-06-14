package com.example.davaleba7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.davaleba7.adpter.Adapter
import com.example.davaleba7.restapi.Model
import com.example.davaleba7.restapi.Retrofit
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var Adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this)

        apiRecyclerView.layoutManager = layoutManager


        Adapter = Adapter(ArrayList())
        apiRecyclerView.adapter = Adapter
        getData()
    }

    private fun getData() {
        Retrofit.mockApi.getInfo()
            .enqueue(object : Callback<List<Model>> {
                override fun onFailure(call: retrofit2.Call<List<Model>>, t: Throwable) {

                }

                override fun onResponse(
                    call: retrofit2.Call<List<Model>>,
                    response: Response<List<Model>>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        Adapter.updateRecycler(response.body()!!)
                    }
                }

            })
    }
}
