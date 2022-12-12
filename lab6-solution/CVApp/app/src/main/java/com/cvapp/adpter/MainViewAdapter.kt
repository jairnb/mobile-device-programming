package com.cvapp.adpter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cvapp.ui.fragment.AboutFragment
import com.cvapp.ui.fragment.ContactFragment
import com.cvapp.ui.fragment.HomeFragment
import com.cvapp.ui.fragment.WorkFragment

class MainViewAdapter (fm: FragmentManager, lc: Lifecycle) : FragmentStateAdapter(fm,lc) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> HomeFragment()
            1-> AboutFragment()
            2-> WorkFragment()
            3-> ContactFragment()
            else-> Fragment()
        }
    }
}