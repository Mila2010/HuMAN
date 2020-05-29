package com.example.human.home

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.human.disabled.DisabledFragment
import com.example.human.donate.DonateFragment
import com.example.human.homless.HomelessFragment

class  NavigationAdapter(fm: FragmentManager, val tabCount:Int ): FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment? = when (position) {
            0 ->  HomelessFragment()
            1 ->  DisabledFragment()
            2 -> DonateFragment()
            else -> null
        }
   

    override fun getCount(): Int = tabCount
}