package com.cvapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cvapp.R
import com.cvapp.adpter.WorkRecycleViewAdapter
import com.cvapp.data.WorkExperience
import kotlinx.android.synthetic.main.fragment_work.*
import java.time.LocalDate


class WorkFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_work, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val workList = ArrayList<WorkExperience>()

        workList.add(WorkExperience(R.drawable.twitter, "Software Developer", "Twitter", LocalDate.of(2020, 10, 1), LocalDate.of(2022, 10, 1), "LA, California", "Analyzed requirements and implemented database structure."))
        workList.add(WorkExperience(R.drawable.google, "Software Developer", "Google", LocalDate.of(2010, 1, 15), LocalDate.of(2014, 3, 1), "LA, California", "Tested and deployed applications, systems, and functionalities."))
        workList.add(WorkExperience(R.drawable.microsoft_logo, "Software Developer", "Microsoft", LocalDate.of(2014, 1, 15), LocalDate.of(2016, 3, 1), "LA, California", "Contributed to front-end and back-end development of software systems."))
        workList.add(WorkExperience(R.drawable.apple, "Software Developer", "Apple", LocalDate.of(2016, 1, 15), LocalDate.of(2018, 3, 1), "LA, California", "Ensured performance, quality, and responsiveness of web."))


        work_recycler_view.layoutManager = LinearLayoutManager(context)

        val adapter = WorkRecycleViewAdapter(workList)
        work_recycler_view.adapter = adapter
    }
}