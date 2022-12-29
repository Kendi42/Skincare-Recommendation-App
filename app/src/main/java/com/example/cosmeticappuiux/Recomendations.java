package com.example.cosmeticappuiux;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.example.cosmeticappuiux.main.SectionsPagerAdapter;
import com.example.cosmeticappuiux.databinding.ActivityRecomendationsBinding;

import com.google.android.material.tabs.TabLayout;

public class Recomendations extends AppCompatActivity {

    private ActivityRecomendationsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRecomendationsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextView home = findViewById(R.id.homebutton);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(intent);
            }
        });

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);


        sectionsPagerAdapter.addFragment(new MakeupFragment(),"Makeup");
        sectionsPagerAdapter.addFragment(new SkincareFragment(),"Skincare");
        viewPager.setAdapter(sectionsPagerAdapter);

//        int Dry = getArguments().getInt("Dry");
//        Toast.makeText(getActivity(), "Dry: "+Dry, Toast.LENGTH_SHORT).show();
    }
}