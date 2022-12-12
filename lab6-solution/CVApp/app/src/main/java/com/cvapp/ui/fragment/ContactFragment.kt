package com.cvapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cvapp.R
import com.cvapp.adpter.ContactRecycleViewAdapter
import com.cvapp.data.ContactData
import kotlinx.android.synthetic.main.fragment_contact.*

class ContactFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contactData = ArrayList<ContactData>()

        contactData.add(ContactData(R.drawable.phone, "+1 555 555 5555", "Phone"))
        contactData.add(ContactData(R.drawable.email,"john.doe@gmail.com", "Email"))
        contactData.add(ContactData(R.drawable.linkedin_black, "https://www.linkedin/com", "LinkedIn"))
        contactData.add(ContactData(R.drawable.github,"https://www.github.com", "Github"))
        contactData.add(ContactData(R.drawable.pdf, "Resume", "PDF"))

        recycle_view_contact.layoutManager = LinearLayoutManager(context)

        val adapter = ContactRecycleViewAdapter(contactData)
        recycle_view_contact.adapter = adapter
    }

}