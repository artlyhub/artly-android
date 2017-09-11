package com.example.administrator.artly_android.CrowedFunding;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.administrator.artly_android.Action.ActionActivity;
import com.example.administrator.artly_android.Home.HomeActivity;
import com.example.administrator.artly_android.Profile.ProfileActivity;
import com.example.administrator.artly_android.R;
import com.example.administrator.artly_android.Search.SearchActivity;
import com.example.administrator.artly_android.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class CrowedFundingActivity extends AppCompatActivity {
    private static final String TAG = "CrowedFundingActivity";
    private static final int ACTIVITY_NUM = 2;

    private Context mContext = CrowedFundingActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crowed_funding);
        Log.d(TAG, "onCreate: started.");

        setupBottomNavigationView();

    }
    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
