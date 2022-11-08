package com.example.walmartlab4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.product_detail.view.*

class MyAdapter(var productLis:ArrayList<Product>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_detail, parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        productLis[position].image?.let { holder.itemView.image_iv.setImageResource(it) }
        holder.itemView.title_tv.text = productLis[position].title
        holder.itemView.price_tv.text = productLis[position].price.toString()
        holder.itemView.color_tv.text = productLis[position].color
    }

    override fun getItemCount(): Int {
        return productLis.size
    }
}