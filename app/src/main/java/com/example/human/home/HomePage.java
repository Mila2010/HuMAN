package com.example.human.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.human.ContactFragment;
import com.example.human.R;
import com.example.human.homless.HomelessOptionsFragment;
import com.example.human.maps.MapsActivity;
import com.example.human.disabled.ParksFragment;

public class HomePage extends AppCompatActivity {

    TabLayout mTabLayout;
    ContactFragment mContactFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mContactFragment = new ContactFragment();

        mTabLayout =  findViewById(R.id.tab_layout);
        mTabLayout.addTab(mTabLayout.newTab().setText(getString(HomePageConstants.TITLE_HOMELESS)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getString(HomePageConstants.TITLE_DISABLED)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getString(HomePageConstants.TITLE_DONATE)));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), mTabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.contact_us:
                getSupportFragmentManager().beginTransaction().add(R.id.activity_main, mContactFragment).commit();

                break;

            case R.id.More_links:

                Intent intent = new Intent(this, MapsActivity.class);
                startActivity(intent);


                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void removeContactUs(View view) {

        getSupportFragmentManager().beginTransaction().remove(mContactFragment).commit();

    }

    public void showDetails(View view) {
        switch (view.getId()) {
            case R.id.family_shelters:

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_container, new HomelessOptionsFragment())
                        .addToBackStack(null)
                        .commit();
                break;

            case R.id.parks:

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_container, new ParksFragment())
                        .addToBackStack(null)
                        .commit();

                break;
        }

    }

}
