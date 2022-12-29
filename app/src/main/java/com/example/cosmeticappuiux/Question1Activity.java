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

public class Question1Activity extends AppCompatActivity {
    private Button button2;
    private TextView textView7;
    int dry = 0;
    int oily =0;
    int combination =0;
    int normal=0;
    int value1;
    int value2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        button2 = (Button)findViewById(R.id.button2);
        textView7 = (TextView) findViewById(R.id.textView7);
        RadioButton yesButton = findViewById(R.id.radioButton);
        RadioButton noButton = findViewById(R.id.radioButton2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checker();

            }
        });
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
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
                oily = 0;
                dry=1;
                normal=0;
                combination=0;
                setOily(oily);
                setDry(dry);
                setNormal(normal);
                setCombination(combination);

            }
            else if(noButton.isChecked()){
                dry = 0;
                oily=0;
                normal=1;
                combination=0;
                setOily(oily);
                setDry(dry);
                setNormal(normal);
                setCombination(combination);
            }


            Intent intent = new Intent(getApplicationContext(),Question2Activity.class);
            intent.putExtra("dry",dry);
            intent.putExtra("oily",oily);
            intent.putExtra("combination",combination);
            intent.putExtra("normal",normal);
            startActivity(intent);
        }
    }

    public void setDry(int dry) {
        this.dry = dry;
    }
    public void setOily(int oily) {
        this.oily = oily;
    }
    public void setNormal(int normal) {
        this.normal = normal;
    }
    public void setCombination(int combination) {
        this.combination = combination;
    }
    public int getDry() {
        return dry;
    }

    public int getOily() {
        return oily;
    }
    public int getCombination() {
        return combination;
    }
    public int getNormal() {
        return normal;
    }

}