package com.example.cosmeticappuiux;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class NormalSkinResultPage extends AppCompatActivity {
    Button btn_recsNormalSkin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_skin_result_page);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        btn_recsNormalSkin = findViewById(R.id.btn_recsNormalSkin);

        btn_recsNormalSkin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Recomendations.class);
                startActivity(intent);
            }
        });
    }
}