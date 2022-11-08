package com.example.walmartlab4

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.product_detail.view.*

class MyAdapter(var context: Context, var productList:ArrayList<Product>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_detail, parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        productList[position].image?.let { holder.itemView.image_iv.setImageResource(it) }
        holder.itemView.title_tv.text = productList[position].title
        holder.itemView.price_tv.text = productList[position].price.toString()
        holder.itemView.color_tv.text = productList[position].color

        holder.itemView.product_detail_cl.setOnClickListener{
            val intent = Intent(context, ProductFullDescription::class.java)
            intent.putExtra("product", productList[position])
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return productList.size
    }
}