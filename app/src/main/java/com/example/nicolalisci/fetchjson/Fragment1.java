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
import java.io.Serializable;
import java.util.ArrayList;
import Models.Bisettimanale;
import Models.Stats;
import Models.Whitebox;



/**
 * Created by nicolalisci on 20/02/18.
 */

public class Fragment1 extends Fragment implements Serializable {

    public static LineChart chart;
    public static LineData dataLD;
    public static ArrayList<Whitebox> whiteboxList = new ArrayList<Whitebox>();
    public static ArrayList<Stats> statsArrayList = new ArrayList<Stats>();
    protected static ArrayList<ArrayList<Bisettimanale>> rilevazioni = new ArrayList<ArrayList<Bisettimanale>>();
    public int position, cont1 = 0, cont2 = 0, contBisettArray = 0, i = 0, ini = 0;
    private Whitebox wb;
    private Stats st;
    private Bisettimanale bs;

    public static Fragment1 newInstance() {
        Fragment1 fragment1 = new Fragment1();
        return fragment1;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle bundle = getArguments();
        //wb = (Whitebox) bundle.getSerializable("wb");
        st = (Stats) bundle.getSerializable("st");
        position=bundle.getInt("currentPosition");
        wb = (Whitebox) bundle.getSerializable("whitebox");
        statsArrayList = (ArrayList<Stats>) bundle.getSerializable("statsArrayList");
        rilevazioni = (ArrayList<ArrayList<Bisettimanale>>) bundle.getSerializable("rilevazioni");

        Log.d("rilevazioni", String.valueOf(rilevazioni));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.frag, parent, false);

        popolaLayout(rootView);

        return rootView;


    }

    public void popolaLayout(ViewGroup rootView) {

        chart = (LineChart) rootView.findViewById(R.id.chart);
        TextView Nome = (TextView) rootView.findViewById(R.id.Nome);
        TextView Descrizione = (TextView) rootView.findViewById(R.id.Descrizione);
        TextView temp = (TextView) rootView.findViewById(R.id.temp);
        TextView umid = (TextView) rootView.findViewById(R.id.umid);
        TextView MaxT = (TextView) rootView.findViewById(R.id.MaxT);
        TextView MinT = (TextView) rootView.findViewById(R.id.MinT);
        TextView AvgT = (TextView) rootView.findViewById(R.id.AvgT);
        TextView MaxU = (TextView) rootView.findViewById(R.id.MaxU);
        TextView MinU = (TextView) rootView.findViewById(R.id.MinU);
        TextView AvgU = (TextView) rootView.findViewById(R.id.AvgU);



        Nome.setText(wb.getWb_nome());
        Descrizione.setText(wb.getWb_descrizione());
        temp.setText(wb.getWb_temp() + " °C");
        umid.setText(wb.getWb_umid() + " %");

        MaxT.setText("Max: " + String.valueOf(st.gettMAX() + " °C"));
        MinT.setText("Min: " + String.valueOf(st.gettMIN() + " °C"));
        AvgT.setText("Media: " + String.valueOf(st.gettAVG()).substring(0,4) + " °C");

        MaxU.setText("Max: " + String.valueOf(st.getuMAX() + " %"));
        MinU.setText("Min: " + String.valueOf(st.getuMIN() + " %"));
        AvgU.setText("Media: " + String.valueOf(st.getuAVG()).substring(0,4) + " %");

        Legend l = chart.getLegend();
        l.setForm(Legend.LegendForm.LINE);
        setData();


    }


    private ArrayList setYAxisValues1() {
        ArrayList yVals1 = new ArrayList<>();


        for (i = ini; i < rilevazioni.get(position).size(); i++) {
            float y = Float.parseFloat(String.valueOf(rilevazioni.get(position).get(i).getWb_temp()));
            float x = Float.parseFloat(String.valueOf(rilevazioni.get(position).get(i).getWb_id()));
            yVals1.add(new Entry(x, y));
        }


        return yVals1;
    }

    private ArrayList setYAxisValues2() {
        ArrayList yVals2 = new ArrayList<>();

        for (i = ini; i < rilevazioni.get(position).size(); i++) {
            float y = Float.parseFloat(String.valueOf(rilevazioni.get(position).get(i).getWb_umid()));
            float x = Float.parseFloat(String.valueOf(rilevazioni.get(position).get(i).getWb_id()));
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
}



