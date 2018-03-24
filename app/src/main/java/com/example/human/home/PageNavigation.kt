package com.example.human.home

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
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

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        val toolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar);
        mContactFragment = ContactFragment();
        mNavigationTabs =  findViewById(R.id.tab_layout);
        mNavigationTabs.addTab(mNavigationTabs.newTab().setText(getString(HomePageConstants.TITLE_HOMELESS)));
        mNavigationTabs.addTab(mNavigationTabs.newTab().setText(getString(HomePageConstants.TITLE_DISABLED)));
        mNavigationTabs.addTab(mNavigationTabs.newTab().setText(getString(HomePageConstants.TITLE_DONATE)));
        mNavigationTabs.setTabGravity(TabLayout.GRAVITY_FILL);
       val viewPager : ViewPager = findViewById(R.id.pager);
        val adapter = PagerAdapter(getSupportFragmentManager(), mNavigationTabs.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(mNavigationTabs));
        //mNavigationTabs.addOnTabSelectedListener(TabLayout.OnTabSelectedListener)

    }



}