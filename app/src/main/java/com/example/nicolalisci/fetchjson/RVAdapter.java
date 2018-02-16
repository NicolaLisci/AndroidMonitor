package com.example.nicolalisci.fetchjson;

import android.annotation.SuppressLint;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nicolalisci on 16/02/18.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CardsViewHolder>{



    public static class CardsViewHolder extends RecyclerView.ViewHolder {
        static CardView cardView;
        static TextView wb_name,wb_temp,wb_umid,wb_ora;


        CardsViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView)itemView.findViewById(R.id.cardView);
            wb_name = (TextView)itemView.findViewById(R.id.wb_name);
            wb_temp = (TextView) itemView.findViewById(R.id.wb_temp);
            wb_umid = (TextView) itemView.findViewById(R.id.wb_umid);
            wb_ora = (TextView) itemView.findViewById(R.id.wb_ora);



        }


    }


    ArrayList<Whitebox> whiteboxList;

    RVAdapter(ArrayList<Whitebox> whiteboxList)
    {
        this.whiteboxList = whiteboxList;
    }


   @Override
    public CardsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
       View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cards,viewGroup,false);
       CardsViewHolder pvh = new CardsViewHolder(v);
       return pvh;
   }



    @Override
    public void onBindViewHolder(CardsViewHolder holder, int i) {


        for (int j = 0; j < whiteboxList.size(); j++) {

            CardsViewHolder.wb_name.setText(whiteboxList.get(j).getWb_nome());
            CardsViewHolder.wb_temp.setText(whiteboxList.get(j).getWb_temp() + " °C");
            CardsViewHolder.wb_umid.setText(whiteboxList.get(j).getWb_umid() + " %");
            CardsViewHolder.wb_ora.setText("Ultima lettura: " + whiteboxList.get(j).getWb_ora());

            Log.d("id", String.valueOf(whiteboxList.get(j).getWb_id()));
            Log.d("nome", String.valueOf(whiteboxList.get(j).getWb_nome()));
            Log.d("descrizione", String.valueOf(whiteboxList.get(j).getWb_descrizione()));
            Log.d("ip", String.valueOf(whiteboxList.get(j).getWb_ip()));
            Log.d("temp", String.valueOf(whiteboxList.get(j).getWb_temp()));
            Log.d("umid", String.valueOf(whiteboxList.get(j).getWb_umid()));
            Log.d("data", String.valueOf(whiteboxList.get(j).getWb_data()));
            Log.d("ora", String.valueOf(whiteboxList.get(j).getWb_ora()));
        /*
        CardsViewHolder.wb_name.setText(whiteboxList.get(i).getWb_nome());
        CardsViewHolder.wb_temp.setText(whiteboxList.get(i).getWb_temp());
        CardsViewHolder.wb_umid.setText(whiteboxList.get(i).getWb_umid());
        CardsViewHolder.wb_ora.setText(whiteboxList.get(i).getWb_ora());
        */
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


