package com.cvapp.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cvapp.R
import com.cvapp.data.ContactData
import kotlinx.android.synthetic.main.item_contact_recycle_view.view.*

class ContactRecycleViewAdapter (var contactData: ArrayList<ContactData>) : RecyclerView.Adapter<ContactRecycleViewAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact_recycle_view, parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        contactData[position].image?.let { holder.itemView.imageView_contact.setImageResource(it) }
        holder.itemView.title_tv_contact.text = contactData[position].title
        holder.itemView.desc_tv_contact.text = contactData[position].description
    }

    override fun getItemCount(): Int {
        return contactData.size
    }
}