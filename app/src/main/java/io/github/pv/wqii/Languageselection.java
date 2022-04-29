package io.github.pv.wqii;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Languageselection extends AppCompatActivity {

    private RadioButton radioenglishButton;
    private RadioButton radiohindiButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languageselection);
        CardView btnDisplay = (CardView) findViewById(R.id.next);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        if(pref.getInt("Previousdata",0)!=0)
        {
            Intent intent1 = new Intent(getApplicationContext(), io.github.pv.wqii.Locationselection.class);
            startActivity(intent1);
            finish();

        }
        radioenglishButton =(RadioButton)findViewById(R.id.en);
        if(pref.getString("Language", "").equals("Hindi"))
        {
            TextView languageask=(TextView) findViewById(R.id.languagequestion);
            languageask.setText("कृपया कोई एक भाषा चुनें:");
            TextView nexttext=(TextView) findViewById(R.id.nexttext);
            nexttext.setText("अगला");


            radiohindiButton=(RadioButton)findViewById(R.id.hin);
            radioenglishButton.setChecked(false);
            radiohindiButton.setChecked(true);

        }


        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(radioenglishButton.isChecked())
                {
                    editor.putInt("Previousdata", 1);
                    editor.putString("Language", "English");

                }
                else
                {
                    editor.putInt("Previousdata", 1);
                    editor.putString("Language", "Hindi");

                }

                editor.putInt("Firststart", 1);
                editor.apply();
                Intent intent1 = new Intent(getApplicationContext(), io.github.pv.wqii.Locationselection.class);
                startActivity(intent1);
                finish();

            }
        });

    }
    @Override
    public void onBackPressed() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        if(pref.getInt("Firststart",0)==0) {
            finish();
        }

        else {
            editor.putInt("Previousdata", 1);
            editor.apply();
            Intent intent1 = new Intent(getApplicationContext(), io.github.pv.wqii.Locationselection.class);
            startActivity(intent1);
            finish();
        }

    }
}