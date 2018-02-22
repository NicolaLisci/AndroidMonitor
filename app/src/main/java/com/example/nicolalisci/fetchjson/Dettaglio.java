package com.example.nicolalisci.fetchjson;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
import android.support.v4.app.Fragment;

import static com.example.nicolalisci.fetchjson.SplashActivity.bisettimanaleArrayList;
import static com.example.nicolalisci.fetchjson.SplashActivity.statsArrayList;


/**
 * Created by nicolalisci on 21/02/18.
 */

public class Dettaglio extends AppCompatActivity implements TabLayout.OnTabSelectedListener{
    public  static LineChart chart;
    public static LineData dataLD;
    public static TextView Nome, Descrizione,temp,umid,MaxT,MinT,AvgT,MaxU,MinU,AvgU;
    public static ArrayList <Whitebox> whiteboxList = new ArrayList<Whitebox>();
    public Whitebox whitebox = new Whitebox();
    public static ArrayList<Stats> statsArrayList = new ArrayList<Stats>();
    public Stats stats = new Stats();
    private static ArrayList <Bisettimanale> bisettimanaleArrayList = new ArrayList<Bisettimanale>();
    public Bisettimanale bisettimanale = new Bisettimanale();
    public int cvID, cont1 = 0, cont2 = 0, contBisettArray=0, i=0,ini=0;
    private static ViewPager vp;
    private TabLayout tab;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dettaglio);
        vp = (ViewPager) findViewById(R.id.viewpager);
        addPages(vp);

        tab = (TabLayout) findViewById(R.id.tabs);
        tab.setTabGravity(TabLayout.GRAVITY_FILL);
        tab.setupWithViewPager(vp);
        tab.addOnTabSelectedListener(this);

        cvID=getIntent().getIntExtra("cvID",cvID);
        Log.d("cvID", String.valueOf(cvID));
        whitebox  = (Whitebox) getIntent().getSerializableExtra("whitebox");
        whiteboxList = (ArrayList<Whitebox>) getIntent().getSerializableExtra("whiteboxList");
        stats = (Stats) getIntent().getSerializableExtra("stats");
        statsArrayList = (ArrayList<Stats>) getIntent().getSerializableExtra("statsArrayList");
        bisettimanale = (Bisettimanale) getIntent().getSerializableExtra("bisettimanale");
        bisettimanaleArrayList = (ArrayList<Bisettimanale>) getIntent().getSerializableExtra("bisettimanaleArrayList");



    }

        /*


       if (savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fooFragment, new Fragment()).commit();

        }



        whitebox  = (Whitebox) getIntent().getSerializableExtra("whitebox");
        whiteboxList = (ArrayList<Whitebox>) getIntent().getSerializableExtra("whiteboxList");
        stats = (Stats) getIntent().getSerializableExtra("stats");
        statsArrayList = (ArrayList<Stats>) getIntent().getSerializableExtra("statsArrayList");
        bisettimanale = (Bisettimanale) getIntent().getSerializableExtra("bisettimanale");
        bisettimanaleArrayList = (ArrayList<Bisettimanale>) getIntent().getSerializableExtra("bisettimanaleArrayList");

        cvID=getIntent().getIntExtra("cvID",cvID);
        //Log.d("cvID", String.valueOf(cvID));

        chart = (LineChart) findViewById(R.id.chart);
        Nome = (TextView) findViewById(R.id.Nome);
        Descrizione = (TextView) findViewById(R.id.Descrizione);
        temp = (TextView)  findViewById(R.id.temp);
        umid = (TextView)  findViewById(R.id.umid);
        MaxT = (TextView) findViewById(R.id.MaxT);
        MinT= (TextView) findViewById(R.id.MinT);
        AvgT= (TextView) findViewById(R.id.AvgT);
        MaxU= (TextView) findViewById(R.id.MaxU);
        MinU= (TextView) findViewById(R.id.MinU);
        AvgU= (TextView) findViewById(R.id.AvgU);

      for (int i=0;i<bisettimanaleArrayList.size();i++)
        {


            Log.d("name", String.valueOf(bisettimanaleArrayList.get(i).getWb_name()));
            Log.d("data", String.valueOf(bisettimanaleArrayList.get(i).getWb_data()));
            Log.d("ora", String.valueOf(bisettimanaleArrayList.get(i).getWb_ora()));
            Log.d("temp", String.valueOf(bisettimanaleArrayList.get(i).getWb_temp()));
            Log.d("umid", String.valueOf(bisettimanaleArrayList.get(i).getWb_umid()));
            Log.d("id", String.valueOf(bisettimanaleArrayList.get(i).getWb_id()));

        }



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
        //Log.d("wbname",whiteboxList.get(cvID).getWb_id());
        //Log.d("cvID", String.valueOf(cvID+1));
        //Log.d("cont1", String.valueOf(cont1));
       // Log.d("cont2", String.valueOf(cont2));
       // Log.d("size", String.valueOf(bisettimanaleArrayList.size()));

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


    //_______________________________________________________________________________________________


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

    */
    private void addPages(ViewPager viewPager)
    {
        PageAdapter myPageAdapter=new PageAdapter(getSupportFragmentManager());
        myPageAdapter.addPage(Fragment1.newInstance());
        myPageAdapter.addPage(Fragment2.newInstance());
        vp.setAdapter(myPageAdapter);
    }
    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
    private Context getActivity() {
        return context;
    }

    public sendData()
    {
        Intent intent = new Intent(getActivity(), Dettaglio.class);

        Bundle bundle1 = new Bundle();
        bundle1.putSerializable("statsArrayList", (Serializable) statsArrayList);
        intent.putExtras(bundle1);

        Bundle bundle2 = new Bundle();
        bundle2.putSerializable("bisettimanaleArrayList", (Serializable) bisettimanaleArrayList);
        intent.putExtras(bundle2);

        Bundle bundle3 = new Bundle();
        bundle3.putSerializable("whiteboxList", (Serializable) whiteboxList);
        intent.putExtras(bundle3);
        intent.putExtra("cvID",cvID);

        Fragment1 fragment1 = new Fragment1();
        fragment1.setArguments(bundle1);
        fragment1.setArguments(bundle2);
        fragment1.setArguments(bundle3);
        Fragment2 fragment2 = new Fragment2();
        fragment2.setArguments(bundle1);
        fragment2.setArguments(bundle2);
        fragment2.setArguments(bundle3);
    }
}