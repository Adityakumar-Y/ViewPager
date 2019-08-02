package com.example.mypageviewer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;


import com.example.mypageviewer.Fragments.AfricaFragment;
import com.example.mypageviewer.Fragments.EnglandFragment;
import com.example.mypageviewer.Fragments.IndiaFragment;
import com.example.mypageviewer.Fragments.UsaFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar); // Set Actionbar as ToolBar

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        addTabs(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void onBackPressed() {
        if(viewPager.getCurrentItem() == 0)
            super.onBackPressed();
        else
            viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
    }

    private void addTabs(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFrag(new IndiaFragment(), "INDIA");
        viewPagerAdapter.addFrag(new EnglandFragment(), "ENGLAND");
        viewPagerAdapter.addFrag(new UsaFragment(), "USA");
        viewPagerAdapter.addFrag(new AfricaFragment(), "AFRICA");
        viewPager.setAdapter(viewPagerAdapter);
    }

     class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> fragmentListTitle = new ArrayList<>();


        public ViewPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        public void addFrag(Fragment fragment, String title){
            fragmentList.add(fragment);
            fragmentListTitle.add(title);
        }

         @Nullable
         @Override
         public CharSequence getPageTitle(int position) {
             return fragmentListTitle.get(position);
         }
     }
}
