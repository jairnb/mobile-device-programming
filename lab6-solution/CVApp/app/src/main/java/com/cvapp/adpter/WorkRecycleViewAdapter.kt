package com.cvapp.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cvapp.R
import com.cvapp.data.WorkExperience
import kotlinx.android.synthetic.main.item_work_experience_recycle_view.view.*
import java.time.format.DateTimeFormatter

class WorkRecycleViewAdapter(var workList: ArrayList<WorkExperience>) : RecyclerView.Adapter<WorkRecycleViewAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_work_experience_recycle_view, parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MMMM yyyy")
//        val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("E yyyy-MM-dd HH:mm")

        workList[position].image?.let { holder.itemView.imageViewWork.setImageResource(it) }
        holder.itemView.title_tv_work.text = workList[position].title
        holder.itemView.company_tv_work.text = workList[position].company
        holder.itemView.description_tv_work.text = workList[position].description
        holder.itemView.location_tv_work.text = workList[position].location
        holder.itemView.location_tv_work.text = workList[position].location
        holder.itemView.from_date_tv_work.text = formatter.format(workList[position].dateFrom).toString() + " - " +formatter.format(workList[position].dateTo).toString()

    }

    override fun getItemCount(): Int {
        return workList.size
    }
}