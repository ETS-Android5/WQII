package io.github.pv.wqii;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Locationselection extends AppCompatActivity {

   public static String avilableuse="";
   public static String avilablesol="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locationselection);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.selectlocation);



        String[] locations;
        if(!pref.getString("Language", "").equals("Hindi")) {
            locations = getResources().getStringArray(R.array.locationarray);
            autoCompleteTextView.setHint("Please select/search your location");
        }
        else {
            TextView max1=(TextView)findViewById(R.id.max1);
            max1.setText("अधिकतम");
            TextView max2=(TextView)findViewById(R.id.max2);
            max2.setText("अधिकतम");
            TextView max3=(TextView)findViewById(R.id.max3);
            max3.setText("अधिकतम");
            TextView max4=(TextView)findViewById(R.id.max4);
            max4.setText("अधिकतम");
            TextView max5=(TextView)findViewById(R.id.max5);
            max5.setText("अधिकतम");
            TextView max6=(TextView)findViewById(R.id.max6);
            max6.setText("अधिकतम");
            TextView max7=(TextView)findViewById(R.id.max7);
            max7.setText("अधिकतम");
            TextView max8=(TextView)findViewById(R.id.max8);
            max8.setText("अधिकतम");
            TextView min1=(TextView)findViewById(R.id.min1);
            min1.setText("न्यूनतम");
            TextView min2=(TextView)findViewById(R.id.min2);
            min2.setText("न्यूनतम");
            TextView min3=(TextView)findViewById(R.id.min3);
            min3.setText("न्यूनतम");
            TextView min4=(TextView)findViewById(R.id.min4);
            min4.setText("न्यूनतम");
            TextView min5=(TextView)findViewById(R.id.min5);
            min5.setText("न्यूनतम");
            TextView min6=(TextView)findViewById(R.id.min6);
            min6.setText("न्यूनतम");
            TextView min7=(TextView)findViewById(R.id.min7);
            min7.setText("न्यूनतम");
            TextView min8=(TextView)findViewById(R.id.min8);
            min8.setText("न्यूनतम");
            locations = getResources().getStringArray(R.array.HindiLocationnames);
            TextView hindiask=(TextView) findViewById(R.id.avilablelocation);
            hindiask.setText("उपलब्ध सूची में से स्थान चुनें/खोजें");
            autoCompleteTextView.setHint("कृपया अपना स्थान चुनें/खोजें");
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
            TextView TF=(TextView) findViewById(R.id.totalcoliform);
            TF.setMaxLines(2);
            TF.setTextSize(20);
            TF.setText("कुल कॉलीफॉर्म \n (एमपीएन/100 एमएल)");
        }


        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.droupdown,locations);
        autoCompleteTextView.setAdapter(arrayAdapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

               String item=adapterView.getItemAtPosition(i).toString();
                int x = item.indexOf(',');
                String word = item.substring(0, x);
                TextView tempraturemin=findViewById(R.id.tempmin);
                TextView tempraturemax=findViewById(R.id.tempmax);
                TextView Dissolvedoxygenmin=findViewById(R.id.dissolvedoxygenmin);
                TextView Dissolvedoxygenmax=findViewById(R.id.dissolvedoxygenmax);
                TextView pHmin=findViewById(R.id.pHmin);
                TextView pHmax=findViewById(R.id.pHmax);
                TextView Conductivitymin=findViewById(R.id.Conductivitymin);
                TextView Conductivitymax=findViewById(R.id.Conductivitymax);
                TextView biochemicaloxygenmin=findViewById(R.id.Biochemoxygenmin);
                TextView biochemicaloxygenmax=findViewById(R.id.Biochemoxygenmax);
                TextView Nitratemin=findViewById(R.id.Nitratemin);
                TextView Nitratemax=findViewById(R.id.Nitratemax);
                TextView FacealColiformmin=findViewById(R.id.Facealcoliformmin);
                TextView FacealColiformmax=findViewById(R.id.Facealcoliformmax);
                TextView TotalColiformmin=findViewById(R.id.totalcoliformmin);
                TextView TotalColiformmax=findViewById(R.id.totalcoliformmax);
                TextView avilableusetext=findViewById(R.id.avilableusage);
                TextView avilablesolutiontext=findViewById(R.id.avilablesol);
                ImageView mapview=findViewById(R.id.mapview);
                    avilablesolutiontext.setText("");
                    avilableuse="";
                    avilablesol="";
                    avilableusetext.setText("");

                switch (word) {
                    case "1491":
                        tempraturemin.setText("");
                        tempraturemax.setText("");
                        Dissolvedoxygenmin.setText("9.8");
                        Dissolvedoxygenmax.setText("9.8");
                        pHmin.setText("");
                        pHmax.setText("");
                        Conductivitymin.setText("");
                        Conductivitymax.setText("");
                        biochemicaloxygenmin.setText("");
                        biochemicaloxygenmax.setText("");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("7");
                        FacealColiformmax.setText("7");
                        TotalColiformmin.setText("9");
                        TotalColiformmax.setText("9");
                        mapview.setImageResource(R.drawable.sc1491);
                        break;
                    case "1485":
                        tempraturemin.setText("17");
                        tempraturemax.setText("18");
                        Dissolvedoxygenmin.setText("9.4");
                        Dissolvedoxygenmax.setText("9.8");
                        pHmin.setText("7.8");
                        pHmax.setText("7.9");
                        Conductivitymin.setText("");
                        Conductivitymax.setText("");
                        biochemicaloxygenmin.setText("1");
                        biochemicaloxygenmax.setText("1");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("1.8");
                        FacealColiformmax.setText("2");
                        TotalColiformmin.setText("1.8");
                        TotalColiformmax.setText("2");
                        mapview.setImageResource(R.drawable.sc1485);
                        break;
                    case "1484":
                        tempraturemin.setText("17");
                        tempraturemax.setText("19");
                        Dissolvedoxygenmin.setText("9.6");
                        Dissolvedoxygenmax.setText("10.2");
                        pHmin.setText("7.6");
                        pHmax.setText("7.8");
                        Conductivitymin.setText("");
                        Conductivitymax.setText("");
                        biochemicaloxygenmin.setText("1");
                        biochemicaloxygenmax.setText("1");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("1.8");
                        FacealColiformmax.setText("2");
                        TotalColiformmin.setText("NA");
                        TotalColiformmax.setText("2");
                        mapview.setImageResource(R.drawable.sc14841486);
                        break;
                    case "1486":
                        tempraturemin.setText("16");
                        tempraturemax.setText("18");
                        Dissolvedoxygenmin.setText("9.2");
                        Dissolvedoxygenmax.setText("10.2");
                        pHmin.setText("7.7");
                        pHmax.setText("7.8");
                        Conductivitymin.setText("");
                        Conductivitymax.setText("");
                        biochemicaloxygenmin.setText("1");
                        biochemicaloxygenmax.setText("1");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("1.8");
                        FacealColiformmax.setText("2");
                        TotalColiformmin.setText("NA");
                        TotalColiformmax.setText("2");
                        mapview.setImageResource(R.drawable.sc14841486);
                        break;
                    case "1488":
                        tempraturemin.setText("17");
                        tempraturemax.setText("18");
                        Dissolvedoxygenmin.setText("9.4");
                        Dissolvedoxygenmax.setText("10.2");
                        pHmin.setText("7.6");
                        pHmax.setText("8");
                        Conductivitymin.setText("");
                        Conductivitymax.setText("");
                        biochemicaloxygenmin.setText("1");
                        biochemicaloxygenmax.setText("1");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("1.8");
                        FacealColiformmax.setText("2");
                        TotalColiformmin.setText("NA");
                        TotalColiformmax.setText("2");
                        mapview.setImageResource(R.drawable.sc148814871489);
                        break;
                    case "1487":
                        tempraturemin.setText("17");
                        tempraturemax.setText("19");
                        Dissolvedoxygenmin.setText("9.2");
                        Dissolvedoxygenmax.setText("10");
                        pHmin.setText("7.6");
                        pHmax.setText("7.9");
                        Conductivitymin.setText("");
                        Conductivitymax.setText("");
                        biochemicaloxygenmin.setText("1");
                        biochemicaloxygenmax.setText("1");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("1.8");
                        FacealColiformmax.setText("2");
                        TotalColiformmin.setText("NA");
                        TotalColiformmax.setText("2");
                        mapview.setImageResource(R.drawable.sc148814871489);
                        break;
                    case "1489":
                        tempraturemin.setText("17");
                        tempraturemax.setText("19");
                        Dissolvedoxygenmin.setText("9.6");
                        Dissolvedoxygenmax.setText("10");
                        pHmin.setText("7.8");
                        pHmax.setText("8");
                        Conductivitymin.setText("");
                        Conductivitymax.setText("");
                        biochemicaloxygenmin.setText("1");
                        biochemicaloxygenmax.setText("1");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("1.8");
                        FacealColiformmax.setText("2");
                        TotalColiformmin.setText("NA");
                        TotalColiformmax.setText("2");
                        mapview.setImageResource(R.drawable.sc148814871489);
                        break;
                    case "20048":
                        tempraturemin.setText("19");
                        tempraturemax.setText("21");
                        Dissolvedoxygenmin.setText("9.2");
                        Dissolvedoxygenmax.setText("10.2");
                        pHmin.setText("7.9");
                        pHmax.setText("8.1");
                        Conductivitymin.setText("105");
                        Conductivitymax.setText("292");
                        biochemicaloxygenmin.setText("1");
                        biochemicaloxygenmax.setText("1");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("40");
                        FacealColiformmax.setText("60");
                        TotalColiformmin.setText("110");
                        TotalColiformmax.setText("170");
                        mapview.setImageResource(R.drawable.sc20048);
                        break;
                    case "1060":
                        tempraturemin.setText("16");
                        tempraturemax.setText("20");
                        Dissolvedoxygenmin.setText("9.8");
                        Dissolvedoxygenmax.setText("11.8");
                        pHmin.setText("7.4");
                        pHmax.setText("8.2");
                        Conductivitymin.setText("114");
                        Conductivitymax.setText("125");
                        biochemicaloxygenmin.setText("1");
                        biochemicaloxygenmax.setText("1");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("14");
                        FacealColiformmax.setText("30");
                        TotalColiformmin.setText("40");
                        TotalColiformmax.setText("401");
                        mapview.setImageResource(R.drawable.sc1060);
                        break;
                    case "20049":
                        tempraturemin.setText("19");
                        tempraturemax.setText("28");
                        Dissolvedoxygenmin.setText("8.8");
                        Dissolvedoxygenmax.setText("10.2");
                        pHmin.setText("7.8");
                        pHmax.setText("8.4");
                        Conductivitymin.setText("");
                        Conductivitymax.setText("390");
                        biochemicaloxygenmin.setText("1");
                        biochemicaloxygenmax.setText("1");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("40");
                        FacealColiformmax.setText("70");
                        TotalColiformmin.setText("9");
                        TotalColiformmax.setText("170");
                        mapview.setImageResource(R.drawable.sc20049);
                        break;
                    case "10147":
                        tempraturemin.setText("16");
                        tempraturemax.setText("22");
                        Dissolvedoxygenmin.setText("9");
                        Dissolvedoxygenmax.setText("11.2");
                        pHmin.setText("7.3");
                        pHmax.setText("8.2");
                        Conductivitymin.setText("97");
                        Conductivitymax.setText("154");
                        biochemicaloxygenmin.setText("1");
                        biochemicaloxygenmax.setText("1");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("26");
                        FacealColiformmax.setText("40");
                        TotalColiformmin.setText("50");
                        TotalColiformmax.setText("90");
                        mapview.setImageResource(R.drawable.sc10147);
                        break;
                    case "2725":
                        tempraturemin.setText("16");
                        tempraturemax.setText("25");
                        Dissolvedoxygenmin.setText("8.6");
                        Dissolvedoxygenmax.setText("10.4");
                        pHmin.setText("7.4");
                        pHmax.setText("8.4");
                        Conductivitymin.setText("308");
                        Conductivitymax.setText("400");
                        biochemicaloxygenmin.setText("1");
                        biochemicaloxygenmax.setText("1.2");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("50");
                        FacealColiformmax.setText("130");
                        TotalColiformmin.setText("110");
                        TotalColiformmax.setText("280");
                        mapview.setImageResource(R.drawable.sc2725);
                        break;
                    case "10148":
                        mapview.setImageResource(R.drawable.sc10148);
                        tempraturemin.setText("17");
                        tempraturemax.setText("22");
                        Dissolvedoxygenmin.setText("9");
                        Dissolvedoxygenmax.setText("10.2");
                        pHmin.setText("7.5");
                        pHmax.setText("8.4");
                        Conductivitymin.setText("121");
                        Conductivitymax.setText("155");
                        biochemicaloxygenmin.setText("1");
                        biochemicaloxygenmax.setText("1");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("26");
                        FacealColiformmax.setText("50");
                        TotalColiformmin.setText("40");
                        TotalColiformmax.setText("110");
                        break;
                    case "1061":
                        mapview.setImageResource(R.drawable.sc1061);
                        tempraturemin.setText("16");
                        tempraturemax.setText("22");
                        Dissolvedoxygenmin.setText("8.6");
                        Dissolvedoxygenmax.setText("9.4");
                        pHmin.setText("7.1");
                        pHmax.setText("8");
                        Conductivitymin.setText("173");
                        Conductivitymax.setText("231");
                        biochemicaloxygenmin.setText("1");
                        biochemicaloxygenmax.setText("2");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("70");
                        FacealColiformmax.setText("220");
                        TotalColiformmin.setText("130");
                        TotalColiformmax.setText("350");
                        break;
                    case "2727":
                        mapview.setImageResource(R.drawable.sc2727);
                        tempraturemin.setText("16");
                        tempraturemax.setText("20");
                        Dissolvedoxygenmin.setText("8.6");
                        Dissolvedoxygenmax.setText("10");
                        pHmin.setText("7.4");
                        pHmax.setText("8.3");
                        Conductivitymin.setText("");
                        Conductivitymax.setText("143");
                        biochemicaloxygenmin.setText("1");
                        biochemicaloxygenmax.setText("1.2");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("40");
                        FacealColiformmax.setText("90");
                        TotalColiformmin.setText("110");
                        TotalColiformmax.setText("170");
                        break;
                    case "10150":
                        mapview.setImageResource(R.drawable.sc10150);
                        tempraturemin.setText("");
                        tempraturemax.setText("");
                        Dissolvedoxygenmin.setText("7.5");
                        Dissolvedoxygenmax.setText("9.7");
                        pHmin.setText("7.4");
                        pHmax.setText("7.7");
                        Conductivitymin.setText("62");
                        Conductivitymax.setText("253");
                        biochemicaloxygenmin.setText("1.3");
                        biochemicaloxygenmax.setText("1.8");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("");
                        FacealColiformmax.setText("");
                        TotalColiformmin.setText("");
                        TotalColiformmax.setText("");
                        break;
                    case "1062":
                        mapview.setImageResource(R.drawable.sc106210149);
                        tempraturemin.setText("16.5");
                        tempraturemax.setText("26");
                        Dissolvedoxygenmin.setText("7.5");
                        Dissolvedoxygenmax.setText("10.5");
                        pHmin.setText("6.8");
                        pHmax.setText("7.7");
                        Conductivitymin.setText("155");
                        Conductivitymax.setText("266");
                        biochemicaloxygenmin.setText("0.9");
                        biochemicaloxygenmax.setText("2.8");
                        Nitratemin.setText("0.33");
                        Nitratemax.setText("0.82");
                        FacealColiformmin.setText("220");
                        FacealColiformmax.setText("1700");
                        TotalColiformmin.setText("540");
                        TotalColiformmax.setText("3500");
                        break;
                    case "10149":
                        mapview.setImageResource(R.drawable.sc106210149);
                        tempraturemin.setText("16");
                        tempraturemax.setText("26");
                        Dissolvedoxygenmin.setText("7.3");
                        Dissolvedoxygenmax.setText("11.5");
                        pHmin.setText("6.5");
                        pHmax.setText("7.6");
                        Conductivitymin.setText("163");
                        Conductivitymax.setText("256");
                        biochemicaloxygenmin.setText("0.6");
                        biochemicaloxygenmax.setText("2.1");
                        Nitratemin.setText("0.25");
                        Nitratemax.setText("0.85");
                        FacealColiformmin.setText("110");
                        FacealColiformmax.setText("1100");
                        TotalColiformmin.setText("240");
                        TotalColiformmax.setText("2800");
                        break;
                    case "2488":
                        mapview.setImageResource(R.drawable.sc2488);
                        tempraturemin.setText("15");
                        tempraturemax.setText("30");
                        Dissolvedoxygenmin.setText("7");
                        Dissolvedoxygenmax.setText("10.4");
                        pHmin.setText("6.9");
                        pHmax.setText("7.5");
                        Conductivitymin.setText("210");
                        Conductivitymax.setText("232");
                        biochemicaloxygenmin.setText("1.1");
                        biochemicaloxygenmax.setText("2.8");
                        Nitratemin.setText("0.32");
                        Nitratemax.setText("0.62");
                        FacealColiformmin.setText("110");
                        FacealColiformmax.setText("280");
                        TotalColiformmin.setText("170");
                        TotalColiformmax.setText("550");
                        break;
                    case "2489":
                        mapview.setImageResource(R.drawable.sc2489);
                        tempraturemin.setText("17");
                        tempraturemax.setText("30");
                        Dissolvedoxygenmin.setText("7.2");
                        Dissolvedoxygenmax.setText("10.3");
                        pHmin.setText("7");
                        pHmax.setText("7.6");
                        Conductivitymin.setText("218");
                        Conductivitymax.setText("236");
                        biochemicaloxygenmin.setText("0.8");
                        biochemicaloxygenmax.setText("2.6");
                        Nitratemin.setText("0.34");
                        Nitratemax.setText("0.53");
                        FacealColiformmin.setText("170");
                        FacealColiformmax.setText("430");
                        TotalColiformmin.setText("240");
                        TotalColiformmax.setText("920");
                        break;
                    case "1145":
                        mapview.setImageResource(R.drawable.sc1145);
                        tempraturemin.setText("14");
                        tempraturemax.setText("29");
                        Dissolvedoxygenmin.setText("7.3");
                        Dissolvedoxygenmax.setText("10.6");
                        pHmin.setText("7.1");
                        pHmax.setText("7.6");
                        Conductivitymin.setText("220");
                        Conductivitymax.setText("234");
                        biochemicaloxygenmin.setText("1");
                        biochemicaloxygenmax.setText("2.5");
                        Nitratemin.setText("0.37");
                        Nitratemax.setText("0.66");
                        FacealColiformmin.setText("280");
                        FacealColiformmax.setText("920");
                        TotalColiformmin.setText("630");
                        TotalColiformmax.setText("1600");
                        break;
                    case "2490":
                        mapview.setImageResource(R.drawable.sc2490);
                        tempraturemin.setText("16");
                        tempraturemax.setText("25");
                        Dissolvedoxygenmin.setText("9.7");
                        Dissolvedoxygenmax.setText("10.5");
                        pHmin.setText("7");
                        pHmax.setText("8");
                        Conductivitymin.setText("118");
                        Conductivitymax.setText("789");
                        biochemicaloxygenmin.setText("0.9");
                        biochemicaloxygenmax.setText("2.5");
                        Nitratemin.setText("0.55");
                        Nitratemax.setText("0.62");
                        FacealColiformmin.setText("170");
                        FacealColiformmax.setText("270");
                        TotalColiformmin.setText("250");
                        TotalColiformmax.setText("460");
                        break;
                    case "10151":
                        mapview.setImageResource(R.drawable.sc10151);
                        tempraturemin.setText("16");
                        tempraturemax.setText("33");
                        Dissolvedoxygenmin.setText("6.4");
                        Dissolvedoxygenmax.setText("10.7");
                        pHmin.setText("7.6");
                        pHmax.setText("8.4");
                        Conductivitymin.setText("157");
                        Conductivitymax.setText("285");
                        biochemicaloxygenmin.setText("1.7");
                        biochemicaloxygenmax.setText("2.6");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("1.8");
                        FacealColiformmax.setText("1700");
                        TotalColiformmin.setText("1700");
                        TotalColiformmax.setText("2700");
                        break;
                    case "1063":
                        mapview.setImageResource(R.drawable.sc1063);
                        tempraturemin.setText("16");
                        tempraturemax.setText("32");
                        Dissolvedoxygenmin.setText("6.4");
                        Dissolvedoxygenmax.setText("10.6");
                        pHmin.setText("7.7");
                        pHmax.setText("8.6");
                        Conductivitymin.setText("205");
                        Conductivitymax.setText("345");
                        biochemicaloxygenmin.setText("2.4");
                        biochemicaloxygenmax.setText("3.4");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("1300");
                        FacealColiformmax.setText("2700");
                        TotalColiformmin.setText("3300");
                        TotalColiformmax.setText("4600");
                        break;
                    case "1066":
                        mapview.setImageResource(R.drawable.sc1066);
                        tempraturemin.setText("16");
                        tempraturemax.setText("32");
                        Dissolvedoxygenmin.setText("6");
                        Dissolvedoxygenmax.setText("10.2");
                        pHmin.setText("7.8");
                        pHmax.setText("8.6");
                        Conductivitymin.setText("200");
                        Conductivitymax.setText("366");
                        biochemicaloxygenmin.setText("2.8");
                        biochemicaloxygenmax.setText("4.2");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("1700");
                        FacealColiformmax.setText("3300");
                        TotalColiformmin.setText("4000");
                        TotalColiformmax.setText("5800");
                        break;
                    case "1146":
                        mapview.setImageResource(R.drawable.sc1146);
                        tempraturemin.setText("16");
                        tempraturemax.setText("32");
                        Dissolvedoxygenmin.setText("6.1");
                        Dissolvedoxygenmax.setText("10.6");
                        pHmin.setText("7.9");
                        pHmax.setText("8.8");
                        Conductivitymin.setText("203");
                        Conductivitymax.setText("350");
                        biochemicaloxygenmin.setText("2.3");
                        biochemicaloxygenmax.setText("4.4");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("1400");
                        FacealColiformmax.setText("3400");
                        TotalColiformmin.setText("3300");
                        TotalColiformmax.setText("5800");
                        break;
                    case "1067":
                        mapview.setImageResource(R.drawable.sc1067);
                        tempraturemin.setText("16");
                        tempraturemax.setText("32");
                        Dissolvedoxygenmin.setText("5.8");
                        Dissolvedoxygenmax.setText("10.3");
                        pHmin.setText("7.8");
                        pHmax.setText("8.7");
                        Conductivitymin.setText("203");
                        Conductivitymax.setText("368");
                        biochemicaloxygenmin.setText("2.5");
                        biochemicaloxygenmax.setText("4");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("1700");
                        FacealColiformmax.setText("3400");
                        TotalColiformmin.setText("3900");
                        TotalColiformmax.setText("5800");
                        break;
                    case "10154":
                        mapview.setImageResource(R.drawable.sc10154);
                        tempraturemin.setText("16");
                        tempraturemax.setText("32");
                        Dissolvedoxygenmin.setText("5.7");
                        Dissolvedoxygenmax.setText("10.4");
                        pHmin.setText("7.8");
                        pHmax.setText("8.7");
                        Conductivitymin.setText("206");
                        Conductivitymax.setText("362");
                        biochemicaloxygenmin.setText("2.4");
                        biochemicaloxygenmax.setText("3.8");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("2000");
                        FacealColiformmax.setText("3300");
                        TotalColiformmin.setText("3200");
                        TotalColiformmax.setText("4900");
                        break;
                    case "10155":
                        mapview.setImageResource(R.drawable.sc10155);
                        tempraturemin.setText("16");
                        tempraturemax.setText("32");
                        Dissolvedoxygenmin.setText("5.4");
                        Dissolvedoxygenmax.setText("10");
                        pHmin.setText("7.8");
                        pHmax.setText("8.7");
                        Conductivitymin.setText("219");
                        Conductivitymax.setText("380");
                        biochemicaloxygenmin.setText("2.7");
                        biochemicaloxygenmax.setText("4.4");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("2000");
                        FacealColiformmax.setText("4500");
                        TotalColiformmin.setText("4600");
                        TotalColiformmax.setText("7000");
                        break;
                    case "1068":
                        mapview.setImageResource(R.drawable.sc1068);
                        tempraturemin.setText("16");
                        tempraturemax.setText("32");
                        Dissolvedoxygenmin.setText("4.6");
                        Dissolvedoxygenmax.setText("9.4");
                        pHmin.setText("7.6");
                        pHmax.setText("8.4");
                        Conductivitymin.setText("223");
                        Conductivitymax.setText("442");
                        biochemicaloxygenmin.setText("3.2");
                        biochemicaloxygenmax.setText("5.8");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("17000");
                        FacealColiformmax.setText("35000");
                        TotalColiformmin.setText("28000");
                        TotalColiformmax.setText("63000");
                        break;
                    case "10157":
                        mapview.setImageResource(R.drawable.sc10157);
                        tempraturemin.setText("16");
                        tempraturemax.setText("32");
                        Dissolvedoxygenmin.setText("5.6");
                        Dissolvedoxygenmax.setText("9.6");
                        pHmin.setText("7.7");
                        pHmax.setText("8.5");
                        Conductivitymin.setText("219");
                        Conductivitymax.setText("392");
                        biochemicaloxygenmin.setText("2.8");
                        biochemicaloxygenmax.setText("5.4");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("4300");
                        FacealColiformmax.setText("25000");
                        TotalColiformmin.setText("7000");
                        TotalColiformmax.setText("54000");
                        break;
                    case "1147":
                        mapview.setImageResource(R.drawable.sc1147);
                        tempraturemin.setText("17");
                        tempraturemax.setText("27");
                        Dissolvedoxygenmin.setText("7");
                        Dissolvedoxygenmax.setText("10.6");
                        pHmin.setText("7.9");
                        pHmax.setText("8.7");
                        Conductivitymin.setText("201");
                        Conductivitymax.setText("458");
                        biochemicaloxygenmin.setText("2.8");
                        biochemicaloxygenmax.setText("4.1");
                        Nitratemin.setText("0.78");
                        Nitratemax.setText("0.86");
                        FacealColiformmin.setText("2500");
                        FacealColiformmax.setText("3600");
                        TotalColiformmin.setText("3100");
                        TotalColiformmax.setText("4100");
                        break;
                    case "2498":
                        mapview.setImageResource(R.drawable.sc2498);
                        tempraturemin.setText("17");
                        tempraturemax.setText("27");
                        Dissolvedoxygenmin.setText("6.9");
                        Dissolvedoxygenmax.setText("11");
                        pHmin.setText("7.9");
                        pHmax.setText("8.5");
                        Conductivitymin.setText("206");
                        Conductivitymax.setText("456");
                        biochemicaloxygenmin.setText("2.7");
                        biochemicaloxygenmax.setText("4.1");
                        Nitratemin.setText("0.76");
                        Nitratemax.setText("0.84");
                        FacealColiformmin.setText("2400");
                        FacealColiformmax.setText("3400");
                        TotalColiformmin.setText("3100");
                        TotalColiformmax.setText("4000");
                        break;
                    case "1046":
                        mapview.setImageResource(R.drawable.sc1046);
                        tempraturemin.setText("22.3");
                        tempraturemax.setText("32.5");
                        Dissolvedoxygenmin.setText("7.3");
                        Dissolvedoxygenmax.setText("12.2");
                        pHmin.setText("7.6");
                        pHmax.setText("8.4");
                        Conductivitymin.setText("154");
                        Conductivitymax.setText("261");
                        biochemicaloxygenmin.setText("2.1");
                        biochemicaloxygenmax.setText("3.2");
                        Nitratemin.setText("1.28");
                        Nitratemax.setText("1.61");
                        FacealColiformmin.setText("4300");
                        FacealColiformmax.setText("14000");
                        TotalColiformmin.setText("9400");
                        TotalColiformmax.setText("24000");
                        break;
                    case "2487":
                        mapview.setImageResource(R.drawable.sc2487);
                        tempraturemin.setText("22.4");
                        tempraturemax.setText("32.7");
                        Dissolvedoxygenmin.setText("6.9");
                        Dissolvedoxygenmax.setText("11.5");
                        pHmin.setText("7.8");
                        pHmax.setText("8.5");
                        Conductivitymin.setText("150");
                        Conductivitymax.setText("268");
                        biochemicaloxygenmin.setText("2");
                        biochemicaloxygenmax.setText("3.9");
                        Nitratemin.setText("1.38");
                        Nitratemax.setText("1.77");
                        FacealColiformmin.setText("4600");
                        FacealColiformmax.setText("14000");
                        TotalColiformmin.setText("11000");
                        TotalColiformmax.setText("27000");
                        break;
                    case "1049":
                        mapview.setImageResource(R.drawable.sc1049);
                        tempraturemin.setText("22.6");
                        tempraturemax.setText("32.8");
                        Dissolvedoxygenmin.setText("6.8");
                        Dissolvedoxygenmax.setText("11.5");
                        pHmin.setText("7.8");
                        pHmax.setText("8.4");
                        Conductivitymin.setText("236");
                        Conductivitymax.setText("283");
                        biochemicaloxygenmin.setText("2");
                        biochemicaloxygenmax.setText("3.4");
                        Nitratemin.setText("1.39");
                        Nitratemax.setText("1.83");
                        FacealColiformmin.setText("3300");
                        FacealColiformmax.setText("13000");
                        TotalColiformmin.setText("8400");
                        TotalColiformmax.setText("27000");
                        break;
                    case "10158":
                        mapview.setImageResource(R.drawable.sc10158);
                        tempraturemin.setText("22.7");
                        tempraturemax.setText("32.8");
                        Dissolvedoxygenmin.setText("7");
                        Dissolvedoxygenmax.setText("11.7");
                        pHmin.setText("7.7");
                        pHmax.setText("8.2");
                        Conductivitymin.setText("246");
                        Conductivitymax.setText("276");
                        biochemicaloxygenmin.setText("1.8");
                        biochemicaloxygenmax.setText("2.9");
                        Nitratemin.setText("1.35");
                        Nitratemax.setText("1.69");
                        FacealColiformmin.setText("3100");
                        FacealColiformmax.setText("9400");
                        TotalColiformmin.setText("7000");
                        TotalColiformmax.setText("22000");
                        break;
                    case "2485":
                        mapview.setImageResource(R.drawable.sc2485);
                        tempraturemin.setText("19");
                        tempraturemax.setText("29.5");
                        Dissolvedoxygenmin.setText("7.2");
                        Dissolvedoxygenmax.setText("9.2");
                        pHmin.setText("8.2");
                        pHmax.setText("8.4");
                        Conductivitymin.setText("352");
                        Conductivitymax.setText("468");
                        biochemicaloxygenmin.setText("2.1");
                        biochemicaloxygenmax.setText("3.2");
                        Nitratemin.setText("0.48");
                        Nitratemax.setText("0.9");
                        FacealColiformmin.setText("800");
                        FacealColiformmax.setText("1300");
                        TotalColiformmin.setText("1300");
                        TotalColiformmax.setText("2700");
                        break;
                    case "2486":
                        mapview.setImageResource(R.drawable.sc2486);
                        tempraturemin.setText("19");
                        tempraturemax.setText("29.8");
                        Dissolvedoxygenmin.setText("6.7");
                        Dissolvedoxygenmax.setText("8.4");
                        pHmin.setText("8.1");
                        pHmax.setText("8.6");
                        Conductivitymin.setText("364");
                        Conductivitymax.setText("496");
                        biochemicaloxygenmin.setText("3.3");
                        biochemicaloxygenmax.setText("3.9");
                        Nitratemin.setText("0.84");
                        Nitratemax.setText("1.3");
                        FacealColiformmin.setText("7000");
                        FacealColiformmax.setText("11000");
                        TotalColiformmin.setText("13000");
                        TotalColiformmax.setText("22000");
                        break;
                    case "10153":
                        mapview.setImageResource(R.drawable.sc10153);
                        tempraturemin.setText("19");
                        tempraturemax.setText("29.5");
                        Dissolvedoxygenmin.setText("6.9");
                        Dissolvedoxygenmax.setText("8.8");
                        pHmin.setText("2.2");
                        pHmax.setText("8.5");
                        Conductivitymin.setText("360");
                        Conductivitymax.setText("488");
                        biochemicaloxygenmin.setText("2.9");
                        biochemicaloxygenmax.setText("3.8");
                        Nitratemin.setText("0.77");
                        Nitratemax.setText("1.12");
                        FacealColiformmin.setText("5000");
                        FacealColiformmax.setText("8000");
                        TotalColiformmin.setText("8000");
                        TotalColiformmax.setText("14000");
                        break;
                    case "1070":
                        mapview.setImageResource(R.drawable.sc1070);
                        tempraturemin.setText("20");
                        tempraturemax.setText("31.5");
                        Dissolvedoxygenmin.setText("7.2");
                        Dissolvedoxygenmax.setText("10");
                        pHmin.setText("8.1");
                        pHmax.setText("8.4");
                        Conductivitymin.setText("364");
                        Conductivitymax.setText("512");
                        biochemicaloxygenmin.setText("1.7");
                        biochemicaloxygenmax.setText("3.3");
                        Nitratemin.setText("0.12");
                        Nitratemax.setText("0.24");
                        FacealColiformmin.setText("500");
                        FacealColiformmax.setText("1700");
                        TotalColiformmin.setText("1100");
                        TotalColiformmax.setText("3400");
                        break;
                    case "1071":
                        mapview.setImageResource(R.drawable.sc1071);
                        tempraturemin.setText("20");
                        tempraturemax.setText("31.5");
                        Dissolvedoxygenmin.setText("6.5");
                        Dissolvedoxygenmax.setText("7.9");
                        pHmin.setText("7.9");
                        pHmax.setText("8.7");
                        Conductivitymin.setText("392");
                        Conductivitymax.setText("528");
                        biochemicaloxygenmin.setText("3.4");
                        biochemicaloxygenmax.setText("4.2");
                        Nitratemin.setText("0.15");
                        Nitratemax.setText("0.4");
                        FacealColiformmin.setText("11000");
                        FacealColiformmax.setText("23000");
                        TotalColiformmin.setText("17000");
                        TotalColiformmax.setText("43000");
                        break;
                    case "10152":
                        mapview.setImageResource(R.drawable.sc10152);
                        tempraturemin.setText("20.5");
                        tempraturemax.setText("32.5");
                        Dissolvedoxygenmin.setText("6.8");
                        Dissolvedoxygenmax.setText("9");
                        pHmin.setText("8.2");
                        pHmax.setText("8.6");
                        Conductivitymin.setText("370");
                        Conductivitymax.setText("524");
                        biochemicaloxygenmin.setText("3");
                        biochemicaloxygenmax.setText("3.8");
                        Nitratemin.setText("0.15");
                        Nitratemax.setText("0.31");
                        FacealColiformmin.setText("5000");
                        FacealColiformmax.setText("11000");
                        TotalColiformmin.setText("8000");
                        TotalColiformmax.setText("17000");
                        break;
                    case "10156":
                        mapview.setImageResource(R.drawable.sc10156);
                        tempraturemin.setText("16");
                        tempraturemax.setText("32");
                        Dissolvedoxygenmin.setText("5.6");
                        Dissolvedoxygenmax.setText("10.1");
                        pHmin.setText("7.7");
                        pHmax.setText("8.6");
                        Conductivitymin.setText("236");
                        Conductivitymax.setText("384");
                        biochemicaloxygenmin.setText("2.6");
                        biochemicaloxygenmax.setText("4.6");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("2300");
                        FacealColiformmax.setText("5400");
                        TotalColiformmin.setText("4600");
                        TotalColiformmax.setText("13000");
                        break;
                    case "1073":
                        mapview.setImageResource(R.drawable.sc1073);
                        tempraturemin.setText("20.5");
                        tempraturemax.setText("32");
                        Dissolvedoxygenmin.setText("6.5");
                        Dissolvedoxygenmax.setText("7.8");
                        pHmin.setText("8.1");
                        pHmax.setText("8.7");
                        Conductivitymin.setText("388");
                        Conductivitymax.setText("535");
                        biochemicaloxygenmin.setText("3.3");
                        biochemicaloxygenmax.setText("4.3");
                        Nitratemin.setText("0.19");
                        Nitratemax.setText("0.38");
                        FacealColiformmin.setText("11000");
                        FacealColiformmax.setText("17000");
                        TotalColiformmin.setText("21000");
                        TotalColiformmax.setText("31000");
                        break;
                    case "1074":
                        mapview.setImageResource(R.drawable.sc1074);
                        tempraturemin.setText("17");
                        tempraturemax.setText("35");
                        Dissolvedoxygenmin.setText("6.8");
                        Dissolvedoxygenmax.setText("10.2");
                        pHmin.setText("7");
                        pHmax.setText("9");
                        Conductivitymin.setText("250");
                        Conductivitymax.setText("512");
                        biochemicaloxygenmin.setText("1.4");
                        biochemicaloxygenmax.setText("2.8");
                        Nitratemin.setText("0.02");
                        Nitratemax.setText("0.37");
                        FacealColiformmin.setText("450");
                        FacealColiformmax.setText("28000");
                        TotalColiformmin.setText("2300");
                        TotalColiformmax.setText("160000");
                        break;
                    case "10113":
                        mapview.setImageResource(R.drawable.sc10113);
                        tempraturemin.setText("17");
                        tempraturemax.setText("37");
                        Dissolvedoxygenmin.setText("6");
                        Dissolvedoxygenmax.setText("8.6");
                        pHmin.setText("7.1");
                        pHmax.setText("8.6");
                        Conductivitymin.setText("253");
                        Conductivitymax.setText("508");
                        biochemicaloxygenmin.setText("1.5");
                        biochemicaloxygenmax.setText("2.7");
                        Nitratemin.setText("0.03");
                        Nitratemax.setText("0.46");
                        FacealColiformmin.setText("2100");
                        FacealColiformmax.setText("28000");
                        TotalColiformmin.setText("8400");
                        TotalColiformmax.setText("160000");
                        break;
                    case "2551":
                        mapview.setImageResource(R.drawable.sc2551);
                        tempraturemin.setText("17");
                        tempraturemax.setText("36");
                        Dissolvedoxygenmin.setText("6");
                        Dissolvedoxygenmax.setText("8.3");
                        pHmin.setText("7.5");
                        pHmax.setText("8.7");
                        Conductivitymin.setText("257");
                        Conductivitymax.setText("523");
                        biochemicaloxygenmin.setText("1.9");
                        biochemicaloxygenmax.setText("2.8");
                        Nitratemin.setText("0.02");
                        Nitratemax.setText("0.54");
                        FacealColiformmin.setText("1100");
                        FacealColiformmax.setText("17000");
                        TotalColiformmin.setText("9400");
                        TotalColiformmax.setText("35000");
                        break;
                    case "3113":
                        mapview.setImageResource(R.drawable.sc3113);
                        tempraturemin.setText("16");
                        tempraturemax.setText("34");
                        Dissolvedoxygenmin.setText("6.3");
                        Dissolvedoxygenmax.setText("8.5");
                        pHmin.setText("7.2");
                        pHmax.setText("8.8");
                        Conductivitymin.setText("248");
                        Conductivitymax.setText("629");
                        biochemicaloxygenmin.setText("1.5");
                        biochemicaloxygenmax.setText("2.7");
                        Nitratemin.setText("0.02");
                        Nitratemax.setText("0.51");
                        FacealColiformmin.setText("170");
                        FacealColiformmax.setText("17000");
                        TotalColiformmin.setText("1600");
                        TotalColiformmax.setText("54000");
                        break;
                    case "10131":
                        mapview.setImageResource(R.drawable.sc10131);
                        tempraturemin.setText("19");
                        tempraturemax.setText("32");
                        Dissolvedoxygenmin.setText("6.2");
                        Dissolvedoxygenmax.setText("9.3");
                        pHmin.setText("7.5");
                        pHmax.setText("8.8");
                        Conductivitymin.setText("236");
                        Conductivitymax.setText("411");
                        biochemicaloxygenmin.setText("1.3");
                        biochemicaloxygenmax.setText("2.2");
                        Nitratemin.setText("0.14");
                        Nitratemax.setText("0.73");
                        FacealColiformmin.setText("1700");
                        FacealColiformmax.setText("17000");
                        TotalColiformmin.setText("11000");
                        TotalColiformmax.setText("92000");
                        break;
                    case "10162":
                        mapview.setImageResource(R.drawable.sc10162);
                        tempraturemin.setText("18");
                        tempraturemax.setText("35");
                        Dissolvedoxygenmin.setText("5.7");
                        Dissolvedoxygenmax.setText("9.8");
                        pHmin.setText("7.3");
                        pHmax.setText("8.3");
                        Conductivitymin.setText("250");
                        Conductivitymax.setText("505");
                        biochemicaloxygenmin.setText("1.4");
                        biochemicaloxygenmax.setText("2");
                        Nitratemin.setText("0.02");
                        Nitratemax.setText("0.36");
                        FacealColiformmin.setText("1300");
                        FacealColiformmax.setText("3900");
                        TotalColiformmin.setText("3300");
                        TotalColiformmax.setText("35000");
                        break;
                    case "2564":
                        mapview.setImageResource(R.drawable.sc2564);
                        tempraturemin.setText("17");
                        tempraturemax.setText("33");
                        Dissolvedoxygenmin.setText("7.3");
                        Dissolvedoxygenmax.setText("9.8");
                        pHmin.setText("7.3");
                        pHmax.setText("8.1");
                        Conductivitymin.setText("237");
                        Conductivitymax.setText("457");
                        biochemicaloxygenmin.setText("1.4");
                        biochemicaloxygenmax.setText("2.5");
                        Nitratemin.setText("0.1");
                        Nitratemax.setText("0.21");
                        FacealColiformmin.setText("1400");
                        FacealColiformmax.setText("4000");
                        TotalColiformmin.setText("2600");
                        TotalColiformmax.setText("28000");
                        break;
                    case "10114":
                        mapview.setImageResource(R.drawable.sc10114);
                        tempraturemin.setText("17");
                        tempraturemax.setText("32");
                        Dissolvedoxygenmin.setText("7.2");
                        Dissolvedoxygenmax.setText("9.7");
                        pHmin.setText("7.2");
                        pHmax.setText("8");
                        Conductivitymin.setText("16");
                        Conductivitymax.setText("462");
                        biochemicaloxygenmin.setText("1.7");
                        biochemicaloxygenmax.setText("2.2");
                        Nitratemin.setText("0.12");
                        Nitratemax.setText("0.62");
                        FacealColiformmin.setText("450");
                        FacealColiformmax.setText("22000");
                        TotalColiformmin.setText("14000");
                        TotalColiformmax.setText("43000");
                        break;
                    case "3114":
                        mapview.setImageResource(R.drawable.sc3114);
                        tempraturemin.setText("19");
                        tempraturemax.setText("33");
                        Dissolvedoxygenmin.setText("6.7");
                        Dissolvedoxygenmax.setText("9.4");
                        pHmin.setText("7.4");
                        pHmax.setText("8.5");
                        Conductivitymin.setText("283");
                        Conductivitymax.setText("563");
                        biochemicaloxygenmin.setText("1.3");
                        biochemicaloxygenmax.setText("2.4");
                        Nitratemin.setText("0.01");
                        Nitratemax.setText("0.86");
                        FacealColiformmin.setText("780");
                        FacealColiformmax.setText("14000");
                        TotalColiformmin.setText("3100");
                        TotalColiformmax.setText("28000");
                        break;
                    case "1077":
                        mapview.setImageResource(R.drawable.sc1077);
                        tempraturemin.setText("18");
                        tempraturemax.setText("33");
                        Dissolvedoxygenmin.setText("6.3");
                        Dissolvedoxygenmax.setText("9");
                        pHmin.setText("7.4");
                        pHmax.setText("8.5");
                        Conductivitymin.setText("257");
                        Conductivitymax.setText("563");
                        biochemicaloxygenmin.setText("1.3");
                        biochemicaloxygenmax.setText("2");
                        Nitratemin.setText("0.03");
                        Nitratemax.setText("1");
                        FacealColiformmin.setText("2100");
                        FacealColiformmax.setText("11000");
                        TotalColiformmin.setText("2600");
                        TotalColiformmax.setText("35000");
                        break;
                    case "2552":
                        mapview.setImageResource(R.drawable.sc2552);
                        tempraturemin.setText("19");
                        tempraturemax.setText("33");
                        Dissolvedoxygenmin.setText("6.5");
                        Dissolvedoxygenmax.setText("8.8");
                        pHmin.setText("7.7");
                        pHmax.setText("8.3");
                        Conductivitymin.setText("265");
                        Conductivitymax.setText("467");
                        biochemicaloxygenmin.setText("1.8");
                        biochemicaloxygenmax.setText("2.9");
                        Nitratemin.setText("0.03");
                        Nitratemax.setText("0.58");
                        FacealColiformmin.setText("1400");
                        FacealColiformmax.setText("26000");
                        TotalColiformmin.setText("11000");
                        TotalColiformmax.setText("35000");
                        break;
                    case "10115":
                        mapview.setImageResource(R.drawable.sc10115);
                        tempraturemin.setText("19");
                        tempraturemax.setText("34");
                        Dissolvedoxygenmin.setText("5.6");
                        Dissolvedoxygenmax.setText("8.5");
                        pHmin.setText("7.4");
                        pHmax.setText("8.4");
                        Conductivitymin.setText("263");
                        Conductivitymax.setText("465");
                        biochemicaloxygenmin.setText("1.8");
                        biochemicaloxygenmax.setText("2.8");
                        Nitratemin.setText("0.03");
                        Nitratemax.setText("0.82");
                        FacealColiformmin.setText("1400");
                        FacealColiformmax.setText("22000");
                        TotalColiformmin.setText("6800");
                        TotalColiformmax.setText("92000");
                        break;
                    case "1079":
                        mapview.setImageResource(R.drawable.sc1079);
                        tempraturemin.setText("19");
                        tempraturemax.setText("34");
                        Dissolvedoxygenmin.setText("6.3");
                        Dissolvedoxygenmax.setText("8.8");
                        pHmin.setText("7.7");
                        pHmax.setText("8.6");
                        Conductivitymin.setText("250");
                        Conductivitymax.setText("479");
                        biochemicaloxygenmin.setText("1.7");
                        biochemicaloxygenmax.setText("2.6");
                        Nitratemin.setText("0.11");
                        Nitratemax.setText("1");
                        FacealColiformmin.setText("1100");
                        FacealColiformmax.setText("28000");
                        TotalColiformmin.setText("11000");
                        TotalColiformmax.setText("160000");
                        break;
                    case "3122":
                        mapview.setImageResource(R.drawable.sc3122);
                        tempraturemin.setText("18");
                        tempraturemax.setText("33");
                        Dissolvedoxygenmin.setText("7");
                        Dissolvedoxygenmax.setText("9.5");
                        pHmin.setText("7.3");
                        pHmax.setText("8.5");
                        Conductivitymin.setText("247");
                        Conductivitymax.setText("458");
                        biochemicaloxygenmin.setText("1.5");
                        biochemicaloxygenmax.setText("2.6");
                        Nitratemin.setText("0.02");
                        Nitratemax.setText("0.8");
                        FacealColiformmin.setText("1100");
                        FacealColiformmax.setText("11000");
                        TotalColiformmin.setText("4000");
                        TotalColiformmax.setText("24000");
                        break;
                    case "4297":
                        mapview.setImageResource(R.drawable.sc4297);
                        tempraturemin.setText("18");
                        tempraturemax.setText("34");
                        Dissolvedoxygenmin.setText("6.6");
                        Dissolvedoxygenmax.setText("9.8");
                        pHmin.setText("6.6");
                        pHmax.setText("8.5");
                        Conductivitymin.setText("262");
                        Conductivitymax.setText("456");
                        biochemicaloxygenmin.setText("1.2");
                        biochemicaloxygenmax.setText("2.1");
                        Nitratemin.setText("0.02");
                        Nitratemax.setText("0.78");
                        FacealColiformmin.setText("1100");
                        FacealColiformmax.setText("11000");
                        TotalColiformmin.setText("5500");
                        TotalColiformmax.setText("28000");
                        break;
                    case "10122":
                        mapview.setImageResource(R.drawable.sc10122);
                        tempraturemin.setText("17");
                        tempraturemax.setText("33");
                        Dissolvedoxygenmin.setText("6.1");
                        Dissolvedoxygenmax.setText("9.5");
                        pHmin.setText("7.7");
                        pHmax.setText("8.4");
                        Conductivitymin.setText("245");
                        Conductivitymax.setText("454");
                        biochemicaloxygenmin.setText("1.4");
                        biochemicaloxygenmax.setText("2.7");
                        Nitratemin.setText("0.03");
                        Nitratemax.setText("0.64");
                        FacealColiformmin.setText("1400");
                        FacealColiformmax.setText("21000");
                        TotalColiformmin.setText("3300");
                        TotalColiformmax.setText("28000");
                        break;
                    case "2553":
                        mapview.setImageResource(R.drawable.sc2553);
                        tempraturemin.setText("17");
                        tempraturemax.setText("34");
                        Dissolvedoxygenmin.setText("6.2");
                        Dissolvedoxygenmax.setText("8.5");
                        pHmin.setText("7.5");
                        pHmax.setText("8.2");
                        Conductivitymin.setText("252");
                        Conductivitymax.setText("467");
                        biochemicaloxygenmin.setText("1.8");
                        biochemicaloxygenmax.setText("2.9");
                        Nitratemin.setText("0.02");
                        Nitratemax.setText("1.83");
                        FacealColiformmin.setText("1100");
                        FacealColiformmax.setText("22000");
                        TotalColiformmin.setText("3800");
                        TotalColiformmax.setText("92000");
                        break;
                    case "4301":
                        mapview.setImageResource(R.drawable.sc4301);
                        tempraturemin.setText("18");
                        tempraturemax.setText("33");
                        Dissolvedoxygenmin.setText("5.8");
                        Dissolvedoxygenmax.setText("9.4");
                        pHmin.setText("7.4");
                        pHmax.setText("8.6");
                        Conductivitymin.setText("246");
                        Conductivitymax.setText("514");
                        biochemicaloxygenmin.setText("1.3");
                        biochemicaloxygenmax.setText("2.2");
                        Nitratemin.setText("0.09");
                        Nitratemax.setText("0.61");
                        FacealColiformmin.setText("1700");
                        FacealColiformmax.setText("17000");
                        TotalColiformmin.setText("3100");
                        TotalColiformmax.setText("54000");
                        break;
                    case "3115":
                        mapview.setImageResource(R.drawable.sc3115);
                        tempraturemin.setText("19");
                        tempraturemax.setText("33");
                        Dissolvedoxygenmin.setText("6.1");
                        Dissolvedoxygenmax.setText("9.8");
                        pHmin.setText("7.5");
                        pHmax.setText("9.9");
                        Conductivitymin.setText("238");
                        Conductivitymax.setText("462");
                        biochemicaloxygenmin.setText("1.3");
                        biochemicaloxygenmax.setText("2.2");
                        Nitratemin.setText("0.03");
                        Nitratemax.setText("0.62");
                        FacealColiformmin.setText("1300");
                        FacealColiformmax.setText("22000");
                        TotalColiformmin.setText("7000");
                        TotalColiformmax.setText("54000");
                        break;
                    case "10130":
                        mapview.setImageResource(R.drawable.sc101301817);
                        tempraturemin.setText("18");
                        tempraturemax.setText("32");
                        Dissolvedoxygenmin.setText("6");
                        Dissolvedoxygenmax.setText("9.6");
                        pHmin.setText("7.5");
                        pHmax.setText("8.9");
                        Conductivitymin.setText("240");
                        Conductivitymax.setText("475");
                        biochemicaloxygenmin.setText("1.1");
                        biochemicaloxygenmax.setText("2.3");
                        Nitratemin.setText("0.1");
                        Nitratemax.setText("0.58");
                        FacealColiformmin.setText("1400");
                        FacealColiformmax.setText("17000");
                        TotalColiformmin.setText("3900");
                        TotalColiformmax.setText("160000");
                        break;
                    case "1817":
                        mapview.setImageResource(R.drawable.sc101301817);
                        tempraturemin.setText("18");
                        tempraturemax.setText("33");
                        Dissolvedoxygenmin.setText("6.1");
                        Dissolvedoxygenmax.setText("9.4");
                        pHmin.setText("7.4");
                        pHmax.setText("8.8");
                        Conductivitymin.setText("237");
                        Conductivitymax.setText("452");
                        biochemicaloxygenmin.setText("1.1");
                        biochemicaloxygenmax.setText("2.6");
                        Nitratemin.setText("0.14");
                        Nitratemax.setText("0.9");
                        FacealColiformmin.setText("1100");
                        FacealColiformmax.setText("13000");
                        TotalColiformmin.setText("1400");
                        TotalColiformmax.setText("54000");
                        break;
                    case "1815":
                        mapview.setImageResource(R.drawable.sc1815);
                        tempraturemin.setText("19");
                        tempraturemax.setText("33");
                        Dissolvedoxygenmin.setText("6.3");
                        Dissolvedoxygenmax.setText("8");
                        pHmin.setText("7.2");
                        pHmax.setText("8.5");
                        Conductivitymin.setText("208");
                        Conductivitymax.setText("425");
                        biochemicaloxygenmin.setText("1.6");
                        biochemicaloxygenmax.setText("2.6");
                        Nitratemin.setText("0.06");
                        Nitratemax.setText("0.54");
                        FacealColiformmin.setText("680");
                        FacealColiformmax.setText("17000");
                        TotalColiformmin.setText("14000");
                        TotalColiformmax.setText("35000");
                        break;
                    case "3123":
                        mapview.setImageResource(R.drawable.sc3123);
                        tempraturemin.setText("21");
                        tempraturemax.setText("35");
                        Dissolvedoxygenmin.setText("6.1");
                        Dissolvedoxygenmax.setText("9.2");
                        pHmin.setText("7.6");
                        pHmax.setText("8.7");
                        Conductivitymin.setText("239");
                        Conductivitymax.setText("452");
                        biochemicaloxygenmin.setText("1.1");
                        biochemicaloxygenmax.setText("2.3");
                        Nitratemin.setText("0.11");
                        Nitratemax.setText("1.17");
                        FacealColiformmin.setText("1100");
                        FacealColiformmax.setText("14000");
                        TotalColiformmin.setText("11000");
                        TotalColiformmax.setText("35000");
                        break;
                    case "3116":
                        mapview.setImageResource(R.drawable.sc3116);
                        tempraturemin.setText("20");
                        tempraturemax.setText("32");
                        Dissolvedoxygenmin.setText("6");
                        Dissolvedoxygenmax.setText("9.7");
                        pHmin.setText("7.6");
                        pHmax.setText("8.6");
                        Conductivitymin.setText("232");
                        Conductivitymax.setText("440");
                        biochemicaloxygenmin.setText("1.1");
                        biochemicaloxygenmax.setText("2.5");
                        Nitratemin.setText("0.03");
                        Nitratemax.setText("0.85");
                        FacealColiformmin.setText("1100");
                        FacealColiformmax.setText("17000");
                        TotalColiformmin.setText("11000");
                        TotalColiformmax.setText("160000");
                        break;
                    case "1818":
                        mapview.setImageResource(R.drawable.sc1818);
                        tempraturemin.setText("21");
                        tempraturemax.setText("32");
                        Dissolvedoxygenmin.setText("5.8");
                        Dissolvedoxygenmax.setText("9.6");
                        pHmin.setText("7.6");
                        pHmax.setText("8.5");
                        Conductivitymin.setText("234");
                        Conductivitymax.setText("436");
                        biochemicaloxygenmin.setText("1.5");
                        biochemicaloxygenmax.setText("2.5");
                        Nitratemin.setText("0.05");
                        Nitratemax.setText("0.6");
                        FacealColiformmin.setText("1100");
                        FacealColiformmax.setText("28000");
                        TotalColiformmin.setText("14000");
                        TotalColiformmax.setText("160000");
                        break;
                    case "3117":
                        mapview.setImageResource(R.drawable.sc3117);
                        tempraturemin.setText("18");
                        tempraturemax.setText("32");
                        Dissolvedoxygenmin.setText("6.1");
                        Dissolvedoxygenmax.setText("9.5");
                        pHmin.setText("7.4");
                        pHmax.setText("8.7");
                        Conductivitymin.setText("242");
                        Conductivitymax.setText("427");
                        biochemicaloxygenmin.setText("1.5");
                        biochemicaloxygenmax.setText("2.3");
                        Nitratemin.setText("0.07");
                        Nitratemax.setText("0.5");
                        FacealColiformmin.setText("1700");
                        FacealColiformmax.setText("17000");
                        TotalColiformmin.setText("9300");
                        TotalColiformmax.setText("92000");
                        break;
                    case "4398":
                        mapview.setImageResource(R.drawable.sc4398);
                        tempraturemin.setText("18");
                        tempraturemax.setText("34");
                        Dissolvedoxygenmin.setText("6.1");
                        Dissolvedoxygenmax.setText("8.7");
                        pHmin.setText("7.5");
                        pHmax.setText("9.1");
                        Conductivitymin.setText("239");
                        Conductivitymax.setText("512");
                        biochemicaloxygenmin.setText("1.3");
                        biochemicaloxygenmax.setText("2.8");
                        Nitratemin.setText("0.05");
                        Nitratemax.setText("1.06");
                        FacealColiformmin.setText("1200");
                        FacealColiformmax.setText("22000");
                        TotalColiformmin.setText("4100");
                        TotalColiformmax.setText("92000");
                        break;
                    case "2554":
                        mapview.setImageResource(R.drawable.sc2554);
                        tempraturemin.setText("18");
                        tempraturemax.setText("32");
                        Dissolvedoxygenmin.setText("6.2");
                        Dissolvedoxygenmax.setText("9.4");
                        pHmin.setText("7.3");
                        pHmax.setText("8.6");
                        Conductivitymin.setText("234");
                        Conductivitymax.setText("408");
                        biochemicaloxygenmin.setText("1.3");
                        biochemicaloxygenmax.setText("2.6");
                        Nitratemin.setText("0.04");
                        Nitratemax.setText("0.56");
                        FacealColiformmin.setText("780");
                        FacealColiformmax.setText("28000");
                        TotalColiformmin.setText("3900");
                        TotalColiformmax.setText("160000");
                        break;
                    case "10138":
                        mapview.setImageResource(R.drawable.sc10138);
                        tempraturemin.setText("17");
                        tempraturemax.setText("35");
                        Dissolvedoxygenmin.setText("6.5");
                        Dissolvedoxygenmax.setText("9.7");
                        pHmin.setText("7");
                        pHmax.setText("8.6");
                        Conductivitymin.setText("241");
                        Conductivitymax.setText("519");
                        biochemicaloxygenmin.setText("1.5");
                        biochemicaloxygenmax.setText("2.6");
                        Nitratemin.setText("0.06");
                        Nitratemax.setText("0.65");
                        FacealColiformmin.setText("200");
                        FacealColiformmax.setText("28000");
                        TotalColiformmin.setText("2700");
                        TotalColiformmax.setText("160000");
                        break;
                    case "1819":
                        mapview.setImageResource(R.drawable.sc1819);
                        tempraturemin.setText("18");
                        tempraturemax.setText("32");
                        Dissolvedoxygenmin.setText("6.1");
                        Dissolvedoxygenmax.setText("8.6");
                        pHmin.setText("7.6");
                        pHmax.setText("8.3");
                        Conductivitymin.setText("224");
                        Conductivitymax.setText("505");
                        biochemicaloxygenmin.setText("1.4");
                        biochemicaloxygenmax.setText("2.5");
                        Nitratemin.setText("0.01");
                        Nitratemax.setText("0.91");
                        FacealColiformmin.setText("780");
                        FacealColiformmax.setText("17000");
                        TotalColiformmin.setText("6800");
                        TotalColiformmax.setText("92000");
                        break;
                    case "3118":
                        mapview.setImageResource(R.drawable.sc3118);
                        tempraturemin.setText("13");
                        tempraturemax.setText("34");
                        Dissolvedoxygenmin.setText("6");
                        Dissolvedoxygenmax.setText("8.5");
                        pHmin.setText("7.6");
                        pHmax.setText("8.6");
                        Conductivitymin.setText("244");
                        Conductivitymax.setText("500");
                        biochemicaloxygenmin.setText("1.9");
                        biochemicaloxygenmax.setText("2.7");
                        Nitratemin.setText("0.01");
                        Nitratemax.setText("0.52");
                        FacealColiformmin.setText("930");
                        FacealColiformmax.setText("35000");
                        TotalColiformmin.setText("11000");
                        TotalColiformmax.setText("160000");
                        break;
                    case "1816":
                        mapview.setImageResource(R.drawable.sc1816);
                        tempraturemin.setText("18");
                        tempraturemax.setText("32");
                        Dissolvedoxygenmin.setText("6.1");
                        Dissolvedoxygenmax.setText("9.5");
                        pHmin.setText("7.5");
                        pHmax.setText("8.6");
                        Conductivitymin.setText("221");
                        Conductivitymax.setText("429");
                        biochemicaloxygenmin.setText("1.1");
                        biochemicaloxygenmax.setText("2.3");
                        Nitratemin.setText("0.07");
                        Nitratemax.setText("0.56");
                        FacealColiformmin.setText("200");
                        FacealColiformmax.setText("17000");
                        TotalColiformmin.setText("110000");
                        TotalColiformmax.setText("160000");
                        break;
                    case "10143":
                        mapview.setImageResource(R.drawable.sc10143);
                        tempraturemin.setText("18");
                        tempraturemax.setText("32");
                        Dissolvedoxygenmin.setText("5.9");
                        Dissolvedoxygenmax.setText("9.3");
                        pHmin.setText("7.4");
                        pHmax.setText("8.5");
                        Conductivitymin.setText("236");
                        Conductivitymax.setText("426");
                        biochemicaloxygenmin.setText("1.2");
                        biochemicaloxygenmax.setText("2.6");
                        Nitratemin.setText("0.01");
                        Nitratemax.setText("0.65");
                        FacealColiformmin.setText("1400");
                        FacealColiformmax.setText("14000");
                        TotalColiformmin.setText("14000");
                        TotalColiformmax.setText("160000");
                        break;
                    case "10144":
                        mapview.setImageResource(R.drawable.sc10144);
                        tempraturemin.setText("17");
                        tempraturemax.setText("40");
                        Dissolvedoxygenmin.setText("7.8");
                        Dissolvedoxygenmax.setText("8.6");
                        pHmin.setText("7.8");
                        pHmax.setText("8.4");
                        Conductivitymin.setText("304");
                        Conductivitymax.setText("316");
                        biochemicaloxygenmin.setText("2.2");
                        biochemicaloxygenmax.setText("2.6");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("");
                        FacealColiformmax.setText("");
                        TotalColiformmin.setText("");
                        TotalColiformmax.setText("");
                        break;
                    case "10145":
                        mapview.setImageResource(R.drawable.sc10145);
                        tempraturemin.setText("18");
                        tempraturemax.setText("44");
                        Dissolvedoxygenmin.setText("8");
                        Dissolvedoxygenmax.setText("8.6");
                        pHmin.setText("7.6");
                        pHmax.setText("8.4");
                        Conductivitymin.setText("312");
                        Conductivitymax.setText("320");
                        biochemicaloxygenmin.setText("2.2");
                        biochemicaloxygenmax.setText("2.6");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("");
                        FacealColiformmax.setText("");
                        TotalColiformmin.setText("");
                        TotalColiformmax.setText("");
                        break;
                    case "10146":
                        mapview.setImageResource(R.drawable.sc10146);
                        tempraturemin.setText("19");
                        tempraturemax.setText("39");
                        Dissolvedoxygenmin.setText("8.2");
                        Dissolvedoxygenmax.setText("8.6");
                        pHmin.setText("8");
                        pHmax.setText("8.3");
                        Conductivitymin.setText("312");
                        Conductivitymax.setText("318");
                        biochemicaloxygenmin.setText("2.2");
                        biochemicaloxygenmax.setText("2.8");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("");
                        FacealColiformmax.setText("");
                        TotalColiformmin.setText("");
                        TotalColiformmax.setText("");
                        break;
                    case "1059":
                        mapview.setImageResource(R.drawable.sc1059);
                        tempraturemin.setText("18");
                        tempraturemax.setText("40");
                        Dissolvedoxygenmin.setText("8");
                        Dissolvedoxygenmax.setText("8.6");
                        pHmin.setText("8.1");
                        pHmax.setText("8.6");
                        Conductivitymin.setText("310");
                        Conductivitymax.setText("322");
                        biochemicaloxygenmin.setText("2.2");
                        biochemicaloxygenmax.setText("2.8");
                        Nitratemin.setText("");
                        Nitratemax.setText("");
                        FacealColiformmin.setText("");
                        FacealColiformmax.setText("");
                        TotalColiformmin.setText("");
                        TotalColiformmax.setText("");
                        break;
                    case "1080":
                        mapview.setImageResource(R.drawable.sc10801015910160);
                        tempraturemin.setText("17");
                        tempraturemax.setText("37");
                        Dissolvedoxygenmin.setText("4.9");
                        Dissolvedoxygenmax.setText("11.2");
                        pHmin.setText("7.4");
                        pHmax.setText("8.5");
                        Conductivitymin.setText("198");
                        Conductivitymax.setText("380");
                        biochemicaloxygenmin.setText("0.8");
                        biochemicaloxygenmax.setText("4.8");
                        Nitratemin.setText("0.28");
                        Nitratemax.setText("0.73");
                        FacealColiformmin.setText("7000");
                        FacealColiformmax.setText("300000");
                        TotalColiformmin.setText("14000");
                        TotalColiformmax.setText("500000");
                        break;
                    case "10159":
                        mapview.setImageResource(R.drawable.sc10801015910160);
                        tempraturemin.setText("17");
                        tempraturemax.setText("37");
                        Dissolvedoxygenmin.setText("4.8");
                        Dissolvedoxygenmax.setText("11");
                        pHmin.setText("7.2");
                        pHmax.setText("8.5");
                        Conductivitymin.setText("193");
                        Conductivitymax.setText("367");
                        biochemicaloxygenmin.setText("0.8");
                        biochemicaloxygenmax.setText("5.8");
                        Nitratemin.setText("0.29");
                        Nitratemax.setText("0.82");
                        FacealColiformmin.setText("1300");
                        FacealColiformmax.setText("280000");
                        TotalColiformmin.setText("23000");
                        TotalColiformmax.setText("350000");
                        break;
                    case "10160":
                        mapview.setImageResource(R.drawable.sc10801015910160);
                        tempraturemin.setText("17");
                        tempraturemax.setText("37");
                        Dissolvedoxygenmin.setText("4.8");
                        Dissolvedoxygenmax.setText("11");
                        pHmin.setText("7.5");
                        pHmax.setText("8.5");
                        Conductivitymin.setText("207");
                        Conductivitymax.setText("383");
                        biochemicaloxygenmin.setText("0.8");
                        biochemicaloxygenmax.setText("8");
                        Nitratemin.setText("0.25");
                        Nitratemax.setText("0.89");
                        FacealColiformmin.setText("8000");
                        FacealColiformmax.setText("240000");
                        TotalColiformmin.setText("26000");
                        TotalColiformmax.setText("300000");
                        break;
                    case "2511":
                        mapview.setImageResource(R.drawable.sc2511);
                        tempraturemin.setText("21");
                        tempraturemax.setText("34");
                        Dissolvedoxygenmin.setText("4");
                        Dissolvedoxygenmax.setText("9.9");
                        pHmin.setText("7.8");
                        pHmax.setText("8.6");
                        Conductivitymin.setText("155");
                        Conductivitymax.setText("379");
                        biochemicaloxygenmin.setText("1.1");
                        biochemicaloxygenmax.setText("5.9");
                        Nitratemin.setText("0.09");
                        Nitratemax.setText("0.92");
                        FacealColiformmin.setText("2000");
                        FacealColiformmax.setText("170000");
                        TotalColiformmin.setText("4000");
                        TotalColiformmax.setText("220000");
                        break;
                    case "2506":
                        mapview.setImageResource(R.drawable.sc2506);
                        tempraturemin.setText("22");
                        tempraturemax.setText("34");
                        Dissolvedoxygenmin.setText("4.6");
                        Dissolvedoxygenmax.setText("9.7");
                        pHmin.setText("7.7");
                        pHmax.setText("8.4");
                        Conductivitymin.setText("217");
                        Conductivitymax.setText("399");
                        biochemicaloxygenmin.setText("1.2");
                        biochemicaloxygenmax.setText("6.1");
                        Nitratemin.setText("0.17");
                        Nitratemax.setText("0.77");
                        FacealColiformmin.setText("1300");
                        FacealColiformmax.setText("220000");
                        TotalColiformmin.setText("8000");
                        TotalColiformmax.setText("300000");
                        break;
                    case "10161":
                        mapview.setImageResource(R.drawable.sc101611054);
                        tempraturemin.setText("21");
                        tempraturemax.setText("33");
                        Dissolvedoxygenmin.setText("3.5");
                        Dissolvedoxygenmax.setText("9.6");
                        pHmin.setText("7.4");
                        pHmax.setText("8.6");
                        Conductivitymin.setText("215");
                        Conductivitymax.setText("388");
                        biochemicaloxygenmin.setText("1.1");
                        biochemicaloxygenmax.setText("6.8");
                        Nitratemin.setText("0.15");
                        Nitratemax.setText("0.72");
                        FacealColiformmin.setText("30000");
                        FacealColiformmax.setText("1300000");
                        TotalColiformmin.setText("50000");
                        TotalColiformmax.setText("3000000");
                        break;
                    case "1054":
                        mapview.setImageResource(R.drawable.sc101611054);
                        tempraturemin.setText("21");
                        tempraturemax.setText("33");
                        Dissolvedoxygenmin.setText("4.2");
                        Dissolvedoxygenmax.setText("9.4");
                        pHmin.setText("7.4");
                        pHmax.setText("8.5");
                        Conductivitymin.setText("206");
                        Conductivitymax.setText("384");
                        biochemicaloxygenmin.setText("1.1");
                        biochemicaloxygenmax.setText("6.8");
                        Nitratemin.setText("0.09");
                        Nitratemax.setText("1.05");
                        FacealColiformmin.setText("11000");
                        FacealColiformmax.setText("220000");
                        TotalColiformmin.setText("30000");
                        TotalColiformmax.setText("900000");
                        break;
                    case "1472":
                        mapview.setImageResource(R.drawable.sc1472);
                        tempraturemin.setText("21");
                        tempraturemax.setText("32");
                        Dissolvedoxygenmin.setText("4.3");
                        Dissolvedoxygenmax.setText("11.5");
                        pHmin.setText("7");
                        pHmax.setText("8.8");
                        Conductivitymin.setText("214");
                        Conductivitymax.setText("372");
                        biochemicaloxygenmin.setText("1.1");
                        biochemicaloxygenmax.setText("6.1");
                        Nitratemin.setText("0.23");
                        Nitratemax.setText("0.85");
                        FacealColiformmin.setText("4000");
                        FacealColiformmax.setText("240000");
                        TotalColiformmin.setText("7000");
                        TotalColiformmax.setText("500000");
                        break;
                    case "1053":
                        mapview.setImageResource(R.drawable.sc1053);
                        tempraturemin.setText("20");
                        tempraturemax.setText("34");
                        Dissolvedoxygenmin.setText("4.7");
                        Dissolvedoxygenmax.setText("7.8");
                        pHmin.setText("7.1");
                        pHmax.setText("8.6");
                        Conductivitymin.setText("252");
                        Conductivitymax.setText("569");
                        biochemicaloxygenmin.setText("2.7");
                        biochemicaloxygenmax.setText("5.5");
                        Nitratemin.setText("0.14");
                        Nitratemax.setText("2.15");
                        FacealColiformmin.setText("33000");
                        FacealColiformmax.setText("900000");
                        TotalColiformmin.setText("49000");
                        TotalColiformmax.setText("1600000");
                        break;
                    case "1471":
                        mapview.setImageResource(R.drawable.sc1471);
                        tempraturemin.setText("19");
                        tempraturemax.setText("35");
                        Dissolvedoxygenmin.setText("3.7");
                        Dissolvedoxygenmax.setText("7.7");
                        pHmin.setText("7.3");
                        pHmax.setText("7.9");
                        Conductivitymin.setText("262");
                        Conductivitymax.setText("575");
                        biochemicaloxygenmin.setText("1.7");
                        biochemicaloxygenmax.setText("6.4");
                        Nitratemin.setText("0.05");
                        Nitratemax.setText("3.01");
                        FacealColiformmin.setText("26000");
                        FacealColiformmax.setText("240000");
                        TotalColiformmin.setText("80000");
                        TotalColiformmax.setText("500000");
                        break;
                    case "1470":
                        mapview.setImageResource(R.drawable.sc1470);
                        tempraturemin.setText("18");
                        tempraturemax.setText("34");
                        Dissolvedoxygenmin.setText("3.8");
                        Dissolvedoxygenmax.setText("7.9");
                        pHmin.setText("7.3");
                        pHmax.setText("9");
                        Conductivitymin.setText("252");
                        Conductivitymax.setText("522");
                        biochemicaloxygenmin.setText("1.2");
                        biochemicaloxygenmax.setText("5.3");
                        Nitratemin.setText("0.26");
                        Nitratemax.setText("2.48");
                        FacealColiformmin.setText("23000");
                        FacealColiformmax.setText("900000");
                        TotalColiformmin.setText("70000");
                        TotalColiformmax.setText("1600000");
                        break;
                    case "1052":
                        mapview.setImageResource(R.drawable.sc1052);
                        tempraturemin.setText("21");
                        tempraturemax.setText("35");
                        Dissolvedoxygenmin.setText("4");
                        Dissolvedoxygenmax.setText("7.5");
                        pHmin.setText("7.2");
                        pHmax.setText("8");
                        Conductivitymin.setText("301");
                        Conductivitymax.setText("826");
                        biochemicaloxygenmin.setText("1.4");
                        biochemicaloxygenmax.setText("5.4");
                        Nitratemin.setText("0.05");
                        Nitratemax.setText("6.32");
                        FacealColiformmin.setText("2100");
                        FacealColiformmax.setText("110000");
                        TotalColiformmin.setText("11000");
                        TotalColiformmax.setText("220000");
                        break;
                    case "1469":
                        mapview.setImageResource(R.drawable.sc1469);
                        tempraturemin.setText("19");
                        tempraturemax.setText("36");
                        Dissolvedoxygenmin.setText("4.3");
                        Dissolvedoxygenmax.setText("7.8");
                        pHmin.setText("6.8");
                        pHmax.setText("8");
                        Conductivitymin.setText("319");
                        Conductivitymax.setText("8049");
                        biochemicaloxygenmin.setText("1.2");
                        biochemicaloxygenmax.setText("4.1");
                        Nitratemin.setText("0.09");
                        Nitratemax.setText("3.81");
                        FacealColiformmin.setText("400");
                        FacealColiformmax.setText("11000");
                        TotalColiformmin.setText("1100");
                        TotalColiformmax.setText("220000");
                        break;
                    case "1335":
                        mapview.setImageResource(R.drawable.sc1335);
                        tempraturemin.setText("19");
                        tempraturemax.setText("35");
                        Dissolvedoxygenmin.setText("3.7");
                        Dissolvedoxygenmax.setText("8.3");
                        pHmin.setText("6.8");
                        pHmax.setText("8.5");
                        Conductivitymin.setText("360");
                        Conductivitymax.setText("18090");
                        biochemicaloxygenmin.setText("0.5");
                        biochemicaloxygenmax.setText("3.9");
                        Nitratemin.setText("0.07");
                        Nitratemax.setText("3.67");
                        FacealColiformmin.setText("2200");
                        FacealColiformmax.setText("33500");
                        TotalColiformmin.setText("11000");
                        TotalColiformmax.setText("90000");
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "Wrong Choice", Toast.LENGTH_LONG).show();
                        break;
                }

                float tempmax,tempmin,phma,phmi,Condmax,Condmin,Domax,Domin,biomax,nitrmax,fcmax;
                //temp
                try {
                    tempmax=Float.parseFloat(tempraturemax.getText().toString());
                }catch (Exception e)
                {
                    tempmax=20.0f;
                }
                try {
                    tempmin=Float.parseFloat(tempraturemin.getText().toString());
                }catch (Exception e)
                {
                    tempmin=20.0f;
                }
                //pH
                try {
                    phma=Float.parseFloat(pHmax.getText().toString());
                }catch (Exception e)
                {
                    phma=7f;
                }
                try {
                    phmi=Float.parseFloat(pHmin.getText().toString());
                }catch (Exception e)
                {
                    phmi=7f;
                }
                //Biochemoxygen
                try {
                    biomax=Float.parseFloat(biochemicaloxygenmax.getText().toString());
                }catch (Exception e)
                {
                    biomax=0.0f;
                }


                //Dissolved oxygen

                try {
                    Domax=Float.parseFloat(Dissolvedoxygenmax.getText().toString());
                }catch (Exception e)
                {
                    Domax=6.5f;
                }
                try {
                    Domin=Float.parseFloat(Dissolvedoxygenmin.getText().toString());
                }catch (Exception e)
                {
                    Domin=6.5f;
                }
                //Conductivity
                try {
                    Condmax=Float.parseFloat(Conductivitymax.getText().toString());
                }catch (Exception e)
                {
                    Condmax=600.0f;
                }
                try {
                    Condmin=Float.parseFloat(Conductivitymin.getText().toString());
                }catch (Exception e)
                {
                    Condmin=600.0f;
                }
                //Nitrate
                try {
                    nitrmax=Float.parseFloat(Nitratemax.getText().toString());
                }catch (Exception e)
                {
                    nitrmax=0.0f;
                }

                //FC
                try {
                    fcmax=Float.parseFloat(FacealColiformmax.getText().toString());
                }catch (Exception e)
                {
                    fcmax=10.0f;
                }


                //Drinking
                if(tempmin>=6&&tempmax<=43 && Domin>=6.5&&Domax<=10 && phmi>=6.5&&phma<=8.5 && Condmin>=200&&Condmax<=800 && biomax<=1 &&nitrmax<=10 && fcmax<=10)
                {
                    if(pref.getString("Language", "").equals("Hindi"))
                        avilableuse+= "पीने, ";
                        else
                    avilableuse+="Drinking, ";
                }
                else
                {

                    if(pref.getString("Language", "").equals("Hindi"))
                        avilablesol+= "• पीने के लिए ";
                    else
                        avilablesol+="• For Drinking ";
                    if(!(tempmin>=6&&tempmax<=43))
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilablesol+= "तापमान उपयुक्त नहीं है, ";
                        else
                        avilablesol+="The temperature is not suitable, ";}
                    if(!(Domin>=6.5&&Domax<=8))
                    {if(pref.getString("Language", "").equals("Hindi"))
                        avilablesol+= "घुलित ऑक्सीजन उपयुक्त नहीं है, ";
                        else
                            avilablesol+="The Dissolved oxygen is not suitable, ";}
                    if(!(phmi>=6.5&&phma<=8.5))
                    {if(pref.getString("Language", "").equals("Hindi"))
                        avilablesol+= "पीएच उपयुक्त नहीं है, ";
                    else
                        avilablesol+="The pH is not suitable, ";}
                    if(!(Condmin>=200&&Condmax<=800))
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilablesol+= "चालकता उपयुक्त नहीं है, ";
                        else
                        avilablesol+="The Conductivity is not suitable, ";}
                    if(!(biomax<=1))
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilablesol+= "जैव-रासायनिक ऑक्सीजन की मांग उपयुक्त नहीं है, ";
                        else
                        avilablesol+="The Bio-Chemical Oxygen Demand is not suitable, ";}
                    if(!(nitrmax<=10))
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilablesol+= "नाइट्रेट उपयुक्त नहीं है, ";
                        else
                        avilablesol+="The Nitrate is not suitable, ";}
                    if(!(fcmax<=10))
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilablesol+= "फेसियल कॉलिफॉर्म उपयुक्त नहीं है, ";
                        else
                        avilablesol+="The Faceal Coliform is not suitable, ";}


                }

                //Agriculture
                if(Domin>=5&&Domax<=10 && phmi>=5&&phma<=9 && Condmin>=500&&Condmax<=2500 && biomax<=200 && nitrmax<=50 && fcmax<=1000)
                {
                    if(pref.getString("Language", "").equals("Hindi"))
                        avilableuse+= "कृषि, ";
                    else
                    avilableuse+="Agriculture, ";
                }
                else
                {
                    if(pref.getString("Language", "").equals("Hindi"))
                        avilablesol+= "\n• कृषि के लिए ";
                    else
                    avilablesol+="\n• For Agriculture ";
                    if(!(Domin>=5&&Domax<=10))
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilablesol+= "घुलित ऑक्सीजन उपयुक्त नहीं है, ";
                        else
                        avilablesol+="The Dissolved oxygen is not suitable, ";}
                    if(!(phmi>=5&&phma<=9))
                    {if(pref.getString("Language", "").equals("Hindi"))
                        avilablesol+= "पीएच उपयुक्त नहीं है, ";
                    else
                        avilablesol+="The pH is not suitable, ";}
                    if(!(Condmin>=500&&Condmax<=2500))
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilablesol+= "चालकता उपयुक्त नहीं है, ";
                        else
                        avilablesol+="The Conductivity is not suitable, ";}
                    if(!(biomax<=200))
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilablesol+= "जैव-रासायनिक ऑक्सीजन की मांग उपयुक्त नहीं है, ";
                        else
                        avilablesol+="The Bio-Chemical Oxygen Demand is not suitable, ";}
                    if(!(nitrmax<=50))
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilablesol+= "नाइट्रेट उपयुक्त नहीं है, ";
                        else
                        avilablesol+="The Nitrate is not suitable, ";}
                    if(!(fcmax<=1000))
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilablesol+= "फेसियल कॉलिफॉर्म उपयुक्त नहीं है, ";
                        else
                        avilablesol+="The Faceal Coliform is not suitable, ";}

                }
                //Bathing
                if(tempmin>=25 && tempmax<=43 && phmi>=5.5&&phma<=7.5 && biomax<=5 && nitrmax<=35 && fcmax<=500)
                {
                    if(pref.getString("Language", "").equals("Hindi"))
                        avilableuse+= "नहाना, ";
                    else
                    avilableuse+="Bathing, ";
                }
                else
                {
                    if(pref.getString("Language", "").equals("Hindi"))
                        avilablesol+= "\n• नहाना के लिए ";
                    else
                    avilablesol+="\n• For Bathing ";

                    if(!(tempmin>=25&&tempmax<=43))
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilablesol+= "तापमान उपयुक्त नहीं है, ";
                        else
                        avilablesol+="The temperature is not suitable, ";}
                    if(!(phmi>=5.5&&phma<=7.5))
                    {if(pref.getString("Language", "").equals("Hindi"))
                        avilablesol+= "पीएच उपयुक्त नहीं है, ";
                    else
                        avilablesol+="The pH is not suitable, ";}
                    if(!(biomax<=5))
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilablesol+= "जैव-रासायनिक ऑक्सीजन की मांग उपयुक्त नहीं है, ";
                        else
                        avilablesol+="The Bio-Chemical Oxygen Demand is not suitable, ";}
                    if(!(nitrmax<=50))
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilablesol+= "नाइट्रेट उपयुक्त नहीं है, ";
                        else
                        avilablesol+="The Nitrate is not suitable, ";}
                    if(!(fcmax<=500))
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilablesol+= "फेसियल कॉलिफॉर्म उपयुक्त नहीं है, ";
                        else
                        avilablesol+="The Faceal Coliform is not suitable, ";}

                }
                //Washing
                if(tempmin>=15 && tempmax<=95 && phmi>=6.5&&phma<=8.5 && biomax<=5 && nitrmax<=35 && fcmax<=500)
                {
                    if(pref.getString("Language", "").equals("Hindi"))
                        avilableuse+= "धुलाई, ";
                    else
                    avilableuse+="Washing, ";
                }
                else
                {
                    if(pref.getString("Language", "").equals("Hindi"))
                        avilablesol+= "\n• धुलाई के लिए ";
                    else
                    avilablesol+="\n• For Washing ";

                    if(!(tempmin>=15&&tempmax<=95))
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilablesol+= "तापमान उपयुक्त नहीं है, ";
                        else
                        avilablesol+="The temperature is not suitable, ";}
                    if(!(phmi>=6.5&&phma<=8.5))
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilablesol+= "पीएच उपयुक्त नहीं है, ";
                        else
                        avilablesol+="The pH is not suitable, ";}
                    if(!(biomax<=5))
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilablesol+= "जैव-रासायनिक ऑक्सीजन की मांग उपयुक्त नहीं है, ";
                        else
                        avilablesol+="The Bio-Chemical Oxygen Demand is not suitable, ";}
                    if(!(nitrmax<=50))
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilablesol+= "नाइट्रेट उपयुक्त नहीं है, ";
                        else
                        avilablesol+="The Nitrate is not suitable, ";}
                    if(!(fcmax<=500))
                    {
                        if(pref.getString("Language", "").equals("Hindi"))
                            avilablesol+= "फेसियल कॉलिफॉर्म उपयुक्त नहीं है, ";
                        else
                        avilablesol+="The Faceal Coliform is not suitable, ";}

                }
                if(avilableuse.isEmpty())
                {
                    if(pref.getString("Language", "").equals("Hindi"))
                        avilableuse+= "कृपया किसी भी उद्देश्य के लिए पानी का उपयोग न करें ";
                    else
                    avilableuse="Please do not use the water for any purpose ";}
                else
                {
                    if(pref.getString("Language", "").equals("Hindi"))
                        avilableuse= "पानी का उपयोग "+avilableuse+"के लिए किया जा सकता है";
                    else
                        avilableuse="The water can be used for "+avilableuse;}
                avilableusetext.setText(avilableuse);
                avilablesolutiontext.setText(avilablesol);




                autoCompleteTextView.setText("");
                autoCompleteTextView.setHint(item);
                try {


                    InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

                } catch (Exception e) {
                    // TODO: handle exception
                }
                LinearLayout info=(LinearLayout) findViewById(R.id.information);
                info.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.addwaterdata:
                Intent intent = new Intent(this, io.github.pv.wqii.EnterwaterInfo.class);
                startActivity(intent);
                return true;
            case R.id.graphdata:
                Intent intent2 = new Intent(this, io.github.pv.wqii.GraphActivity.class);
                startActivity(intent2);
                return true;
            case R.id.language:
                Intent intent1 = new Intent(this, Languageselection.class);
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("Previousdata", 0);
                editor.apply();
                startActivity(intent1);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onBackPressed() {
finish();
    }





}