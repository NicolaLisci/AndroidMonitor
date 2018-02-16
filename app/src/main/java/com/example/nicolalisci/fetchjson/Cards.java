package com.example.nicolalisci.fetchjson;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.nicolalisci.fetchjson.Whitebox;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicolalisci on 15/02/18.
 */

public class Cards extends Activity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static TextView wb_id, wb_name, wb_descrizione, wb_ip, wb_temp, wb_umid, wb_data, wb_ora;
    public static CardView cardView;
    public static ArrayList<Whitebox> whiteboxList = new ArrayList<Whitebox>();
    Whitebox w = new Whitebox();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cards);

       /* cardView =  findViewById(R.id.cardView);
        wb_name = findViewById(R.id.wb_name);
        wb_temp = findViewById(R.id.wb_temp);
        wb_umid = findViewById(R.id.wb_umid);
        wb_ora = findViewById(R.id.wb_ora);

*/



        w = (Whitebox) getIntent().getSerializableExtra("whitebox");
        whiteboxList = (ArrayList<Whitebox>) getIntent().getSerializableExtra("whiteboxList");

        RecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        RVAdapter adapter = new RVAdapter(whiteboxList);
        rv.setAdapter(adapter);


       /* for(int i=0;i<whiteboxList.size();i++)
        {

            wb_name.setText(whiteboxList.get(i).getWb_nome());
            wb_temp.setText(whiteboxList.get(i).getWb_temp()+" °C");
            wb_umid.setText(whiteboxList.get(i).getWb_umid()+" %");
            wb_ora.setText("Ultima lettura: "+whiteboxList.get(i).getWb_ora());

        */




        /*    Log.d("id", String.valueOf(whiteboxList.get(i).getWb_id()));
            Log.d("nome", String.valueOf(whiteboxList.get(i).getWb_nome()));
            Log.d("descrizione", String.valueOf(whiteboxList.get(i).getWb_descrizione()));
            Log.d("ip", String.valueOf(whiteboxList.get(i).getWb_ip()));
            Log.d("temp", String.valueOf(whiteboxList.get(i).getWb_temp()));
            Log.d("umid", String.valueOf(whiteboxList.get(i).getWb_umid()));
            Log.d("data", String.valueOf(whiteboxList.get(i).getWb_data()));
            Log.d("ora", String.valueOf(whiteboxList.get(i).getWb_ora()));
            }

         */


    }


}



    //__________________________________________________________________________________
    /*
   static class RVAdapter extends RecyclerView.Adapter<RVAdapter.CardsViewHolder> {




        public static class CardsViewHolder extends RecyclerView.ViewHolder {
            static CardView cardView;
            static TextView wb_name, wb_temp, wb_umid, wb_ora;


            CardsViewHolder(View itemView) {
                super(itemView);
                cardView = (CardView) itemView.findViewById(R.id.cardView);
                wb_name = (TextView) wb_name.findViewById(R.id.wb_name);
                wb_temp = (TextView) wb_temp.findViewById(R.id.wb_temp);
                wb_umid = (TextView) wb_umid.findViewById(R.id.wb_umid);
                wb_ora = (TextView) wb_ora.findViewById(R.id.wb_ora);


            }


        }


     RVAdapter(ArrayList<Whitebox> whiteboxList) {
           whiteboxList = whiteboxList;
        }


        @Override
        public CardsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.id.cardView, viewGroup, false);
            CardsViewHolder pvh = new CardsViewHolder(v);
            return pvh;
        }


        @Override
        public void onBindViewHolder(CardsViewHolder holder, int i) {


            for (int j = 0; j < whiteboxList.size(); j++)
            {

                CardsViewHolder.wb_name.setText(whiteboxList.get(j).getWb_nome());
                CardsViewHolder.wb_temp.setText(whiteboxList.get(j).getWb_temp() + " °C");
                CardsViewHolder.wb_umid.setText(whiteboxList.get(j).getWb_umid() + " %");
                CardsViewHolder.wb_ora.setText("Ultima lettura: " + whiteboxList.get(j).getWb_ora());


       // CardsViewHolder.wb_name.setText(whiteboxList.get(i).getWb_nome());
       // CardsViewHolder.wb_temp.setText(whiteboxList.get(i).getWb_temp());
       // CardsViewHolder.wb_umid.setText(whiteboxList.get(i).getWb_umid());
       // CardsViewHolder.wb_ora.setText(whiteboxList.get(i).getWb_ora());


            }
        }

        @Override
        public int getItemCount() {
            return whiteboxList.size();
        }

        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
        }


    }

*/











