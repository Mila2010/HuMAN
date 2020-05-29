package com.example.human.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.human.disabled.DisabledFragment
import com.example.human.donate.DonateFragment
import com.example.human.homless.HomelessFragment

class  NavigationAdapter(fm: FragmentManager, val tabCount:Int ): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {


    override fun getItem(position: Int): Fragment = when (position) {
            0 ->  HomelessFragment()
            1 ->  DisabledFragment()
            2 -> DonateFragment()
            else -> error("")
        }
   

    override fun getCount(): Int = tabCount
}