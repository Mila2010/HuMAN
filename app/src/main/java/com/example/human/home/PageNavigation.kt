package com.example.human.home

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

import com.example.human.ContactFragment
import com.example.human.R


/**
 * Created by mila on 3/23/18.
 */
class PageNavigation : AppCompatActivity() {

    lateinit var mNavigationTabs: TabLayout
    lateinit var mContactFragment: ContactFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        val toolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar);
        mContactFragment = ContactFragment();
        mNavigationTabs =  findViewById(R.id.tab_layout);
        mNavigationTabs.addTab(mNavigationTabs.newTab().setText(getString(TITLE_HOMELESS)))
        mNavigationTabs.addTab(mNavigationTabs.newTab().setText(getString(TITLE_DISABLED)))
        mNavigationTabs.addTab(mNavigationTabs.newTab().setText(getString(TITLE_DONATE)))
        mNavigationTabs.tabGravity = TabLayout.GRAVITY_FILL
        val viewPager : ViewPager = findViewById(R.id.pager)
        val adapter = NavigationAdapter(supportFragmentManager, mNavigationTabs.getTabCount())
        viewPager.adapter = adapter;
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(mNavigationTabs))

        mNavigationTabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem= tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) = Unit
            override fun onTabReselected(tab: TabLayout.Tab) = Unit

        })
    }
}