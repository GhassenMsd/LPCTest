package com.example.lpctest.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.lpctest.Adapters.PagerAdapter;
import com.example.lpctest.Entities.Pot;
import com.example.lpctest.R;
import com.example.lpctest.retro.ApiUtil;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        button= findViewById(R.id.add);


        setSupportActionBar(toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("ANNIVERSAIRE"));
        tabLayout.addTab(tabLayout.newTab().setText("DEPART"));
        tabLayout.addTab(tabLayout.newTab().setText("SOLIDAIRE"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ApiUtil.getServiceClass().AddPot().enqueue(new Callback<Pot>() {
                    @Override
                    public void onResponse(Call<Pot> call, Response<Pot> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Succes",Toast.LENGTH_SHORT).show();

                        }else {
                            Toast.makeText(getApplicationContext(),"Succes but no add",Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Pot> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"Oups une erreur est survenue",Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });

    }
}
