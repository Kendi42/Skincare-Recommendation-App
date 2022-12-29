package com.example.cosmeticappuiux;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MoreInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        Intent intent = getIntent();
        String value = getIntent().getStringExtra("choice");
        String word = getIntent().getStringExtra("word");
        ImageView picture = findViewById(R.id.img_moreinfo);
        Glide.with(this).load(value).into(picture);

        TextView home = findViewById(R.id.homebuttonmoreinfo);
        TextView back = findViewById(R.id.backarrow);
        TextView text = findViewById(R.id.tv_desription);
        TextView text2 = findViewById(R.id.tv_productnameTitle);

        text2.setText(word);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Recomendations.class);
                startActivity(intent);
            }
        });

    }
}