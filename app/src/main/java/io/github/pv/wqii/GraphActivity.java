package io.github.pv.wqii;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;


public class GraphActivity extends AppCompatActivity {

    public double[] temp={0,
            17.5,
            18,
            17,
            17.5,
            18,
            18,
            20,
            18,
            23.5,
            19,
            20.5,
            19.5,
            19,
            18,
            0,
            21.25,
            21,
            22.5,
            23.5,
            21.5,
            20.5,
            24.5,
            24,
            24,
            24,
            24,
            24,
            24,
            24,
            24,
            22,
            22,
            27.4,
            27.55,
            27.7,
            27.75,
            24.25,
            24.4,
            24.25,
            25.75,
            25.75,
            26.5,
            24,
            26.25,
            26,
            27,
            26.5,
            25,
            25.5,
            26.5,
            25,
            24.5,
            26,
            25.5,
            26,
            26.5,
            26.5,
            25.5,
            26,
            25,
            25.5,
            25.5,
            26,
            25,
            25.5,
            26,
            28,
            26,
            26.5,
            25,
            26,
            25,
            26,
            25,
            23.5,
            25,
            25,
            28.5,
            31,
            29,
            29,
            27,
            27,
            27,
            27.5,
            28,
            27,
            27,
            26.5,
            27,
            27,
            26,
            28,
            27.5,
            27,
    };
    public double[] DO={9.8,
            9.6,
            9.9,
            9.7,
            9.8,
            9.6,
            9.8,
            9.7,
            10.8,
            9.5,
            10.1,
            9.5,
            9.6,
            9,
            9.3,
            8.6,
            9,
            9.4,
            8.7,
            8.75,
            8.95,
            10.1,
            8.55,
            8.5,
            8.1,
            8.35,
            8.05,
            8.05,
            7.7,
            7,
            7.6,
            8.8,
            8.95,
            9.75,
            9.2,
            9.15,
            9.35,
            8.2,
            7.55,
            7.85,
            8.6,
            7.2,
            7.9,
            7.85,
            7.15,
            8.5,
            7.3,
            7.15,
            7.4,
            7.75,
            7.75,
            8.55,
            8.45,
            8.05,
            7.65,
            7.65,
            7.05,
            7.55,
            8.25,
            8.2,
            7.8,
            7.35,
            7.6,
            7.95,
            7.8,
            7.75,
            7.15,
            7.65,
            7.85,
            7.7,
            7.8,
            7.4,
            7.8,
            8.1,
            7.35,
            7.25,
            7.8,
            7.6,
            8.2,
            8.3,
            8.4,
            8.3,
            8.05,
            7.9,
            7.9,
            6.95,
            7.15,
            6.55,
            6.8,
            7.9,
            6.25,
            5.7,
            5.85,
            5.75,
            6.05,
            6,
    };
    public double[] pH={7,
            7.85,
            7.7,
            7.75,
            7.8,
            7.75,
            7.9,
            8,
            7.8,
            8.1,
            7.75,
            7.9,
            7.95,
            7.55,
            7.85,
            7.55,
            7.25,
            7.05,
            7.2,
            7.3,
            7.35,
            7.5,
            8,
            8.15,
            8.2,
            8.35,
            8.25,
            8.25,
            8.25,
            8,
            8.1,
            8.3,
            8.2,
            8,
            8.15,
            8.1,
            7.95,
            8.3,
            8.35,
            5.35,
            8.25,
            8.3,
            8.4,
            8.15,
            8.4,
            8,
            7.85,
            8.1,
            8,
            8.15,
            7.8,
            7.7,
            7.6,
            7.95,
            7.95,
            8,
            7.9,
            8.15,
            7.9,
            7.55,
            8.05,
            7.85,
            8,
            8.7,
            8.2,
            8.1,
            7.85,
            8.15,
            8.1,
            8.05,
            8.05,
            8.3,
            7.95,
            7.8,
            7.95,
            8.1,
            8.05,
            7.95,
            8.1,
            8,
            8.15,
            8.35,
            7.95,
            7.85,
            8,
            8.2,
            8.05,
            8,
            7.95,
            7.9,
            7.85,
            7.6,
            8.15,
            7.6,
            7.4,
            7.65,
    };
    public double[] conductivity={0,
            0,
            0,
            0,
            0,
            0,
            0,
            198.5,
            119.5,
            390,
            125.5,
            354,
            138,
            202,
            143,
            157.5,
            210.5,
            209.5,
            221,
            227,
            227,
            453.5,
            221,
            275,
            283,
            276.5,
            285.5,
            284,
            299.5,
            332.5,
            305.5,
            329.5,
            331,
            207.5,
            209,
            259.5,
            261,
            410,
            430,
            424,
            438,
            460,
            447,
            310,
            461.5,
            381,
            380.5,
            390,
            438.5,
            323.5,
            377.5,
            347,
            239,
            423,
            410,
            366,
            364,
            364.5,
            352.5,
            359,
            349.5,
            359.5,
            380,
            350,
            357.5,
            344.5,
            316.5,
            345.5,
            336,
            335,
            334.5,
            375.5,
            321,
            380,
            364.5,
            372,
            325,
            331,
            310,
            316,
            315,
            316,
            289,
            280,
            295,
            267,
            308,
            301.5,
            295,
            293,
            410.5,
            418.5,
            387,
            563.5,
            4184,
            9225,
    };
    public double[] bio={1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1,
            1.1,
            1,
            1.5,
            1.1,
            1.55,
            1.85,
            1.35,
            1.95,
            1.7,
            1.75,
            1.7,
            2.15,
            2.9,
            3.5,
            3.35,
            3.25,
            3.1,
            3.55,
            4.5,
            4.1,
            3.45,
            3.4,
            2.65,
            2.95,
            2.7,
            2.35,
            2.65,
            3.6,
            3.35,
            2.5,
            3.8,
            3.4,
            3.6,
            3.8,
            2.1,
            2.1,
            2.35,
            2.1,
            1.75,
            1.7,
            1.95,
            1.95,
            1.85,
            1.65,
            2.35,
            2.3,
            2.15,
            2.05,
            1.65,
            2.05,
            2.35,
            1.75,
            1.75,
            1.7,
            1.85,
            2.1,
            1.7,
            1.8,
            2,
            1.9,
            2.05,
            1.95,
            2.05,
            1.95,
            2.3,
            1.7,
            1.9,
            2.4,
            2.4,
            2.5,
            2.5,
            2.8,
            3.3,
            4.4,
            3.5,
            3.65,
            3.95,
            3.95,
            3.6,
            4.1,
            4.05,
            3.25,
            3.4,
            2.65,
            2.2,
    };
    public double[] nitrate={0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0.575,
            0.55,
            0.47,
            0.435,
            0.515,
            0.585,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0.82,
            0.8,
            1.445,
            1.575,
            1.61,
            1.52,
            0.69,
            1.07,
            0.945,
            0.18,
            0.275,
            0.23,
            0,
            0.285,
            0.195,
            0.245,
            0.28,
            0.265,
            0.435,
            0.19,
            0.155,
            0.37,
            0.435,
            0.515,
            0.305,
            0.425,
            0.555,
            0.41,
            0.4,
            0.335,
            0.925,
            0.35,
            0.325,
            0.34,
            0.52,
            0.3,
            0.64,
            0.44,
            0.325,
            0.285,
            0.555,
            0.3,
            0.355,
            0.46,
            0.265,
            0.315,
            0.33,
            0,
            0,
            0,
            0,
            0.505,
            0.555,
            0.57,
            0.505,
            0.47,
            0.435,
            0.57,
            0.54,
            1.145,
            1.53,
            1.37,
            3.185,
            1.95,
            1.87,
    };
    public double[] facial={0.1,
            0,
            0,
            0,
            0,
            0,
            0,
            0.5,
            0.2,
            0.6,
            0.3,
            0.9,
            0.4,
            1.5,
            0.7,
            0,
            9.6,
            6.1,
            2,
            3,
            6,
            2.2,
            8.5,
            20,
            25,
            24,
            25.5,
            26.5,
            32.5,
            260,
            146.5,
            30.5,
            29,
            91.5,
            93,
            81.5,
            62.5,
            10.5,
            90,
            65,
            11,
            170,
            80,
            38.5,
            140,
            142.3,
            150.5,
            90.5,
            85.9,
            93.5,
            26,
            27,
            112.3,
            73.9,
            65.5,
            137,
            117,
            145.5,
            60.5,
            60.5,
            112,
            115.5,
            93.5,
            116.5,
            92,
            70.5,
            88.4,
            75.5,
            90.5,
            145.5,
            93.5,
            116,
            143.9,
            141,
            88.9,
            179.7,
            86,
            77,
            0,
            0,
            0,
            0,
            1535,
            1406.5,
            1240,
            860,
            1106.5,
            6650,
            1155,
            1220,
            4665,
            1330,
            4615,
            560.5,
            57,
            178.5,

    };
    public double[] totcol={0,
            0,
            0,
            0,
            0,
            0,
            0,
            0.1,
            0.2,
            0.1,
            0.1,
            0.2,
            0.1,
            0.2,
            0.1,
            0,
            2,
            1.5,
            0.4,
            0.6,
            1.1,
            0.4,
            2.2,
            4,
            4.9,
            4.6,
            4.9,
            4.1,
            5.8,
            45.5,
            30.5,
            3.6,
            3.6,
            16.7,
            19,
            17.7,
            14.5,
            2,
            17.5,
            11,
            2.3,
            30,
            12.5,
            8.8,
            26,
            81.2,
            84.2,
            22.2,
            27.8,
            51.5,
            19.2,
            15.3,
            28.5,
            15.6,
            18.8,
            23,
            49.4,
            85.5,
            14,
            16.8,
            15.7,
            47.9,
            28.6,
            30.5,
            82,
            27.7,
            24.5,
            23,
            85.5,
            87,
            50.7,
            48.1,
            82,
            81.4,
            49.4,
            85.5,
            135,
            87,
            0,
            0,
            0,
            0,
            257,
            186.5,
            163,
            112,
            154,
            1525,
            465,
            253.5,
            824.5,
            290,
            835,
            115.5,
            110.6,
            50.5,

    };
    public boolean hindi=false;
    protected Typeface tfLight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        tfLight = Typeface.createFromAsset(getAssets(), "OpenSans-Light.ttf");



        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);

        if(pref.getString("Language", "").equals("Hindi"))
        {hindi=true;
            TextView temp=(TextView) findViewById(R.id.gtemp);
            temp.setText("तापमान (डिग्री सेल्सियस)");
            TextView Dissolvedoxygen=(TextView) findViewById(R.id.gDO);
            Dissolvedoxygen.setText("घुलित ऑक्सीजन (मिलीग्राम/लीटर)");
            TextView pH=(TextView) findViewById(R.id.gph);
            pH.setText("पीएच");
            TextView Conductivity=(TextView) findViewById(R.id.gcond);
            Conductivity.setText("चालकता (उम्हो/सेमी)");
            TextView Biochemicaloxygen=(TextView) findViewById(R.id.gbio);
            Biochemicaloxygen.setText("जैव रासायनिक ऑक्सीजन मांग (मिलीग्राम/लीटर)");
            TextView Nitrate=(TextView) findViewById(R.id.gnitrate);
            Nitrate.setText("नाइट्रेट (मिलीग्राम/लीटर)");
            TextView Facelcoliform=(TextView) findViewById(R.id.gfacial);
            Facelcoliform.setText("फेसियल कॉलीफॉर्म (एमपीएन/100 मिलीलीटर) *100");
            TextView TF=(TextView) findViewById(R.id.gtotalcoliform);
            TF.setText("कुल कॉलीफॉर्म (एमपीएन/100 एमएल) *1000");
            Toast.makeText(getApplicationContext(),"95 उपलब्ध प्रविष्टियों से डेटा",Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getApplicationContext(),"Data from 95 available entries",Toast.LENGTH_SHORT).show();

        ListView lv = findViewById(R.id.listView1);

        ArrayList<BarData> list = new ArrayList<>();


        list.add(datafortemp());
        list.add(dataforDO());
        list.add(dataforpH());
        list.add(dataforConduct());
        list.add(dataforbio());
        list.add(datafornitrate());
        list.add(dataforfacialcolform());
        list.add(datafortotcoliform());
        ChartDataAdapter cda = new ChartDataAdapter(getApplicationContext(), list);
        lv.setAdapter(cda);




    }

    private BarData datafortemp() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i <=95; i++) {
            entries.add(new BarEntry(i+1, (float) temp[i]));
        }

        BarDataSet d;
        if(!hindi)
            d = new BarDataSet(entries, "TEMPERATURE (°C)");
        else
            d = new BarDataSet(entries, "तापमान (डिग्री सेल्सियस)");

        d.setBarShadowColor(Color.rgb(203, 203, 203));

        ArrayList<IBarDataSet> sets = new ArrayList<>();
        sets.add(d);

        BarData cd = new BarData(sets);
        cd.setBarWidth(0.9f);
        return cd;
    }

    private BarData dataforfacialcolform() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i <=95; i++) {
            entries.add(new BarEntry(i+1,(float) facial[i]));
        }



        BarDataSet d;
        if(!hindi)
            d = new BarDataSet(entries, "Facial Coliform (MPN/100mL)*100");
        else
            d = new BarDataSet(entries, "फेसियल कॉलीफॉर्म (एमपीएन/100एमएल)*100");
        d.setBarShadowColor(Color.rgb(203, 203, 203));
        d.setColor(Color.rgb(255, 102, 255));

        ArrayList<IBarDataSet> sets = new ArrayList<>();
        sets.add(d);

        BarData cd = new BarData(sets);
        cd.setBarWidth(0.9f);
        return cd;
    }

    private BarData dataforbio() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i <= 95; i++) {
            entries.add(new BarEntry(i+1,(float) bio[i]));
        }

        BarDataSet d;
        if(!hindi)
            d = new BarDataSet(entries, "Bio-Chemical Oxygen Demand(mg/L)");
        else
            d = new BarDataSet(entries, "जैव रासायनिक ऑक्सीजन मांग (मिलीग्राम/लीटर)");
        d.setBarShadowColor(Color.rgb(203, 203, 203));
        d.setColor(Color.rgb(240, 120, 124));

        ArrayList<IBarDataSet> sets = new ArrayList<>();
        sets.add(d);

        BarData cd = new BarData(sets);
        cd.setBarWidth(0.9f);
        return cd;
    }

    private BarData dataforConduct() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i <=95; i++) {
            entries.add(new BarEntry(i+1,(float) conductivity[i]));
        }
        BarDataSet d;
        if(!hindi)
            d = new BarDataSet(entries, "Conductivity (umho/Cm)");
        else
            d = new BarDataSet(entries, "चालकता (उम्हो/सेमी)");
        d.setBarShadowColor(Color.rgb(203, 203, 203));
        d.setColor(Color.rgb(230, 230, 25));

        ArrayList<IBarDataSet> sets = new ArrayList<>();
        sets.add(d);

        BarData cd = new BarData(sets);
        cd.setBarWidth(0.9f);
        return cd;

    }

    private BarData dataforpH() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i <= 95; i++) {
            entries.add(new BarEntry(i+1,(float) pH[i]));
        }

        BarDataSet d;
        if(!hindi)
            d = new BarDataSet(entries, "pH");
        else
            d = new BarDataSet(entries, "पीएच");
        d.setBarShadowColor(Color.rgb(203, 203, 203));
        d.setColor(Color.rgb(153, 204, 0));

        ArrayList<IBarDataSet> sets = new ArrayList<>();
        sets.add(d);

        BarData cd = new BarData(sets);
        cd.setBarWidth(0.9f);
        return cd;
    }

    private BarData dataforDO() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i <= 95; i++) {
            entries.add(new BarEntry(i+1,(float) DO[i]));
        }

        BarDataSet d;
        if(!hindi)
            d = new BarDataSet(entries, "Dissolved Oxygen (mg/L)");
        else
            d = new BarDataSet(entries, "घुलित ऑक्सीजन (मिलीग्राम/लीटर)");
        d.setBarShadowColor(Color.rgb(203, 203, 203));
        d.setColor(Color.rgb(153, 102, 255));

        ArrayList<IBarDataSet> sets = new ArrayList<>();
        sets.add(d);

        BarData cd = new BarData(sets);
        cd.setBarWidth(0.9f);
        return cd;
    }

    private BarData datafornitrate() {

        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i <= 95; i++) {
            entries.add(new BarEntry(i+1,(float) nitrate[i]));
        }

        BarDataSet d;
        if(!hindi)
            d = new BarDataSet(entries, "Nitrate (mg/L)");
        else
            d = new BarDataSet(entries, "नाइट्रेट (मिलीग्राम/लीटर)");
        d.setBarShadowColor(Color.rgb(203, 203, 203));
        d.setColor(Color.rgb(255, 102, 0));

        ArrayList<IBarDataSet> sets = new ArrayList<>();
        sets.add(d);

        BarData cd = new BarData(sets);
        cd.setBarWidth(0.9f);
        return cd;
    }
    private BarData datafortotcoliform() {

        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i <= 95; i++) {
            entries.add(new BarEntry(i+1,(float) totcol[i]));
        }

        BarDataSet d;
        if(!hindi)
            d = new BarDataSet(entries, "Total Coliform (MPN/100mL)*1000");
        else
            d = new BarDataSet(entries, "कुल कॉलीफॉर्म (एमपीएन/100एमएल)*1000");
        d.setColor(Color.rgb(242, 210, 189));
        d.setBarShadowColor(Color.rgb(203, 203, 203));

        ArrayList<IBarDataSet> sets = new ArrayList<>();
        sets.add(d);

        BarData cd = new BarData(sets);
        cd.setBarWidth(0.9f);
        return cd;
    }

    private class ChartDataAdapter extends ArrayAdapter<BarData> {

        ChartDataAdapter(Context context, List<BarData> objects) {
            super(context, 0, objects);
        }

        @SuppressLint("InflateParams")
        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {

            BarData data = getItem(position);

            ViewHolder holder;

            if (convertView == null) {

                holder = new ViewHolder();

                convertView = LayoutInflater.from(getContext()).inflate(
                        R.layout.list_item_barchart, null);
                holder.chart = convertView.findViewById(R.id.chart);

                convertView.setTag(holder);

            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            // apply styling
            if (data != null) {
                data.setValueTypeface(tfLight);
                data.setValueTextColor(Color.BLACK);
            }
            holder.chart.getDescription().setEnabled(false);
            holder.chart.setDrawGridBackground(false);

            holder.chart.setMaxVisibleValueCount(35);
            XAxis xAxis = holder.chart.getXAxis();
            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
            xAxis.setTypeface(tfLight);
            xAxis.setDrawGridLines(false);

            YAxis leftAxis = holder.chart.getAxisLeft();
            leftAxis.setTypeface(tfLight);
            leftAxis.setLabelCount(5, false);
            leftAxis.setSpaceTop(15f);

            YAxis rightAxis = holder.chart.getAxisRight();
            rightAxis.setTypeface(tfLight);
            rightAxis.setLabelCount(10, false);
            rightAxis.setSpaceTop(15f);

            holder.chart.setData(data);
            holder.chart.setFitBars(true);


            holder.chart.animateY(700);

            return convertView;
        }


        private class ViewHolder {

            BarChart chart;
        }
    }





}