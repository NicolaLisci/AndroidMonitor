package com.example.nicolalisci.fetchjson;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import java.util.ArrayList;
import Models.Bisettimanale;
import Models.Stats;
import Models.Whitebox;



/**
 * Created by nicolalisci on 20/02/18.
 */

public class Fragment1 extends Fragment {
    private String title;
    private int page;
    public  static LineChart chart;
    public static LineData dataLD;
   // public static TextView Nome, Descrizione,temp,umid,MaxT,MinT,AvgT,MaxU,MinU,AvgU;
    private static ArrayList <Whitebox> whiteboxList = new ArrayList<Whitebox>();
    Whitebox whitebox = new Whitebox();
    private static ArrayList<Stats> statsArrayList = new ArrayList<Stats>();
    Stats stats = new Stats();
    private static ArrayList <Bisettimanale> bisettimanaleArrayList = new ArrayList<Bisettimanale>();
    Bisettimanale bisettimanale = new Bisettimanale();
    private int cvID, cont1 = 0, cont2 = 0, contBisettArray=0, i=0,ini=0;

    public static Fragment1 newInstance()
    {
        Fragment1 fragment1 = new Fragment1();
        return fragment1;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        cvID=getIntent().getIntExtra("cvID",cvID);
        Log.d("cvID", String.valueOf(cvID));
        whitebox  = (Whitebox) getIntent().getSerializableExtra("whitebox");
        whiteboxList = (ArrayList<Whitebox>) getIntent().getSerializableExtra("whiteboxList");
        stats = (Stats) getIntent().getSerializableExtra("stats");
        statsArrayList = (ArrayList<Stats>) getIntent().getSerializableExtra("statsArrayList");
        bisettimanale = (Bisettimanale) getIntent().getSerializableExtra("bisettimanale");
        bisettimanaleArrayList = (ArrayList<Bisettimanale>) getIntent().getSerializableExtra("bisettimanaleArrayList");

        return inflater.inflate(R.layout.frag, parent, false);


    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {


        chart = (LineChart) view.findViewById(R.id.chart);
        TextView  Nome = (TextView) view.findViewById(R.id.Nome);
        TextView  Descrizione = (TextView) view.findViewById(R.id.Descrizione);
        TextView  temp = (TextView)  view.findViewById(R.id.temp);
        TextView  umid = (TextView)  view.findViewById(R.id.umid);
        TextView  MaxT = (TextView) view.findViewById(R.id.MaxT);
        TextView  MinT= (TextView) view.findViewById(R.id.MinT);
        TextView  AvgT= (TextView) view.findViewById(R.id.AvgT);
        TextView  MaxU= (TextView) view.findViewById(R.id.MaxU);
        TextView  MinU= (TextView) view.findViewById(R.id.MinU);
        TextView  AvgU= (TextView) view.findViewById(R.id.AvgU);


        Log.d("wbname",whiteboxList.get(cvID).getWb_id());


        for (int i=0; i<bisettimanaleArrayList.size();i++)
        {
            // Log.d("wbname",bisettimanaleArrayList.get(i).getWb_name());

            if(bisettimanaleArrayList.get(i).getWb_name().equals(String.valueOf(1)))
            {
                cont1++;
            }
            if(bisettimanaleArrayList.get(i).getWb_name().equals(String.valueOf(2)))
            //else
            {
                cont2++;
            }

        }

        if (cvID+1==2)
        {
            ini=cont1;
            cont1=ini+cont2;
            Log.d("cv2","cv2");
        }

        Nome.setText(whiteboxList.get(cvID).getWb_nome());
        Descrizione.setText(whiteboxList.get(cvID).getWb_descrizione());
        temp.setText(whiteboxList.get(cvID).getWb_temp() + " °C");
        umid.setText(whiteboxList.get(cvID).getWb_umid() + " %");
        MaxT.setText("Max: " + String.valueOf(statsArrayList.get(cvID).gettMAX()));
        MinT.setText("Min: " + String.valueOf(statsArrayList.get(cvID).gettMIN()));
        AvgT.setText("Media: " + String.valueOf(statsArrayList.get(cvID).gettAVG()));

        MaxU.setText("Max: " + String.valueOf(statsArrayList.get(cvID).getuMAX()));
        MinU.setText("Min: " + String.valueOf(statsArrayList.get(cvID).getuMIN()));
        AvgU.setText("Media: " + String.valueOf(statsArrayList.get(cvID).getuAVG()));



        Legend l = chart.getLegend();
        l.setForm(Legend.LegendForm.LINE);
        setData();


    }

    private Intent getIntent() {
        return null;
    }

    private ArrayList setYAxisValues1() {
        ArrayList yVals1 = new ArrayList<>();


        for (i=ini; i<cont1;i++)
        {
            float y= Float.parseFloat(String.valueOf(bisettimanaleArrayList.get(i).getWb_temp()));
            float x= Float.parseFloat(String.valueOf(bisettimanaleArrayList.get(i).getWb_id()));
            yVals1.add(new Entry(x,y ));
        }



        return yVals1;
    }

    private ArrayList setYAxisValues2() {
        ArrayList yVals2 = new ArrayList<>();

        for (i=ini; i<cont1; i++)
        {
            float y = Float.parseFloat(String.valueOf(bisettimanaleArrayList.get(i).getWb_umid()));
            float x = Float.parseFloat(String.valueOf(bisettimanaleArrayList.get(i).getWb_id()));
            yVals2.add(new Entry(x, y));
        }
        return yVals2;
    }


    public void setData() {

        ArrayList<Entry> yVals1 = setYAxisValues1();
        ArrayList<Entry> yVals2 = setYAxisValues2();
        LineDataSet set1;
        LineDataSet set2;


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
        set1.setDrawValues(false);
        set1.setMode(LineDataSet.Mode.CUBIC_BEZIER);

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
        set2.setDrawValues(false);
        set2.setMode(LineDataSet.Mode.CUBIC_BEZIER);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(set2);
        dataSets.add(set1);



        dataLD = new LineData(dataSets);
        chart.setDrawBorders(true);
        chart.setData(dataLD);
        chart.invalidate();

    }
    @Override
    public String toString() {
        return "Fragment1";
    }


}

