package com.example.nicolalisci.fetchjson;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import org.json.JSONObject;

import java.util.ArrayList;

import Models.Bisettimanale;
import Models.Stats;

import static java.lang.Float.valueOf;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //public static Button click;
    public  static TextView dataTV;
    public  static LineChart chart;
    public static LineData dataLD;
    private JSONObject object;
    private static ArrayList <Stats> statsArrayList = new ArrayList<Stats>();
    Stats stats = new Stats();
    private static ArrayList <Bisettimanale> bisettimanaleArrayList = new ArrayList<Bisettimanale>();
    Bisettimanale bisettimanale = new Bisettimanale();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stats = (Stats) getIntent().getSerializableExtra("stats");
        statsArrayList = (ArrayList<Stats>) getIntent().getSerializableExtra("statsArrayList");
        bisettimanale = (Bisettimanale) getIntent().getSerializableExtra("bisettimanale");
        bisettimanaleArrayList = (ArrayList<Bisettimanale>) getIntent().getSerializableExtra("bisettimanaleArrayList");


        //dataTV = (TextView) findViewById(R.id.fetcheddata);
        chart = (LineChart) findViewById(R.id.chart);

         Button click = findViewById(R.id.click);
         click.setOnClickListener(this);

      /*  click.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("click","click");
                //fetchData process = new fetchData();
                Legend l = chart.getLegend();
                l.setForm(Legend.LegendForm.LINE);
                //process.execute();
                setData();

            }
        });
*/





    }

    //_______________________________________________________________________________________________



     /*private ArrayList setXAxisValues(){
        ArrayList xVals = new ArrayList<>();
        xVals.add("10");
        xVals.add("20");
        xVals.add("30");
        xVals.add("30.5");
        xVals.add("40");

        return xVals;
    }
    */
     private ArrayList setYAxisValues1() {
         ArrayList yVals1 = new ArrayList<>();
         Log.d("qui", "qui");
         for (int i=0; i<bisettimanaleArrayList.size();i++)
         {
             float y= Float.parseFloat(String.valueOf(bisettimanaleArrayList.get(i).getWb_temp()));
             float x= Float.parseFloat(String.valueOf(bisettimanaleArrayList.get(i).getWb_id()));
             yVals1.add(new Entry(x,y ));
         }



         return yVals1;
     }
    private ArrayList setYAxisValues2() {
        ArrayList yVals2 = new ArrayList<>();

        for (int i = 0; i < bisettimanaleArrayList.size(); i++) {
            float y = Float.parseFloat(String.valueOf(bisettimanaleArrayList.get(i).getWb_umid()));
            float x = Float.parseFloat(String.valueOf(bisettimanaleArrayList.get(i).getWb_id()));
            yVals2.add(new Entry(x, y));
        }
        return yVals2;
    }


    public void setData() {
        //ArrayList xVals = setXAxisValues();
        Log.d("setData", "setData");
        ArrayList<Entry> yVals1 = setYAxisValues1();
        ArrayList<Entry> yVals2 = setYAxisValues2();
        LineDataSet set1;
        LineDataSet set2;

        // create a dataset and give it a type
        set1 = new LineDataSet(yVals1, "Temperatura");
        set1.setFillColor(getResources().getColor(R.color.colorTemp));
        set1.setFillAlpha(255);
        set1.setCircleColor(Color.BLACK);
        set1.setLineWidth(1f);
        set1.setCircleRadius(2f);
        set1.setDrawCircleHole(false);
        set1.setValueTextSize(9f);
        set1.setDrawFilled(true);
        set1.setColors(getResources().getColor(R.color.colorTemp));

        set2 = new LineDataSet(yVals2, "Umidità");
        set2.setFillColor(getResources().getColor(R.color.colorUmid));
        set2.setFillAlpha(200);
        set2.setCircleColor(Color.BLACK);
        set2.setLineWidth(1f);
        set2.setCircleRadius(2f);
        set2.setDrawCircleHole(false);
        set2.setValueTextSize(9f);
        set2.setDrawFilled(true);
        set2.setColors(getResources().getColor(R.color.colorUmid));

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set2);
        dataSets.add(set1);


        //LineData data = new LineData(xVals, dataSets);

        //LineDataSet set = new LineDataSet(null, null);
        dataLD = new LineData(dataSets);
        //dataLD.addDataSet(set);
        //Log.d("dataLD",dataLD);
        chart.setData(dataLD);
        chart.invalidate();

    }


    @Override
    public void onClick(View v) {
        Log.d("click","click");
        //fetchData process = new fetchData();
        Legend l = chart.getLegend();
        l.setForm(Legend.LegendForm.LINE);
        //process.execute();
        setData();

    }
}

//Log.d("bisettimanaleArrayList", String.valueOf(bisettimanaleArrayList));

      /*  for (int i=0;i<bisettimanaleArrayList.size();i++)
        {


            Log.d("name", String.valueOf(bisettimanaleArrayList.get(i).getWb_name()));
            Log.d("data", String.valueOf(bisettimanaleArrayList.get(i).getWb_data()));
            Log.d("ora", String.valueOf(bisettimanaleArrayList.get(i).getWb_ora()));
            Log.d("temp", String.valueOf(bisettimanaleArrayList.get(i).getWb_temp()));
            Log.d("umid", String.valueOf(bisettimanaleArrayList.get(i).getWb_umid()));
            Log.d("id", String.valueOf(bisettimanaleArrayList.get(i).getWb_id()));

        }

*/


/*         for (int i=0;i<statsArrayList.size();i++)
        {
            Log.d("wb_name", String.valueOf(statsArrayList.get(i).getWb_name()));
            Log.d("tMAX", String.valueOf(statsArrayList.get(i).gettMAX()));
            Log.d("tMIN", String.valueOf(statsArrayList.get(i).gettMIN()));
            Log.d("tAVG", String.valueOf(statsArrayList.get(i).gettAVG()));
            Log.d("uMAX", String.valueOf(statsArrayList.get(i).getuMAX()));
            Log.d("uMIN", String.valueOf(statsArrayList.get(i).getuMIN()));
            Log.d("uAVG", String.valueOf(statsArrayList.get(i).getuAVG()));
        }


*/





/*
        JSONObject jsonObj = null;
        try {
            jsonObj = new JSONObject(getIntent().getStringExtra("JSON"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("extras", String.valueOf(jsonObj));


        try {
            for (int i=0; i<jsonObj.length();i++)
            {
                String id = object.getString("id");
                String wb_name = object.getString("wb_name");
                String wb_data = object.getString("wb_data");
                String wb_ora = object.getString("wb_ora");
                String temperatura = object.getString("temperatura");
                String umidita = object.getString("umidita");
                String HOUR = object.getString("HOUR(ir1.wb_ora)");
                Log.d("id",id);
                Log.d("wb_name",wb_name);
                Log.d("wb_data",wb_data);
                Log.d("wb_ora",wb_ora);
                Log.d("temperatura",temperatura);
                Log.d("umidita",umidita);
                Log.d("HOUR",HOUR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


         click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("click","click");
                //fetchData process = new fetchData();
                Legend l = chart.getLegend();
                l.setForm(Legend.LegendForm.LINE);
                //process.execute();
                setData();
            }
        });
*/
