package com.example.human;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.human.view.HomelessOptionsFragment;
import com.example.human.view.MapsActivity;

public class HomePage extends AppCompatActivity {

    TabLayout mTabLayout;
    ContactUsFragment mContactUsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override

    protected void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mContactUsFragment = new ContactUsFragment();

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mTabLayout.addTab(mTabLayout.newTab().setText("Help for Homeless"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Tab 2"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Donate"));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setOffscreenPageLimit(2);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), mTabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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

        switch(item.getItemId()) {
            case R.id.contact_us:
              getSupportFragmentManager().beginTransaction().add(R.id.activity_main,mContactUsFragment).commit();

                break;

            case R.id.More_links:

                Intent intent = new Intent(this, MapsActivity.class);
                startActivity(intent);


                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void removeContactUs(View view){

        getSupportFragmentManager().beginTransaction().remove(mContactUsFragment).commit();

    }

    public void showDetails(View view){
        switch (view.getId()){

            case R.id.family_shelters:

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main,new HomelessOptionsFragment())
                .addToBackStack(null)
                .commit();
        break;
        }

    }

}
