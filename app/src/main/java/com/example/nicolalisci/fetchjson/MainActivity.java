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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.example.nicolalisci.fetchjson.fetchData.JA;


public class MainActivity extends AppCompatActivity {
    Button click;
    public  static TextView dataTV;
    public  static LineChart chart;
    public static LineData dataLD;
    private JSONObject object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click = (Button) findViewById(R.id.button);
        dataTV = (TextView) findViewById(R.id.fetcheddata);
        chart = (LineChart) findViewById(R.id.chart);


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
                fetchData process = new fetchData();
                Legend l = chart.getLegend();
                l.setForm(Legend.LegendForm.LINE);
                process.execute();
                setData();
            }
        });

    }

    //_______________________________________________________________________________________________



     /* private ArrayList setXAxisValues(){
        ArrayList xVals = new ArrayList<>();
        xVals.add("10");
        xVals.add("20");
        xVals.add("30");
        xVals.add("30.5");
        xVals.add("40");

        return xVals;
    }*/
     private ArrayList setYAxisValues() {
         ArrayList yVals = new ArrayList<>();
         //Log.d("JA", String.valueOf(JA.length()));
         yVals.add(new Entry(60, 0));
         yVals.add(new Entry(48, 1));
         yVals.add(new Entry(70.5f, 2));
         yVals.add(new Entry(100, 3));
         yVals.add(new Entry(180.9f, 4));

         return yVals;
     }



    public void setData() {
        //ArrayList xVals = setXAxisValues();
        Log.d("setData", "setData");
        ArrayList<Entry> yVals = setYAxisValues();

        LineDataSet set1;


        // create a dataset and give it a type
        set1 = new LineDataSet(yVals, "DataSet 1");
        set1.setFillAlpha(110);
        set1.setColor(Color.BLACK);
        set1.setCircleColor(Color.BLACK);
        set1.setLineWidth(1f);
        set1.setCircleRadius(3f);
        set1.setDrawCircleHole(false);
        set1.setValueTextSize(9f);
        set1.setDrawFilled(true);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);

        //LineData data = new LineData(xVals, dataSets);

        //LineDataSet set = new LineDataSet(null, null);
        dataLD = new LineData(dataSets);
        //dataLD.addDataSet(set);
        //Log.d("dataLD",dataLD);
        chart.setData(dataLD);
        chart.invalidate();

    }


}