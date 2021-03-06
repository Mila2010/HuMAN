package com.example.human.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.example.human.ContactFragment
import com.example.human.R
import com.example.human.disabled.ParksFragment
import com.example.human.homless.HomelessOptionsFragment
import com.google.android.material.tabs.TabLayout

class HomeActivity : AppCompatActivity() {

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
        viewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) = Unit

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) = Unit

            override fun onPageSelected(position: Int) = Unit
        })

        mNavigationTabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem= tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) = Unit
            override fun onTabReselected(tab: TabLayout.Tab) = Unit

        })
    }
    fun showDetails(view: View) {
        when (view.id) {
            R.id.family_shelters -> supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.content_container, HomelessOptionsFragment())
                    .addToBackStack(null)
                    .commit()
            R.id.parks -> supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.content_container, ParksFragment())
                    .addToBackStack(null)
                    .commit()
        }
    }

}