package com.cvapp.ui.fragment

import android.content.Context
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.bold
import androidx.fragment.app.Fragment
import com.cvapp.R
import com.cvapp.data.HomeData
import com.cvapp.data.User
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeData = ArrayList<HomeData>()

        name_tv_home.text = getUser()?.firstname + " " + getUser()?.lastname ?: ""

        val language = SpannableStringBuilder().bold { append("Languages: ") }.append("Java, C#")
        language_tv_home.text = language

        val microservice = SpannableStringBuilder().bold { append("Microservices/Cloud: ") }.append("AWS, EC2, S3")
        microservice_tv_home.text = microservice

        val frameworks = SpannableStringBuilder().bold { append("Frameworks/Web: ") }.append("Spring Boot, Hibernate")
        framework_tv_home.text = frameworks

        val databases = SpannableStringBuilder().bold { append("Databases: ") }.append("MySQL, MSQL")
        database_tv_home.text = databases

        val tools = SpannableStringBuilder().bold { append("Tools: ") }.append("Intellij, Maven")
        tools_tv_home.text = tools
    }

    private fun getUser(): User? {
        val gson = Gson()
        val prefs = activity!!.getSharedPreferences("user", Context.MODE_PRIVATE)
//        val spf = getSharedPreferences("user", 0)
        val res = prefs.getString("user", "")

        return if(res != null){
            gson.fromJson(res, User::class.java)
        }else {
            null
        }
    }
}