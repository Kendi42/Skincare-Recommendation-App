package com.example.cosmeticappuiux;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.HashMap;

public class Question2Activity extends Question1Activity {
    private Button button2;
    private TextView textView7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        button2 = (Button)findViewById(R.id.button2);
        textView7 = (TextView) findViewById(R.id.textView7);
        RadioButton yesButton = findViewById(R.id.radioButton);
        RadioButton noButton = findViewById(R.id.radioButton2);
        Intent q2 = getIntent();
        final int[] dry2 = {q2.getIntExtra("dry", dry)};
        final int[] normal2 = {q2.getIntExtra("normal", normal)};
        final int[] oily2 = {q2.getIntExtra("oily", oily)};
        final int[] combo2 = {q2.getIntExtra("combination", combination)};




        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              checker();
            }
        });
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Question1Activity.class);
                startActivity(intent);
            }
        });
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
    }
    public void checker()
    {
        RadioButton yesButton = findViewById(R.id.radioButton);
        RadioButton noButton = findViewById(R.id.radioButton2);
        Intent q2 = getIntent();
        final int[] dry2 = {q2.getIntExtra("dry", dry)};
        final int[] normal2 = {q2.getIntExtra("normal", normal)};
        final int[] oily2 = {q2.getIntExtra("oily", oily)};
        final int[] combo2 = {q2.getIntExtra("combination", combination)};



        if(yesButton.isChecked() && noButton.isChecked()) {
            yesButton.setChecked(false);
            noButton.setChecked(false);
            //Toast.makeText(this, "Please choose one radio button", Toast.LENGTH_SHORT).show();
            new AlertDialog.Builder(this).setTitle("Result")
                    .setMessage("Please choose one radio button for accurate results")
                    .setNeutralButton("Go back", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //back
                        }
                    }).show();
        }
        else{
            if (yesButton.isChecked())
            {
                dry2[0] = dry2[0] +1;
                setDry(dry2[0]);
                // Since we may have picked dry on the other page, we need to ensure that the value is set.
                // That way both values are updated since the main reading is being done from this page not the previous.
                setNormal(normal2[0]);
                setOily(oily2[0]);
                setCombination(combo2[0]);
            }
            else if(noButton.isChecked()){
                normal2[0] = normal2[0]+1;
                setDry(dry2[0]);
                // Since we may have picked oily on the other page, we need to ensure that the value is set.
                // That way both values are updated since the main reading is being done from this page not the previous.
                setNormal(normal2[0]);
                setOily(oily2[0]);
                setCombination(combo2[0]);
            }


            Intent intent = new Intent(getApplicationContext(),Question3Activity.class);
            intent.putExtra("dry",dry);
            intent.putExtra("oily",oily);
            intent.putExtra("combination",combination);
            intent.putExtra("normal",normal);
            startActivity(intent);
        }
    }
}