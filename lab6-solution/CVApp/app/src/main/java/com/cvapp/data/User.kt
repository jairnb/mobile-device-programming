package com.cvapp.data

import java.io.Serializable

data class User(var firstname: String, var lastname: String, var username: String, var password: String) : Serializable {
}