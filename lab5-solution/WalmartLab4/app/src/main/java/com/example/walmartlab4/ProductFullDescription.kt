package com.example.walmartlab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_product_full_description.*

class ProductFullDescription : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_full_description)

        val temp = intent.getSerializableExtra("product")

        if(temp != null) {
            var result = temp as Product

            result.image?.let { image_pd_iv.setImageResource(it) }
            title_pd_tv.text = result.title
            color_pd_tv.text = result.color
            price_pd_tv.text = result.price.toString()
            id_pd_tv.text = result.itemId.toString()
            desc_pd_tv.text = result.desc
        }
    }
}