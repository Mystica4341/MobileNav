package com.bt.navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    ActionBar actionBar;
    FrameLayout frameLayout;
    BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();
        frameLayout = (FrameLayout) findViewById(R.id.frameFrag);
        bottomNav = (BottomNavigationView) findViewById(R.id.BottomNav);

        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.shop){
                    actionBar.setTitle("Shop");
                    loadFragment(new ShopFrag());
                    return true;
                } else if (id == R.id.gift) {
                    actionBar.setTitle("Gift");
                    loadFragment(new GiftFrag());
                    return true;
                } else if (id == R.id.cart) {
                    actionBar.setTitle("Cart");
                    loadFragment(new CartFrag());
                    return true;
                } else if (id == R.id.profile) {
                    actionBar.setTitle("Profile");
                    loadFragment(new ProfileFrag());
                    return true;
                }
                return false;
            }
        });
    }

    public void loadFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        //đẩy fragment tương ứng lên
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameFrag, fragment);
        ft.commit();
    }
}