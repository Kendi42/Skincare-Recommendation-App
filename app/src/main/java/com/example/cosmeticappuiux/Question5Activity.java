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

public class Question5Activity extends Question4Activity {
    private Button button2;
    private TextView textView7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);

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
                Intent intent = new Intent(getApplicationContext(),Question4Activity.class);
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
        final int[] dry5 = {q2.getIntExtra("dry", dry)};
        final int[] normal5 = {q2.getIntExtra("normal", normal)};
        final int[] oily5 = {q2.getIntExtra("oily", oily)};
        final int[] combo5 = {q2.getIntExtra("combination", combination)};
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
                oily5[0] = oily5[0] +1;
                setOily(oily5[0]);
                setDry(dry5[0]);
                setNormal(normal5[0]);
                setCombination(combo5[0]);
            }
            else if(noButton.isChecked()){
                dry5[0] = dry5[0]+1;
                setOily(oily5[0]);
                // Since we may have picked oily on the other page, we need to ensure that the value is set.
                // That way both values are updated since the main reading is being done from this page not the previous.
                setNormal(normal5[0]);
                setDry(dry5[0]);
                setCombination(combo5[0]);
            }

          /* new AlertDialog.Builder(this).setTitle("Result")
                    .setMessage("Dry skin: "+getDry()+"\n"+"Oily skin: "+getOily()+"\n"+"Normal skin:"+getNormal()+"\n"+"Combination skin:"+getCombination())
                    .setNeutralButton("Go back", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //back
                        }
                    }).show();*/

            int resultOily = getOily();
            int resultNormal = getNormal();
            int resultDry = getDry();
            int resultCombo = getCombination();

            if(resultOily> resultNormal && resultOily>resultDry && resultOily>resultCombo)
            {
                Intent intent = new Intent(getApplicationContext(),OilySkinResultPage.class);
                //Create the bundle
                Bundle Type = new Bundle();
                Type.putInt("Oily", oily);
                Type.putInt("Normal", normal);
                Type.putInt("Dry", dry);
                Type.putInt("Combo",combination);
                intent.putExtras(Type);
                startActivity(intent);

            }
            else if(resultNormal>resultDry && resultNormal>resultOily && resultNormal>resultCombo)
            {
                Intent intent = new Intent(getApplicationContext(),NormalSkinResultPage.class);
                startActivity(intent);
            }
            else if(resultDry > resultOily && resultDry > resultNormal && resultDry > resultCombo)
            {
                Intent dryskin = new Intent(this,DrySkinResultPage.class);
                startActivity(dryskin);

            }
            else{
                Intent intent = new Intent(getApplicationContext(),CombinationSkinResultPage.class);
                startActivity(intent);
            }

        }
    }
}