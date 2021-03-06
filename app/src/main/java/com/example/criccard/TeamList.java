package com.example.criccard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class TeamList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_list);

        ViewPager2 viewPager2=findViewById(R.id.viewPager);
        viewPager2.setAdapter(new PageAdapter(this));

        TabLayout tabLayout=findViewById(R.id.tabLayout);
        TabLayoutMediator tabLayoutMediator =new TabLayoutMediator(
                tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0: {
                        tab.setText("Team1");
                        tab.setIcon(R.drawable.ic_sports);
                        break;
                    }
                    default: {
                        tab.setText("Team2");
                        tab.setIcon(R.drawable.ic_sports);
                        break;
                    }

                }
            }
        }
        );
        tabLayoutMediator.attach();
    }
}