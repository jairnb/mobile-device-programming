package com.example.walmartlab4

import java.io.Serializable

data class Product(var title: String?, var price: Double?, var color: String?, var image: Int?, var itemId: String?, var desc: String?):
    Serializable

