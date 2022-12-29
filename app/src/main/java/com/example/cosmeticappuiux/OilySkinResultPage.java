package com.example.cosmeticappuiux;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class OilySkinResultPage extends AppCompatActivity {
    Button btn_recsOilySkin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oily_skin);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
        btn_recsOilySkin =findViewById(R.id.btn_recsOilySkin);

//        Bundle data = getIntent().getExtras();
//        int dry = data.getInt("Dry");
//        int normal = data.getInt("Normal");
//        int oily = data.getInt("Oily");
//        int combinational = data.getInt("Combo");
//
//        Toast.makeText(this, "Dry: "+dry, Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "Oily: "+oily, Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "Combinational: "+combinational, Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "Normal: "+normal, Toast.LENGTH_SHORT).show();


        btn_recsOilySkin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Recomendations.class);
                //Fragment blue = new Fragment();
//                Bundle Type = new Bundle();
//                Type.putInt("Oily", oily);
//                Type.putInt("Normal", normal);
//                Type.putInt("Dry", dry);
//                Type.putInt("Combo",combinational);
               // blue.setArguments(Type);
              //  intent.putExtras(Type);
                startActivity(intent);

            }
        });

    }
}