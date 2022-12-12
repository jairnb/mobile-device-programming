package com.cvapp.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cvapp.R
import com.cvapp.data.HomeData
import kotlinx.android.synthetic.main.item_home_recycle_view.view.*

class HomeRecycleViewAdapter (var homeData: ArrayList<HomeData>) : RecyclerView.Adapter<HomeRecycleViewAdapter.MyViewHolder>(){
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_recycle_view, parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.itemView.textView3.text = homeData[position].title
        holder.itemView.textView4.text = homeData[position].description

    }

    override fun getItemCount(): Int {
        return homeData.size
    }

}