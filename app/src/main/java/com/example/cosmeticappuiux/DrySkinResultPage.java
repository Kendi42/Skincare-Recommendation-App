package com.example.cosmeticappuiux;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class DrySkinResultPage extends AppCompatActivity {
    Button btn_recsDrySkin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dry_skin_result_page);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        btn_recsDrySkin = findViewById(R.id.btn_recsDrySkin);

        btn_recsDrySkin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Recomendations.class);
                startActivity(intent);
            }
        });
    }
}
