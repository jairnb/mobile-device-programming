package com.example.walmartlab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayoutStates
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_product_list_rec_view.*

class ProductListRecView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list_rec_view)

        var productList = ArrayList<Product>()
        var item1 = Product("Tv Insignia", 254.0, "Black", R.drawable.tv, "1", "4K Ultra HD (2160p resolution) - Enjoy breathtaking 4K movies and TV shows at 4 times the resolution of Full HD, and upscale your current content to Ultra HD-level picture quality.")
        var item2 = Product("Projector", 897.0, "White", R.drawable.projector, "2", "4K Ultra HD (2160p resolution) - Enjoy breathtaking 4K movies and TV shows at 4 times the resolution of Full HD, and upscale your current content to Ultra HD-level picture quality.")
        var item3 = Product("Printer", 4512.0, "Blue", R.drawable.printer, "3", "4K Ultra HD (2160p resolution) - Enjoy breathtaking 4K movies and TV shows at 4 times the resolution of Full HD, and upscale your current content to Ultra HD-level picture quality.")
        var item4 = Product("Laptop", 79.0, "Brown", R.drawable.laptop, "4", "4K Ultra HD (2160p resolution) - Enjoy breathtaking 4K movies and TV shows at 4 times the resolution of Full HD, and upscale your current content to Ultra HD-level picture quality.")
        var item5 = Product("Tablet", 146.0, "Yellow", R.drawable.tablet, "5", "4K Ultra HD (2160p resolution) - Enjoy breathtaking 4K movies and TV shows at 4 times the resolution of Full HD, and upscale your current content to Ultra HD-level picture quality.")
        productList.add(item1)
        productList.add(item2)
        productList.add(item3)
        productList.add(item4)
        productList.add(item5)
        productList.add(item5)
        productList.add(item5)
        productList.add(item5)

        val adapter = MyAdapter(this, productList)
        list_item.adapter = adapter

        list_item.layoutManager = LinearLayoutManager(this)

    }
}