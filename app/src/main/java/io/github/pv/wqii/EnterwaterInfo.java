package io.github.pv.wqii;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class EnterwaterInfo extends AppCompatActivity {
    public static String avilableusestr="";
    public static String avilablesolstr="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterwater_info);
        CardView btnDisplay = (CardView) findViewById(R.id.next);
        EditText entertemp=findViewById(R.id.entertemp);
        entertemp.setFilters(new InputFilter[]{ new io.github.pv.wqii.InputFilterMinMax("0", "120.0")});
        EditText enterpH=findViewById(R.id.enterpH);
        enterpH.setFilters(new InputFilter[]{ new io.github.pv.wqii.InputFilterMinMax("0.0", "14.0")});
        EditText enterDO=findViewById(R.id.enterdissolvedoxygen);
        enterDO.setFilters(new InputFilter[]{ new io.github.pv.wqii.InputFilterMinMax("0.0", "120.0")});
        EditText enterconduct=findViewById(R.id.enterConductivity);
        enterconduct.setFilters(new InputFilter[]{ new io.github.pv.wqii.InputFilterMinMax("0", "25000")});
        EditText enterbio=findViewById(R.id.enterbiochemoxygen);
        enterbio.setFilters(new InputFilter[]{ new io.github.pv.wqii.InputFilterMinMax("0.0", "1000.0")});
        EditText enternitr=findViewById(R.id.enterNitrate);
        enternitr.setFilters(new InputFilter[]{ new io.github.pv.wqii.InputFilterMinMax("0.00", "500.00")});
        EditText enterfacel=findViewById(R.id.enterFacealColiform);
        enterfacel.setFilters(new InputFilter[]{ new io.github.pv.wqii.InputFilterMinMax("0.0", "5000.0")});
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        TextView availablesol=(TextView) findViewById(R.id.avilablesol);
        TextView availableusage=(TextView) findViewById(R.id.avilableusage);
        if(pref.getString("Language", "").equals("Hindi"))
        {
            TextView Enterdetails=(TextView) findViewById(R.id.enterdetails);
            Enterdetails.setText("उपलब्ध पानी का विवरण दर्ज करें");
            TextView temp=(TextView) findViewById(R.id.temp);
            temp.setText("तापमान\n(डिग्री सेल्सियस)");
            TextView Dissolvedoxygen=(TextView) findViewById(R.id.dissolvedoxygen);
            Dissolvedoxygen.setMaxLines(3);
            Dissolvedoxygen.setTextSize(20);
            Dissolvedoxygen.setText("घुलित ऑक्सीजन\n(मिलीग्राम/लीटर)\n>5.0 मिलीग्राम/लीटर");
            TextView pH=(TextView) findViewById(R.id.pH);
            pH.setText("पीएच\n(6.5 - 8.5)");
            TextView Conductivity=(TextView) findViewById(R.id.Conductivity);
            Conductivity.setText("चालकता\n(उम्हो/सेमी)");
            TextView Biochemicaloxygen=(TextView) findViewById(R.id.Biochemoxygen);
            Biochemicaloxygen.setMaxLines(4);
            Biochemicaloxygen.setText("जैव रासायनिक ऑक्सीजन\nमांग (मिलीग्राम/लीटर)\n<3.0 मिलीग्राम/लीटर");
            TextView Nitrate=(TextView) findViewById(R.id.Nitrate);
            Nitrate.setText("नाइट्रेट\n(मिलीग्राम/लीटर)");
            TextView Facelcoliform=(TextView) findViewById(R.id.Facealcoliform);
            Facelcoliform.setMaxLines(4);
            Facelcoliform.setTextSize(18);
            Facelcoliform.setText("फेसियल कॉलीफॉर्म\n(एमपीएन/100मिलीलीटर)\n<2500 एमपीएन/100मिलीलीटर");
            TextView nexttext=(TextView) findViewById(R.id.nexttext);
            nexttext.setText("विवरण दर्ज करें");


        }

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                availablesol.setText("");
                availableusage.setText("");
                avilableusestr="";
                avilablesolstr="";
                if(!enterbio.getText().toString().isEmpty()&&!enterpH.getText().toString().isEmpty()&& !entertemp.getText().toString().isEmpty()&& !enternitr.getText().toString().isEmpty()&& !enterfacel.getText().toString().isEmpty()&& !enterconduct.getText().toString().isEmpty()&& !enterDO.getText().toString().isEmpty())

                {
                    float temp,ph,Cond,Do,bio,nitr,fc;
                    temp =Float.parseFloat(entertemp.getText().toString());
                    ph =Float.parseFloat(enterpH.getText().toString());
                    Cond =Float.parseFloat(enterconduct.getText().toString());
                    Do =Float.parseFloat(enterDO.getText().toString());
                    nitr =Float.parseFloat(enternitr.getText().toString());
                    bio =Float.parseFloat(enterbio.getText().toString());
                    fc =Float.parseFloat(enterfacel.getText().toString());
                    if(temp>=6&&temp<=43 && Do>=6.5&&Do<=10 && ph>=6.5&&ph<=8.5 && Cond>=200&&Cond<=800 && bio<=1 &&nitr<=10 && fc<=10)
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilableusestr+= "पीने, ";
                        else
                        avilableusestr+="Drinking, ";
                    }
                    else
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilablesolstr+= "• पीने के लिए ";
                        else
                        avilablesolstr+="• For Drinking ";
                        if(!(temp>=6&&temp<=43))
                        {
                            if(pref.getString("Language", "").equals("Hindi"))
                                avilablesolstr+= "तापमान उपयुक्त नहीं है, ";
                            else
                            avilablesolstr+="The temperature is not suitable, ";}
                        if(!(Do>=6.5&&Do<=8))
                        {
                            if(pref.getString("Language", "").equals("Hindi"))
                                avilablesolstr+= "घुलित ऑक्सीजन उपयुक्त नहीं है, ";
                            else
                            avilablesolstr+="The Dissolved oxygen is not suitable, ";}
                        if(!(ph>=6.5&&ph<=8.5))
                        {
                            if(pref.getString("Language", "").equals("Hindi"))
                                avilablesolstr+= "पीएच उपयुक्त नहीं है, ";
                            else
                            avilablesolstr+="The pH is not suitable, ";}
                        if(!(Cond>=200&&Cond<=800))
                        {
                            if(pref.getString("Language", "").equals("Hindi"))
                                avilablesolstr+= "चालकता उपयुक्त नहीं है, ";
                            else
                            avilablesolstr+="The Conductivity is not suitable, ";}
                        if(!(bio<=1))
                        {
                            if(pref.getString("Language", "").equals("Hindi"))
                                avilablesolstr+= "जैव-रासायनिक ऑक्सीजन की मांग उपयुक्त नहीं है, ";
                            else
                            avilablesolstr+="The Bio-Chemical Oxygen Demand is not suitable, ";}
                        if(!(nitr<=10))
                        {
                            if(pref.getString("Language", "").equals("Hindi"))
                                avilablesolstr+= "नाइट्रेट उपयुक्त नहीं है, ";
                            else
                            avilablesolstr+="The Nitrate is not suitable, ";}
                        if(!(fc<=10))
                        {
                            if(pref.getString("Language", "").equals("Hindi"))
                                avilablesolstr+= "फेसियल कॉलिफॉर्म उपयुक्त नहीं है, ";
                            else
                                avilablesolstr+="The Faceal Coliform is not suitable, ";}


                    }

                    //Agriculture
                    if(Do>=5&&Do<=10 && ph>=5&&ph<=9 && Cond>=500&&Cond<=2500 && bio<=200 && nitr<=50 && fc<=1000)
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilableusestr+= "कृषि, ";
                        else
                        avilableusestr+="Agriculture, ";
                    }
                    else
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilablesolstr+= "\n• कृषि के लिए ";
                        else
                        avilablesolstr+="\n• For Agriculture ";
                        if(!(Do>=5&&Do<=10))
                        {
                            if(pref.getString("Language", "").equals("Hindi"))
                                avilablesolstr+= "घुलित ऑक्सीजन उपयुक्त नहीं है, ";
                            else
                            avilablesolstr+="The Dissolved oxygen is not suitable, ";}
                        if(!(ph>=5&&ph<=9))
                        {
                            if(pref.getString("Language", "").equals("Hindi"))
                                avilablesolstr+= "पीएच उपयुक्त नहीं है, ";
                            else
                            avilablesolstr+="The pH is not suitable, ";}
                        if(!(Cond>=500&&Cond<=2500))
                        {
                            if(pref.getString("Language", "").equals("Hindi"))
                                avilablesolstr+= "चालकता उपयुक्त नहीं है, ";
                            else
                            avilablesolstr+="The Conductivity is not suitable, ";}
                        if(!(bio<=200))
                        {
                            if(pref.getString("Language", "").equals("Hindi"))
                                avilablesolstr+= "जैव-रासायनिक ऑक्सीजन की मांग उपयुक्त नहीं है, ";
                            else
                            avilablesolstr+="The Bio-Chemical Oxygen Demand is not suitable, ";}
                        if(!(nitr<=50))
                        {
                            if(pref.getString("Language", "").equals("Hindi"))
                                avilablesolstr+= "नाइट्रेट उपयुक्त नहीं है, ";
                            else
                            avilablesolstr+="The Nitrate is not suitable, ";}
                        if(!(fc<=1000))
                        {
                            if(pref.getString("Language", "").equals("Hindi"))
                                avilablesolstr+= "फेसियल कॉलिफॉर्म उपयुक्त नहीं है, ";
                            else
                            avilablesolstr+="The Faceal Coliform is not suitable, ";}

                    }
                    //Bathing
                    if(temp>=25 && temp<=43 && ph>=5.5&&ph<=7.5 && bio<=5 && nitr<=35 && fc<=500)
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilableusestr+= "नहाना, ";
                        else
                        avilableusestr+="Bathing, ";
                    }
                    else
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilablesolstr+= "\n• नहाना के लिए ";
                        else
                        avilablesolstr+="\n• For Bathing ";

                        if(!(temp>=25&&temp<=43))
                        {
                            if(pref.getString("Language", "").equals("Hindi"))
                                avilablesolstr+= "तापमान उपयुक्त नहीं है, ";
                            else
                            avilablesolstr+="The temperature is not suitable, ";}
                        if(!(ph>=5.5&&ph<=7.5))
                        {
                            if(pref.getString("Language", "").equals("Hindi"))
                                avilablesolstr+= "पीएच उपयुक्त नहीं है, ";
                            else
                            avilablesolstr+="The pH is not suitable, ";}
                        if(!(bio<=5))
                        {
                            if(pref.getString("Language", "").equals("Hindi"))
                                avilablesolstr+= "जैव-रासायनिक ऑक्सीजन की मांग उपयुक्त नहीं है, ";
                            else
                            avilablesolstr+="The Bio-Chemical Oxygen Demand is not suitable, ";}
                        if(!(nitr<=50))
                        {
                            if(pref.getString("Language", "").equals("Hindi"))
                                avilablesolstr+= "नाइट्रेट उपयुक्त नहीं है, ";
                            else
                            avilablesolstr+="The Nitrate is not suitable, ";}
                        if(!(fc<=500))
                        {
                            if(pref.getString("Language", "").equals("Hindi"))
                                avilablesolstr+= "फेसियल कॉलिफॉर्म उपयुक्त नहीं है, ";
                            else
                            avilablesolstr+="The Faceal Coliform is not suitable, ";}

                    }
                    //Washing
                    if(temp>=15 && temp<=95 && ph>=6.5&&ph<=8.5 && bio<=5 && nitr<=35 && fc<=500)
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilableusestr+= "धुलाई, ";
                        else
                        avilableusestr+="Washing, ";
                    }
                    else
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilablesolstr+= "\n• धुलाई के लिए ";
                        else
                        avilablesolstr+="\n• For Washing ";

                        if(!(temp>=15&&temp<=95))
                        {
                            if(pref.getString("Language", "").equals("Hindi"))
                                avilablesolstr+= "तापमान उपयुक्त नहीं है, ";
                            else
                            avilablesolstr+="The temperature is not suitable, ";}
                        if(!(ph>=6.5&&ph<=8.5))
                        {
                            if(pref.getString("Language", "").equals("Hindi"))
                                avilablesolstr+= "पीएच उपयुक्त नहीं है, ";
                            else
                            avilablesolstr+="The pH is not suitable, ";}
                        if(!(bio<=5))
                        {
                            if(pref.getString("Language", "").equals("Hindi"))
                                avilablesolstr+= "जैव-रासायनिक ऑक्सीजन की मांग उपयुक्त नहीं है, ";
                            else
                            avilablesolstr+="The Bio-Chemical Oxygen Demand is not suitable, ";}
                        if(!(nitr<=50))
                        {
                            if(pref.getString("Language", "").equals("Hindi"))
                                avilablesolstr+= "नाइट्रेट उपयुक्त नहीं है, ";
                            else
                            avilablesolstr+="The Nitrate is not suitable, ";}
                        if(!(fc<=500))
                        {
                            if(pref.getString("Language", "").equals("Hindi"))
                                avilablesolstr+= "फेसियल कॉलिफॉर्म उपयुक्त नहीं है, ";
                            else
                            avilablesolstr+="The Faceal Coliform is not suitable, ";}

                    }
                    if(avilableusestr.isEmpty())
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilableusestr+= "कृपया किसी भी उद्देश्य के लिए पानी का उपयोग न करें ";
                        else
                        avilableusestr="Please do not use the water for any purpose ";}
                    else
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilableusestr= "पानी का उपयोग के लिए किया जा सकता है "+avilableusestr;
                        else
                        avilableusestr="The water can be used for "+avilableusestr;
                    }
                    availableusage.setText(avilableusestr);
                    availablesol.setText(avilablesolstr);



                LinearLayout info=(LinearLayout) findViewById(R.id.waterinfo);
                info.setVisibility(View.VISIBLE);
                }
                else {
                    if(pref.getString("Language", "").equals("Hindi"))
                        Toast.makeText(getApplicationContext(), "कृपया सभी मानों को ठीक से भरें", Toast.LENGTH_SHORT).show();

                    else
                    Toast.makeText(getApplicationContext(), "Please fill in all the values properly", Toast.LENGTH_SHORT).show();
                }

                try {
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        });
    }
}