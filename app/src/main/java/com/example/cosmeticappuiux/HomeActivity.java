package com.example.cosmeticappuiux;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        button1 = (Button)findViewById(R.id.button);
        Spinner spinnerSkin_types=findViewById(R.id.spinner_skin_type);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.skin_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerSkin_types.setAdapter(adapter);
        spinnerSkin_types.setOnItemSelectedListener(this);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Question1Activity.class);
                startActivity(intent);
            }
        });

        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // An item was selected. You can retrieve the selected item using
        String text = parent.getItemAtPosition(position).toString();
        if("Normal".equals(text))
        {
            Intent intent = new Intent(getApplicationContext(),NormalSkinResultPage.class);
            startActivity(intent);
        }
        else if("Dry".equals(text))
        {
            Intent intent = new Intent(getApplicationContext(),DrySkinResultPage.class);
            startActivity(intent);
        }
        else if("Oily".equals(text))
        {
            Intent intent = new Intent(getApplicationContext(),OilySkinResultPage.class);
            startActivity(intent);
        }
        else if("Combination".equals(text))
        {
            Intent intent = new Intent(getApplicationContext(),CombinationSkinResultPage.class);
            startActivity(intent);
        }
    }

    public void onNothingSelected(AdapterView<?> parent){

    }

}