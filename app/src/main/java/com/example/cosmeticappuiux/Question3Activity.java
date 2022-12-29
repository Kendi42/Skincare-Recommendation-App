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

public class Question3Activity extends Question2Activity {
    private Button button2;
    private TextView textView7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        button2 = (Button)findViewById(R.id.button2);
        textView7 = (TextView) findViewById(R.id.textView7);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              checker();
            }
        });
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Question2Activity.class);
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
        final int[] dry3 = {q2.getIntExtra("dry", dry)};
        final int[] normal3 = {q2.getIntExtra("normal", normal)};
        final int[] oily3 = {q2.getIntExtra("oily", oily)};
        final int[] combo3 = {q2.getIntExtra("combination", combination)};
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
                oily3[0] = oily3[0] +1;
                setOily(oily3[0]);
                // Since we may have picked dry on the other page, we need to ensure that the value is set.
                // That way both values are updated since the main reading is being done from this page not the previous.
                setDry(dry3[0]);
                setNormal(normal3[0]);
                setCombination(combo3[0]);
            }
            else if(noButton.isChecked()){
                dry3[0] = dry3[0]+1;
                setOily(oily3[0]);
                // Since we may have picked oily on the other page, we need to ensure that the value is set.
                // That way both values are updated since the main reading is being done from this page not the previous.
                setNormal(normal3[0]);
                setDry(dry3[0]);
                setCombination(combo3[0]);
            }


            Intent intent = new Intent(getApplicationContext(),Question4Activity.class);
            intent.putExtra("dry",dry);
            intent.putExtra("oily",oily);
            intent.putExtra("combination",combination);
            intent.putExtra("normal",normal);
            startActivity(intent);
        }
    }
}