package com.example.walmartlab4

import java.io.Serializable

class User(var firstname: String?, var lastname: String?, var username: String?, var password: String?) : Serializable {
    override fun toString(): String {
        return "UserAccount(firstName=$firstname, lastName=$lastname, emailId=$username)"
    }
}