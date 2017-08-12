package com.example.administrator.artly_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    private MyPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionsPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(1);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        return true;
                    case R.id.navigation_search:
                        intent = new Intent(MainActivity.this,SearchActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.navigation_crowed_funding:
                        intent = new Intent(MainActivity.this,CrowedFundingActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.navigation_action:
                        intent = new Intent(MainActivity.this,ActionActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.navigation_profile:
                        intent = new Intent(MainActivity.this,ProfileActivity.class);
                        startActivity(intent);
                        return true;
                }
                return false;
            }
        });

    }

    //fragment 각각 생성
    public class MyPagerAdapter extends FragmentPagerAdapter {

        private final String[] TITLES = {"작품등록", "커뮤니티", "메신저"};

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: { //Request
                    return ArtworkFragment.newInstance();
                }
                case 1: { //Recommend
                    return CommunityFragment.newInstance();
                }
                case 2: {//Setting
                    return MessengerFragment.newInstance();
                }
            }
            return null;
        }

        @Override
        public int getCount() {
            return  TITLES.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return TITLES[0];
                case 1:
                    return TITLES[1];
                case 2:
                    return TITLES[2];
            }
            return null;
        }
    }
}

