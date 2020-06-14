package com.example.davaleba7.adpter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.davaleba7.R
import com.example.davaleba7.restapi.Model
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_index.view.*

class Adapter(private var data: List<Model> )
    : RecyclerView.Adapter<Adapter.MockViewHolder>() {

    class MockViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SetTextI18n")
        fun bind(info: Model) {

            itemView.titleENView.text = "Title: \n${info.titleEN}"
            itemView.descENView.text = "Description: \n${info.descriptionEN}"

            Picasso.get()
                .load(info.cover).into(itemView.apiCoverView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MockViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.activity_index, parent, false)

        return MockViewHolder(v)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MockViewHolder, position: Int) {
        holder.bind(data[position])
    }

    fun updateRecycler(data: List<Model>) {
        this.data = data
        notifyDataSetChanged()
    }
}
